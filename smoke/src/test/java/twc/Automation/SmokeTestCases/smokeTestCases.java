package twc.Automation.SmokeTestCases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.TemporaryFilesystem;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import twc.Automation.Driver.Drivers;
import twc.Automation.General.DeviceStatus;
import twc.Automation.General.loginModule;
import twc.Automation.HandleMapLocal.MapLocalFunctions;
import twc.Automation.HandleWithApp.AppFunctions;
import twc.Automation.HandleWithAppium.AppiumFunctions;
import twc.Automation.HandleWithCharles.CharlesFunctions;
import twc.Automation.ReadDataFromFile.read_excel_data;
import twc.Automation.ReadDataFromFile.read_xml_data_into_buffer;
import twc.Automation.RetryAnalyzer.RetryAnalyzer;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Title;
import twc.Automation.Driver.Drivers;
import twc.Automation.General.loginModule;
import twc.Automation.HandleMapLocal.MapLocalFunctions;
import twc.Automation.HandleWithApp.AppFunctions;
import twc.Automation.HandleWithAppium.AppiumFunctions;
import twc.Automation.HandleWithCharles.CharlesFunctions;
import twc.Automation.RetryAnalyzer.RetryAnalyzer;
import twc.Automation.General.Functions;

public class smokeTestCases extends Drivers {
//	protected String email;

	// Verifying Api and feed card and amazon aax prerol calls verification
	@Test(priority = 1, enabled = true)
	@Title("Verifying wfxtg trigger api call url")
	public void Smoke_Test_CaseVerify_WeatherFXAPI_url() throws Exception {
		System.out.println("================= Verifying WeatherFX API url started =========================");
		// CharlesFunctions.startSessionBrowserData();
		CharlesFunctions.ExportSession();
		Functions.validating_WeatherFXAPI();
		System.out.println("================= Verifying WeatherFX API url End =========================");
	}

	@Test(priority = 2, enabled = true)
	@Title("Verifying Location/Factual  api call url")
	public void Smoke_Test_CaseVerify_Factualapi_url() throws Exception {
		System.out.println("================= Verifying WeatherFX API url started =========================");
		Functions.validating_Fatual();
		System.out.println("================= Verifying WeatherFX API url End =========================");
	}

	@Test(priority = 3, enabled = true)
	@Title("Verifying turbo call api url")
	public void Smoke_Test_CaseVerify_turbo_url() throws Exception {
		System.out.println("================= Verifying Turbo call  API url started =========================");
		Functions.validating_turbocallAPI();
		System.out.println("================= Verifying Turbo call API url End =========================");
	}

	@Test(priority = 4, enabled = true)
	@Title("Verifying Lotame adcrw api call url")
	public void Smoke_Test_CaseVerify_adcrwdcntrlnet_url() throws Exception {
		System.out.println("================= Verifying Lotame ad.crwdcntrl.net url started =========================");
		Functions.validating_adcrw();
		System.out.println("================= Verifying Lotame ad.crwdcntrl.net url End =========================");
	}

	@Test(priority = 5, enabled = true)
	@Title("Verifying Home screen marquee ad call")
	public void Smoke_Test_CaseVerify_Homescreen_marquee_ad_iu() throws Exception {
		System.out.println(
				"================= verifying iu value for home screen marquee test case started =========================");
		Functions.finding_Homescreen_marquee_iu_value();
		System.out.println(
				"================= verifying iu value for home screen marquee test case End =========================");

	}

	@Test(priority = 6, enabled = true)
	@Title("Verifying feed_1 ad call")
	public void Smoke_Test_verifying_feed_1adcall() throws Exception {
		System.out.println("================= Verifying feed_1 ad call tescase Started =========================");
		Functions.verifying_feedcalls(1);
		System.out.println("================= Verifying feed_1 ad call tescase End =========================");
	}

	@Test(priority = 7, enabled = false)
	@Title("Verifying amazon Slot Id for feed1 prerol ad call")
	public void Smoke_Test_amazon_aaxSlot_feed1_preroladcall() throws Exception {
		System.out.println(
				"================= Verify amazon aax slot  Id for feed1 prerol adcall  testcase Started =========================");
		// AppFunctions.Pull_To_Refresh("Pulltorefresh");
		// CharlesFunctions.startSessionBrowserData();
		// CharlesFunctions.ExportSession();
		logStep(" Verifying amazon aax slot Id for feed1");
		Functions.get_aaxcal_feed1();
		System.out.println(
				"================= Verify amazon aax slot Id for feed1 prerol adcall testcase End =========================");

	}

	@Test(priority = 8, enabled = false)
	@Title("Verifying amazon Slot Id for feed2 prerol ad call")
	public void Smoke_Test_amazon_aaxSlot_feed2_preroladcall() throws Exception {
		System.out.println(
				"================= Verify amazon aax slot  Id for feed2 prerol adcall testcase Started =========================");

		logStep(" Verifying amazon aax slot Id for feed2");
		Functions.get_aaxcal_feed2();
		System.out.println(
				"================= Verify amazon aax slot Id for feed2 prerol adcall testcase End =========================");

	}

	@Test(priority = 9, enabled = false)
	@Title("Verifying amazon Slot Id for feed3 prerol ad call")
	public void Smoke_Test_amazon_aaxSlot_feed3_preroladcall() throws Exception {
		System.out.println(
				"================= Verify amazon aax slot  Id for feed3 prerol adcall testcase Started =========================");
		logStep(" Verifying amazon aax slot Id for feed3");
		Functions.get_aaxcal_feed3();
		System.out.println(
				"================= Verify amazon aax slot Id for feed3 prerol  adcall testcase End =========================");

	}

	@Test(priority = 10, enabled = false)
	@Title("Verifying amazon Slot Id for hourly details preroll ad call")
	public void Smoke_Test_amazon_aax_Hourly_preroll_adcall() throws Exception {
		System.out.println(
				"================= Verify amazon aax Hourly details preroll adcall Started =========================");

		logStep(" Verifying preload amazon aax for  hourly details");
		Functions.get_aaxcal_Hourly();
		System.out.println(
				"================= Verify amazon aax Hourly details preroll adcall End =========================");

	}

	@Test(priority = 11, enabled = false)
	@Title("Verifying amazon Slot Id for maps details preroll ad cal")
	public void Smoke_Test_amazon_aax_mapsdetails_preload_adcall() throws Exception {
		System.out.println(
				"================= Verify amazon aax Maps card preroll adcall Started =========================");

		logStep(" Verifying preload amazon aax for  map details");
		Functions.get_aaxcal_map_details();
		System.out
				.println("================= Verify amazon aax Maps card preroll adcall End =========================");

	}

	@Test(priority = 12, enabled = false)
	@Title("Verifying amazon Slot Id for daily details day1 preroll ad calll")
	public void Smoke_Test_amazon_aax_Daily_day1_preroll_adcall() throws Exception {
		System.out.println(
				"================= Verify amazon aax Daily details day1 preroll adcall Started =========================");
		logStep(" Verifying preload amazon aax for  daily details");
		Functions.get_aaxcal_Daily();
		System.out.println(
				"================= Verify amazon aax Daily details day1 preroll adcall End =========================");
	}

	// going to details also

	@Test(priority = 20, enabled = true)
	@Title("Verifying feed_2 ad call")
	public void Smoke_Test_verifying_feed_2adcall() throws Exception {
		System.out.println("================= Verifying feed_2 ad call tescase Started =========================");
		CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData();
	//	AppFunctions.Kill_Launch_App();
		AppiumFunctions.SwipeUp_Counter_feedcards(100);
		CharlesFunctions.ExportSession();
	//	AppiumFunctions.getFeedCardsListAndNavigateToThem(true);// going details		
		// AppiumFunctions.navigateToAllCardsByCardSize();
		Functions.verifying_feedcalls(2);
		System.out.println("================= Verifying feed_2 ad call tescase End =========================");
	}

	@Test(priority = 21, enabled = false)
	@Title("Verifying amazon  Slot Id for feed2 ad call")
	public void Smoke_Test_amazon_aaxSlot_feed2_adcall() throws Exception {
		System.out.println(
				"================= Verify amazon aax slot  Id for feed2 adcall testcase Started =========================");
		logStep(" Verifying amazon aax slot Id for feed2");
		Functions.get_aaxcal_feed2();
		System.out.println(
				"================= Verify amazon aax slot Id for feed2l adcall testcase End =========================");
	}

	@Test(priority = 22, enabled = true)
	@Title("Verifying feed_3 ad call")
	public void Smoke_Test_verifying_feed_3adcall() throws Exception {
		System.out.println("================= Verifying feed_3 ad call tescase Started =========================");
		Functions.verifying_feedcalls(3);
		System.out.println("================= Verifying feed_3 ad call tescase End =========================");
	}

	@Test(priority = 23, enabled = false)
	@Title("Verifying amazon  Slot Id for feed3 ad call")
	public void Smoke_Test_amazon_aaxSlot_feed3_adcall() throws Exception {
		System.out.println(
				"================= Verify amazon aax slot  Id for feed3 adcall testcase Started =========================");
		logStep(" Verifying amazon aax slot Id for feed3");
		Functions.get_aaxcal_feed3();
		System.out.println(
				"================= Verify amazon aax slot Id for feed3  adcall testcase End =========================");
	}

	@Test(priority = 24, enabled = true)
	@Title("Verifying feed_4 ad call")
	public void Smoke_Test_verifying_feed_4adcall() throws Exception {
		System.out.println("================= Verifying feed_4 ad call tescase Started =========================");
		Functions.verifying_feedcalls(4);
		System.out.println("================= Verifying feed_4 ad call tescase End =========================");
	}

	@Test(priority = 25, enabled = false)
	@Title("Verifying amazon  Slot Id for feed4 ad call")
	public void Smoke_Test_amazon_aaxSlot_feed4_adcall() throws Exception {
		System.out.println(
				"================= Verify amazon aax slot  Id for feed4 adcall testcase Started =========================");
		logStep(" Verifying amazon aax slot Id for feed4");
		Functions.get_aaxcal_feed4();
		System.out.println(
				"================= Verify amazon aax slot Id for feed4 adcall testcase End =========================");
	}

	@Test(priority = 26, enabled = true)
	@Title("Verifying feed_5 ad call")
	public void Smoke_Test_verifying_feed_5adcall() throws Exception {
		System.out.println("================= Verifying feed_5 ad call tescase Started =========================");
		Functions.verifying_feedcalls(5);
		System.out.println("================= Verifying feed_5 ad call tescase End =========================");
	}

	@Test(priority = 27, enabled = false)
	@Title("Verifying amazon  Slot Id for feed5 ad call")
	public void Smoke_Test_amazon_aaxSlot_feed5_adcall() throws Exception {
		System.out.println(
				"================= Verify amazon aax slot  Id for feed5 adcall testcase Started =========================");
		logStep(" Verifying amazon aax slot Id for feed5");
		Functions.get_aaxcal_feed5();
		System.out.println(
				"================= Verify amazon aax slot Id for feed5 adcall testcase End =========================");
	}

	@Test(priority = 28, enabled = true)
	@Title("Verifying feed_6 ad call")
	public void Smoke_Test_verifying_feed_6adcall() throws Exception {
		System.out.println("================= Verifying feed_6 ad call tescase Started =========================");
		Functions.verifying_feedcalls(6);
		System.out.println("================= Verifying feed_6 ad call tescase End =========================");
	}

	@Test(priority = 29, enabled = false)
	@Title("Verifying amazon  Slot Id for feed6 ad call")
	public void Smoke_Test_amazon_aaxSlot_feed6_adcall() throws Exception {
		System.out.println(
				"================= Verify amazon aax slot  Id for feed6 adcall testcase Started =========================");
		logStep(" Verifying amazon aax slot Id for feed6");

		Functions.get_aaxcal_feed6();
		System.out.println(
				"================= Verify amazon aax slot Id for feed6 adcall testcase End =========================");
	}

	@Test(priority = 30, enabled = true)
	@Title("Verifying iu value for maps details card")
	public void Smoke_Test_CaseVerify_Radar_Maps_deatailscard_adcall() throws Exception {
		System.out.println(
				"================= verifying iu value for Radar&Maps deatail card started =========================");
		Functions.finding_Radar_Map_card_iu_value();
		System.out.println(
				"================= verifying iu value for Radar&Maps deatail card  End =========================");
	}

	@Test(priority = 31, enabled = false)
	@Title("Verifying amazon Slot Id for maps details preroll ad cal")
	public void Smoke_Test_amazon_aax_mapsdetails_adcall() throws Exception {
		System.out.println("================= Verify amazon aax maps detais adcall Started =========================");
		logStep(" Verifying preload amazon aax for  map details");
		Functions.get_aaxcal_map_details();
		System.out
				.println("================= Verify amazon aax maps card preroll adcall End =========================");
	}

	@Test(priority = 32, enabled = true)
	@Title("Verifying Video ad call")
	public void Smoke_Test_Case_Verify_Video_adCalll() throws Exception {
		System.out.println("================= Verifying Video ad call testcase started =========================");
		Functions.finding_VideoCard_iu_value();
		System.out.println("================= Verifying Video ad call testcase End==============================");
	}

	@Test(priority = 33, enabled = false)
	@Title("Verifying amazon Slot Id  video ad call")
	public void Smoke_Test_amazon_aax_video_adcall() throws Exception {
		System.out.println("================= Verify amazon aax video adcall Started =========================");
		logStep(" Verifying preload amazon aax for  video details");
		Functions.get_aaxcal_video_details();
		System.out.println("================= Verify amazon aax video  adcall End =========================");
	}

	@Test(priority = 34, enabled = false)
	@Title("Verifying iu value for news detailpage ad call iu")
	public void Smoke_Test_Verify_News_detailpage_adcall_iu() throws Exception {
		System.out.println("================= Verify_News_detailpage_adcall_iu Started =========================");
		Functions.Verify_News_detailpage_adcall_iu();
		System.out.println("================= Verify_News_detailpage_adcall_iu End =========================");
	}

	@Test(priority = 35, enabled = false)
	@Title("Verifying amazon axx slot for new article")
	public void Smoke_Test_Verify_amazon_aax_News_adcall() throws Exception {
		System.out.println(
				"================= verifying amazon aax slot for news article started =========================");
		Functions.get_aaxcal_news();
		System.out
				.println("================= verifying amazon aax slot for news article  End =========================");
	}

	@Test(priority = 36, enabled = true)
	@Title("Verifying iu value Today details Page")
	public void Smoke_Test_CaseVerify_Today_details_page_iu() throws Exception {
		System.out.println(
				"================= verifying iu value for Today_details_page_iu started =========================");
		Functions.finding_Today_detail_page_iu_value();
		System.out.println(
				"================= verifying iu value for Today_details_page_iu End =========================");
	}

	@Test(priority = 37, enabled = false)
	@Title("Verifying amazon aax for today details card")
	public void Smoke_Test_amazon_aax_today_deatailcard() throws Exception {
		System.out.println(
				"================= Verify amazon aax for today detail adcard Started =========================");
		Functions.get_aaxcal_today_details();
		System.out.println("================= Verify amazon aax for today detail adcard End=========================");
	}

	@Test(priority = 38, enabled = true)
	@Title("Verifying iu value for  Air Quality content page")
	public void Smoke_Test_Verify_Air_Quality_detailpage_adcall_iu() throws Exception {
		System.out.println(
				"================= Verifying iu value for Air Quality content page testcase  started =========================");
		Functions.AirQuality_detailed_adcall_iu();
		System.out.println(
				"================= Verifying iu value for Air Quality content page testcase  End =========================");
	}
	
	
	
	
	@Test(priority = 39, enabled = false)
	@Title("Verifying amazon aax for AQ details page")
	public void Smoke_Test_amazon_aax_Airquality_deatailcard() throws Exception {
		System.out.println(
				"================= Verify amazon aax for Air Quality details page Started =========================");
		Functions.get_aaxcal_aq();
		System.out.println("================= Verify amazon aax for Air Quality detail Page  End=========================");
	}
	

	@Test(priority = 40, enabled = true)
	@Title("Verifying  iu value for Running content page")
	public void Smoke_Test_Verify_health_and_activities_Running_contenPage_adcall_iu() throws Exception {
		System.out.println(
				"================= Verify_health_and_activities_Running_contenPage_adcall_iu Started =========================");
		Functions.health_and_activities_Running_spotlight_adcall_iu();
		System.out.println(
				"================= Verify_health_and_activities_Running_contenPage_adcall_iu End =========================");
	}

	@Test(priority = 41, enabled = false)
	@Title("Verifying amazon slot Id for Running Bigbanner ad")
	public void Smoke_Test_Verify_amazon_SlotId_Running_Bigbanner_ad() throws Exception {
		System.out.println(
				"================= verifying amazon SlotId for Running BigBanner adcall started =========================");
		Functions.get_aaxcal_Running_Bigbanner();
		System.out.println(
				"================= verifying amazon SlotId for Running BigBanner adcall  End =========================");
	}

	@Test(priority = 41, enabled = true)
	@Title("Verifying iu value for Boat&Beach content page")
	public void Smoke_Test_Verify_health_and_activities_Bot_beach_contenPage_adcall_iu() throws Exception {
		System.out.println(
				"================= Verify_health_and_activities_Bot&beach_contenPage_adcall_iu Started =========================");
		Functions.health_and_activities_Boat_beach_detailpage_adcall_iu();
		System.out.println(
				"================= Verify_health_and_activities_Bot&beach_contenPage_adcall_iu End =========================");
	}

	@Test(priority = 42, enabled = false)
	@Title("Verifying amazon slot Id  for Boat&Beach Bigbanner ad")
	public void Smoke_Test_Verify_amazon_SlotId_Boat_Beach_Bigbanner_ad() throws Exception {
		System.out.println(
				"================= verifying amazon aax SlotId for Boat&Beach BigBanner adcall started =========================");
		Functions.get_aaxcal_Boat_Beach_Bigbanner();
		System.out.println(
				"================= verifying amazon SlotId for Boat&Beach BigBanner adcall End =========================");
	}

	@Test(priority = 43, enabled = true)
	@Title("Verifying iu value for Allergy content page")
	public void Smoke_Test_Verify_health_and_activities_Allergy_contenPage_adcall_iu() throws Exception {
		System.out.println(
				"================= Verify_health_and_activities_Allergy_contenPage_adcall_iu Started =========================");
		Functions.health_and_activities_Allergy_detailpage_adcall_iu();
		System.out.println(
				"================= Verify_health_and_activities_Allergy_contenPage_adcall_iu End =========================");
	}

	@Test(priority = 44, enabled = false)
	@Title("Verifying amazon slot Id for Allergy Bigbanner ad")
	public void Smoke_Test_Verify_amazon_SlotId_Allergy_Bigbanner_ad() throws Exception {
		System.out.println(
				"================= verifying amazon SlotId for Allergy BigBanner adcall started =========================");
		Functions.get_aaxcal_Allergy_Bigbanner();
		System.out.println(
				"================= verifying amazon SlotId for Allergy BigBanner adcall  End =========================");
	}

	@Test(priority = 45, enabled = true)
	@Title("Verifying iu value for Cold&Flu content page")
	public void Smoke_Test_Verify_health_and_activities_coldFlu_contenPaget_adcall_iu() throws Exception {
		System.out.println(
				"================= Verify_health_and_activities_coldFlu_contenPage_adcall_iu Started =========================");
		Functions.health_and_activities_Cold_Flu_detailpage_adcall_iu();
		System.out.println(
				"================= Verify_health_and_activities_coldFlu_contenPage_adcall_iu End =========================");
	}

	@Test(priority = 46, enabled = false)
	@Title("Verifying amazon slot Id for Cold&Flu Bigbanner ad")
	public void Smoke_Test_Verify_amazon_SlotId_coldFlu_Bigbanner_ad() throws Exception {
		System.out.println(
				"================= verifying amazon SlotId for cold&Flu BigBanner adcall started =========================");
		Functions.get_aaxcal_Cold_Flu_Bigbanner();
		System.out.println(
				"================= verifying amazon SlotId for cold&Flu BigBanner adcall  End =========================");
	}

	@Test(priority = 47, enabled = true)
	@Title("Verifying iu value for outdoor conditions  detailed  page  iu")
	public void Smoke_Test_Verify_SeasonalHub_detailpage_adcall_iu() throws Exception {
		System.out
				.println("================= Verifying outdoor detailpage_adcall iu Started =========================");
		Functions.Verify_SH_detailpage_adcall_iu();
		System.out.println("================= Verifying outdoor detailpage adcall iu End =========================");
	}
	
	
	@Test(priority = 49, enabled = false)
	@Title("Verifying amazon slot Id for Outdoor details page")
	public void Smoke_Test_Verify_amazon_SlotId_outdoor_details() throws Exception {
		System.out.println(
				"================= verifying amazon SlotId for oudoor details adcall started =========================");
		Functions.get_aaxcal_SH_details();
		System.out.println(
				"================= verifying amazon SlotId for outdoor details adcall  End =========================");
	}
	
	
//need to add aax

	@Test(priority = 50, enabled = true)
	@Title("Verifying iu value for hourly detailpage")
	public void Smoke_Test_Verify_hourly_detailpage_adcall_iu() throws Exception {
		System.out.println("================= Verifying hourly_detailpage_adcall_iu test case  Started =========================");
		CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData();
	   AppFunctions.click_hourly_element();
	   Thread.sleep(5000);
		AppFunctions.Swipe();
		AppFunctions.Swipe();
		AppFunctions.Swipe();
		AppFunctions.Swipe();
		AppFunctions.Swipe();
		AppFunctions.Swipe();
		CharlesFunctions.ExportSession();
		Functions.Verify_hourly_detailpage_adcall_iu();
		
		System.out.println("================= Verifying hourly_detailpage_adcall_iu  test case  End =========================");
	}

	@Test(priority = 51, enabled = false)
	@Title("Verifying amazon Slot Id for hourly details ad call")
	public void Smoke_Test_amazon_aax_Hourly_details_adcall() throws Exception {
		System.out.println(
				"================= Verify amazon aax Hourly details  adcall test case  Started =========================");
		Functions.get_aaxcal_Hourly();
		System.out.println("================= Verify amazon aax Hourly details  test case  End =========================");

	}
	
	@Test(priority = 52, enabled = true)
	@Title("Verifying iu value for hourly1 bigad  detailpage")
	public void Smoke_Test_Verify_hourly1_bigad_detailpage_adcall_iu() throws Exception {
		System.out.println(
				"================= Verifying hourly1 big ad detailpage_adcall_iu  test case Started =========================");
		Functions.Verify_hourly_detailpage_bigad1_adcall_iu();
		System.out.println(
				"================= Verifying hourly1 big ad detailpage_adcall_iu test case  End =========================");
	}
	
