package doc;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import experi.dao.DoctorDao;
import experi.dao.PatientDao;
import experi.dao.PressureDao;
import experi.entity.Doctor;
import experi.entity.Patient;
import experi.entity.Pressure;

import java.awt.Toolkit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
//import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

public class PatInfo {

	protected Shell shell;
	protected Display display;
	private Text textMessage;
	private Text textSendMessage;
	private Text textAdvice;
	private Text textNotes;
	private String pat_id;
	private int index;
	private int INIT;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PatInfo window = new PatInfo();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public PatInfo() {
		
	}
	
	public PatInfo(String pat_id) {
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
		PatientDao patientDao = new PatientDao();
		Patient patient = patientDao.findByIdComplete(pat_id);
		
		PressureDao pressureDao = new PressureDao();
		int pressureNum = pressureDao.countPatPressure(pat_id);
		//INIT = pressureNum - 1;
		
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shell.setSize(800, 600);
		shell.setText("\u60A3\u8005\u4FE1\u606F");
		
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int x = (screenWidth - 800) / 2;
		int y = (screenHeight - 600) / 2;
		shell.setLocation(x, y);
		
		Label lblName = new Label(shell, SWT.NONE);
		lblName.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblName.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		lblName.setBounds(56, 46, 190, 35);
		lblName.setText("\u60A3\u8005-" + patient.getPat_name());
		
		Button btnBack = new Button(shell, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				display.close();
				//DocMain.main(null);
				DoctorDao doctorDao = new DoctorDao();
				Doctor doctor = doctorDao.findById(patient.getDoc_id());
				DocMain docMain = new DocMain(doctor.getDoctor_mobile());
				docMain.open();
			}
		});
		btnBack.setBounds(665, 475, 76, 34);
		btnBack.setText("\u8FD4\u56DE");
		
		Label lblAge = new Label(shell, SWT.NONE);
		lblAge.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblAge.setBounds(405, 144, 210, 24);
		lblAge.setText("\u5E74       \u9F84\uFF1A"  + " " + patient.getPat_name());
		lblAge.setVisible(false);
		
		Label lblSex = new Label(shell, SWT.NONE);
		lblSex.setText("\u6027       \u522B\uFF1A" + " " + patient.getPat_sex());
		lblSex.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblSex.setBounds(405, 192, 210, 24);
		lblSex.setVisible(false);
		
		Label lblHeight = new Label(shell, SWT.NONE);
		lblHeight.setText("\u8EAB       \u9AD8\uFF1A" + " " + patient.getPat_height());
		lblHeight.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblHeight.setBounds(405, 245, 210, 24);
		lblHeight.setVisible(false);
		
		Label lblWeight = new Label(shell, SWT.NONE);
		lblWeight.setText("\u4F53       \u91CD\uFF1A" + " " + patient.getPat_weight());
		lblWeight.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblWeight.setBounds(405, 299, 210, 24);
		lblWeight.setVisible(false);
		
		Label lblFamilialDisease = new Label(shell, SWT.NONE);
		lblFamilialDisease.setText("\u5BB6\u65CF\u75BE\u75C5\uFF1A" + " " + patient.getPat_familialDisease());
		lblFamilialDisease.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblFamilialDisease.setBounds(405, 354, 298, 50);
		lblFamilialDisease.setVisible(false);
		
		Label lblHistoryDisease = new Label(shell, SWT.NONE);
		lblHistoryDisease.setText("\u65E2\u5F80\u75C5\u53F2\uFF1A" + " " + patient.getPat_historyDisease());
		lblHistoryDisease.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblHistoryDisease.setBounds(405, 410, 298, 59);
		lblHistoryDisease.setVisible(false);
		
		//Combo comboHistory = new Combo(shell, SWT.NONE);
		//comboHistory.setBounds(405, 122, 228, 32);
		//comboHistory.setVisible(false);
		
		textMessage = new Text(shell, SWT.BORDER | SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		textMessage.setText("\u6D88\u606F\u8BB0\u5F55a\na\naaa\naaaa\naaaaaaa\naaaaaaaaaa\naaaa\n\naaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		textMessage.setEditable(false);
		textMessage.setBounds(365, 91, 298, 232);
		textMessage.setVisible(false);
		
		textSendMessage = new Text(shell, SWT.BORDER | SWT.MULTI | SWT.WRAP);//reference:http://bbs.csdn.net/topics/260045661
		textSendMessage.setBounds(365, 354, 210, 71);
		textSendMessage.setVisible(false);
		
		Button btnSend = new Button(shell, SWT.NONE);
		btnSend.setBounds(593, 354, 70, 71);
		btnSend.setText("\u53D1\u9001");
		btnSend.setVisible(false);
		
		textAdvice = new Text(shell, SWT.BORDER);
		textAdvice.setBounds(365, 160, 298, 163);
		textAdvice.setVisible(false);
		
		Button btnSendAdvice = new Button(shell, SWT.NONE);
		btnSendAdvice.setBounds(461, 368, 114, 34);
		btnSendAdvice.setText("\u53D1\u9001");
		btnSendAdvice.setVisible(false);
		
		textNotes = new Text(shell, SWT.BORDER);
		textNotes.setBounds(365, 91, 298, 334);
		textNotes.setVisible(false);
		
		Label lblSystolic = new Label(shell, SWT.NONE);
		lblSystolic.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		lblSystolic.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblSystolic.setBounds(320, 111, 90, 24);
		lblSystolic.setText("\u6536\u7F29\u538B");
		lblSystolic.setVisible(false);
		
		Label lblDiastolic = new Label(shell, SWT.NONE);
		lblDiastolic.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		lblDiastolic.setText("\u8212\u5F20\u538B");
		lblDiastolic.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblDiastolic.setBounds(460, 111, 90, 24);
		lblDiastolic.setVisible(false);
		
		Label lblRecordTime = new Label(shell, SWT.NONE);
		lblRecordTime.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		lblRecordTime.setText("\u8BB0\u5F55\u65F6\u95F4");
		lblRecordTime.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblRecordTime.setBounds(600, 111, 90, 24);
		lblRecordTime.setVisible(false);
		
		Label lblSystolic0 = new Label(shell, SWT.NONE);
		lblSystolic0.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblSystolic0.setBounds(328, 245, 90, 24);
		
		Label lblDiastolic0 = new Label(shell, SWT.NONE);
		lblDiastolic0.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblDiastolic0.setBounds(471, 245, 90, 24);
		
		Label lblRecordTime0 = new Label(shell, SWT.NONE);
		lblRecordTime0.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblRecordTime0.setBounds(593, 245, 175, 24);
		
		Button btnPre = new Button(shell, SWT.NONE);
		Button btnNext = new Button(shell, SWT.NONE);
		
		Label lblPage = new Label(shell, SWT.NONE);
		lblPage.setBounds(487, 445, 90, 24);
		
		
		
		Button btnInfo = new Button(shell, SWT.NONE);
		btnInfo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				index = INIT;
				lblAge.setVisible(true);
				lblWeight.setVisible(true);
				lblFamilialDisease.setVisible(true);
				lblHeight.setVisible(true);
				lblSex.setVisible(true);
				lblHistoryDisease.setVisible(true);
				textAdvice.setVisible(false);
				textMessage.setVisible(false);
				textNotes.setVisible(false);
				textSendMessage.setVisible(false);
				btnSend.setVisible(false);
				btnSendAdvice.setVisible(false);
				lblDiastolic.setVisible(false);
				lblDiastolic0.setVisible(false);
				lblSystolic.setVisible(false);
				lblSystolic0.setVisible(false);
				lblRecordTime.setVisible(false);
				lblRecordTime0.setVisible(false);
				btnPre.setVisible(false);
				btnNext.setVisible(false);
			}
		});
		btnInfo.setBounds(88, 130, 114, 34);
		btnInfo.setText("\u57FA\u672C\u4FE1\u606F");
		
		Button btnPressure = new Button(shell, SWT.NONE);
		btnPressure.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblAge.setVisible(false);
				lblWeight.setVisible(false);
				lblFamilialDisease.setVisible(false);
				lblHeight.setVisible(false);
				lblSex.setVisible(false);
				lblHistoryDisease.setVisible(false);
				textAdvice.setVisible(false);
				textMessage.setVisible(false);
				textNotes.setVisible(false);
				textSendMessage.setVisible(false);
				btnSend.setVisible(false);
				btnSendAdvice.setVisible(false);
				lblDiastolic.setVisible(true);
				lblDiastolic0.setVisible(true);
				lblSystolic.setVisible(true);
				lblSystolic0.setVisible(true);
				lblRecordTime.setVisible(true);
				lblRecordTime0.setVisible(true);
				btnPre.setVisible(true);
				btnNext.setVisible(true);
				//int pressureNum = pressureDao.countPatPressure(pat_id);
				if (pressureNum == 0 || pressureNum == 1) {
					btnPre.setVisible(false);
					btnNext.setVisible(false);
				}
				
				Pressure pressure = pressureDao.findByPatIDandIndex(pat_id, pressureNum - 1);
				if(pressure == null) {
					lblDiastolic0.setText("无记录");
					lblRecordTime0.setText("");
					lblSystolic0.setText("");
				}
				else {
					lblDiastolic0.setText(pressure.getPressure_Diastolic());
					lblSystolic0.setText(pressure.getPressure_Systolic());
					lblRecordTime0.setText(pressure.getPressure_RecordTime());
				}
				
				index = INIT;
				
				lblPage.setText(Integer.toString(index));
				
				btnPre.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						if(index < pressureNum - 1) {
							index = index + 1;
							lblPage.setText(Integer.toString(index));
							Pressure pressure = pressureDao.findByPatIDandIndex(pat_id, index);
							if(pressure == null) {
								lblDiastolic0.setText("无记录");
								lblRecordTime0.setText("");
								lblSystolic0.setText("");
							}
							else {
								lblDiastolic0.setText(pressure.getPressure_Diastolic());
								lblSystolic0.setText(pressure.getPressure_Systolic());
								lblRecordTime0.setText(pressure.getPressure_RecordTime());
							}
						}
					}
				});
				btnPre.setBounds(469, 324, 25, 24);
				btnPre.setText("<");
				
				btnNext.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						if(index > 0) {
							index = index - 1;
							lblPage.setText(Integer.toString(index));
							Pressure pressure = pressureDao.findByPatIDandIndex(pat_id, index);
							if(pressure == null) {
								lblDiastolic0.setText("无记录");
								lblRecordTime0.setText("");
								lblSystolic0.setText("");
							}
							else {
								lblDiastolic0.setText(pressure.getPressure_Diastolic());
								lblSystolic0.setText(pressure.getPressure_Systolic());
								lblRecordTime0.setText(pressure.getPressure_RecordTime());
							}
						}
					}
				});
				btnNext.setText(">");
				btnNext.setBounds(536, 324, 25, 24);
			}
		});
		btnPressure.setText("\u8840\u538B\u53D8\u5316");
		btnPressure.setBounds(88, 200, 114, 34);
		
		Button btnMessage = new Button(shell, SWT.NONE);
		btnMessage.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				index = INIT;
				lblPage.setText(Integer.toString(index));
				lblAge.setVisible(false);
				lblWeight.setVisible(false);
				lblFamilialDisease.setVisible(false);
				lblHeight.setVisible(false);
				lblSex.setVisible(false);
				lblHistoryDisease.setVisible(false);
				textAdvice.setVisible(false);
				textMessage.setVisible(true);
				textNotes.setVisible(false);
				textSendMessage.setVisible(true);
				btnSend.setVisible(true);
				btnSendAdvice.setVisible(false);
				lblDiastolic.setVisible(false);
				lblDiastolic0.setVisible(false);
				lblSystolic.setVisible(false);
				lblSystolic0.setVisible(false);
				lblRecordTime.setVisible(false);
				lblRecordTime0.setVisible(false);
				btnPre.setVisible(false);
				btnNext.setVisible(false);
			}
		});
		btnMessage.setText("\u6D88\u606F\u8BB0\u5F55");
		btnMessage.setBounds(88, 270, 114, 34);
		
		Button btnAdvice = new Button(shell, SWT.NONE);
		btnAdvice.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				index = INIT;
				lblPage.setText(Integer.toString(index));
				lblAge.setVisible(false);
				lblWeight.setVisible(false);
				lblFamilialDisease.setVisible(false);
				lblHeight.setVisible(false);
				lblSex.setVisible(false);
				lblHistoryDisease.setVisible(false);
				textAdvice.setVisible(true);
				textMessage.setVisible(false);
				textNotes.setVisible(false);
				textSendMessage.setVisible(false);
				btnSend.setVisible(false);
				btnSendAdvice.setVisible(true);
				lblDiastolic.setVisible(false);
				lblDiastolic0.setVisible(false);
				lblSystolic.setVisible(false);
				lblSystolic0.setVisible(false);
				lblRecordTime.setVisible(false);
				lblRecordTime0.setVisible(false);
				btnPre.setVisible(false);
				btnNext.setVisible(false);
			}
		});
		btnAdvice.setText("\u533B\u7597\u5EFA\u8BAE");
		btnAdvice.setBounds(88, 340, 114, 34);
		
		Button btnNote = new Button(shell, SWT.NONE);
		btnNote.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				index = INIT;
				lblPage.setText(Integer.toString(index));
				lblAge.setVisible(false);
				lblWeight.setVisible(false);
				lblFamilialDisease.setVisible(false);
				lblHeight.setVisible(false);
				lblSex.setVisible(false);
				lblHistoryDisease.setVisible(false);
				textAdvice.setVisible(false);
				textMessage.setVisible(false);
				textNotes.setVisible(true);
				textSendMessage.setVisible(false);
				btnSend.setVisible(false);
				btnSendAdvice.setVisible(false);
				lblDiastolic.setVisible(false);
				lblDiastolic0.setVisible(false);
				lblSystolic.setVisible(false);
				lblSystolic0.setVisible(false);
				lblRecordTime.setVisible(false);
				lblRecordTime0.setVisible(false);
				btnPre.setVisible(false);
				btnNext.setVisible(false);
			}
		});
		btnNote.setText("\u5907\u5FD8");
		btnNote.setBounds(88, 410, 114, 34);
		
		

	}

}
