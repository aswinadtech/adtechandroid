package twc.Automation.SmokeTestCases;

import org.testng.annotations.Test;
import java.util.ArrayList;
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

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
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
	protected String email;

	

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	public int age;

	/*
	 * @Test public static void Scroll() throws Exception{ for(int
	 * scroll=1;scroll<=250;scroll++){ System.out.println("times =" +scroll);
	 * for(int i=1;i<=10 ;i++){ //System.out.println("times" +i);
	 * Thread.sleep(2000); AppFunctions.Swipe(); Thread.sleep(2000); }
	 * 
	 * AppiumFunctions.Kill_launch(); } CharlesFunctions.ExportSession();
	 * 
	 * }
	 */

	// Validate BB on Severe1
	/*
	 * @Test(priority=1,enabled = true,retryAnalyzer=RetryAnalyzer.class)
	 * 
	 * @Title("Content Mode Severe1") public void
	 * Smoke_Test_Case_Content_Mode_Severe1() throws Exception{ System.out.
	 * println("================= Content Mode Severe1 Test Case Started ========================="
	 * ); AppiumFunctions.Kill_launch();
	 * MapLocalFunctions.contentModeModule("severe1");
	 * CharlesFunctions.charlesOpen(); CharlesFunctions.browserForMapLocal();
	 * CharlesFunctions.ClearSessions(); AppiumFunctions.Kill_launch();
	 * CharlesFunctions.ExportSession();
	 * Functions.maplocal_bbcall_validation("MapLocal","severe1"); System.out.
	 * println("================= Content Mode Severe1 Test Case End ========================="
	 * ); }
	 */

	// Valodate BB on Severe2
	/*
	 * @Test(priority=2,enabled = true,retryAnalyzer=RetryAnalyzer.class)
	 * 
	 * @Title("Content Mode Severe2") public void
	 * Smoke_Test_Case_Content_Mode_Severe2() throws Exception{ System.out.
	 * println("================= Content Mode Severe2 Test Case Started ========================="
	 * );
	 * 
	 * MapLocalFunctions.contentModeModule("severe2");
	 * //AppiumFunctions.UnInstallApp(); //added this AppiumFunctions.Kill_launch();
	 * // AppiumFunctions.Kill_launch(); CharlesFunctions.ClearSessions();
	 * //AppiumFunctions.Kill_launch(); AppiumFunctions.Kill_launch();; //added this
	 * CharlesFunctions.ExportSession();
	 * Functions.maplocal_bbcall_validation("MapLocal","severe2"); System.out.
	 * println("================= Content Mode Severe2 Test Case End ========================="
	 * ); }
	 */

	// CXTG Values Test Case
	/*
	 * @Title("Verify WeatherFx API Call Response When User Selects Contextual Locations"
	 * )
	 * 
	 * @Test(priority=3,enabled = true,retryAnalyzer=RetryAnalyzer.class) public
	 * void
	 * Smoke_Test_Case_C415129_Verify_Weatherfx_API_Call_Response_When_User_Selects_Contextual_Locations
	 * () throws Exception{ System.out.
	 * println("================= WFXTG Test Case Started ========================="
	 * ); MapLocalFunctions.contentModeModule("normal");
	 * CharlesFunctions.startSessionBrowserData();
	 * //AppiumFunctions.LaunchAppWithFullReset("false");
	 * //AppFunctions.compareBuildVersion();//commeneted dec 9
	 * //AppiumFunctions.Kill_launch(); //AppiumFunctions.Swipe_Up();
	 * //loginModule.login(); //AppFunctions.Kill_Launch_App();
	 * //Functions.verifySavedAddressList(1);
	 * CharlesFunctions.StopExportSessionXMLFile();
	 * Functions.validate_CXTG_values1("WFXTrigger"); System.out.
	 * println("================= WFXTG Test Case End ========================="); }
	 */

	// Wfxtg Values Test Case
	/*
	 * @Test(priority=4,enabled = true,retryAnalyzer=RetryAnalyzer.class)
	 * 
	 * @Title("Verify WeatherFX API Request For Wfxtg Value") public void
	 * Smoke_Test_Case_C333173_Verify_WeatherFX_API_Request_For_Wfxtg_Value() throws
	 * Exception{ System.out.
	 * println("================= Wfxtg Values Test Case Started ========================="
	 * );
	 * 
	 * if(RetryAnalyzer.count >= 1){
	 * 
	 * Functions.validate_CXTG_values2("WFXTrigger"); }else{
	 * Functions.validate_CXTG_values2("WFXTrigger"); }
	 * 
	 * System.out.
	 * println("================= Wfxtg Values Test Case End ========================="
	 * ); }
	 */

	// Factual Call Test Case
	/*
	 * @Test(priority=5,enabled = true,retryAnalyzer=RetryAnalyzer.class)
	 * 
	 * @Title("Verify Factual Call") public void
	 * Smoke_Test_Case_C333174_Verify_Factual_Call() throws Exception{ System.out.
	 * println("================= Factual Call Test Case Started ========================="
	 * ); Functions.validate_CXTG_values2("WFXTrigger"); System.out.
	 * println("================= Factual Call Test Case End ========================="
	 * ); }
	 */

	// Lotame Call Test Case
	/*
	 * @Test(priority=6,enabled = true,retryAnalyzer=RetryAnalyzer.class)
	 * 
	 * @Title("Verify Lotame Call") public void
	 * Smoke_Test_Case_C333182_Verify_Lotame_Call() throws Exception{ System.out.
	 * println("================= Lotame Call Test Case Started ========================="
	 * ); Functions.validate_CXTG_values3("WFXTrigger"); System.out.
	 * println("================= Lotame Call Test Case End ========================="
	 * ); }
	 * 
	 * // Pull To Refresh Test Case
	 * 
	 * @Test(priority=7,enabled = true)
	 * 
	 * @Title("Verify Ad Call Is Made On Pull To Refresh") public void
	 * Smoke_Test_Case_C333179_Verify_Ad_Call_Is_Made_On_Pull_To_Refresh() throws
	 * Exception{ System.out.
	 * println("================= Pull To Refresh Test Case Started ========================="
	 * ); CharlesFunctions.startSessionBrowserData(); AppiumFunctions.Kill_launch();
	 * AppFunctions.Pull_To_Refresh("Pulltorefresh");
	 * CharlesFunctions.StopExportSessionXMLFile();
	 * Functions.bb_call_validation("Pulltorefresh");
	 * 
	 * System.out.
	 * println("================= Pull To Refresh Test Case  End ========================="
	 * ); }
	 * 
	 * 
	 * //ApiumFunctions.LaunchAppWithFullReset(); Launch Test Case
	 * 
	 * @Test(priority=8,enabled = true)
	 * 
	 * @Title("Verify Ad Calls On Clean Launch") public void
	 * Smoke_Test_Case_C333172_Verify_Ad_Calls_On_Clean_Launch() throws Exception{
	 * System.out.
	 * println("================= Clean App Launch Test Case Started ========================="
	 * ); CharlesFunctions.startSessionBrowserData();
	 * //AppiumFunctions.Kill_launch(); AppiumFunctions.Kill_launch();
	 * AppFunctions.CleanLaunch_launch("General"); CharlesFunctions.ExportSession();
	 * Functions.clean_App_Launch("CleanLaunch"); System.out.
	 * println("================= Clean App Launch Test Case End ========================="
	 * ); } //Lotame Call Test Case
	 * 
	 * @Test(priority=9,enabled = true)
	 * 
	 * @Title("Verify Bcp Call") public void Verify_Bcp_Call() throws Exception{
	 * System.out.
	 * println("================= Bcp Call Test Case Started ========================="
	 * );
	 * 
	 * Functions.validate_CXTG_values4("WFXTrigger"); System.out.
	 * println("================= Bcp Call Test Case End ========================="
	 * ); }
	 */
