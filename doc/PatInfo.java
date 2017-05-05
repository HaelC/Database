package doc;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import java.awt.Toolkit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

public class PatInfo {

	protected Shell shell;
	protected Display display;
	private Text textMessage;
	private Text textSendMessage;
	private Text textAdvice;
	private Text textNotes;

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
		lblName.setText("\u60A3\u8005-Name");
		
		Button btnBack = new Button(shell, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				display.close();
				DocMain.main(null);
			}
		});
		btnBack.setBounds(665, 475, 76, 34);
		btnBack.setText("\u8FD4\u56DE");
		
		Label lblAge = new Label(shell, SWT.NONE);
		lblAge.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblAge.setBounds(405, 144, 90, 24);
		lblAge.setText("\u5E74       \u9F84\uFF1A");
		lblAge.setVisible(false);
		
		Label lblSex = new Label(shell, SWT.NONE);
		lblSex.setText("\u6027       \u522B\uFF1A");
		lblSex.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblSex.setBounds(405, 192, 90, 24);
		lblSex.setVisible(false);
		
		Label lblPresssure = new Label(shell, SWT.NONE);
		lblPresssure.setText("\u8840       \u538B\uFF1A");
		lblPresssure.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblPresssure.setBounds(405, 245, 90, 24);
		lblPresssure.setVisible(false);
		
		Label lblDiet = new Label(shell, SWT.NONE);
		lblDiet.setText("\u996E\u98DF\u4E60\u60EF\uFF1A");
		lblDiet.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblDiet.setBounds(405, 299, 90, 24);
		lblDiet.setVisible(false);
		
		Label lblExercise = new Label(shell, SWT.NONE);
		lblExercise.setText("\u5065\u8EAB\u60C5\u51B5");
		lblExercise.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblExercise.setBounds(405, 354, 90, 24);
		lblExercise.setVisible(false);
		
		Combo comboHistory = new Combo(shell, SWT.NONE);
		comboHistory.setBounds(405, 122, 228, 32);
		comboHistory.setVisible(false);
		
		textMessage = new Text(shell, SWT.BORDER);
		textMessage.setText("\u6D88\u606F\u8BB0\u5F55");
		textMessage.setEditable(false);
		textMessage.setBounds(365, 91, 298, 232);
		textMessage.setVisible(false);
		
		textSendMessage = new Text(shell, SWT.BORDER);
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
		
		Button btnInfo = new Button(shell, SWT.NONE);
		btnInfo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblAge.setVisible(true);
				lblDiet.setVisible(true);
				lblExercise.setVisible(true);
				lblPresssure.setVisible(true);
				lblSex.setVisible(true);
				comboHistory.setVisible(false);
				textAdvice.setVisible(false);
				textMessage.setVisible(false);
				textNotes.setVisible(false);
				textSendMessage.setVisible(false);
				btnSend.setVisible(false);
				btnSendAdvice.setVisible(false);
			}
		});
		btnInfo.setBounds(88, 130, 114, 34);
		btnInfo.setText("\u57FA\u672C\u4FE1\u606F");
		
		Button btnHistory = new Button(shell, SWT.NONE);
		btnHistory.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblAge.setVisible(false);
				lblDiet.setVisible(false);
				lblExercise.setVisible(false);
				lblPresssure.setVisible(false);
				lblSex.setVisible(false);
				comboHistory.setVisible(true);
				textAdvice.setVisible(false);
				textMessage.setVisible(false);
				textNotes.setVisible(false);
				textSendMessage.setVisible(false);
				btnSend.setVisible(false);
				btnSendAdvice.setVisible(false);
			}
		});
		btnHistory.setText("\u5386\u6B21\u5C31\u8BCA");
		btnHistory.setBounds(88, 200, 114, 34);
		
		Button btnMessage = new Button(shell, SWT.NONE);
		btnMessage.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblAge.setVisible(false);
				lblDiet.setVisible(false);
				lblExercise.setVisible(false);
				lblPresssure.setVisible(false);
				lblSex.setVisible(false);
				comboHistory.setVisible(false);
				textAdvice.setVisible(false);
				textMessage.setVisible(true);
				textNotes.setVisible(false);
				textSendMessage.setVisible(true);
				btnSend.setVisible(true);
				btnSendAdvice.setVisible(false);
			}
		});
		btnMessage.setText("\u6D88\u606F\u8BB0\u5F55");
		btnMessage.setBounds(88, 270, 114, 34);
		
		Button btnAdvice = new Button(shell, SWT.NONE);
		btnAdvice.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblAge.setVisible(false);
				lblDiet.setVisible(false);
				lblExercise.setVisible(false);
				lblPresssure.setVisible(false);
				lblSex.setVisible(false);
				comboHistory.setVisible(false);
				textAdvice.setVisible(true);
				textMessage.setVisible(false);
				textNotes.setVisible(false);
				textSendMessage.setVisible(false);
				btnSend.setVisible(false);
				btnSendAdvice.setVisible(true);
			}
		});
		btnAdvice.setText("\u533B\u7597\u5EFA\u8BAE");
		btnAdvice.setBounds(88, 340, 114, 34);
		
		Button btnNote = new Button(shell, SWT.NONE);
		btnNote.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblAge.setVisible(false);
				lblDiet.setVisible(false);
				lblExercise.setVisible(false);
				lblPresssure.setVisible(false);
				lblSex.setVisible(false);
				comboHistory.setVisible(false);
				textAdvice.setVisible(false);
				textMessage.setVisible(false);
				textNotes.setVisible(true);
				textSendMessage.setVisible(false);
				btnSend.setVisible(false);
				btnSendAdvice.setVisible(false);
			}
		});
		btnNote.setText("\u5907\u5FD8");
		btnNote.setBounds(88, 410, 114, 34);
		

	}

}
