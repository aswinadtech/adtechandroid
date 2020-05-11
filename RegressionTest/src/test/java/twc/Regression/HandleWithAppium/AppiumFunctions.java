package twc.Regression.HandleWithAppium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




//import twc.Automation.RetryAnalyzer.RetryAnalyzer;
import twc.Regression.Driver.Drivers;
import twc.Regression.ReadDataFromFile.read_excel_data;
import twc.Regression.utils.ReadExcelData;
import twc.Regression.General.DeviceStatus;
import twc.Regression.HandleWithCharles.CharlesFunctions;

public class AppiumFunctions extends Drivers{
	static int startY;
	static int endY;
	
//	public static void verifyAdPresentOnExtendedPage(String excel_sheet_name) throws Exception{
//		DeviceStatus device_status = new DeviceStatus();
//		int Cap = device_status.Device_Status();
//
//		//hourly/daily/map/news
//		//String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);  
//
//		
//		String[][] excelData=ReadExcelData.getExcelData("Excel_Sheet/TWC_CustParam_Framework.xls", excel_sheet_name);
//
//		String module_name = null;
//		String module_locator = null;
//		String Ad_holder = null;
//		
//		 for (int i = 0; i < excelData.length; i++){
//			if(excelData[i][0].equalsIgnoreCase("module_name")){
//				module_name = excelData[i][2];
//			}else if(excelData[i][0].equalsIgnoreCase("module_locator")){
//				module_locator = excelData[i][2];
//			}else if(excelData[i][0].equalsIgnoreCase("Ad_holder")){
//				Ad_holder = excelData[i][2];
//			}
//		 }
//		
//
////######
//
//		System.out.println("Searching for "+module_name+" module"); //exceldata[1][Cap]
//		logStep("Searching For "+module_name+" Module");  //exceldata[1][Cap]
//		MobileElement extendModuleValidate = (MobileElement) Ad.findElementById(module_locator);//exceldata[4][Cap]
//		if(extendModuleValidate.isDisplayed() )
//		{
//			System.out.println("On Extended "+module_name+" page");//exceldata[1][Cap]
//			WebDriverWait wait1 = new WebDriverWait(Ad, 10);
//			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(Ad_holder)));//exceldata[7][Cap]
//			MobileElement AdEle =(MobileElement) Ad.findElementById(Ad_holder); //exceldata[7][Cap]
//			if (AdEle.isDisplayed()) {
//				logStep("Ad is Present on Extended "+module_name+" Page"); //exceldata[1][Cap]
//				System.out.println("Ad is present on Extended page");
//			
//				Thread.sleep(2000);
//				
//			}
//		}
//	}
	
	public static void verifyAdPresentOnExtendedPage(String excel_sheet_name) throws Exception{

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		//hourly/daily/map/news
		//String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);  


		String[][] excelData=ReadExcelData.getExcelData("Excel_Sheet/TWC_CustParam_Framework.xls", excel_sheet_name);
		
				String module_name = null;
				String module_locator = null;
				String Ad_holder = null;
				String scrollCount = null;
				String module_title = null;
				String module_link = null;
				String extendedPage_title = null;
				String backArrow = null;
				
				
				 for (int i = 0; i < excelData.length; i++){
					if(excelData[i][0].equalsIgnoreCase("module_name")){
						module_name = excelData[i][2];
					}else if(excelData[i][0].equalsIgnoreCase("scrollCount")){
						scrollCount = excelData[i][2];
					}else if(excelData[i][0].equalsIgnoreCase("module_locator")){
						module_locator = excelData[i][2];
					}else if(excelData[i][0].equalsIgnoreCase("module_title")){
						module_title = excelData[i][2];
					}else if(excelData[i][0].equalsIgnoreCase("module_link")){
						module_link = excelData[i][2];
					}else if(excelData[i][0].equalsIgnoreCase("extendedPage_title")){
						extendedPage_title = excelData[i][2];
					}else if(excelData[i][0].equalsIgnoreCase("Ad_holder")){
						Ad_holder = excelData[i][2];
					}else if(excelData[i][0].equalsIgnoreCase("backArrow")){
						backArrow = excelData[i][2];
					}
				 }
				
		
		try{
		
									MobileElement extendModule = (MobileElement) Ad.findElementById(extendedPage_title);   //exceldata[6][Cap]
							if(module_name.equalsIgnoreCase("Radar & Maps")){
									if(extendModule.isDisplayed() )
									{
										MobileElement extendModuleValidate = (MobileElement) Ad.findElementById(module_locator);//exceldata[4][Cap]
										if(extendModuleValidate.isDisplayed() )
										{
											System.out.println("On Extended "+module_name+" page");
											WebDriverWait wait1 = new WebDriverWait(Ad, 10);
											wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(Ad_holder)));//exceldata[7][Cap]
											MobileElement AdEle =(MobileElement) Ad.findElementById(Ad_holder); //exceldata[7][Cap]
											if (AdEle.isDisplayed()) {
												logStep("Ad is Present on Extended "+module_name+" Page");
												System.out.println("Ad is present on Extended page");
												//RetryAnalyzer.count=0;
												Thread.sleep(2000);
												//Ad.findElementByClassName(exceldata[10][Cap]).click();//click on back arrow
												//break;
											}
										}
									}	
							}	
							
							
							
