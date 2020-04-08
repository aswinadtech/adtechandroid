package twc.Regression.TestCases;

import java.io.File;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Title;
import twc.Automation.HandleMapLocal.MapLocalFunctions;
//import twc.Automation.HandleMapLocal.MapLocalFunctions;
import twc.Regression.CustomParamValidation.CustomParamFunctions;
import twc.Regression.Driver.Drivers;
import twc.Regression.General.Functions;
import twc.Regression.HandleWithAppium.AppiumFunctions;
import twc.Regression.HandleWithCharles.CharlesFunctions;
import twc.Regression.ReadDataFromFile.read_excel_data;
import twc.Regression.utils.DeleteFiles;


public class regressionTestCases extends Drivers{

	/*@Test(priority=1)
	@Title("Verify custom parameter cnd")
	public void C333216_Verify_cust_param_cnd() throws Exception{
		System.out.println("================= Custom Parameter Cnd Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("cnd");
		System.out.println("================= Custom Parameter Cnd Verfication End =========================");
	}*/
	@Test(priority=2)
	@Title("Verify custom parameter dma")
	public void C333203_Verify_cust_param_dma() throws Exception{
		System.out.println("================= Custom Parameter Dma Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("dma");
		System.out.println("================= Custom Parameter Dma Verfication End =========================");
	}
	@Test(priority=3)
	@Title("Verify custom parameter zip")
	public void C333202_Verify_cust_param_zip() throws Exception{
		System.out.println("================= Custom Parameter Zip Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("zip");
		
		System.out.println("================= Custom Parameter Zip Verfication End =========================");
	}
	/*@Test(priority=4)
	@Title("Verify custom parameter tmp")
	public void C333208_Verify_cust_param_tmp() throws Exception{
		System.out.println("================= Custom Parameter Tmp Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("tmp");
		System.out.println("================= Custom Parameter Tmp Verfication End =========================");
	}*/
	@Test(priority=5)
	@Title("Verify custom parameter ct")
	public void C333212_Verify_cust_param_ct() throws Exception{
		System.out.println("================= Custom Parameter Ct Verfication Started =========================");
	//	Custom_Parameters_Verification.parameters_Verification("ct");
		System.out.println("================= Custom Parameter Ct Verfication End =========================");
	}
	@Test(priority=6)
	@Title("Verify custom parameter locale")
	public void C333211_Verify_cust_param_locale() throws Exception{
		System.out.println("================= Custom Parameter Locale Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("locale");
		System.out.println("================= Custom Parameter Locale Verfication End =========================");
	}
	@Test(priority=7)
	@Title("Verify custom parameter wind")
	public void C333221_Verify_cust_param_wind() throws Exception{
		System.out.println("================= Custom Parameter Wind Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("wind");
		System.out.println("================= Custom Parameter Wind Verfication End =========================");
	}
	@Test(priority=8)
	@Title("Verify custom parameter hlzip")
	public void C333214_Verify_cust_param_hlzip() throws Exception{
		System.out.println("================= Custom Parameter Hlzip Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("hlzip");
		System.out.println("================= Custom Parameter Hlzip Verfication End =========================");
	}
	@Test(priority=9)
	@Title("Verify custom parameter hmid")
	public void C333207_Verify_cust_param_hmid() throws Exception{
		System.out.println("================= Custom Parameter Hmid Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("hmid");
		System.out.println("================= Custom Parameters Hmid Verfication End =========================");
	}
	@Test(priority=10)
	@Title("Verify custom parameter st")
	public void C333226_Verify_cust_param_st() throws Exception{
		System.out.println("================= Custom Parameter St Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("st");
		System.out.println("================= Custom Parameter St Verfication End =========================");
	}
	@Test(priority=11)
	@Title("Verify custom parameter faud")
	public void C333229_Verify_cust_param_faud() throws Exception{
		System.out.println("================= Custom Parameter Faud Verfication Started =========================");
	//	Custom_Parameters_Verification.parameters_Verification("faud");
		System.out.println("================= Custom Parameter Faud Verfication End =========================");
	}
	@Test(priority=12)
	@Title("Verify custom parameter fgeo")
	public void C333230_Verify_cust_param_fgeo() throws Exception{
		System.out.println("================= Custom Parameter Fgeo Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("fgeo");
		System.out.println("================= Custom Parameter Fgeo Verfication End =========================");
	}
	@Test(priority=13)
	@Title("Verify custom parameter fltmpc")
	public void C333233_Verify_cust_param_filtmpc() throws Exception{
		System.out.println("================= Custom Parameter Fltmpc Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("fltmpc");
		System.out.println("================= Custom Parameter Fltmpc Verfication End =========================");
	}
	@Test(priority=14)
	@Title("Verify custom parameter ftl")
	public void C333215_Verify_cust_param_ftl() throws Exception{
		System.out.println("================= Custom Parameter Ftl Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("ftl");
		System.out.println("================= Custom Parameter Ftl Verfication End =========================");
	}
	@Test(priority=15)
	@Title("Verify custom parameter lang")
	public void C658711_Verify_cust_param_lang() throws Exception{
		System.out.println("================= Custom Parameter Lang Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("lang");
		System.out.println("================= Custom Parameter Lang Verfication End =========================");
	}
	@Test(priority=16)
	@Title("Verify custom parameter plat")
	public void C658712_Verify_cust_param_plat() throws Exception{
		System.out.println("================= Custom Parameter Plat Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("plat");
	//	System.out.println("================= Custom Parameter Plat Verfication End =========================");
	}
	/*@Test(priority=17)
	@Title("Verify custom parameter pos")
	public void C333218_Verify_cust_param_pos() throws Exception{
		System.out.println("================= Custom Parameter Pos Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("pos");
		System.out.println("================= Custom Parameter Pos Verfication End =========================");
	}*/
	@Test(priority=18)
	@Title("Verify custom parameter sg")
	public void C333227_Verify_cust_param_sg() throws Exception{
		System.out.println("================= Custom Parameter Sg Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("sg");
		System.out.println("================= Custom Parameter Sg Verfication End =========================");
	}
	@Test(priority=19)
	@Title("Verify custom parameter tile")
	public void C333205_Verify_cust_param_tile() throws Exception{
		System.out.println("================= Custom Parameter Tile Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("tile");
		System.out.println("================= Custom Parameter Tile Verfication End =========================");
	}
	@Test(priority=20)
	@Title("Verify custom parameter tmpc")
	public void C333239_Verify_cust_param_tmpc() throws Exception{
		System.out.println("================= Custom Parameter Tmpc Verfication Started =========================");
	//	Custom_Parameters_Verification.parameters_Verification("tmpc");
		System.out.println("================= Custom Parameter Tmpc Verfication End =========================");
	}
	@Test(priority=21)
	@Title("Verify custom parameter tmpr")
	public void C333217_Verify_cust_param_tmpr() throws Exception{
		System.out.println("================= Custom Parameter Tmpr Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("tmpr");
		System.out.println("================= Custom Parameter Tmpr Verfication End =========================");
	}
	@Test(priority=22)
	@Title("Verify custom parameter uv")
	public void C333224_Verify_cust_param_uv() throws Exception{
		System.out.println("================= Custom Parameter Uv Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("uv");
		System.out.println("================= Custom Parameter Uv Verfication End =========================");
	}
	@Test(priority=23)
	@Title("Verify custom parameter wfxtg")
	public void C333228_Verify_cust_param_wfxtg() throws Exception{
		System.out.println("================= Custom Parameter Wfxtg Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("wfxtg");
		System.out.println("================= Custom Parameter Wfxtg Verfication End =========================");
	}
	@Test(priority=24)
	@Title("Verify custom parameter zcs")
	public void C333240_Verify_cust_param_zcs() throws Exception{
		System.out.println("================= Custom Parameter Zcs Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("zcs");
		System.out.println("================= Custom Parameter Zcs Verfication End =========================");
	}
	/*@Test(priority=25)
	@Title("Verify custom parameter nzcs")
	public void C333241_Verify_cust_param_nzcs() throws Exception{
		System.out.println("================= Custom Parameter Nzcs Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("nzcs");
		System.out.println("================= Custom Parameter Nzcs Verfication End =========================");
	}*/
	@Test(priority=26)
	@Title("Verify custom parameter hzcs")
	public void C333242_Verify_cust_param_hzcs() throws Exception{
		System.out.println("================= Custom Parameter Hzcs Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("hzcs");
		System.out.println("================= Custom Parameter Hzcs Verfication End =========================");
	}
	@Test(priority=27)
	@Title("Verify custom parameter cc")
	public void C333209_Verify_cust_param_cc() throws Exception{
		System.out.println("================= Custom Parameter Cc Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("cc");
		System.out.println("================= Custom Parameter Cc Verfication End =========================");
	}
	@Test(priority=28)
	@Title("Verify custom parameter par")
	public void C658713_Verify_cust_param_par() throws Exception{
		System.out.println("================= Custom Parameter Par Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("par");
		System.out.println("================= Custom Parameter Par Verfication End =========================");
	}
	@Test(priority=29)
	@Title("Verify custom parameter vw")
	public void C333210_Verify_cust_param_vw() throws Exception{
		System.out.println("================= Custom Parameter Vw Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("vw");
		System.out.println("================= Custom Parameter Vw Verfication End =========================");
	}
	@Test(priority=30)
	@Title("Verify custom parameter aid")
	public void C333213_Verify_cust_param_aid() throws Exception{
		System.out.println("================= Custom Parameter Aid Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("aid");
		System.out.println("================= Custom Parameter Aid Verfication End =========================");
	}
	@Test(priority=31)
	@Title("Verify custom parameter ord")
	public void C333200_Verify_cust_param_ord() throws Exception{
		System.out.println("================= Custom Parameter ORD Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("ord");
		System.out.println("================= Custom Parameter ORD Verfication End =========================");
	}
	@Test(priority=32)
	@Title("Verify custom parameter a")
	public void C333235_Verify_cust_param_a() throws Exception{
		System.out.println("================= Custom Parameter A Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("a");
		System.out.println("================= Custom Parameter A Verfication End =========================");
	}
	@Test(priority=33)
	@Title("Verify custom parameter ch")
	public void C658714_Verify_cust_param_ch() throws Exception{
		System.out.println("================= Custom Parameter Ch Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("ch");
		System.out.println("================= Custom Parameter Ch Verfication End =========================");
	}
	@Test(priority=34)
	@Title("Verify custom parameter fam")
	public void C658715_Verify_cust_param_fam() throws Exception{
		System.out.println("================= Custom Parameter Fam Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("fam");
		System.out.println("================= Custom Parameter Fam Verfication End =========================");
	}
	@Test(priority=35)
	@Title("Verify custom parameter g")
	public void C333236_Verify_cust_param_g() throws Exception{
		System.out.println("================= Custom Parameter G Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("g");
		System.out.println("================= Custom Parameter G Verfication End =========================");
	}
	@Test(priority=36)
	@Title("Verify custom parameter layer")
	public void C333225_Verify_cust_param_layer() throws Exception{
		System.out.println("================= Custom Parameter Layer Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("layer");
		System.out.println("================= Custom Parameter Layer Verfication End =========================");
	}
	@Test(priority=37)
	@Title("Verify custom parameter rmid")
	public void C333204_Verify_cust_param_rmid() throws Exception{
		System.out.println("================= Custom Parameter Rmid Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("rmid");
		System.out.println("================= Custom Parameter Rmid Verfication End =========================");
	}
	@Test(priority=38)
	@Title("Verify custom parameter tf")
	public void C658716_Verify_cust_param_tf() throws Exception{
		System.out.println("================= Custom Parameter Tf Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("tf");
		System.out.println("================= Custom Parameter Tf Verfication End =========================");
	}
	@Test(priority=39)
	@Title("Verify custom parameter ver")
	public void C333219_Verify_cust_param_ver() throws Exception{
		System.out.println("================= Custom Parameter Ver Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("ver");
		System.out.println("================= Custom Parameter Ver Verfication End =========================");
	}
	@Test(priority=40)
	@Title("Verify custom parameter fhic")
	public void C333232_Verify_cust_param_fhic() throws Exception{
		System.out.println("================= Custom Parameter Fhic Verfication Started =========================");
	//	Custom_Parameters_Verification.parameters_Verification("fhic");
		System.out.println("================= Custom Parameter Fhic Verfication End =========================");
	}
	@Test(priority=41)
	@Title("Verify custom parameter floc")
	public void C333238_Verify_cust_param_floc() throws Exception{
		System.out.println("================= Custom Parameter Floc Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("floc");
		System.out.println("================= Custom Parameter Floc Verfication End =========================");
	}
	/*@Test(priority=42)
	@Title("Verify custom parameter sev")
	public void C333223_Verify_cust_param_sev() throws Exception{
		System.out.println("================= Custom Parameter Sev Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("sev");
		System.out.println("================= Custom Parameter Sev Verfication End =========================");
	}*/
	/*@Test(priority=43)
	@Title("Verify custom parameter plln")
	public void C333201_Verify_cust_param_plln() throws Exception{
		System.out.println("================= Custom Parameter Plln Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("plln");
		System.out.println("================= Custom Parameter Plln Verfication End =========================");
	}*/
	@Test(priority=44)
	@Title("Verify custom parameter cmsid")
	public void C344257_Verify_Video_Url_Parameter_cmsid() throws Exception{
		System.out.println("================= Custom Parameter Cmsid Verfication Started =========================");
	//	Custom_Parameters_Verification.verify_video_custom_parameters("cmsid");
		System.out.println("================= Custom Parameter Cmsid Verfication End =========================");
	}
	@Test(priority=45)
	@Title("Verify custom parameter ttid")
	public void C344258_Verify_Video_Url_Parameter_ttid() throws Exception{
		System.out.println("================= Custom Parameter Ttid Verfication Started =========================");
		//Custom_Parameters_Verification.verify_video_custom_parameters("ttid");
		System.out.println("================= Custom Parameter Ttid Verfication End =========================");
	}
	@Test(priority=46)
	@Title("Verify custom parameter lnid")
	public void C344260_Verify_Video_Url_Parameter_lnid() throws Exception{
		System.out.println("================= Custom Parameter Lnid Verfication Started =========================");
	//	Custom_Parameters_Verification.verify_video_custom_parameters("lnid");
		System.out.println("================= Custom Parameter Lnid Verfication End =========================");
	}
	@Test(priority=47)
	@Title("Verify custom parameter vid")
	public void C344259_Verify_Video_Url_Parameter_vid() throws Exception{
		System.out.println("================= Custom Parameter Vid Verfication Started =========================");
	//	Custom_Parameters_Verification.verify_video_custom_parameters("vid");
		System.out.println("================= Custom Parameter Vid Verfication End =========================");
	}
	@Test(priority=48)
	@Title("Verify custom parameter iu")
	public void C344261_Verify_Video_Url_Parameter_iu() throws Exception{
		System.out.println("================= Custom Parameter IU Verfication Started =========================");
		//Custom_Parameters_Verification.verify_video_custom_parameters("iu");
		System.out.println("================= Custom Parameter IU Verfication End =========================");
	}
	@Test(priority=49)
	@Title("Verify custom parameter dynght")
	public void C628160_Verify_Parameter_DyNght() throws Exception{
		System.out.println("================= Custom Parameter DayNight Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("dynght");
		System.out.println("================= Custom Parameter DayNight Verfication End =========================");
	}
	@Test(priority=50)
	@Title("Verify custom parameter bn")
	public void C456970_Verify_Parameter_BN() throws Exception{
		System.out.println("================= Custom Parameter BN Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("bn");
		System.out.println("================= Custom Parameter BN Verfication End =========================");
	}
	/*@Test(priority=51)
	@Title("Verify custom parameter ")
	public void validating_env_values_backgroundlaunch() throws Exception{
		System.out.println("================= validating_env_values_backgroundlaunch =========================");
		Ad.runAppInBackground(10);
		Custom_Parameters_Verification.parameters_Verification("env");
		System.out.println("================= validating_env_values_backgroundlaunch =========================");
	}*/
	/*@Test(priority=51)
	@Title("Verify custom parameter mlayer")
	public void C402798_Verify_Road_Conditions_Paramater_mlayer() throws Exception{
		System.out.println("================= Custom Parameter Mlayer Verfication Started =========================");
		Custom_Parameters_Verification.verify_mlayer_custom_parameters("mlayer");
		System.out.println("================= Custom Parameter Mlayer Verfication End =========================");
	}*/
	
	
	
	
	
	/*@Test(priority=52)
	@Title("Verify custom parameter Env")
	public void C758746_Verify_cust_param_Env_pullToRefresh() throws Exception{
		System.out.println("================= Custom Parameter Env Verfication for pull to refresh Starts =========================");
		Custom_Parameters_Verification.verify_custom_parameter_for_PullToReFresh("Env");
		System.out.println("================= Custom Parameter Env Verfication for pull to refresh Ends =========================");
	}*/

	/*@Test(priority=53)
	@Title("Verify custom parameter Env after scrolling the app")
	public void C758747_Verify_cust_param_Env_afterScrollingApp() throws Exception{
		System.out.println("================= Custom Parameter Env Verfication after scrolling the app Starts =========================");
		Custom_Parameters_Verification.verify_custom_parameter_after_ScrollingApp("Env");
		System.out.println("================= Custom Parameter Env Verfication after scrolling the app Ends =========================");
	}*/
//	
//	
//	
//	@Test(priority=54)
//	@Title("Verify custom parameter Env on minimize and relaunching the app")
//	public void C758749_Verify_cust_param_Env_on_minimize_and_relaunchingApp() throws Exception{
//		System.out.println("================= Custom Parameter Env Verfication on minimize and relaunching the app Starts =========================");
//		Custom_Parameters_Verification.verify_custom_parameter_on_minimize_and_relaunchingApp("Env");
//		System.out.println("================= Custom Parameter Env Verfication on minimize and relaunching the app Ends =========================");
//	}
//	
//	
//
//
//	@Test(priority=55)
//	@Title("Verify custom parameter Env on detailPage")
//	public void C758748_Verify_cust_param_Env_on_detailPage() throws Exception{
//		System.out.println("================= Custom Parameter Env Verfication after scrolling the app Started =========================");
//		Custom_Parameters_Verification.verify_custom_parameter_on_detailPage("Env");
//		System.out.println("================= Custom Parameter Env Verfication after scrolling the app End =========================");
//	}
//	
	
	/*@Test(priority=52)
	@Title("Verify custom parameter Env")
	public void C758746_Verify_cust_param_Env() throws Exception{
		CharlesFunctions.charlesOpen();
//		//AppiumFunctions.UnInstallApp();
		CharlesFunctions.openCharlesBrowser();
		System.out.println("================= Custom Parameter Env Verfication for pull to refresh Starts =========================");
		Custom_Parameters_Verification.verify_custom_parameter_for_PullToReFresh("Env");
		System.out.println("================= Custom Parameter Env Verfication for pull to refresh Ends =========================");
	

		System.out.println("================= Custom Parameter Env Verfication after scrolling the app Starts =========================");
		Custom_Parameters_Verification.verify_custom_parameter_after_ScrollingApp("Env");
		System.out.println("================= Custom Parameter Env Verfication after scrolling the app Ends =========================");
	
	
	
		System.out.println("================= Custom Parameter Env Verfication on minimize and relaunching the app Starts =========================");
		Custom_Parameters_Verification.verify_custom_parameter_on_minimize_and_relaunchingApp("Env");
		System.out.println("================= Custom Parameter Env Verfication on minimize and relaunching the app Ends =========================");
	
	
	

		System.out.println("================= Custom Parameter Env Verfication on_detailPage =========================");
		Custom_Parameters_Verification.verify_custom_parameter_on_detailPage("Env");
		System.out.println("================= Custom Parameter Env Verfication on_detailPage =========================");
	}*/

	
	/*@Test(priority = 0,enabled=true)
	public void Verify_SlotID_foralltheads() throws Exception {
		Functions.get_aaxcals();
	}*/

	
	
	@BeforeTest
	public void Before_Test() throws Exception{
	
		CharlesFunctions.charlesOpen();
		AppiumFunctions.UnInstallApp();
		CharlesFunctions.openCharlesBrowser();
		System.out.println("setting contentmode to normal");
		//MapLocalFunctions.contentModeModule("normal");
		//read_excel_data.Clear_Exceldata();	    
	   CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData();
		//CharlesFunctions.startSessionBrowserData();
	    AppiumFunctions.LaunchAppWithFullReset();
	    Thread.sleep(30000);
	//	Functions.Change_to_Test_Mode("TestMode");
		//Functions.Kill_launch();

                       AppiumFunctions.SwipeUp_Counter(1);	
			AppiumFunctions.clickOnVideoElement();
			AppiumFunctions.clickOnBackArrowElement();

                    AppiumFunctions.SwipeUp_Counter(2);
			//AppiumFunctions.clickOnRadarMaps();
		//	AppiumFunctions.clickOnBackArrowElement();	
                        AppiumFunctions.SwipeUp_Counter(5);					
			//AppiumFunctions.click_Todaydetails_element();
		//	AppiumFunctions.clickOnBackArrowElement_trending();
             	//	AppiumFunctions.SwipeUp_Counter(1);
			//AppiumFunctions.click_Airpollution_element();
		//	AppiumFunctions.clickOnBackArrowElement();
			AppiumFunctions.SwipeUp_Counter(2);
			//AppiumFunctions.click_news_element();
			//AppiumFunctions.clickOnBackArrowElement();
			//AppiumFunctions.click_hourly_element();
			//AppiumFunctions.click_home_element();
			//AppiumFunctions.click_daily_element();
			CharlesFunctions.ExportSession();	
	      //Functions.verify_Road_Conditions("DDI");
 		 // Functions.CleanLaunch_launch("General");
	    // CharlesFunctions.StopExportSessionXMLFile();
		 // CustomParamFunctions.get_fhic_floc_value();
	}
	@AfterTest
	public void After_Test() throws Exception{
		//DeleteFiles.deleteFiles(new Fi le("/Users/monocept/Documents/workspace_luna/RegressionTest/ExpectedMapLocal/"));
	    //DeleteFiles d = new DeleteFiles();
	    //d.deleteFiles(new File("/Users/monocept/Documents/workspace_luna/RegressionTest/ExpectedMapLocal/"));
	    //DeleteFiles.delete(new File("/Users/monocept/Documents/workspace_luna/RegressionTest/ExpectedMapLocal/"));
//		CharlesFunctions.BrowserClosed();
//		CharlesFunctions.charlesClose();
	}
}
