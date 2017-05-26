package pat;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import experi.dao.PatientDao;
import experi.entity.Patient;

import java.awt.Toolkit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class PatSignUp {

	protected Shell shlSignUppatient;
	protected Display display;
	private Text text_Name;
	private Text text_Mobile;
	private Label lbl_Password;
	private Text text_Password;
	private Label lbl_Confirm;
	private Text text_Confirm;
	private Button button;
	public String PAT_ID;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PatSignUp window = new PatSignUp();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		display = Display.getDefault();
		createContents();
		shlSignUppatient.open();
		shlSignUppatient.layout();
		while (!shlSignUppatient.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlSignUppatient = new Shell();
		shlSignUppatient.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shlSignUppatient.setSize(800, 600);
		shlSignUppatient.setText("\u6CE8\u518C-\u60A3\u8005");
		
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int x = (screenWidth - 800) / 2;
		int y = (screenHeight - 600) / 2;
		shlSignUppatient.setLocation(x, y);
		
		text_Name = new Text(shlSignUppatient, SWT.BORDER);
		text_Name.setBounds(314, 100, 248, 30);
		
		Label lbl_Name = new Label(shlSignUppatient, SWT.NONE);
		lbl_Name.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lbl_Name.setBounds(218, 100, 90, 24);
		lbl_Name.setText("\u59D3\u540D\uFF1A");
		
		Label lbl_Mobile = new Label(shlSignUppatient, SWT.NONE);
		lbl_Mobile.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lbl_Mobile.setBounds(218, 160, 90, 24);
		lbl_Mobile.setText("\u624B\u673A\u53F7\uFF1A");
		
		text_Mobile = new Text(shlSignUppatient, SWT.BORDER);
		text_Mobile.setBounds(314, 160, 248, 30);
		
		lbl_Password = new Label(shlSignUppatient, SWT.NONE);
		lbl_Password.setText("\u5BC6\u7801\uFF1A");
		lbl_Password.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lbl_Password.setBounds(218, 220, 90, 24);
		
		text_Password = new Text(shlSignUppatient, SWT.BORDER);
		text_Password.setBounds(314, 220, 248, 30);
		text_Password.setEchoChar('*');
		
		lbl_Confirm = new Label(shlSignUppatient, SWT.NONE);
		lbl_Confirm.setText("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lbl_Confirm.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lbl_Confirm.setBounds(218, 280, 90, 24);
		
		text_Confirm = new Text(shlSignUppatient, SWT.BORDER);
		text_Confirm.setBounds(314, 280, 248, 30);
		text_Confirm.setEchoChar('*');
		
		Button btnBack = new Button(shlSignUppatient, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				display.close();
				ui.Login.main(null);
			}
		});
		btnBack.setText("\u8FD4\u56DE");
		btnBack.setBounds(448, 376, 114, 34);
		
		button = new Button(shlSignUppatient, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(text_Password.getText().equals(text_Confirm.getText()) && checkPhoneNumber(text_Mobile.getText())) {
					PatientDao patientDao = new PatientDao();
					Patient checkIfExist = patientDao.findByMobile(text_Mobile.getText().trim());
					if(checkIfExist == null) {
						Patient patient = new Patient(null, text_Name.getText(), text_Password.getText(), text_Mobile.getText());
						//PatientDao dao = new PatientDao();
						try {
							//dao.insertPatient(patient);
							//MessageBox messageBox= new MessageBox(shlSignUppatient);
							//messageBox.setMessage("\u6ce8\u518c\u6210\u529f");
							//messageBox.open();
							display.close();
							//PatSelfInfo.main(null);
							//PatSelfInfo patSelfInfo = new PatSelfInfo(patient.getPat_mobile());
							PatSelfInfo patSelfInfo = new PatSelfInfo(patient.getPat_name(), patient.getPat_mobile(), patient.getPassword()); 
							patSelfInfo.open();
						}catch (Exception ex) {
							// TODO: handle exception
							ex.printStackTrace();
						}
					}
					else {
						MessageBox messageBox = new MessageBox(shlSignUppatient);
						messageBox.setMessage("该手机号已注册！");
						messageBox.open();
					}
				}
				else if (!text_Password.getText().equals(text_Confirm.getText())){
					MessageBox messageBox = new MessageBox(shlSignUppatient);
					messageBox.setMessage("两次密码不一致");
					messageBox.open();
				}
				else if(text_Name.getText().isEmpty()) {
					MessageBox messageBox = new MessageBox(shlSignUppatient);
					messageBox.setMessage("姓名不能为空");
					messageBox.open();
				}
				else {
					MessageBox messageBox = new MessageBox(shlSignUppatient);
					messageBox.setMessage("无效的手机号码");
					messageBox.open();
				}
			}
		});
		button.setBounds(218, 376, 114, 34);
		button.setText("\u786E\u8BA4");

	}
	
	private boolean checkPhoneNumber(String mobile) {
		int n = mobile.length();
		if(n != 11) {
			return false;
		}
		if(mobile.charAt(0) != '1') {
			return false;
		}
		for(int i = 0; i < n; ++i) {
			if(!Character.isDigit(mobile.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
