package pat;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ibm.icu.text.SimpleDateFormat;

import experi.dao.AppointmentDao;
import experi.dao.DoctorDao;
import experi.dao.MessageDao;
import experi.dao.PatientDao;
import experi.dao.RateDao;
import experi.dao.SuggestionDao;
import experi.entity.Doctor;
import experi.entity.Message;
import experi.entity.Patient;
import experi.entity.Rate;
import experi.entity.Suggestion;
import experi.entity.Appointment;

import java.awt.Toolkit;
//import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
//import org.eclipse.ui.internal.handlers.WizardHandler.New;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Scale;

public class PatSelfDoc {

	protected Shell shell;
	protected Display display;
	
	private Text txtAdvice;
	private Text textMessage;
	private Text textSendMessage;
	
	protected String pat_id;
	private Text textApmtNote;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PatSelfDoc window = new PatSelfDoc();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public PatSelfDoc() {
		
	}
	
	public PatSelfDoc(String pat_id) {
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
		Patient patient = patientDao.findById(pat_id);
		
		DoctorDao doctorDao = new DoctorDao();
		Doctor doctor = doctorDao.findByIdComplete(patient.getDoc_id());
		
		MessageDao messageDao = new MessageDao();
		SuggestionDao suggestionDao = new SuggestionDao();
		
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shell.setSize(800, 600);
		shell.setText("\u4E3B\u6CBB\u533B\u751F");
		
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int x = (screenWidth - 800) / 2;
		int y = (screenHeight - 600) / 2;
		shell.setLocation(x, y);
		
		Label lblName = new Label(shell, SWT.NONE);
		lblName.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 14, SWT.NORMAL));
		lblName.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblName.setBounds(422, 41, 209, 49);
		lblName.setText("医生:" + doctor.getDoctor_name());
		
		/*
		Canvas canvasPhoto = new Canvas(shell, SWT.NONE);
		canvasPhoto.setBounds(442, 180, 142, 200);
		//Need to learn how to add images.
		*/
		
		Button btnBack = new Button(shell, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				display.close();
				PatMain patMain = new PatMain(patient.getPat_mobile());
				patMain.open();
			}
		});
		btnBack.setBounds(665, 475, 76, 34);
		btnBack.setText("\u8FD4\u56DE");
		
		Label lblPhone = new Label(shell, SWT.NONE);
		lblPhone.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		lblPhone.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblPhone.setBounds(389, 153, 269, 29);
		lblPhone.setText("\u8054\u7CFB\u7535\u8BDD\uFF1A" + doctor.getDoctor_mobile());
		lblPhone.setVisible(false);
		
		Label lblTencent = new Label(shell, SWT.NONE);
		lblTencent.setText("QQ/\u5FAE\u4FE1\uFF1A");
		if(doctor.getDoc_QQ() != null) {
			lblTencent.setText("QQ/\u5FAE\u4FE1\uFF1A" + doctor.getDoc_QQ());
		}
		lblTencent.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		lblTencent.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblTencent.setBounds(389, 233, 269, 29);
		lblTencent.setVisible(false);
		
		/*
		Label lblAddress = new Label(shell, SWT.NONE);
		lblAddress.setText("\u5730\u5740\uFF1A\u6D59\u6C5F\u7701\u676D\u5DDE\u5E02**\u8DEF");
		lblAddress.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		lblAddress.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblAddress.setBounds(389, 304, 269, 29);
		lblAddress.setVisible(false);
		*/
		
		Label lblWorkTime = new Label(shell, SWT.NONE);
		lblWorkTime.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		lblWorkTime.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblWorkTime.setBounds(484, 298, 183, 156);
		lblWorkTime.setText("");
		if (doctor.getWorkOnMon()) {
			lblWorkTime.setText(lblWorkTime.getText() + "周一\n");
		}
		if (doctor.getWorkOnTue()) {
			lblWorkTime.setText(lblWorkTime.getText() + "周二\n");
		}
		if (doctor.getWorkOnWed()) {
			lblWorkTime.setText(lblWorkTime.getText() + "周三\n");
		}
		if (doctor.getWorkOnThu()) {
			lblWorkTime.setText(lblWorkTime.getText() + "周四\n");
		}
		if (doctor.getWorkOnFri()) {
			lblWorkTime.setText(lblWorkTime.getText() + "周五\n");
		}
		if (doctor.getWorkOnSat()) {
			lblWorkTime.setText(lblWorkTime.getText() + "周六\n");
		}
		if (doctor.getWorkOnSun()) {
			lblWorkTime.setText(lblWorkTime.getText() + "周日\n");
		}
		lblWorkTime.setVisible(false);
		
		Label lbl = new Label(shell, SWT.NONE);
		lbl.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblWorkTime.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		lbl.setBounds(389, 298, 90, 24);
		lbl.setText("\u5DE5\u4F5C\u65F6\u95F4\uFF1A");
		lbl.setVisible(false);
		
		txtAdvice = new Text(shell, SWT.BORDER | SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		txtAdvice.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		txtAdvice.setEditable(false);
		txtAdvice.setText("");
		txtAdvice.setBounds(389, 129, 278, 245);
		txtAdvice.setVisible(false);
		
		int adviceNum = suggestionDao.countSuggestions(pat_id);
		
		for(int i = 0; i < adviceNum; ++i) {
			Suggestion suggestion = suggestionDao.findSuggestion(pat_id, i);
			txtAdvice.append(suggestion.getSug_time() + ":\n" + suggestion.getSug_main() + "\n");
		}
		
		textMessage = new Text(shell, SWT.BORDER | SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		//textMessage.setText("\u5386\u53F2\u6D88\u606F");
		textMessage.setText("");
		textMessage.setEditable(false);
		textMessage.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		textMessage.setBounds(389, 129, 278, 245);
		textMessage.setVisible(false);
		
		textSendMessage = new Text(shell, SWT.BORDER | SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		textSendMessage.setBounds(387, 397, 215, 57);
		textSendMessage.setVisible(false);
		
		int messageNum = messageDao.countMessages(pat_id, patient.getDoc_id());
		
		for(int i = 0; i < messageNum; ++i) {
			Message message = messageDao.findMessage(pat_id, patient.getDoc_id(), i);
			//textMessage.setText(textMessage.getText() + message.getMes_time() + " ");
			textMessage.append("\n" + message.getMes_time() + " ");
			if(message.getMes_sentByDoc() == 0) {
				//textMessage.setText(textMessage.getText() + "\n你: " + message.getMes_text() + "\n\n");
				textMessage.append("\n你: " + message.getMes_text() + "\n");
			}
			else {
				//textMessage.setText(textMessage.getText() + "\n医生: " + message.getMes_text() + "\n\n");
				textMessage.append("\n医生:" + message.getMes_text() + "\n");
			}
			
			//textMessage.setText(textMessage.getText() + message.getMes_text() + "\n\r");
			
		}
		
		
		Button btnSend = new Button(shell, SWT.NONE);
		btnSend.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				//String time = Integer.toString(timestamp.getYear());
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = simpleDateFormat.format(new Date());
				Message message = new Message(patient.getDoc_id(), pat_id, textSendMessage.getText(), time, 0);
				
				messageDao.sendMessage(message);
				//textMessage.setText(textMessage.getText() + "\n" + message.getMes_time()  + "\n你: " + message.getMes_text() + "\n");
				textMessage.append("\n" + message.getMes_time() + "\n你: " + message.getMes_text() + "\n");
				textSendMessage.setText("");
			}
		});
		btnSend.setBounds(608, 397, 59, 57);
		btnSend.setText("\u53D1\u9001");
		btnSend.setVisible(false);
		
		textApmtNote = new Text(shell, SWT.BORDER | SWT.MULTI | SWT.WRAP);
		textApmtNote.setText("\u5907\u6CE8");
		textApmtNote.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		textApmtNote.setBounds(389, 153, 269, 152);
		textApmtNote.setVisible(false);
		
		DateTime dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.setBounds(389, 350, 135, 33);
		dateTime.setVisible(false);
		
		Button btnSubmit = new Button(shell, SWT.NONE);
		btnSubmit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AppointmentDao appointmentDao = new AppointmentDao();
				//Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				//Rate rate = new Rate(pat_id, patient.getDoc_id(), scaleScore.getSelection(), timestamp.toString());
				//rateDao.insertRate(rate);
				Appointment appointment = new Appointment(patient.getDoc_id(), pat_id, dateTime.toString(), textApmtNote.getText());
				appointmentDao.insertAppointment(appointment);
				MessageBox messageBox = new MessageBox(shell);
				messageBox.setMessage("预约成功");
				messageBox.open();
			}
		});
		btnSubmit.setBounds(544, 350, 114, 34);
		btnSubmit.setText("\u9884\u7EA6");
		btnSubmit.setVisible(false);
		
		Scale scaleScore = new Scale(shell, SWT.NONE);
		scaleScore.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		scaleScore.setBounds(371, 244, 260, 48);
		scaleScore.setMaximum(10);
		scaleScore.setMinimum(0);
		scaleScore.setPageIncrement(1);
		scaleScore.setVisible(false);
		
		Label lblPoint = new Label(shell, SWT.NONE);
		lblPoint.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.NORMAL));
		lblPoint.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblPoint.setBounds(371, 203, 260, 24);
		lblPoint.setText("   0  1  2  3  4  5  6  7  8  9  10 ");
		lblPoint.setVisible(false);
		
		Button btnRate = new Button(shell, SWT.NONE);
		btnRate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				RateDao rateDao = new RateDao();
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				Rate rate = new Rate(pat_id, patient.getDoc_id(), scaleScore.getSelection(), timestamp.toString());
				rateDao.insertRate(rate);
				MessageBox messageBox = new MessageBox(shell);
				messageBox.setMessage("评分成功");
				messageBox.open();
			}
		});
		btnRate.setBounds(653, 255, 76, 34);
		btnRate.setText("\u8BC4\u5206");
		btnRate.setVisible(false);
		
		Button btnContact = new Button(shell, SWT.NONE);
		btnContact.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblPhone.setVisible(true);
				lblTencent.setVisible(true);
				lblWorkTime.setVisible(true);
				lbl.setVisible(true);
				//lblAddress.setVisible(true);
				txtAdvice.setVisible(false);
				textMessage.setVisible(false);
				textSendMessage.setVisible(false);
				textApmtNote.setVisible(false);
				dateTime.setVisible(false);
				btnSend.setVisible(false);
				btnSubmit.setVisible(false);
				scaleScore.setVisible(false);
				lblPoint.setVisible(false);
				btnRate.setVisible(false);
			}
		});
		btnContact.setBounds(135, 100, 114, 34);
		btnContact.setText("\u8054\u7CFB\u65B9\u5F0F");
		
		Button btnAdvice = new Button(shell, SWT.NONE);
		btnAdvice.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblPhone.setVisible(false);
				lblTencent.setVisible(false);
				lblWorkTime.setVisible(false);
				lbl.setVisible(false);
				//lblAddress.setVisible(false);
				txtAdvice.setVisible(true);
				textMessage.setVisible(false);
				textSendMessage.setVisible(false);
				textApmtNote.setVisible(false);
				dateTime.setVisible(false);
				btnSend.setVisible(false);
				btnSubmit.setVisible(false);
				scaleScore.setVisible(false);
				lblPoint.setVisible(false);
				btnRate.setVisible(false);
			}
		});
		btnAdvice.setBounds(135, 180, 114, 34);
		btnAdvice.setText("\u67E5\u770B\u5EFA\u8BAE");
		
		Button btnMessage = new Button(shell, SWT.NONE);
		btnMessage.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblPhone.setVisible(false);
				lblTencent.setVisible(false);
				lblWorkTime.setVisible(false);
				lbl.setVisible(false);
				//lblAddress.setVisible(false);
				txtAdvice.setVisible(false);
				textMessage.setVisible(true);
				textSendMessage.setVisible(true);
				textApmtNote.setVisible(false);
				dateTime.setVisible(false);
				btnSend.setVisible(true);
				btnSubmit.setVisible(false);
				scaleScore.setVisible(false);
				lblPoint.setVisible(false);
				btnRate.setVisible(false);
			}
		});
		btnMessage.setBounds(135, 260, 114, 34);
		btnMessage.setText("\u6D88\u606F\u8BB0\u5F55");
		
		Button btnAppointment = new Button(shell, SWT.NONE);
		btnAppointment.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblPhone.setVisible(false);
				lblTencent.setVisible(false);
				lblWorkTime.setVisible(false);
				lbl.setVisible(false);
				//lblAddress.setVisible(false);
				txtAdvice.setVisible(false);
				textMessage.setVisible(false);
				textSendMessage.setVisible(false);
				textApmtNote.setVisible(true);
				textApmtNote.addFocusListener(new FocusListener() {
					
					@Override
					public void focusLost(FocusEvent arg0) {
						// TODO Auto-generated method stub
						if(textApmtNote.getText().equals("")) {
							textApmtNote.setText("备注");
							textApmtNote.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
						}
					}
					
					@Override
					public void focusGained(FocusEvent arg0) {
						// TODO Auto-generated method stub
						textApmtNote.setText("");
						textApmtNote.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
						
					}
				});
				dateTime.setVisible(true);
				btnSend.setVisible(false);
				btnSubmit.setVisible(true);
				scaleScore.setVisible(false);
				lblPoint.setVisible(false);
				btnRate.setVisible(false);
			}
		});
		btnAppointment.setBounds(135, 340, 114, 34);
		btnAppointment.setText("\u8FDB\u884C\u9884\u7EA6");
		
		Button btnReview = new Button(shell, SWT.NONE);
		btnReview.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblPhone.setVisible(false);
				lblTencent.setVisible(false);
				lblWorkTime.setVisible(false);
				lbl.setVisible(false);
				//lblAddress.setVisible(false);
				txtAdvice.setVisible(false);
				textMessage.setVisible(false);
				textSendMessage.setVisible(false);
				textApmtNote.setVisible(false);
				dateTime.setVisible(false);
				btnSend.setVisible(false);
				btnSubmit.setVisible(false);
				scaleScore.setVisible(true);
				lblPoint.setVisible(true);
				btnRate.setVisible(true);
			}
		});
		btnReview.setBounds(135, 420, 114, 34);
		btnReview.setText("\u8BC4\u4EF7\u533B\u751F");
		
		
		
		
		
		
	}
}
