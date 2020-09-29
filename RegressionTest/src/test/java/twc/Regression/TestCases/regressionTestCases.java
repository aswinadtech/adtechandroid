package twc.Regression.TestCases;

import java.io.File;

import org.openqa.selenium.internal.Killable;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Title;

//import twc.Automation.HandleMapLocal.MapLocalFunctions;
import twc.Regression.CustomParamValidation.CustomParamFunctions;
import twc.Regression.CustomParamValidation.validate_CustomParameter;
import twc.Regression.Driver.Drivers;
import twc.Regression.General.Functions;
import twc.Regression.HandleWithAppium.AppiumFunctions;
import twc.Regression.HandleWithCharles.CharlesFunctions;
import twc.Regression.ReadDataFromFile.read_excel_data;
import twc.Regression.utils.DeleteFiles;

public class regressionTestCases extends Drivers {

	// video ad call custum parameters
	/*@Test(priority = 1)
	@Title("Verify custom parameter cmsid")
	public void C344257_Verify_Video_Url_Parameter_cmsid() throws Exception {
		System.out.println("================= Custom Parameter Cmsid Verfication Started =========================");
		Custom_Parameters_Verification.verify_video_custom_parameters("cmsid");
		System.out.println("================= Custom Parameter Cmsid Verfication End =========================");
	}

	@Test(priority = 2)
	@Title("Verify custom parameter ttid")
	public void C344258_Verify_Video_Url_Parameter_ttid() throws Exception {
		System.out.println("================= Custom Parameter Ttid Verfication Started =========================");
		Custom_Parameters_Verification.verify_video_custom_parameters("ttid");
		System.out.println("================= Custom Parameter Ttid Verfication End =========================");
	}

	@Test(priority = 3)
	@Title("Verify custom parameter lnid")
	public void C344260_Verify_Video_Url_Parameter_lnid() throws Exception {
		System.out.println("================= Custom Parameter Lnid Verfication Started =========================");
		Custom_Parameters_Verification.verify_video_custom_parameters("lnid");
		System.out.println("================= Custom Parameter Lnid Verfication End =========================");
	}

	@Test(priority = 4)
	@Title("Verify custom parameter vid")
	public void C344259_Verify_Video_Url_Parameter_vid() throws Exception {
		System.out.println("================= Custom Parameter Vid Verfication Started =========================");
		Custom_Parameters_Verification.verify_video_custom_parameters("vid");
		System.out.println("================= Custom Parameter Vid Verfication End =========================");
	}

	@Test(priority = 5)
	@Title("Verify video ad call custom parameter iu")
	public void C344261_Verify_Video_Url_Parameter_iu() throws Exception {
		System.out.println("================= Custom Parameter IU Verfication Started =========================");
		Custom_Parameters_Verification.verify_video_custom_parameters("iu");
		System.out.println("================= Custom Parameter IU Verfication End =========================");
	}

	@Test(priority = 6)
	@Title("Verify Description_url for video call")
	public void C344261_Verify_DescriptionURL_Video() throws Exception {
		System.out.println("================= Verify description URL for video call Started =========================");
		Custom_Parameters_Verification.verify_video_request("description_url");
		System.out.println("================= Verify description URL for video call  End =========================");
	}

	@Test(priority = 7)
	@Title("Verify Content_url for video call")
	public void C344261_Verify_ContentURL_Video() throws Exception {
		System.out.println("================= Verify Content URL for video call Started =========================");
		Custom_Parameters_Verification.verify_video_request("content_url");
		System.out.println("================= Verify Content URL for video call  End =========================");
	}*/

	// Not null
	/*@Test(priority = 21)
	@Title("Verify custom parameter adid")
	public void C333213_Verify_cust_param_adid() throws Exception {
		System.out.println("================= Custom Parameter adid Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("adid");
		System.out.println("================= Custom Parameter adid Verfication End =========================");
	}

	@Test(priority = 22)
	@Title("Verify custom parameter aid")
	public void C333213_Verify_cust_param_aid() throws Exception {
		System.out.println("================= Custom Parameter Aid Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("aid");
		System.out.println("================= Custom Parameter Aid Verfication End =========================");
	}*/
	/*@Test(priority = 22)
	@Title("Verify custom parameter env")
	public void C333244_Verify_cust_param_env() throws Exception {
		System.out.println("================= Custom Parameter env Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("env");
		System.out.println("================= Custom Parameter env Verfication End =========================");
	}*/


	/*@Test(priority = 23)
	@Title("Verify custom parameter st")
	public void C333219_Verify_cust_param_st() throws Exception {
		System.out.println("================= Custom Parameter St Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("st");
		System.out.println("================= Custom Parameter St Verfication End =========================");
	}*/