							else {
								if(extendModule.isDisplayed() && extendModule.getText().contains(module_name) )
								{
									System.out.println("On Extended "+module_name+" page");
									WebDriverWait wait1 = new WebDriverWait(Ad, 10);
									wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(Ad_holder)));//exceldata[7][Cap]
									MobileElement AdEle =(MobileElement) Ad.findElementById(Ad_holder); //exceldata[7][Cap]
									if (AdEle.isDisplayed()) {
										logStep("Ad is Present on Extended "+module_name+" Page");
										System.out.println("Ad is present on Extended page");
										//RetryAnalyzer.count=0;
										Thread.sleep(2000);
										//Ad.findElementByClassName(exceldata[10][Cap]).click();//click on back arrow
										//break;
									}
								}
							}
						
					
				
		} catch (Exception e) {
			//System.out.println(e);
			System.out.println(module_name + " module is not present and so scrolling down");
			 Swipe();	
		}


}
	

	public static void navigateToModule(String module, String excel_workbook_name, String excel_sheet_name) throws Exception{
		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();
		
		
		
		//String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);  
		String[][] excelData=ReadExcelData.getExcelData(excel_workbook_name, excel_sheet_name);

		String module_name = null;
		String module_title = null;
		String module_link = null;
		
		 for (int i = 0; i < excelData.length; i++){
			if(excelData[i][0].equalsIgnoreCase("module_name")){
				module_name = excelData[i][2];
			}else if(excelData[i][0].equalsIgnoreCase("module_title")){
				module_title = excelData[i][2];
			}else if(excelData[i][0].equalsIgnoreCase("module_link")){
				module_link = excelData[i][2];
			}
		 }
		
		
		
		
		System.out.println("Searching for "+module+" module"); 
		logStep("Searching For "+module_name+" Module");  //excelData[1][Cap]         
		Ad.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		for(int i = 0; i<16; i++){
			try {
				MobileElement module2 = (MobileElement)Ad.findElement(By.id(module_title));	//excelData[32][Cap]
				System.out.println("Navigated to "+ module+ "module");
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				AppiumFunctions.Swipe();
				System.out.println(module+" module not found so swiping");
			} 
		}
	}
	
	
	public static void Swipe_Up(){
		Dimension dimensions = Ad.manage().window().getSize();
		Double startY1 = dimensions.getHeight() * 0.7;  
		startY = startY1.intValue();
		Double endY1 = (double) (dimensions.getHeight()/6);  //  dimensions.getHeight()  0.2;  == 512.0
		endY = endY1.intValue();
		System.out.println("endY  - "+endY);
		System.out.println("startY  - "+startY);
		//Ad.swipe(10, endY, 80, startY,2000);
		Ad.swipe(10, endY, 80, startY,2000);
	}
	
	//SCROLL DOWN
		public static void scroll_Up() throws Exception{
			//Scroll JS
			JavascriptExecutor js = (JavascriptExecutor) Ad ;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "up");
			js.executeScript("mobile: scroll", scrollObject);
		}
	
	public static void Pull_To_Refresh(String excel_sheet_name) throws Exception{
		logStep("On CC Screen Do A Pull To Refresh");
		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();
		
		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
		System.out.println("Pull the screen to REFRESH is Start");
		
		WebDriverWait wait = new WebDriverWait(Ad, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(exceldata[1][Cap])));

		//Temperature element
		MobileElement temp = (MobileElement) Ad.findElementById(exceldata[1][Cap]);
		System.out.println("Temp : "+temp.getText());

