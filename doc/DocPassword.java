package doc;

import java.awt.Toolkit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import experi.dao.DoctorDao;
import experi.entity.Doctor;
//import pat.PatMain;

public class DocPassword {

	protected Shell shell;
	protected Display display;
	protected String doc_id;
	private Text textOrigin;
	private Text textNew;
	private Text textConfirm;
	private Button btnOK;
	private Button btnBack;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DocPassword window = new DocPassword();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DocPassword() {
		
	}
	
	public DocPassword(String doc_id) {
		this.doc_id = doc_id;
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
		DoctorDao doctorDao = new DoctorDao();
		Doctor doctor =doctorDao.findById(doc_id);
		
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shell.setSize(800, 600);
		shell.setText("\u4FEE\u6539\u5BC6\u7801");
		
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int x = (screenWidth - 800) / 2;
		int y = (screenHeight - 600) / 2;
		shell.setLocation(x, y);
		
		Label lblOrigin = new Label(shell, SWT.NONE);
		lblOrigin.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblOrigin.setBounds(230, 140, 90, 24);
		lblOrigin.setText("\u539F\u5BC6\u7801");
		
		Label lblNew = new Label(shell, SWT.NONE);
		lblNew.setText("\u65B0\u5BC6\u7801");
		lblNew.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblNew.setBounds(230, 220, 90, 24);
		
		Label lblConfirm = new Label(shell, SWT.NONE);
		lblConfirm.setText("\u786E\u8BA4\u5BC6\u7801");
		lblConfirm.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblConfirm.setBounds(230, 300, 90, 24);
		
		textOrigin = new Text(shell, SWT.BORDER);
		textOrigin.setBounds(373, 140, 160, 30);
		textOrigin.setEchoChar('*');
		
		textNew = new Text(shell, SWT.BORDER);
		textNew.setBounds(373, 220, 160, 30);
		textNew.setEchoChar('*');
		
		textConfirm = new Text(shell, SWT.BORDER);
		textConfirm.setBounds(373, 300, 160, 30);
		textConfirm.setEchoChar('*');
		
		btnOK = new Button(shell, SWT.NONE);
		btnOK.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(doctor.getPassword().equals(textOrigin.getText().trim()) && textNew.getText().equals(textConfirm.getText())) {
					doctor.setPassword(textNew.getText());
					doctorDao.changeDoctorPassword(doctor);
					MessageBox messageBox = new MessageBox(shell);
					messageBox.setMessage("修改成功");
					messageBox.open();
					display.close();
					DocMain docMain = new DocMain(doctor.getDoctor_mobile());
					docMain.open();
				}
				else if(!doctor.getPassword().equals(textOrigin.getText().trim())) {
					MessageBox messageBox = new MessageBox(shell);
					messageBox.setMessage("原密码错误");
					messageBox.open();
				}
				else {
					MessageBox messageBox = new MessageBox(shell);
					messageBox.setMessage("两次密码不一致");
					messageBox.open();
				}
			}
		});
		btnOK.setBounds(241, 399, 96, 34);
		btnOK.setText("\u786E\u8BA4");
		
		btnBack = new Button(shell, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				display.close();
				//PatMain.main(null);
				DocMain docMain = new DocMain(doctor.getDoctor_mobile());
				docMain.open();
			}
		});
		btnBack.setText("\u8FD4\u56DE");
		btnBack.setBounds(427, 399, 96, 34);


	}

}