	@Test(priority =53, enabled = false)
	@Title("Verifying amazon Slot Id for hourly1 big ad detailspage")
	public void Smoke_Test_amazon_aax_Hourly1_bigaddetails_adcall() throws Exception {
		System.out.println(
				"================= Verify amazon aax Hourly1 details big  adcall  test case Started =========================");
		Functions.get_aaxcal_Hourly1();
		System.out.println("================= Verify amazon aax Hourly1 big ad details  test case  End =========================");

	}
	
	
	
	
	//aax's

	@Test(priority = 54, enabled = true)
	@Title("Verifying iu value for hourly2 bigad  detailpage")
	public void Smoke_Test_Verify_hourly2_bigad_detailpage_adcall_iu() throws Exception {
		System.out.println(
				"================= Verifying hourly2 bigad detailpage_adcall_iu test case Started =========================");
		Functions.Verify_hourly_detailpage_bigad2_adcall_iu();
		System.out.println(
				"================= Verifying hourly2 bigad detailpage_adcall_iu test case End =========================");
	}
	
	@Test(priority = 55, enabled = false)
	@Title("Verifying amazon Slot Id for hourly2 big ad detailspage")
	public void Smoke_Test_amazon_aax_Hourly2_bigaddetails_adcall() throws Exception {
		System.out.println(
				"================= Verifying  amazon aax Hourly2 details big  adcall  test case Started =========================");
		Functions.get_aaxcal_Hourly2();
		System.out.println("================= Verifying  amazon aax Hourly2  big ad details  test case  End =========================");

	}
	

	@Test(priority = 56, enabled = true)
	@Title("Verifying iu value for hourly3 bigad  detailpage")
	public void Smoke_Test_Verify_hourly3_bigad_detailpage_adcall_iu() throws Exception {
		System.out.println(
				"================= Verifying hourly3 bigad detailpage_adcall_iu test case  Started =========================");
	
		Functions.Verify_hourly_detailpage_bigad3_adcall_iu();
		
		System.out.println(
				"================= Verifying hourly3 bigad detailpage_adcall_iu test case  End =========================");
	}

	@Test(priority = 57, enabled = false)
	@Title("Verifying amazon Slot Id for hourly3 big ad detailspagel")
	public void Smoke_Test_amazon_aax_Hourly3_bigaddetails_adcall() throws Exception {
		System.out.println(
				"================= Verify amazon aax Hourly3 details big  ad call test case  Started =========================");
		Functions.get_aaxcal_Hourly3();
		System.out.println("================= Verify amazon aax Hourly3 big ad call test case End =========================");
	}
	  
		 @Test(priority = 68, enabled = true)
	  
		  @Title("Verifying  feed_1 ad call pull to refrersh scenario") 
		  public  void Smoke_Test_Verifying_feed1_pulltoreresh_scenario() throws  Exception {	 
		  logStep("Verifying feed_1 ad call pull to refrersh scenario");
		  System.out.
		  println("================= Verifying  feed_1 ad  call pull to refrersh scenario started =========================" ); 
		 AppFunctions.Kill_Launch_App();
		  CharlesFunctions.ClearSessions();
		  CharlesFunctions.startSessionBrowserData();
		  AppFunctions.Pull_To_Refresh("Pulltorefresh");
		  AppFunctions.Pull_To_Refresh("Pulltorefresh");
		  CharlesFunctions.ExportSession(); 
		  Functions.verifying_feedcalls(1);
		  System.out. println("================= Verifying  feed_1 ad  call pull to refrersh scenario started End =========================" ); 
		  }
		  
		  @Test(priority = 69, enabled = true)
		  
		  @Title("Verifying  home screen marquee call pull to refrersh scenario") public
		  void Smoke_Test_Verifying_homescreenmarquee__pulltoreresh_scenario() throws
		  Exception {
		  logStep("Verifying  home screen marquee call pull to refrersh scenario");
		  System.out. println("================= Verifying  home screen marquee call pull to refrersh scenario started =========================");
		  Functions.finding_Homescreen_marquee_iu_value(); 
		  System.out.println("================= Verifying  home screen marquee call pull to refrersh scenario  End =========================" );  
		  }
		
		  
		  @Test(priority = 70, enabled = true)	  
		  @Title("Verifying bcp.crwdcntrl call" )
		  public void Smoke_Test__Verifying_Bcp_apicall_Opti_mode_scenario() throws  Exception { 
		  logStep("Verifying bcp.crwdcntrl call" ); 
		  System.out.println("=================Verifying  bcp.crwdcntrl call testcase started =========================");	  
		  Functions.validating_bcp_privacy_Optinmode_scenarion();
		  System.out.println("================= Verifying  bcp.crwdcntrl call testcase End =========================" );
		  
		  }
	
		  @Test(priority = 72, enabled = true)	  
		  @Title("Verifying feed_1 ad  app backgroud launch call scenario") 
		  public  void Smoke_Test_Verifying_feed1Adcall__backgroundLaunch_scenario() throws  Exception {	 
		  logStep("Verifying feed_1 ad call backgroud launch scenario");
		  System.out.
		  println("================= Verifying  feed_1 ad  call backgroud launch scenario started =========================" ); 
		  CharlesFunctions.ClearSessions();
		  CharlesFunctions.startSessionBrowserData();
		 Ad.runAppInBackground(25);
		  CharlesFunctions.ExportSession(); 
		  Functions.verifying_feedcalls(1);
		  System.out. println("================= Verifying  feed_1 ad  call backgroud launch scenario End =========================" ); 
		  }
		  
		  @Test(priority = 73, enabled = true)	  
		  @Title("Verifying  home screen marquee call backgroud launch scenario") public
		  void Smoke_Test_Verifying_homescreenmarquee__backgroundLaunch_scenario() throws
		  Exception {
		  logStep("Verifying  home screen marquee call backgroud launch scenario");
		  System.out. println("================= Verifying  home screen marquee call backgroud launch scenario started =========================");
		  Functions.finding_Homescreen_marquee_iu_value(); 
		  System.out.println("================= Verifying  home screen marquee call backgroud launch scenario  End =========================" );  
		  }
		  
		  
		  
		  @Test(priority = 74, enabled = true)	  
		  @Title("Verifying feed_1 ad call when user enter new location") 
		  public  void Smoke_Test_Verifying_feed1Adcall_enter_newLocation_scenario() throws  Exception {	 
		  logStep("erifying feed_1 ad call when user enter new location");
		  System.out.
		  println("================= Verifying  feed_1 ad  call when user enter new location scenario started =========================" ); 
		  CharlesFunctions.ClearSessions();
		  CharlesFunctions.startSessionBrowserData();
		  AppFunctions.enter_requiredLocation("30124");
		  CharlesFunctions.ExportSession(); 
		  Functions.verifying_feedcalls(1);
		  System.out. println("=================Verifying  feed_1 ad  call when user enter new location scenario  End =========================" ); 
		  }
		  
