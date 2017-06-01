package pat;

import java.awt.Toolkit;
//import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

//import com.ibm.icu.text.SimpleDateFormat;

import experi.dao.PatientDao;
import experi.entity.Patient;

import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;

public class PatMain {

	protected Shell shlMain;
	protected Display display;
	protected String pat_mobile;
	private String pat_name;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PatMain window = new PatMain();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public PatMain() {
		
	}
	
	public PatMain(String pat_mobile) {
		this.pat_mobile = pat_mobile;
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
		PatientDao patientDao = new PatientDao();
		Patient patient = patientDao.findByMobile(pat_mobile);
		pat_name = patient.getPat_name();
		
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
		lblDoctorsName.setText(pat_name);
		
		Menu menu = new Menu(shlMain, SWT.BAR);
		shlMain.setMenuBar(menu);
		
		MenuItem menuDoctor = new MenuItem(menu, SWT.CASCADE);
		menuDoctor.setText("\u67E5\u770B\u533B\u751F");
		
		Menu menu_Doctor = new Menu(menuDoctor);
		menuDoctor.setMenu(menu_Doctor);
		
		MenuItem menuDoc = new MenuItem(menu_Doctor, SWT.NONE);
		menuDoc.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if(patient.getDoc_id() == null) {
					//display.close();
					MessageBox messageBox = new MessageBox(shlMain);
					messageBox.setMessage("您未关联主治医师。请前往医生一览页面选择关联主治医师");
					messageBox.open();
				}
				else {
					display.close();
					PatSelfDoc patSelfDoc = new PatSelfDoc(patient.getPat_id());
					patSelfDoc.open();
				}
			}
		});
		menuDoc.setText("\u4E3B\u6CBB\u533B\u751F");
		
		MenuItem menuDocList = new MenuItem(menu_Doctor, SWT.NONE);
		menuDocList.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				display.close();
				//DocList.main(null);
				DocList docList = new DocList(patient.getPat_id());
				docList.open();
			}
		});
		menuDocList.setText("\u533B\u751F\u4E00\u89C8");
		
		MenuItem menuSetting = new MenuItem(menu, SWT.CASCADE);
		menuSetting.setText("\u8BBE\u7F6E");
		
		Menu menu_Setting = new Menu(menuSetting);
		menuSetting.setMenu(menu_Setting);
		
		MenuItem menuSelfInfo = new MenuItem(menu_Setting, SWT.NONE);
		menuSelfInfo.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				display.close();
				//PatSetting.main(null);
				PatSetting patSetting = new PatSetting(patient.getPat_id());
				patSetting.open();
			}
		});
		menuSelfInfo.setText("\u4E2A\u4EBA\u4FE1\u606F");
		
		MenuItem menuUpdatePressure = new MenuItem(menu_Setting, SWT.NONE);
		menuUpdatePressure.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				display.close();
				PatUpdatePressure patUpdatePressure = new PatUpdatePressure(patient.getPat_id());
				patUpdatePressure.open();
			}
		});
		menuUpdatePressure.setText("\u66F4\u65B0\u8840\u538B");
		
		MenuItem menuPassword = new MenuItem(menu_Setting, SWT.NONE);
		menuPassword.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				display.close();
				PatPassword patPassword = new PatPassword(patient.getPat_id());
				patPassword.open();
			}
		});
		menuPassword.setText("\u4FEE\u6539\u5BC6\u7801");
		/*
		MenuItem menuHomePage = new MenuItem(menu_Setting, SWT.NONE);
		menuHomePage.setText("\u4E3B\u9875\u8D44\u6599");
		*/
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
			/*
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			*/
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
