package doc;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;

import java.awt.Toolkit;
import java.util.*;
import com.ibm.icu.text.SimpleDateFormat;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;

//import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
//import org.eclipse.swt.events.SelectionEvent;

public class DocMain {

	protected Shell shlMain;
	protected Display display;
	
	/*
	public DocMain(DocSignIn signIn) {
		this.mobile = signIn.text_Mobile.getText();
	}
	*/

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DocMain window = new DocMain();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DocMain() {
		
	}
	
	public DocMain(String docName) {
		this.docName = docName;
	}

	/**
	 * Open the window.
	 */
	public void open() {
		display = Display.getDefault();
		createContents();
		shlMain.open();
		shlMain.layout();
		while (!shlMain.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMain = new Shell();
		shlMain.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shlMain.setSize(800, 600);
		shlMain.setText("\u9AD8\u8840\u538B\u793E\u533A\u7BA1\u7406\u7CFB\u7EDF");
		
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int x = (screenWidth - 800) / 2;
		int y = (screenHeight - 600) / 2;
		shlMain.setLocation(x, y);
		
		Label lblWelcome = new Label(shlMain, SWT.NONE);
		lblWelcome.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblWelcome.setBounds(200, 240, 90, 24);
		lblWelcome.setText("\u6B22\u8FCE\u767B\u5F55\uFF0C");
		
		Label lblDoctorsName = new Label(shlMain, SWT.NONE);
		lblDoctorsName.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblDoctorsName.setBounds(306, 240, 136, 24);
		lblDoctorsName.setText(docName);
		
		Menu menu = new Menu(shlMain, SWT.BAR);
		shlMain.setMenuBar(menu);
		
		MenuItem menuPatient = new MenuItem(menu, SWT.CASCADE);
		menuPatient.setText("\u60A3\u8005\u4FE1\u606F");
		
		Menu menu_Patient = new Menu(menuPatient);
		menuPatient.setMenu(menu_Patient);
		
		MenuItem menuName = new MenuItem(menu_Patient, SWT.CASCADE);
		menuName.setText("\u60A3\u8005\u59D3\u540D");
		
		Menu menu_Name = new Menu(menuName);
		menuName.setMenu(menu_Name);
		
		MenuItem menuSample1 = new MenuItem(menu_Name, SWT.NONE);
		menuSample1.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				display.close();
				PatInfo.main(null);
			}
		});
		menuSample1.setText("Sample1");
		
		MenuItem menuSchedule = new MenuItem(menu, SWT.CASCADE);
		menuSchedule.setText("\u65E5\u7A0B\u5B89\u6392");
		
		Menu menu_Schedule = new Menu(menuSchedule);
		menuSchedule.setMenu(menu_Schedule);
		
		MenuItem menuArrangement = new MenuItem(menu_Schedule, SWT.NONE);
		menuArrangement.setText("\u4E00\u5468\u5B89\u6392");
		
		MenuItem menuReservation = new MenuItem(menu_Schedule, SWT.NONE);
		menuReservation.setText("\u9884\u7EA6\u60C5\u51B5");
		
		MenuItem menuSetting = new MenuItem(menu, SWT.CASCADE);
		menuSetting.setText("\u8BBE\u7F6E");
		
		Menu menu_Setting = new Menu(menuSetting);
		menuSetting.setMenu(menu_Setting);
		
		MenuItem menuSelfInfo = new MenuItem(menu_Setting, SWT.NONE);
		menuSelfInfo.setText("\u4E2A\u4EBA\u4FE1\u606F");
		
		MenuItem menuHomePage = new MenuItem(menu_Setting, SWT.NONE);
		menuHomePage.setText("\u4E3B\u9875\u8D44\u6599");
		
		MenuItem menuAbout = new MenuItem(menu, SWT.CASCADE);
		menuAbout.setText("\u5173\u4E8E");
		
		Menu menu_About = new Menu(menuAbout);
		menuAbout.setMenu(menu_About);
		
		MenuItem menuCopyright = new MenuItem(menu_About, SWT.NONE);
		menuCopyright.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageBox messageBox = new MessageBox(shlMain);
				messageBox.setMessage("Copyright\u00A9 Hael Chan(Chen Haoliang) from College of Biomedical Engineering & Instrument Science,Zhejiang University, 2017");
				messageBox.open();
				
			}
		});
		menuCopyright.setText("\u7248\u6743\u4FE1\u606F");
		
		MenuItem menuExit = new MenuItem(menu_About, SWT.NONE);
		menuExit.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				display.close();
			}
		});
		menuExit.setText("\u9000\u51FA\u7CFB\u7EDF");
		
		/*
		 * Our teacher asks us to import the Java.util,
		 * however, I don't know what to do.So I just write  
		 * a clock widget to display the current time.
		 * Reference link:
		 * http://blog.csdn.net/szu_lzz/article/details/47857741
		 */
		
		/*
		org.eclipse.swt.widgets.Label date = new org.eclipse.swt.widgets.Label(shlMain, SWT.NONE);	
		date.setBounds(440, 240, 286, 24);
		date.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		
		new Thread(){
			public void run() {
				while(true){
					try {
						date.getDisplay().asyncExec(new Runnable() {
							
							@Override
							public void run() {
								
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								String s = sdf.format(new Date());
								date.setText(s);
								
							}
						});
						Thread.sleep(1000);
					} catch (Exception e) {
					}
				}
			}
		}.start();
		*/

	}
}
