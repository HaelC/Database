package pat;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import java.awt.Toolkit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class PatSetting {

	protected Shell shell;
	protected Display display;
	private Text textName;
	private Text textPressure;
	private Text textQQ;

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
		shell.setText("\u4E2A\u4EBA\u4FE1\u606F");
		
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int x = (screenWidth - 800) / 2;
		int y = (screenHeight - 600) / 2;
		shell.setLocation(x, y);
		
		Label lblName = new Label(shell, SWT.NONE);
		lblName.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblName.setBounds(263, 65, 65, 24);
		lblName.setText("\u59D3\u540D");
		
		Label lblPressure = new Label(shell, SWT.NONE);
		lblPressure.setText("\u8840\u538B");
		lblPressure.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblPressure.setBounds(263, 121, 65, 24);
		
		Label lblConcact = new Label(shell, SWT.NONE);
		lblConcact.setText("QQ");
		lblConcact.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblConcact.setBounds(263, 178, 65, 24);
		
		textName = new Text(shell, SWT.BORDER);
		textName.setBounds(345, 59, 113, 30);
		
		textPressure = new Text(shell, SWT.BORDER);
		textPressure.setBounds(345, 115, 113, 30);
		
		textQQ = new Text(shell, SWT.BORDER);
		textQQ.setBounds(345, 172, 113, 30);
		
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
				PatMain.main(null);
			}
		});
		btnBack.setText("\u8FD4\u56DE");
		btnBack.setBounds(380, 428, 90, 34);
		

	}

}
