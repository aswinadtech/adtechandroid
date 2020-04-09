package ANDROID_ARMS.ANDROID_ARMS;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import ru.yandex.qatools.allure.annotations.Title;
import twc.Automation.Driver.Drivers;
import twc.Automation.General.DeviceStatus;
import twc.Automation.HandleWithApp.AppFunctions;
import twc.Automation.HandleWithAppium.AppiumFunctions;
import twc.Automation.HandleWithCharles.CharlesFunctions;
import twc.Automation.ReadDataFromFile.read_excel_data;


public class FeedAdVAlidationonUI 
extends Drivers
{
	public static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
	//Validating_feedads_and_detailpageads_fromUI
	@Test(priority =1,enabled = true)
	public void Validating_Home_page_Ad() throws Exception
	{
	    logStep("Validating Home page Ad TestCase Started");
		System.out.println("====== Validating Home page Ad TestCase Started =======");
		//AppFunctions.Kill_Launch_App();
		logStep("Clearing the charles session");
		CharlesFunctions.ClearSessions();
		logStep("Cleared the charles session");
		AppiumFunctions.Check_Home_ad();
		System.out.println("====== Validating Home page Ad TestCase End =======");
		logStep("Validating Home page Ad TestCase End");

	}
		@Test(priority =3,enabled = true)
		@Title("Validating Extended Maps page Ad")
		public void Extended_Deatail_MapsPage_Ad() throws Exception
		{
			System.out.println("====== Validating Extended Deatail MapsPage TestCase Started =======");
			AppFunctions.SwipeUp_Counter(1);
			AppFunctions.click_Mapsdetails_element();				
			logStep("Checking the  Extended Deatail MapsPage ad is presnted or not");
			AppiumFunctions.Check_submodules_Maps_ad();
			//AppFunctions.clickOnBackArrowElement();
			System.out.println("====== Validating Extended Deatail MapsPage Ad TestCase End =======");    
		}
		//Validating Radar&Maps feed card
		@Test(priority =4,enabled = true)
		@Title("Validating Radar&Maps feed card Ad")
		public void Validating_Radar_Maps_feed__card() throws Exception
		{
			logStep("Validating Radar&Maps Ad TestCase Started");
			System.out.println("====== Validating Radar&Maps Ad TestCase Started =======");
			//scroll app to feed_2
			logStep("Scroll the App to Radar&Maps feed card");
			AppiumFunctions.Check_feed2_ad();
			System.out.println("====== Validating Radar&Maps feed card TestCase End =======");
		}
                              //Validating  Dailyforecast feed card
				@Test(priority =2,enabled = true)
				@Title("Validating Daily feed card Ad")
				public void Validating_Dailyforecast_feed__card() throws Exception
				{
					logStep("Validating Dailyforecast Ad TestCase Started");
					System.out.println("====== Validating Dailyforecast Ad TestCase Started =======");
					//scrolled app till Dailyforecast feed
					
                                       AppFunctions.Swipeforappdeckapk();
                                       AppFunctions.SwipeUp_Counter(1);	
			
					logStep("Scroll the App to  Dailyforecast  feed card");
					AppiumFunctions.Check_dailyforecast_feedad();
					System.out.println("====== Validating Dailyforecast feed card TestCase End =======");
				}

		/*@Test(priority =6,enabled = true)
		@Title("Validating Extended Today page Ad")
		public void Extended_Today_datailpage_Ad() throws Exception
		{
			System.out.println("====== Validating Extended today datail page testCase Started =======");
			//AppFunctions.Kill_Launch_App();
			AppFunctions.SwipeUp_Counter(1);
			AppFunctions.click_Todaydetails_element();			
			logStep("Checking the  Extended today datail page ad is presnted or not");
			AppiumFunctions.Check_submodules_Today_ad();
			AppFunctions.clickOnBackArrowElement_trending();
			System.out.println("====== Validating Extended today datail page Ad TestCase End =======");    
		}*/

             
		@Test(priority =5,enabled = true)
		@Title("Validating Health_and_Activities feed Ad")
		public void Validating_Health_and_Activities_feed__card() throws Exception
		{
			System.out.println("====== Validating Health and Activities feed card testCase Started =======");
			//AppFunctions.Kill_Launch_App();
			 AppFunctions.Swipeforappdeckapk();
			AppFunctions.SwipeUp_Counter(4);		
			logStep("Checking the  Health and Activities feed card ad is presnted or not");
			AppiumFunctions.Check_Health_and_Activities_feedad();
			System.out.println("====== Validating Health and Activities feed card testCase End =======");    
		}
		//Validating Health&Activities Module page Ads
		//Validating Boat&Beach Module page Ad
		   /* @Test(priority =7,enabled = true)
			@Title("Validating Extended Boat&Beach page Ad")
			public void Extended_Boat_beach_Ad() throws Exception
			{
				System.out.println("====== Validating Extended Boat&Beach page Ad TestCase Started =======");
				//AppFunctions.SwipeUp_Counter(1);	
				AppFunctions.click_Boat_Beach_element();
				AppFunctions.SwipeUp_Counter(3);
				logStep("Checking the boatbeach bb ad is presnted or not");
				AppiumFunctions.Check_boatbeach_bb_ad();
				//AppFunctions.clickOnBackArrowElement();
				System.out.println("====== Validating Extended Boat&Beach page Ad TestCase End =======");    
			}*/
			        //Validating Running Module page Ad
				/*	@Test(priority =9,enabled = true)
					@Title("Validating Extended Running page Ad")
					public void Extended_Runningpage_Ad() throws Exception
					{
						System.out.println("====== Validating Extended Running page Ad TestCase Started =======");
						//AppFunctions.SwipeUp_Counter(1);		
						AppFunctions.click_Running_element();
						AppFunctions.SwipeUp_Counter(3);
						logStep("Checking the Running bb ad is presnted or not");
						AppiumFunctions.Check_Running_bb_ad();
						//AppFunctions.clickOnBackArrowElement();
						System.out.println("====== Validating Extended Running page Ad TestCase End =======");    
					}
					//Validating Cold_flu Module page Ad
					@Test(priority =11,enabled = true)
		
					@Title("Validating Extended Cold_flu page Ad")
					public void Extended_ColdFlu_Ad() throws Exception
					{
					   
						System.out.println("====== Validating Extended Cold_flu page Ad TestCase Started =======");
						//AppFunctions.SwipeUp_Counter(1);
                                                AppFunctions.click_cold_Flu_element();
						AppFunctions.SwipeUp_Counter(1);
						logStep("Checking the ColdFlu bb ad is presnted or not");
						AppiumFunctions.Check_ColdFlu_bb_ad();
						//AppFunctions.clickOnBackArrowElement();
						System.out.println("====== Validating Extended Cold_flu page Ad TestCase End =======");    
					}*/
					//Validating Allergy Module page Ad
					/*@Test(priority =10,enabled = true)
					@Title("Validating Extended Allergy page Ad")
					public void Extended_Allergy_Ad() throws Exception
					{
						System.out.println("====== Validating Extended Allergy page Ad TestCase Started =======");					
						//AppFunctions.SwipeUp_Counter(1);
						AppFunctions.click_Allergy_element();
						AppFunctions.SwipeUp_Counter(3);
						logStep("Checking the Allergy bb ad is presnted or not");
						AppiumFunctions.Check_Allergy_bb_ad();
						//AppFunctions.clickOnBackArrowElement();
						System.out.println("====== Validating Extended Allergy page Ad TestCase End =======");    
					}*/
                                         @Test(priority =13,enabled = true)
					@Title("Validating SeasonalHub feed Ad")
					public void Validating_seasonalhub_feed__card() throws Exception
					{
						System.out.println("====== Validating SeasonalHub feed card testCase Started =======");
						//AppFunctions.Kill_Launch_App();
						AppFunctions.SwipeUp_Counter(1);		
						logStep("Checking the  SeasonalHub feed card ad is presnted or not");
						AppiumFunctions. Check_seasonalhub_feedad();
						System.out.println("====== Validating SeasonalHub feed  card testCase End =======");    
					}
	


	
	
	/*@Test(priority =11,enabled = true)
	@Title("Validating Extended Airpollution page Ad")
	public void Extended_Deatail_Airpollution_Ad() throws Exception
	{
		System.out.println("====== Validating Extended Deatail Airpollution TestCase Started =======");
		AppFunctions.SwipeUp_Counter(1);
		AppFunctions.click_Airpollution_element();				
		logStep("Checking the  Extended Deatail Airpollution ad is presnted or not");
		AppiumFunctions.Check_submodules_Airpollution_ad();
		//AppFunctions.clickOnBackArrowElement();
		System.out.println("====== Validating Extended Deatail Airpollution Ad TestCase End =======");    
	}*/
	// Validating Air Pollution feed card
		@Test(priority =12,enabled = true)
		@Title("Validating  Airpollution feed card")
		public void Validating_Airpollution_feed_card() throws Exception
		{
			logStep("Validating the Airpollution_feed_card TestCase");
			System.out.println("======= Validating Airpollution_feed_card Ad TestCase Started =======");
			//Scroll the app to feed_2 ad
			logStep("scrolling the app till Airpollution_feed_card");
			AppFunctions.SwipeUp_Counter(2);
			//checking the feed_1 ad is coming or not
			logStep("Checking the Airpollution_feed_card is presnted or not");
			AppiumFunctions.Check_Airpollution_feedcard();
		    System.out.println("====== Validating Airpollution_feed_card TestCase End =========");
		}
	@Test(priority =14,enabled = true)
	@Title("Validating Extended News page Ad")
	public void Extended_Detailed_NewsPage_Ad() throws Exception
	{
		System.out.println("====== Validating Extended Deatail news page TestCase Started =======");
		AppFunctions.SwipeUp_Counter(1);
		AppFunctions.click_news_element();				
		logStep("Checking the  Extended Deatail News Page ad is presnted or not");
		//AppiumFunctions.Check_submodules_news_ad();
	   AppFunctions.clickOnBackArrowElement();
		System.out.println("====== Validating Extended Deatailnews page Ad TestCase End =======");    
	}
	//Validating Extended hourly page Ad
			@Test(priority =15,enabled = true)
			@Title("Validating Extended hourly page Ad")
			public void Extended_hourly_page_Ad() throws Exception
			{
				System.out.println("====== Validating Extended Hourly page Ad TestCase Started =======");
				AppFunctions.click_hourly_element();
				logStep("Checking the hourly ad is presnted or not");
			//	AppiumFunctions.Check_submodules_Hourly_ad(); 		
				AppFunctions.click_home_element(); 
				System.out.println("====== Validating Extended Hourly page Ad TestCase End =======");

			}

			//Validating Extended Daily page Ad
		      /* @Test(priority =16,enabled = true)
			@Title("Validating Extended Daily page Ad")
			public void Extended_Daily_page_Ad() throws Exception
			{
				System.out.println("====== Validating Extended Daily page Ad TestCase Started =======");
				//AppFunctions.click_daily_element();
				logStep("Checking the daily ad is presnted or not");
				AppiumFunctions.Check_submodules_Daily_ad();
				//AppFunctions.click_home_element(); 
				System.out.println("====== Validating Extended Daily page Ad TestCase End =======");    
			}*/

			//Validating Extended Maps&Radar page Ad
			@Test(priority =17,enabled = true)
			@Title("Validating Extended Maps&Radar page Ad")
			public void Extended_Maps_Radar_page_Ad() throws Exception
			{
				System.out.println("====== Validating Extended Maps&Radar page Ad TestCase Started =======");
				//AppFunctions.click_radar_element();
				AppFunctions.click_daily_element();
				logStep("Checking the Radar ad is presnted or not");
				AppiumFunctions.Check_submodules_Mapps_ad();
				//AppFunctions.click_home_element();
				System.out.println("====== Validating Extended Maps&Radar page Ad TestCase End =======");    

			}
	/*//Validating feed1 Ad
	    @Test(priority =1,enabled = true)
		@Title("Validating feed_1 Ad call")
		public void Validating_feed1() throws Exception
		{
	    	    logStep("Validating the feed_1 testcase");
			System.out.println("======= Validating feed_1 Ad TestCase Started =======");
			logStep("Clearing the charles session");
		 	CharlesFunctions.ClearSessions();
		 	logStep("Cleared the charles session");
			//Launch the App
			//AppiumFunctions.LaunchApp();
		 	logStep("Wait till app was launched");
			Thread.sleep(5000);
			//select the location 
			logStep("set the location on the app");
			AppiumFunctions.selectlocation();						
			Thread.sleep(5000);
			//Scroll the app to feed_1 ad
			logStep("Scrolling the app to  feed_1");
			AppFunctions.SwipeUp_Counter(2);
			//checking the feed_1 ad is coming or not
			logStep("validating the feed_1 ad");
			//AppiumFunctions.Check_feed1_ad();
			System.out.println("====== Validating feed_1 Ad TestCase End =========");
		}
		//Validating feed_2 Ad
			@Test(priority =2,enabled = true)
			@Title("Validating feed_2 Ad call")
			public void Validating_feed2() throws Exception
			{
				logStep("Validating feed_2 Ad TestCase Started");
				System.out.println("====== Validating feed_2 Ad TestCase Started =======");
				//scroll app to feed_2
				logStep("Scroll the App to feed_2 Ad");
				AppFunctions.SwipeUp_Counter(2);
				//checking the feed_2 ad is coming or not
				//AppiumFunctions.Check_feed2_ad();
				System.out.println("====== Validating feed_2 Ad TestCase End =======");
			}
			//Validating feed_3 Ad
					@Test(priority =3,enabled = true)
					@Title("Validating feed_3 Ad call")
					public void Validating_feed3() throws Exception
					{
						logStep("Validating feed_3 Ad TestCase Started");
						System.out.println("====== Validating feed_3 Ad TestCase Started =======");
						//scroll app to feed_3
						logStep("Scroll the app to feed3 ad");
						AppFunctions.SwipeUp_Counter(1);
						AppFunctions.Swipe_feed3();
						//checking the feed_3 ad is coming or not
						//AppiumFunctions.Check_feed3_ad();
						System.out.println("====== Validating feed_3 Ad TestCase End =======");
					}

					//Validating feed_4 Ad
					@Test(priority =4,enabled = true)
					@Title("Validating feed_4 Ad call")
					public void Validating_feed4() throws Exception
					{
						logStep("Validating feed_4 testcase Started");
						System.out.println("====== Validating feed_4 Ad TestCase Started =======");
						//checking the feed_4 ad is coming or not
						logStep("scroll the app to feed_4");
						AppFunctions.SwipeUp_Counter(2);
					//	AppiumFunctions.Check_feed4_ad();
						System.out.println("====== Validating feed_4 Ad TestCase End =======");
					}

					//Validating feed_5 Ad
					/*@Test(priority =6,enabled = true)
					@Title("Validating feed_5 Ad call")
					public void Validating_feed5() throws Exception
					{	logStep("Validating the feed_5 test case started");
						System.out.println("====== Validating feed_5 Ad TestCase Started =======");
						//checking the feed_5 ad is coming or not
						logStep("scroll the app to feed_5 ad");
						AppFunctions.SwipeUp_Counter(2);
						AppiumFunctions.Check_feed5_ad();
						AppFunctions.Kill_Launch_App();
						System.out.println("====== Validating feed_5 Ad TestCase End =======");
					}*/
	//Validating Extended hourly page Ad
	/*@Test(priority =7,enabled = true)
					@Title("Validating Extended hourly page Ad")
					public void Extended_hourly_page_Ad() throws Exception
					{
						logStep("Validating Extended Hourly page Ad TestCase Started");
						System.out.println("====== Validating Extended Hourly page Ad TestCase Started =======");
						try{
							logStep("kill and launch the app");
							AppFunctions.Kill_Launch_App();
							}
							catch(Exception e)
							{
								logStep("kill and launch the app");
								AppFunctions.Kill_Launch_App();
							}
						//scroll to hourly submodule and checking the hourly submodule ad is coming or not
						logStep("Scroll the app till hourly page");
					//	AppFunctions.SwipeUp_Counter_hourly_submodules();		    
						System.out.println("====== Validating Extended Hourly page Ad TestCase End =======");
					}
					//Validating Extended Daily page Ad
					@Test(priority =8,enabled = true)
					@Title("Validating Extended Daily page Ad")
					public void Extended_Daily_page_Ad() throws Exception
					{
					  logStep("Validating Extended Daily page Ad TestCase Started");
					  System.out.println("====== Validating Extended Daily page Ad TestCase Started =======");
					  //scroll to daily submodule and  checking the Daily submodule  ad is coming or not
					  logStep("Scroll the app till Daily page");
					 // AppFunctions.SwipeUp_Counter_Daily_submodule();
					  System.out.println("====== Validating Extended Daily page Ad TestCase End =======");    
					}
					//Validating Extended Maps&Radar page Ad
					 @Test(priority =9,enabled = true)
					 @Title("Validating Extended Maps&Radar page Ad")
					 public void Extended_Maps_Radar_page_Ad() throws Exception
					{
						 logStep("Validating Extended Maps&Radar page Ad TestCase Started");
						 System.out.println("====== Validating Extended Maps&Radar page Ad TestCase Started =======");
						 logStep("Scroll the app till Maps page");
						 AppFunctions.Kill_Launch_App();
						// AppFunctions.SwipeUp_Counter_Maps_submodule();
						 //AppFunctions.Kill_Launch_App();
						 System.out.println("====== Validating Extended Maps&Radar page Ad TestCase End =======");	    
					}
					 @Test(priority =10,enabled = true)
						@Title("Validating Extended News page Ad")
						public void Extended_News_page_Ad() throws Exception
						{ 
						   logStep("Validating Extended News page Ad TestCase Started");
						   System.out.println("====== Validating Extended News page Ad TestCase Started =======");
						   //scroll to news submodule and checking the News submodule ad is coming or not	
						   logStep("Scroll the app to news Module");
						  AppFunctions.SwipeUp_Counter_news_submodules();	
						   AppiumFunctions.Check_submodules_news_ad();
						  // AppiumFunctions.Clickon_Back_Button();
						   System.out.println("====== Validating Extended News page Ad TestCase End =======");
						}*/


	//Validating cold & flu Ad
/*@Test(priority =11,enabled = true)
						 @Title("Validating Extended cold & flu page Ad")
						 public void Extended_cold_flu_page_Ad() throws Exception
						{
							 System.out.println("====== Validating Extended cold & flu TestCase Started =======");
							 AppFunctions.Kill_Launch_App();
							 AppFunctions.Change_to_Test_Mode("TestMode");
							 AppFunctions.Kill_Launch_App();
							 AppFunctions.Kill_Launch_App();
							 AppFunctions.Kill_Launch_App();
							 AppFunctions.SwipeUp_Counter_lifestyle_submodule();
							 AppFunctions.SwipeUp_Counter(2);
							 AppiumFunctions.Check_Cold_Flu_BigbannertAd();
							 AppiumFunctions.Clickon_Back_Button();
							 System.out.println("====== Validating Extended cold & flu TestCase  page Ad TestCase End =======");	    

						}*/

	//Validating Allergy Ad
	/*@Test(priority =12,enabled = true)
						 @Title("Validating Extended allergy page Ad")
						 public void Extended_HealthModule_page_Ad() throws Exception
						{
							 System.out.println("====== Validating Extended allergy TestCase Started =======");
							 AppiumFunctions.clickallergy();
							 AppiumFunctions.Check_Allergy_spotAd();
							 AppFunctions.SwipeUp_Counter(2);
							AppiumFunctions.Check_Allergy_BigbannerAd();
							 AppiumFunctions.Clickon_Back_Button();
							 System.out.println("====== Validating Extended allergy TestCase End =======");	    
						}*/

	//Validating GoRunAd 
	/*@Test(priority =13,enabled = true)
						 @Title("Validating Extended GoRun page Ad")
						 public void Extended_GoRunhModule_page_Ad() throws Exception
						{
							 System.out.println("====== Validating Extended GoRun TestCase Started =======");
							 AppiumFunctions.clickGoRun();
							 AppiumFunctions.Check_GoRun_spotAd();
							 AppFunctions.SwipeUp_Counter(2);
							 AppiumFunctions.Check_GoRun_BigbannerAd();
							 AppiumFunctions.Clickon_Back_Button();
							 AppFunctions.Kill_Launch_App();
							 AppFunctions.Change_to_Test_Mode("TestMode");
							 System.out.println("====== Validating Extended allergy TestCase End =======");	    
						}*/


	//Validating NativeBB
	/* @Test(priority =13,enabled = true)
	 @Title("Validating NativeBB")
	 public void NativeBB() throws Exception
	{
		 logStep("NativeBB TestCase Started");
		 System.out.println("====== NativeBB TestCase Started =======");
		 logStep("Scroll the app till Maps page");
		 AppFunctions.Change_to_Test_Mode("TestMode");
		 AppFunctions.Kill_Launch_App();
		 AppFunctions.selectlocation_nativeBB();
		 AppiumFunctions.Check_nativeBb();
		 System.out.println("====== NativeBB TestCase End =======");	    
	}*/

	/*@Title("Validating NativeBB")
	@Test(priority =1,enabled = true)
	 public void test() throws Exception
	{	
		//AppFunctions.Change_to_Test_Mode("TestMode");
	     AppFunctions.SwipeUp_Counter(7);
		 AppFunctions.Kill_Launch_App();
	}*/


	@BeforeTest
	public void Before_Test() throws Exception{		
		System.out.println("================= Before Test Started =========================");	
		AppiumFunctions.UnInstallApp();
		CharlesFunctions.charlesOpen();
		AppiumFunctions.CheckBuildFolder(AppiumFunctions.folder);
		CharlesFunctions.openCharlesBrowser();
		AppiumFunctions.delete_screenshots();
		AppiumFunctions.LaunchAppWithFullReset();
		//AppFunctions.Kill_Launch_App();
		System.out.println("================= Before Test End =========================");
	}
	@AfterTest
	public void End_Test() throws Exception
	{
                  AppiumFunctions.downloadXMLFile();
		//CharlesFunctions.StopExportSessionXMLFile();
	//	logStep("Clearing the charles session");
		//CharlesFunctions.ClearSessions();
		
		//Ad.quit();
	}

}