		  @Test(priority = 118, enabled = true)	  
		  @Title("Verifying  home screen marquee call when user enter new location") public
		  void Smoke_Test_Verifying_homescreenmarquee__enter_newLocation_scenario() throws
		  Exception {
		  logStep("Verifying  home screen marquee call backgroud launch scenario");
		  System.out. println("================= Verifying  home screen marquee call when user enter new location scenario started =========================");
		  Functions.finding_Homescreen_marquee_iu_value(); 
		  System.out.println("================= Verifying  home screen marquee call when user enter new location scenario   End =========================" );  
		  }
		
	
	
	
/*	@Test(priority = 60, enabled = true)

	@Title("Verifying new daily details day1 ad call")
	public void Smoke_Test_Verifying_newdailydetails_day1adcall() throws Exception {
		System.out.println(
				"================= Verifying new daily details day1 ad call tescase Started =========================");
		CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData();
		Functions.clickdailydetails();
		Functions.closeInterstailads();
		Functions.clickongotit();
		CharlesFunctions.ExportSession();
		Functions.verifyingdailydetailiu();
		System.out.println(
				"=================  Verifying new daily details day1 ad call tescase  End =========================");
	}

	@Test(priority = 61, enabled = false)
	@Title("Verifying amazon Slot Id for daily details day1 ad calll")
	public void Smoke_Test_amazon_aax_Daily_details_Day1_adcall() throws Exception {
		System.out
				.println("================= Verifying amazon slot id for  daily details day1 adcall test case Started =========================");
	  Functions.gettingDayofWeekFromUI(1);
		Functions.get_aaxcal_Daily();
		System.out.println("================= Verifying amazon slot id for  daily details day 1 adcall test case End =========================");
	}
//aax 15 days
	@Test(priority = 62, enabled = true)

	@Title("Verifying new daily details day2 ad call")
	public void Smoke_Test_Verifying_newdailydetails_day2adcall() throws Exception {
		System.out.println(
				"================= Verifying new daily details day2 ad call test case Started=========================");
		CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData();
		Functions.clickonday2();
		CharlesFunctions.ExportSession();
		Functions.verifyingdailydetailiu();
	//	Functions.verifyingdailydetailsiu();
		System.out.println(
				"================= Verifying new daily details day2 ad call test case End =========================");
	}
	
	@Test(priority = 63, enabled = false)
	@Title("Verifying amazon Slot Id for daily details day2 ad calll")
	public void Smoke_Test_amazon_aax_Dailydetails_Day2adcall() throws Exception {
		System.out
				.println("================= Verifying amazon slot id for  daily details day2  adcall test case Started =========================");
	  Functions.gettingDayofWeekFromUI(1);
		Functions.get_aaxcal_Daily();
		System.out.println("================= Verifying amazon slot id for  daily details day2 adcall test case End =========================");
	}

	@Test(priority = 64, enabled = true)

	@Title("Verifying new daily details day3 ad call")
	public void Smoke_Test_Verifying_newdailydetails_day3adcall() throws Exception {
		System.out.println(
				"================= Verifying new daily details day3 ad call test case Started =========================");
		CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData(); //
		//Functions.finding_newDailyBidadcall_day2();
		Functions.clickonday3();
		CharlesFunctions.ExportSession();
		Functions.verifyingdailydetailiu();
		System.out.println(
				"================= Verifying new daily details day3 ad call test case End =========================");
	}
	
	
	@Test(priority = 65, enabled = false)
	@Title("Verifying amazon Slot Id for daily details day3 ad calll")
	public void Smoke_Test_amazon_aax_Dailydetails_Day3adcall() throws Exception {
		System.out
				.println("================= Verifying amazon slot id for  daily details day3  adcall test case Started =========================");
	  Functions.gettingDayofWeekFromUI(1);
		Functions.get_aaxcal_Daily();
		System.out.println("================= Verifying amazon slot id for  daily details day3 adcall test case End =========================");
	}

	@Test(priority = 66, enabled = true)

	@Title("Verifying new daily details day4 ad call")
	public void Smoke_Test_Verifying_newdailydetails_day4adcall() throws Exception {
		System.out.println(
				"================= Verifying new daily details day4 ad call tescase Started =========================");
		CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData(); //
	//	Functions.finding_newDailyBidadcall_day2();
		Functions.clickonday4();
		CharlesFunctions.ExportSession();
		Functions.verifyingdailydetailiu();
		System.out.println(
				"================= Verifying new daily details day4 ad call tescase End =========================");
	}

	
	@Test(priority = 67, enabled = false)
	@Title("Verifying amazon Slot Id for daily details day4 ad calll")
	public void Smoke_Test_amazon_aax_Dailydetails_Day4adcall() throws Exception {
		System.out
				.println("================= Verifying amazon slot id for  daily details day4  adcall test case Started =========================");
	  Functions.gettingDayofWeekFromUI(1);
		Functions.get_aaxcal_Daily();
		System.out.println("================= Verifying amazon slot id for  daily details day4 adcall test case End =========================");
	}
	
	@Test(priority = 68, enabled = false)

	@Title("Verifying new daily details day5 ad call")
	public void Smoke_Test_Verifying_newdailydetails_day5adcall() throws Exception {
		System.out.println(
				"================= Verifying new daily details day5 ad call tescase Started =========================");
		CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData(); //
	//	Functions.finding_newDailyBidadcall_day2();
		Functions.clickonday5();
		CharlesFunctions.ExportSession();
		Functions.verifyingdailydetailiu();
		System.out.println(
				"================= Verifying new daily details day5 ad call tescase End =========================");
	}

	
	@Test(priority = 69, enabled = false)
	@Title("Verifying amazon Slot Id for daily details day5 ad calll")
	public void Smoke_Test_amazon_aax_Dailydetails_Day5adcall() throws Exception {
		System.out
				.println("================= Verifying amazon slot id for  daily details day5  adcall test case Started =========================");
	  Functions.gettingDayofWeekFromUI(1);
		Functions.get_aaxcal_Daily();
		System.out.println("================= Verifying amazon slot id for  daily details day5 adcall test case End =========================");
	}
	
	
	@Test(priority = 70, enabled = true)

	@Title("Verifying new daily details day6 ad call")
	public void Smoke_Test_Verifying_newdailydetails_day6adcall() throws Exception {
		System.out.println(
				"================= Verifying new daily details day6 ad call tescase Started =========================");
		CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData(); //
	//	Functions.finding_newDailyBidadcall_day2();
		Functions.clickonday6();
		CharlesFunctions.ExportSession();
		Functions.verifyingdailydetailiu();
		System.out.println(
				"================= Verifying new daily details day6 ad call tescase End =========================");
	}
	
	@Test(priority = 71, enabled = false)
	@Title("Verifying amazon Slot Id for daily details day6 ad calll")
	public void Smoke_Test_amazon_aax_Dailydetails_Day6adcall() throws Exception {
		System.out
				.println("================= Verifying amazon slot id for  daily details day6  adcall test case Started =========================");
	  Functions.gettingDayofWeekFromUI(1);
		Functions.get_aaxcal_Daily();
		System.out.println("================= Verifying amazon slot id for  daily details day6 adcall test case End =========================");
	}

	@Test(priority = 72, enabled = true)

	@Title("Verifying new daily details day7 ad call")
	public void Smoke_Test_Verifying_newdailydetails_day7adcall() throws Exception {
		System.out.println(
				"================= Verifying new daily details day7 ad call tescase Started =========================");
		CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData(); 
	//	Functions.finding_newDailyBidadcall_day2();
		Functions.clickonday7();
		CharlesFunctions.ExportSession();
		Functions.verifyingdailydetailiu();
		System.out.println(
				"================= Verifying new daily details day7 ad call tescase End =========================");
	}
	
	@Test(priority = 73, enabled = false)
	@Title("Verifying amazon Slot Id for daily details day7 ad calll")
	public void Smoke_Test_amazon_aax_Dailydetails_Day7adcall() throws Exception {
		System.out
				.println("================= Verifying amazon slot id for  daily details day7  adcall test case Started =========================");
	  Functions.gettingDayofWeekFromUI(1);
		Functions.get_aaxcal_Daily();
		System.out.println("================= Verifying amazon slot id for  daily details day7 adcall test case End =========================");
	}

	@Test(priority = 74, enabled = true)

	@Title("Verifying new daily details day8 ad call")
	public void Smoke_Test_Verifying_newdailydetails_day8adcall() throws Exception {
		System.out.println(
				"================= Verifying new daily details day8 ad call tescase Started =========================");
		CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData(); //
		//Functions.finding_newDailyBidadcall_day2();
		Functions.clickonday8();
		CharlesFunctions.ExportSession();
		Functions.verifyingdailydetailsiu1();
		System.out.println(
				"================= Verifying new daily details day8 ad call tescase End =========================");
	}
	
	
	@Test(priority = 75, enabled = false)
	@Title("Verifying amazon Slot Id for daily details day8 ad calll")
	public void Smoke_Test_amazon_aax_Dailydetails_Day8adcall() throws Exception {
		System.out
				.println("================= Verifying amazon slot id for  daily details day8  adcall test case Started =========================");
	  Functions.gettingDayofWeekFromUI(2);
		Functions.get_aaxcal_Daily();
		System.out.println("================= Verifying amazon slot id for  daily details day8 adcall test case End =========================");
	}

	@Test(priority = 76, enabled = true)

	@Title("Verifying new daily details day9 ad call")
	public void Smoke_Test_Verifying_newdailydetails_day9adcall() throws Exception {
		System.out.println(
				"================= Verifying new daily details day9 ad call tescase Started =========================");
		CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData(); //
		//Functions.finding_newDailyBidadcall_day2();
		Functions.clickonday9();
		CharlesFunctions.ExportSession();
		Functions.verifyingdailydetailsiu1();
		System.out.println(
				"================= Verifying new daily details day9 ad call tescase End =========================");
	}
	
	
	
	@Test(priority = 77, enabled = false)
	@Title("Verifying amazon Slot Id for daily details day9 ad calll")
	public void Smoke_Test_amazon_aax_Dailydetails_Day9adcall() throws Exception {
		System.out
				.println("================= Verifying amazon slot id for  daily details day9  adcall test case Started =========================");
	  Functions.gettingDayofWeekFromUI(2);
		Functions.get_aaxcal_Daily();
		System.out.println("================= Verifying amazon slot id for  daily details day9 adcall test case End =========================");
	}

	@Test(priority = 78, enabled = true)

	@Title("Verifying new daily details day10 ad call")
	public void Smoke_Test_Verifying_newdailydetails_day10adcall() throws Exception {
		System.out.println(
				"================= Verifying new daily details day10 ad call tescase Started =========================");
		CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData(); //
	//	Functions.finding_newDailyBidadcall_day2();
		Functions.clickonday10();
		CharlesFunctions.ExportSession();
		Functions.verifyingdailydetailsiu1();
		
		System.out.println(
				"================= Verifying new daily details day10 ad call tescase End =========================");
	}
	
	
	
	@Test(priority = 79, enabled = false)
	@Title("Verifying amazon Slot Id for daily details day10  ad calll")
	public void Smoke_Test_amazon_aax_Dailydetails_Day10adcall() throws Exception {
		System.out
				.println("================= Verifying amazon slot id for  daily details day10  adcall test case Started =========================");
	  Functions.gettingDayofWeekFromUI(2);
		Functions.get_aaxcal_Daily();
		System.out.println("================= Verifying amazon slot id for  daily details day10 adcall test case End =========================");
	}

	@Test(priority = 80, enabled = true)

	@Title("Verifying new daily details day11 ad call")
	public void Smoke_Test_Verifying_newdailydetails_day11adcall() throws Exception {
		System.out.println(
				"================= Verifying new daily details day11 ad call tescase Started =========================");
		CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData(); //
		//Functions.finding_newDailyBidadcall_day2();
		Functions.clickonday11();
		CharlesFunctions.ExportSession();
		Functions.verifyingdailydetailsiu1();
		System.out.println(
				"================= Verifying new daily details day11 ad call tescase End =========================");
	}
	
	
	
	@Test(priority = 81, enabled = false)
	@Title("Verifying amazon Slot Id for daily details day11  ad calll")
	public void Smoke_Test_amazon_aax_Dailydetails_Day11adcall() throws Exception {
		System.out
				.println("================= Verifying amazon slot id for  daily details day11  adcall test case Started =========================");
	  Functions.gettingDayofWeekFromUI(2);
		Functions.get_aaxcal_Daily();
		System.out.println("================= Verifying amazon slot id for  daily details day11 adcall test case End =========================");
	}

	@Test(priority = 82, enabled = true)

	@Title("Verifying new daily details day12 ad call")
	public void Smoke_Test_Verifying_newdailydetails_day12adcall() throws Exception {
		System.out.println(
				"================= Verifying new daily details day12 ad call tescase Started =========================");
		CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData(); //
	//	Functions.finding_newDailyBidadcall_day2();
		Functions.clickonday12();
		CharlesFunctions.ExportSession();
		Functions.verifyingdailydetailsiu1();
		System.out.println(
				"================= Verifying new daily details day12 ad call tescase End =========================");
	}
	
	@Test(priority = 83, enabled = false)
	@Title("Verifying amazon Slot Id for daily details day12  ad calll")
	public void Smoke_Test_amazon_aax_Dailydetails_Day12adcall() throws Exception {
		System.out
				.println("================= Verifying amazon slot id for  daily details day12  adcall test case Started =========================");
	  Functions.gettingDayofWeekFromUI(2);
		Functions.get_aaxcal_Daily();
		System.out.println("================= Verifying amazon slot id for  daily details day12 adcall test case End =========================");
	}

	@Test(priority = 84, enabled = true)
	@Title("Verifying new daily details day13 ad call")
	public void Smoke_Test_Verifying_newdailydetails_day13adcall() throws Exception {
		System.out.println(
				"================= Verifying new daily details day13 ad call tescase Started =========================");
		CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData(); //
	//	Functions.finding_newDailyBidadcall_day2();
		Functions.clickonday13();
		CharlesFunctions.ExportSession();
		Functions.verifyingdailydetailsiu1();
		System.out.println(
				"================= Verifying new daily details day13 ad call tescase End =========================");
	}
	
	
	@Test(priority = 85, enabled = false)
	@Title("Verifying amazon Slot Id for daily details day13  ad calll")
	public void Smoke_Test_amazon_aax_Dailydetails_Day13adcall() throws Exception {
		System.out
				.println("================= Verifying amazon slot id for  daily details day13  adcall test case Started =========================");
	  Functions.gettingDayofWeekFromUI(2);
		Functions.get_aaxcal_Daily();
		System.out.println("================= Verifying amazon slot id for  daily details day13 adcall test case End =========================");
	}

	@Test(priority = 86, enabled = true)

	@Title("Verifying new daily details day14 ad call")
	public void Smoke_Test_Verifying_newdailydetails_day14adcall() throws Exception {
		System.out.println(
				"================= Verifying new daily details day14 ad call tescase Started =========================");
		CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData(); //
	//	Functions.finding_newDailyBidadcall_day2();
		Functions.clickonday14();
		CharlesFunctions.ExportSession();
		Functions.verifyingdailydetailsiu1();
		System.out.println(
				"================= Verifying new daily details day14 ad call tescase End =========================");
	}
	
	
	@Test(priority = 87, enabled = false)
	@Title("Verifying amazon Slot Id for daily details day14  ad calll")
	public void Smoke_Test_amazon_aax_Dailydetails_Day14adcall() throws Exception {
		System.out
				.println("================= Verifying amazon slot id for  daily details day14  adcall test case Started =========================");
	  Functions.gettingDayofWeekFromUI(2);
		Functions.get_aaxcal_Daily();
		System.out.println("================= Verifying amazon slot id for  daily details day14 adcall test case End =========================");
	}


	@Test(priority = 88, enabled = true)

	@Title("Verifying new daily details day15 ad call")
	public void Smoke_Test_Verifying_newdailydetails_day15adcall() throws Exception {
		System.out.println(
				"================= Verifying new daily details day15 ad call tescase Started =========================");
		CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData(); //
	//	Functions.finding_newDailyBidadcall_day2();
		Functions.clickonday15();
		CharlesFunctions.ExportSession();
		Functions.verifyingdailydetailsiu2();
		System.out.println(
				"================= Verifying new daily details day15 ad call tescase End =========================");
	}

	
	@Test(priority = 89, enabled = false)
	@Title("Verifying amazon Slot Id for daily details day15  ad calll")
	public void Smoke_Test_amazon_aax_Dailydetails_Day15adcall() throws Exception {
		System.out
				.println("================= Verifying amazon slot id for  daily details day15  adcall test case Started =========================");
	  Functions.gettingDayofWeekFromUI(3);
		Functions.get_aaxcal_Daily();
		System.out.println("================= Verifying amazon slot id for  daily details day15 adcall test case End =========================");
	}
	
	  
	/*  @Test(priority = 0, enabled = true)
  
	  @Title("Verifying  feed_1 ad call pull to refrersh scenario") 
	  public  void Smoke_Test_Verifying_feed1_pulltoreresh_scenario() throws  Exception {	 
	  logStep("Verifying feed_1 ad call pull to refrersh scenario");
	  System.out.
	  println("================= Verifying  feed_1 ad  call pull to refrersh scenario started =========================" ); 
	 AppFunctions.Kill_Launch_App();
	  CharlesFunctions.ClearSessions();
	  CharlesFunctions.startSessionBrowserData();
	  AppFunctions.Pull_To_Refresh("Pulltorefresh");
	  AppFunctions.Pull_To_Refresh("Pulltorefresh");
	  CharlesFunctions.ExportSession(); 
	  Functions.verifying_feedcalls(1);
	  System.out. println("================= Verifying  feed_1 ad  call pull to refrersh scenario started End =========================" ); 
	  }
	  
	  @Test(priority = 118, enabled = true)
	  
	  @Title("Verifying  home screen marquee call pull to refrersh scenario") public
	  void Smoke_Test_Verifying_homescreenmarquee__pulltoreresh_scenario() throws
	  Exception {
	  logStep("Verifying  home screen marquee call pull to refrersh scenario");
	  System.out. println("================= Verifying  home screen marquee call pull to refrersh scenario started =========================");
	  Functions.finding_Homescreen_marquee_iu_value(); 
	  System.out.println("================= Verifying  home screen marquee call pull to refrersh scenario  End =========================" );  
	  }
	
	  @Test(priority = 0, enabled = true)	  
	  @Title("Verifying feed_1 ad  app backgroud launch call scenario") 
	  public  void Smoke_Test_Verifying_feed1Adcall__backgroundLaunch_scenario() throws  Exception {	 
	  logStep("Verifying feed_1 ad call backgroud launch scenario");
	  System.out.
	  println("================= Verifying  feed_1 ad  call backgroud launch scenario started =========================" ); 
	  AppFunctions.Kill_Launch_App();
	  CharlesFunctions.ClearSessions();
	  CharlesFunctions.startSessionBrowserData();
	  AppFunctions.Pull_To_Refresh("Pulltorefresh");
	  AppFunctions.Pull_To_Refresh("Pulltorefresh");
	  CharlesFunctions.ExportSession(); 
	  Functions.verifying_feedcalls(1);
	  System.out. println("================= Verifying  feed_1 ad  call backgroud launch scenario End =========================" ); 
	  }
	  
	  @Test(priority = 118, enabled = true)	  
	  @Title("Verifying  home screen marquee call backgroud launch scenario") public
	  void Smoke_Test_Verifying_homescreenmarquee__backgroundLaunch_scenario() throws
	  Exception {
	  logStep("Verifying  home screen marquee call backgroud launch scenario");
	  System.out. println("================= Verifying  home screen marquee call backgroud launch scenario started =========================");
	  Functions.finding_Homescreen_marquee_iu_value(); 
	  System.out.println("================= Verifying  home screen marquee call backgroud launch scenario  End =========================" );  
	  }
	  
	  
	  
	  @Test(priority = 0, enabled = true)	  
	  @Title("Verifying feed_1 ad call when user enter new location") 
	  public  void Smoke_Test_Verifying_feed1Adcall_enter_newLocation_scenario() throws  Exception {	 
	  logStep("erifying feed_1 ad call when user enter new location");
	  System.out.
	  println("================= Verifying  feed_1 ad  call when user enter new location scenario started =========================" ); 
	  AppFunctions.enter_requiredLocation("10005");
	  CharlesFunctions.ClearSessions();
	  CharlesFunctions.startSessionBrowserData();
	  AppFunctions.Pull_To_Refresh("Pulltorefresh");
	  AppFunctions.Pull_To_Refresh("Pulltorefresh");
	  CharlesFunctions.ExportSession(); 
	  Functions.verifying_feedcalls(1);
	  System.out. println("=================Verifying  feed_1 ad  call when user enter new location scenario  End =========================" ); 
	  }
	  
	  @Test(priority = 118, enabled = true)	  
	  @Title("Verifying  home screen marquee call when user enter new location") public
	  void Smoke_Test_Verifying_homescreenmarquee__enter_newLocation_scenario() throws
	  Exception {
	  logStep("Verifying  home screen marquee call backgroud launch scenario");
	  System.out. println("================= Verifying  home screen marquee call when user enter new location scenario started =========================");
	  Functions.finding_Homescreen_marquee_iu_value(); 
	  System.out.println("================= Verifying  home screen marquee call when user enter new location scenario   End =========================" );  
	  }*/
	
	  
	  
	  
	  
	  
	/*@Test(priority = 80, enabled = true)  
	  @Title("Verifying Privacy Card is present on the screen") public void
	  Smoke_Test_Verify_PrivacyCard_onScreen() throws Exception {	  
	 System.out. println("=================Verifying Privacy Card is present on the screen testcase started =========================" ); 
	 AppFunctions. Kill_Launch_App();
	//  AppFunctions. Kill_Launch_App();
	  Thread.sleep(10000);	  
	  Functions.Verify_Privacy_Card_onScreen();	  
	  System.out. println("================= Verifying Privacy Card is present on the screen testcase End =========================" );
	  }
	  
	  @Test(priority = 81, enabled = true)	  
	  @Title("Selecting the  Optout mode in the privacy card") public void
	  Smoke_Test_Selecting_Opt_out_mode_scenario() throws Exception {	  
	 System.out. println("=================Slecting Opt out mode scenario in privacy card testcase started =========================" );
	  Thread.sleep(10000); 
	  Functions.selecting_opt_out_mode(); 
	  System.out.println("kill launch the app for two times");
	  AppFunctions.Kill_Launch_App(); 
	   AppFunctions.Kill_Launch_App();  
	  System.out.println("================= Slecting Optout mode scenario in privacy card  testcase End =========================");	  
	  }
	  
	  @Test(priority = 82, enabled = true)	  
	  @Title("Verifying video call when user selecting Optoutmode scenario in privacy card") 
	  public void Smoke_Test__Smoke_Test_Verifying_videoadcall_Optoutmode_scenario() throws   Exception {
	System.out. println("=================Verifying video Feed ad call when user selecting Optoutmode scenario in privacy card started =========================" );
	  logStep("Verifying video call when user selecting Optoutmode scenario in privacy card"); 
	  CharlesFunctions.startSessionBrowserData(); 
	  CharlesFunctions.ClearSessions();
	   AppFunctions.Kill_Launch_App();  
	  AppiumFunctions.SwipeUp_Counter_video_maps_feedcards(10);
	  CharlesFunctions.ExportSession();
	  Functions.Verify_video_ad_call_Optoutmode(); 
	  System.out.println("================= Verifying video ad call when user selecting Optoutmode scenario in privacy card End =========================" );  
	  }
	  
	  @Test(priority = 83, enabled = true)
	  @Title("Verifying feed_1 ad call when user selecting Optoutmode scenario in privacy card") 
	  public void Smoke_Test_Verifying_Feedadcall_Optoutmode_scenario() throws   Exception {
	  System.out. println("=================Verifying Feed_1 ad call when user selecting Optoutmode scenario in privacy card started =========================" );
	  logStep("Verifying feed_1 ad call when user selecting Optoutmode scenario in privacy card");
	  Functions.verifying_feedcalls(1);
	  System.out. println("================= Verifying Feed_1 ad call when user selecting Optoutmode scenario in privacy card End =========================" ); 
	  }
	  
	  
	  @Test(priority = 84, enabled = true)	  
	  @Title("Verifying  maps detail page ad call when user selecting Optoutmode scenario in privacy card" )
	  public void Smoke_Test_Verifying_detailpageadcall_Optoutmode_scenario()  throws Exception {
	   logStep("Verifying   maps detail page ad call when user selecting Optoutmode scenario in privacy card" );
	   System.out.println("=================Verifying maps detail page Feed ad call when user selecting Optoutmode scenario in privacy card started =========================" );
	   Functions.Verifying_detail_gampadcalls_Optoutmode();
	   System.out.println("================= Verifying maps detail page  Feed ad call when user selecting Optoutmode scenario in privacy card End =========================" );
	   }
	  
	  
	  @Test(priority = 85, enabled = true)	  
	  @Title("Verifying bcp api url  when user selecting Optoutmode scenario in privacy card" )
	  public void Smoke_Test__Verifying_Bcp_apicall_Optoutmode_scenario() throws   Exception {
	  logStep("Verifying bcp api url  when user selecting Optoutmode scenario in privacy card" ); 
	  System.out.println("=================Verifying BCP api call when user selecting Optoutmode scenario in privacy card started =========================" );
	  Functions.validating_bcp_privacy_Optoutmode_scenarion();
	  System.out.println("================= Verifying BCP api call when user selecting Optoutmode scenario in privacy card End =========================");  
	  }
	 
	  @Test(priority = 86, enabled = true)  
	  @Title("Verifying adcrw api call when user selecting Optoutmode scenario in privacy card") 
	  public void Smoke_Test__Verifying_adcrw_apicall_Optoutmode_scenario()  throws Exception {  
	  logStep("Verifying adcrw api call when user selecting Optoutmode scenario in privacy card" ); 
	  System.out.println("=================Verifying adcrw api call when user selecting Optoutmode scenario in privacy card started =========================");
	  Functions.validating_adcrw_privacy_Optoutmode_scenarion(); 
	  System.out.println("================= Verifying adcrw api call when user selecting Optoutmode scenario in privacy card End =========================");	  
	  }
	  
	  @Test(priority = 87, enabled = true)	  
	  @Title("Verifying Factual api call when user selecting Optoutmode scenario in privacy card") 
	  public void Smoke_Test__Verifying_locaion_apicall_Optoutmode_scenario() throws Exception { 
	  logStep("Verifying Factual api call when user selecting Optoutmode scenario in privacy card"); 
	 System.out.println("=================Verifying Fatual api call when user selecting Optoutmode scenario in privacy card started =========================");
	 Functions.validating_Fatualcall_privacy_Optoutmode_scenarion();
	 System.out. println("================= Verifying Fatual api call when user selecting Optoutmode scenario in privacy card End =========================");
	  }
	 
	  @Test(priority =88, enabled = true)  
	  @Title("Verifying amazon prerol aax sloit id's  when user selecting Optoutmode scenario in privacy card" ) 
	  public void Smoke_Test__Verifying_amaozn_aax_calls_Optoutmode_scenario()  throws Exception {
	  logStep("Verifying amazon prerol aax slot id's when user selecting Optoutmode scenario in privacy card" );
	  System.out.println("=================Verifying amazon prerol slot is's  when user selecting Optoutmode scenario in privacy card started =========================" );
	  logStep("Verifying amazon prerol slot id's when user selecting Optoutmode scenario in privacy card" );
	  Functions.validating_aax_privacy_Optoutmode_scenario(); 
	  System.out.println("================= Verifying amazon prerol slot id's when user selecting Optoutmode scenario in privacy card End =========================");  
	  }
	  
	  @Test(priority = 89, enabled = true)  
	  @Title("Verifying feed_1 ad call  when user selecting Optoutmode scenario in privacy card" ) 
	  public void  Smoke_Test__Verifying_homescreenhourly_calls_Optoutmode_scenario() throws Exception {
     System.out.println("=================Verifying feed_1 ad call when user selecting Optoutmode scenario in privacy card started =========================" );
	  logStep("Verifying feed_1 ad call  when user selecting Optoutmode scenario in privacy card" );
	  Functions.verifying_feedcalls(1);
	  System.out.println("================= Verifying feed_1 ad calls when user selecting Optoutmode scenario in privacy card End =========================" );	  
	  }
	  
	  @Test(priority = 90, enabled = true)	  
	  @Title("Verifying homescreen marquee ad call  when user selecting Optoutmode scenario in privacy card" )	
	  public void Smoke_Test__Verifying_marqueehomescreecall_Optoutmode_scenario() throws	 Exception {
	  logStep("Verifying homescreen marquee ad call  when user selecting Optoutmode scenario in privacy card" ); 
	  System.out. println("=================Verifying homescreen marquee ad calls when user selecting Optoutmode scenario in privacy card started =========================" );  
	  Functions.finding_Homescreen_marquee_iu_value();
	  System.out.println("================= Verifying homescreen  marquee ad calls when user selecting Optoutmode scenario in privacy card End =========================" );	  
	  }
	  
	  @Test(priority = 91, enabled = true)	  
	  @Title("Verifying SOD Cust param value for feed_1 call when user selecting Optoutmode scenario in privacy card" )
	  public void Smoke_Test_Verifying_SOD_Cust_Param_feed1ad_Optoutmode_scenario() throws Exception {
	  logStep("Verifying SOD Cust param value for feed_1 call when user selecting Optoutmode scenario in privacy card" ); 
	  System.out.println("================= Verifying SOD CUST_PARAM value for feed_1 call  when user selecting Optoutmode scenario in privacy card started =========================" );
	  Functions.validate_SOD_Cust_param_homescreen_Optoutmode(); 
	  System.out.println("================= Verifying SOD CUST_PARAM value for feed_1 screen call when user selecting Optoutmode scenario in privacy card End ========================="  ); 
	  }
	  
	  @Test(priority = 109, enabled = true)	  
	  @Title("Verifying SOD Cust param value for homescreen marquee call when user selecting Optout mode scenario in privacy card" )
	  public void  Smoke_Test_Verifying_SOD_Cust_Param_homescreen_marquee_Optout_mode_scenario() throws  Exception {
	  logStep("Verifying SOD Cust param value for home screen marquee call when user selecting Optout mode scenario in privacy card" ); 
	  System.out.println("================= Verifying SOD CUST_PARAM value for homescreen marquee call  when user selecting Optout mode scenario in privacy card started ========================="); 
	  Functions.validate_SOD_Cust_param_homescreenmarquee_Optoutmode();
	  System.out.println("================= Verifying SOD CUST_PARAM value for homescreen marquee call when user selecting Opttinmode scenario in privacy card End =========================" ); 
	  }




	  
	/*  @Test(priority = 92, enabled = true)  
	  @Title("Verifying SOD Cust param value for  Feed ad call when user selecting Optoutmode scenario in privacy card"  )
	  public void  Smoke_Test_Verifying_SOD_Cust_Param_Feedad_Optoutmode_scenario() throws Exception {
	  logStep("Verifying SOD Cust param value for  Feed ad call when user selecting Optoutmode scenario in privacy card" ); 
	  System.out. println("================= Verifying SOD CUST_PARAM value for Feed ad call  when user selecting Optoutmode scenario in privacy card started ========================="); 
	  Functions.validate_SOD_Cust_param_feed_Optoutmode(); 
	  System.out.println("================= Verifying SOD CUST_PARAM value for Feed ad call  when user selecting Optoutmode scenario in privacy card End =========================");
	  }*/
	  
	  
	/*  @Test(priority = 93, enabled = true)	  
	  @Title("Verifying SOD Cust param value for maps detaill page ad call when user selecting Optoutmode scenario in privacy card" )
	  public void Smoke_Test_Verifying_SOD_Cust_Param_mapsdetail_Feedad_Optoutmode_scenario() throws Exception { 
	 System.out. println("================= Verifying SOD CUST_PARAM value for  detailed Feed ad call  when user selecting Optoutmode scenario in privacy card started =========================" );
	  logStep("Verifying SOD Cust param value for maps detaill page ad call when user selecting Optoutmode scenario in privacy card" );  
	  Functions.validate_SOD_Cust_param_deatiledfeed_Optoutmode();
	  System.out. println("================= Verifying SOD CUST_PARAM value for  detailed Feed ad call  when user selecting Optoutmode scenario in privacy card End =========================" );
	  }
	  
	  @Test(priority = 94, enabled = true)	  
	  @Title("Verifying SOD Cust param value for video call when user selecting Optoutmode scenario in privacy card" ) 
	  public void Smoke_Test_Verifying_SOD_Cust_Param_videoad_Optoutmode_scenario() throws Exception {
	  logStep("Verifying SOD Cust param value for video call when user selecting Optoutmode scenario in privacy card" ); 
	  System.out. println("================= Verifying SOD CUST_PARAM value for video ad call  when user selecting Optoutmode scenario in privacy card started =========================" );
	  Functions.validate_SOD_Cust_param_video_Optoutmode(); 
	  System.out.println("================= Verifying SOD CUST_PARAM value for video ad call  when user selecting Optoutmode scenario in privacy card End ========================="); 
	  }
	  
	  @Test(priority = 95, enabled = true)  
	  @Title("Verifying RDP  value for feed_1 call when user selecting Optoutmode scenario in privacy card" ) 
	  public void Smoke_Test_Verifying_RDP_value_feed1ad_Optoutmode_scenario() throws  Exception {
	   logStep("Verifying RDP value for feed_1 call when user selecting Optoutmode scenario in privacy card");  
	  System.out. println("================= Verifying RDP value for feed_1 ad call  when user selecting Optoutmode scenario in privacy card started =========================" );
	  Functions.validate_RDP_homescreen_Optoutmode(); 
	  System.out.println("================= Verifying RDP value for feed_1 ad call when user selecting Optoutmode scenario in privacy card End ========================="); 
	  }
	  
	  @Test(priority = 113, enabled = true)	  
	  @Title("Verifying RDP  value for homescreen  marquee call when user selecting Optout mode scenario in privacy card") 
	  public void
	  Smoke_Test_Verifying_RDP_value_homescreenmarquee_Optout_mode_scenario() throws  Exception {
	  logStep("Verifying RDP  value for homescreen marquee call when user selecting Optout mode scenario in privacy card"); 
	  System.out.println("================= Verifying RDP value for homescreen marquee call  when user selecting Optout mode scenario in privacy card started =========================" ); 
	  Functions.validate_RDP_homescreenmarquee_Optoutmode();
	  System.out. println("================= Verifying RDP value for homescreen marquee call when user selecting Optout mode scenario in privacy card End =========================");
          }*/
	  