//		//HILO element
//		MobileElement hilo = (MobileElement) Ad.findElementById(exceldata[18][Cap]);
//		System.out.println("hilo : "+hilo.getText());
		
		//added by ravi
		MobileElement videoTile = (MobileElement) Ad.findElementById(exceldata[18][Cap]);
		System.out.println("videoTile : "+videoTile.getText());
		
		//hilo.get
		TouchAction action = new TouchAction(Ad);
		//action.longPress(temp).moveTo(2, 400).release().perform();
		Dimension dimensions = Ad.manage().window().getSize();
		Double startY = (double) dimensions.getHeight();
		Double startX = (double) dimensions.getWidth();
		System.out.println("StartX :"+startX+"startY"+startY);
		action.longPress(temp).moveTo(videoTile).release().perform();//not reliable
		//action.longPress(temp).moveTo(450, 250).release().perform();
		//action.longPress(temp).moveTo(80, 250).release().perform();
		//.moveTo(2,400).release().perform();
		Thread.sleep(3000);
		System.out.println("Pull the screen to REFRESH is done");
	}

//ravi
	public static void clickOnModule(String excel_sheet_name) throws Exception{
		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		//hourly/daily/map/news
		//String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);  

		
		
		 
				String[][] excelData=ReadExcelData.getExcelData("Excel_Sheet/TWC_CustParam_Framework.xls", excel_sheet_name);

				String module_name = null;
				String module_title = null;
				String module_link = null;
				
				 for (int i = 0; i < excelData.length; i++){
					if(excelData[i][0].equalsIgnoreCase("module_name")){
						module_name = excelData[i][2];
					}else if(excelData[i][0].equalsIgnoreCase("module_title")){
						module_title = excelData[i][2];
					}else if(excelData[i][0].equalsIgnoreCase("module_link")){
						module_link = excelData[i][2];
					}
				 }
				
				
		
		

		System.out.println("Clicking on =====>>>"+module_name+" module"); //exceldata[1][Cap]
		logStep("Clicking on =====>>>"+excelData[1][Cap]+" Module");           

		
		try {
			MobileElement module2 = (MobileElement)Ad.findElement(By.id(module_link));	//exceldata[11][Cap]
			module2.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			AppiumFunctions.Swipe();
			MobileElement module2 = (MobileElement)Ad.findElement(By.id(module_link));	//exceldata[11][Cap]
			module2.click();
		} 
	
	}
	
//ravi
public static void scrollInToView(String excel_sheet_name) throws Exception{
		
		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		//hourly/daily/map/news
		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);  
		

		System.out.println("Searching for "+exceldata[1][Cap]+" module"); 
		logStep("Searching For "+exceldata[1][Cap]+" Module");           

		int swipe = Integer.parseInt(exceldata[2][Cap].trim());
		System.out.println("swipe count"+swipe);
		Ad.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		System.out.println("@@@@@@@@@@@@@ s");
		MobileElement module;
		int MAX_SWIPES = swipe;
		for (int i = 0; i < MAX_SWIPES; i++) {

			try {
				module = (MobileElement) Ad.findElementById(exceldata[5][Cap]);
				if(module.getText().equalsIgnoreCase(exceldata[1][Cap])){
					System.out.println(exceldata[1][Cap] + " Module Is Present On Page");
					logStep(exceldata[1][Cap] + " Module Is Present On Page");
					break;
				}
			} catch (Exception e) {
				System.out.println(exceldata[1][Cap] + " module is not present and so scrolling down");
				Swipe();	
			}
		}
	}


