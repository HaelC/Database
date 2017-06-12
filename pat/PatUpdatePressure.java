package pat;

import java.awt.Toolkit;
//import java.sql.Timestamp;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import experi.dao.PatientDao;
import experi.dao.PressureDao;
import experi.entity.Patient;
import experi.entity.Pressure;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.DateTime;

public class PatUpdatePressure {

	protected Shell shell;
	protected Display display;
	private String pat_id;
	private Text textSystolic;
	private Text textDiastolic;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PatUpdatePressure window = new PatUpdatePressure();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public PatUpdatePressure() {
		
	}
	
	public PatUpdatePressure (String pat_id) {
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
		Pressure pressure = pressureDao.findByPatIDLatest(pat_id);
		
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shell.setSize(800, 600);
		shell.setText("\u66F4\u65B0\u8840\u538B");
		
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int x = (screenWidth - 800) / 2;
		int y = (screenHeight - 600) / 2;
		shell.setLocation(x, y);
		
		Label lblSystolic = new Label(shell, SWT.NONE);
		lblSystolic.setText("\u6536\u7F29\u538B");
		lblSystolic.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblSystolic.setBounds(153, 176, 65, 24);
		
		Label lblDiastolic = new Label(shell, SWT.NONE);
		lblDiastolic.setText("\u8212\u5F20\u538B");
		lblDiastolic.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblDiastolic.setBounds(409, 176, 65, 24);
		
		textSystolic = new Text(shell, SWT.BORDER);
		textSystolic.setBounds(240, 173, 113, 30);
		if(pressure != null)
			textSystolic.setText(pressure.getPressure_Systolic());
		
		textDiastolic = new Text(shell, SWT.BORDER);
		textDiastolic.setBounds(499, 173, 113, 30);
		if(pressure != null)
			textDiastolic.setText(pressure.getPressure_Diastolic());
		

		DateTime dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.setBounds(263, 260, 135, 33);
		
		DateTime dateTime_1 = new DateTime(shell, SWT.BORDER | SWT.TIME);
		dateTime_1.setBounds(439, 260, 135, 33);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblNewLabel.setBounds(153, 269, 90, 24);
		lblNewLabel.setText("\u6D4B\u5B9A\u65F6\u95F4");
		
		Button btnSubmit = new Button(shell, SWT.NONE);
		btnSubmit.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				
				Pressure pressure = new Pressure();
				pressure.setPat_id(pat_id);
				pressure.setPressure_Diastolic(textDiastolic.getText());
				pressure.setPressure_Systolic(textSystolic.getText());
				//Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				//pressure.setPressure_RecordTime(timestamp.toString());
				//pressure.setPressure_RecordTime(dateTime.toString());
				pressure.setPressure_RecordTime(Integer.toString(dateTime.getYear()) + "-" + Integer.toString(dateTime.getMonth() + 1) + "-"  +Integer.toString(dateTime.getDay()) + " " + Integer.toString(dateTime_1.getHours()) + ":" + Integer.toString(dateTime_1.getMinutes()) + ":" + Integer.toString(dateTime_1.getSeconds()));
				
				pressureDao.insertPressure(pressure);
				MessageBox messageBox = new MessageBox(shell);
				messageBox.setMessage("提交成功");
				messageBox.open();
				display.close();
				PatMain patMain = new PatMain(patient.getPat_mobile());
				patMain.open();
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
		

	}
}