	/*  @Test(priority = 96, enabled = true)	  
	  @Title("Verifying RDP  value for feed ad call when user selecting Optoutmode scenario in privacy card" )
	  public void Smoke_Test_Verifying_RDP_value_feedad_Optoutmode_scenario()   throws Exception {
	  logStep("Verifying RDP  value for feed ad call when user selecting Optoutmode scenario in privacy card"  );	  
	  System.out. println("================= Verifying RDP value for feed ad  call  when user selecting Optoutmode scenario in privacy card started =========================" );  
	  Functions.validate_RDP_feed_Optoutmode(); 
	  System.out. println("================= Verifying RDP value for feed ad call when user selecting Optoutmode scenario in privacy card End =========================" ); 
	  }*/
	  
	  
	  /*@Test(priority = 97, enabled = true)	  
	  @Title("Verifying RDP  value for detailed feed ad call when user selecting Optoutmode scenario in privacy card" ) 
	  public void Smoke_Test_Verifying_RDP_value_detailed_feedad_Optoutmode_scenario() throws  Exception {
	  logStep("Verifying RDP  value for detailed feed ad call when user selecting Optoutmode scenario in privacy card"  );	
	  System.out. println("================= Verifying RDP value for detailed feed ad  call  when user selecting Optoutmode scenario in privacy card started =========================" ); 
	  Functions.validate_RDP_detailed_feed_Optoutmode(); 
	  System.out.println("================= Verifying RDP value for detailed feed ad call when user selecting Optoutmode scenario in privacy card End =========================");
	  }
	  
	  @Test(priority = 98, enabled = true)	  
	  @Title("Verifying RDP  value forvideo  ad call when user selecting Optoutmode scenario in privacy card" ) 
	  public void Smoke_Test_Verifying_RDP_value_video_adcall_Optoutmode_scenario() throws Exception {
	  logStep("Verifying RDP  value forvideo  ad call when user selecting Optoutmode scenario in privacy card" );  
	  System.out. println("================= Verifying RDP value for video  ad call  when user selecting Optoutmode scenario in privacy card started =========================");
	  Functions.validate_RDP_video_ad_Optoutmode();
	  System.out. println("================= Verifying RDP value for video ad call when user selecting Optoutmode scenario in privacy card End =========================");
	  }
	  
	  
	  
	  
      @Test(priority = 99, enabled = true)	  
	  @Title("Selecting the  Optin mode in the privacy card") public void
	  Smoke_Test_Selecting_Optin_mode_scenario() throws Exception {
	  logStep("Selecting the  Optin mode in the privacy card");
      System.out. println("=================Slecting Optin mode scenario in privacy card testcase started =========================");
	    AppFunctions.Kill_Launch_App(); 
	    Thread.sleep(10000);
	  Functions.Verify_Privacy_Card_onScreen(); 
	  Thread.sleep(10000); 
	  Functions.selecting_opt_in_mode();
	  AppFunctions.Kill_Launch_App();
	  AppFunctions.Kill_Launch_App();
	  System.out.println("================= Slecting Opt in mode scenario in privacy card  testcase End ========================="); 
	  }
	  

	  
	  @Test(priority = 100, enabled = true)  
	  @Title("Verifying video ad call when user selecting Optin mode scenario in privacy card" ) 
	  public void  Smoke_Test__Smoke_Test_Verifying_videoadcall_Optin_mode_scenario() throws Exception {
	  logStep("Verifying video call when user selecting Optin mode scenario in privacy card" ); 
	  System.out.println("=================Verifying video  ad call when user selecting Optin mode scenario in privacy card started =========================");
	  CharlesFunctions.startSessionBrowserData(); 
	  CharlesFunctions.ClearSessions();
	  AppFunctions.Kill_Launch_App();	  
	  Thread.sleep(10000);
	  AppiumFunctions.SwipeUp_Counter_video_maps_feedcards(10);
	  CharlesFunctions.ExportSession();
	  Functions.Verify_video_ad_call_Optoutmode(); 
	  System.out. println("================= Verifying video ad call when user selecting Optin mode scenario in privacy card End =========================" );	  
	  }
	  
	  @Test(priority = 101, enabled = true)
	  @Title("Verifying feed_1 ad call when user selecting Optin mode scenario in privacy card" )
	  public void Smoke_Test_Verifying_Feed_1_adcall_Optin_mode_scenario() throws Exception {  
	  logStep("Verifying feed_1 ad call when user selecting Optin mode scenario in privacy card"); 
	  System.out.println("=================Verifying feed1 ad call when user selecting Optin mode scenario in privacy card started =========================");
	  Functions.verifying_feedcalls(1); 
	  System.out.println("================= Verifying feed1 ad call when user selecting Optin mode scenario in privacy card End =========================" ); 
	  }
	  
	  
	  @Test(priority = 102, enabled = true)	  
	  @Title("Verifying maps details page ad call when user selecting Optin mode scenario in privacy card" ) 
	  public void Smoke_Test_Verifying_maps_detailpageadcall_Optin_mode_scenario() throws Exception {
	  logStep("Verifying details page ad call when user selecting Optin mode scenario in privacy card"  );
	  System.out.println("=================Verifying detail page Feed ad call when user selecting Optin mode scenario in privacy card started =========================" ); 
	  Functions.Verifying_detail_gampadcalls_Optoutmode();
	  System.out. println("================= Verifying detail page  Feed ad call when user selecting Optin mode scenario in privacy card End ========================="  );
	  }
	  
	  @Test(priority = 103, enabled = true)	  
	  @Title("Verifying BCP  call when user selecting Optin mode scenario in privacy card" )
	  public void Smoke_Test__Verifying_Bcp_apicall_Opti_mode_scenario() throws  Exception { 
	  logStep("Verifying BCP  call when user selecting Optin mode scenario in privacy card" ); 
	  System.out.println("=================Verifying BCP api call when user selecting Optin mode scenario in privacy card started =========================");	  
	  Functions.validating_bcp_privacy_Optinmode_scenarion();
	  System.out.println("================= Verifying BCP api call when user selecting Optin mode scenario in privacy card End =========================" );
	  
	  }
	  
	  @Test(priority = 104, enabled = true)	  
	  @Title("Verifying adcrw api call when user selecting Optin mode scenario in privacy card") 
	  public void Smoke_Test__Verifying_adcrw_apicall_Optin_mode_scenario() throws Exception {
	  logStep("Verifying adcrw api call when user selecting Optin mode scenario in privacy card" );	  
	  System.out. println("=================Verifying adcrw api call when user selecting Optin mode scenario in privacy card started =========================" );  
	  Functions.validating_adcrw_privacy_Optinmode_scenarion();
	  System.out.println("================= Verifying adcrw api call when user selecting Optin mode scenario in privacy card End =========================" );	  
	  }
	  
	  @Test(priority = 105, enabled = true)	  
	  @Title("Verifying Fatual api call when user selecting Optin mode scenario in privacy card" )
	  public void Smoke_Test__Verifying_locaion_apicall_Optin_mode_scenario()  throws Exception {
	   logStep("Verifying Fatual api call when user selecting Optin mode scenario in privacy card" ); 
	   System.out.println("=================Verifying Fatcual api call when user selecting Optin mode scenario in privacy card started =========================");
	   Functions.validating_Fatualcall_privacy_Optinmode_scenarion(); 
	   System.out. println("================= Verifying Fatcual api call when user selecting Oppinmode scenario in privacy card End =========================" );
	 
	  }
	  
	  @Test(priority =106, enabled = true)	  
	  @Title("Verifying amazon prerol slot id's  when user selecting Optin mode scenario in privacy card" ) 
	  public void Smoke_Test__Verifying_amaozn_slotid_Optin_mode_scenario() throws Exception {	  
	  logStep("Verifying amazon prerol slot id's when user selecting Optin mode scenario in privacy card" );
	  System.out.println("=================Verifying amazon prerol slot id's when user selecting Optin mode scenario in privacy card started =========================");
	  Functions.validating_aax_privacy_Optinmode_scenario(); 
	  System.out.println("================= Verifying amazonprerol slot id's  when user selecting Optin mode scenario in privacy card End =========================" );
	    }
	  
	  @Test(priority = 107, enabled = true)  
	  @Title("Verifying home screen marquee ad call  when user selecting Optin mode scenario in privacy card" ) 
	  public void Smoke_Test__Verifying_homescreenmarquee_calls_Optin_mode_scenario() throws Exception {
	  logStep("Verifying home screen marquee ad call  when user selecting Optin mode scenario in privacy card" ); 
	  System.out. println("=================Verifying homescreen marquee ad calls when user selecting Optin mode scenario in privacy card started ========================="); 
	  Functions. finding_Homescreen_marquee_iu_value();
	  System.out.println("================= Verifying homescreen marquee ad calls when user selecting Optin mode scenario in privacy card End =========================" );	  
	  }
	  
	 
	  
	  
	  
	  @Test(priority = 109, enabled = true)	  
	  @Title("Verifying SOD Cust param value for homescreen marquee  call when user selecting Optin mode scenario in privacy card" )
	  public void  Smoke_Test_Verifying_SOD_Cust_Param_homescreen_marquee_Optin_mode_scenario() throws  Exception {
	  logStep("Verifying SOD Cust param value for home screen marquee call when user selecting Optin mode scenario in privacy card" ); 
	  System.out.println("================= Verifying SOD CUST_PARAM value for homescreen marquee call  when user selecting Optin mode scenario in privacy card started ========================="); 
	  Functions.validate_SOD_Cust_param_homescreen_Optinmode(); 
	  System.out.println("================= Verifying SOD CUST_PARAM value for homescreen marquee call when user selecting Opttinmode scenario in privacy card End =========================" ); 
	  }
	  
	  @Test(priority = 110, enabled = true)	  
	  @Title("Verifying SOD Cust param value for  feed_1 ad call when user selecting Optin mode scenario in privacy card") 
	  public void Smoke_Test_Verifying_SOD_Cust_Param_feed_1_Optinmode_scenario()   throws Exception
	 { 
	 System.out. println("================= Verifying SOD CUST_PARAM value for feed_1 ad call  when user selecting Optin mode scenario in privacy card started =========================");
	  logStep("Verifying SOD Cust param value for  feed ad call when user selecting Optin mode scenario in privacy card"); 
	   Functions.validate_SOD_Cust_param_feed_Optinmode();
	   System.out.println("================= Verifying SOD CUST_PARAM value for feed_1 ad call  when user selecting Optin mode scenario in privacy card End ========================="  ); 
	   }
	  
	  
	  @Test(priority = 111, enabled = true)  
	  @Title("Verifying SOD Cust param value for maps detail page ad call when user selecting Optin mode scenario in privacy card" )
	  public void  Smoke_Test_Verifying_SOD_Cust_Param_mapsdetail_page_Optin_mode_scenario() throws  Exception {
	  logStep("Verifying SOD Cust param value for maps detail page ad call when user selecting Optin mode scenario in privacy card" ); 
	  System.out.println("================= Verifying SOD CUST_PARAM value for maps detailed Feed ad call  when user selecting Optin mode scenario in privacy card started =========================" );
	  Functions. validate_SOD_Cust_param_deatiledfeed_Optinmode();
	  System.out.println("================= Verifying SOD CUST_PARAM value for  maps detailed Feed ad call  when user selecting Optin mode scenario in privacy card End =========================" );
	  }
	  
	  @Test(priority = 112, enabled = true)	  
	  @Title("Verifying SOD Cust param value for video ad call when user selecting Optin mode scenario in privacy card") 
	  public void Smoke_Test_Verifying_SOD_Cust_Param_videoad_Optin_mode_scenario() throws Exception {
	  logStep("Verifying SOD Cust param value for video ad call when user selecting Optin mode scenario in privacy card");
	  System.out.println("================= Verifying SOD CUST_PARAM value for video ad call  when user selecting Optin mode scenario in privacy card started =========================" );
	  Functions.validate_SOD_Cust_param_video_Optinmode();
	  System.out.println("================= Verifying SOD CUST_PARAM value for video ad call  when user selecting Optin mode scenario in privacy card End =========================" );
	  }
	  
	  @Test(priority = 113, enabled = true)	  
	  @Title("Verifying RDP  value for home screen  marquee call when user selecting Optin mode scenario in privacy card") 
	  public void
	  Smoke_Test_Verifying_RDP_value_homescreenmarquee_Optin_mode_scenario() throws  Exception {
	  logStep("Verifying RDP  value for homescreen marquee call when user selecting Optin mode scenario in privacy card"); 
	  System.out.println("================= Verifying RDP value for homescreen marquee call  when user selecting Optin mode scenario in privacy card started =========================" ); 
	  Functions.validate_RDP_homescreen_Optinmode();
	  System.out. println("================= Verifying RDP value for homescreen marquee call when user selecting Optin mode scenario in privacy card End =========================");
    }
	  
	  @Test(priority = 114, enabled = true)	  
	  @Title("Verifying RDP  value for feed_1 ad call when user selecting Optin mode scenario in privacy card")
	  public void Smoke_Test_Verifying_RDP_value_feed_1ad_Optin_mode_scenario()  throws Exception {	
	  logStep("Verifying RDP  value for feed_1 ad call when user selecting Optin mode scenario in privacy card" );  
	  System.out. println("================= Verifying RDP value for feed_1 ad  call  when user selecting Optin mode scenario in privacy card started =========================" );
	  Functions.validate_RDP_feed_Optinmode();
	  System.out.println("================= Verifying RDP value for feed_1 ad call when user selecting Optin mode scenario in privacy card End ========================="); 
	  }
	  
	  
	  @Test(priority = 115, enabled = true)
	  @Title("Verifying RDP value for maps detailed page ad call when user selecting Optin mode scenario in privacy card" ) 
	  public void Smoke_Test_Verifying_RDP_value_mapsdetailed_feedad_Optinmode_scenario()  throws Exception {
	  logStep("Verifying RDP value for maps detailed page ad call when user selecting Optin mode scenario in privacy card" ); 
	  System.out.println("================= Verifying RDP value for maps detailes ad call  when user selecting Optin mode scenario in privacy card started =========================");
	   Functions.validate_RDP_detailed_feed_Optinmode(); 
	   System.out. println("================= Verifying RDP value for maps detailes ad call when user selecting Optin mode scenario in privacy card End =========================" );
	   }
	  
	  @Test(priority = 116, enabled = true)  
	  @Title("Verifying RDP value for video  ad call  url when user selecting Optin mode scenario in privacy card" ) 
	  public void Smoke_Test_Verifying_RDP_value_video_adcall_Optin_mode_scenario() throws  Exception {	  
	 System.out. println("================= Verifying RDP value for video  ad call url  when user selecting Optin mode scenario in privacy card started =========================" );
	  logStep("Verifying RDP  value for video  ad call url when user selecting Optin mode scenario in privacy card");
	  Functions.validate_RDP_video_ad_Optinmode(); 
	  System.out. println("================= Verifying RDP value for video ad call url when user selecting Optin mode scenario in privacy card End =========================" );
	  }*/
	  
	  
	/*@Test(priority=150,enabled = true)  
 @Title("Verifying NextGen IM ad call unit") 
	public void Smoke_Test_NextGen_IM_adunit() throws Exception { 
		System.out.println("================= Verify  NextGen IM adunit testcase Started =========================");
		AppFunctions.Kill_Launch_App();
      AppFunctions.selectingRequiredUserGroup("AdsTestAdUnitOnly");
      Ad.runAppInBackground(30);
      CharlesFunctions.ClearSessions();  
      AppFunctions.Kill_Launch_App();
	  Thread.sleep(5000); 
	    CharlesFunctions.ClearSessions();
	    CharlesFunctions.startSessionBrowserData();
	    AppFunctions.enter_requiredLocation("30124");
	   CharlesFunctions.ExportSession();
	  Functions.nextgenim_adunit(); 
	  System.out.println("================= Verify  NextGen IM adunit testcase End =========================");
	  
	  }
	
	  @Test(priority=151,enabled = true)	  
	  @Title("Verifying  NextGen IM ad card call response") public void
	  Smoke_Test_verifying_NextGenIM_response() throws Exception { System.out.
	  println("================= Verify  NextGen IM ad response testcase started =========================" );  
	  Functions.nextgenim_adcall_response(); 
	  System.out.println("================= Verify   NextGen IM ad  response testcase End =========================");  
	  }
	  
	  
	   @Test(priority=152,enabled = true)  
	  @Title("Verifying the FG URL for nextgen ad call") public void
	  Smoke_Test_verifying_FG_url_NextgenIm_Ad() throws Exception { 
		System.out. println("================= Verify  Nextgen Im ad FG URL testcase started =========================" );
	  Functions.validate_FG_adcall_NextGenIM(); 
	  System.out. println("================= Verify  Nextgen Im ad FG URL testcase End =========================" );
	    }
	  
	  
	   @Test(priority=152,enabled = true)  
		  @Title("Verifying the BG URL for nextgen ad call") public void
		  Smoke_Test_verifying_BG_urls_NextgenIm_Ad() throws Exception { System.out.
		  println("================= Verify  NextgenIM ad BG URL testcase started =========================" );
		  Functions.validate_BG_adcall_NextGenIM(); 
		  System.out. println("================= Verify  NextgenIM ad BG URL testcase End =========================" );
		    }
	  @Test(priority=153,enabled = true)	  
	  @Title("Verifying the Size for nextgen ad call") public void
	  Smoke_Test_verifying_Size_NextgenIm_Ad() throws Exception { 
      System.out. println("================= Verify  Nextgen Im adunit response testcase started =========================" );  
	  Functions.validate_Size_NextGenIM(); 
	  System.out.println("================= Verify  Nextgen Im adunit response testcase End =========================" ); 
	  }
	  
	  
	   @Test(priority=155,enabled = true) 
	  @Title("Verifying iu value for daily feed card") 
	  public void Smoke_Test_Verify_daily_card_adcall_iu() throws Exception { 
		System.out. println("================= Verifyig daily adcall_iu Started =========================" );
		CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData();
		AppiumFunctions.SwipeUp_Counter_feedcards(30);
		AppFunctions.enter_requiredLocation("30124");
		Functions. Verify_dailycard_iu(); 
		System.out.println("================= Verify_daily_card_adcall_iu End =========================" );
		}
	  
	  
	   @Test(priority=155,enabled = true) 
	  @Title("Verifying daily IF ad card call response") public void
	  Smoke_Test_verifying_DailyIFcardResponse() throws Exception {
	  System.out.println("================= Verify  Daily IF card response testcase started =========================" ); 
		 Functions.dailyIFCard_adcall_response(); 
	  System.out.println("================= Verify  Daily IF card response testcase End =========================");  
	  }
	  
	  @Test(priority=156,enabled = true)  
	  @Title("Verifying the response for Daily IF card") public void
	  Smoke_Test_verifying_FG_url_DailyIF_Card() throws Exception { System.out.
	  println("================= Verifying Daily IF card FG asses call  testcase started ========================="  );  
	  Functions.validate_FG_url_DailyIFcard();
	  System.out.println("================= Verifying Daily IF card FG asses call  testcase   End =========================" ); 
	  }
	 
	  @Test(priority=156,enabled = true)  
	  @Title("Verifying the response for Daily IF card") public void
	  Smoke_Test_verifying_BG_url_DailyIF_Card() throws Exception { System.out.
	  println("================= Verifying Daily IF card BG asses call  testcase started ========================="  );  
	  Functions.validate_BG_url_DailyIFcard();
	  System.out.println("=================Verifying Daily IF card BG asses call  testcase  End =========================" ); 
	  }
	
	  @Test(priority=157,enabled = true)
	  @Title("Verifying the Size for Daily  ad call") 
	  public void Smoke_Test_verifying_Size_DailyIFCard() throws Exception { 
	 System.out.println("================= Verify  Nextgen Im adunit response testcase started =========================" );
	 Functions.validate_Size_DailyIFCard(); 
	 System.out.println("================= Verify  Nextgen Im adunit response testcase End =========================" ); 
	 }
	 

	@Test(priority=150,enabled = true)  
 @Title("Verifying NextGenIM ad call unit for video") 
	public void Smoke_Test_NextGen_IM_adunit_video() throws Exception { 
		System.out.println("================= Verify  NextGen IM adunit testcase Started =========================");
		AppFunctions.Kill_Launch_App();
      AppFunctions.selectingRequiredUserGroup("AdsTestAdUnitOnly");
      Ad.runAppInBackground(30);
      CharlesFunctions.ClearSessions();  
      AppFunctions.Kill_Launch_App();
	  Thread.sleep(5000); 
	    CharlesFunctions.ClearSessions();
	    CharlesFunctions.startSessionBrowserData();
	    AppFunctions.enter_requiredLocation("30124");
	   CharlesFunctions.ExportSession();
	  Functions.nextgenim_adunit(); 
	  System.out.println("================= Verify  NextGen IM adunit testcase End =========================");
	  
	  }
	
	  @Test(priority=151,enabled = true)	  
	  @Title("Verifying  NextGen IM sd call response for video") public void
	  Smoke_Test_verifying_NextGenIM_response_video() throws Exception { System.out.
	  println("================= Verify  NextGen IM ad response testcase started =========================" );  
	  Functions.nextgenim_adcall_response(); 
	  System.out.println("================= Verify   NextGen IM ad  response testcase End =========================");  
	  }
	  
	  
	   @Test(priority=152,enabled = true)  
	  @Title("Verifying the FG URL for nextgen ad call video") public void
	  Smoke_Test_verifying_FG_url_NextgenIm_Ad_video() throws Exception { 
		System.out. println("================= Verify  Nextgen Im ad FG URL testcase started =========================" );
	  Functions.validate_FG_adcall_NextGenIM(); 
	  System.out. println("================= Verify  Nextgen Im ad FG URL testcase End =========================" );
	    }
	  
	  
	   @Test(priority=152,enabled = true)  
		  @Title("Verifying the BG URL for nextgen ad call video") public void
		  Smoke_Test_verifying_BG_urls_NextgenIm_Ad_video() throws Exception { System.out.
		  println("================= Verify  NextgenIM ad BG URL testcase started =========================" );
		  Functions.validate_BG_adcall_NextGenIM(); 
		  System.out. println("================= Verify  NextgenIM ad BG URL testcase End =========================" );
		    }
	  @Test(priority=153,enabled = true)	  
	  @Title("Verifying the Size for nextgen ad call video") public void
	  Smoke_Test_verifying_Size_NextgenIm_Ad_video() throws Exception { 
      System.out. println("================= Verify  Nextgen Im adunit response testcase started =========================" );  
	  Functions.validate_Size_NextGenIM(); 
	  System.out.println("================= Verify  Nextgen Im adunit response testcase End =========================" ); 
	  }
	  
	  
	   @Test(priority=155,enabled = true) 
	  @Title("Verifying iu value for daily feed card") 
	  public void Smoke_Test_Verify_daily_card_adcall_iu_video() throws Exception { 
		System.out. println("================= Verifyig daily adcall_iu Started =========================" );
		CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData();
		AppiumFunctions.SwipeUp_Counter_feedcards(30);
		AppFunctions.enter_requiredLocation("30124");
		Functions. Verify_dailycard_iu(); 
		System.out.println("================= Verify_daily_card_adcall_iu End =========================" );
		}
	  
	  
	   @Test(priority=155,enabled = true) 
	  @Title("Verifying daily IF ad card call response for video") public void
	  Smoke_Test_verifying_DailyIFcardResponse_video() throws Exception {
	  System.out.println("================= Verify  Daily IF card response testcase started =========================" ); 
		 Functions.dailyIFCard_adcall_response(); 
	  System.out.println("================= Verify  Daily IF card response testcase End =========================");  
	  }
	  
	  @Test(priority=156,enabled = true)  
	  @Title("Verifying the response for Daily IF card") public void
	  Smoke_Test_verifying_FG_url_DailyIF_Card_video() throws Exception { System.out.
	  println("================= Verifying Daily IF card FG asses call  testcase started ========================="  );  
	  Functions.validate_FG_url_DailyIFcard();
	  System.out.println("================= Verifying Daily IF card FG asses call  testcase   End =========================" ); 
	  }
	 
	  @Test(priority=156,enabled = true)  
	  @Title("Verifying the response for Daily IF card for video") public void
	  Smoke_Test_verifying_BG_url_DailyIF_Card_video() throws Exception { System.out.
	  println("================= Verifying Daily IF card BG asses call  testcase started ========================="  );  
	  Functions.validate_BG_url_DailyIFcard();
	  System.out.println("=================Verifying Daily IF card BG asses call  testcase  End =========================" ); 
	  }
	
	  @Test(priority=157,enabled = true)
	  @Title("Verifying the Size for Daily  ad call for video") 
	  public void Smoke_Test_verifying_Size_DailyIFCard_video() throws Exception { 
	 System.out.println("================= Verify  Nextgen Im adunit response testcase started =========================" );
	 Functions.validate_Size_DailyIFCard(); 
	 System.out.println("================= Verify  Nextgen Im adunit response testcase End =========================" ); 
	 }*/
	  
	  
	  
	
	@BeforeTest
	public void Before_Test() throws Exception {
		System.out.println("================= Before Test Started =========================");
		//CharlesFunctions.app_download_from_firebaselink();
		 CharlesFunctions.charlesOpen();
		AppiumFunctions.UnInstallApp();
		CharlesFunctions.openCharlesBrowser();
		// CharlesFunctions.app_download_from_firebaselink();
		// MapLocalFunctions.alertModeChanges("withoutalert");
		// CharlesFunctions.ClearSessions();
		// CharlesFunctions.startSessionBrowserData();
			//CharlesFunctions.ExportSession();
		// AppiumFunctions.killADB(); 
		// AppiumFunctions.UnInstallApp();
		 //AppiumFunctions.AppiumServerStop(); 
		// AppiumFunctions.AppiumServerStart();
		 
		// CharlesFunctions.ClearSessions();

		 // CharlesFunctions.startSessionBrowserData();
		  //CharlesFunctions.app_download_from_firebaselink();
		AppiumFunctions.LaunchAppWithFullReset();
		Thread.sleep(20000);
		//AppiumFunctions.Kill_launch();
	//	Thread.sleep(5000);
		AppFunctions.gettingApkVersion() ;
		//Thread.sleep(5000);
	//	AppFunctions.enablingBranch("adsTestAutomation2");
		//AppiumFunctions.Kill_launch();
		//AppiumFunctions.Kill_launch();
		//AppFunctions.enter_requiredLocation("10005");
		Thread.sleep(10000);
		//AppiumFunctions.SwipeUp_Counter_feedcards(30);
	//	AppFunctions.selectingRequiredUserGroup("multi cards");
		// Ad.runAppInBackground(30);
		// AppFunctions.Kill_Launch_App();
		// AppFunctions.enablingBranch("adsTestAutomation2");
		// Ad.runAppInBackground(30);
		// AppFunctions.Kill_Launch_App();
		//AppFunctions.Kill_Launch_App();
	// AppiumFunctions.ClickonIUnderstand();
		// AppiumFunctions.getFeedCardsListAndNavigateToThem(false);//not going details
		// AppiumFunctions.getFeedCardsListAndNavigateToThem(true);//going details
		// AppiumFunctions.navigateToAllCardsByCardSize();
		// AppiumFunctions.getFeedCardsListAndNavigateToThem(true);

		System.out.println("================= Before Test End =========================");

	}