public static void Swipe(){
	Dimension dimensions = Ad.manage().window().getSize();//throwing exception
	Double startY1 = dimensions.getHeight() * 0.7;  
	startY = startY1.intValue();
	Double endY1 = (double) (dimensions.getHeight()/40);  //  dimensions.getHeight()  0.2;  == 512.0
	endY = endY1.intValue();
	Ad.swipe(0, startY, 0, endY,2000);
	
}
	
public static void killADB() throws IOException, Exception{
	
	String[] command ={"/usr/bin/killall","-KILL","adb"};
	Runtime.getRuntime().exec(command); 
	String[] command1 ={"/usr/bin/killall","-KILL","-9 adb"}; 
	Runtime.getRuntime().exec(command1);
	Thread.sleep(5000);
	String[] command2 ={"/bin/sh", "-c", "adb start-server"}; 
	Runtime.getRuntime().exec(command2);
	}
	
	public static void UnInstallApp() throws Exception{
		
		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();
		
		String[][] paths = read_excel_data.exceldataread("Paths");
		String adbPath = paths[15][Cap];
		
		//System.out.println("adbPath "+ adbPath);
		
		System.out.println("Uninstall the APP and Installing");
		
		String[] uninstall ={"/bin/bash", "-c",  adbPath+" shell pm uninstall com.weather.Weather"};
		Runtime.getRuntime().exec(uninstall);
		System.out.println("Uninstall completed");
		Thread.sleep(5000);
	}
	
	public static void AppiumServerStop() throws InterruptedException{

		//		String[] command ={"/usr/bin/killall","-KILL","node"};  
		//
		//		try {
		//			Runtime.getRuntime().exec(command);
		//		} catch (IOException e) {
		//			System.out.println("Appium Server Not Yet Killed At This Time");
		//		}  
		String[] command = new String[]{"sh", "-c", "lsof -P | grep ':4726' | awk '{print $2}' | xargs kill -9"};
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(5000);
	}
	
	public static void clearTWCLogs() throws Exception{
		
		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();
		
		String[][] paths = read_excel_data.exceldataread("Paths");
		System.out.println("Clear Logcat Logs for TWC App");	
		String[] clearLogcatdata ={"/bin/bash", "-c",  paths[15][Cap]+" logcat -c"};
		Runtime.getRuntime().exec(clearLogcatdata);	
		Thread.sleep(4000);
	}
	
	public static void AppiumServerStart() throws InterruptedException{
		
		CommandLine command = new CommandLine("/usr/local/bin/node");
		command.addArgument("/Applications/Appium 2.app/Contents/Resources/app/node_modules/appium/build/lib/main.js", false);
		//		CommandLine command = new CommandLine("/Applications/Appium.app/Contents/Resources/node/bin/node");
		//		command.addArgument("/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js", false);


		command.addArgument("--address", false);
		command.addArgument("127.0.0.1");
		command.addArgument("--port", false);
		command.addArgument("4726");	
		command.addArgument("--no-reset", false);
		command.addArgument("--log-level", false);
		command.addArgument("error");

		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(command, resultHandler);
			Thread.sleep(5000);
		} catch (ExecuteException e) {
			System.out.println("Appium Server Not Yet Started");
		} catch (IOException e) {
			System.out.println("Appium Server Not Yet Started");
		}
	}
	
	public static void ReLaunchApp() throws Exception{
		
		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();
		
		clearTWCLogs();
		
		String[][] paths = read_excel_data.exceldataread("Paths");
		String adbPath = paths[15][Cap];
		
		String[] str ={"/bin/bash", "-c", adbPath+" shell pm disable com.weather.Weather"};
		Runtime.getRuntime().exec(str);
		Thread.sleep(2000);
		
		String[] str1 ={"/bin/bash", "-c", adbPath+" shell pm enable com.weather.Weather"};
		Runtime.getRuntime().exec(str1);
		
		Ad.closeApp();
		Ad.launchApp();
	}
	
	@SuppressWarnings("rawtypes")
	public static void LaunchApp() throws InterruptedException, IOException{
			
			//killADB();
			//AppiumServerStop();
			//AppiumServerStart();
			
			DeviceStatus device_status = new DeviceStatus();
			int Cap = device_status.Device_Status();
			
			try {
				
				String[][] capabilitydata = read_excel_data.exceldataread("Capabilities");
				DesiredCapabilities capabilities = new DesiredCapabilities();
				
				/* --- Start Android Device Capabilities --- */
				if(Cap == 2){
				capabilities.setCapability(capabilitydata[1][0], capabilitydata[1][Cap]);
				capabilities.setCapability(capabilitydata[2][0], capabilitydata[2][Cap]); 
				capabilities.setCapability(capabilitydata[3][0], capabilitydata[3][Cap]);
				capabilities.setCapability(capabilitydata[7][0], capabilitydata[7][Cap]); 
				capabilities.setCapability(capabilitydata[9][0], capabilitydata[9][Cap]);
				capabilities.setCapability(capabilitydata[10][0],capabilitydata[10][Cap]);
				capabilities.setCapability(capabilitydata[12][0],capabilitydata[12][Cap]);
				capabilities.setCapability(capabilitydata[13][0],capabilitydata[13][Cap]);
				capabilities.setCapability(capabilitydata[14][0],capabilitydata[14][Cap]);
				Ad = new AndroidDriver(new URL(capabilitydata[15][Cap]), capabilities);
				}
				Thread.sleep(10000);
				clickONNext();
			    ClickonIUnderstand();
				
				/* ---End Android Device Capabilities --- */
				Ad.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				
				System.out.println("Capabilities have been launched");
				Thread.sleep(5000);
			} catch (Exception e) {
				System.out.println("Unable To Launch The Appium Capabilities");
			}
			
			
	}
	@SuppressWarnings("rawtypes")
	public static void LaunchAppWithFullReset() throws Exception{
		
	/*	killADB();
		AppiumServerStop();
		AppiumServerStart();*/
		
		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();
		
		try {
			
			String[][] capabilitydata = read_excel_data.exceldataread("Capabilities");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			/* --- Start Android Device Capabilities --- */
			if(Cap == 2){
				capabilities.setCapability(capabilitydata[1][0], capabilitydata[1][Cap]);
				capabilities.setCapability(capabilitydata[2][0], capabilitydata[2][Cap]); 
				capabilities.setCapability(capabilitydata[3][0], capabilitydata[3][Cap]);
				capabilities.setCapability(capabilitydata[7][0], capabilitydata[7][Cap]); 
				//capabilities.setCapability(capabilitydata[9][0], capabilitydata[9][Cap]);
				capabilities.setCapability(capabilitydata[10][0],capabilitydata[10][Cap]);
				capabilities.setCapability(capabilitydata[12][0],capabilitydata[12][Cap]);
			//	capabilities.setCapability("appActivity","com.weather.Weather.splash.SplashScreenActivity");
				//capabilities.setCapability("appActivity","com.weather.android.daybreak.MainActivity");
				//capabilities.setCapability("automationName","UiAutomator2");
				System.out.println("app : "+capabilitydata[10][Cap]);
				capabilities.setCapability(capabilitydata[13][0],capabilitydata[13][Cap]);
				//capabilities.setCapability(capabilitydata[14][0],capabilitydata[14][Cap]);
				
				Thread.sleep(10000);
				
				Ad = new AndroidDriver(new URL(capabilitydata[15][Cap]), capabilities);
				Thread.sleep(30000);
			}
			/* ---End Android Device Capabilities --- */
			Ad.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			//####added ths to handle allow button
			Thread.sleep(10000);
			
        	clickONNext();
		    ClickonIUnderstand();
    		clickOnAllow();
    		System.out.println("Capabilities have been launched  with fullreset ");
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("Unable To Launch The Appium Capabilities");
		}
	}
	public static void clickOnVideoElement() throws Exception{
		System.out.println("clicking video element");
		logStep("clicking video element");
		try {
		Ad.findElementById("com.weather.Weather:id/ok_button").click();	
		Thread.sleep(2000);
		}
		catch(Exception e) {
			try {
			Ad.findElementById("Id com.weather.Weather:id/video_player_thumbnail_extra").click();	
			Thread.sleep(2000);
			}
			catch(Exception e1) {
				Ad.findElementById("com.weather.Weather:id/ok_button").click();	
				Thread.sleep(2000);
			}
		}
		
	}
	public static void clickOnMaps() throws Exception{
		Ad.findElementById("com.weather.Weather:id/ok_button").click();	
		Thread.sleep(3000);	
	}
	public static void clickOnRadarMaps() throws Exception{
		System.out.println("clicking maps element");
		logStep("clicking maps element");
		try {
		Ad.findElementById("com.weather.Weather:id/details_button").click();
		Thread.sleep(2000);		
		}
		catch(Exception e) {
			Ad.findElementById("com.weather.Weather:id/radar_map_image").click();
			Thread.sleep(2000);
		}
	}	
	public static void click_Todaydetails_element() throws Exception
	{
		System.out.println("clicking today element");
		logStep("clicking today element");
		try {
		Ad.findElementById("com.weather.Weather:id/details_button").click();
		Thread.sleep(2000);	
		}
		catch(Exception e) {
			Ad.findElementById("com.weather.Weather:id/today_details_container").click();
			Thread.sleep(2000);
		}	
	}
	public static void clickOnBackArrowElement() throws Exception
	{
		try {
			Ad.findElementByAccessibilityId("Navigate up").click();
			Thread.sleep(2000);
	     
		}
		catch(Exception e) {
			Ad.findElementById("com.weather.Weather:id/fake_toolbar_back_button").click();
		     Thread.sleep(2000);
		}
	}
	
	public static void clickOnBackArrowElement_today() throws Exception
	{
		try {
			Ad.findElementByAccessibilityId("Navigate up").click();
			Thread.sleep(2000);
	     
		}
		catch(Exception e) {
			Ad.findElementById("com.weather.Weather:id/trending_up_navigation_icon").click();
		     Thread.sleep(2000);
		}
	}
	public static void clickONNext() throws Exception{

		try{
			if((Ad.findElementById("com.weather.Weather:id/ok_button").isDisplayed())){
				Ad.findElementById("com.weather.Weather:id/ok_button").click();
				Thread.sleep(2000);
			}
		}catch(Exception e){
			
		}

	}
	public static void clickOnAllow() throws Exception{

		try{
			if((Ad.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button").isDisplayed())){
				Ad.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button").click();
				Thread.sleep(2000);
			}
		}catch(Exception e){
			
		}
		
	}
	public static void clickOnSearch() throws Exception{
	Ad.findElementByAccessibilityId("Search").click();
		Thread.sleep(10000);
	}
	public static void SwipeUp_Counter(int Counter) throws Exception{

		int swipeup = Counter;
	//System.out.println("swipeup");
		for(int i=1;i<=swipeup ;i++){

			Swipe();
			Thread.sleep(5000);
			//Swipe();
		}
	}
	
	public static void click_cold_Flu_element() throws Exception
	{try {
		Ad.findElementByName("Low").click();
		Thread.sleep(3000);
	}
	catch(Exception e) {
		Ad.findElementById("com.weather.Weather:id/index_3_description").click();
		Thread.sleep(3000);

	}
	}
	public static void click_Running_element() throws Exception
	{
		try {
		Ad.findElementByName("Tough run conditions now.").click();
		Thread.sleep(3000);
		}
		catch(Exception e) {
		Ad.findElementById("com.weather.Weather:id/index_1_description").click();
		Thread.sleep(3000);
		}
	}
	public static void click_Boat_Beach_element() throws Exception
	{
		try {
		Ad.findElementByName("Currently High Tide").click();
		Thread.sleep(3000);
		}
		catch(Exception e) {
		Ad.findElementById("com.weather.Weather:id/index_1_description").click();
		Thread.sleep(3000);
		}
	}
	public static void click_Allergy_element() throws Exception
	{
		try {
		Ad.findElementByName("Pollen is high in your area").click();
		Thread.sleep(3000);
		}
		catch(Exception e) {
		Ad.findElementById("com.weather.Weather:id/index_2_description").click();
		Thread.sleep(3000);
		}		
	}
	public static void click_Airpollution_element() throws Exception
	{
		Ad.findElementById("com.weather.Weather:id/air_quality_dial").click();
		Thread.sleep(3000);		
	}
	public static void click_news_element() throws Exception
	{
		Ad.findElementById("com.weather.Weather:id/video_backdrop").click();
		Thread.sleep(3000);		
	}
	public static void click_hourly_element() throws Exception
	{ 
		try {
		
		Ad.findElementByAccessibilityId("Hourly").click();
		Thread.sleep(2000);	
	}
	catch(Exception e) {
		try {
		List<WebElement> home=Ad.findElementsById("com.weather.Weather:id/icon");
		home.get(0).click();
		Thread.sleep(2000);
		System.out.println("clicking hourly deatils");
     	logStep("clicking hourly details element");
		}
		catch(Exception e2) {
			System.out.println("clicking hourly deatils");
	     	logStep("clicking hourly details element");
			List<WebElement> home=Ad.findElementsById("com.weather.Weather:id/icon");
			for(WebElement all:home) {
				if(all.getText().toString().equalsIgnoreCase("Hourly")) {
					all.click();
					Thread.sleep(2000);
				}
			}
		}
	}
	}
	public static void click_home_element() throws Exception
	{ try {
		Ad.findElementById("com.weather.Weather:id/bottom_nav_home_icon").click();
		Thread.sleep(2000);	
	}
	catch(Exception e) {
		List<WebElement> home=Ad.findElementsById("com.weather.Weather:id/icon");
		home.get(2).click();
		Thread.sleep(2000);
		
	}
	}
	
	public static void click_daily_element() throws Exception
	{

		System.out.println("clicking daily deatils");
     	logStep("clicking daily details element");
		try {
		
		Ad.findElementByAccessibilityId("Daily").click();
		Thread.sleep(3000);
			
	}
	catch(Exception e) {
			
	}
	}
	public static void ClickonIUnderstand() throws Exception{
		try{
			if((Ad.findElementById("com.weather.Weather:id/next_button_text").isDisplayed())){
				Ad.findElementById("com.weather.Weather:id/next_button_text").click();
				Thread.sleep(2000);
			}
		}catch(Exception e){
			
		}
}
	
	
	public static void entering_Zip() throws Exception {
		
		Ad.findElementByAccessibilityId("Search").click();
		 CharlesFunctions.ClearSessions();
		Ad.findElementById("com.weather.Weather:id/search_text").sendKeys("10014");
		Ad.findElementById("com.weather.Weather:id/search_item_container").click();		
		 CharlesFunctions.startSessionBrowserData();
          AppiumFunctions.SwipeUp_Counter(1);	
			AppiumFunctions.clickOnVideoElement();
			AppiumFunctions.clickOnBackArrowElement();
			AppiumFunctions.SwipeUp_Counter(2);
			AppiumFunctions.clickOnRadarMaps();
			AppiumFunctions.clickOnBackArrowElement();	
              AppiumFunctions.SwipeUp_Counter(3);					
			AppiumFunctions.click_Todaydetails_element();
			AppiumFunctions.clickOnBackArrowElement_today();
             		AppiumFunctions.SwipeUp_Counter(4);
			//AppiumFunctions.click_Airpollution_element();
			//AppiumFunctions.clickOnBackArrowElement();
			//AppiumFunctions.SwipeUp_Counter(1);
			//AppiumFunctions.click_news_element();
			//AppiumFunctions.clickOnBackArrowElement();
			AppiumFunctions.click_hourly_element();
			AppiumFunctions.click_home_element();
			AppiumFunctions.click_daily_element();
	        Thread.sleep(10000);
	}
}
