package pat;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import java.awt.Toolkit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Scale;

public class PatSelfDoc {

	protected Shell shell;
	protected Display display;
	
	private Text txtAdvice;
	private Text textMessage;
	private Text textSendMessage;

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
		lblName.setText("\u533B\u751F\uFF1AName");
		
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
				PatMain.main(null);
			}
		});
		btnBack.setBounds(665, 475, 76, 34);
		btnBack.setText("\u8FD4\u56DE");
		
		Label lblPhone = new Label(shell, SWT.NONE);
		lblPhone.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		lblPhone.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblPhone.setBounds(389, 153, 269, 29);
		lblPhone.setText("\u8054\u7CFB\u7535\u8BDD\uFF1A18888888888");
		lblPhone.setVisible(false);
		
		Label lblTencent = new Label(shell, SWT.NONE);
		lblTencent.setText("QQ/\u5FAE\u4FE1\uFF1A000000000");
		lblTencent.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		lblTencent.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblTencent.setBounds(389, 233, 269, 29);
		lblTencent.setVisible(false);
		
		Label lblAddress = new Label(shell, SWT.NONE);
		lblAddress.setText("\u5730\u5740\uFF1A\u6D59\u6C5F\u7701\u676D\u5DDE\u5E02**\u8DEF");
		lblAddress.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		lblAddress.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblAddress.setBounds(389, 304, 269, 29);
		lblAddress.setVisible(false);
		
		txtAdvice = new Text(shell, SWT.BORDER);
		txtAdvice.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		txtAdvice.setEditable(false);
		txtAdvice.setText("\u591A\u559D\u70ED\u6C34w");
		txtAdvice.setBounds(389, 129, 278, 245);
		txtAdvice.setVisible(false);
		
		textMessage = new Text(shell, SWT.BORDER);
		textMessage.setText("\u5386\u53F2\u6D88\u606F");
		textMessage.setEditable(false);
		textMessage.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		textMessage.setBounds(389, 129, 278, 245);
		textMessage.setVisible(false);
		
		textSendMessage = new Text(shell, SWT.BORDER);
		textSendMessage.setBounds(387, 397, 215, 57);
		textSendMessage.setVisible(false);
		
		Button btnSend = new Button(shell, SWT.NONE);
		btnSend.setBounds(608, 397, 59, 57);
		btnSend.setText("\u53D1\u9001");
		btnSend.setVisible(false);
		
		DateTime dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.setBounds(389, 244, 135, 33);
		dateTime.setVisible(false);
		
		Button btnSubmit = new Button(shell, SWT.NONE);
		btnSubmit.setBounds(544, 244, 114, 34);
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
				MessageBox messageBox = new MessageBox(shell);
				messageBox.setMessage("ÆÀ·Ö³É¹¦");
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
				lblAddress.setVisible(true);
				txtAdvice.setVisible(false);
				textMessage.setVisible(false);
				textSendMessage.setVisible(false);
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
				lblAddress.setVisible(false);
				txtAdvice.setVisible(true);
				textMessage.setVisible(false);
				textSendMessage.setVisible(false);
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
				lblAddress.setVisible(false);
				txtAdvice.setVisible(false);
				textMessage.setVisible(true);
				textSendMessage.setVisible(true);
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
				lblAddress.setVisible(false);
				txtAdvice.setVisible(false);
				textMessage.setVisible(false);
				textSendMessage.setVisible(false);
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
				lblAddress.setVisible(false);
				txtAdvice.setVisible(false);
				textMessage.setVisible(false);
				textSendMessage.setVisible(false);
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