	/*
	 * @Test(priority=1000,enabled = true)
	 * 
	 * @Title("Verifying wfxtg trigger api call url") public void
	 * Smoke_Test_CaseVerify_WeatherFXAPI_url() throws Exception { System.out.
	 * println("================= Verifying WeatherFX API url started ========================="
	 * ); //CharlesFunctions.startSessionBrowserData();
	 * CharlesFunctions.ExportSession(); Functions.validating_WeatherFXAPI();
	 * System.out.
	 * println("================= Verifying WeatherFX API url End ========================="
	 * ); }
	 */

	/*
	 * (@Test(priority=2,enabled = true)
	 * 
	 * @Title("Verifying Location/Factual  api call url") public void
	 * Smoke_Test_CaseVerify_Factualapi_url() throws Exception { System.out.
	 * println("================= Verifying WeatherFX API url started ========================="
	 * ); Functions.validating_Fatual(); System.out.
	 * println("================= Verifying WeatherFX API url End ========================="
	 * ); }
	 */

	/*
	 * @Test(priority=300000,enabled = true)
	 * 
	 * @Title("Verifying turbo call api url") public void
	 * Smoke_Test_CaseVerify_turbo_url() throws Exception { System.out.
	 * println("================= Verifying Turbo call  API url started ========================="
	 * ); Functions.validating_turbocallAPI(); System.out.
	 * println("================= Verifying Turbo call API url End ========================="
	 * ); }
	 * 
	 * @Test(priority=400000,enabled = true)
	 * 
	 * @Title("Verifying Lotame api call url") public void
	 * Smoke_Test_CaseVerify_adcrwdcntrlnet_url() throws Exception { System.out.
	 * println("================= Verifying Lotame ad.crwdcntrl.net url started ========================="
	 * ); Functions.validating_adcrw(); System.out.
	 * println("================= Verifying Lotame ad.crwdcntrl.net url End ========================="
	 * ); }
	 * 
	 * @Test(priority=5000000,enabled = true)
	 * 
	 * @Title("Verifying Homescreenhourly ad call") public void
	 * Smoke_Test_CaseVerify_Homescreen_ad_iu() throws Exception { System.out.
	 * println("================= verifying iu value for health_and_activitiescard_iu started ========================="
	 * ); logStep(" Verifying homescreen hourly ad call on FTL");
	 * Functions.finding_Homescreen_iu_value(); System.out.
	 * println("================= verifying iu value for health_and_activitiescard__iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=6000000,enabled = true)
	 * 
	 * @Title("Verifying Home screen marquee ad call") public void
	 * Smoke_Test_CaseVerify_Homescreen_marquee_ad_iu() throws Exception {
	 * System.out.
	 * println("================= verifying iu value for home screen marquee test case started ========================="
	 * ); logStep(" Verifying homescreen marquee ad call on FTL");
	 * Functions.finding_Homescreen_marquee_iu_value(); System.out.
	 * println("================= verifying iu value for home screen marquee test case End ========================="
	 * ); }
	 * 
	 * @Test(priority=7000000,enabled = true)
	 * 
	 * @Title("Verifying amazon aax for home screen hourly preroll ad call") public
	 * void Smoke_Test_amazon_aax_home_screen_today_preroll_adcall__iu() throws
	 * Exception { System.out.
	 * println("================= Verify amazon aax home screenhourly preroll adcall Started ========================="
	 * ); //AppFunctions.Pull_To_Refresh("Pulltorefresh");
	 * //CharlesFunctions.startSessionBrowserData(); //
	 * CharlesFunctions.ExportSession();
	 * logStep(" Verifying preload amazon aax for homescreenhourly"); Functions.
	 * get_aaxcal_homescreen_hourly(); System.out.
	 * println("================= Verify amazon aax home screenhourly preroll adcall End ========================="
	 * ); }
	 * 
	 * 
	 * @Test(priority=8765756,enabled = true)
	 * 
	 * @Title("Verifying amazon aax for radar card preroll ad call") public void
	 * Smoke_Test_amazon_aax_rader_card_preroll_adcall() throws Exception {
	 * System.out.
	 * println("================= Verify amazon aax radar card preroll adcall Started ========================="
	 * ); logStep(" Verifying preload amazon aax for radar card");
	 * Functions.get_aaxcal_radar(); System.out.
	 * println("================= Verify amazon aax radar card preroll adcall End ========================="
	 * ); }
	 * 
	 * @Test(priority=90000,enabled = true)
	 * 
	 * @Title("Verifying amazon aax for map details preroll ad call") public void
	 * Smoke_Test_amazon_aax_mapsdetails_preload_adcall() throws Exception {
	 * System.out.
	 * println("================= Verify amazon aax Maps card preroll adcall Started ========================="
	 * ); logStep(" Verifying preload amazon aax for  map details");
	 * //Functions.get_aaxcal_map_details(); System.out.
	 * println("================= Verify amazon aax Maps card preroll adcall End ========================="
	 * ); }
	 * 
	 * @Test(priority=100000,enabled = true)
	 * 
	 * @Title("Verifying amazon for aax Air Quality preroll ad call") public void
	 * Smoke_Test_amazon_aax_AQ_card_preroll_adcall() throws Exception { System.out.
	 * println("================= Verify amazon aax  Air Quality card preroll adcall Started ========================="
	 * ); logStep(" Verifying preload amazon aax for air quality card"); //
	 * Functions.get_aaxcal_AirQuality(); System.out.
	 * println("================= Verify amazon aax  Air Quality card preroll adcall End ========================="
	 * ); }
	 * 
	 * @Test(priority=1111324,enabled = true)
	 * 
	 * @Title("Verifying amazon aax for Hourly details preroll ad call") public void
	 * Smoke_Test_amazon_aax_Hourly_preroll_adcall() throws Exception { System.out.
	 * println("================= Verify amazon aax Hourly details preroll adcall Started ========================="
	 * ); logStep(" Verifying preload amazon aax for  hourly details");
	 * //Functions.get_aaxcal_Hourly(); System.out.
	 * println("================= Verify amazon aax Hourly details preroll adcall End ========================="
	 * ); }
	 * 
	 * @Test(priority=126868,enabled = true)
	 * 
	 * @Title("Verifying amazon aax  for daily details preroll ad call") public void
	 * Smoke_Test_amazon_aax_Daily_preroll_adcall() throws Exception { System.out.
	 * println("================= Verify amazon aax Daily details preroll adcall Started ========================="
	 * ); logStep(" Verifying preload amazon aax for  daily details"); //
	 * Functions.get_aaxcal_Daily(); System.out.
	 * println("================= Verify amazon aax Daily details preroll adcall End ========================="
	 * ); }
	 * 
	 * @Test(priority=132343245,enabled = true)
	 * 
	 * @Title("Verifying amazon aax video preroll ad call") public void
	 * Smoke_Test_amazon_aax_video_preroll_adcall() throws Exception { System.out.
	 * println("================= Verify amazon aax video preload adcall Started ========================="
	 * ); logStep(" Verifying preload amazon aax for  video details");
	 * //Functions.get_aaxcal_video_details(); System.out.
	 * println("================= Verify amazon aax video preload adcall End ========================="
	 * ); }
	 */

	/*
	 * @Test(priority=2432,enabled = true)
	 * 
	 * @Title("Verifying Video ad call") public void
	 * Smoke_Test_Case_Verify_Video_adCalll() throws Exception { System.out.
	 * println("================= Verifying Video ad call testcase  started ========================="
	 * ); CharlesFunctions.ClearSessions();
	 * CharlesFunctions.clearSessionBrowserData(); //
	 * CharlesFunctions.startSessionBrowserData();
	 * 
	 * Thread.sleep(50000);
	 * 
	 * Thread.sleep(50000);
	 * 
	 * Thread.sleep(50000); Thread.sleep(50000); Thread.sleep(50000);
	 * Thread.sleep(50000);
	 */
	/*
	 * AppiumFunctions.clickOnUnderstandbutton(); // AppFunctions.Kill_Launch_App();
	 * AppiumFunctions.Kill_launch(); AppiumFunctions.clickOnUnderstandbutton();
	 * AppiumFunctions.Swipeforappdeckapk(); AppiumFunctions.Kill_launch();
	 * Thread.sleep(10000); AppiumFunctions.SwipeUp_Counter(1); Thread.sleep(3000);
	 * AppiumFunctions.clickOnVideoElement(); Thread.sleep(5000);
	 * Thread.sleep(5000); AppiumFunctions.clickOnBackArrowElement();
	 * Thread.sleep(5000); Thread.sleep(5000); AppiumFunctions.SwipeUp_Counter(1);
	 * // AppiumFunctions.click_hurricane_element();
	 * AppiumFunctions.clickOnBackArrowElement();
	 * AppiumFunctions.SwipeUp_Counter(2); AppiumFunctions.clickOnRadarMaps();
	 * AppiumFunctions.clickOnBackArrowElement();
	 * AppiumFunctions.SwipeUp_Counter(2);
	 * AppiumFunctions.click_Boat_Beach_element();
	 * AppiumFunctions.clickOnBackArrowElement(); //
	 * AppiumFunctions.click_Running_element();
	 * AppiumFunctions.clickOnBackArrowElement();
	 * AppiumFunctions.click_cold_Flu_element();
	 * AppiumFunctions.clickOnBackArrowElement();
	 * AppiumFunctions.click_Allergy_element(); //
	 * AppiumFunctions.clickOnBackArrowElement();
	 * AppiumFunctions.click_Running_element(); //
	 * AppiumFunctions.clickOnBackArrowElement();
	 * AppiumFunctions.SwipeUp_Counter(1);
	 * 
	 * AppiumFunctions.click_Todaydetails_element();
	 * AppiumFunctions.clickOnBackArrowElement_trending();
	 * AppiumFunctions.SwipeUp_Counter(1);
	 * 
	 * Thread.sleep(3000); AppiumFunctions.SwipeUp_Counter(1);
	 * AppiumFunctions.click_Airpollution_element();
	 * AppiumFunctions.clickOnBackArrowElement(); Thread.sleep(5000);
	 * AppiumFunctions.SwipeUp_Counter(1); AppiumFunctions.click_SH_element();
	 * AppiumFunctions.clickOnBackArrowElement(); Thread.sleep(5000);
	 * AppiumFunctions.SwipeUp_Counter(1); AppiumFunctions.click_news_element();
	 * AppiumFunctions.clickOnBackArrowElement(); Thread.sleep(5000);
	 * AppiumFunctions.click_hourly_element();
	 */
	// CharlesFunctions.ExportSession();
	// Functions.finding_VideoCard_iu_value();
	// System.out.println("================= Verifying Video ad call testcase End
	// =========================" );
	// }

	/*
	 * @Test(priority=23432,enabled = true)
	 * 
	 * @Title("Verifying iu value for Hurricane detailpage ad call iu") public void
	 * Smoke_Test_Verify_News_hurricane_detail_adcall_iu() throws Exception {
	 * System.out.
	 * println("================= Verify_hurricane_detailpage_adcall_iu Started ========================="
	 * ); Functions.Verify_Hurricane_detailpage_adcall_iu(); System.out.
	 * println("================= Verify_hurricane_detailpage_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=23,enabled = true)
	 * 
	 * @Title("Verifying iu value for hurricane details maps page") public void
	 * Smoke_Test_CaseVerify_hurricane_Maps_deatailscard_adcall() throws Exception {
	 * System.out.
	 * println("================= Verifying iu value for hurricane deatails maps page started ========================="
	 * ); logStep("Verifying iu value for hurricane details maps page");
	 * Functions.finding_hurricane_Map_detaiedpage_iu_value(); System.out.
	 * println("================= Verifying iu value for hurricane deatails maps page  End ========================="
	 * ); }
	 * 
	 * 
	 * @Test(priority=24,enabled = true)
	 * 
	 * @Title("Verifying iu value for hurricane  articles page") public void
	 * Smoke_Test_CaseVerify_hurricane_articles_deatailspage_adcall() throws
	 * Exception { System.out.
	 * println("================= Verifying iu value for hurricane articles deatails  page started ========================="
	 * ); logStep("Verifying iu value for hurricane  articles page"); Functions.
	 * finding_hurricane_art_detailedpage_iu_value(); System.out.
	 * println("================= Verifying iu value for hurricane articles deatails  page  End ========================="
	 * ); }
	 */

	/*
	 * @Test(priority=14,enabled = true)
	 * 
	 * @Title("Verifying iu value for hurricane details  articles page") public void
	 * Smoke_Test_CaseVerify_hurricane_articles_deatailscard_adcall() throws
	 * Exception { logStep(""); System.out.
	 * println("================= verifying iu value for Radar&Maps deatail card started ========================="
	 * ); Functions. finding_hurricane_art_detailedpage_iu_value() ; System.out.
	 * println("================= verifying iu value for Radar&Maps deatail card  End ========================="
	 * ); }
	 */
	/*
	 * @Test(priority=25,enabled = true)
	 * 
	 * @Title("Verifying Video ad call in hurricane module") public void
	 * Smoke_Test_Case_Verify_hurricanevideo_adCalll() throws Exception {
	 * logStep("Verifying Video ad call in hurricane module"); System.out.
	 * println("================= Verifying Video ad call testcase  started ========================="
	 * ); Functions.Verify_News_detailpage_adcall_iu(); System.out.
	 * println("================= Verifying Video ad call testcase  End ========================="
	 * ); }
	 * 
	 * 
	 * 
	 * @Test(priority=26,enabled = true)
	 * 
	 * @Title("Verifying iu value for news detailpage ad call iu") public void
	 * Smoke_Test_Verify_News_detailpage_adcall_iu() throws Exception { System.out.
	 * println("================= Verify_News_detailpage_adcall_iu Started ========================="
	 * ); Functions.Verify_News_detailpage_adcall_iu(); System.out.
	 * println("================= Verify_News_detailpage_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority = 27, enabled = true)
	 * 
	 * @Title("Verifying iu value for outdoor conditions  feed card iu") public void
	 * Smoke_Test_Verify_SeasonalHub_feedcard_adcall_iu() throws Exception {
	 * System.out.
	 * println("================= Verify_SH_feedcard_adcall_iu Started ========================="
	 * ); Functions.Verify_SH_feedcard_adcall_iu(); System.out.
	 * println("================= Verify_SH_feedcard_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority = 28, enabled = true)
	 * 
	 * @Title("Verifying iu value for outdoor conditions  detailed  page  iu")
	 * public void Smoke_Test_Verify_SeasonalHub_detailpage_adcall_iu() throws
	 * Exception { System.out.
	 * println("================= Verify_SH_detailpage_adcall_iu Started ========================="
	 * ); Functions.Verify_SH_detailpage_adcall_iu(); System.out.
	 * println("================= Verify_SH_detailpage_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=29,enabled = true)
	 * 
	 * @Title("Verifying iu value for Health&Activities  feed card") public void
	 * Smoke_Test_CaseVerify_Health_Activities_feed_adcall() throws Exception {
	 * System.out.
	 * println("================= verifying iu value Health&Activities feed card started ========================="
	 * ); Functions.finding_H_C_adcalL_iu(); System.out.
	 * println("================= verifying iu value Health&Activities feed card End ========================="
	 * ); }
	 * 
	 * @Test(priority=30,enabled = true)
	 * 
	 * @Title("Verifying  iu value for Running content page") public void
	 * Smoke_Test_Verify_health_and_activities_Running_spotlight_adcall_iu() throws
	 * Exception { System.out.
	 * println("================= Verify_health_and_activities_Running_spotlight_adcall_iu Started ========================="
	 * ); Functions. health_and_activities_Running_spotlight_adcall_iu();
	 * System.out.
	 * println("================= Verify_health_and_activities_Running_spotlight_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=31,enabled = true)
	 * 
	 * @Title("Verifying iu value for Boat&Beach content page") public void
	 * Smoke_Test_Verify_health_and_activities_Bot_beach_detailpage_adcall_iu()
	 * throws Exception { System.out.
	 * println("================= Verify_health_and_activities_Bot&beach_Spotlight_adcall_iu Started ========================="
	 * ); Functions.health_and_activities_Boat_beach_detailpage_adcall_iu();
	 * System.out.
	 * println("================= Verify_health_and_activities_Bot&beach_Spotlight_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=32,enabled = true)
	 * 
	 * @Title("Verifying iu value for Allergy content page") public void
	 * Smoke_Test_Verify_health_and_activities_Allergy_detailpage_adcall_iu() throws
	 * Exception { System.out.
	 * println("================= Verify_health_and_activities_Allergy_Spotlight_adcall_iu Started ========================="
	 * ); Functions.health_and_activities_Allergy_detailpage_adcall_iu();
	 * System.out.
	 * println("================= Verify_health_and_activities_Allergy_Spotlight_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=33,enabled = true)
	 * 
	 * @Title("Verifying iu value for Cold&Flu content page") public void
	 * Smoke_Test_Verify_health_and_activities_cold_flu_Spotlight_adcall_iu() throws
	 * Exception { System.out.
	 * println("================= Verify_health_and_activities_cold_flu_Spotlight_adcall_iu Started ========================="
	 * ); Functions.health_and_activities_Cold_Flu_detailpage_adcall_iu();
	 * System.out.
	 * println("================= Verify_health_and_activities_cold_flu_Spotlight_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=34,enabled = true)
	 * 
	 * @Title("Verifying iu value for  Air Quality feed card") public void
	 * Smoke_Verify_est_Air_Quality_feedcard_adcall_iu() throws Exception {
	 * System.out.
	 * println("================= Verifying iu value for Air Quality fedd card testcase  started ========================="
	 * ); Functions.AirQuality_adcall_iu(); System.out.
	 * println("================= Verifying iu value for Air Quality fedd card testcase  End ========================="
	 * ); }
	 * 
	 * @Test(priority=35,enabled = true)
	 * 
	 * @Title("Verifying iu value for  Air Quality content page") public void
	 * Smoke_Test_Verify_Air_Quality_detailpage_adcall_iu() throws Exception {
	 * System.out.
	 * println("================= Verifying iu value for Air Quality content page testcase  started ========================="
	 * ); Functions.AirQuality_detailed_adcall_iu(); System.out.
	 * println("================= Verifying iu value for Air Quality content page testcase  End ========================="
	 * ); }
	 * 
	 * @Test(priority=36,enabled = true)
	 * 
	 * @Title("Verifying iu value Today details Page ") public void
	 * Smoke_Test_CaseVerify_Today_details_page_iu() throws Exception { System.out.
	 * println("================= verifying iu value for Today_details_page_iu started ========================="
	 * ); Functions.finding_Today_detail_page_iu_value(); System.out.
	 * println("================= verifying iu value for Today_details_page_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=37,enabled = true)
	 * 
	 * @Title("Verifying iu value covid19 details Page ") public void
	 * Smoke_Test_CaseVerify_coivd_details_page_iu() throws Exception { System.out.
	 * println("================= verifying iu value for covid details page  started ========================="
	 * ); Functions.Verify_coivid19_detailpage_adcall_iu() ; System.out.
	 * println("================= verifying iu value for covid details page End ========================="
	 * ); }
	 * 
	 * @Test(priority=38,enabled = true)
	 * 
	 * @Title("Verifying iu value for Radar feed card ") public void
	 * Smoke_Test_CaseVerify_Radar_Maps_feedcard_adcall() throws Exception {
	 * System.out.
	 * println("================= verifying iu value for Radar&Maps feed card started ========================="
	 * ); Functions.finding_Radar_Map_feedcard_iu_value(); System.out.
	 * println("================= verifying iu value for Radar&Maps feed card  End ========================="
	 * ); }
	 * 
	 * @Test(priority=39,enabled = true)
	 * 
	 * @Title("Verifying iu value for maps details card") public void
	 * Smoke_Test_CaseVerify_Radar_Maps_deatailscard_adcall() throws Exception {
	 * System.out.
	 * println("================= verifying iu value for Radar&Maps deatail card started ========================="
	 * ); Functions.finding_Radar_Map_card_iu_value(); System.out.
	 * println("================= verifying iu value for Radar&Maps deatail card  End ========================="
	 * ); }
	 * 
	 * @Test(priority=40,enabled = true)
	 * 
	 * @Title("Verifying iu value for daily feed card") public void
	 * Smoke_Test_Verify_daily_card_adcall_iu() throws Exception { System.out.
	 * println("================= Verifyig daily adcall_iu Started ========================="
	 * ); Functions. Verify_dailycard_iu(); System.out.
	 * println("================= Verify_daily_card_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=41,enabled = true)
	 * 
	 * @Title("Verifying iu value for hourly detailpage") public void
	 * Smoke_Test_Verify_hourly_detailpage_adcall_iu() throws Exception {
	 * System.out.
	 * println("================= Verifying hourly_detailpage_adcall_iu Started ========================="
	 * ); Functions.Verify_hourly_detailpage_adcall_iu(); System.out.
	 * println("================= Verifying hourly_detailpage_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=42,enabled = true)
	 * 
	 * @Title("Verifying iu value for hourly1 bigad  detailpage") public void
	 * Smoke_Test_Verify_hourly1_bigad_detailpage_adcall_iu() throws Exception {
	 * System.out.
	 * println("================= Verifying hourly1 big ad detailpage_adcall_iu Started ========================="
	 * ); Functions.Verify_hourly_detailpage_bigad1_adcall_iu(); System.out.
	 * println("================= Verifying hourly1 big ad detailpage_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=43,enabled = true)
	 * 
	 * @Title("Verifying iu value for hourly2 bigad  detailpage") public void
	 * Smoke_Test_Verify_hourly2_bigad_detailpage_adcall_iu() throws Exception {
	 * System.out.
	 * println("================= Verifying hourly2 bigad detailpage_adcall_iu Started ========================="
	 * ); Functions.Verify_hourly_detailpage_bigad2_adcall_iu(); System.out.
	 * println("================= Verifying hourly2 bigad detailpage_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=44,enabled = true)
	 * 
	 * @Title("Verifying iu value for hourly3 bigad  detailpage") public void
	 * Smoke_Test_Verify_hourly3_bigad_detailpage_adcall_iu() throws Exception {
	 * System.out.
	 * println("================= Verifying hourly3 bigad detailpage_adcall_iu Started ========================="
	 * ); Functions.Verify_hourly_detailpage_bigad3_adcall_iu(); System.out.
	 * println("================= Verifying hourly3 bigad detailpage_adcall_iu End ========================="
	 * ); }
	 * 
	 * 
	 * @Test(priority=45,enabled = true)
	 * 
	 * @Title("Verifying amazon axx slot for new article") public void
	 * Smoke_Test_Verify_amazon_aax_News_adcall() throws Exception { System.out.
	 * println("================= verifying amazon aax slot for news article started ========================="
	 * ); Functions.get_aaxcal_news(); System.out.
	 * println("================= verifying amazon aax slot for news article  End ========================="
	 * ); }
	 * 
	 * @Test(priority=46,enabled = true)
	 * 
	 * @Title("Verifying hurricane aax call") public void
	 * Smoke_Test_CaseVerify_hurricane_detal_aax_adcalll() throws Exception {
	 * System.out.
	 * println("================= Verifying amazon hurricane details aax call  started ========================="
	 * ); Functions.get_aaxcal_hurricanedetails(); System.out.
	 * println("================= Verifying amazon hurricane details aax call End ========================="
	 * ); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @Test(priority=47,enabled = true)
	 * 
	 * @Title("Verifying amazon aax for today details card") public void
	 * Smoke_Test_amazon_aax_today_deatailcard() throws Exception { System.out.
	 * println("================= Verify amazon aax for today detail adcard Started ========================="
	 * ); Functions.get_aaxcal_today_details(); System.out.
	 * println("================= Verify amazon aax for today detail adcard End========================="
	 * ); }
	 * 
	 * @Test(priority=48,enabled = true)
	 * 
	 * @Title("Verifying amazon aax for covid19 details card") public void
	 * Smoke_Test_amazon_aax_covid19_deatailcard() throws Exception { System.out.
	 * println("================= Verify amazon aax for today detail adcard Started ========================="
	 * ); Functions.get_aaxcal_covid19(); System.out.
	 * println("================= Verify amazon aax for today detail adcard End========================="
	 * ); }
	 */

