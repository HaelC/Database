package pat;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import experi.dao.DoctorDao;
import experi.dao.PatientDao;
import experi.entity.Doctor;
import experi.entity.Patient;

import java.awt.Toolkit;

import org.eclipse.swt.SWT;
//import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
//import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;

public class DocList {

	protected Shell shell;
	protected Display display;
	private Text text_toFind;
	protected String pat_id;
	//protected Doctor doctor;
	private int page = 1;
	
	protected DoctorDao doctorDao;
	protected Doctor doctor;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DocList window = new DocList();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DocList() {
		
	}
	
	public DocList(String pat_id) {
		this.pat_id = pat_id;
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
		PatientDao dao = new PatientDao();
		Patient patient = dao.findById(pat_id);
		
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shell.setSize(800, 600);
		shell.setText("\u533B\u751F\u4E00\u89C8");
		
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int x = (screenWidth - 800) / 2;
		int y = (screenHeight - 600) / 2;
		shell.setLocation(x, y);
		
		Label lblDoc = new Label(shell, SWT.NONE);
		lblDoc.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblDoc.setBounds(65, 53, 245, 24);
		lblDoc.setText("\u67E5\u627E\u533B\u751F\uFF08\u8BF7\u8F93\u5165\u533B\u751F\u59D3\u540D\uFF09");
		
		text_toFind = new Text(shell, SWT.BORDER);
		text_toFind.setBounds(328, 50, 108, 30);
		
		Label lblName = new Label(shell, SWT.NONE);
		lblName.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblName.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblName.setBounds(312, 152, 149, 34);
		lblName.setVisible(false);
		
		Label lblMobile = new Label(shell, SWT.NONE);
		lblMobile.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblMobile.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblMobile.setBounds(312, 260, 160, 34);
		lblMobile.setVisible(false);
		
		Label lblNotFound = new Label(shell, SWT.NONE);
		lblNotFound.setText("\u672A\u627E\u5230\u5BF9\u5E94\u533B\u751F");
		lblNotFound.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblNotFound.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNotFound.setBounds(307, 253, 194, 34);
		lblNotFound.setVisible(false);
		
		Button btnFind = new Button(shell, SWT.NONE);
		btnFind.addSelectionListener(new SelectionAdapter() {
			
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//PatientDao patientDao = new PatientDao();
				//Doctor doctor = patientDao.findDoc(patient);
				doctorDao = new DoctorDao();
				doctor = doctorDao.findByName(text_toFind.getText());
				if (doctor == null) {
					lblNotFound.setVisible(true);
					lblName.setVisible(false);
					lblMobile.setVisible(false);
				}
				else {
					lblNotFound.setVisible(false);
					lblName.setText(doctor.getDoctor_name());
					lblName.setVisible(true);
					lblMobile.setText(doctor.getDoctor_mobile());
					lblMobile.setVisible(true);
				}
			}
			
		});
		btnFind.setBounds(494, 48, 114, 34);
		btnFind.setText("\u67E5\u627E");
		
		Label lblPage = new Label(shell, SWT.NONE);
		lblPage.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblPage.setText(Integer.toString(page));
		lblPage.setBounds(380, 398, 33, 24);
		
		Button btnPre = new Button(shell, SWT.NONE);
		btnPre.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (page > 1) {
					page--;
					//DoctorDao doctorDao = new DoctorDao();
					doctor = doctorDao.findByNameAndIndex(text_toFind.getText(), page);
					if (doctor == null) {
						lblNotFound.setVisible(true);
						lblName.setVisible(false);
						lblMobile.setVisible(false);
					}
					else {
						lblNotFound.setVisible(false);
						lblName.setText(doctor.getDoctor_name());
						lblName.setVisible(true);
						lblMobile.setText(doctor.getDoctor_mobile());
						lblMobile.setVisible(true);
					}
					lblPage.setText(Integer.toString(page));
				}
			}
		});
		btnPre.setBounds(320, 398, 33, 24);
		btnPre.setText("<");
		
		Button btnNext = new Button(shell, SWT.NONE);
		btnNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				page++;
				//DoctorDao doctorDao = new DoctorDao();
				doctor = doctorDao.findByNameAndIndex(text_toFind.getText(), page);
				if (doctor == null) {
					lblNotFound.setVisible(true);
					lblName.setVisible(false);
					lblMobile.setVisible(false);
				}
				else {
					lblNotFound.setVisible(false);
					lblName.setText(doctor.getDoctor_name());
					lblName.setVisible(true);
					lblMobile.setText(doctor.getDoctor_mobile());
					lblMobile.setVisible(true);
				}
				lblPage.setText(Integer.toString(page));
			}
		});
		btnNext.setText(">");
		btnNext.setBounds(417, 398, 33, 24);
		
		Button btnLink = new Button(shell, SWT.NONE);
		btnLink.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dao.updatePatient(patient, doctor.getDoctor_id());
				MessageBox messageBox = new MessageBox(shell);
				messageBox.setMessage("关联成功");
				messageBox.open();
			}
		});
		btnLink.setBounds(320, 455, 130, 34);
		btnLink.setText("\u5173\u8054");
		
		Button btnBack = new Button(shell, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				display.close();
				//PatMain.main(null);
				PatMain main = new PatMain(patient.getPat_mobile());
				main.open();
			}
		});
		btnBack.setBounds(640, 484, 97, 34);
		btnBack.setText("\u8FD4\u56DE");

	}
}
