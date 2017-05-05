package doc;

import java.awt.Toolkit;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import experi.dao.DoctorDao;
import experi.entity.Doctor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;

public class DocSignIn {

	protected Shell shell;
	protected Display display;
	public Text text_Mobile;
	private Text text_Password;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DocSignIn window = new DocSignIn();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shell.setSize(800, 600);
		shell.setText("\u767B\u5F55-\u533B\u751F");
		
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int x = (screenWidth - 800) / 2;
		int y = (screenHeight - 600) / 2;
		shell.setLocation(x, y);
		
		Label lbl_Mobile = new Label(shell, SWT.NONE);
		lbl_Mobile.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lbl_Mobile.setBounds(242, 201, 90, 24);
		lbl_Mobile.setText("\u624B\u673A\u53F7");
		
		Label lbl_Password = new Label(shell, SWT.NONE);
		lbl_Password.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lbl_Password.setBounds(242, 272, 90, 24);
		lbl_Password.setText("\u5BC6\u7801");
		
		text_Mobile = new Text(shell, SWT.BORDER);
		text_Mobile.setBounds(380, 201, 175, 30);
		
		text_Password = new Text(shell, SWT.BORDER);
		text_Password.setBounds(380, 266, 175, 30);
		text_Password.setEchoChar('*');
		
		Button btnOk = new Button(shell, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DoctorDao dao = new DoctorDao();
				Doctor doctor = dao.findByMobile(text_Mobile.getText().trim());
				if(doctor == null) {
					MessageBox box = new MessageBox(shell);
					box.setMessage("该手机号未注册");
					box.open();
					return;
				}//To deal with the error:java.lang.NullPointerException.
				
				if(doctor.getPassword().equals(text_Password.getText().trim())) {
					display.close();
					//doc.DocMain.main(null);
					DocMain main = new DocMain(doctor.getDoctor_name());
					//Here pass the information-- doctor's name to the new window
					main.open();
				}
				else {
					MessageBox box = new MessageBox(shell);
					box.setMessage("密码错误");
					box.open();
					return;
				}
				
			}
		});
		btnOk.setBounds(257, 348, 114, 34);
		btnOk.setText("\u786E\u8BA4");
		
		Button btnBack = new Button(shell, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				display.close();
				ui.Login.main(null);
			}
		});
		btnBack.setText("\u8FD4\u56DE");
		btnBack.setBounds(439, 348, 114, 34);

	}

}