//
//

	// Hourly Module Extended Page Ad Test Case
	/*
	 * @Test(priority=1,enabled = true)
	 * 
	 * @Title("Verify Ad Is Present On Extended Hourly Page") public void
	 * Smoke_Test_Case_C333175_Verifyd_Ad_Is_Present_On_Extended_Hourly_Page()
	 * throws Exception { System.out.
	 * println("================= Hourly Module Test Case Started ========================="
	 * ); AppiumFunctions.Kill_launch(); AppiumFunctions.Kill_launch();
	 * AppFunctions.AddingLocation(); CharlesFunctions.ClearSessions();
	 * AppFunctions.verify_adpresent_onHourly_page("Hourly");
	 * CharlesFunctions.ExportSession();
	 * Functions.get_wfxtriggers_call2("WFXTrigger");
	 * AppFunctions.click_HomeButton(); System.out.
	 * println("================= Hourly Module Test Case End ========================="
	 * ); } //Daily Module Extended Page Ad Test Case
	 * 
	 * @Test(priority=2,enabled = true)
	 * 
	 * @Title("Verify Ad Is Present On Extended Daily Page") public void
	 * Smoke_Test_Case_C333180_Verify_Ad_Is_Present_On_Extended_Daily_Page() throws
	 * Exception { System.out.
	 * println("================= Daily Module Test Case Started ========================="
	 * ); CharlesFunctions.ClearSessions();
	 * AppFunctions.verify_adpresent_onToday_page();
	 * CharlesFunctions.ExportSession(); Functions.finding_Dailycall("WFXTrigger");
	 * AppFunctions.click_HomeButton();
	 * 
	 * System.out.
	 * println("================= Daily Module Test Case End ========================="
	 * ); } //Today Module Extended Maps Page Ad Test Case
	 * 
	 * @Test(priority=3,enabled = true)
	 * 
	 * @Title("Verify Ad Is Present On Extended Radr Page") public void
	 * Smoke_Test_Case_C333180_Verify_Ad_Is_Present_On_RadarPage() throws Exception
	 * { System.out.
	 * println("================= Radar Module Test Case Started ========================="
	 * ); CharlesFunctions.ClearSessions();
	 * AppFunctions.verify_adpresent_onRadar_page("Daily");
	 * CharlesFunctions.ExportSession(); Functions.finding_Mapcall("Daily");
	 * AppFunctions.click_HomeButton(); System.out.
	 * println("================= Radar Module Test Case End ========================="
	 * ); }
	 * 
	 * @Test(priority=4,enabled = true)
	 * 
	 * @Title("Verify Ad Is Present On Extended Video Page") public void
	 * Smoke_Test_Case_C333175_Verify_Ad_Is_Present_On_Extended_Video_Page() throws
	 * Exception { System.out.
	 * println("================= Video Module Test Case Started ========================="
	 * ); CharlesFunctions.ClearSessions();
	 * AppFunctions.verify_adpresent_onvideo_page("Daily");
	 * CharlesFunctions.ExportSession(); Functions.finding_Videocall("Daily");
	 * AppFunctions.click_HomeButton(); System.out.
	 * println("================= Video Module Test Case End ========================="
	 * ); }
	 * 
	 * @Test(priority=1,enabled = true)
	 * 
	 * @Title("Verify Ad Is Present On Extended Hourly tile Page") public void
	 * Verify_Ad_Is_Present_On_Extended_HourlyTile_Page() throws Exception {
	 * System.out.
	 * println("================= Video Module Test Case Started ========================="
	 * ); CharlesFunctions.ClearSessions();
	 * AppFunctions.verify_adpresent_onvideo_page("Daily");
	 * CharlesFunctions.ExportSession(); Functions.finding_Videocall("Daily");
	 * AppFunctions.click_HomeButton(); System.out.
	 * println("================= Video Module Test Case End ========================="
	 * ); }
	 * 
	 * // Verify the home screen ads and ad calls for Native BB and Native Animated
	 * BB
	 * 
	 * @Test(priority=1,enabled = true,retryAnalyzer=RetryAnalyzer.class)
	 * 
	 * @Title("Verify home screen ads  and ad calls") public void
	 * Smoke_Test_Case_homescreenadsandadcalls() throws Exception{ System.out.
	 * println("================= Verify home screen ads  and ad calls for  Native BB  Test Case Started ========================="
	 * ); AppiumFunctions.LaunchApp(); CharlesFunctions.startSessionBrowserData();
	 * CharlesFunctions.ClearSessions(); System.out.
	 * println("================= Verify home screen ads  and ad calls for  Native BB  Test Case End ========================="
	 * ); } //Verify Today tile iu call value is generated or not
	 * 
	 * @Test(priority=200,enabled = true)
	 * 
	 * @Title("Verify Today tile iu call value is generated or not") public void
	 * Smoke_Test_CaseVerify_Hourlytileiucallvalue() throws Exception { System.out.
	 * println("================= Today Tile Test Case Started ========================="
	 * );
	 * 
	 * Functions.get_tileadcalls_hourly(); System.out.
	 * println("================= Today Tile Test Case End ========================="
	 * ); }
	 * 
	 * @Test(priority=3,enabled = true)
	 * 
	 * @Title("Verify Today tile iu call value is generated or not") public void
	 * Smoke_Test_CaseVerify_Dailytileiucallvalue() throws Exception { System.out.
	 * println("================= Today Tile Test Case Started ========================="
	 * );
	 * 
	 * Functions.get_tileadcalls_daily(); System.out.
	 * println("================= Today Tile Test Case End ========================="
	 * ); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @Test(priority=1,enabled = true)
	 * 
	 * @Title("Verifying iu value for maps card") public void
	 * Smoke_Test_CaseVerify_mapscard_iu() throws Exception { System.out.
	 * println("================= verifying iu value for the maps card started ========================="
	 * ); AppFunctions.Swipeapptillend(); CharlesFunctions.ExportSessions();
	 * Functions.finding_maps_cardvalue(); System.out.
	 * println("================= verifying iu value for the maps card End ========================="
	 * ); } /*@Test(priority=2,enabled = true)
	 * 
	 * @Title("Verifying iu value for health and activities card") public void
	 * Smoke_Test_CaseVerify_health_and_activities_card2_iu() throws Exception {
	 * System.out.
	 * println("================= verifying iu value for health_and_activitiescard_iu started ========================="
	 * ); Functions.finding_health_activities_card_iu_value(); System.out.
	 * println("================= verifying iu value for health_and_activitiescard__iu End ========================="
	 * ); }
	 */
	/*
	 * @Test(priority=2,enabled = true)
	 * 
	 * @Title("Verifying Lotame bcp.crwdcntrl.net url") public void
	 * Smoke_TestCaseVerify_bcpcrwdcntrlnet_url() throws Exception { System.out.
	 * println("================= Verifying Lotame bcpcrwdcntrlnet url started ========================="
	 * ); Functions.validating_bcp(); System.out.
	 * println("================= Verifying Lotame bcpcrwdcntrlnet url End ========================="
	 * ); }
	 * 
	 * @Test(priority=1,enabled = true)
	 * 
	 * @Title("Verifying Lotame ad.crwdcntrl.net url") public void
	 * Smoke_Test_CaseVerify_adcrwdcntrlnet_url() throws Exception { System.out.
	 * println("================= Verifying Lotame ad.crwdcntrl.net url started ========================="
	 * ); CharlesFunctions.startSessionBrowserData();
	 * CharlesFunctions.ExportSession(); Functions.validating_adcrw(); System.out.
	 * println("================= Verifying Lotame ad.crwdcntrl.net url End ========================="
	 * ); }
	 * 
	 * @Test(priority=2,enabled = true)
	 * 
	 * @Title("Verifying wfxtg triggere call url") public void
	 * Smoke_Test_CaseVerify_WeatherFXAPI_url() throws Exception { System.out.
	 * println("================= Verifying WeatherFX API url started ========================="
	 * ); Functions.validating_WeatherFXAPI(); System.out.
	 * println("================= Verifying WeatherFX API url End ========================="
	 * ); }
	 */
	/*
	 * @Test(priority=4,enabled = true)
	 * 
	 * @Title("Verifying Lotame ad.crwdcntrl.net url") public void
	 * Smoke_Test_CaseVerify_WeatherFX_url() throws Exception { System.out.
	 * println("================= Verifying WeatherFX API url started ========================="
	 * ); Functions.validating_WeatherFXAPI(); System.out.
	 * println("================= Verifying WeatherFX API url End ========================="
	 * ); }
	 */
	/*
	 * @Test(priority=3,enabled = true)
	 * 
	 * @Title("Verifying Fatual location url") public void
	 * Smoke_Test_CaseVerify_Fatual_url() throws Exception { System.out.
	 * println("================= Verifying Fatual url started ========================="
	 * ); Functions.validating_Fatual(); System.out.
	 * println("================= Verifying Fatual API url End ========================="
	 * ); }
	 */
	/*
	 * @Test(priority=100,enabled = true)
	 * 
	 * @Title("Verifying Lotame ad.crwdcntrl.net url") public void
	 * Smoke_TestCasePulltoRefresh() throws Exception { System.out.
	 * println("================= Verifying Home screen ad call while pull to refresh started ========================="
	 * ); CharlesFunctions.clearSessionBrowserData();
	 * CharlesFunctions.startSessionBrowserData(); AppFunctions.Kill_Launch_App();
	 * AppiumFunctions.ClickonIUnderstand();
	 * AppFunctions.Pull_To_Refresh("Pulltorefresh");
	 * CharlesFunctions.ExportSession(); Functions.finding_Homescreen_iu_value();
	 * System.out.
	 * println("=================Verifying Home screen ad call while pull to refresh End ========================="
	 * ); }
	 * 
	 * @Test(priority=5,enabled = true)
	 * 
	 * @Title("Verifying iu value for Home screen") public void
	 * Smoke_Test_CaseVerify_Homescreen_ad_iu() throws Exception { System.out.
	 * println("================= verifying iu value for health_and_activitiescard_iu started ========================="
	 * ); Functions.finding_Homescreen_iu_value(); System.out.
	 * println("================= verifying iu value for health_and_activitiescard__iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=6,enabled = true)
	 * 
	 * @Title("Verifying iu value for Video ") public void
	 * Smoke_Test_CaseVerify_Vidoe_ad_iu() throws Exception { System.out.
	 * println("================= verifying iu value for  Video ad call iu started ========================="
	 * ); Functions.finding_VideoCard_iu_value(); System.out.
	 * println("================= verifying iu value for  Video ad call iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=7,enabled = true)
	 * 
	 * @Title("Verifying iu value for Radar&Maps ") public void
	 * Smoke_Test_CaseVerify_Radar_Map_card_iu() throws Exception { System.out.
	 * println("================= verifying iu value for Radar_Map_card started ========================="
	 * ); Functions.finding_Radar_Map_card_iu_value(); System.out.
	 * println("================= verifying iu value for Radar_Map_card End ========================="
	 * ); }
	 * 
	 * @Test(priority=8,enabled = true)
	 * 
	 * @Title("Verifying iu value Today details Page ") public void
	 * Smoke_Test_CaseVerify_Today_details_page_iu() throws Exception { System.out.
	 * println("================= verifying iu value for Today_details_page_iu started ========================="
	 * ); Functions.finding_Today_detail_page_iu_value(); System.out.
	 * println("================= verifying iu value for Today_details_page_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=9,enabled = true)
	 * 
	 * @Title("Verifying iu value for health and activities Running Spot light ad call iu"
	 * ) public void
	 * Smoke_Test_Verify_health_and_activities_Running_spotlight_adcall_iu() throws
	 * Exception { System.out.
	 * println("================= Verify_health_and_activities_Running_spotlight_adcall_iu Started ========================="
	 * ); Functions. health_and_activities_Running_spotlight_adcall_iu();
	 * System.out.
	 * println("================= Verify_health_and_activities_Running_spotlight_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=10,enabled = true)
	 * 
	 * @Title("Verifying iu value for health and activities Bot&beach Spotlight ad call iu"
	 * ) public void
	 * Smoke_Test_Verify_health_and_activities_Bot_beach_detailpage_adcall_iu()
	 * throws Exception { System.out.
	 * println("================= Verify_health_and_activities_Bot&beach_Spotlight_adcall_iu Started ========================="
	 * ); Functions.health_and_activities_Boat_beach_detailpage_adcall_iu();
	 * System.out.
	 * println("================= Verify_health_and_activities_Bot&beach_Spotlight_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=11,enabled = true)
	 * 
	 * @Title("Verifying iu value for health and activities Allergy Spot light ad call iu"
	 * ) public void
	 * Smoke_Test_Verify_health_and_activities_Allergy_detailpage_adcall_iu() throws
	 * Exception { System.out.
	 * println("================= Verify_health_and_activities_Allergy_Spotlight_adcall_iu Started ========================="
	 * ); Functions.health_and_activities_Allergy_detailpage_adcall_iu();
	 * System.out.
	 * println("================= Verify_health_and_activities_Allergy_Spotlight_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=12,enabled = true)
	 * 
	 * @Title("Verifying iu value for health and activities cold&Flu Spotlight ad call iu"
	 * ) public void
	 * Smoke_Test_Verify_health_and_activities_cold_flu_Spotlight_adcall_iu() throws
	 * Exception { System.out.
	 * println("================= Verify_health_and_activities_cold_flu_Spotlight_adcall_iu Started ========================="
	 * ); Functions.health_and_activities_Cold_Flu_detailpage_adcall_iu();
	 * System.out.
	 * println("================= Verify_health_and_activities_cold_flu_Spotlight_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=13,enabled = true)
	 * 
	 * @Title("Verifying iu value for health and activities Air Quality detailpage ad call iu"
	 * ) public void
	 * Smoke_Test_Verify_health_and_activities_Air_Quality_detailpage_adcall_iu()
	 * throws Exception { System.out.
	 * println("================= Verify_health_and_activities_AirQuality_detailpage_adcall_iu Started ========================="
	 * ); Functions.health_and_activities_AirQuality_detailpage_adcall_iu();
	 * System.out.
	 * println("================= Verify_health_and_activities_AirQuality_detailpage_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=14,enabled = true)
	 * 
	 * @Title("Verifying iu value Hurricane detailpage ad call iu") public void
	 * Smoke_Test_Verify_Hurricane_detailpage_adcall_iu() throws Exception {
	 * System.out.
	 * println("================= Verify_Hurricane_detailpage_adcall_iu Started ========================="
	 * ); Functions.Verify_Hurricane_detailpage_adcall_iu(); System.out.
	 * println("================= Verify_Hurricane_detailpage_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=15,enabled = true)
	 * 
	 * @Title("Verifying iu value for news detailpage ad call iu") public void
	 * Smoke_Test_Verify_News_detailpage_adcall_iu() throws Exception { System.out.
	 * println("================= Verify_News_detailpage_adcall_iu Started ========================="
	 * ); Functions.Verify_News_detailpage_adcall_iu(); System.out.
	 * println("================= Verify_News_detailpage_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=16,enabled = true)
	 * 
	 * @Title("Verifying iu value for daily card ad call iu") public void
	 * Smoke_Test_Verify_daily_card_adcall_iu() throws Exception { System.out.
	 * println("================= Verify_News_detailpage_adcall_iu Started ========================="
	 * ); Functions. Verify_dailycard_iu(); System.out.
	 * println("================= Verify_daily_card_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=105,enabled = true)
	 * 
	 * @Title("Verifying iu value for snapshot ad call iu") public void
	 * Smoke_Test_Verify_snapshotcard_adcall_iu() throws Exception { System.out.
	 * println("================= Verify_snapshotcard_adcall_iu Started ========================="
	 * ); CharlesFunctions.ClearSessions();
	 * CharlesFunctions.startSessionBrowserData();
	 * AppiumFunctions.click_snapShot_button(); CharlesFunctions.ExportSession();
	 * Functions.Verify_snapshot_spotlight_adcard_iu(); System.out.
	 * println("================= Verify_snapshotcard_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=104,enabled = true)
	 * 
	 * @Title("Verifying iu value for snapshot ad call iu") public void
	 * Smoke_Test_Verify_snapshot_spotlight_adcall_iu() throws Exception {
	 * System.out.
	 * println("================= Verify_snapshot_spotlight_adcall_iu Started ========================="
	 * ); Functions.Verify_snapshot_spotlight_iu(); System.out.
	 * println("================= Verify_snapshot_spotlight_adcall_iu End ========================="
	 * ); }
	 */
	
	 /* @Test(priority=133,enabled = true)
	  
	  @Title("Verifying NextGen IM ad call unit") public void
	  Smoke_Test_NextGen_IM_adunit() throws Exception { 
		  
		  System.out.println("================= Verify  NextGen IM adunit testcase Started =========================" ); 
	
	//  AppFunctions.putTestMode();
	//AppFunctions. enable_adstestadunit();
	// AppiumFunctions.Kill_launch(); 
	 // AppFunctions.putTestMode(); 
//	  AppFunctions.enable_adstestadunit();   
	//  Thread.sleep(5000); // AppiumFunctions.Kill_launch();
	// AppFunctions.Kill_Launch_App(); 
	//  AppFunctions.enable_responsive_mode();
	   AppFunctions.Kill_Launch_App(); 
	//  AppFunctions.enter_nextgenIm_ad_location();
	  CharlesFunctions.startSessionBrowserData();
	  CharlesFunctions.ExportSession();
	 Functions.nextgenim_adunit(); 
	 System.out.println("================= Verify  NextGen IM adunit testcase End =========================" ); 
	 
	  }*/
	 
	
	  /*@Test(priority=22,enabled = true)	  
	  @Title("Verifying  NextGen IM ad card call response") public void
	  Smoke_Test_verifying_NextGenIM_response() throws Exception { 
	   System.out.println("================= Verify  NextGen IM ad response testcase started =========================");
	   Functions.nextgenim_adcall_response(); 
	   System.out.println("================= Verify   NextGen IM ad  response testcase End ========================="); 
	 
	  }
	 
	  @Test(priority=32,enabled = true)
	 
	  @Title("Verifying the FG and BG URL'S for nextgen ad call") public void
	 Smoke_Test_verifying_FG_BG_urls_NextgenIm_Ad() throws Exception {
	  System.out.println("================= Verify  Nextgen Im adunit response testcase started =========================");
	  Functions.validate_FG_BG_adcalls_NextGenIM(); 
	  System.out.println("================= Verify  Nextgen Im adunit response testcase End ========================="); 
	
	 }
	 
	 @Test(priority=44,enabled = true)
	 
	  @Title("Verifying the Size for nextgen ad call") public void
	  Smoke_Test_verifying_Size_NextgenIm_Ad() throws Exception { 
	  System.out.println("================= Verify  Nextgen Im adunit response testcase started ========================="); 
     // CharlesFunctions.ClearSessions();
	  Functions.validate_Size_NextGenIM();  
	  System.out.println("================= Verify  Nextgen Im adunit response testcase End =========================");
	  }*/
	
	 
	/*@Test(priority = 52, enabled = true)
		@Title("Verifying SOD Cust param value for home screen call when user selecting Optoutmode scenario in privacy card")
		public void Smoke_Test_Verifying_SOD_Cust_Param_homescreenad_Optoutmode_scenario() throws Exception {
		
		 System.out.println("================= Verifying SOD CUST_PARAM value for home screen call  when user selecting Optoutmode scenario in privacy card started =========================");				
	      Functions.validate_SOD_Cust_param_homescreen_Optoutmode();
		  System.out.println("================= Verifying SOD CUST_PARAM value for home screen call when user selecting Optoutmode scenario in privacy card End =========================");
		}
	 
	 @Test(priority = 53, enabled = true)
		@Title("Verifying SOD Cust param value for  Feed ad call when user selecting Optoutmode scenario in privacy card")
		public void Smoke_Test_Verifying_SOD_Cust_Param_Feedad_Optoutmode_scenario() throws Exception {

			
		 System.out.println("================= Verifying SOD CUST_PARAM value for Feed ad call  when user selecting Optoutmode scenario in privacy card started =========================");				
	      Functions.validate_SOD_Cust_param_feed_Optoutmode();
		  System.out.println("================= Verifying SOD CUST_PARAM value for Feed ad call  when user selecting Optoutmode scenario in privacy card End =========================");
		}
	
	 
	 @Test(priority = 54, enabled = true)
		@Title("Verifying SOD Cust param value for detail Feed ad call when user selecting Optoutmode scenario in privacy card")
		public void Smoke_Test_Verifying_SOD_Cust_Param_detail_Feedad_Optoutmode_scenario() throws Exception {			
		 System.out.println("================= Verifying SOD CUST_PARAM value for  detailed Feed ad call  when user selecting Optoutmode scenario in privacy card started =========================");				
	      Functions.validate_SOD_Cust_param_deatiledfeed_Optoutmode();
		  System.out.println("================= Verifying SOD CUST_PARAM value for  detailed Feed ad call  when user selecting Optoutmode scenario in privacy card End =========================");
		}
	
	 @Test(priority = 55, enabled = true)
		@Title("Verifying SOD Cust param value for video call when user selecting Optoutmode scenario in privacy card")
		public void Smoke_Test_Verifying_SOD_Cust_Param_videoad_Optoutmode_scenario() throws Exception {
			
		 System.out.println("================= Verifying SOD CUST_PARAM value for video ad call  when user selecting Optoutmode scenario in privacy card started =========================");				
	      Functions.validate_SOD_Cust_param_video_Optoutmode();
		  System.out.println("================= Verifying SOD CUST_PARAM value for video ad call  when user selecting Optoutmode scenario in privacy card End =========================");
		}*/
	 
	 
	 

	/* @Test(priority = 56, enabled = true)
		@Title("Verifying RDP  value for home screen call when user selecting Optoutmode scenario in privacy card")
		public void Smoke_Test_Verifying_RDP_value_homescreenad_Optoutmode_scenario() throws Exception {
		
		 System.out.println("================= Verifying RDP value for home screen call  when user selecting Optoutmode scenario in privacy card started =========================");				
	      Functions.validate_RDP_homescreen_Optoutmode();
		  System.out.println("================= Verifying RDP value for home screen call when user selecting Optoutmode scenario in privacy card End =========================");
		}
	 
	 @Test(priority = 57, enabled = true)
		@Title("Verifying RDP  value for feed ad call when user selecting Optoutmode scenario in privacy card")
		public void Smoke_Test_Verifying_RDP_value_feedad_Optoutmode_scenario() throws Exception {
		
		 System.out.println("================= Verifying RDP value for feed ad  call  when user selecting Optoutmode scenario in privacy card started =========================");				
	      Functions.validate_RDP_feed_Optoutmode();
		  System.out.println("================= Verifying RDP value for feed ad call when user selecting Optoutmode scenario in privacy card End =========================");
		}
	 

	 @Test(priority = 58, enabled = true)
		@Title("Verifying RDP  value for detailed feed ad call when user selecting Optoutmode scenario in privacy card")
		public void Smoke_Test_Verifying_RDP_value_detailed_feedad_Optoutmode_scenario() throws Exception {
		
		 System.out.println("================= Verifying RDP value for detailed feed ad  call  when user selecting Optoutmode scenario in privacy card started =========================");				
	      Functions.validate_RDP_detailed_feed_Optoutmode();
		  System.out.println("================= Verifying RDP value for detailed feed ad call when user selecting Optoutmode scenario in privacy card End =========================");
		}
	 
	 @Test(priority = 59, enabled = true)
		@Title("Verifying RDP  value forvideo  ad call when user selecting Optoutmode scenario in privacy card")
		public void Smoke_Test_Verifying_RDP_value_video_adcall_Optoutmode_scenario() throws Exception {
		
		 System.out.println("================= Verifying RDP value for video  ad call  when user selecting Optoutmode scenario in privacy card started =========================");				
	      Functions.validate_RDP_video_ad_Optoutmode();
		  System.out.println("================= Verifying RDP value for video ad call when user selecting Optoutmode scenario in privacy card End =========================");
		}*/
	 
	 
	 
	 
	 
	 
	 
	 

	/* @Test(priority = 74, enabled = true)
		@Title("Verifying RDP  value for home screen call when user selecting Optinmode scenario in privacy card")
		public void Smoke_Test_Verifying_RDP_value_homescreenad_Optinmode_scenario() throws Exception {
		
		 System.out.println("================= Verifying RDP value for home screen call  when user selecting Optinmode scenario in privacy card started =========================");				
	      Functions.validate_RDP_homescreen_Optinmode();
		  System.out.println("================= Verifying RDP value for home screen call when user selecting Optinmode scenario in privacy card End =========================");
		}
	 
	 @Test(priority = 75, enabled = true)
		@Title("Verifying RDP  value for feed ad call when user selecting Optinmode scenario in privacy card")
		public void Smoke_Test_Verifying_RDP_value_feedad_Optinmode_scenario() throws Exception {
		
		 System.out.println("================= Verifying RDP value for feed ad  call  when user selecting Optinmode scenario in privacy card started =========================");				
	      Functions.validate_RDP_feed_Optinmode();
		  System.out.println("================= Verifying RDP value for feed ad call when user selecting Optinmode scenario in privacy card End =========================");
		}
	 

	 @Test(priority = 76, enabled = true)
		@Title("Verifying RDP  value for detailed feed ad call when user selecting Optinmode scenario in privacy card")
		public void Smoke_Test_Verifying_RDP_value_detailed_feedad_Optinmode_scenario() throws Exception {
		
		 System.out.println("================= Verifying RDP value for detailed feed ad  call  when user selecting Optinmode scenario in privacy card started =========================");				
	      Functions.validate_RDP_detailed_feed_Optinmode();
		  System.out.println("================= Verifying RDP value for detailed feed ad call when user selecting Optinmode scenario in privacy card End =========================");
		}
	 
	 @Test(priority = 77, enabled = true)
		@Title("Verifying RDP  value forvideo  ad call when user selecting Optinmode scenario in privacy card")
		public void Smoke_Test_Verifying_RDP_value_video_adcall_Optinmode_scenario() throws Exception {
		
		 System.out.println("================= Verifying RDP value for video  ad call  when user selecting Optinmode scenario in privacy card started =========================");				
	      Functions.validate_RDP_video_ad_Optinmode();
		  System.out.println("================= Verifying RDP value for video ad call when user selecting Optinmode scenario in privacy card End =========================");
		}*/
	 
	 
	  /* @Test(priority = 78, enabled = true)
		@Title("Verifying  home screen hourly call pull to refrersh scenario")
		public void Smoke_Test_Verifying_homescreenhourly__pulltoreresh_scenario() throws Exception {
		
		 System.out.println("================= Verifying  home screen hourly call pull to refrersh scenario started =========================");						
		 CharlesFunctions.ClearSessions(); 
		 CharlesFunctions.startSessionBrowserData();
		 AppFunctions.Kill_Launch_App();	 	 
		 //AppFunctions.Pull_To_Refresh("Pulltorefresh");
		 CharlesFunctions.ExportSession_feed();
		 Functions.finding_Homescreen_iu_value();
		 
		 System.out.println("================= Verifying  home screen hourly call pull to refrersh scenario started End =========================");
		}
	 
	   @Test(priority = 79, enabled = true)
		@Title("Verifying  home screen hourly call pull to refrersh scenario")
		public void Smoke_Test_Verifying_homescreenmarquee__pulltoreresh_scenario() throws Exception {
		
		 System.out.println("================= Verifying  home screen marquee call pull to refrersh scenario started =========================");				
		 Functions.finding_Homescreen_marquee_iu_value();
		 System.out.println("================= Verifying  home screen marquee call pull to refrersh scenario started End =========================");
		
	   }
	   @Test(priority = 80, enabled = true)
		@Title("Verifying  home screen hourly call kill launch scenario")
		public void Smoke_Test_Verifying_homescreenhourly__killlaunch_scenario() throws Exception {
		
		 System.out.println("================= Verifying  home screen hourly call kill and launch scenario started =========================");						
		 CharlesFunctions.ClearSessions();
		 CharlesFunctions.startSessionBrowserData();
		 AppFunctions.Kill_Launch_App();	
		 //CharlesFunctions.startSessionBrowserData();
		 Functions.finding_Homescreen_iu_value();
		 
		 System.out.println("================= Verifying  home screen hourly call kill and launch  scenario  End =========================");
		}
	 
	   @Test(priority = 81, enabled = true)
		@Title("Verifying  home screen hourly call kil and launch  scenario")
		public void Smoke_Test_Verifying_homescreenmarquee__killlaunch_scenario() throws Exception {
		
		 System.out.println("================= Verifying  home screen marquee call kill and launch  scenario started =========================");				
		 Functions.finding_Homescreen_marquee_iu_value();
		 System.out.println("================= Verifying  home screen marquee call kill and launch scenario  End =========================");
		
	   }
	   
	   @Test(priority = 82, enabled = true)
		@Title("Verifying  home screen hourly call back from detailes page  scenario")
		public void Smoke_Test_Verifying_homescreenhourly__backfromdetailedpage_scenario() throws Exception {
		
		 System.out.println("================= Verifying  home screen hourly call back from detailes page scenario  started =========================");						
		 CharlesFunctions.ClearSessions(); 
		 AppFunctions.Kill_Launch_App();	 
		 CharlesFunctions.startSessionBrowserData();
		 Functions.scrollapp_maps();
		 Functions.click_Mapsdetails_element();		
		 Functions.clickonBackbutton();
		 CharlesFunctions.ExportSession_feed();
		 Functions.finding_Homescreen_iu_value();
		 
		 System.out.println("================= Verifying  home screen hourly back from detailes page scenario End =========================");
		}
	 
	   @Test(priority = 83, enabled = true)
		@Title("Verifying  home screen marquee callbackfromdetailedpage scenario")
		public void Smoke_Test_Verifying_homescreenmarquee_backfromdetailedpage__scenario() throws Exception {
		
		 System.out.println("================= Verifying  home screen marquee call  back from detailes page scenario  started =========================");				
		 Functions.finding_Homescreen_marquee_iu_value();
		 Functions.Swipe_Conter(3);
		 System.out.println("================= Verifying  home screen marquee call  back from detailes page scenario  End =========================");
		
	   }*/
	/* @Test(priority = 66, enabled = true)
		@Title("Verifying SOD Cust param value for home screen call when user selecting Optinmode scenario in privacy card")
		public void Smoke_Test_Verifying_SOD_Cust_Param_homescreenad_Optinmode_scenario() throws Exception {

			
		 System.out.println("================= Verifying SOD CUST_PARAM value for home screen call  when user selecting Optinmode scenario in privacy card started =========================");				
	      Functions.validate_SOD_Cust_param_homescreen_Optinmode();
		  System.out.println("================= Verifying SOD CUST_PARAM value for home screen call when user selecting Opttinmode scenario in privacy card End =========================");
		}
	 
	 @Test(priority = 67, enabled = true)
		@Title("Verifying SOD Cust param value for  Feed ad call when user selecting Optinmode scenario in privacy card")
		public void Smoke_Test_Verifying_SOD_Cust_Param_Feedad_Optinmode_scenario() throws Exception {

			
		 System.out.println("================= Verifying SOD CUST_PARAM value for Feed ad call  when user selecting Optinmode scenario in privacy card started =========================");				
	      Functions.validate_SOD_Cust_param_feed_Optinmode();
		  System.out.println("================= Verifying SOD CUST_PARAM value for Feed ad call  when user selecting Optinmode scenario in privacy card End =========================");
		}
	
	 
	 @Test(priority = 68, enabled = true)
		@Title("Verifying SOD Cust param value for detail Feed ad call when user selecting Optinmode scenario in privacy card")
		public void Smoke_Test_Verifying_SOD_Cust_Param_detail_Feedad_Optinmode_scenario() throws Exception {			
		 System.out.println("================= Verifying SOD CUST_PARAM value for  detailed Feed ad call  when user selecting Optinmode scenario in privacy card started =========================");				
	      Functions.validate_SOD_Cust_param_deatiledfeed_Optinmode();
		  System.out.println("================= Verifying SOD CUST_PARAM value for  detailed Feed ad call  when user selecting Optinmode scenario in privacy card End =========================");
		}
	
	 @Test(priority = 69, enabled = true)
		@Title("Verifying SOD Cust param value for video call when user selecting Optinmode scenario in privacy card")
		public void Smoke_Test_Verifying_SOD_Cust_Param_videoad_Optinmode_scenario() throws Exception {
			
		 System.out.println("================= Verifying SOD CUST_PARAM value for video ad call  when user selecting Optinmode scenario in privacy card started =========================");				
	      Functions.validate_SOD_Cust_param_video_Optinmode();
		  System.out.println("================= Verifying SOD CUST_PARAM value for video ad call  when user selecting Optinmode scenario in privacy card End =========================");
		}*/
	 /* @Test(priority=74,enabled = true)
	   @Title("Verifying iu value for daily card ad call iu") public void
	  Smoke_Test_Verify_daily_card_adcall_iu() throws Exception { System.out.
	  println("================= Verifyig daily adcall_iu Started =========================");
	   //AppFunctions.enter_nextgenIm_ad_location();
	
	  CharlesFunctions.ClearSessions();
	  CharlesFunctions.startSessionBrowserData();
	  CharlesFunctions.ExportSession();
	  Functions.Verify_dailycard_iu(); System.out.
	 println("================= Verify_daily_card_adcall_iu End =========================");
	   }
	 
	 @Test(priority=75,enabled = true)	  
	 @Title("Verifying daily IF ad card call response") public void
	  Smoke_Test_verifying_DailyIFcardResponse() throws Exception { 
		  
		  System.out.println("================= Verify  Daily IF card response testcase started =========================" );
	 Functions.dailyIFCard_adcall_response(); 
	 System.out.println("================= Verify  Daily IF card response testcase End =========================");
	  
	  }
	  
	  @Test(priority=76,enabled = true)	  
	  @Title("Verifying the response for Daily IF card") public void
	 Smoke_Test_verifying_FG_BG_urls_DailyIF_Card() throws Exception { 
		  System.out.println("================= Verify  Nextgen Im adunit response testcase started =========================");
	 Functions.validate_FG_BG_adcalls_DailyIFcards(); 
	 System.out.println("================= Verify  Nextgen Im adunit response testcase End ========================="); 
	}
	  
	  @Test(priority=77,enabled = true)	  
	  @Title("Verifying the Size for Daily  ad call") public void
	  Smoke_Test_verifying_Size_DailyIFCard() throws Exception { 
		  System.out.println("================= Verify  Nextgen Im adunit response testcase started =========================");
	   Functions.validate_Size_DailyIFCard(); 
	   System.out.println("================= Verify  Nextgen Im adunit response testcase End =========================" );
	  }*/
	 
	
	/* * @Test(priority=1,enabled = true)
	 * 
	 * @Title("Verifying amazon aax home screen today preload ad call") public void
	 * Smoke_Test_amazon_aax_home_screen_today_preload_adcall__iu() throws Exception
	 * { System.out.
	 * println("================= Verify amazon aax home screentoday preload adcall Started ========================="
	 * ); //AppFunctions.Pull_To_Refresh("Pulltorefresh");
	 * CharlesFunctions.startSessionBrowserData(); CharlesFunctions.ExportSession();
	 * Functions. get_aaxcal_homescreen_today(); System.out.
	 * println("================= Verify amazon aax home screentoday preload adcall End ========================="
	 * ); }
	 * 
	 * @Test(priority=2,enabled = true)
	 * 
	 * @Title("Verifying amazon aax home screen today preload ad call") public void
	 * Smoke_Test_amazon_aax_rader_card_preload_adcall() throws Exception {
	 * System.out.
	 * println("================= Verify amazon aax radar card preload adcall Started ========================="
	 * ); Functions.get_aaxcal_radar(); System.out.
	 * println("================= Verify amazon aax radar card preload adcall End ========================="
	 * ); }
	 * 
	 * @Test(priority=3,enabled = true)
	 * 
	 * @Title("Verifying amazon aax Air Quality preload ad call") public void
	 * Smoke_Test_amazon_aax_AQ_card_preload_adcall() throws Exception { System.out.
	 * println("================= Verify amazon aax AQ card preload adcall Started ========================="
	 * ); Functions.get_aaxcal_AirQuality(); System.out.
	 * println("================= Verify amazon aax AQ card preload adcall End ========================="
	 * ); }
	 * 
	 * @Test(priority=4,enabled = true)
	 * 
	 * @Title("Verifying amazon aax Hourly  preload ad call") public void
	 * Smoke_Test_amazon_aax_Hourly_preload_adcall() throws Exception { System.out.
	 * println("================= Verify amazon aax Hourly card preload adcall Started ========================="
	 * ); Functions.get_aaxcal_Hourly(); System.out.
	 * println("================= Verify amazon aax Hourly card preload adcall End ========================="
	 * ); }
	 * 
	 * @Test(priority=5,enabled = true)
	 * 
	 * @Title("Verifying amazon aax daily preload ad call") public void
	 * Smoke_Test_amazon_aax_Daily_preload_adcall() throws Exception { System.out.
	 * println("================= Verify amazon aax Daily card preload adcall Started ========================="
	 * ); Functions.get_aaxcal_Daily(); System.out.
	 * println("================= Verify amazon aax Daily card preload adcall End ========================="
	 * ); }
	 * 
	 * @Test(priority=6,enabled = true)
	 * 
	 * @Title("Verifying amazon aax maps preload ad call") public void
	 * Smoke_Test_amazon_aax_mapsdetails_preload_adcall() throws Exception {
	 * System.out.
	 * println("================= Verify amazon aax Maps card preload adcall Started ========================="
	 * ); Functions.get_aaxcal_map_details(); System.out.
	 * println("================= Verify amazon aax Maps card preload adcall End ========================="
	 * ); }
	 * 
	 * @Test(priority=7,enabled = true)
	 * 
	 * @Title("Verifying iu value for Home screen") public void
	 * Smoke_Test_CaseVerify_Homescreen_ad_iu() throws Exception { System.out.
	 * println("================= verifying iu value for health_and_activitiescard_iu started ========================="
	 * ); Functions.finding_Homescreen_iu_value(); System.out.
	 * println("================= verifying iu value for health_and_activitiescard__iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=8,enabled = true)
	 * 
	 * @Title("Verifying wfxtg triggere call url") public void
	 * Smoke_Test_CaseVerify_WeatherFXAPI_url() throws Exception { System.out.
	 * println("================= Verifying WeatherFX API url started ========================="
	 * ); Functions.validating_WeatherFXAPI(); System.out.
	 * println("================= Verifying WeatherFX API url End ========================="
	 * ); }
	 * 
	 * @Test(priority=9,enabled = true)
	 * 
	 * @Title("Verifying api weather call url") public void
	 * Smoke_Test_CaseVerify_turbo_url() throws Exception { System.out.
	 * println("================= Verifying Turbo call  API url started ========================="
	 * ); Functions.validating_turbocallAPI(); System.out.
	 * println("================= Verifying Turbo call API url End ========================="
	 * ); }
	 * 
	 * @Test(priority=10,enabled = true)
	 * 
	 * @Title("Verifying Lotame ad.crwdcntrl.net url") public void
	 * Smoke_Test_CaseVerify_adcrwdcntrlnet_url() throws Exception { System.out.
	 * println("================= Verifying Lotame ad.crwdcntrl.net url started ========================="
	 * ); Functions.validating_adcrw(); System.out.
	 * println("================= Verifying Lotame ad.crwdcntrl.net url End ========================="
	 * ); }
	 * 
	 * @Test(priority=11,enabled = true)
	 * 
	 * @Title("Verifying Video ad call") public void
	 * Smoke_Test_Case_Verify_Video_adCalll() throws Exception { System.out.
	 * println("================= Verifying Video ad call testcase  started ========================="
	 * ); CharlesFunctions.clearSessionBrowserData();
	 * CharlesFunctions.startSessionBrowserData();
	 * AppiumFunctions.clickOnUnderstandbutton(); // AppFunctions.Kill_Launch_App();
	 * AppiumFunctions.Kill_launch(); AppiumFunctions.clickOnUnderstandbutton();
	 * //AppiumFunctions.Kill_launch(); Thread.sleep(10000);
	 * AppiumFunctions.SwipeUp_Counter(3);
	 * AppiumFunctions.click_hurricane_element();
	 * AppiumFunctions.clickOnBackArrowElement();
	 * AppiumFunctions.SwipeUp_Counter(1); AppiumFunctions.clickOnRadarMaps();
	 * AppiumFunctions.clickOnBackArrowElement();
	 * AppiumFunctions.SwipeUp_Counter(1);
	 * AppiumFunctions.click_Todaydetails_element();
	 * AppiumFunctions.clickOnBackArrowElement();
	 * AppiumFunctions.SwipeUp_Counter(1); AppiumFunctions.clickOnVideoElement();
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
	 * AppiumFunctions.SwipeUp_Counter(2);
	 * AppiumFunctions.click_Airpollution_element();
	 * AppiumFunctions.clickOnBackArrowElement();
	 * AppiumFunctions.SwipeUp_Counter(1); AppiumFunctions.click_news_element();
	 * AppiumFunctions.clickOnBackArrowElement();
	 * AppiumFunctions.click_hourly_element(); CharlesFunctions.ExportSession();
	 * Functions.finding_VideoCard_iu_value(); System.out.
	 * println("================= Verifying Video ad call testcase End ========================="
	 * ); }
	 * 
	 * @Test(priority=12,enabled = true)
	 * 
	 * @Title("Verifying iu value for Radar&Maps feed card ") public void
	 * Smoke_Test_CaseVerify_Radar_Maps_feedcard_adcall() throws Exception {
	 * System.out.
	 * println("================= verifying iu value for Radar&Maps feed card started ========================="
	 * ); Functions.finding_Radar_Map_feedcard_iu_value(); System.out.
	 * println("================= verifying iu value for Radar&Maps feed card  End ========================="
	 * ); }
	 * 
	 * @Test(priority=13,enabled = true)
	 * 
	 * @Title("Verifying iu value for Radar&Maps details card") public void
	 * Smoke_Test_CaseVerify_Radar_Maps_deatailscard_adcall() throws Exception {
	 * System.out.
	 * println("================= verifying iu value for Radar&Maps deatail card started ========================="
	 * ); Functions.finding_Radar_Map_card_iu_value(); System.out.
	 * println("================= verifying iu value for Radar&Maps deatail card  End ========================="
	 * ); }
	 */

	/*
	 * @Test(priority=14,enabled = true)
	 * 
	 * @Title("Verifying iu value Today details Page ") public void
	 * Smoke_Test_CaseVerify_Today_details_page_iu() throws Exception { System.out.
	 * println("================= verifying iu value for Today_details_page_iu started ========================="
	 * ); Functions.finding_Today_detail_page_iu_value(); System.out.
	 * println("================= verifying iu value for Today_details_page_iu End ========================="
	 * ); }
	 */

	/*
	 * @Test(priority=15,enabled = true)
	 * 
	 * @Title("Verifying amazon aax for today details card") public void
	 * Smoke_Test_amazon_aax_today_deatailcard() throws Exception { System.out.
	 * println("================= Verify amazon aax for today detail adcard Started ========================="
	 * ); Functions.get_aaxcal_today_details(); System.out.
	 * println("================= Verify amazon aax for today detail adcard End========================="
	 * ); }
	 * 
	 * @Test(priority=16,enabled = true)
	 * 
	 * @Title("Verifying iu value Health&Activities feed card ") public void
	 * Smoke_Test_CaseVerify_Health_Activities_feed_adcall() throws Exception {
	 * System.out.
	 * println("================= verifying iu value Health&Activities feed card started ========================="
	 * ); Functions.finding_H_C_adcalL_iu(); System.out.
	 * println("================= verifying iu value Health&Activities feed card End ========================="
	 * ); }
	 * 
	 * @Test(priority=17,enabled = true) public void
	 * Smoke_Test_Verify_health_and_activities_Running_spotlight_adcall_iu() throws
	 * Exception { System.out.
	 * println("================= Verify_health_and_activities_Running_spotlight_adcall_iu Started ========================="
	 * ); Functions. health_and_activities_Running_spotlight_adcall_iu();
	 * System.out.
	 * println("================= Verify_health_and_activities_Running_spotlight_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=18,enabled = true)
	 * 
	 * @Title("Verifying iu value for health and activities Bot&beach Spotlight ad call iu"
	 * ) public void
	 * Smoke_Test_Verify_health_and_activities_Bot_beach_detailpage_adcall_iu()
	 * throws Exception { System.out.
	 * println("================= Verify_health_and_activities_Bot&beach_Spotlight_adcall_iu Started ========================="
	 * ); Functions.health_and_activities_Boat_beach_detailpage_adcall_iu();
	 * System.out.
	 * println("================= Verify_health_and_activities_Bot&beach_Spotlight_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=19,enabled = true)
	 * 
	 * @Title("Verifying iu value for health and activities Allergy Spot light ad call iu"
	 * ) public void
	 * Smoke_Test_Verify_health_and_activities_Allergy_detailpage_adcall_iu() throws
	 * Exception { System.out.
	 * println("================= Verify_health_and_activities_Allergy_Spotlight_adcall_iu Started ========================="
	 * ); Functions.health_and_activities_Allergy_detailpage_adcall_iu();
	 * System.out.
	 * println("================= Verify_health_and_activities_Allergy_Spotlight_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=20,enabled = true)
	 * 
	 * @Title("Verifying iu value for health and activities cold&Flu Spotlight ad call iu"
	 * ) public void
	 * Smoke_Test_Verify_health_and_activities_cold_flu_Spotlight_adcall_iu() throws
	 * Exception { System.out.
	 * println("================= Verify_health_and_activities_cold_flu_Spotlight_adcall_iu Started ========================="
	 * ); Functions.health_and_activities_Cold_Flu_detailpage_adcall_iu();
	 * System.out.
	 * println("================= Verify_health_and_activities_cold_flu_Spotlight_adcall_iu End ========================="
	 * ); }
	 */
	/*
	 * @Test(priority=21,enabled = true)
	 * 
	 * @Title("Verifying amazon axx slot for cold&flu Bigbanner ad") public void
	 * Smoke_Test_Verify_amazon_aax_cold_flu_Bigbanner_ad() throws Exception {
	 * System.out.
	 * println("================= verifying amazon aax slot for cold&flu BigBanner adcall started ========================="
	 * ); Functions.get_aaxcal_Cold_Flu_Bigbanner(); System.out.
	 * println("================= verifying amazon aax slot for cold&flu BigBanner adcall  End ========================="
	 * ); }
	 * 
	 * @Test(priority=22,enabled = true)
	 * 
	 * @Title("Verifying amazon axx slot for Allergy Bigbanner ad") public void
	 * Smoke_Test_Verify_amazon_aax_Allergy_Bigbanner_ad() throws Exception {
	 * System.out.
	 * println("================= verifying amazon aax slot for Allergy BigBanner adcall started ========================="
	 * ); Functions.get_aaxcal_Allergy_Bigbanner(); System.out.
	 * println("================= verifying amazon aax slot for Allergy BigBanner adcall  End ========================="
	 * ); }
	 */
	/*
	 * @Test(priority=23,enabled = true)
	 * 
	 * @Title("Verifying amazon axx slot for Running Bigbanner ad") public void
	 * Smoke_Test_Verify_amazon_aax_Running_Bigbanner_ad() throws Exception {
	 * System.out.
	 * println("================= verifying amazon aax slot for Running BigBanner adcall started ========================="
	 * ); Functions.get_aaxcal_Running_Bigbanner(); System.out.
	 * println("================= verifying amazon aax slot for Running BigBanner adcall  End ========================="
	 * ); }
	 */
	/*
	 * @Test(priority=24,enabled = true)
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
	 * @Test(priority=25,enabled = true)
	 * 
	 * @Title("Verifying iu value seasonal hub  feed card ") public void
	 * Smoke_Test_CaseVerify_seasonalhub_feed_adcall() throws Exception {
	 * System.out.
	 * println("================= verifying iu value SeasonalHub feed card started ========================="
	 * ); Functions.finding_Seasonalhub_adcalL_iu(); System.out.
	 * println("================= verifying iu value SeasonalHub feed card End ========================="
	 * ); }
	 * 
	 * @Test(priority=26,enabled = true)
	 * 
	 * @Title("Verifying iu value for  Air Quality detailpage ad call iu") public
	 * void
	 * Smoke_Test_Verify_health_and_activities_Air_Quality_detailpage_adcall_iu()
	 * throws Exception { System.out.
	 * println("================= Verify_health_and_activities_AirQuality_detailpage_adcall_iu Started ========================="
	 * ); Functions.health_and_activities_AirQuality_detailpage_adcall_iu();
	 * System.out.
	 * println("================= Verify_health_and_activities_AirQuality_detailpage_adcall_iu End ========================="
	 * ); }
	 */
	/*
	 * @Test(priority=27,enabled = true)
	 * 
	 * @Title("Verifying amazon axx slot for Boat&Beach Bigbanner ad") public void
	 * Smoke_Test_Verify_amazon_aax_AirQuality_adcall() throws Exception {
	 * System.out.
	 * println("================= verifying amazon aax slot for Boat&Beach BigBanner adcall started ========================="
	 * ); Functions.get_aaxcal_AQ(); System.out.
	 * println("================= verifying amazon aax slot for Boat&Beach BigBanner adcall  End ========================="
	 * ); }
	 */
	/*
	 * @Test(priority=28,enabled = true)
	 * 
	 * @Title("Verifying iu value for news detailpage ad call iu") public void
	 * Smoke_Test_Verify_News_detailpage_adcall_iu() throws Exception { System.out.
	 * println("================= Verify_News_detailpage_adcall_iu Started ========================="
	 * ); Functions.Verify_News_detailpage_adcall_iu(); System.out.
	 * println("================= Verify_News_detailpage_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=29,enabled = true)
	 * 
	 * @Title("Verifying iu value for news detailpage ad call iu") public void
	 * Smoke_Test_Verify_News_hurricane_detail_adcall_iu() throws Exception {
	 * System.out.
	 * println("================= Verify_hurricane_detailpage_adcall_iu Started ========================="
	 * ); Functions.Verify_Hurricane_detailpage_adcall_iu(); System.out.
	 * println("================= Verify_hurricane_detailpage_adcall_iu End ========================="
	 * ); } /*@Test(priority=29,enabled = true)
	 * 
	 * @Title("Verifying amazon axx slot for Boat&Beach Bigbanner ad") public void
	 * Smoke_Test_Verify_amazon_aax_News_adcall() throws Exception { System.out.
	 * println("================= verifying amazon aax slot for news adcall started ========================="
	 * ); Functions.get_aaxcal_news(); System.out.
	 * println("================= verifying amazon aax slot for Boat&Beach BigBanner adcall  End ========================="
	 * ); }
	 */
	/*
	 * @Test(priority=30,enabled = true)
	 * 
	 * @Title("Verifying iu value for daily card ad call iu") public void
	 * Smoke_Test_Verify_daily_card_adcall_iu() throws Exception { System.out.
	 * println("================= Verifyig daily adcall_iu Started ========================="
	 * ); Functions. Verify_dailycard_iu(); System.out.
	 * println("================= Verify_daily_card_adcall_iu End ========================="
	 * ); }
	 */

	/*
	 * @Test(priority=31,enabled = true)
	 * 
	 * @Title("Verifying AQ aax call") public void
	 * Smoke_Test_CaseVerify_AQ_aax_amazon_adcalll() throws Exception { System.out.
	 * println("================= Verifying amazon AQ aax call  started ========================="
	 * ); Functions.get_aaxcal_AQ(); System.out.
	 * println("================= Verifying amazon AQ aax call End ========================="
	 * ); }
	 * 
	 * @Test(priority=32,enabled = true)
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
	 * @Test(priority=33,enabled = true)
	 * 
	 * @Title("Verifying ysoriu value for news detailpage ad call iu") public void
	 * Smoke_Test_Verify_hourly_detailpage_adcall_iu() throws Exception {
	 * System.out.
	 * println("================= Verify_hourly_detailpage_adcall_iu Started ========================="
	 * ); Functions.Verify_hourly_detailpage_adcall_iu(); System.out.
	 * println("================= Verify_hourly_detailpage_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=34,enabled = true)
	 * 
	 * @Title("Verifying news aax call") public void
	 * Smoke_Test_CaseVerify_hurricane_detal_aax_adcalll() throws Exception {
	 * System.out.
	 * println("================= Verifying amazon hurricane details aax call  started ========================="
	 * ); Functions.get_aaxcal_hurricanedetails(); System.out.
	 * println("================= Verifying amazon hurricane details aax call End ========================="
	 * ); }
	 * 
	 * @Test(priority=100,enabled = true)
	 * 
	 * @Title("Verifying iu value for snapshot ad call iu") public void
	 * Smoke_Test_Verify_snapshotcard_adcall_iu() throws Exception { System.out.
	 * println("================= Verify_snapshotcard_adcall_iu Started ========================="
	 * );
	 * 
	 * CharlesFunctions.ClearSessions(); AppiumFunctions.Kill_launch();
	 * CharlesFunctions.startSessionBrowserData();
	 * AppiumFunctions.click_snapShot_button(); CharlesFunctions.ExportSession();
	 * Functions.Verify_snapshot_spotlight_adcard_iu(); System.out.
	 * println("================= Verify_snapshotcard_adcall_iu End ========================="
	 * ); }
	 * 
	 * @Test(priority=101,enabled = true)
	 * 
	 * @Title("Verifying iu value for snapshot ad call iu") public void
	 * Smoke_Test_Verify_snapshot_spotlight_adcall_iu() throws Exception {
	 * System.out.
	 * println("================= Verify_snapshot_spotlight_adcall_iu Started ========================="
	 * ); Functions.Verify_snapshot_spotlight_iu(); System.out.
	 * println("================= Verify_snapshot_spotlight_adcall_iu End ========================="
	 * ); }
	 */

	/*
	 * @Test(priority=1,enabled = true)
	 * 
	 * @Title("Verifying iu value for snapshot ad call iu") public void
	 * Smoke_Test_Verify_snapshot_spotlight_adcall_iu() throws Exception {
	 * System.out.
	 * println("================= Verify_snapshot_spotlight_adcall_iu Started ========================="
	 * ); Functions.Verify_snapshot_spotlight_iu(); System.out.
	 * println("================= Verify_snapshot_spotlight_adcall_iu End ========================="
	 * ); }
	 */
	  /* @Test(priority=1)
	   @Title("Verifying iu value for seasonal hub  detailpage ad call iu") 
	   public void Smoke_Test_Verify_SeasonalHub_detailpage_adcall_iu() throws Exception {
		
		 System.out.println("================= Verify_SH_detailpage_adcall_iu Started =========================");
		 // Functions.testmode_settings(); 
		 Functions.clickAelrts();
		  System.out.println("================= Verify_SH_detailpage_adcall_iu End =========================");
		 
		  } */
	   
	   
	   

	   
	   
	   
	 /*@Test(priority=1,enabled=true)
	   @Title("Verifying new daily details big ad for day1") 
	   public void Smoke_Test_Verify_newDailydetailsBigad_tonight_day1() throws Exception {		
		 System.out.println("================= Verifying new daily details bid ad for day1 Started =========================");
		 Functions.clickbranch();
		 Functions.enablenewdetailBigad();
		 AppFunctions.Kill_Launch_App();
		 Functions.clickbranch();
		 Functions.enablenewdetailBigad();
		Ad.runAppInBackground(10);
		// Functions.enablenewdetailBigad();
		AppiumFunctions.Kill_launch();
		AppiumFunctions.Kill_launch();
		Thread.sleep(3000);
		CharlesFunctions.ClearSessions();
		Thread.sleep(3000);
		AppFunctions.Kill_Launch_App();
		Functions.clickdailydetails();
		Functions.clickeachday();
		CharlesFunctions.ExportSessions();
		try {
		Functions. finding_newDailyBidadcall_day1();
		}
		catch(Exception e) {
			AppFunctions.Kill_Launch_App();
			CharlesFunctions.ClearSessions();
			Functions.clickdailydetails();
			Functions.clickeachday();
		}
	    System.out.println("================= Verifying new daily details bid ad for day1 End ========================="); 
	    }
	   
	   @Test(priority=2,enabled=true)
	   @Title("Verifying new daily details big ad for day2") 
	   public void Smoke_Test_Verify_newDailydetailsBigad_day2() throws Exception {		
		 System.out.println("================= Verifying new daily details bid ad for day2 Started =========================");
		Functions.finding_newDailyBidadcall_day2();
	    System.out.println("================= Verifying new daily details bid ad for day2 End ========================="); 
	    }
	  
	   @Test(priority=3,enabled=true)
	   @Title("Verifying new daily details big ad for day3") 
	   public void Smoke_Test_Verify_newDailydetailsBigad_day3() throws Exception {		
		 System.out.println("================= Verifying new daily details bid ad for day3 Started =========================");
		Functions.finding_newDailyBidadcall_day3();
	    System.out.println("================= Verifying new daily details bid ad for day3 End ========================="); 
	    }
	   @Test(priority=4,enabled=true)
	   @Title("Verifying new daily details big ad for day4") 
	   public void Smoke_Test_Verify_newDailydetailsBigad_day4() throws Exception {		
		 System.out.println("================= Verifying new daily details bid ad for day4 Started =========================");
		Functions.finding_newDailyBidadcall_day4();
	    System.out.println("================= Verifying new daily details bid ad for day4 End ========================="); 
	    }
	   
	   @Test(priority=5,enabled=true)
	   @Title("Verifying new daily details big ad for day5") 
	   public void Smoke_Test_Verify_newDailydetailsBigad_day5() throws Exception {		
		 System.out.println("================= Verifying new daily details bid ad for day5 Started =========================");
		Functions.finding_newDailyBidadcall_day5();
	    System.out.println("================= Verifying new daily details bid ad for day5 End ========================="); 
	    }
	   
	   @Test(priority=6,enabled=true)
	   @Title("Verifying new daily details big ad for day6") 
	   public void Smoke_Test_Verify_newDailydetailsBigad_day6() throws Exception {		
		 System.out.println("================= Verifying new daily details bid ad for day6 Started =========================");
		Functions.finding_newDailyBidadcall_day6();
	    System.out.println("================= Verifying new daily details bid ad for day6 End ========================="); 
	    }
	   
	   @Test(priority=7,enabled=true)
	   @Title("Verifying new daily details big ad for day7") 
	   public void Smoke_Test_Verify_newDailydetailsBigad_day7() throws Exception {		
		 System.out.println("================= Verifying new daily details bid ad for day7 Started =========================");
		Functions.finding_newDailyBidadcall_day7();
	    System.out.println("================= Verifying new daily details bid ad for day7 End ========================="); 
	    }
	   
	   @Test(priority=8,enabled=true)
	   @Title("Verifying new daily details big ad for day8") 
	   public void Smoke_Test_Verify_newDailydetailsBigad_day8() throws Exception {		
		 System.out.println("================= Verifying new daily details bid ad for day8 Started =========================");
		Functions.finding_newDailyBidadcall_day8();
	    System.out.println("================= Verifying new daily details bid ad for day8 End ========================="); 
	    }
	   @Test(priority=9,enabled=true)
	   @Title("Verifying new daily details big ad for day9") 
	   public void Smoke_Test_Verify_newDailydetailsBigad_day9() throws Exception {		
		 System.out.println("================= Verifying new daily details bid ad for day9 Started =========================");
		Functions.finding_newDailyBidadcall_day9();
	    System.out.println("================= Verifying new daily details bid ad for day9 End ========================="); 
	    }
	   @Test(priority=10,enabled=true)
	   @Title("Verifying new daily details big ad for day10") 
	   public void Smoke_Test_Verify_newDailydetailsBigad_day10() throws Exception {		
		 System.out.println("================= Verifying new daily details bid ad for day10 Started =========================");
		Functions.finding_newDailyBidadcall_day10();
	    System.out.println("================= Verifying new daily details bid ad for day10 End ========================="); 
	    }
	   
	   @Test(priority=11,enabled=true)
	   @Title("Verifying new daily details big ad for day11") 
	   public void Smoke_Test_Verify_newDailydetailsBigad_day11() throws Exception {		
		 System.out.println("================= Verifying new daily details bid ad for day11 Started =========================");
		Functions.finding_newDailyBidadcall_day11();
	    System.out.println("================= Verifying new daily details bid ad for day11 End ========================="); 
	    }
	   @Test(priority=12,enabled=true)
	   @Title("Verifying new daily details big ad for day12") 
	   public void Smoke_Test_Verify_newDailydetailsBigad_day12() throws Exception {		
		 System.out.println("================= Verifying new daily details bid ad for day12 Started =========================");
		Functions.finding_newDailyBidadcall_day12();
		 System.out.println("================= Verifying new daily details bid ad for day12 End ========================="); 
	   }
	   @Test(priority=13,enabled=true)
	   @Title("Verifying new daily details big ad for day13") 
	   public void Smoke_Test_Verify_newDailydetailsBigad_day13() throws Exception {		
		 System.out.println("================= Verifying new daily details bid ad for day13 Started =========================");
		Functions.finding_newDailyBidadcall_day13();
		 System.out.println("================= Verifying new daily details bid ad for day13 End ========================="); 
	   }
	   @Test(priority=14,enabled=true)
	   @Title("Verifying new daily details big ad for day14") 
	   public void Smoke_Test_Verify_newDailydetailsBigad_day14() throws Exception {		
		 System.out.println("================= Verifying new daily details bid ad for day14 Started =========================");
		Functions.finding_newDailyBidadcall_day14();
		 System.out.println("================= Verifying new daily details bid ad for day14 End ========================="); 
	   }
	   
	   @Test(priority=15,enabled=true)
	   @Title("Verifying new daily details big ad for day15") 
	   public void Smoke_Test_Verify_newDailydetailsBigad_day15() throws Exception {		
		 System.out.println("================= Verifying new daily details bid ad for day15 Started =========================");
		Functions.finding_newDailyBidadcall_day15();
		 System.out.println("================= Verifying new daily details bid ad for day15 End ========================="); 
	   }
	   
	   
	   @Test(priority=16,enabled=true)
	   @Title("Verifying new houly page") 
	   public void Smoke_Test_Verify_newHourlyAd() throws Exception {		
		 System.out.println("================= Verifying new hourly page Started =========================");
		 AppFunctions.Kill_Launch_App();
		 Functions.enable_nghourly();
		 Ad.runAppInBackground(10);
		  AppFunctions.Kill_Launch_App();
		  CharlesFunctions.ClearSessions();
		Functions.clickHourlydetails();
		CharlesFunctions.ExportSessions();
		Functions.Verify_hourly_detailpage_adcall_iu();
		
		System.out.println("================= Verifying new hourly page End =========================");
	   }
	   

		 @Test(priority=500,enabled=true)
		   @Title("Verifying Breaking news alert push notification") 
		   public void Smoke_Test_Verify_Breakingnews_Alert_Pushnotification() throws Exception {	
			 System.out.println("================= Verifying Breaking news alert push notification Started =========================");
			 // Functions.testmode_settings(); 
			 Functions.enablePushalerts();
			 Functions.clickAelrts();
			 Functions.clickbreakingnewsAlert();
			 Functions.swipefornotification();
			 CharlesFunctions.ClearSessions();
			 Functions.clickOnBNnotification();
			 CharlesFunctions.ExportSessions();
		     Functions.finding_BreakingNews_iu_value();
		     Functions.VerifyBNAlert();	
		     Thread.sleep(30000);
		     AppFunctions.Kill_Launch_App();
			 System.out.println("================= Verifying Breaking news alert push notification End =========================");
			  }
		   
		   @Test(priority=502)
		   @Title("Verifying Real time rain alert push notification") 
		   public void Smoke_Test_Verify_Realtimerain_Alert_Pushnotification() throws Exception {
			
			 System.out.println("================= Verifying Real time rain alert push notificationStarted =========================");
			 // Functions.testmode_settings(); 
			Thread.sleep(30000);
			 //AppFunctions.Kill_Launch_App();
			 AppFunctions.resetApp();
			 Thread.sleep(3000);
			// Functions.tapping();
			 Functions.clickAelrts();
			 Functions.clickrealtimerainAlert();
			 Functions.swipefornotification();
			 CharlesFunctions.ClearSessions();	 
			 Functions.clickOnRTRnotification();
			 CharlesFunctions.ExportSessions();
			 Functions.finding_Radar_Map_card_iu_value();
			 Functions.VerifyRTRAlert();	
		     Thread.sleep(30000);
		     AppFunctions.Kill_Launch_App();
			
		System.out.println("================= Verifying Real time rain alert push notification End =========================");
			 
			  } */
		 /*  @Test(priority=503)
		   @Title("Verifying Pollen  alert push notification") 
		   public void Smoke_Test_Verify_Pollen_Alert_Pushnotification() throws Exception {
			 System.out.println("================= Verifying Pollen  alert push notification Started =========================");
			 AppFunctions.Kill_Launch_App();
		//	 Functions.tapping();
			 Functions.clickAelrts();
			 Functions.clickpollenAlert();
			 Functions.swipefornotification();
			 CharlesFunctions.ClearSessions();
			 Functions.clickOnPollennotification();
			 CharlesFunctions.ExportSessions();	
			
			 
			  System.out.println("================= Verifying Pollen  alert push notification End =========================");		 
			  } */
		   
		  /* @Test(priority=504)
		   @Title("Verifying Rain/snow  alert push notification") 
		   public void Smoke_Test_Verify_RainSnow_Alert_Pushnotification() throws Exception {		
			 System.out.println("================= Verifying Rain/snow alert push notification Started =========================");
			 AppFunctions.resetApp();
			// Functions.tapping();
			 Functions.clickAelrts();
			 Functions.clickrainsnowfallAlert();
			 Functions.swipefornotification();
			 CharlesFunctions.ClearSessions();
			 Functions.clickOnRainSnownotification();
			 CharlesFunctions.ExportSessions();
			 Functions.finding_daily_details_card_iu_value();
			 Functions.VerifyRainSnowalert();
		     Thread.sleep(30000);
		     AppFunctions.Kill_Launch_App();
			  System.out.println("================= Verifying Rain/snow  alert push notification End =========================");
			 
			  }
		   
		   @Test(priority=505)
		   @Title("Verifying Heavy rain fall alert push notification") 
		   public void Smoke_Test_Verify_heavyrainfall_Alert_Pushnotification() throws Exception {		
			 System.out.println("================= Verifying heavy rain fall alert push notification Started =========================");
			 AppFunctions.Kill_Launch_App();
			 Functions.tapping();
			 Functions.clickAelrts();
			 Functions.clickheavyrainfallAlert();
			 Functions.swipefornotification();
			 CharlesFunctions.ClearSessions();
			 Functions.clickOnheavyrainfallnotification();
			 CharlesFunctions.ExportSessions();
			 Functions.finding_hourly_details_card_iu_value();
			 Functions.Verifyheavyrainfallalert();
		     Thread.sleep(30000);
		     AppFunctions.Kill_Launch_App();
		  System.out.println("================= Verifying heavy rain fall alert push notification End =========================");
			 
			  }
		   
		   @Test(priority=506)
		   @Title("Verifying Thunderstorm alert push notification") 
		   public void Smoke_Test_Verify_thunderstorm_Alert_Pushnotification() throws Exception {		
			 System.out.println("================= Verifying thunderstorm alert push notification Started =========================");
			 AppFunctions.Kill_Launch_App();
			 Functions.tapping();
			 Functions.clickAelrts();
			 Functions.clickthunderstormAlert();
			 Functions.swipefornotification();
			 CharlesFunctions.ClearSessions();
			 Functions.clickthunderstormalertnotification();
			 CharlesFunctions.ExportSessions();
			 Functions.finding_hourly_details_card_iu_value();
			 Functions.Verifythunderstormalert();
		     Thread.sleep(30000);
		     AppFunctions.Kill_Launch_App();
			  System.out.println("================= Verifying thunderstorm alert push notification End =========================");
			 
			  }
		   
		   @Test(priority=507)
		   @Title("Verifying high heat alert push notification") 
		   public void Smoke_Test_Verify_HighHeat_Alert_Pushnotification() throws Exception {		
			 System.out.println("================= Verifying high heat alert push notification Started =========================");
			 AppFunctions.Kill_Launch_App();
			 Functions.tapping();
			 Functions.clickAelrts();
			 Functions.clickhightheatAlert();
			 Functions.swipefornotification();
			 CharlesFunctions.ClearSessions();
			 Functions.clickhighheatalertnotification();
			 CharlesFunctions.ExportSessions();
			 Functions.finding_daily_details_card_iu_value();
			 Functions.Verifyhighheatalert();
		     Thread.sleep(30000);
		     AppFunctions.Kill_Launch_App();
			  System.out.println("================= Verifying high heat alert push notification End =========================");		 
			  }
		
		   @Test(priority=508)
		   @Title("Verifying high wind alert push notification") 
		   public void Smoke_Test_Verify_HighWind_Alert_Pushnotification() throws Exception {		
			 System.out.println("================= Verifying high wind alert push notification Started =========================");
			 AppFunctions.Kill_Launch_App();
			 Functions.tapping();
			 Functions.clickAelrts();
			 Functions.clickhighwindAlert();
			 Functions.swipefornotification();
			 CharlesFunctions.ClearSessions();
	 		 Functions.clickhighwindalertnotification();
			 CharlesFunctions.ExportSessions();
			 Functions.finding_hourly_details_card_iu_value();
			 Functions.Verifyhighwindalert();
		     Thread.sleep(30000);
		     AppFunctions.Kill_Launch_App();
			  System.out.println("================= Verifying high wind alert push notification End =========================");		 
			  }
		   
		   
		   @Test(priority=509)
		   @Title("Verifying dense fog alert push notification") 
		   public void Smoke_Test_Verify_densefog_Alert_Pushnotification() throws Exception {		
			 System.out.println("================= Verifying dense fog alert push notification Started =========================");
			 AppFunctions.Kill_Launch_App();
			 Functions.tapping();
			 Functions.clickAelrts();
			 Functions.clickdensefogAlert();
			 Functions.swipefornotification();
			 CharlesFunctions.ClearSessions();
			 Functions.clickdensefogalertnotification();
			 CharlesFunctions.ExportSessions();
			 Functions.finding_hourly_details_card_iu_value();
			 Functions.Verifydensefogalert();
		     Thread.sleep(30000);
		     AppFunctions.Kill_Launch_App();
			  System.out.println("================= Verifying dense fog alert push notification End =========================");		 
			  }
		   
		   @Test(priority=510)
		   @Title("Verifying very cold alert push notification") 
		   public void Smoke_Test_Verify_VeryCold_Alert_Pushnotification() throws Exception {		
			 System.out.println("================= Verifying very cold  alert push notification Started =========================");
		
			 AppiumFunctions.Kill_launch();
			 // AppFunctions.Kill_Launch_App();
			 Functions.tapping();
			 Functions.clickAelrts();
			 Functions.clickverycoldlert();
			 Functions.swipefornotification();
			 CharlesFunctions.ClearSessions();
			 Functions.clickverycoldalertnotification();
			 CharlesFunctions.ExportSessions();
			 Functions.finding_daily_details_card_iu_value();
			 Functions.VerifyVerycoldalert();
		     Thread.sleep(30000);
		     AppFunctions.Kill_Launch_App();
			 System.out.println("================= Verifying very cold alert push notification End =========================");		 
			 }
		   
		   @Test(priority=511)
		   @Title("Verifying heavy snowfall alert push notification") 
		   public void Smoke_Test_Verify_heavysnowfall_Alert_Pushnotification() throws Exception {		
			 System.out.println("================= Verifying heavy snowfall alert push notification Started =========================");
			 AppFunctions.Kill_Launch_App();
			 Functions.tapping();
			 Functions.clickAelrts();
			 Functions.clickheavysnowfalllert();;
			 Functions.swipefornotification();
			 CharlesFunctions.ClearSessions();
			 Functions.clickheavysnowfallalertnotification();
			 CharlesFunctions.ExportSessions();
			 Functions.finding_daily_details_card_iu_value();
			 Functions.Verifyheavysnowfallalert();
		     Thread.sleep(30000);
		     AppFunctions.Kill_Launch_App();
			 System.out.println("================= Verifying heavy snowfall alert push notification End =========================");		 
			 }
		   
		   @Test(priority=512)
		   @Title("Verifying ice alert push notification") 
		   public void Smoke_Test_Verify_ice_Alert_Pushnotification() throws Exception {		
			 System.out.println("================= Verifying ice alert push notification Started =========================");
			 AppFunctions.Kill_Launch_App();
			 Functions.tapping();
			 Functions.clickAelrts();
			 AppiumFunctions.SwipeUp_Counter(1);
			 Functions.clickicealert();
			 Functions.swipefornotification();
			 CharlesFunctions.ClearSessions();
			 Functions.clickicealertnotification();
			 CharlesFunctions.ExportSessions();
			 Functions.finding_daily_details_card_iu_value();
			 Functions.Verifyicealert();
		     Thread.sleep(30000);
		     AppFunctions.Kill_Launch_App();
			 System.out.println("================= Verifying ice alert push notification End =========================");		 
			 }
		   
		   @Test(priority=513)
		   @Title("Verifying Severe alert push notification") 
		   public void Smoke_Test_Verify_Severe_Alert_Pushnotification() throws Exception {		
			 System.out.println("================= Verifying Severe alert push notification Started =========================");
			 AppFunctions.Kill_Launch_App();
			 Functions.tapping();
			 Functions.clickAelrts();
			 Functions.clickSevereAlert();
			 Functions.swipefornotification();
			 CharlesFunctions.ClearSessions();
			 Functions.clickseverealertnotification();
			 CharlesFunctions.ExportSessions();
			 Functions.findind_alertsiu_value();
			 Functions.VerifysevereAlert();
		     Thread.sleep(30000);
		     AppFunctions.Kill_Launch_App();
			 System.out.println("================= Verifying Severe alert push notification End =========================");		 
			 }
		
		   @Test(priority=514)
		   @Title("Verifying real time lightning alert push notification") 
		   public void Smoke_Test_Verify_RealtimeLightning_Alert_Pushnotification() throws Exception {		
			 System.out.println("================= Verifying Severe alert push notification Started =========================");
			 AppFunctions.Kill_Launch_App();
			 Functions.tapping();
			 Functions.clickAelrts();
			 Functions.clickrealtimelightningAlert();;
			 Functions.swipefornotification();
			 CharlesFunctions.ClearSessions();
			 Functions.clickRTLalertnotification();
			 CharlesFunctions.ExportSessions();
			 Functions.finding_Radar_Map_card_iu_value();
			 Functions.VerifyRTLAlert();
		     Thread.sleep(30000);
		     AppFunctions.Kill_Launch_App();
			 System.out.println("================= Verifying real time lightning alert push notification End =========================");		 
			 }
		   @Test(priority=515)
		   @Title("Verifying Winter breaking news alert push notification") 
		   public void Smoke_Test_WinterBreakingNews_Alert_Pushnotification() throws Exception {		
			 System.out.println("================= Verifying Winter breaking news alert push notification Started =========================");
			 AppFunctions.Kill_Launch_App();
			 Functions.tapping();
			 Functions.clickAelrts();
			 AppiumFunctions.SwipeUp_Counter(1);
			 Functions.clickwinterbreakingalert();
			 Functions.swipefornotification();
			 CharlesFunctions.ClearSessions();
			 Functions.clickRTLalertnotification();
			 CharlesFunctions.ExportSessions();
			 Functions.finding_BreakingNews_iu_value();
		     Functions.VerifyWBNAlert();
		     Thread.sleep(30000);
		     AppFunctions.Kill_Launch_App();
			 System.out.println("================= Verifying Winter breaking news alert push notification End =========================");		 
			 }
		   @Test(priority=516)
		   @Title("Verifying Flux tomorrow alert push notification") 
		   public void Smoke_Test_FluxTomorrow_Alert_Pushnotification() throws Exception {		
			 System.out.println("================= Verifying Flux tomorrow  alert push notification Started =========================");
			 AppFunctions.Kill_Launch_App();
			 Functions.tapping();
			 Functions.clickAelrts();
			 AppiumFunctions.SwipeUp_Counter(1);
			 Functions.clickfluxtomorrowalert();
			 Functions.swipefornotification();
			 CharlesFunctions.ClearSessions();
			 Functions.clickFluxTomorrowalertnotification();
			 CharlesFunctions.ExportSessions();
			 Functions.finding_Homescreen_iu_value();
		     Functions.VerifyFluxTomorrowAlert();
		     Thread.sleep(30000);
		     AppFunctions.Kill_Launch_App();
			 System.out.println("================= Verifying Flux tomorrow  alert push notification End =========================");		 
			 }
		   @Test(priority=517)
		   @Title("Verifying Flux tonight alert push notification") 
		   public void Smoke_Test_Fluxtonight_Alert_Pushnotification() throws Exception {		
			 System.out.println("================= Verifying Flux tonight  alert push notification Started =========================");
			 AppFunctions.Kill_Launch_App();
			 Functions.tapping();
			 Functions.clickAelrts();
			 AppiumFunctions.SwipeUp_Counter(1);
			 Functions.clickfluxtomorrowalert();
			 Functions.swipefornotification();
			 CharlesFunctions.ClearSessions();
			 Functions.clickFluxTtonightalertnotification();
			 CharlesFunctions.ExportSessions();
			 Functions.finding_Homescreen_iu_value();
		     Functions.VerifyFluxTonightAlert();
		     Thread.sleep(30000);
		     AppFunctions.Kill_Launch_App();
			 System.out.println("================= Verifying Flux tonight  alert push notification End =========================");		 
			 }*/
		   
	   
	   
	   
		  //===================================Interstail ads=======================================
		   
		   
	
	@Test(priority = 1000, enabled = true)
	@Title("Verifying Hoyrly  details Interstal ads")
	public void Smoke_Test_Verify_Hourlydetails_interstial_ads() throws Exception {
		System.out.println(
				"================= Verifying Hourly details Interstal ads test case  Started =========================");
		//Functions.settheTimer();
		Functions.enable_QA_Usergroup();
		AppiumFunctions.Kill_launch();
		AppiumFunctions.Kill_launch();
		Functions.Enable_ResponsiveMode();
		AppiumFunctions.Kill_launch();
		//AppiumFunctions.Kill_launch();
		Functions.clickbranch();
		Functions.enableInterstitialsbranch();
		Ad.runAppInBackground(10);		
		System.out.println("doing the kill launch for 2 times");
		AppiumFunctions.Kill_launch();	
		//AppiumFunctions.Kill_launch();
		CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData();
		Functions.clickHourlydetails();
		Functions.wiatfor5secindetails();
		CharlesFunctions.ExportSessions();
		Functions.Verify_hourly_detailpage_interstitial_adcall();
		Functions.click_home_element();			
		Functions.handleInterstailads();
		Functions.closeInterstailads();
		Functions.settheTimer();
		CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData();
		Functions.clickHourlydetails();
		Functions.wiatfor5secindetails();
		CharlesFunctions.ExportSessions();
		Functions.Verify_hourly_detailpage_interstitial_adcall1();
		Functions.click_home_element();	
		Functions.handleInterstailads();
		Functions.closeInterstailads();
		
	}
				  
	@Title("Verifying daily  details Interstal ads")
	@Test(priority = 1001, enabled = true)
	public void Smoke_Test_Verify_daily_details_interstial_ads() throws Exception {
		System.out.println("================= Verifying daily details Interstal ads test case  Started =========================");
		
		CharlesFunctions.clearSessionBrowserData();
		CharlesFunctions.startSessionBrowserData();
		Functions.clickdailydetails();
		Functions.wiatfor5secindetails();
		CharlesFunctions.ExportSessions();
		Functions.Verify_daily_detailpage_interstitial_adcall();
		Functions.click_home_element();
		Functions.handleInterstailads();
		Functions.closeInterstailads();
		Functions.settheTimer();
		CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData();
		Functions.clickdailydetails();
		Functions.wiatfor5secindetails();
		CharlesFunctions.ExportSessions();
		Functions.Verify_daily_detailpage_interstitial_adcall1();
		Functions.click_home_element();	
		Functions.handleInterstailads();
		Functions.closeInterstailads();
		System.out.println("=================Verifying daily details Interstal ads test case  End =========================");
		}
	
	
	@Title("Verifying maps details Interstal ads")
	@Test(priority = 1002, enabled = true)
	public void Smoke_Test_Verify_radar_details_interstial_ads() throws Exception {
		System.out.println("================= Verifying maps details Interstal ads test case  Started =========================");
		Thread.sleep(5000);
		CharlesFunctions.clearSessionBrowserData();
		CharlesFunctions.startSessionBrowserData();
		Functions.clickmapsdetails();	
		Functions.wiatfor5secindetails();
		CharlesFunctions.ExportSessions();
		Functions.Verify_maps_detailpage_interstitial_adcall();
		Functions.click_home_element();
		Functions.handleInterstailads();
		Functions.closeInterstailads();
		Functions.settheTimer();
		CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData();
		Functions.clickmapsdetails();	
		CharlesFunctions.ExportSessions();
		Functions.Verify_maps_detailpage_interstitial_adcall1();
		Functions.click_home_element();
		Functions.handleInterstailads();
		Functions.closeInterstailads();
		
		
		System.out.println("=================Verifying maps details Interstal ads test case  End =========================");
		}
	   
	@Title("Verifying video details Interstal ads")
	@Test(priority = 1003, enabled = true)
	public void Smoke_Test_Verify_video_details_interstial_ads() throws Exception {
		System.out.println("================= Verifying video details Interstal ads test case  Started =========================");
		
		Thread.sleep(5000);
		Functions.Swipeforappdeckapk();
		CharlesFunctions.clearSessionBrowserData();
		CharlesFunctions.startSessionBrowserData();
		Functions.clickOnVideoElement();
		CharlesFunctions.ExportSessions();
		Functions.Verify_video_detailpage_interstitial_adcall();
		Functions.clickBackButtonAlerts();
		Functions.handleInterstailads();
		Functions.closeInterstailads();
		Functions.settheTimer();
		CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData();
		Functions.clickOnVideoElement();
		Functions.wiatfor5secindetails();
		CharlesFunctions.ExportSessions();
		Functions.Verify_video_detailpage_interstitial_adcall1();
		Functions.clickBackButtonAlerts();
		Functions.handleInterstailads();
		Functions.closeInterstailads();
		System.out.println("=================Verifying video details Interstal ads test case  End =========================");
		}
	   
	
	
	
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   /*@Test(priority=11)
	   @Title("Verifying iu value for seasonal hub  detailpage ad call iu") 
	   public void Smoke_Test_Verify_enable_Pushalerts()throws Exception {
		
		 System.out.println("================= Verify_SH_detailpage_adcall_iu Started =========================");
		  
		  System.out.println("================= Verify_SH_detailpage_adcall_iu End =========================");
		 
		  } 
	   
	   
	   
	   @Title("Verifying iu value for seasonal hub  detailpage ad call iu") 
	   public void Smoke_Test_Verify_SeasonallHub_detailpage_adcall_iu() throws Exception {
		
		 System.out.println("================= Verify_SH_detailpage_adcall_iu Started =========================");
		  Functions.Verify_SH_detailpage_adcall_iu(); 
		  System.out.println("================= Verify_SH_detailpage_adcall_iu End =========================");
		 
		  } 
	   
	   
	   @Title("Verifying iu value for Watson Flu detailpage ad call iu") 
	   public void Smoke_Test_Verify_WatsonFlu_adcall() throws Exception {
		
		 System.out.println("================= Verify_WatsonFlu adcall Started =========================");
		  Functions.finding_watsonFlu_card_iu_value(); 
		  System.out.println("================= Verify_WatsonFlu adcall End =========================");
		 
		  }
	   
	   
	   

 @Test(priority = 551, enabled = true)
	@Title("Verifying Privacy Card is present on the screen")
	public void Smoke_Test_Verify_PrivacyCard_onScreen() throws Exception {
	 AppFunctions.Pull_To_Refresh("Pulltorefresh");
		System.out.println(
				"=================Verifying Privacy Card is present on the screen testcase started =========================");
		Functions.Verify_Privacy_Card_onScreen();
		
		System.out.println(	"================= Verifying Privacy Card is present on the screen testcase End =========================");
	}

	@Test(priority = 42, enabled = true)
	@Title("Selecting the  Opt out mode in the privacy card")
	public void Smoke_Test_Selecting_Opt_out_mode_scenario() throws Exception {

		System.out.println(
				"=================Slecting Opt out mode scenario in privacy card testcase started =========================");
		
		Functions.selecting_opt_out_mode();
		System.out.println(
				"================= Slecting Opt out mode scenario in privacy card  testcase End =========================");
	}
	@Test(priority = 43, enabled = true)
	@Title("Verifying video call when user selecting Optoutmode scenario in privacy card")
	public void Smoke_Test__Smoke_Test_Verifying_videoadcall_Optoutmode_scenario() throws Exception {

		System.out.println(
				"=================Verifying video Feed ad call when user selecting Optoutmode scenario in privacy card started =========================");
		 AppFunctions.Kill_Launch_App();
		 
		CharlesFunctions.startSessionBrowserData();	
		Functions.click_video();
		Functions.scrollapp_maps();
		Functions.click_Mapsdetails_element();		
		CharlesFunctions.ExportSession();
		Functions.Verify_video_ad_call_Optoutmode_();
		System.out.println("================= Verifying video ad call when user selecting Optoutmode scenario in privacy card End =========================");
				
	}

	


	@Test(priority = 44, enabled = true)
	@Title("Verifying Feed ad call when user selecting Optoutmode scenario in privacy card")
	public void Smoke_Test_Verifying_Feedadcall_Optoutmode_scenario() throws Exception {

		System.out.println(
				"=================Verifying Feed ad call when user selecting Optoutmode scenario in privacy card started =========================");
			
		Functions.Verifying_gampadcalls_Optoutmode();
		System.out.println(
				"================= Verifying Feed ad call when user selecting Optoutmode scenario in privacy card End =========================");
	}

	
	@Test(priority = 45, enabled = true)
	@Title("Verifying details page detail page ad call when user selecting Optoutmode scenario in privacy card")
	public void Smoke_Test_Verifying_detailpageadcall_Optoutmode_scenario() throws Exception {

		System.out.println(
				"=================Verifying detail page Feed ad call when user selecting Optoutmode scenario in privacy card started =========================");
		Functions.Verifying_detail_gampadcalls_Optoutmode();
		System.out.println(
				"================= Verifying detail page  Feed ad call when user selecting Optoutmode scenario in privacy card End =========================");
	}

	@Test(priority = 46, enabled = true)
	@Title("Verifying BCP api call when user selecting Optoutmode scenario in privacy card")
	public void Smoke_Test__Verifying_Bcp_apicall_Optoutmode_scenario() throws Exception {

		System.out.println(
				"=================Verifying BCP api call when user selecting Optoutmode scenario in privacy card started =========================");
		
		Functions.validating_bcp_privacy_Optoutmode_scenarion();
		System.out.println("================= Verifying BCP api call when user selecting Optoutmode scenario in privacy card End =========================");
				
	}
	
	@Test(priority = 47, enabled = true)
	@Title("Verifying Adcrw api call when user selecting Optoutmode scenario in privacy card")
	public void Smoke_Test__Verifying_adcrw_apicall_Optoutmode_scenario() throws Exception {

		System.out.println(
				"=================Verifying adcrw api call when user selecting Optoutmode scenario in privacy card started =========================");
		
		Functions.validating_adcrw_privacy_Optoutmode_scenarion();
		System.out.println("================= Verifying adcrw api call when user selecting Optoutmode scenario in privacy card End =========================");
				
	}
	
	@Test(priority = 48, enabled = true)
	@Title("Verifying Fatual api call when user selecting Optoutmode scenario in privacy card")
	public void Smoke_Test__Verifying_locaion_apicall_Optoutmode_scenario() throws Exception {

		System.out.println(
				"=================Verifying Fatual api call when user selecting Optoutmode scenario in privacy card started =========================");
		
		Functions.validating_Fatualcall_privacy_Optoutmode_scenarion();
		System.out.println("================= Verifying Fatual api call when user selecting Optoutmode scenario in privacy card End =========================");
				
	}
	
	@Test(priority =49, enabled = true)
	@Title("Verifying amazon aax calls when user selecting Optoutmode scenario in privacy card")
	public void Smoke_Test__Verifying_amaozn_aax_calls_Optoutmode_scenario() throws Exception {

		System.out.println(
				"=================Verifying amazon aax calls when user selecting Optoutmode scenario in privacy card started =========================");
		
		Functions.validating_aax_privacy_Optoutmode_scenario();
		System.out.println("================= Verifying amazon aax calls when user selecting Optoutmode scenario in privacy card End =========================");
				
	}
	@Test(priority = 50, enabled = true)
	@Title("Verifying home screnn hourly ad call  when user selecting Optoutmode scenario in privacy card")
	public void Smoke_Test__Verifying_homescreenhourly_calls_Optoutmode_scenario() throws Exception {

		System.out.println(
				"=================Verifying homescreen hourly ad calls when user selecting Optoutmode scenario in privacy card started =========================");
		
		Functions.finding_Homescreen_iu_value();
		System.out.println("================= Verifying homescreen hourly ad calls when user selecting Optoutmode scenario in privacy card End =========================");
				
	}
	
	@Test(priority = 51, enabled = true)
	@Title("Verifying homescreen marquee ad call  when user selecting Optoutmode scenario in privacy card")
	public void Smoke_Test__Verifying_marqueehomescreecall_Optoutmode_scenario() throws Exception {

		System.out.println(
				"=================Verifying homescreen marquee ad calls when user selecting Optoutmode scenario in privacy card started =========================");
		
		Functions.finding_Homescreen_marquee_iu_value();
		System.out.println("================= Verifying homescreen  marquee ad calls when user selecting Optoutmode scenario in privacy card End =========================");
				
	}
	

	@Test(priority = 52, enabled = true)
	@Title("Selecting the  Opt in mode in the privacy card")
	public void Smoke_Test_Selecting_Opt_in_mode_scenario() throws Exception {

		System.out.println(
				"=================Slecting Opt in mode scenario in privacy card testcase started =========================");
		AppFunctions.Kill_Launch_App();
		Functions.Verify_Privacy_Card_onScreen();
		Functions.selecting_opt_in_mode();
		System.out.println(
				"================= Slecting Opt in mode scenario in privacy card  testcase End =========================");
	}
	
	@Test(priority = 53, enabled = true)
	@Title("Verifying video call when user selecting Optinmode scenario in privacy card")
	public void Smoke_Test__Smoke_Test_Verifying_videoadcall_Optinmode_scenario() throws Exception {

		System.out.println(
				"=================Verifying video Feed ad call when user selecting Optinmode scenario in privacy card started =========================");
		 AppFunctions.Kill_Launch_App();
		 
		CharlesFunctions.startSessionBrowserData();	
		Functions.click_video();
		Functions.scrollapp_maps();
		Functions.click_Mapsdetails_element();		
		CharlesFunctions.ExportSession();
		Functions.Verify_video_ad_call_Optoutmode_();
		System.out.println("================= Verifying video ad call when user selecting Optinmode scenario in privacy card End =========================");
				
	}

	@Test(priority = 54, enabled = true)
	@Title("Verifying Feed ad call when user selecting Optintmode scenario in privacy card")
	public void Smoke_Test_Verifying_Feedadcall_Optinmode_scenario() throws Exception {

		System.out.println(
				"=================Verifying Feed ad call when user selecting Optinmode scenario in privacy card started =========================");
			
		Functions.Verifying_gampadcalls_Optoutmode();
		System.out.println(
				"================= Verifying Feed ad call when user selecting Optinmode scenario in privacy card End =========================");
	}

	
	@Test(priority = 55, enabled = true)
	@Title("Verifying details page detail page ad call when user selecting Optinmode scenario in privacy card")
	public void Smoke_Test_Verifying_detailpageadcall_Optinmode_scenario() throws Exception {

		System.out.println(
				"=================Verifying detail page Feed ad call when user selecting Optinmode scenario in privacy card started =========================");
		Functions.Verifying_detail_gampadcalls_Optoutmode();
		System.out.println(
				"================= Verifying detail page  Feed ad call when user selecting Optinmode scenario in privacy card End =========================");
	}
	
	@Test(priority = 56, enabled = true)
	@Title("Verifying BCP api call when user selecting Optinmode scenario in privacy card")
	public void Smoke_Test__Verifying_Bcp_apicall_Optinmode_scenario() throws Exception {

		System.out.println(
				"=================Verifying BCP api call when user selecting Optinmode scenario in privacy card started =========================");
		
		Functions.validating_bcp_privacy_Optinmode_scenarion();
		System.out.println("================= Verifying BCP api call when user selecting Optinmode scenario in privacy card End =========================");
				
	}
	
	@Test(priority = 57, enabled = true)
	@Title("Verifying Adcrw api call when user selecting Optinmode scenario in privacy card")
	public void Smoke_Test__Verifying_adcrw_apicall_Optinmode_scenario() throws Exception {

		System.out.println(
				"=================Verifying adcrw api call when user selecting Optinmode scenario in privacy card started =========================");
		
		Functions.validating_adcrw_privacy_Optinmode_scenarion();
		System.out.println("================= Verifying adcrw api call when user selecting Optinmode scenario in privacy card End =========================");
				
	}
	
	
	
	
	@Test(priority = 58, enabled = true)
	@Title("Verifying Fatual api call when user selecting Optinmode scenario in privacy card")
	public void Smoke_Test__Verifying_locaion_apicall_Optinmode_scenario() throws Exception {

		System.out.println(
				"=================Verifying Fatcual api call when user selecting Optinmode scenario in privacy card started =========================");
		
		Functions.validating_Fatualcall_privacy_Optinmode_scenarion();
		System.out.println("================= Verifying Fatcual api call when user selecting Oppinmode scenario in privacy card End =========================");
				
	}

	@Test(priority =59, enabled = true)
	@Title("Verifying amazon aax calls when user selecting Optinmode scenario in privacy card")
	public void Smoke_Test__Verifying_amaozn_aax_calls_Optinmode_scenario() throws Exception {

		System.out.println(
				"=================Verifying amazon aax calls when user selecting Optinmode scenario in privacy card started =========================");
		
		Functions.validating_aax_privacy_Optinmode_scenario();
		System.out.println("================= Verifying amazon aax calls when user selecting Optinmode scenario in privacy card End =========================");
				
	}
	@Test(priority = 60, enabled = true)
	@Title("Verifying home screnn hourly ad call  when user selecting Optinmode scenario in privacy card")
	public void Smoke_Test__Verifying_homescreenhourly_calls_Optinmode_scenario() throws Exception {

		System.out.println(
				"=================Verifying homescreen hourly ad calls when user selecting Optinmode scenario in privacy card started =========================");
		
		Functions.finding_Homescreen_iu_value();
		System.out.println("================= Verifying homescreen hourly ad calls when user selecting Optinmode scenario in privacy card End =========================");
				
		
	}
	
	@Test(priority = 61, enabled = true)
	@Title("Verifying homescreen marquee ad call  when user selecting Optinmode scenario in privacy card")
	public void Smoke_Test__Verifying_marqueehomescreecall_Optinmode_scenario() throws Exception {

		System.out.println(
				"=================Verifying homescreen marquee ad calls when user selecting Optinmode scenario in privacy card started =========================");
		
		Functions.finding_Homescreen_marquee_iu_value();
		System.out.println("================= Verifying homescreen  marquee ad calls when user selecting Optinmode scenario in privacy card End =========================");
				
	}*/
	
	/*
	 * @Test(priority=2,enabled = true)
	 * 
	 * @Title("Selecting the  Opt out mode in the privacy card") public void
	 * Smoke_Test_Selecting_Opt_out_mode_Option()throws Exception {
	 * 
	 * System.out.
	 * println("=================Slecting Opt out mode option in privacy card testcase started ========================="
	 * ); Functions.selecting_opt_out_mode(); System.out.
	 * println("================= Slecting Opt out mode option in privacy card  testcase End ========================="
	 * ); }
	 * 
	 * @Test(priority=3,enabled = true)
	 * 
	 * @Title("Selecting the  Opt out mode in the privacy card") public void
	 * Smoke_Test_Verifying_Bcp_apicall_privacycard_Optoutmode()throws Exception {
	 * 
	 * System.out.
	 * println("=================Slecting Opt out mode option in privacy card testcase started ========================="
	 * ); Functions.selecting_opt_out_mode(); System.out.
	 * println("================= Slecting Opt out mode option in privacy card  testcase End ========================="
	 * ); }
	 */

	@BeforeTest
	public void Before_Test() throws Exception {
		System.out.println("================= Before Test Started =========================");
	//CharlesFunctions.charlesOpen();
	// AppiumFunctions.UnInstallApp();
	  CharlesFunctions.openCharlesBrowser();
		// MapLocalFunctions.alertModeChanges("withoutalert");
		//CharlesFunctions.ClearSessions();
		// AppiumFunctions.killADB();
		// AppiumFunctions.UnInstallApp();
		// AppiumFunctions.AppiumServerStop();
		// AppiumFunctions.AppiumServerStart();
		// CharlesFunctions.ClearSessions();
	//	AppiumFunctions.LaunchAppWithFullReset();
		// Thread.sleep(10000);
		// AppiumFunctions.Kill_launch();
		/*
		 * AppiumFunctions.ClickonIUnderstand(); //AppiumFunctions.clickOnNext();
		 * //AppiumFunctions.clickOnUnderstandbutton();
		 * CharlesFunctions.startSessionBrowserData();
		 * AppiumFunctions.SwipeUp_Counter(2); AppiumFunctions.clickOnVideoElement();
		 * AppiumFunctions.clickOnBackArrowElement();
		 * AppiumFunctions.SwipeUp_Counter(1); AppiumFunctions.clickOnRadarMaps();
		 * AppiumFunctions.clickOnBackArrowElement();
		 * //AppiumFunctions.SwipeUp_Counter(1); //
		 * AppiumFunctions.clickOnVideoElement();
		 * //AppiumFunctions.clickOnBackArrowElement();
		 * AppiumFunctions.SwipeUp_Counter(1);
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
		 * AppiumFunctions.SwipeUp_Counter(2);
		 * AppiumFunctions.click_Airpollution_element();
		 * AppiumFunctions.clickOnBackArrowElement();
		 * AppiumFunctions.SwipeUp_Counter(2); AppiumFunctions.click_news_element();
		 */
		// AppiumFunctions.clickOnBackArrowElement();

		// CharlesFunctions.ExportSession();

		// AppiumFunctions.LaunchAppWithFullReset("true");
		// Ad.quit();
		AppiumFunctions.LaunchAppWithFullReset();
		//
		System.out.println("================= Before Test End =========================");

	}

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