	/*
	 * @Test(priority = 23, enabled = true)
	 * 
	 * @Title("Verifying iu value for Watson Flu card  iu") public void
	 * Smoke_Test_Verify_WatsonFlu_adcall() throws Exception { System.out.
	 * println("================= Verify_WatsonFlu adcall Started ========================="
	 * ); Functions.finding_watsonFlu_card_iu_value(); System.out.
	 * println("================= Verify_WatsonFlu adcall End ========================="
	 * ); }
	 */

	/*
	 * @Test(priority=22,enabled = true)
	 * 
	 * @Title("Verifying amazon axx slot for cold&flu Bigbanner ad") public void
	 * Smoke_Test_Verify_amazon_aax_cold_flu_Bigbanner_ad() throws Exception {
	 * System.out.
	 * println("================= verifying amazon aax slot for cold&flu BigBanner adcall started ========================="
	 * ); Functions.get_aaxcal_Cold_Flu_Bigbanner(); System.out.
	 * println("================= verifying amazon aax slot for cold&flu BigBanner adcall  End ========================="
	 * ); }
	 */
	/*
	 * @Test(priority=49,enabled = true)
	 * 
	 * @Title("Verifying amazon axx slot for Allergy Bigbanner ad") public void
	 * Smoke_Test_Verify_amazon_aax_Allergy_Bigbanner_ad() throws Exception {
	 * System.out.
	 * println("================= verifying amazon aax slot for Allergy BigBanner adcall started ========================="
	 * ); Functions.get_aaxcal_Allergy_Bigbanner(); System.out.
	 * println("================= verifying amazon aax slot for Allergy BigBanner adcall  End ========================="
	 * ); }
	 * 
	 * @Test(priority=50,enabled = true)
	 * 
	 * @Title("Verifying amazon axx slot for Running Bigbanner ad") public void
	 * Smoke_Test_Verify_amazon_aax_Running_Bigbanner_ad() throws Exception {
	 * System.out.
	 * println("================= verifying amazon aax slot for Running BigBanner adcall started ========================="
	 * ); Functions.get_aaxcal_Running_Bigbanner(); System.out.
	 * println("================= verifying amazon aax slot for Running BigBanner adcall  End ========================="
	 * ); }
	 * 
	 * @Test(priority=51,enabled = true)
	 * 
	 * @Title("Verifying amazon axx slot for Boat&Beach Bigbanner ad") public void
	 * Smoke_Test_Verify_amazon_aax_Boat_Beach_Bigbanner_ad() throws Exception {
	 * System.out.
	 * println("================= verifying amazon aax slot for Boat&Beach BigBanner adcall started ========================="
	 * ); Functions.get_aaxcal_Boat_Beach_Bigbanner(); System.out.
	 * println("================= verifying amazon aax slot for Boat&Beach BigBanner adcall  End ========================="
	 * ); }
	 */
	/*
	 * @Test(priority=26,enabled = true)
	 * 
	 * @Title("Verifying iu value seasonal hub  feed card ") public void
	 * Smoke_Test_CaseVerify_seasonalhub_feed_adcall() throws Exception {
	 * System.out.
	 * println("================= verifying iu value SeasonalHub feed card started ========================="
	 * ); Functions.finding_Seasonalhub_adcalL_iu(); System.out.
	 * println("================= verifying iu value SeasonalHub feed card End ========================="
	 * ); }
	 */

	/*
	 * @Test(priority=52,enabled = true)
	 * 
	 * @Title("Verifying amazon axx slotId for  air quality feed card") public void
	 * Smoke_Test_Verify_amazon_aax_AirQuality_adcall() throws Exception {
	 * System.out.
	 * println("================= Verifying amazon aax slotId for air quality feed card started ========================="
	 * ); Functions.get_aaxcal_AQ(); System.out.
	 * println("================= Verifying amazon aax slotId for air quality feed card End ========================="
	 * ); }
	 * 
	 * 
	 * 
	 * @Test(priority=31,enabled = true)
	 * 
	 * @Title("Verifying AQ aax call") public void
	 * Smoke_Test_CaseVerify_AQ_aax_amazon_adcalll() throws Exception { System.out.
	 * println("================= Verifying amazon AQ aax call  started ========================="
	 * ); Functions.get_aaxcal_AQ(); System.out.
	 * println("================= Verifying amazon AQ aax call End ========================="
	 * ); }
	 * 
	 * @Test(priority=53,enabled = true)
	 * 
	 * @Title("Verifying news aax call") public void
	 * Smoke_Test_CaseVerify_news_aax_amazon_adcalll() throws Exception {
	 * System.out.
	 * println("================= Verifying amazon news aax call  started ========================="
	 * ); Functions.get_aaxcal_news(); System.out.
	 * println("================= Verifying amazon news aax call End ========================="
	 * ); }
	 * 
	 * 
	 * 
	 * 
	 * @Test(priority = 80, enabled = true)
	 * 
	 * @Title("Verifying Privacy Card is present on the screen") public void
	 * Smoke_Test_Verify_PrivacyCard_onScreen() throws Exception {
	 * 
	 * 
	 * System.out.
	 * println("=================Verifying Privacy Card is present on the screen testcase started ========================="
	 * ); //AppiumFunctions.Kill_launch(); // AppFunctions.Kill_Launch_App();
	 * Thread.sleep(50000);
	 * 
	 * Functions.Verify_Privacy_Card_onScreen();
	 * 
	 * System.out.
	 * println("================= Verifying Privacy Card is present on the screen testcase End ========================="
	 * ); }
	 * 
	 * @Test(priority = 81, enabled = true)
	 * 
	 * @Title("Selecting the  Opt out mode in the privacy card") public void
	 * Smoke_Test_Selecting_Opt_out_mode_scenario() throws Exception {
	 * 
	 * 
	 * System.out.
	 * println("=================Slecting Opt out mode scenario in privacy card testcase started ========================="
	 * ); Thread.sleep(50000); Functions.selecting_opt_out_mode(); System.out.
	 * println("================= Slecting Opt out mode scenario in privacy card  testcase End ========================="
	 * );
	 * 
	 * }
	 * 
	 * @Test(priority = 82, enabled = true)
	 * 
	 * @Title("Verifying video call when user selecting Optoutmode scenario in privacy card"
	 * ) public void
	 * Smoke_Test__Smoke_Test_Verifying_videoadcall_Optoutmode_scenario() throws
	 * Exception {
	 * 
	 * 
	 * System.out.
	 * println("=================Verifying video Feed ad call when user selecting Optoutmode scenario in privacy card started ========================="
	 * );
	 * logStep("Verifying video call when user selecting Optoutmode scenario in privacy card"
	 * ); CharlesFunctions.startSessionBrowserData();
	 * 
	 * //AppFunctions.Kill_Launch_App(); Thread.sleep(80000); Thread.sleep(50000);
	 * // AppFunctions.Kill_Launch_App();
	 * 
	 * 
	 * //Functions.click_video(); // Functions.scrollapp_maps(); //
	 * AppiumFunctions.clickOnRadarMaps(); CharlesFunctions.ExportSession();
	 * Functions.Verify_video_ad_call_Optoutmode(); System.out.
	 * println("================= Verifying video ad call when user selecting Optoutmode scenario in privacy card End ========================="
	 * );
	 * 
	 * }
	 * 
	 * @Test(priority = 83, enabled = true)
	 * 
	 * @Title("Verifying feed ad call when user selecting Optoutmode scenario in privacy card"
	 * ) public void Smoke_Test_Verifying_Feedadcall_Optoutmode_scenario() throws
	 * Exception {
	 * 
	 * 
	 * System.out.
	 * println("=================Verifying Feed ad call when user selecting Optoutmode scenario in privacy card started ========================="
	 * );
	 * logStep("Verifying feed ad call when user selecting Optoutmode scenario in privacy card"
	 * ); Functions.Verifying_gampadcalls_Optoutmode();
	 * 
	 * System.out.
	 * println("================= Verifying Feed ad call when user selecting Optoutmode scenario in privacy card End ========================="
	 * ); }
	 * 
	 * 
	 * @Test(priority = 84, enabled = true)
	 * 
	 * @Title("Verifying  detail page ad call when user selecting Optoutmode scenario in privacy card"
	 * ) public void Smoke_Test_Verifying_detailpageadcall_Optoutmode_scenario()
	 * throws Exception {
	 * 
	 * logStep("Verifying  detail page ad call when user selecting Optoutmode scenario in privacy card"
	 * ); System.out.
	 * println("=================Verifying detail page Feed ad call when user selecting Optoutmode scenario in privacy card started ========================="
	 * ); Functions.Verifying_detail_gampadcalls_Optoutmode(); System.out.
	 * println("================= Verifying detail page  Feed ad call when user selecting Optoutmode scenario in privacy card End ========================="
	 * ); }
	 * 
	 * 
	 * @Test(priority = 85, enabled = true)
	 * 
	 * @Title("Verifying bcp api url  when user selecting Optoutmode scenario in privacy card"
	 * ) public void Smoke_Test__Verifying_Bcp_apicall_Optoutmode_scenario() throws
	 * Exception {
	 * logStep("Verifying bcp api url  when user selecting Optoutmode scenario in privacy card"
	 * ); System.out.
	 * println("=================Verifying BCP api call when user selecting Optoutmode scenario in privacy card started ========================="
	 * ); Functions.validating_bcp_privacy_Optoutmode_scenarion(); System.out.
	 * println("================= Verifying BCP api call when user selecting Optoutmode scenario in privacy card End ========================="
	 * );
	 * 
	 * }
	 */

	/*
	 * @Test(priority = 86, enabled = true)
	 * 
	 * @Title("Verifying adcrw api call when user selecting Optoutmode scenario in privacy card"
	 * ) public void Smoke_Test__Verifying_adcrw_apicall_Optoutmode_scenario()
	 * throws Exception {
	 * 
	 * logStep("Verifying adcrw api call when user selecting Optoutmode scenario in privacy card"
	 * ); System.out.
	 * println("=================Verifying adcrw api call when user selecting Optoutmode scenario in privacy card started ========================="
	 * );
	 * 
	 * Functions.validating_adcrw_privacy_Optoutmode_scenarion(); System.out.
	 * println("================= Verifying adcrw api call when user selecting Optoutmode scenario in privacy card End ========================="
	 * );
	 * 
	 * }
	 * 
	 * @Test(priority = 87, enabled = true)
	 * 
	 * @Title("Verifying Factual api call when user selecting Optoutmode scenario in privacy card"
	 * ) public void Smoke_Test__Verifying_locaion_apicall_Optoutmode_scenario()
	 * throws Exception {
	 * logStep("Verifying Factual api call when user selecting Optoutmode scenario in privacy card"
	 * );
	 * 
	 * System.out.
	 * println("=================Verifying Fatual api call when user selecting Optoutmode scenario in privacy card started ========================="
	 * ); Functions.validating_Fatualcall_privacy_Optoutmode_scenarion();
	 * System.out.
	 * println("================= Verifying Fatual api call when user selecting Optoutmode scenario in privacy card End ========================="
	 * );
	 * 
	 * }
	 */

