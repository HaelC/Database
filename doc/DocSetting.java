package doc;

import java.awt.Toolkit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import experi.dao.DoctorDao;
import experi.entity.Doctor;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class DocSetting {

	protected Shell shell;
	protected Display display;
	protected String doc_id;
	private Text textName;
	private Text textMobile;
	private Text textPhone;
	private Text textQQ;
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
			DocSetting window = new DocSetting();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DocSetting() {
		
	}
	
	public DocSetting(String doc_id) {
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
		Doctor doctor = doctorDao.findByIdComplete(doc_id);
		
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shell.setSize(800, 600);
		shell.setText("\u4E2A\u4EBA\u4FE1\u606F");
		
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int x = (screenWidth - 800) / 2;
		int y = (screenHeight - 600) / 2;
		shell.setLocation(x, y);
		
		Label lblName = new Label(shell, SWT.NONE);
		lblName.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblName.setBounds(197, 72, 55, 24);
		lblName.setText("\u59D3   \u540D");
		
		textName = new Text(shell, SWT.BORDER);
		textName.setBounds(258, 69, 99, 30);
		textName.setText(doctor.getDoctor_name());
		
		Label lblMobile = new Label(shell, SWT.NONE);
		lblMobile.setText("\u624B   \u673A");
		lblMobile.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblMobile.setBounds(417, 72, 55, 24);
		
		textMobile = new Text(shell, SWT.BORDER);
		textMobile.setEditable(false);
		textMobile.setBounds(478, 69, 134, 30);
		textMobile.setText(doctor.getDoctor_mobile());
		
		Label lblPhone = new Label(shell, SWT.NONE);
		lblPhone.setText("\u56FA   \u8BDD");
		lblPhone.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblPhone.setBounds(197, 145, 55, 24);
		
		textPhone = new Text(shell, SWT.BORDER);
		textPhone.setBounds(258, 145, 99, 30);
		if(doctor.getDoc_phone() != null) {
			textPhone.setText(doctor.getDoc_phone());
		}
		
		Label lblQQ = new Label(shell, SWT.NONE);
		lblQQ.setText("Q   Q");
		lblQQ.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblQQ.setBounds(417, 145, 55, 24);
		
		textQQ = new Text(shell, SWT.BORDER);
		textQQ.setBounds(478, 145, 134, 30);
		if(doctor.getDoc_QQ() != null) {
			textQQ.setText(doctor.getDoc_QQ());
		}
		
		btn_Mon = new Button(shell, SWT.CHECK);
		btn_Mon.setBounds(291, 232, 99, 24);
		btn_Mon.setText("\u5468\u4E00");
		btn_Mon.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		if(doctor.getWorkOnMon()) {
			btn_Mon.setSelection(true);
		}
		
		btn_Tue = new Button(shell, SWT.CHECK);
		btn_Tue.setText("\u5468\u4E8C");
		btn_Tue.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		btn_Tue.setBounds(434, 232, 99, 24);
		if(doctor.getWorkOnTue()) {
			btn_Tue.setSelection(true);
		}
		
		btn_Wed = new Button(shell, SWT.CHECK);
		btn_Wed.setText("\u5468\u4E09");
		btn_Wed.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		btn_Wed.setBounds(291, 282, 83, 24);
		if(doctor.getWorkOnWed()) {
			btn_Wed.setSelection(true);
		}
		
		btn_Thu = new Button(shell, SWT.CHECK);
		btn_Thu.setText("\u5468\u56DB");
		btn_Thu.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		btn_Thu.setBounds(434, 282, 83, 24);
		if(doctor.getWorkOnThu()) {
			btn_Thu.setSelection(true);
		}
		
		btn_Fri = new Button(shell, SWT.CHECK);
		btn_Fri.setText("\u5468\u4E94");
		btn_Fri.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		btn_Fri.setBounds(291, 337, 83, 24);
		if(doctor.getWorkOnFri()) {
			btn_Fri.setSelection(true);
		}
		
		btn_Sat = new Button(shell, SWT.CHECK);
		btn_Sat.setText("\u5468\u516D");
		btn_Sat.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		btn_Sat.setBounds(434, 337, 83, 24);
		if(doctor.getWorkOnSat()) {
			btn_Sat.setSelection(true);
		}
		
		btn_Sun = new Button(shell, SWT.CHECK);
		btn_Sun.setText("\u5468\u65E5");
		btn_Sun.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		btn_Sun.setBounds(291, 392, 143, 24);
		if(doctor.getWorkOnSun()) {
			btn_Sun.setSelection(true);
		}
		
		Label lblWorkday = new Label(shell, SWT.NONE);
		lblWorkday.setText("\u5DE5\u4F5C\u65F6\u95F4");
		lblWorkday.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblWorkday.setBounds(197, 232, 88, 24);
		
		Button btnOk = new Button(shell, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				doctor.setDoctor_name(textName.getText());
				doctor.setDoc_phone(textPhone.getText());
				doctor.setDoc_QQ(textQQ.getText());
				doctor.setWorkOnMon(btn_Mon.getSelection());
				doctor.setWorkOnTue(btn_Tue.getSelection());
				doctor.setWorkOnWed(btn_Wed.getSelection());
				doctor.setWorkOnThu(btn_Thu.getSelection());
				doctor.setWorkOnFri(btn_Fri.getSelection());
				doctor.setWorkOnSat(btn_Sat.getSelection());
				doctor.setWorkOnSun(btn_Sun.getSelection());
				doctorDao.setDocInfo(doctor);
				MessageBox messageBox = new MessageBox(shell);
				messageBox.setMessage("提交成功");
				messageBox.open();
				display.close();
				DocMain docMain = new DocMain(doctor.getDoctor_mobile());
				docMain.open();
			}
		});
		btnOk.setBounds(274, 444, 83, 34);
		btnOk.setText("\u63D0    \u4EA4");
		
		Button btnBack = new Button(shell, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				display.close();
				DocMain docMain = new DocMain(doctor.getDoctor_mobile());
				docMain.open();
			}
		});
		btnBack.setText("\u8FD4    \u56DE");
		btnBack.setBounds(434, 444, 83, 34);

	}
}
