package pat;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.awt.Toolkit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import experi.dao.PatientDao;
import experi.entity.Patient;

public class PatSignIn {

	protected Shell shell;
	protected Display display;
	private Text text_Mobile;
	private Text text_Password;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PatSignIn window = new PatSignIn();
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
		shell.setText("\u767B\u5F55-\u60A3\u8005");
		
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
				PatientDao patientDao = new PatientDao();
				Patient patient = patientDao.findByMobile(text_Mobile.getText().trim());
				if(patient == null) {
					MessageBox box = new MessageBox(shell);
					box.setMessage("¸ÃÊÖ»úºÅÎ´×¢²á");
					box.open();
					return;
				}//To deal with the error:java.lang.NullPointerException.
				if (patient.getPassword().equals(text_Password.getText().trim())) {
					display.close();
					pat.PatMain.main(null);
				}
				else {
					MessageBox box = new MessageBox(shell);
					box.setMessage("ÃÜÂë´íÎó");
					box.open();
					return;
				}
			}
		});
		btnOk.setBounds(276, 348, 114, 34);
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
