package pat;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import experi.dao.PatientDao;
import experi.entity.Patient;

import java.awt.Toolkit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class DocList {

	protected Shell shell;
	protected Display display;

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
		shell.setText("\u533B\u751F\u4E00\u89C8");
		
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int x = (screenWidth - 800) / 2;
		int y = (screenHeight - 600) / 2;
		shell.setLocation(x, y);
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(151, 101, 97, 32);
		
		Label lblDoc = new Label(shell, SWT.NONE);
		lblDoc.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblDoc.setBounds(64, 104, 59, 24);
		lblDoc.setText("\u533B\u751F");
		
		Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.setBounds(427, 84, 142, 200);
		
		Button btnLink = new Button(shell, SWT.NONE);
		btnLink.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String id = "1";
				PatientDao dao = new PatientDao();
				dao.updatePatient(new Patient(id, null, null, null), "1");
			}
		});
		btnLink.setBounds(432, 445, 130, 34);
		btnLink.setText("\u5173\u8054/\u53D6\u6D88\u5173\u8054");
		
		Button btnBack = new Button(shell, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				display.close();
				PatMain.main(null);
			}
		});
		btnBack.setBounds(640, 484, 97, 34);
		btnBack.setText("\u8FD4\u56DE");
		
		Label lblName = new Label(shell, SWT.NONE);
		lblName.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		lblName.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblName.setBounds(427, 318, 149, 34);
		lblName.setText("Doc'sName");
		
		

	}
}
