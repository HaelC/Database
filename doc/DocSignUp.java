package doc;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import experi.dao.DoctorDao;
import experi.entity.Doctor;

import java.awt.Toolkit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class DocSignUp {

	protected Shell shlSignUpdoctor;
	protected Display display;
	private Text text_Name;
	private Text text_Mobile;
	private Label lbl_Password;
	private Text text_Password;
	private Label lbl_Confirm;
	private Text text_Confirm;
	private Label lbl_Worktime;
	private Button btn_Mon;
	private Button btn_Tue;
	private Button btn_Wed;
	private Button btn_Thu;
	private Button btn_Fri;
	private Button btn_Sat;
	private Button btn_Sun;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DocSignUp window = new DocSignUp();
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
		shlSignUpdoctor.open();
		shlSignUpdoctor.layout();
		while (!shlSignUpdoctor.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlSignUpdoctor = new Shell();
		shlSignUpdoctor.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shlSignUpdoctor.setSize(800, 600);
		shlSignUpdoctor.setText("\u6CE8\u518C-\u533B\u751F");
		
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int x = (screenWidth - 800) / 2;
		int y = (screenHeight - 600) / 2;
		shlSignUpdoctor.setLocation(x, y);
		
		text_Name = new Text(shlSignUpdoctor, SWT.BORDER);
		text_Name.setBounds(230, 81, 248, 30);
		
		Label lbl_Name = new Label(shlSignUpdoctor, SWT.NONE);
		lbl_Name.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lbl_Name.setBounds(128, 81, 90, 24);
		lbl_Name.setText("\u59D3\u540D\uFF1A");
		
		Label lbl_Mobile = new Label(shlSignUpdoctor, SWT.NONE);
		lbl_Mobile.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lbl_Mobile.setBounds(128, 144, 90, 24);
		lbl_Mobile.setText("\u624B\u673A\u53F7\uFF1A");
		
		text_Mobile = new Text(shlSignUpdoctor, SWT.BORDER);
		text_Mobile.setBounds(230, 144, 248, 30);
		
		lbl_Password = new Label(shlSignUpdoctor, SWT.NONE);
		lbl_Password.setText("\u5BC6\u7801\uFF1A");
		lbl_Password.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lbl_Password.setBounds(128, 206, 90, 24);
		
		text_Password = new Text(shlSignUpdoctor, SWT.BORDER);
		text_Password.setBounds(230, 206, 248, 30);
		text_Password.setEchoChar('*');
		
		lbl_Confirm = new Label(shlSignUpdoctor, SWT.NONE);
		lbl_Confirm.setText("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lbl_Confirm.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lbl_Confirm.setBounds(128, 272, 90, 24);
		
		text_Confirm = new Text(shlSignUpdoctor, SWT.BORDER);
		text_Confirm.setBounds(230, 272, 248, 30);
		text_Confirm.setEchoChar('*');
		
		lbl_Worktime = new Label(shlSignUpdoctor, SWT.NONE);
		lbl_Worktime.setText("\u5DE5\u4F5C\u65F6\u95F4\uFF1A");
		lbl_Worktime.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lbl_Worktime.setBounds(128, 339, 90, 24);
		
		btn_Mon = new Button(shlSignUpdoctor, SWT.CHECK);
		btn_Mon.setBounds(232, 339, 143, 24);
		btn_Mon.setText("\u5468\u4E00");
		btn_Mon.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		
		btn_Tue = new Button(shlSignUpdoctor, SWT.CHECK);
		btn_Tue.setText("\u5468\u4E8C");
		btn_Tue.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		btn_Tue.setBounds(378, 339, 143, 24);
		
		btn_Wed = new Button(shlSignUpdoctor, SWT.CHECK);
		btn_Wed.setText("\u5468\u4E09");
		btn_Wed.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		btn_Wed.setBounds(527, 339, 143, 24);
		
		btn_Thu = new Button(shlSignUpdoctor, SWT.CHECK);
		btn_Thu.setText("\u5468\u56DB");
		btn_Thu.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		btn_Thu.setBounds(128, 395, 83, 24);
		
		btn_Fri = new Button(shlSignUpdoctor, SWT.CHECK);
		btn_Fri.setText("\u5468\u4E94");
		btn_Fri.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		btn_Fri.setBounds(232, 395, 143, 24);
		
		btn_Sat = new Button(shlSignUpdoctor, SWT.CHECK);
		btn_Sat.setText("\u5468\u516D");
		btn_Sat.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		btn_Sat.setBounds(378, 395, 143, 24);
		
		btn_Sun = new Button(shlSignUpdoctor, SWT.CHECK);
		btn_Sun.setText("\u5468\u65E5");
		btn_Sun.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		btn_Sun.setBounds(527, 395, 143, 24);
		
		Button btnSubmit = new Button(shlSignUpdoctor, SWT.NONE);
		btnSubmit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (text_Password.getText().equals(text_Confirm.getText()) && (checkPhoneNumber(text_Mobile.getText()) && (!text_Name.getText().isEmpty()))) {
					Doctor doctor = new Doctor("1234", text_Name.getText(), text_Mobile.getText(), text_Password.getText(), btn_Mon.getSelection(), btn_Tue.getSelection(), btn_Wed.getSelection(), btn_Thu.getSelection(), btn_Fri.getSelection(), btn_Sat.getSelection(), btn_Sun.getSelection());
					DoctorDao dao = new DoctorDao();
					try {
						dao.insertDoctor(doctor);
						MessageBox messageBox = new MessageBox(shlSignUpdoctor);
						messageBox.setMessage("\u6ce8\u518c\u6210\u529f");
						messageBox.open();
						display.close();
						DocMain.main(null);
					}catch(Exception ex) {
						ex.printStackTrace();
					}
				}
				else if (!text_Password.getText().equals(text_Confirm.getText())){
					MessageBox messageBox = new MessageBox(shlSignUpdoctor);
					messageBox.setMessage("两次密码不一致");
					messageBox.open();
				}
				else if(text_Name.getText().isEmpty()) {
					MessageBox messageBox = new MessageBox(shlSignUpdoctor);
					messageBox.setMessage("姓名不能为空");
					messageBox.open();
				}
				else {
					MessageBox messageBox = new MessageBox(shlSignUpdoctor);
					messageBox.setMessage("无效的手机号码");
					messageBox.open();
				}
			}
		});
		btnSubmit.setBounds(230, 458, 114, 34);
		btnSubmit.setText("\u786E\u8BA4");
		
		Button btnBack = new Button(shlSignUpdoctor, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				display.close();
				ui.Login.main(null);
			}
		});
		btnBack.setText("\u8FD4\u56DE");
		btnBack.setBounds(407, 458, 114, 34);

	}
	
	/*
	 * Roughly this method can check whether the mobile phone number is valid:
	 * Check whether its length is 11;
	 * check whether its first digit is 1
	 * check whether it is made of digits.
	 */
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