	/*
	 * @Test(priority =88, enabled = true)
	 * 
	 * @Title("Verifying amazon aax calls when user selecting Optoutmode scenario in privacy card"
	 * ) public void Smoke_Test__Verifying_amaozn_aax_calls_Optoutmode_scenario()
	 * throws Exception {
	 * logStep("Verifying amazon aax calls when user selecting Optoutmode scenario in privacy card"
	 * );
	 * 
	 * System.out.
	 * println("=================Verifying amazon aax calls when user selecting Optoutmode scenario in privacy card started ========================="
	 * );
	 * logStep("Verifying amazon aax calls when user selecting Optoutmode scenario in privacy card"
	 * ); Functions.validating_aax_privacy_Optoutmode_scenario(); System.out.
	 * println("================= Verifying amazon aax calls when user selecting Optoutmode scenario in privacy card End ========================="
	 * );
	 * 
	 * }
	 * 
	 * @Test(priority = 89, enabled = true)
	 * 
	 * @Title("Verifying home screnn hourly ad call  when user selecting Optoutmode scenario in privacy card"
	 * ) public void
	 * Smoke_Test__Verifying_homescreenhourly_calls_Optoutmode_scenario() throws
	 * Exception {
	 * 
	 * 
	 * System.out.
	 * println("=================Verifying homescreen hourly ad calls when user selecting Optoutmode scenario in privacy card started ========================="
	 * );
	 * logStep("Verifying home screnn hourly ad call  when user selecting Optoutmode scenario in privacy card"
	 * ); Functions.finding_Homescreen_iu_value(); System.out.
	 * println("================= Verifying homescreen hourly ad calls when user selecting Optoutmode scenario in privacy card End ========================="
	 * );
	 * 
	 * }
	 * 
	 * @Test(priority = 90, enabled = true)
	 * 
	 * @Title("Verifying homescreen marquee ad call  when user selecting Optoutmode scenario in privacy card"
	 * ) public void
	 * Smoke_Test__Verifying_marqueehomescreecall_Optoutmode_scenario() throws
	 * Exception {
	 * 
	 * logStep("Verifying homescreen marquee ad call  when user selecting Optoutmode scenario in privacy card"
	 * ); System.out.
	 * println("=================Verifying homescreen marquee ad calls when user selecting Optoutmode scenario in privacy card started ========================="
	 * );
	 * 
	 * Functions.finding_Homescreen_marquee_iu_value(); System.out.
	 * println("================= Verifying homescreen  marquee ad calls when user selecting Optoutmode scenario in privacy card End ========================="
	 * );
	 * 
	 * }
	 * 
	 * @Test(priority = 91, enabled = true)
	 * 
	 * @Title("Verifying SOD Cust param value for home screen call when user selecting Optoutmode scenario in privacy card"
	 * ) public void
	 * Smoke_Test_Verifying_SOD_Cust_Param_homescreenad_Optoutmode_scenario() throws
	 * Exception {
	 * logStep("Verifying SOD Cust param value for home screen call when user selecting Optoutmode scenario in privacy card"
	 * ); System.out.
	 * println("================= Verifying SOD CUST_PARAM value for home screen call  when user selecting Optoutmode scenario in privacy card started ========================="
	 * ); Functions.validate_SOD_Cust_param_homescreen_Optoutmode(); System.out.
	 * println("================= Verifying SOD CUST_PARAM value for home screen call when user selecting Optoutmode scenario in privacy card End ========================="
	 * ); }
	 * 
	 * @Test(priority = 92, enabled = true)
	 * 
	 * @Title("Verifying SOD Cust param value for  Feed ad call when user selecting Optoutmode scenario in privacy card"
	 * ) public void
	 * Smoke_Test_Verifying_SOD_Cust_Param_Feedad_Optoutmode_scenario() throws
	 * Exception {
	 * 
	 * logStep("Verifying SOD Cust param value for  Feed ad call when user selecting Optoutmode scenario in privacy card"
	 * ); System.out.
	 * println("================= Verifying SOD CUST_PARAM value for Feed ad call  when user selecting Optoutmode scenario in privacy card started ========================="
	 * ); Functions.validate_SOD_Cust_param_feed_Optoutmode(); System.out.
	 * println("================= Verifying SOD CUST_PARAM value for Feed ad call  when user selecting Optoutmode scenario in privacy card End ========================="
	 * ); }
	 * 
	 * 
	 * @Test(priority = 93, enabled = true)
	 * 
	 * @Title("Verifying SOD Cust param value for detail feed ad call when user selecting Optoutmode scenario in privacy card"
	 * ) public void
	 * Smoke_Test_Verifying_SOD_Cust_Param_detail_Feedad_Optoutmode_scenario()
	 * throws Exception { System.out.
	 * println("================= Verifying SOD CUST_PARAM value for  detailed Feed ad call  when user selecting Optoutmode scenario in privacy card started ========================="
	 * );
	 * logStep("Verifying SOD Cust param value for detail feed ad call when user selecting Optoutmode scenario in privacy card"
	 * ); Functions.validate_SOD_Cust_param_deatiledfeed_Optoutmode(); System.out.
	 * println("================= Verifying SOD CUST_PARAM value for  detailed Feed ad call  when user selecting Optoutmode scenario in privacy card End ========================="
	 * ); }
	 * 
	 * @Test(priority = 94, enabled = true)
	 * 
	 * @Title("Verifying SOD Cust param value for video call when user selecting Optoutmode scenario in privacy card"
	 * ) public void
	 * Smoke_Test_Verifying_SOD_Cust_Param_videoad_Optoutmode_scenario() throws
	 * Exception {
	 * logStep("Verifying SOD Cust param value for video call when user selecting Optoutmode scenario in privacy card"
	 * ); System.out.
	 * println("================= Verifying SOD CUST_PARAM value for video ad call  when user selecting Optoutmode scenario in privacy card started ========================="
	 * ); Functions.validate_SOD_Cust_param_video_Optoutmode(); System.out.
	 * println("================= Verifying SOD CUST_PARAM value for video ad call  when user selecting Optoutmode scenario in privacy card End ========================="
	 * ); }
	 * 
	 * @Test(priority = 95, enabled = true)
	 * 
	 * @Title("Verifying RDP  value for home screen call when user selecting Optoutmode scenario in privacy card"
	 * ) public void
	 * Smoke_Test_Verifying_RDP_value_homescreenad_Optoutmode_scenario() throws
	 * Exception {
	 * logStep("Verifying RDP  value for home screen call when user selecting Optoutmode scenario in privacy card"
	 * ); System.out.
	 * println("================= Verifying RDP value for home screen call  when user selecting Optoutmode scenario in privacy card started ========================="
	 * ); Functions.validate_RDP_homescreen_Optoutmode(); System.out.
	 * println("================= Verifying RDP value for home screen call when user selecting Optoutmode scenario in privacy card End ========================="
	 * ); }
	 * 
	 * @Test(priority = 96, enabled = true)
	 * 
	 * @Title("Verifying RDP  value for feed ad call when user selecting Optoutmode scenario in privacy card"
	 * ) public void Smoke_Test_Verifying_RDP_value_feedad_Optoutmode_scenario()
	 * throws Exception {
	 * logStep("Verifying RDP  value for feed ad call when user selecting Optoutmode scenario in privacy card"
	 * ); System.out.
	 * println("================= Verifying RDP value for feed ad  call  when user selecting Optoutmode scenario in privacy card started ========================="
	 * ); // Functions.validate_RDP_feed_Optoutmode(); System.out.
	 * println("================= Verifying RDP value for feed ad call when user selecting Optoutmode scenario in privacy card End ========================="
	 * ); }
	 * 
	 * 
	 * @Test(priority = 97, enabled = true)
	 * 
	 * @Title("Verifying RDP  value for detailed feed ad call when user selecting Optoutmode scenario in privacy card"
	 * ) public void
	 * Smoke_Test_Verifying_RDP_value_detailed_feedad_Optoutmode_scenario() throws
	 * Exception {
	 * logStep("Verifying RDP  value for detailed feed ad call when user selecting Optoutmode scenario in privacy card"
	 * ); System.out.
	 * println("================= Verifying RDP value for detailed feed ad  call  when user selecting Optoutmode scenario in privacy card started ========================="
	 * ); Functions.validate_RDP_detailed_feed_Optoutmode(); System.out.
	 * println("================= Verifying RDP value for detailed feed ad call when user selecting Optoutmode scenario in privacy card End ========================="
	 * ); }
	 * 
	 * @Test(priority = 98, enabled = true)
	 * 
	 * @Title("Verifying RDP  value forvideo  ad call when user selecting Optoutmode scenario in privacy card"
	 * ) public void
	 * Smoke_Test_Verifying_RDP_value_video_adcall_Optoutmode_scenario() throws
	 * Exception {
	 * logStep("Verifying RDP  value forvideo  ad call when user selecting Optoutmode scenario in privacy card"
	 * ); System.out.
	 * println("================= Verifying RDP value for video  ad call  when user selecting Optoutmode scenario in privacy card started ========================="
	 * ); Functions.validate_RDP_video_ad_Optoutmode(); System.out.
	 * println("================= Verifying RDP value for video ad call when user selecting Optoutmode scenario in privacy card End ========================="
	 * ); }
	 * 
	 * 
	 * @Test(priority = 99, enabled = true)
	 * 
	 * @Title("Selecting the  Opt in mode in the privacy card") public void
	 * Smoke_Test_Selecting_Opt_in_mode_scenario() throws Exception {
	 * logStep("Selecting the  Opt in mode in the privacy card");
	 * 
	 * System.out.
	 * println("=================Slecting Opt in mode scenario in privacy card testcase started ========================="
	 * );
	 * 
	 * //AppFunctions.Kill_Launch_App(); Thread.sleep(50000);
	 * //Functions.Verify_Privacy_Card_onScreen(); Thread.sleep(50000); //
	 * Functions.selecting_opt_in_mode();
	 * 
	 * System.out.
	 * println("================= Slecting Opt in mode scenario in privacy card  testcase End ========================="
	 * ); }
	 * 
	 * //869c843c-7cf8-47ae-b6ed-088057e4bc8a
	 * 
	 * @Test(priority = 100, enabled = true)
	 * 
	 * @Title("Verifying video call when user selecting Optin mode scenario in privacy card"
	 * ) public void
	 * Smoke_Test__Smoke_Test_Verifying_videoadcall_Optin mode_scenario() throws
	 * Exception {
	 * logStep("Verifying video call when user selecting Optin mode scenario in privacy card"
	 * ); System.out.
	 * println("=================Verifying video Feed ad call when user selecting Optin mode scenario in privacy card started ========================="
	 * ); //AppFunctions.Kill_Launch_App();
	 * CharlesFunctions.startSessionBrowserData(); Thread.sleep(100000);
	 * Thread.sleep(50000); //Functions.click_video(); //
	 * Functions.scrollapp_maps(); //Functions.scrollapp_maps();
	 * //AppiumFunctions.clickOnRadarMaps(); CharlesFunctions.ExportSession();
	 * Functions.Verify_video_ad_call_Optoutmode(); System.out.
	 * println("================= Verifying video ad call when user selecting Optin mode scenario in privacy card End ========================="
	 * );
	 * 
	 * }
	 * 
	 * @Test(priority = 101, enabled = true)
	 * 
	 * @Title("Verifying feed ad call when user selecting Optintmode scenario in privacy card"
	 * ) public void Smoke_Test_Verifying_Feedadcall_Optin mode_scenario() throws
	 * Exception {
	 * 
	 * logStep("Verifying feed ad call when user selecting Optintmode scenario in privacy card"
	 * ); System.out.
	 * println("=================Verifying Feed ad call when user selecting Optin mode scenario in privacy card started ========================="
	 * ); Functions.Verifying_gampadcalls_Optoutmode(); System.out.
	 * println("================= Verifying Feed ad call when user selecting Optin mode scenario in privacy card End ========================="
	 * ); }
	 * 
	 * 
	 * @Test(priority = 102, enabled = true)
	 * 
	 * @Title("Verifying details page ad call when user selecting Optin mode scenario in privacy card"
	 * ) public void Smoke_Test_Verifying_detailpageadcall_Optin mode_scenario()
	 * throws Exception {
	 * logStep("Verifying details page ad call when user selecting Optin mode scenario in privacy card"
	 * );
	 * 
	 * System.out.
	 * println("=================Verifying detail page Feed ad call when user selecting Optin mode scenario in privacy card started ========================="
	 * ); Functions.Verifying_detail_gampadcalls_Optoutmode();
	 * 
	 * System.out.
	 * println("================= Verifying detail page  Feed ad call when user selecting Optin mode scenario in privacy card End ========================="
	 * ); }
	 * 
	 * @Test(priority = 103, enabled = true)
	 * 
	 * @Title("Verifying BCP  call when user selecting Optin mode scenario in privacy card"
	 * ) public void Smoke_Test__Verifying_Bcp_apicall_Optin mode_scenario() throws
	 * Exception {
	 * 
	 * logStep("Verifying BCP  call when user selecting Optin mode scenario in privacy card"
	 * ); System.out.
	 * println("=================Verifying BCP api call when user selecting Optin mode scenario in privacy card started ========================="
	 * );
	 * 
	 * Functions.validating_bcp_privacy_Optin mode_scenarion(); System.out.
	 * println("================= Verifying BCP api call when user selecting Optin mode scenario in privacy card End ========================="
	 * );
	 * 
	 * }
	 * 
	 * @Test(priority = 104, enabled = true)
	 * 
	 * @Title("Verifying adcrw api call when user selecting Optin mode scenario in privacy card"
	 * ) public void Smoke_Test__Verifying_adcrw_apicall_Optin mode_scenario() throws
	 * Exception {
	 * logStep("Verifying adcrw api call when user selecting Optin mode scenario in privacy card"
	 * );
	 * 
	 * System.out.
	 * println("=================Verifying adcrw api call when user selecting Optin mode scenario in privacy card started ========================="
	 * );
	 * 
	 * Functions.validating_adcrw_privacy_Optin mode_scenarion(); System.out.
	 * println("================= Verifying adcrw api call when user selecting Optin mode scenario in privacy card End ========================="
	 * );
	 * 
	 * }
	 * 
	 * @Test(priority = 105, enabled = true)
	 * 
	 * @Title("Verifying Fatual api call when user selecting Optin mode scenario in privacy card"
	 * ) public void Smoke_Test__Verifying_locaion_apicall_Optin mode_scenario()
	 * throws Exception {
	 * 
	 * logStep("Verifying Fatual api call when user selecting Optin mode scenario in privacy card\""
	 * ); System.out.
	 * println("=================Verifying Fatcual api call when user selecting Optin mode scenario in privacy card started ========================="
	 * ); Functions.validating_Fatualcall_privacy_Optin mode_scenarion(); System.out.
	 * println("================= Verifying Fatcual api call when user selecting Oppinmode scenario in privacy card End ========================="
	 * );
	 * 
	 * }
	 * 
	 * @Test(priority =106, enabled = true)
	 * 
	 * @Title("Verifying amazon aax calls when user selecting Optin mode scenario in privacy card"
	 * ) public void Smoke_Test__Verifying_amaozn_aax_calls_Optin mode_scenario()
	 * throws Exception {
	 * 
	 * logStep("Verifying amazon aax calls when user selecting Optin mode scenario in privacy card"
	 * ); System.out.
	 * println("=================Verifying amazon aax calls when user selecting Optin mode scenario in privacy card started ========================="
	 * ); Functions.validating_aax_privacy_Optin mode_scenario(); System.out.
	 * println("================= Verifying amazon aax calls when user selecting Optin mode scenario in privacy card End ========================="
	 * );
	 * 
	 * }
	 * 
	 * @Test(priority = 107, enabled = true)
	 * 
	 * @Title("Verifying home screnn hourly ad call  when user selecting Optin mode scenario in privacy card"
	 * ) public void
	 * Smoke_Test__Verifying_homescreenhourly_calls_Optin mode_scenario() throws
	 * Exception {
	 * logStep("Verifying home screnn hourly ad call  when user selecting Optin mode scenario in privacy card"
	 * ); System.out.
	 * println("=================Verifying homescreen hourly ad calls when user selecting Optin mode scenario in privacy card started ========================="
	 * ); Functions.finding_Homescreen_iu_value(); System.out.
	 * println("================= Verifying homescreen hourly ad calls when user selecting Optin mode scenario in privacy card End ========================="
	 * );
	 * 
	 * }
	 * 
	 * @Test(priority = 108, enabled = true)
	 * 
	 * @Title("Verifying homescreen marquee ad call  when user selecting Optin mode scenario in privacy card"
	 * ) public void Smoke_Test__Verifying_marqueehomescreecall_Optin mode_scenario()
	 * throws Exception {
	 * 
	 * logStep("Verifying homescreen marquee ad call  when user selecting Optin mode scenario in privacy card"
	 * ); System.out.
	 * println("=================Verifying homescreen marquee ad calls when user selecting Optin mode scenario in privacy card started ========================="
	 * ); Functions.finding_Homescreen_marquee_iu_value(); System.out.
	 * println("================= Verifying homescreen  marquee ad calls when user selecting Optin mode scenario in privacy card End ========================="
	 * );
	 * 
	 * }
	 * 
	 * 
	 * 
	 * @Test(priority = 109, enabled = true)
	 * 
	 * @Title("Verifying SOD Cust param value for home screen call when user selecting Optin mode scenario in privacy card"
	 * ) public void
	 * Smoke_Test_Verifying_SOD_Cust_Param_homescreenad_Optin mode_scenario() throws
	 * Exception {
	 * logStep("Verifying SOD Cust param value for home screen call when user selecting Optin mode scenario in privacy card"
	 * ); System.out.
	 * println("================= Verifying SOD CUST_PARAM value for home screen call  when user selecting Optin mode scenario in privacy card started ========================="
	 * ); Functions.validate_SOD_Cust_param_homescreen_Optin mode(); System.out.
	 * println("================= Verifying SOD CUST_PARAM value for home screen call when user selecting Opttinmode scenario in privacy card End ========================="
	 * ); }
	 * 
	 * @Test(priority = 110, enabled = true)
	 * 
	 * @Title("Verifying SOD Cust param value for  feed ad call when user selecting Optin mode scenario in privacy card"
	 * ) public void Smoke_Test_Verifying_SOD_Cust_Param_Feedad_Optin mode_scenario()
	 * throws Exception { System.out.
	 * println("================= Verifying SOD CUST_PARAM value for Feed ad call  when user selecting Optin mode scenario in privacy card started ========================="
	 * );
	 * logStep("Verifying SOD Cust param value for  feed ad call when user selecting Optin mode scenario in privacy card"
	 * ); Functions.validate_SOD_Cust_param_feed_Optin mode(); System.out.
	 * println("================= Verifying SOD CUST_PARAM value for Feed ad call  when user selecting Optin mode scenario in privacy card End ========================="
	 * ); }
	 * 
	 * 
	 * @Test(priority = 111, enabled = true)
	 * 
	 * @Title("Verifying SOD Cust param value for detail page ad call when user selecting Optin mode scenario in privacy card"
	 * ) public void
	 * Smoke_Test_Verifying_SOD_Cust_Param_detail_Feedad_Optin mode_scenario() throws
	 * Exception {
	 * logStep("Verifying SOD Cust param value for detail page ad call when user selecting Optin mode scenario in privacy card"
	 * ); System.out.
	 * println("================= Verifying SOD CUST_PARAM value for  detailed Feed ad call  when user selecting Optin mode scenario in privacy card started ========================="
	 * ); Functions.validate_SOD_Cust_param_deatiledfeed_Optin mode(); System.out.
	 * println("================= Verifying SOD CUST_PARAM value for  detailed Feed ad call  when user selecting Optin mode scenario in privacy card End ========================="
	 * ); }
	 * 
	 * @Test(priority = 112, enabled = true)
	 * 
	 * @Title("Verifying SOD Cust param value for video call when user selecting Optin mode scenario in privacy card"
	 * ) public void
	 * Smoke_Test_Verifying_SOD_Cust_Param_videoad_Optin mode_scenario() throws
	 * Exception {
	 * logStep("Verifying SOD Cust param value for video call when user selecting Optin mode scenario in privacy card"
	 * ); System.out.
	 * println("================= Verifying SOD CUST_PARAM value for video ad call  when user selecting Optin mode scenario in privacy card started ========================="
	 * ); Functions.validate_SOD_Cust_param_video_Optin mode(); System.out.
	 * println("================= Verifying SOD CUST_PARAM value for video ad call  when user selecting Optin mode scenario in privacy card End ========================="
	 * ); }
	 * 
	 * @Test(priority = 113, enabled = true)
	 * 
	 * @Title("Verifying RDP  value for home screen call when user selecting Optin mode scenario in privacy card"
	 * ) public void
	 * Smoke_Test_Verifying_RDP_value_homescreenad_Optin mode_scenario() throws
	 * Exception {
	 * logStep("Verifying RDP  value for home screen call when user selecting Optin mode scenario in privacy card"
	 * ); System.out.
	 * println("================= Verifying RDP value for home screen call  when user selecting Optin mode scenario in privacy card started ========================="
	 * ); Functions.validate_RDP_homescreen_Optin mode(); System.out.
	 * println("================= Verifying RDP value for home screen call when user selecting Optin mode scenario in privacy card End ========================="
	 * ); }
	 * 
	 * @Test(priority = 114, enabled = true)
	 * 
	 * @Title("Verifying RDP  value for feed ad call when user selecting Optin mode scenario in privacy card"
	 * ) public void Smoke_Test_Verifying_RDP_value_feedad_Optin mode_scenario()
	 * throws Exception {
	 * logStep("Verifying RDP  value for feed ad call when user selecting Optin mode scenario in privacy card"
	 * ); System.out.
	 * println("================= Verifying RDP value for feed ad  call  when user selecting Optin mode scenario in privacy card started ========================="
	 * ); Functions.validate_RDP_feed_Optin mode(); System.out.
	 * println("================= Verifying RDP value for feed ad call when user selecting Optin mode scenario in privacy card End ========================="
	 * ); }
	 * 
	 * 
	 * @Test(priority = 115, enabled = true)
	 * 
	 * @Title("Verifying RDP  value for detailed page ad call when user selecting Optin mode scenario in privacy card"
	 * ) public void
	 * Smoke_Test_Verifying_RDP_value_detailed_feedad_Optin mode_scenario() throws
	 * Exception {
	 * logStep("Verifying RDP value for detailed page ad call when user selecting Optin mode scenario in privacy card"
	 * ); System.out.
	 * println("================= Verifying RDP value for detailed feed ad  call  when user selecting Optin mode scenario in privacy card started ========================="
	 * ); Functions.validate_RDP_detailed_feed_Optin mode(); System.out.
	 * println("================= Verifying RDP value for detailed feed ad call when user selecting Optin mode scenario in privacy card End ========================="
	 * ); }
	 * 
	 * @Test(priority = 116, enabled = true)
	 * 
	 * @Title("Verifying RDP  value forvideo  ad call when user selecting Optin mode scenario in privacy card"
	 * ) public void
	 * Smoke_Test_Verifying_RDP_value_video_adcall_Optin mode_scenario() throws
	 * Exception {
	 * 
	 * System.out.
	 * println("================= Verifying RDP value for video  ad call  when user selecting Optin mode scenario in privacy card started ========================="
	 * );
	 * logStep("Verifying RDP  value forvideo  ad call when user selecting Optin mode scenario in privacy card"
	 * ); Functions.validate_RDP_video_ad_Optin mode(); System.out.
	 * println("================= Verifying RDP value for video ad call when user selecting Optin mode scenario in privacy card End ========================="
	 * ); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @Test(priority = 117, enabled = true)
	 * 
	 * @Title("Verifying  home screen hourly call pull to refrersh scenario") public
	 * void Smoke_Test_Verifying_homescreenhourly__pulltoreresh_scenario() throws
	 * Exception {
	 * logStep("Verifying  home screen hourly call pull to refrersh scenario");
	 * System.out.
	 * println("================= Verifying  home screen hourly call pull to refrersh scenario started ========================="
	 * ); CharlesFunctions.ClearSessions();
	 * CharlesFunctions.startSessionBrowserData(); Thread.sleep(100000); //
	 * AppFunctions.Kill_Launch_App(); // AppFunctions.Kill_Launch_App(); //
	 * AppFunctions.Pull_To_Refresh("Pulltorefresh");
	 * CharlesFunctions.ExportSession(); Functions.finding_Homescreen_iu_value();
	 * 
	 * System.out.
	 * println("================= Verifying  home screen hourly call pull to refrersh scenario started End ========================="
	 * ); }
	 * 
	 * @Test(priority = 118, enabled = true)
	 * 
	 * @Title("Verifying  home screen hourly call pull to refrersh scenario") public
	 * void Smoke_Test_Verifying_homescreenmarquee__pulltoreresh_scenario() throws
	 * Exception {
	 * logStep("Verifying  home screen hourly call pull to refrersh scenario");
	 * System.out.
	 * println("================= Verifying  home screen marquee call pull to refrersh scenario started ========================="
	 * ); Functions.finding_Homescreen_marquee_iu_value(); System.out.
	 * println("================= Verifying  home screen marquee call pull to refrersh scenario  End ========================="
	 * );
	 * 
	 * }
	 * 
	 * @Test(priority = 119, enabled = true)
	 * 
	 * @Title("Verifying  home screen hourly call kill launch scenario") public void
	 * Smoke_Test_Verifying_homescreenhourly__killlaunch_scenario() throws Exception
	 * { logStep("Verifying  home screen hourly call kill launch scenario");
	 * System.out.
	 * println("================= Verifying  home screen hourly call kill and launch scenario started ========================="
	 * ); // CharlesFunctions.ClearSessions();
	 * //CharlesFunctions.startSessionBrowserData(); Thread.sleep(10000); //
	 * AppFunctions.Kill_Launch_App(); //CharlesFunctions.ExportSession();
	 * Functions.finding_Homescreen_iu_value();
	 * 
	 * System.out.
	 * println("================= Verifying  home screen hourly call kill and launch  scenario  End ========================="
	 * ); }
	 * 
	 * @Test(priority = 120, enabled = true)
	 * 
	 * @Title("Verifying  home screen hourly call kil and launch scenario") public
	 * void Smoke_Test_Verifying_homescreenmarquee__killlaunch_scenario() throws
	 * Exception {
	 * logStep("Verifying  home screen hourly call kil and launch scenario");
	 * System.out.
	 * println("================= Verifying  home screen marquee call kill and launch  scenario started ========================="
	 * );
	 * 
	 * Functions.finding_Homescreen_marquee_iu_value(); System.out.
	 * println("================= Verifying  home screen marquee call kill and launch scenario  End ========================="
	 * );
	 * 
	 * }
	 * 
	 * @Test(priority = 121, enabled = true)
	 * 
	 * @Title("Verifying  home screen hourly call back from detailes page  scenario"
	 * ) public void
	 * Smoke_Test_Verifying_homescreenhourly__backfromdetailedpage_scenario() throws
	 * Exception {
	 * logStep("Verifying  home screen hourly call back from detailes page  scenario"
	 * ); System.out.
	 * println("================= Verifying  home screen hourly call back from detailes page scenario  started ========================="
	 * ); // CharlesFunctions.ClearSessions(); // AppFunctions.Kill_Launch_App(); //
	 * CharlesFunctions.startSessionBrowserData(); Thread.sleep(10000); //
	 * Functions.scrollapp_maps(); // Functions.click_Mapsdetails_element(); //
	 * Functions.clickonBackbutton(); //CharlesFunctions.ExportSession_feed();
	 * Functions.finding_Homescreen_iu_value();
	 * 
	 * System.out.
	 * println("================= Verifying  home screen hourly back from detailes page scenario End ========================="
	 * ); }
	 * 
	 * @Test(priority = 122, enabled = true)
	 * 
	 * @Title("Verifying  home screen marquee callbackfromdetailedpage scenario")
	 * public void
	 * Smoke_Test_Verifying_homescreenmarquee_backfromdetailedpage__scenario()
	 * throws Exception {
	 * logStep("Verifying  home screen marquee callbackfromdetailedpage scenario");
	 * System.out.
	 * println("================= Verifying  home screen marquee call  back from detailes page scenario  started ========================="
	 * ); Functions.finding_Homescreen_marquee_iu_value(); System.out.
	 * println("================= Verifying  home screen marquee call  back from detailes page scenario  End ========================="
	 * );
	 * 
	 * }
	 */
	/*
	 * @Test(priority=150,enabled = true)
	 * 
	 * @Title("Verifying NextGen IM ad call unit") public void
	 * Smoke_Test_NextGen_IM_adunit() throws Exception { System.out.
	 * println("================= Verify  NextGen IM adunit testcase Started ========================="
	 * );
	 * 
	 * AppFunctions.putTestMode(); AppFunctions. enable_adstestadunit();
	 * AppiumFunctions.Kill_launch(); AppFunctions.putTestMode();
	 * AppFunctions.enable_adstestadunit(); Thread.sleep(5000);
	 * AppiumFunctions.Kill_launch(); AppFunctions.Kill_Launch_App();
	 * AppFunctions.enable_responsive_mode(); CharlesFunctions.ClearSessions();
	 * AppFunctions.Kill_Launch_App(); AppFunctions.enter_nextgenIm_ad_location();
	 * CharlesFunctions.startSessionBrowserData(); CharlesFunctions.ExportSession();
	 * Functions.nextgenim_adunit(); System.out.
	 * println("================= Verify  NextGen IM adunit testcase End ========================="
	 * );
	 * 
	 * }
	 */

	/*
	 * @Test(priority=151,enabled = true)
	 * 
	 * @Title("Verifying  NextGen IM ad card call response") public void
	 * Smoke_Test_verifying_NextGenIM_response() throws Exception { System.out.
	 * println("================= Verify  NextGen IM ad response testcase started ========================="
	 * ); // Functions.nextgenim_adcall_response(); System.out.
	 * println("================= Verify   NextGen IM ad  response testcase End ========================="
	 * );
	 * 
	 * }
	 * 
	 * 
	 * /* @Test(priority=152,enabled = true)
	 * 
	 * @Title("Verifying the FG and BG URL'S for nextgen ad call") public void
	 * Smoke_Test_verifying_FG_BG_urls_NextgenIm_Ad() throws Exception { System.out.
	 * println("================= Verify  Nextgen Im adunit response testcase started ========================="
	 * ); //Functions.validate_FG_BG_adcalls_NextGenIM(); System.out.
	 * println("================= Verify  Nextgen Im adunit response testcase End ========================="
	 * );
	 * 
	 * }
	 * 
	 * 
	 * @Test(priority=153,enabled = true)
	 * 
	 * @Title("Verifying the Size for nextgen ad call") public void
	 * Smoke_Test_verifying_Size_NextgenIm_Ad() throws Exception { System.out.
	 * println("================= Verify  Nextgen Im adunit response testcase started ========================="
	 * ); // CharlesFunctions.ClearSessions();
	 * //Functions.validate_Size_NextGenIM(); System.out.
	 * println("================= Verify  Nextgen Im adunit response testcase End ========================="
	 * ); }
	 * 
	 * 
	 * 
	 * @Test(priority=155,enabled = true)
	 * 
	 * @Title("Verifying daily IF ad card call response") public void
	 * Smoke_Test_verifying_DailyIFcardResponse() throws Exception {
	 * 
	 * System.out.
	 * println("================= Verify  Daily IF card response testcase started ========================="
	 * ); // Functions.dailyIFCard_adcall_response(); System.out.
	 * println("================= Verify  Daily IF card response testcase End ========================="
	 * );
	 * 
	 * }
	 * 
	 * @Test(priority=156,enabled = true)
	 * 
	 * @Title("Verifying the response for Daily IF card") public void
	 * Smoke_Test_verifying_FG_BG_urls_DailyIF_Card() throws Exception { System.out.
	 * println("================= Verify  Nextgen Im adunit response testcase started ========================="
	 * ); // Functions.validate_FG_BG_adcalls_DailyIFcards(); System.out.
	 * println("================= Verify  Nextgen Im adunit response testcase End ========================="
	 * ); }
	 */

