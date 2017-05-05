package ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import experi.dao.DoctorDao;
import experi.entity.Doctor;

import java.awt.Toolkit;

import javax.xml.soap.Text;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

public class Login {

	protected Shell shell;
	protected Display display;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Login window = new Login();
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
		
		/*
		 * Set the window to the center of the screen
		 */
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int x = (screenWidth - 800) / 2;
		int y = (screenHeight - 600) / 2;
		shell.setText("\u8D77\u59CB\u9875");
		shell.setLocation(x, y);
		
		Group group = new Group(shell, SWT.NONE);
		group.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		group.setText("\u89D2\u8272\u9009\u62E9");
		group.setBounds(148, 120, 468, 247);
		
		Button btnDoc = new Button(group, SWT.RADIO);
		btnDoc.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		btnDoc.setBounds(57, 125, 141, 24);
		btnDoc.setText("\u793E\u533A\u533B\u751F");
		
		Button btnPat = new Button(group, SWT.RADIO);
		btnPat.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		btnPat.setBounds(283, 125, 141, 24);
		btnPat.setText("\u9AD8\u8840\u538B\u60A3\u8005");
		
		Button btnSignIn = new Button(shell, SWT.NONE);
		btnSignIn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(btnDoc.getSelection()){
					display.close();
					doc.DocSignIn.main(null);
				}
				else if (btnPat.getSelection()){
					display.close();
					pat.PatSignIn.main(null);
				}
			}
		});
		btnSignIn.setBounds(185, 412, 114, 34);
		btnSignIn.setText("\u767B\u5F55");
		btnSignIn.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		
		Button btnSignUp = new Button(shell, SWT.NONE);
		btnSignUp.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(btnDoc.getSelection()){
					display.close();
					doc.DocSignUp.main(null);
				}
				else if (btnPat.getSelection()){
					display.close();
					pat.PatSignUp.main(null);
				}
			}
		});
		btnSignUp.setBounds(470, 412, 114, 34);
		btnSignUp.setText("\u6CE8\u518C");
		
		Label lblLogo = new Label(shell, SWT.NONE);
		lblLogo.setFont(SWTResourceManager.getFont("幼圆", 25, SWT.BOLD));
		lblLogo.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblLogo.setBounds(148, 41, 468, 73);
		lblLogo.setText("\u9AD8\u8840\u538B\u793E\u533A\u7BA1\u7406\u7CFB\u7EDF");
		
		
	}
	
	

}