	@Test(priority = 25)
	@Title("Verify custom parameter ord")
	public void C333200_Verify_cust_param_ord() throws Exception {
		System.out.println("================= Custom Parameter ORD Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("ord");
		System.out.println("================= Custom Parameter ORD Verfication End =========================");
	}

	/*@Test(priority = 26)
	@Title("Verify custom parameter rmid")
	public void C333204_Verify_cust_param_rmid() throws Exception {
		System.out.println("================= Custom Parameter Rmid Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("rmid");
		System.out.println("================= Custom Parameter Rmid Verfication End =========================");
	}*/

@Test(priority = 27)
	@Title("Verify custom parameter ver")
	public void C333219_Verify_cust_param_ver() throws Exception {
		System.out.println("================= Custom Parameter Ver Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("ver");
		System.out.println("================= Custom Parameter Ver Verfication End =========================");
	}
	

	 /* @Test(priority=29)  
	  @Title("Verify custom parameter ftl") 
	  public void C333215_Verify_cust_param_ftl() throws Exception{ 
		  System.out.println("================= Custom Parameter Ftl Verfication Started =========================" );
	  Custom_Parameters_Verification.parameters_Verification("ftl"); 
	  System.out. println("================= Custom Parameter Ftl Verfication End =========================");  
	  }
	  @Test(priority=30)
	  @Title("Verify custom parameter g") 
	  public void C333236_Verify_cust_param_g()  throws Exception{ 
	 System.out. println("================= Custom Parameter G Verfication Started =========================");
	 Custom_Parameters_Verification.parameters_Verification("g"); 
	 System.out.println("================= Custom Parameter G Verfication End =========================" );
	 }*/

@Test(priority = 31)
	@Title("Verify custom parameter dt")
	public void C333213_Verify_cust_param_dt_day1_adCall() throws Exception {
		System.out.println("================= Custom Parameter dt Verfication Started =========================");
		Custom_Parameters_Verification.verify_daily_custom_parameters("dt");
		System.out.println("================= Custom Parameter dt Verfication End =========================");
	}

	@Test(priority = 32)
	@Title("Verify custom parameter mnth")
	public void C333213_Verify_cust_param_mnth_day1_adCall() throws Exception {
		System.out.println("================= Custom Parameter mnth Verfication Started =========================");
		Custom_Parameters_Verification.verify_daily_custom_parameters("mnth");
		System.out.println("================= Custom Parameter mnth Verfication End =========================");
		
	}
	
	@Test(priority = 33)
	@Title("Verify custom parameter tf")
	public void C658716_Verify_cust_param_tf() throws Exception {
		System.out.println("================= Custom Parameter Tf Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("tf");
		System.out.println("================= Custom Parameter Tf Verfication End =========================");
	}

	@Test(priority = 31)
	@Title("Verify custom parameter fcnd")
	public void C333213_Verify_cust_param_fcnd_day1_adCall() throws Exception {
		System.out.println("================= Custom Parameter fcnd Verfication Started =========================");
		//Custom_Parameters_Verification.verify_daily_custom_parameters("fcnd");
		System.out.println("================= Custom Parameter fcnd Verfication End =========================");
	}

	@Test(priority = 32)
	@Title("Verify custom parameter fdynght")
	public void C333213_Verify_cust_param_fdynght_day1_adCall() throws Exception {
		System.out.println("================= Custom Parameter fdynght Verfication Started =========================");
		//Custom_Parameters_Verification.verify_daily_custom_parameters("fdynght");
		System.out.println("================= Custom Parameter fdynght Verfication End =========================");
		
	}
	
	
//Hard code values

	@Test(priority = 40)
	@Title("Verify custom parameter lang")
	public void C658711_Verify_cust_param_lang() throws Exception {
		System.out.println("================= Custom Parameter Lang Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("lang");
		System.out.println("================= Custom Parameter Lang Verfication End =========================");
	}

	@Test(priority = 41)
	@Title("Verify custom parameter plat")
	public void C658712_Verify_cust_param_plat() throws Exception {
		System.out.println("================= Custom Parameter Plat Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("plat");
		System.out.println("================= Custom Parameter Plat Verfication End =========================");
	}

	@Test(priority = 42)
	@Title("Verify custom parameter pos")
	public void C333218_Verify_cust_param_pos() throws Exception {
		System.out.println("================= Custom Parameter Pos Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("pos");
		System.out.println("================= Custom Parameter Pos Verfication End =========================");
	}

	@Test(priority = 43)
	@Title("Verify custom parameter tile")
	public void C333205_Verify_cust_param_tile() throws Exception {
		System.out.println("================= Custom Parameter Tile Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("tile");
		System.out.println("================= Custom Parameter Tile Verfication End =========================");
	}

	
	
	
	
	

	// turbo call values
	@Test(priority = 60)
	@Title("Verify custom parameter cnd")
	public void C333216_Verify_cust_param_cnd() throws Exception {
		System.out.println("================= Custom Parameter Cnd Verfication Started =========================");
		//Custom_Parameters_Verification.parameters_Verification("cnd");

		System.out.println("================= Custom Parameter Cnd Verfication End =========================");
	}

	@Test(priority = 61)
	@Title("Verify custom parameter ct")
	public void C333212_Verify_cust_param_ct() throws Exception {
		System.out.println("================= Custom Parameter Ct Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("ct");
		System.out.println("================= Custom Parameter Ct Verfication End =========================");
	}

	@Test(priority = 62)
	@Title("Verify custom parameter dma")
	public void C333203_Verify_cust_param_dma() throws Exception {
		System.out.println("================= Custom Parameter Dma Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("dma");
		System.out.println("================= Custom Parameter Dma Verfication End =========================");
	}

	@Test(priority = 63)
	@Title("Verify custom parameter dynght")
	public void C628160_Verify_Parameter_DyNght() throws Exception {
		System.out.println("================= Custom Parameter DayNight Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("dynght");
		System.out.println("================= Custom Parameter DayNight Verfication End =========================");
	}

	@Test(priority = 64)
	@Title("Verify custom parameter cc")
	public void C333209_Verify_cust_param_cc() throws Exception {
		System.out.println("================= Custom Parameter Cc Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("cc");
		System.out.println("================= Custom Parameter Cc Verfication End =========================");
	}

	/*@Test(priority = 65)
	@Title("Verify custom parameter fhic")
	public void C333232_Verify_cust_param_fhic() throws Exception {
		System.out.println("================= Custom Parameter Fhic Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("fhic");
		System.out.println("================= Custom Parameter Fhic Verfication End =========================");
	}*/

	/*@Test(priority = 66)
	@Title("Verify custom parameter floc")
	public void C333238_Verify_cust_param_floc() throws Exception {
		System.out.println("================= Custom Parameter Floc Verfication Started =========================");
	//	Custom_Parameters_Verification.parameters_Verification("floc");
		System.out.println("================= Custom Parameter Floc Verfication End =========================");
	}*/

	@Test(priority = 67)
	@Title("Verify custom parameter tmp")
	public void C333208_Verify_cust_param_tmp() throws Exception {
		System.out.println("================= Custom Parameter Tmp Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("tmp");
		System.out.println("================= Custom Parameter Tmp Verfication End =========================");
	}

	@Test(priority = 68)
	@Title("Verify custom parameter tmpr")
	public void C333217_Verify_cust_param_tmpr() throws Exception {
		System.out.println("================= Custom Parameter Tmpr Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("tmpr");
		System.out.println("================= Custom Parameter Tmpr Verfication End =========================");
	}

	@Test(priority = 69)
	@Title("Verify custom parameter tmpc")
	public void C333239_Verify_cust_param_tmpc() throws Exception {
		System.out.println("================= Custom Parameter Tmpc Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("tmpc");
		System.out.println("================= Custom Parameter Tmpc Verfication End =========================");
	}

	@Test(priority = 70)
	@Title("Verify custom parameter zip from  turbo api")
	public void C333202_Verify_cust_param_zip() throws Exception {
		System.out.println(
				"================= Custom Parameter Zip Verfication  from turbo call Started =========================");
		Custom_Parameters_Verification.parameters_Verification("zip");

		System.out.println(
				"================= Custom Parameter Zip Verfication  from turbo call End =========================");
	}
	
	/*@Test(priority=73) 
	  @Title("Verify custom parameter hmid") 
public void  C333207_Verify_cust_param_hmid() throws Exception{ 
	  System.out.println("================= Custom Parameter Hmid Verfication Started =========================");
	  Custom_Parameters_Verification.parameters_Verification("hmid"); 
	  System.out.println("================= Custom Parameters Hmid Verfication End =========================" );
	  }*/

	@Test(priority = 74)
	@Title("Verify custom parameter wind")
	public void C333221_Verify_cust_param_wind() throws Exception {
		System.out.println("================= Custom Parameter Wind Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("wind");
		System.out.println("================= Custom Parameter Wind Verfication End =========================");
	}

	@Test(priority = 75)
	@Title("Verify custom parameter uv")
	public void C333224_Verify_cust_param_uv() throws Exception {
		System.out.println("================= Custom Parameter Uv Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("uv");
		System.out.println("================= Custom Parameter Uv Verfication End =========================");
	}

	@Test(priority = 76)
	@Title("Verify custom parameter fltmpc")
	public void C333232_Verify_cust_param_fltmpc() throws Exception {
		System.out.println("================= Custom Parameter fltmpc Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("fltmpc");
		System.out.println("================= Custom Parameter fltmpc Verfication End =========================");
	}

	
	
	// wfxtg call

	@Test(priority = 90)
	@Title("Verify custom parameter wfxtg")
	public void C333228_Verify_cust_param_wfxtg() throws Exception {
		System.out.println("================= Custom Parameter Wfxtg Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("wfxtg");
		System.out.println("================= Custom Parameter Wfxtg Verfication End =========================");
	}

	/*
	 * @Test(priority=81)
	 * 
	 * @Title("Verify custom parameter cfxtg") public void
	 * C333228_Verify_cust_param_cfxtg() throws Exception{ System.out.
	 * println("================= Custom Parameter cfxtg Verfication Started ========================="
	 * ); Custom_Parameters_Verification.parameters_Verification("cxtg");
	 * System.out.
	 * println("================= Custom Parameter cfxtg Verfication End ========================="
	 * ); }
	 */

	/*@Test(priority = 82)
	@Title("Verify custom parameter hlzip")
	public void C333214_Verify_cust_param_hlzip() throws Exception {
		System.out.println("================= Custom Parameter Hlzip Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("hlzip");
		System.out.println("================= Custom Parameter Hlzip Verfication End =========================");
	}*/

	/*
	 * @Test(priority=83)
	 * 
	 * @Title("Verify custom parameter zcs") public void
	 * C333240_Verify_cust_param_zcs() throws Exception{ System.out.
	 * println("================= Custom Parameter Zcs Verfication Started ========================="
	 * ); Custom_Parameters_Verification.parameters_Verification("zcs"); System.out.
	 * println("================= Custom Parameter Zcs Verfication End ========================="
	 * ); }
	 * 
	 * @Test(priority=84)
	 * 
	 * @Title("Verify custom parameter nzcs") public void
	 * C333241_Verify_cust_param_nzcs() throws Exception{ System.out.
	 * println("================= Custom Parameter Nzcs Verfication Started ========================="
	 * ); Custom_Parameters_Verification.parameters_Verification("nzcs");
	 * System.out.
	 * println("================= Custom Parameter Nzcs Verfication End ========================="
	 * ); }
	 * 
	 * @Test(priority=85)
	 * 
	 * @Title("Verify custom parameter hzcs") public void
	 * C333242_Verify_cust_param_hzcs() throws Exception{ System.out.
	 * println("================= Custom Parameter Hzcs Verfication Started ========================="
	 * ); Custom_Parameters_Verification.parameters_Verification("hzcs");
	 * System.out.
	 * println("================= Custom Parameter Hzcs Verfication End ========================="
	 * ); }
	 */

	// Fatual call

	/*
	 * @Test(priority=100)
	 * 
	 * @Title("Verify custom parameter faud") public void
	 * C333229_Verify_cust_param_faud() throws Exception{ System.out.
	 * println("================= Custom Parameter Faud Verfication Started ========================="
	 * ); Custom_Parameters_Verification.parameters_Verification("faud");
	 * System.out.
	 * println("================= Custom Parameter Faud Verfication End ========================="
	 * ); }
	 * 
	 * @Test(priority=101)
	 * 
	 * @Title("Verify custom parameter fgeo") public void
	 * C333230_Verify_cust_param_fgeo() throws Exception{ System.out.
	 * println("================= Custom Parameter Fgeo Verfication Started ========================="
	 * ); Custom_Parameters_Verification.parameters_Verification("fgeo");
	 * System.out.
	 * println("================= Custom Parameter Fgeo Verfication End ========================="
	 * ); }
	 */

	// Lotame call

	/*
	 * @Test(priority=110)
	 * 
	 * @Title("Verify custom parameter sg") public void
	 * C333227_Verify_cust_param_sg() throws Exception{ System.out.
	 * println("================= Custom Parameter Sg Verfication Started ========================="
	 * ); Custom_Parameters_Verification.parameters_Verification("sg"); System.out.
	 * println("================= Custom Parameter Sg Verfication End ========================="
	 * ); }
	 */

	// DSX call

	// DsxCmsAssetsCall
	@Test(priority = 120)
	@Title("Verify custom parameter locale")
	public void C333211_Verify_cust_param_locale() throws Exception {
		System.out.println("================= Custom Parameter Locale Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("locale");
		System.out.println("================= Custom Parameter Locale Verfication End =========================");
	}

	// UI

	/*@Test(priority = 130)
	@Title("Verify custom parameter sev")
	public void C333223_Verify_cust_param_sev() throws Exception {
		System.out.println("================= Custom Parameter Sev Verfication Started =========================");
		Custom_Parameters_Verification.parameters_Verification("sev");
		System.out.println("================= Custom Parameter Sev Verfication End =========================");
	}*/

	// turbo call related test cases

	/*
	 * @Test(priority=4)
	 * 
	 * @Title("Verify custom parameter plat") public void
	 * C658712_Verify_cust_param_plat() throws Exception{ System.out.
	 * println("================= Custom Parameter Plat Verfication Started ========================="
	 * ); Custom_Parameters_Verification.parameters_Verification("plat");
	 * //validate_CustomParameter.sf.assertAll(); System.out.
	 * println("================= Custom Parameter Plat Verfication End ========================="
	 * ); }
	 */

	/*
	 * @Test(priority=5)
	 * 
	 * @Title("Verify custom parameter zip from UI") public void
	 * C333202_Verify_cust_param_Zip() throws Exception{ System.out.
	 * println("================= Custom Parameter Zip Verfication Verfication  from UI call Started ========================="
	 * ); Functions.Kill_launch(); Thread.sleep(5000);
	 * AppiumFunctions.entering_Zip();
	 * Custom_Parameters_Verification.parameters_Verification("Zip");
	 * CharlesFunctions.ExportSession();
	 * 
	 * System.out.
	 * println("================= Custom Parameter Zip Verfication  from turbo call UI End ========================="
	 * ); }
	 */

	/*
	
	
	
	
	
	*/

//not null validation	

	/*
	 * @Test(priority=1)
	 * 
	 * @Title("Verify custom parameter vw") public void
	 * C333210_Verify_cust_param_vw() throws Exception{ System.out.
	 * println("================= Custom Parameter Vw Verfication Started ========================="
	 * ); Custom_Parameters_Verification.parameters_Verification("vw"); System.out.
	 * println("================= Custom Parameter Vw Verfication End ========================="
	 * ); }
	 */

	/*
	 * @Test(priority=4)
	 * 
	 * @Title("Verify custom parameter a") public void C333235_Verify_cust_param_a()
	 * throws Exception{ System.out.
	 * println("================= Custom Parameter A Verfication Started ========================="
	 * ); Custom_Parameters_Verification.parameters_Verification("a"); System.out.
	 * println("================= Custom Parameter A Verfication End ========================="
	 * ); }
	 * 
	 * @Test(priority=5)
	 * 
	 * @Title("Verify custom parameter ch") public void
	 * C658714_Verify_cust_param_ch() throws Exception{ System.out.
	 * println("================= Custom Parameter Ch Verfication Started ========================="
	 * ); Custom_Parameters_Verification.parameters_Verification("ch"); System.out.
	 * println("================= Custom Parameter Ch Verfication End ========================="
	 * ); }
	 * 
	 * @Test(priority=6)
	 * 
	 * @Title("Verify custom parameter fam") public void
	 * C658715_Verify_cust_param_fam() throws Exception{ System.out.
	 * println("================= Custom Parameter Fam Verfication Started ========================="
	 * ); Custom_Parameters_Verification.parameters_Verification("fam"); System.out.
	 * println("================= Custom Parameter Fam Verfication End ========================="
	 * ); }
	 * 

	 * 
	 * @Test(priority=8)
	 * 
	 * @Title("Verify custom parameter layer") public void
	 * C333225_Verify_cust_param_layer() throws Exception{ System.out.
	 * println("================= Custom Parameter Layer Verfication Started ========================="
	 * ); Custom_Parameters_Verification.parameters_Verification("layer");
	 * System.out.
	 * println("================= Custom Parameter Layer Verfication End ========================="
	 * ); }
	 */



//Validating Hard code values

	 


	/*
	 * @Test(priority=29)
	 * 
	 * @Title("Verify custom parameter par") public void
	 * C658713_Verify_cust_param_par() throws Exception{ System.out.
	 * println("================= Custom Parameter Par Verfication Started ========================="
	 * ); Custom_Parameters_Verification.parameters_Verification("par"); System.out.
	 * println("================= Custom Parameter Par Verfication End ========================="
	 * ); }
	 */

//turbo call related test cases


  

	/*
	 * @Test(priority=78)
	 * 
	 * @Title("Verify custom parameter plln") public void
	 * C333201_Verify_cust_param_plln() throws Exception{ System.out.
	 * println("================= Custom Parameter Plln Verfication Started ========================="
	 * ); Custom_Parameters_Verification.parameters_Verification("plln");
	 * System.out.
	 * println("================= Custom Parameter Plln Verfication End ========================="
	 * ); }
	 */

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * //UI
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	/*
	 * @Test(priority=50)
	 * 
	 * @Title("Verify custom parameter bn") public void
	 * C456970_Verify_Parameter_BN() throws Exception{ System.out.
	 * println("================= Custom Parameter BN Verfication Started ========================="
	 * ); Custom_Parameters_Verification.parameters_Verification("bn"); System.out.
	 * println("================= Custom Parameter BN Verfication End ========================="
	 * ); }
	 */
	/*
	 * @Test(priority=51)
	 * 
	 * @Title("Verify custom parameter ") public void
	 * validating_env_values_backgroundlaunch() throws Exception{ System.out.
	 * println("================= validating_env_values_backgroundlaunch ========================="
	 * ); Ad.runAppInBackground(10);
	 * Custom_Parameters_Verification.parameters_Verification("env"); System.out.
	 * println("================= validating_env_values_backgroundlaunch ========================="
	 * ); }
	 */
	/*
	 * @Test(priority=51)
	 * 
	 * @Title("Verify custom parameter mlayer") public void
	 * C402798_Verify_Road_Conditions_Paramater_mlayer() throws Exception{
	 * System.out.
	 * println("================= Custom Parameter Mlayer Verfication Started ========================="
	 * ); Custom_Parameters_Verification.verify_mlayer_custom_parameters("mlayer");
	 * System.out.
	 * println("================= Custom Parameter Mlayer Verfication End ========================="
	 * ); }
	 */

	/*
	 * @Test(priority=52)
	 * 
	 * @Title("Verify custom parameter Env") public void
	 * C758746_Verify_cust_param_Env_pullToRefresh() throws Exception{ System.out.
	 * println("================= Custom Parameter Env Verfication for pull to refresh Starts ========================="
	 * ); Custom_Parameters_Verification.verify_custom_parameter_for_PullToReFresh(
	 * "Env"); System.out.
	 * println("================= Custom Parameter Env Verfication for pull to refresh Ends ========================="
	 * ); }
	 */

	/*
	 * @Test(priority=53)
	 * 
	 * @Title("Verify custom parameter Env after scrolling the app") public void
	 * C758747_Verify_cust_param_Env_afterScrollingApp() throws Exception{
	 * System.out.
	 * println("================= Custom Parameter Env Verfication after scrolling the app Starts ========================="
	 * ); Custom_Parameters_Verification.verify_custom_parameter_after_ScrollingApp(
	 * "Env"); System.out.
	 * println("================= Custom Parameter Env Verfication after scrolling the app Ends ========================="
	 * ); }
	 */
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

	/*
	 * @Test(priority=52)
	 * 
	 * @Title("Verify custom parameter Env") public void
	 * C758746_Verify_cust_param_Env() throws Exception{
	 * CharlesFunctions.charlesOpen(); // //AppiumFunctions.UnInstallApp();
	 * CharlesFunctions.openCharlesBrowser(); System.out.
	 * println("================= Custom Parameter Env Verfication for pull to refresh Starts ========================="
	 * ); Custom_Parameters_Verification.verify_custom_parameter_for_PullToReFresh(
	 * "Env"); System.out.
	 * println("================= Custom Parameter Env Verfication for pull to refresh Ends ========================="
	 * );
	 * 
	 * 
	 * System.out.
	 * println("================= Custom Parameter Env Verfication after scrolling the app Starts ========================="
	 * ); Custom_Parameters_Verification.verify_custom_parameter_after_ScrollingApp(
	 * "Env"); System.out.
	 * println("================= Custom Parameter Env Verfication after scrolling the app Ends ========================="
	 * );
	 * 
	 * 
	 * 
	 * System.out.
	 * println("================= Custom Parameter Env Verfication on minimize and relaunching the app Starts ========================="
	 * ); Custom_Parameters_Verification.
	 * verify_custom_parameter_on_minimize_and_relaunchingApp("Env"); System.out.
	 * println("================= Custom Parameter Env Verfication on minimize and relaunching the app Ends ========================="
	 * );
	 * 
	 * 
	 * 
	 * 
	 * System.out.
	 * println("================= Custom Parameter Env Verfication on_detailPage ========================="
	 * );
	 * Custom_Parameters_Verification.verify_custom_parameter_on_detailPage("Env");
	 * System.out.
	 * println("================= Custom Parameter Env Verfication on_detailPage ========================="
	 * ); }
	 */

	/*
	 * @Test(priority = 0,enabled=true) public void Verify_SlotID_foralltheads()
	 * throws Exception { Functions.get_aaxcals(); }
	 */

	/*
	 * @Test(priority=31)
	 * 
	 * @Title("Verify custom parameter zip") public void
	 * C333202_Verify_cust_param_zip1() throws Exception{ System.out.
	 * println("================= Custom Parameter Zip Verfication Started ========================="
	 * ); Custom_Parameters_Verification.parameters_Verification("zip");
	 * 
	 * System.out.
	 * println("================= Custom Parameter Zip Verfication End ========================="
	 * ); }
	 */

	
	
	
	
	
	
	
	
	
	
	
	
	  
	  
	  ////Interstail ads/////
	  
	  @Test(priority =600, enabled = false)
	  @Title("Verifying Hourly  details Interstal ads") 
	  public void Smoke_Test_Verify_Hourlydetails_interstial_ads() throws Exception {
	 System.out.println( "================= Verifying Hourly details Interstal ads test case  Started =========================");
	 //Functions.settheTimer(); // Functions.enable_QA_Usergroup(); //
	//  AppiumFunctions.Kill_Launch_App(); //AppiumFunctions.Kill_launch();
	  Thread.sleep(20000);
	 Ad.resetApp();
	  Thread.sleep(40000);
	  AppiumFunctions.clickONNext();
	  AppiumFunctions. ClickonIUnderstand();
	  AppiumFunctions.clickOnAllow();
	  CharlesFunctions.ClearSessions();
	  CharlesFunctions.startSessionBrowserData();
	  Thread.sleep(250000);
	  AppiumFunctions.click_hourly_element();
	  Functions.wiatfor5secindetails();
	  CharlesFunctions.ExportSessions();
	  Functions.Verify_hourly_detailpage_interstitial_adcall();
	  Functions.click_home_element();
	//  Ad.runAppInBackground(10);
	  Functions.handleInterstailads();
	  Functions.closeInterstailads();
	/*  Functions.settheTimer();
	  CharlesFunctions.ClearSessions();
	  CharlesFunctions.startSessionBrowserData();
	  AppiumFunctions.click_hourly_element();
	  Functions.wiatfor5secindetails();
	  CharlesFunctions.ExportSessions();
	  Functions.Verify_hourly_detailpage_interstitial_adcall1();
	  Functions.click_home_element(); 
	  Functions.handleInterstailads();
	 Functions.closeInterstailads();*/
	  
	  }
	  
	  @Title("Verifying daily  details Interstal ads")
	  @Test(priority = 601, enabled = false) public void
	  Smoke_Test_Verify_daily_details_interstial_ads() throws Exception {
	  System.out.
	  println("================= Verifying daily details Interstal ads test case  Started ========================="
	  );
	  Ad.resetApp();
	  Thread.sleep(40000);
	  AppiumFunctions.clickONNext();
	  AppiumFunctions. ClickonIUnderstand();
	  AppiumFunctions.clickOnAllow();
	  CharlesFunctions.ClearSessions();
	  CharlesFunctions.startSessionBrowserData();
	  Thread.sleep(25000);
	  AppiumFunctions.click_daily_element();
	  Functions.wiatfor5secindetails(); 
	  CharlesFunctions.ExportSessions();
	  Functions.Verify_daily_detailpage_interstitial_adcall();
	  Functions.click_home_element();
	//  Ad.runAppInBackground(10);
	  Functions.handleInterstailads();
	  Functions.closeInterstailads();
	 /* Functions.settheTimer();
	  CharlesFunctions.ClearSessions(); 
	  CharlesFunctions.startSessionBrowserData();
	  AppiumFunctions.click_daily_element();
	  Functions.wiatfor5secindetails();
	  CharlesFunctions.ExportSessions();
	  Functions.Verify_daily_detailpage_interstitial_adcall1();
	  Functions.click_home_element();
	  Functions.handleInterstailads();
	  Functions.closeInterstailads();*/
	  System.out.println("=================Verifying daily details Interstal ads test case  End =========================");
	  }
	  
	  
	 @Title("Verifying maps details Interstal ads")
	  @Test(priority = 602, enabled = false) public void
	  Smoke_Test_Verify_radar_details_interstial_ads() throws Exception {
	 System.out.println("================= Verifying maps details Interstal ads test case  Started =========================");
	 Ad.resetApp();
	  Thread.sleep(40000);
	  AppiumFunctions.clickONNext();
	  AppiumFunctions. ClickonIUnderstand();
	  AppiumFunctions.clickOnAllow();
	  CharlesFunctions.ClearSessions();
	  CharlesFunctions.startSessionBrowserData();
	  Thread.sleep(25000);
	  AppiumFunctions.SwipeUp_Counter_videos_maps(20);
	  Functions.wiatfor5secindetails();
	  CharlesFunctions.ExportSessions();
	  Functions.Verify_maps_detailpage_interstitial_adcall();
	//  Functions.click_home_element();
	//  Ad.runAppInBackground(10);
	  Functions.handleInterstailads();
	  Functions.closeInterstailads();
	/*  Functions.settheTimer();
	  CharlesFunctions.ClearSessions();
	  CharlesFunctions.startSessionBrowserData();
	  AppiumFunctions.SwipeUp_Counter_videos_maps(20);
	  CharlesFunctions.ExportSessions();
	  Functions.Verify_maps_detailpage_interstitial_adcall1();
	  Functions.click_home_element(); 
	  Functions.handleInterstailads();
	  Functions.closeInterstailads();	 */ 
	
	  System.out. println("=================Verifying maps details Interstal ads test case  End =========================" );
	  }
	  
	 @Title("Verifying video details Interstal ads")  
	  @Test(priority = 603, enabled = false) 
	  public void Smoke_Test_Verify_video_details_interstial_ads() throws Exception {
	 System.out.println("================= Verifying video details Interstal ads test case  Started =========================" );  
	 Ad.resetApp();
	 Thread.sleep(40000);
	  AppiumFunctions.clickONNext();
	  AppiumFunctions. ClickonIUnderstand();
	  AppiumFunctions.clickOnAllow();
	  CharlesFunctions.ClearSessions();
	  CharlesFunctions.startSessionBrowserData();
	  Thread.sleep(25000);
	  Functions.click_video_interstitial(); 
	  Functions.wiatfor5secindetails();
	  CharlesFunctions.ExportSessions();
	  Functions.Verify_video_detailpage_interstitial_adcall();
	  Functions.clickBackButtonAlerts(); 
	 // Ad.runAppInBackground(10);
	  Functions.handleInterstailads();
	  Functions.closeInterstailads();
	  /*Functions.settheTimer();
	  CharlesFunctions.ClearSessions(); 
	  CharlesFunctions.startSessionBrowserData();
	  AppiumFunctions.SwipeUp_Counter(15);
	  Functions.wiatfor5secindetails();
	  CharlesFunctions.ExportSessions();
	  Functions.Verify_video_detailpage_interstitial_adcall1();
	  Functions.clickBackButtonAlerts(); 
	  Functions.handleInterstailads();
	  Functions.closeInterstailads(); */
	  System.out.println("=================Verifying video details Interstal ads test case  End =========================" );
	  }
	 
	
	
	
	
	
	
	
	
	
	
	
	
	/*###### Push Notifications#######################################################*/
	
	
	 @Test(priority=500,enabled=false)  
	  @Title("Verifying Breaking news alert push notification") public void
	  Smoke_Test_Verify_Breakingnews_Alert_Pushnotification() throws Exception {
  	System.out.println("================= Verifying Breaking news alert push notification Started =========================");  // Functions.testmode_settings(); 

  	AppiumFunctions.Kill_Launch_App();
	//Functions.enable_Alert_Notifications_bn("Breaking News");
   Functions.clickAlerts();
 // Functions.click_BN();
     Functions.clickOnAlertType("breaking news alert");
  // Functions.clickOnRequiredPushNotification("breaking news alert");
	  Functions.swipefornotification();
	  CharlesFunctions.ClearSessions();
	  CharlesFunctions.startSessionBrowserData();
		  Functions.clickOnAlertNotificatons("Breaking News");
		  Thread.sleep(10000);
	//  Functions.clickNotification("Breaking");
	  CharlesFunctions.ExportSessions();
	  Functions.finding_BreakingNews_iu_value();
	  Functions.VerifyBNAlert();
	  System.out.println("================= Verifying Breaking news alert push notification End ========================="); 
	  }
	
	
	  
	 /* @Test(priority=501)
	  @Title("Verifying Winter breaking news alert push notification") 
	  public void Smoke_Test_WinterBreakingNews_Alert_Pushnotification() throws Exception {
	   System.out. println("================= Verifying Winter breaking news alert push notification Started =========================");
	   Functions.tapping();
	   AppiumFunctions.Kill_Launch_App(); 
	   Functions.clickAlerts(); 
	   Thread.sleep(3000);
	  AppiumFunctions.Swipe_feed();
	   Functions.clickOnAlertType("winter breaking news alert");
		//  Functions.clickOnAlertNotificatons("winter breaking news alert");
		  Functions.swipefornotification();
		  CharlesFunctions.ClearSessions();
		  CharlesFunctions.startSessionBrowserData();
		  Functions.clickOnAlertNotificatons("Breaking News");
	  CharlesFunctions.ExportSessions(); 
	  Functions.finding_BreakingNews_iu_value();
	  Functions.VerifyWBNAlert(); 
	  System.out.println("================= Verifying Winter breaking news alert push notification End =========================");
	  }*/
	 
	 
	  @Test(priority=502,enabled=false)  
	  @Title("Verifying Real time rain alert push notification") public void
	  Smoke_Test_Verify_Realtimerain_Alert_Pushnotification() throws Exception {
	  
	  System.out.
	  println("================= Verifying Real time rain alert push notificationStarted =========================" ); 
	  Functions.tapping();
	  AppiumFunctions.Kill_Launch_App();
	  Thread.sleep(3000);
	// Functions.enable_Alert_Notifications_rtr("Real-time rain");
	  Functions.clickAlerts();
	 // Functions.click_RTR();
	  Functions.clickOnAlertType("real time rain alert");
	 //  Functions.clickOnRequiredPushNotification("real time rain alert");
	 // Functions.clickOnRequiredPushNotification("real time rain alert");
	  Functions.swipefornotification();
	  CharlesFunctions.ClearSessions();
	  CharlesFunctions.startSessionBrowserData();
	  Functions.clickOnAlertNotificatons("Real-time rain");
	  CharlesFunctions.ExportSessions();
	  Functions.finding_Radar_Map_card_iu_value(); 
	  Functions.VerifyRTRAlert();
	  System.out.println("================= Verifying Real time rain alert push notification End =========================");
	  }
	
	  
	  
	/* @Test(priority=503,enabled=false)
	  @Title("Verifying real time lightning alert push notification")
	  public void Smoke_Test_Verify_RealtimeLightning_Alert_Pushnotification() throws Exception { 
		  System.out. println("================= Verifying real time lightning aler push notification Started ========================="); 
		  Functions.tapping();
		  AppiumFunctions.Kill_Launch_App(); 
		  Thread.sleep(3000);
		  Functions.enable_Alert_Notifications_light("Lightning strikes");
		  Functions.clickAlerts(); 
		  Functions.clickOnAlertType("real time lightning alert");
	  Functions.swipefornotification();
	  CharlesFunctions.ClearSessions();
	  CharlesFunctions.startSessionBrowserData();
	  Functions.clickOnAlertNotificatons("Lightning Strike");
	  CharlesFunctions.ExportSessions();
	  Functions.finding_Radar_Map_card_iu_value(); 
	  Functions.VerifyRTLAlert();
	  System.out.println("================= Verifying real time lightning alert push notification End ========================="
	  ); 
	  }*/

	  
	  
	  
	  
  @Test(priority=504,enabled=false)
	  
	  @Title("Verifying Thunderstorm alert push notification") public void
	  Smoke_Test_Verify_thunderstorm_Alert_Pushnotification() throws Exception {
	  System.out.
	  println("================= Verifying thunderstorm alert push notification Started =========================" ); 
	 // Thread.sleep(15000);
	  Functions.tapping();
	  AppiumFunctions.Kill_Launch_App(); 
	  Thread.sleep(15000);
	  Thread.sleep(15000);
	  //Functions.enable_Alert_Notifications("Significant weather forecast");
		Functions.enableSignificantweatherforecast_Notifications();
	  Functions.clickAlerts(); 
	  //Functions.click_thunderstorm();
	// Functions.clickOnRequiredPushNotification("thunderstorm alert");
	   Functions.clickOnAlertType("thunderstorm alert");
	  Functions.swipefornotification(); 
	  CharlesFunctions.ClearSessions();
	  CharlesFunctions.startSessionBrowserData();
	  Functions.clickOnAlertNotificatons("Thunderstorm");
	  CharlesFunctions.ExportSessions();
	  Functions.finding_hourly_details_card_iu_value();
	  Functions.Verifythunderstormalert(); 
	  System.out.println("================= Verifying thunderstorm alert push notification End =========================");
	  }
  

  @Test(priority=505,enabled=false)
  @Title("Verifying Heavy rain fall alert push notification") public void
  Smoke_Test_Verify_heavyrainfall_Alert_Pushnotification() throws Exception {
  System.out.
  println("================= Verifying heavy rain fall alert push notification Started =========================");
  Functions.tapping();
  AppiumFunctions.Kill_Launch_App();
  Thread.sleep(3000);
  Functions.clickAlerts(); 
  Functions.clickOnAlertType("heavy rainfall alert");
 //  Functions.clickOnAlertType("heavy rainfall alert");
  Functions.swipefornotification();
  CharlesFunctions.ClearSessions();
  CharlesFunctions.startSessionBrowserData();
  Functions.clickOnAlertNotificatons("Heavy Rainfall");
  CharlesFunctions.ExportSessions();
  Functions.finding_hourly_details_card_iu_value();
  Functions.Verifyheavyrainfallalert(); 
  System.out.println("================= Verifying heavy rain fall alert push notification End =========================");
  
  }

  @Test(priority=506,enabled=false)
  @Title("Verifying heavy snowfall alert push notification") public void
  Smoke_Test_Verify_heavysnowfall_Alert_Pushnotification() throws Exception {
  System.out.
  println("================= Verifying heavy snowfall alert push notification Started =========================");
  Functions.tapping();
  AppiumFunctions.Kill_Launch_App(); 
  Thread.sleep(3000);
  Functions.clickAlerts(); 
  Functions.clickOnAlertType("heavy snowfall alert");
  Functions.swipefornotification(); 
  CharlesFunctions.ClearSessions();
  CharlesFunctions.startSessionBrowserData();
  Functions.clickOnAlertNotificatons("Heavy Snowfall");
  CharlesFunctions.ExportSessions();
  Functions.finding_daily_details_card_iu_value();
  Functions.Verifyheavysnowfallalert();
System.out.println("================= Verifying heavy snowfall alert push notification End ========================="
  ); }
  
  
  
  
  @Test(priority=507,enabled=false)
  
  @Title("Verifying ice alert push notification") 
  public void Smoke_Test_Verify_ice_Alert_Pushnotification() throws Exception { 
	  System.out.println("================= Verifying ice alert push notification Started ========================= ");
	  Functions.tapping();
	  AppiumFunctions.Kill_Launch_App();
	  Thread.sleep(3000);
	  Functions.clickAlerts(); 
//  AppiumFunctions.SwipeUp_Counter(1);
	  Functions.clickOnAlertType("ice alert");
  Functions.swipefornotification();
  CharlesFunctions.ClearSessions();
  CharlesFunctions.startSessionBrowserData();
  Functions.clickOnAlertNotificatons("Ice");
  CharlesFunctions.ExportSessions();
  Functions.finding_daily_details_card_iu_value(); 
  Functions.Verifyicealert(); 
  System.out. println("================= Verifying ice alert push notification End =========================");
  }
  
  
  
  
  
  @Test(priority=508,enabled=false)
  @Title("Verifying Severe alert push notification") public void
  Smoke_Test_Verify_Severe_Alert_Pushnotification() throws Exception {
  System.out.
  println("================= Verifying Severe alert push notification Started =========================" ); 
  Functions.tapping();
  AppiumFunctions.Kill_Launch_App();
  Thread.sleep(3000);
  Functions.clickAlerts(); 
 // Functions.click_severe();
//  Functions.clickOnRequiredPushNotification("severe alert");
  Functions.clickOnAlertType("severe alert");
  Functions.swipefornotification();
  CharlesFunctions.ClearSessions();
  CharlesFunctions.startSessionBrowserData();
  Functions.clickOnAlertNotificatons("Severe");
  CharlesFunctions.ExportSessions();
  Functions.findind_alertsiu_value();
  Functions.VerifysevereAlert();
  System.out.println("================= Verifying Severe alert push notification End ========================="
  ); 
  }
	  

  


 
	
	
	 
	  
	  
	  
	  
	  
	  
	  
	  
     
	@BeforeTest
public void Before_Test() throws Exception {

		CharlesFunctions.charlesOpen();
	 AppiumFunctions.UnInstallApp();
		CharlesFunctions.openCharlesBrowser();
		// System.out.println("setting contentmode to normal");
		// MapLocalFunctions.contentModeModule("severe1");
//		read_excel_data.Clear_Exceldata();	    
	 CharlesFunctions.ClearSessions();
		CharlesFunctions.startSessionBrowserData();
		// CharlesFunctions.startSessionBrowserData();
		// AppiumFunctions.LaunchApp();
AppiumFunctions.LaunchAppWithFullReset();
CharlesFunctions.ClearSessions();
CharlesFunctions.startSessionBrowserData();
AppiumFunctions.Kill_Launch_App();
Thread.sleep(25000);
AppiumFunctions. ClickonIUnderstand();
Thread.sleep(10000);
AppiumFunctions.gettingApkVersion();
Thread.sleep(5000);
//CustomParamFunctions.get_fhic_floc_value();    
AppiumFunctions.SwipeUp_Counter(15);
Thread.sleep(15000);
AppiumFunctions.click_hourly_element();
 Thread.sleep(5000);
 AppiumFunctions.click_daily_element();
// AppiumFunctions.closeInterstailads();
CharlesFunctions.ExportSession();
		// CustomParamFunctions.get_fhic_floc_value();      
		//AppiumFunctions.SwipeUp_Counter(15);	
	 //AppiumFunctions.clickOnVideoElement();
		// AppiumFunctions.clickOnBackArrowElement();
		// AppiumFunctions.closeInterstailads();
		// Thread.sleep(3000);
		// AppiumFunctions.SwipeUp_Counter(2);
		// AppiumFunctions.clickOnRadarMaps();
		// AppiumFunctions.clickOnBackArrowElement();
		// AppiumFunctions.SwipeUp_Counter(4);
		// AppiumFunctions.click_Todaydetails_element();
//AppiumFunctions.clickOnBackArrowElement_today();
		// AppiumFunctions.SwipeUp_Counter(5);
		// AppiumFunctions.click_Airpollution_element();
		// AppiumFunctions.clickOnBackArrowElement();
		// AppiumFunctions.SwipeUp_Counter(1);
		// AppiumFunctions.click_news_element();
		// AppiumFunctions.clickOnBackArrowElement();
		// AppiumFunctions.click_hourly_element();
		// AppiumFunctions.click_home_element();
		// AppiumFunctions.click_daily_element();

		// CharlesFunctions.ExportSession();
//	Functions.verify_Road_Conditions("DDI");
		// Functions.CleanLaunch_launch("General");
		// CharlesFunctions.StopExportSessionXMLFile();

	}

	//@AfterTest
//	public void After_Test() throws Exception {
		// validate_CustomParameter.sf.assertAll();
		// DeleteFiles.deleteFiles(new Fi
		// le("/Users/monocept/Documents/workspace_luna/RegressionTest/ExpectedMapLocal/"));
		// DeleteFiles d = new DeleteFiles();
		// d.deleteFiles(new
		// File("/Users/monocept/Documents/workspace_luna/RegressionTest/ExpectedMapLocal/"));
		// DeleteFiles.delete(new
		// File("/Users/monocept/Documents/workspace_luna/RegressionTest/ExpectedMapLocal/"));
 	//CharlesFunctions.BrowserClosed();
	//CharlesFunctions.charlesClose();
	//Ad.quit();
	//}
}