	/*
	 * @Test(priority=157,enabled = true)
	 * 
	 * @Title("Verifying the Size for Daily  ad call") public void
	 * Smoke_Test_verifying_Size_DailyIFCard() throws Exception { System.out.
	 * println("================= Verify  Nextgen Im adunit response testcase started ========================="
	 * ); Functions.validate_Size_DailyIFCard(); System.out.
	 * println("================= Verify  Nextgen Im adunit response testcase End ========================="
	 * ); }
	 */

	// @BeforeTest
	// public void Before_Test() throws Exception {
	// System.out.println("================= Before Test Started
	// =========================");
	// CharlesFunctions.charlesOpen();
	// AppiumFunctions.UnInstallApp();

	// CharlesFunctions.openCharlesBrowser();
	// CharlesFunctions.ExportSession();
	// MapLocalFunctions.alertModeChanges("withoutalert");
	// CharlesFunctions.ClearSessions();
	// CharlesFunctions.startSessionBrowserData();
	// AppiumFunctions.killADB();
	// AppiumFunctions.UnInstallApp();
	// AppiumFunctions.AppiumServerStop();
	// AppiumFunctions.AppiumServerStart();
//	CharlesFunctions.ClearSessions();
	// CharlesFunctions.startSessionBrowserData();
	// AppiumFunctions.LaunchAppWithFullReset();

	// AppFunctions.selectingRequiredUserGroup("multi cards");
//  Ad.runAppInBackground(30);
	// AppFunctions.Kill_Launch_App();
	// AppFunctions.enablingBranch("adsTestAutomation");
	// Ad.runAppInBackground(30);
	// AppFunctions.Kill_Launch_App();
	// AppFunctions.Kill_Launch_App();
	// AppiumFunctions.getFeedCardsListAndNavigateToThem(false);//not going details
	// AppiumFunctions.getFeedCardsListAndNavigateToThem(true);//going details
	// AppiumFunctions.navigateToAllCardsByCardSize();
	// AppiumFunctions.getFeedCardsListAndNavigateToThem(true);
	// AppiumFunctions.Swipeforappdeckapk();
	// AppiumFunctions.Kill_launch();
	/*
	 * AppiumFunctions.ClickonIUnderstand(); //AppiumFunctions.clickOnNext();
	 * //AppiumFunctions.clickOnUnderstandbutton();
	 * CharlesFunctions.startSessionBrowserData();
	 * AppiumFunctions.Swipeforappdeckapk(); //AppiumFunctions.SwipeUp_Counter(1);
	 * AppiumFunctions.clickOnVideoElement();
	 * AppiumFunctions.clickOnBackArrowElement();
	 * AppiumFunctions.SwipeUp_Counter(2); AppiumFunctions.clickOnRadarMaps();
	 * AppiumFunctions.clickOnBackArrowElement();
	 * //AppiumFunctions.SwipeUp_Counter(1); //
	 * AppiumFunctions.clickOnVideoElement();
	 * //AppiumFunctions.clickOnBackArrowElement();
	 * AppiumFunctions.SwipeUp_Counter(2);
	 * AppiumFunctions.click_Todaydetails_element();
	 * AppiumFunctions.clickOnBackArrowElement();
	 * AppiumFunctions.SwipeUp_Counter(1);
	 * //AppiumFunctions.click_Boat_Beach_element();
	 * //AppiumFunctions.clickOnBackArrowElement();
	 * AppiumFunctions.click_Running_element();
	 * AppiumFunctions.clickOnBackArrowElement();
	 * AppiumFunctions.click_cold_Flu_element();
	 * AppiumFunctions.clickOnBackArrowElement();
	 * AppiumFunctions.click_Allergy_element();
	 * AppiumFunctions.clickOnBackArrowElement();
	 * AppiumFunctions.SwipeUp_Counter(1);
	 * AppiumFunctions.click_Airpollution_element();
	 * AppiumFunctions.clickOnBackArrowElement();
	 * AppiumFunctions.SwipeUp_Counter(2); AppiumFunctions.click_news_element();
	 */
	// AppiumFunctions.clickOnBackArrowElement();

	// Thread.sleep(100000);
	// Thread.sleep(40000);
	// CharlesFunctions.ExportSession();

	// AppiumFunctions.LaunchAppWithFullReset("true");
	// Ad.quit();
	// AppiumFunctions.LaunchAppWithFullReset("false");
	//
	// System.out.println("================= Before Test End
	// =========================");

//	}

	/*
	 * @Test(priority=1,enabled=true)
	 * 
	 * @Title("Verifying new daily details day1 ad call") public void
	 * Smoke_Test_Verifying_newdailydetails_day1adcall() throws Exception {
	 * System.out.
	 * println("================= Verifying new daily details day1 ad call tescase Started ========================="
	 * ); CharlesFunctions.ClearSessions();
	 * CharlesFunctions.startSessionBrowserData(); Functions.clickdailydetails();
	 * Functions.clickongotit(); CharlesFunctions.ExportSession(); Functions.
	 * verifyingdailydetailiu(); System.out.
	 * println("=================  Verifying new daily details day1 ad call tescase  End ========================="
	 * ); }
	 */

	/*
	 * @Test(priority = 20, enabled = true)
	 * 
	 * @Title("Verifying feed_2 ad call") public void
	 * Smoke_Test_verifying_feed_2adcall() throws Exception { System.out.
	 * println("================= Verifying feed_2 ad call tescase Started ========================="
	 * ); // AppFunctions.Kill_Launch_App(); CharlesFunctions.ClearSessions();
	 * CharlesFunctions.startSessionBrowserData();
	 * AppiumFunctions.getFeedCardsListAndNavigateToThem(true);//going details //
	 * AppiumFunctions.navigateToAllCardsByCardSize();
	 * CharlesFunctions.ExportSession(); Functions.verifying_feedcalls(2);
	 * System.out.
	 * println("================= Verifying feed_2 ad call tescase End ========================="
	 * ); }
	 * 
	 * @Test(priority = 21, enabled = true)
	 * 
	 * @Title("Verifying feed_3 ad call") public void
	 * Smoke_Test_verifying_feed_3adcall() throws Exception { System.out.
	 * println("================= Verifying feed_3 ad call tescase Started ========================="
	 * ); Functions.verifying_feedcalls(3); System.out.
	 * println("================= Verifying feed_3 ad call tescase End ========================="
	 * ); }
	 * 
	 * @Test(priority = 22, enabled = true)
	 * 
	 * @Title("Verifying feed_4 ad call") public void
	 * Smoke_Test_verifying_feed_4adcall() throws Exception { System.out.
	 * println("================= Verifying feed_4 ad call tescase Started ========================="
	 * ); Functions.verifying_feedcalls(4); System.out.
	 * println("================= Verifying feed_4 ad call tescase End ========================="
	 * ); }
	 * 
	 * @Test(priority = 23, enabled = true)
	 * 
	 * @Title("Verifying feed_5 ad call") public void
	 * Smoke_Test_verifying_feed_5adcall() throws Exception { System.out.
	 * println("================= Verifying feed_5 ad call tescase Started ========================="
	 * ); Functions.verifying_feedcalls(5); System.out.
	 * println("================= Verifying feed_5 ad call tescase End ========================="
	 * ); }
	 * 
	 * @Test(priority = 24, enabled = true)
	 * 
	 * @Title("Verifying feed_6 ad call") public void
	 * Smoke_Test_verifying_feed_6adcall() throws Exception { System.out.
	 * println("================= Verifying feed_6 ad call tescase Started ========================="
	 * ); Functions.verifying_feedcalls(6); System.out.
	 * println("================= Verifying feed_6 ad call tescase End ========================="
	 * ); }
	 */

	/*
	 * @Test(priority = 8, enabled = true)
	 * 
	 * @Title("Verifying amazon  Slot Id for feed2 ad call") public void
	 * Smoke_Test_amazon_aaxSlot_feed2_adcall() throws Exception {
	 * System.out.println(
	 * "================= Verify amazon aax slot  Id for feed2 prerol adcall testcase Started ========================="
	 * ); logStep(" Verifying amazon aax slot Id for feed2");
	 * Functions.get_aaxcal_feed2(); System.out.println(
	 * "================= Verify amazon aax slot Id for feed2 prerol adcall testcase End ========================="
	 * ); }
	 * 
	 * @Test(priority = 8, enabled = true)
	 * 
	 * @Title("Verifying amazon  Slot Id for feed3 ad call") public void
	 * Smoke_Test_amazon_aaxSlot_feed3_adcall() throws Exception {
	 * System.out.println(
	 * "================= Verify amazon aax slot  Id for feed3 prerol adcall testcase Started ========================="
	 * ); logStep(" Verifying amazon aax slot Id for feed3");
	 * Functions.get_aaxcal_feed3(); System.out.println(
	 * "================= Verify amazon aax slot Id for feed3 prerol  adcall testcase End ========================="
	 * ); }
	 * 
	 * @Test(priority = 9, enabled = true)
	 * 
	 * @Title("Verifying amazon  Slot Id for feed4 ad call") public void
	 * Smoke_Test_amazon_aaxSlot_feed4_adcall() throws Exception {
	 * System.out.println(
	 * "================= Verify amazon aax slot  Id for feed4 adcall testcase Started ========================="
	 * ); logStep(" Verifying amazon aax slot Id for feed4");
	 * Functions.get_aaxcal_feed4(); System.out.println(
	 * "================= Verify amazon aax slot Id for feed4 adcall testcase End ========================="
	 * ); }
	 * 
	 * @Test(priority = 10, enabled = true)
	 * 
	 * @Title("Verifying amazon  Slot Id for feed5 ad call") public void
	 * Smoke_Test_amazon_aaxSlot_feed5_adcall() throws Exception {
	 * System.out.println(
	 * "================= Verify amazon aax slot  Id for feed5 adcall testcase Started ========================="
	 * ); logStep(" Verifying amazon aax slot Id for feed5");
	 * Functions.get_aaxcal_feed5(); System.out.println(
	 * "================= Verify amazon aax slot Id for feed5 adcall testcase End ========================="
	 * ); }
	 * 
	 * @Test(priority = 11, enabled = true)
	 * 
	 * @Title("Verifying amazon  Slot Id for feed6 ad call") public void
	 * Smoke_Test_amazon_aaxSlot_feed6_adcall() throws Exception {
	 * System.out.println(
	 * "================= Verify amazon aax slot  Id for feed6 adcall testcase Started ========================="
	 * ); logStep(" Verifying amazon aax slot Id for feed6");
	 * 
	 * Functions.get_aaxcal_feed6(); System.out.println(
	 * "================= Verify amazon aax slot Id for feed6 adcall testcase End ========================="
	 * ); }
	 */

	/*
	 * @Test(priority=1,enabled=true)
	 * 
	 * @Title("Verifying new daily details day1 ad call") public void
	 * Smoke_Test_Verifying_newdailydetails_day1adcall() throws Exception {
	 * System.out.
	 * println("================= Verifying new daily details day1 ad call tescase Started ========================="
	 * ); CharlesFunctions.ClearSessions();
	 * CharlesFunctions.startSessionBrowserData(); Functions.clickdailydetails();
	 * Functions.clickongotit(); CharlesFunctions.ExportSession(); Functions.
	 * verifyingdailydetailiu(); System.out.
	 * println("=================  Verifying new daily details day1 ad call tescase  End ========================="
	 * ); }
	 * 
	 * 
	 * @Test(priority=2,enabled=true)
	 * 
	 * @Title("Verifying new daily details day2 ad call") public void
	 * Smoke_Test_Verifying_newdailydetails_day2adcall() throws Exception {
	 * System.out.
	 * println("================= Verifying new daily details day2 ad call tescase Started========================="
	 * ); CharlesFunctions.ClearSessions();
	 * CharlesFunctions.startSessionBrowserData(); Functions.clickonday2();
	 * CharlesFunctions.ExportSession(); Functions. verifyingdailydetailsiu();
	 * System.out.
	 * println("================= Verifying new daily details day1 ad call tescase End ========================="
	 * ); }
	 * 
	 * @Test(priority=3,enabled=true)
	 * 
	 * @Title("Verifying new daily details day3 ad call") public void
	 * Smoke_Test_Verifying_newdailydetails_day3adcall() throws Exception {
	 * System.out.
	 * println("================= Verifying new daily details day3 ad call tescase Started ========================="
	 * ); CharlesFunctions.ClearSessions();
	 * CharlesFunctions.startSessionBrowserData(); //
	 * Functions.finding_newDailyBidadcall_day2(); Functions.clickonday3();
	 * CharlesFunctions.ExportSession(); Functions. verifyingdailydetailsiu();
	 * System.out.
	 * println("================= Verifying new daily details day3 ad call tescase End ========================="
	 * ); }
	 * 
	 * @Test(priority=4,enabled=true)
	 * 
	 * @Title("Verifying new daily details day4 ad call") public void
	 * Smoke_Test_Verifying_newdailydetails_day4adcall() throws Exception {
	 * System.out.
	 * println("================= Verifying new daily details day4 ad call tescase Started ========================="
	 * ); CharlesFunctions.ClearSessions();
	 * CharlesFunctions.startSessionBrowserData(); //
	 * Functions.finding_newDailyBidadcall_day2(); Functions.clickonday4();
	 * CharlesFunctions.ExportSession(); Functions. verifyingdailydetailsiu();
	 * System.out.
	 * println("================= Verifying new daily details day4 ad call tescase End ========================="
	 * ); }
	 * 
	 * @Test(priority=5,enabled=true)
	 * 
	 * @Title("Verifying new daily details day5 ad call") public void
	 * Smoke_Test_Verifying_newdailydetails_day5adcall() throws Exception {
	 * System.out.
	 * println("================= Verifying new daily details day5 ad call tescase Started ========================="
	 * ); CharlesFunctions.ClearSessions();
	 * CharlesFunctions.startSessionBrowserData(); //
	 * Functions.finding_newDailyBidadcall_day2(); Functions.clickonday5();
	 * CharlesFunctions.ExportSession(); Functions. verifyingdailydetailsiu();
	 * System.out.
	 * println("================= Verifying new daily details day5 ad call tescase End ========================="
	 * ); }
	 * 
	 * @Test(priority=6,enabled=true)
	 * 
	 * @Title("Verifying new daily details day6 ad call") public void
	 * Smoke_Test_Verifying_newdailydetails_day6adcall() throws Exception {
	 * System.out.
	 * println("================= Verifying new daily details day6 ad call tescase Started ========================="
	 * ); CharlesFunctions.ClearSessions();
	 * CharlesFunctions.startSessionBrowserData(); //
	 * Functions.finding_newDailyBidadcall_day2(); Functions.clickonday6();
	 * CharlesFunctions.ExportSession(); Functions. verifyingdailydetailsiu();
	 * System.out.
	 * println("================= Verifying new daily details day6 ad call tescase End ========================="
	 * ); }
	 * 
	 * @Test(priority=7,enabled=true)
	 * 
	 * @Title("Verifying new daily details day7 ad call") public void
	 * Smoke_Test_Verifying_newdailydetails_day7adcall() throws Exception {
	 * System.out.
	 * println("================= Verifying new daily details day7 ad call tescase Started ========================="
	 * ); CharlesFunctions.ClearSessions();
	 * CharlesFunctions.startSessionBrowserData(); //
	 * Functions.finding_newDailyBidadcall_day2(); Functions.clickonday7();
	 * CharlesFunctions.ExportSession(); Functions. verifyingdailydetailsiu();
	 * System.out.
	 * println("================= Verifying new daily details day7 ad call tescase End ========================="
	 * ); }
	 * 
	 * @Test(priority=8,enabled=true)
	 * 
	 * @Title("Verifying new daily details day8 ad call") public void
	 * Smoke_Test_Verifying_newdailydetails_day8adcall() throws Exception {
	 * System.out.
	 * println("================= Verifying new daily details day8 ad call tescase Started ========================="
	 * ); CharlesFunctions.ClearSessions();
	 * CharlesFunctions.startSessionBrowserData(); //
	 * Functions.finding_newDailyBidadcall_day2(); Functions.clickonday8();
	 * CharlesFunctions.ExportSession(); Functions. verifyingdailydetailsiu1();
	 * System.out.
	 * println("================= Verifying new daily details day8 ad call tescase End ========================="
	 * ); }
	 * 
	 * @Test(priority=9,enabled=true)
	 * 
	 * @Title("Verifying new daily details day9 ad call") public void
	 * Smoke_Test_Verifying_newdailydetails_day9adcall() throws Exception {
	 * System.out.
	 * println("================= Verifying new daily details day9 ad call tescase Started ========================="
	 * ); CharlesFunctions.ClearSessions();
	 * CharlesFunctions.startSessionBrowserData(); //
	 * Functions.finding_newDailyBidadcall_day2(); Functions.clickonday9();
	 * CharlesFunctions.ExportSession(); Functions. verifyingdailydetailsiu1();
	 * System.out.
	 * println("================= Verifying new daily details day9 ad call tescase End ========================="
	 * ); }
	 * 
	 * @Test(priority=10,enabled=true)
	 * 
	 * @Title("Verifying new daily details day10 ad call") public void
	 * Smoke_Test_Verifying_newdailydetails_day10adcall() throws Exception {
	 * System.out.
	 * println("================= Verifying new daily details day10 ad call tescase Started ========================="
	 * ); CharlesFunctions.ClearSessions();
	 * CharlesFunctions.startSessionBrowserData(); //
	 * Functions.finding_newDailyBidadcall_day2(); Functions.clickonday10();
	 * CharlesFunctions.ExportSession(); Functions. verifyingdailydetailsiu1();
	 * System.out.
	 * println("================= Verifying new daily details day10 ad call tescase End ========================="
	 * ); }
	 * 
	 * @Test(priority=11,enabled=true)
	 * 
	 * @Title("Verifying new daily details day11 ad call") public void
	 * Smoke_Test_Verifying_newdailydetails_day11adcall() throws Exception {
	 * System.out.
	 * println("================= Verifying new daily details day11 ad call tescase Started ========================="
	 * ); CharlesFunctions.ClearSessions();
	 * CharlesFunctions.startSessionBrowserData(); //
	 * Functions.finding_newDailyBidadcall_day2(); Functions.clickonday11();
	 * CharlesFunctions.ExportSession(); Functions. verifyingdailydetailsiu1();
	 * System.out.
	 * println("================= Verifying new daily details day11 ad call tescase End ========================="
	 * ); }
	 * 
	 * @Test(priority=12,enabled=true)
	 * 
	 * @Title("Verifying new daily details day12 ad call") public void
	 * Smoke_Test_Verifying_newdailydetails_day12adcall() throws Exception {
	 * System.out.
	 * println("================= Verifying new daily details day12 ad call tescase Started ========================="
	 * ); CharlesFunctions.ClearSessions();
	 * CharlesFunctions.startSessionBrowserData(); //
	 * Functions.finding_newDailyBidadcall_day2(); Functions.clickonday12();
	 * CharlesFunctions.ExportSession(); Functions. verifyingdailydetailsiu1();
	 * System.out.
	 * println("================= Verifying new daily details day12 ad call tescase End ========================="
	 * ); }
	 * 
	 * @Test(priority=13,enabled=true)
	 * 
	 * @Title("Verifying new daily details day13 ad call") public void
	 * Smoke_Test_Verifying_newdailydetails_day13adcall() throws Exception {
	 * System.out.
	 * println("================= Verifying new daily details day13 ad call tescase Started ========================="
	 * ); CharlesFunctions.ClearSessions();
	 * CharlesFunctions.startSessionBrowserData(); //
	 * Functions.finding_newDailyBidadcall_day2(); Functions.clickonday13();
	 * CharlesFunctions.ExportSession(); Functions. verifyingdailydetailsiu1();
	 * System.out.
	 * println("================= Verifying new daily details day13 ad call tescase End ========================="
	 * ); }
	 * 
	 * @Test(priority=14,enabled=true)
	 * 
	 * @Title("Verifying new daily details day14 ad call") public void
	 * Smoke_Test_Verifying_newdailydetails_day14adcall() throws Exception {
	 * System.out.
	 * println("================= Verifying new daily details day14 ad call tescase Started ========================="
	 * ); CharlesFunctions.ClearSessions();
	 * CharlesFunctions.startSessionBrowserData(); //
	 * Functions.finding_newDailyBidadcall_day2(); Functions.clickonday14();
	 * CharlesFunctions.ExportSession(); Functions. verifyingdailydetailsiu1();
	 * System.out.
	 * println("================= Verifying new daily details day14 ad call tescase End ========================="
	 * ); }
	 * 
	 * @Test(priority=15,enabled=true)
	 * 
	 * @Title("Verifying new daily details day15 ad call") public void
	 * Smoke_Test_Verifying_newdailydetails_day15adcall() throws Exception {
	 * System.out.
	 * println("================= Verifying new daily details day15 ad call tescase Started ========================="
	 * ); CharlesFunctions.ClearSessions();
	 * CharlesFunctions.startSessionBrowserData(); //
	 * Functions.finding_newDailyBidadcall_day2(); Functions.clickonday15();
	 * CharlesFunctions.ExportSession(); Functions. verifyingdailydetailsiu2();
	 * System.out.
	 * println("================= Verifying new daily details day15 ad call tescase End ========================="
	 * ); }
	 */

	/*
	 * @Test(priority=16,enabled=true)
	 * 
	 * @Title("Verifying feed_1 ad call") public void
	 * Smoke_Test_Verifying_feed_1adcal() throws Exception { System.out.
	 * println("================= Verifying feed_1 ad call tescase Started ========================="
	 * );
	 * 
	 * System.out.
	 * println("=================  Verifying feed_1 ad call tescase End ========================="
	 * ); }
	 */

	//

	@AfterTest
	public void After_Test() throws Exception {
		/*
		 * System.out.println("After Test started");
		 * 
		 * TemporaryFilesystem.getDefaultTmpFS().deleteTemporaryFiles(); Ad.quit();
		 */

	}

}
