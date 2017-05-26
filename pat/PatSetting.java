package pat;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import experi.dao.PatientDao;
import experi.dao.PressureDao;
import experi.entity.Patient;
import experi.entity.Pressure;

import java.awt.Toolkit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

public class PatSetting {

	protected Shell shell;
	protected Display display;
	private Text textName;
	private Text textHeight;
	private Text textQQ;
	protected String pat_id;
	private Text textWeight;
	private Text textDiastolic;
	private Text textSystolic;
	private Text textFamilialDisease;
	private Text textHistoryDisease;
	private Text textMobile;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PatSetting window = new PatSetting();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public PatSetting() {
		
	}
	
	public PatSetting(String pat_id) {
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
		//PressureDao pressureDao = new PressureDao();
		//Pressure pressure = pressureDao.findByPatID(pat_id);
		
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
		lblName.setBounds(153, 62, 65, 24);
		lblName.setText("\u59D3\u540D");
		
		Label lblHeight = new Label(shell, SWT.NONE);
		lblHeight.setText("\u8EAB\u9AD8");
		lblHeight.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblHeight.setBounds(153, 118, 65, 24);
		
		Label lblQQ = new Label(shell, SWT.NONE);
		lblQQ.setText("QQ");
		lblQQ.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblQQ.setBounds(153, 295, 65, 24);
		
		textName = new Text(shell, SWT.BORDER);
		textName.setBounds(240, 59, 113, 30);
		if(patient.getPat_name() != null)
			textName.setText(patient.getPat_name());
		
		textHeight = new Text(shell, SWT.BORDER);
		textHeight.setBounds(240, 115, 82, 30);
		if(patient.getPat_height() != null) 
			textHeight.setText(patient.getPat_height());
		
		textQQ = new Text(shell, SWT.BORDER);
		textQQ.setBounds(240, 292, 113, 30);
		if(patient.getPat_QQ() != null)
			textQQ.setText(patient.getPat_QQ());
		
		Button btnSubmit = new Button(shell, SWT.NONE);
		btnSubmit.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				MessageBox messageBox = new MessageBox(shell);
				messageBox.setMessage("提交成功");
				messageBox.open();
			}
		});
		btnSubmit.setBounds(263, 428, 90, 34);
		btnSubmit.setText("\u63D0\u4EA4");
		
		Button btnBack = new Button(shell, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				display.close();
				//PatMain.main(null);
				PatMain patMain = new PatMain(patient.getPat_mobile());
				patMain.open();
			}
		});
		btnBack.setText("\u8FD4\u56DE");
		btnBack.setBounds(422, 428, 90, 34);
		
		Label lblAge = new Label(shell, SWT.NONE);
		lblAge.setText("\u5E74\u9F84");
		lblAge.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblAge.setBounds(409, 62, 65, 24);
		
		Label lblWeight = new Label(shell, SWT.NONE);
		lblWeight.setText("\u4F53\u91CD");
		lblWeight.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblWeight.setBounds(409, 118, 65, 24);
		
		textWeight = new Text(shell, SWT.BORDER);
		textWeight.setBounds(499, 115, 82, 30);
		if(patient.getPat_weight() != null)
			textWeight.setText(patient.getPat_weight());
		
		Label lblDiastolic = new Label(shell, SWT.NONE);
		lblDiastolic.setText("\u8212\u5F20\u538B");
		lblDiastolic.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblDiastolic.setBounds(153, 176, 65, 24);
		
		Label lblSystolic = new Label(shell, SWT.NONE);
		lblSystolic.setText("\u4F38\u7F29\u538B");
		lblSystolic.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblSystolic.setBounds(409, 176, 65, 24);
		
		textDiastolic = new Text(shell, SWT.BORDER);
		textDiastolic.setBounds(240, 173, 113, 30);
		//if(pressure != null)textDiastolic.setText(pressure.getPressure_Diastolic());
		
		textSystolic = new Text(shell, SWT.BORDER);
		textSystolic.setBounds(499, 173, 113, 30);
		//if(pressure != null)textSystolic.setText(pressure.getPressure_Systolic());
		
		Combo age = new Combo(shell, SWT.NONE);
		age.setBounds(499, 59, 113, 32);
		age.setItems("0-30岁","31-40岁","41-50岁","51-60岁","61-70岁","71-80岁","80岁以上");
		if(patient.getPat_age() != null)
			age.setText(patient.getPat_age());
		
		Label lblFamilialDisease = new Label(shell, SWT.NONE);
		lblFamilialDisease.setText("\u5BB6\u65CF\u75BE\u75C5");
		lblFamilialDisease.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblFamilialDisease.setBounds(153, 230, 82, 24);
		
		textFamilialDisease = new Text(shell, SWT.BORDER);
		textFamilialDisease.setBounds(240, 230, 113, 30);
		if(patient.getPat_familialDisease() != null)
			textFamilialDisease.setText(patient.getPat_familialDisease());
		
		Label lblHistoryDisease = new Label(shell, SWT.NONE);
		lblHistoryDisease.setText("\u65E2\u5F80\u75C5\u53F2");
		lblHistoryDisease.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblHistoryDisease.setBounds(409, 230, 82, 24);
		
		textHistoryDisease = new Text(shell, SWT.BORDER);
		textHistoryDisease.setBounds(499, 230, 113, 30);
		if(patient.getPat_historyDisease() != null) 
			textHistoryDisease.setText(patient.getPat_historyDisease());
		
		Label lblMobile = new Label(shell, SWT.NONE);
		lblMobile.setText("\u624B\u673A\u53F7");
		lblMobile.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblMobile.setBounds(409, 292, 65, 24);
		
		textMobile = new Text(shell, SWT.BORDER);
		textMobile.setEditable(false);
		textMobile.setBounds(499, 289, 151, 30);
		textMobile.setText(patient.getPat_mobile());
		
		Label lblMeter = new Label(shell, SWT.NONE);
		lblMeter.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblMeter.setBounds(328, 118, 25, 24);
		lblMeter.setText("m");
		
		Label lblKilogram = new Label(shell, SWT.NONE);
		lblKilogram.setText("kg");
		lblKilogram.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblKilogram.setBounds(587, 118, 25, 24);

	}
}
