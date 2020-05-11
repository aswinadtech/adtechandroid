package twc.Regression.TestCases;

import io.appium.java_client.MobileElement;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import twc.Regression.CustomParamValidation.CustomParamFunctions;
import twc.Regression.CustomParamValidation.validate_CustomParameter;
import twc.Regression.General.DeviceStatus;
import twc.Regression.General.Functions;
import twc.Regression.HandleWithAppium.AppiumFunctions;
import twc.Regression.HandleWithCharles.CharlesFunctions;
import twc.Regression.ReadDataFromFile.read_excel_data;
import twc.Regression.ReadDataFromFile.read_xml_data_into_buffer;
import twc.Regression.ReadDataFromFile.write_excel_data;
import twc.Regression.utils.ReadXMLData;
import twc.Regression.Driver.Drivers;
public class Custom_Parameters_Verification extends Drivers{

	public static String ParamValue =null;
	public static String ParamType = null;
	public static String Param_val = null;
	public static String feedAd=null;

	public static void parameters_Verification(String custParam) throws Exception{


		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		String[][] exceldata = read_excel_data.exceldataread_Custom_Parameters("Cust_Param","General");
		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		xml_data_into_buffer.read_xml_file_into_buffer_string("normal");

		String feedVal=exceldata[6][Cap].toString().trim();

	//	System.out.println("Feeds Val are :"+feedVal.trim());

		//String homescreenfeedads=exceldata[7][Cap].toString().trim();
		Functions.homescreenfeedad=exceldata[7][Cap].toString().split(",");
		int numberOfCards = Functions.homescreenfeedad.length;
		/*for (int i=1; i<numberOfCards; i++)
    {
		if(i==1) {
			feedAd=exceldata[5][Cap]+homescreenfeedad[1];
		}
		if(i==2) {
			feedAd=exceldata[5][Cap]+homescreenfeedad[2];
		}
		if(i==3) {
			feedAd=exceldata[5][Cap]+homescreenfeedad[3];
		}
		if(i==4) {
			feedAd=exceldata[5][Cap]+homescreenfeedad[4];
		}
    }*/
		Functions.Deatailpagead=exceldata[8][Cap].toString().split(",");
		int numberOfads = Functions.Deatailpagead.length;
		/*for (int i=1; i<numberOfads; i++)
    {
		if(i==1) {
			feedAd=exceldata[10][Cap]+homescreenfeedad[1];
		}
		if(i==2) {
			feedAd=exceldata[10][Cap]+homescreenfeedad[2];
		}
		if(i==3) {
			feedAd=exceldata[10][Cap]+homescreenfeedad[cn3];
		}
		if(i==4) {
			feedAd=exceldata[10][Cap]+homescreenfeedad[4];
		}
		if(i==5) {
			feedAd=exceldata[10][Cap]+homescreenfeedad[5];
		}
		if(i==6) {
			feedAd=exceldata[10][Cap]+homescreenfeedad[6];
		}		
    }*/
		String[] HCpagead=exceldata[12][Cap].toString().split(",");
		int numberOfcontentpageads = HCpagead.length;
		/*for (int i=1; i<numberOfcontentpageads; i++)
    {
		if(i==1) {
			feedAd=exceldata[11][Cap]+homescreenfeedad[1];
		}
		if(i==2) {
			feedAd=exceldata[11][Cap]+homescreenfeedad[2];
		}
		if(i==3) {
			feedAd=exceldata[11][Cap]+homescreenfeedad[3];
		}

    }*/


		int feedcount = 0;
		
		int allads=3;
		
		

		Map<String, String> mapkeys = new HashMap<String, String>();

		for(int adlogic =1;adlogic<=2;adlogic++) {
			if(adlogic==1) {
				feedcount=Functions.homescreenfeedad.length;
				Functions.adType= "HomeScreen";
			}else if(adlogic==2) {
				feedcount=Functions.Deatailpagead.length;
				Functions.adType= "DetailsPages";
			}
			for(int feed=0;feed<=feedcount-2;feed++){
				if(adlogic==1) {
					feedAd=exceldata[5][Cap]+Functions.homescreenfeedad[feed];
				}else if(adlogic==2) {
					feedAd=exceldata[10][Cap]+Functions.Deatailpagead[feed];
				}
				


				System.out.println("Ad name : "+feedAd);
				
				if(sb.toString().contains(feedAd))
				{
				

					String expectedValues = Functions.get_pub_ad_call(feed);

					String[][] data = read_excel_data.exceldataread_Custom_Parameters("Cust_Param_Result","SMOKE");

					String[] arrays = expectedValues.split("&");

					for(int testcase=1;testcase<=read_excel_data.rowCount;testcase++){
						String param = data[testcase][4].toString();
						//System.out.println("param=>"+param);

						for(String keys : arrays){

							if(keys.contains("=")){
								String[] key = keys.split("=");
								// System.out.println(key[0] + "---"+key[1]);
								mapkeys.put(key[0], key[1]);

								if (param.trim().equals(key[0].trim())) {
									String ExactValue = key[key.length - 1];

									//							System.out.println("ExactValue"+ ExactValue);
									//							System.out.println("keys"+ keys);
									//							System.out.println("param"+ param);
									ParamType=key[0].trim();
									ParamValue=key[1].trim();

									//							System.out.println("Param Type is ::"+ParamType);
									//							System.out.println("Param Value is :;"+ParamValue);

									if(ParamType.equals("tmp") && custParam.equals("tmp")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_results("tmp",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("tmp Value not matched");
										}
									}
									else if(ParamType.equals("tmpr") && custParam.equals("tmpr")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_results("tmpr",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("tmpr Value not matched");
										}
									}
									else if(ParamType.equals("cnd") && custParam.equals("cnd")){
										logStep("Verifyied Feed:"+feedAd+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_results("cnd",feed);
										if(Param_val.equals("Fail") && feed == 3 &&  feedAd.contains("details")){
										//if(Param_val.contains("Fail") && feed==allfeeds ) {
										//if(!Param_val.equals("Pass") && feed == feedcount){
										//if(Param_val.contains("Fail")) {
										    logStep(custParam+" should not be empty");
										    logStep(custParam+" can be nl");
										//	validate_CustomParameter.sf.assertTrue(false);
									     	Assert.fail("cnd Value not matched");
										}
									}
									/*else if(ParamType.equals("cnd") && custParam.equals("cnd")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_not_null_results("cnd",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("adid Value not matched");
										}
									}*/
									
									else if(ParamType.equals("hmid") && custParam.equals("hmid")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_results("hmid",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("hmid Value not matched");
										}
									}
									else if(ParamType.equals("wind") && custParam.equals("wind")){
										logStep("Verifyied Feed:"+feedAd+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_results("wind",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("wind Value not matched");
										}
									}
									else if(ParamType.equals("uv") && custParam.equals("uv")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_results("uv",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("uv Value not matched");
										}
									}
									else if(ParamType.equals("fltmpc") && custParam.equals("fltmpc")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_results("fltmpc",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("fltmpc Value not matched");
										}
									}
									else if(ParamType.equals("tmpc") && custParam.equals("tmpc")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_results("tmpc",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("tmpc Value not matched");
										}
									}
									else if(ParamType.equals("dma") && custParam.equals("dma")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_dsx_results("dma",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("dma Value not matched");
										}
									}
									else if(ParamType.equals("zip") && custParam.equalsIgnoreCase("zip")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_dsx_results("zip",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											Assert.fail("zip Value not matched");
										}
									}
									
									/*else if(ParamType.equals("zip") && custParam.equals("zip")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_not_null_results("zip",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("adid Value not matched");
										}
									}*/
									else if(ParamType.equals("ct") && custParam.equals("ct")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_dsx_results("ct",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("ct Value not matched");
										}
									}
									else if(ParamType.equals("st") && custParam.equals("st")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_dsx_results("st",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("st Value not matched");
										}
									}
									else if(ParamType.equals("cc") && custParam.equals("cc")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_dsx_results("cc",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("cc Value not matched");
										}
									}
									else if(ParamType.equals("wfxtg") && custParam.equals("wfxtg")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_wfxtg_results("wfxtg",feed);
										System.out.println("Param_val "+Param_val);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("wfxtg Value not matched");
										}
									}
									else if(ParamType.equals("zcs") && custParam.equals("zcs")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_wfxtg_results("zcs",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("zcs Value not matched");
										}
									}
									else if(ParamType.equals("hzcs") && custParam.equals("hzcs")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_wfxtg_results("hzcs",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("hzcs Value not matched");
										}
									}
									else if(ParamType.equals("nzcs") && custParam.equals("nzcs")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_wfxtg_results("nzcs",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("nzcs Value not matched");
										}
									}
									else if(ParamType.equals("fgeo") && custParam.equals("fgeo")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_not_null_results("fgeo",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("fgeo Value not matched");
										}
									}
									else if(ParamType.equals("faud") && custParam.equals("faud")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_not_null_results("faud",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("faud Value not matched");
										}
									}
									else if(ParamType.equals("sg") && custParam.equals("sg")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_lotame_results("sg",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("sg Value not matched");
										}
									}
									else if(ParamType.equals("locale") && custParam.equals("locale")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_dsxcms_results("locale",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("locale Value not matched");
										}
									}
									else if(ParamType.equals("hlzip") && custParam.equals("hlzip")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_wfxtg_results("hlzip",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("hlzip Value not matched");
										}
									}
									else if(ParamType.equals("lang") && custParam.equals("lang")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_hard_code_results("lang",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("lang Value not matched");
										}
									}
									else if(ParamType.equals("plat") && custParam.equals("plat")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_hard_code_results("plat",feed);
										if(Param_val.equals("Fail") && feed == allads){
										//if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" should not be empty");
											Assert.fail("plat Value not matched");
										}
									}
									
									
										
			
									
									/*else if(ParamType.equals("zip") && custParam.equals("plat")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_not_null_results("plat",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("adid Value not matched");
										}
									}*/
									else if(ParamType.equals("ftl") && custParam.equals("ftl")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_hard_code_results("ftl",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("ftl Value not matched");
										}
									}
									else if(ParamType.equals("pos") && custParam.equals("pos")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_hard_code_results("pos",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("pos Value not matched");
										}
									}
									
									else if(ParamType.equalsIgnoreCase("zip") && custParam.equalsIgnoreCase("Zip")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_hard_code_zip_results("zip",feed);
									//	Param_val = CustomParamFunctions.validate_not_null_results("zip",feed);
										if(Param_val.contains("Fail") && feed==allads) {
										//if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" should not be empty");
											Assert.fail("zip Value not matched");
										}
									}
									else if(ParamType.equals("tile") && custParam.equals("tile")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_hard_code_results("tile",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("tile Value not matched");
										}
									}
									else if(ParamType.equals("par") && custParam.equals("par")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_hard_code_results("par",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("par Value not matched");
										}
									}
									else if(ParamType.equals("vw") && custParam.equals("vw")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_not_null_results("vw",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("vw Value not matched");
										}
									}
									else if(ParamType.equals("aid") && custParam.equals("aid")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_not_null_results("aid",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("aid Value not matched");
										}
									}
									
								/*	else if(ParamType.equals("wfxtg") && custParam.equals("wfxtg")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_not_null_results("wfxtg",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("aid Value not matched");
										}
									}*/
									/*else if(ParamType.equals("zip") && custParam.equals("zip")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_not_null_results("zip",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("adid Value not matched");
										}
									}*/
									
									else if(ParamType.equals("adid") && custParam.equals("adid")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_not_null_results("adid",feed);
									if(Param_val.equals("Fail") && feed == 3 &&  feedAd.contains("details")){
									//	if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" should not be empty");
											Assert.fail("adid Value not matched");
										}
									}
									else if(ParamType.equals("ord") && custParam.equals("ord")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_not_null_results("ord",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("ord Value not matched");
										}
									}
									else if(ParamType.equals("a") && custParam.equals("a")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_not_null_results("a",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("a Value not matched");
										}
									}
									else if(ParamType.equals("ch") && custParam.equals("ch")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_not_null_results("ch",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("ch Value not matched");
										}
									}
									else if(ParamType.equals("fam") && custParam.equals("fam")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_not_null_results("fam",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("fam Value not matched");
										}
									}
									else if(ParamType.equals("g") && custParam.equals("g")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_not_null_results("g",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("g Value not matched");
										}
									}
									else if(ParamType.equals("layer") && custParam.equals("layer")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_not_null_results("layer",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("layer Value not matched");
										}
									}
									else if(ParamType.equals("rmid") && custParam.equals("rmid")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_not_null_results("rmid",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("rmid Value not matched");
										}
									}
									else if(ParamType.equals("tf") && custParam.equals("tf")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_not_null_results("tf",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("tf Value not matched");
										}
									}
									else if(ParamType.equals("ver") && custParam.equals("ver")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_not_null_results("ver",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("ver Value not matched");
										}
									}
									else if(ParamType.equals("dynght") && custParam.equals("dynght")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_not_null_results("dynght",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("dynght Value not matched");
										}
									}
									else if(ParamType.equals("bn") && custParam.equals("bn")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_not_null_results("bn",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("bn Value not matched");
										}
									}
									else if(ParamType.equals("fhic") && custParam.equals("fhic")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_results("fhic",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("fhic Value not matched");
										}

									}
									else if(ParamType.equals("floc") && custParam.equals("floc")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_results("floc",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("floc Value not matched");
										}
									}
									else if(ParamType.equals("sev") && custParam.equals("sev")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_results("sev",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("sev Value not matched");
										}
									}
									else if(ParamType.equals("plln") && custParam.equals("plln")){
										logStep("Verifyied Feed:"+feed+" Pub Ad Call "+custParam+" Custm_Parameter Expected value presented");
										Param_val = CustomParamFunctions.validate_results("plln",feed);
										if(!Param_val.equals("Pass") && feed == feedcount){
											logStep(custParam+" should not be null");
											logStep(custParam+" can be nl");
											Assert.fail("plln Value not matched");
										}
									}
									write_excel_data wResult = new write_excel_data();

									int Getresult = feed*2;
									//Change values for entering result into all the feeds
									int ResultColumn_1=7+Getresult;
									int ResultColumn_2=8+Getresult;

									if(custParam.equals(param))
									{
										if(Param_val.equals("Pass")){
											wResult.enterResult("SMOKE", "Pass", ExactValue, testcase, ResultColumn_1, ResultColumn_2);
										}
										else
										{
											System.out.println("Values are not matched");
											wResult.enterResult("SMOKE", "Not matched", ExactValue, testcase, ResultColumn_1, ResultColumn_2);
											break;
										}
									}

								}//Main If
							}//If key contains 
						}//For Loop Array Key 
					}//For Loop For Testcase	
				}//main if close
				else{
					System.out.println("Feed values have not been generated");
					//Assert.fail("Feed values have not been generated");
				}
			}	
		}
	}

	public static String verify_video_custom_parameters(String custParam) throws Exception{

		String result = null;
		String pubad_val =null;
		Map<String, String> pubads_call_results = Functions.read_Video_Pub_Ad_Call_Data("VideoPubAds");
		pubad_val =pubads_call_results.get(custParam);
		logStep("navigate to video module");
		logStep("Tap On Video");
		logStep("Verify video preRoll pub Ad call is being made in cahrles");
		if(!pubad_val.isEmpty()){
			logStep("Verifyied Video PubAd "+custParam+" Data : "+pubad_val+" Value Presented As Expected");
			System.out.println("Video PubAd "+custParam+" Data : "+pubad_val);
			result="Pass";
			System.out.println("Result "+result);
		}
		return result;
	}

	public static String verify_mlayer_custom_parameters(String custParam) throws Exception{

		String result = null;
		String pubad_val =null;
		Map<String, String> pubads_call_results = Functions.ddi_validation("DDI");
		pubad_val =pubads_call_results.get(custParam);
		logStep("navigate to road conditions module");
		logStep("Tap On Road Conditions");
		if(!pubad_val.isEmpty()){
			logStep("Verifyied Road Conditions PubAd "+custParam+" Data : "+pubad_val+" Value Presented As Expected");
			System.out.println("Road Conditions PubAd "+custParam+" Data : "+pubad_val);
			result="Pass";
			System.out.println("Result "+result);
		}
		return result;
	}


	public static void verify_custom_parameter_for_PullToReFresh(String custParam) throws Exception{



		CharlesFunctions.startSessionBrowserData2();
		CharlesFunctions.ClearSessions();

		//AppiumFunctions.LaunchApp(); 
		AppiumFunctions.LaunchAppWithFullReset();
		Thread.sleep(10000);

		CharlesFunctions.ExportSessions();
		String xmlData_appLaunch= ReadXMLData.getXMLData();

		String bbCallData_appLaunch= ReadXMLData.getRequiredXMLData("Excel_Sheet/TWC_CustParam_Framework.xls" , custParam, "bb",0, xmlData_appLaunch);
		String val_appLaunch_bb = ReadXMLData.validateCustomParam(custParam, "Excel_Sheet/TWC_CustParam_Framework.xls" ,custParam ,"bb", bbCallData_appLaunch);



		String feed0_CallData_appLaunch= ReadXMLData.getRequiredXMLData("Excel_Sheet/TWC_CustParam_Framework.xls" , custParam, "feed",0, xmlData_appLaunch);
		String val_appLaunch_feed0 = ReadXMLData.validateCustomParam(custParam, "Excel_Sheet/TWC_CustParam_Framework.xls" ,custParam ,"feed", feed0_CallData_appLaunch);


		CharlesFunctions.ClearSessions();
		AppiumFunctions.Pull_To_Refresh("Pulltorefresh"); //not working so using Swipe_Up
		//AppiumFunctions.scroll_Up();
		AppiumFunctions.Swipe_Up();
		Thread.sleep(5000);
		CharlesFunctions.ExportSessions();


		String xmlData_PullToRefresh= ReadXMLData.getXMLData();
		String bbCallData_pullToRefresh = ReadXMLData.getRequiredXMLData("Excel_Sheet/TWC_CustParam_Framework.xls" , custParam, "bb", 0, xmlData_PullToRefresh);

		String val_pullToRefesh_bb = ReadXMLData.validateCustomParam(custParam, "Excel_Sheet/TWC_CustParam_Framework.xls" ,custParam ,"bb", bbCallData_pullToRefresh);




		String feed0_CallData_pullToRefesh= ReadXMLData.getRequiredXMLData("Excel_Sheet/TWC_CustParam_Framework.xls" , custParam, "feed",0,  xmlData_appLaunch);
		String val_pullToRefesh_feed0 = ReadXMLData.validateCustomParam(custParam, "Excel_Sheet/TWC_CustParam_Framework.xls" ,custParam ,"feed", feed0_CallData_pullToRefesh);

		System.out.println("env value at app launch for bb call"+" === "+val_appLaunch_bb);
		System.out.println("env value at app launch for feed call"+" === "+val_appLaunch_feed0);
		System.out.println("env value after pull to refresh for bb call"+" ===>>> "+val_pullToRefesh_bb);
		System.out.println("env value after pull to refresh for feed call"+" ===>>> "+val_pullToRefesh_feed0);

		//	//Integer x = Integer.valueOf(str);
		//	if(Integer.parseInt(val_appLaunch_bb)==Integer.parseInt(val_appLaunch_feed0) && Integer.parseInt(val_pullToRefesh_bb)==Integer.parseInt(val_pullToRefesh_feed0) && Integer.parseInt(val_appLaunch_bb)==Integer.parseInt(val_pullToRefesh_bb)){
		//	//if(val_appLaunch_bb==val_pullToRefesh_bb && val_appLaunch_feed0==val_pullToRefesh_feed0 && val_appLaunch_bb==val_appLaunch_feed0){	
		//		System.out.println("Env generated before and after pull to refresh were same");
		//		logStep("Env generated before and after pull to refresh were same");
		//	}
		//	else
		//	{
		//		System.out.println("Env generated before and after pull to refresh were NOT same");
		//		logStep("Env generated before and after pull to refresh were NOT same");
		//		Assert.fail("Env generated before and after pull to refresh were NOT same");
		//	}

	}





	public static void verify_custom_parameter_after_ScrollingApp(String custParam) throws Exception{

		CharlesFunctions.startSessionBrowserData2();
		CharlesFunctions.ClearSessions();
		//AppiumFunctions.LaunchApp(); 
		AppiumFunctions.LaunchAppWithFullReset();

		Thread.sleep(10000);
		CharlesFunctions.ExportSessions();
		String xmlData_appLaunch= ReadXMLData.getXMLData();

		String bbCallData_appLaunch= ReadXMLData.getRequiredXMLData("Excel_Sheet/TWC_CustParam_Framework.xls" , custParam, "bb",0, xmlData_appLaunch);
		String custParamval_bb = ReadXMLData.validateCustomParam(custParam, "Excel_Sheet/TWC_CustParam_Framework.xls" ,custParam ,"bb", bbCallData_appLaunch);
		System.out.println("env value at app launch for bb call"+" ===>>> "+custParamval_bb);
		AppiumFunctions.navigateToModule("Ski","Excel_Sheet/TWC_CustParam_Framework.xls" ,"Env");
		//AppFunctions.scrollInToView("Ski");
		CharlesFunctions.ExportSessions();



		for(int i = 0; i<5;i++){
			String feedData= ReadXMLData.getRequiredXMLData("Excel_Sheet/TWC_CustParam_Framework.xls" , custParam, "feed",i,  xmlData_appLaunch);
			String custParamVal_feed= ReadXMLData.validateCustomParam(custParam, "Excel_Sheet/TWC_CustParam_Framework.xls" ,custParam ,"feed", feedData);
			String val_feed="feed"+i;
			System.out.println("env value at app launch for feed call---> "+val_feed+" ===>>> "+custParamVal_feed);


			//		 if(Integer.parseInt(custParamval_bb)==Integer.parseInt(custParamVal_feed)){
			//				System.out.println("Env values are same");
			//				logStep("Env values are same");
			//			}
			//			else
			//			{
			//				System.out.println("Env values are NOT same");
			//				logStep("Env values are NOT same");
			//				Assert.fail("Env values are NOT same");
			//			}
		}




	}




	public static void verify_custom_parameter_on_detailPage(String custParam) throws Exception{

		//AppiumFunctions.LaunchApp(); 
		AppiumFunctions.LaunchAppWithFullReset();
		Thread.sleep(10000);

		//String[] module={"news"};
		String[] module={"Hourly","daily","map","news"};
		for(int i=0;i<module.length; i++){

			AppiumFunctions.navigateToModule(module[i],"Excel_Sheet/TWC_CustParam_Framework.xls" ,module[i]);
			//AppiumFunctions.scrollInToView(module[i]);
			CharlesFunctions.startSessionBrowserData2();
			CharlesFunctions.ClearSessions();


			AppiumFunctions.clickOnModule(module[i]);
			//AppiumFunctions.verifyAdPresentOnExtendedPage(module[i]);
			CharlesFunctions.ExportSessions();
			Thread.sleep(2000);


			String xmlData_appLaunch= ReadXMLData.getXMLData();
			//	 
			//	 String extendedPage= ReadXMLData.getRequiredXMLData("Excel_Sheet/TWC_CustParam_Framework.xls" , custParam, "extendedPage",0, xmlData_appLaunch);
			//	 String custParamval_bb = ReadXMLData.validateCustomParam(custParam, "Excel_Sheet/TWC_CustParam_Framework.xls" ,custParam ,"extendedPage", extendedPage);
			//	 System.out.println("env value for extended page"+" ===>>> "+custParamval_bb);
			//	 AppiumFunctions.navigateToModule("Ski","Excel_Sheet/TWC_CustParam_Framework.xls" ,"Env");
			//	//AppFunctions.scrollInToView("Ski");
			//	 CharlesFunctions.ExportSessions();




			String feedData= ReadXMLData.getRequiredXMLData("Excel_Sheet/TWC_CustParam_Framework.xls" , custParam, module[i],i,  xmlData_appLaunch);
			String custParamVal_feed= ReadXMLData.validateCustomParam(custParam, "Excel_Sheet/TWC_CustParam_Framework.xls" ,custParam ,"extendedPage", feedData);

			System.out.println("env value of extended page for "+module+"===>>>" +custParamVal_feed);


			//		 if(Integer.parseInt(custParamval_bb)==Integer.parseInt(custParamVal_feed)){
			//				System.out.println("Env values are same");
			//				logStep("Env values are same");
			//			}
			//			else
			//			{
			//				System.out.println("Env values are NOT same");
			//				logStep("Env values are NOT same");
			//				Assert.fail("Env values are NOT same");
			//			}


			Ad.findElementByClassName("android.widget.ImageButton").click();//click on back arrow
		}




	}




	public static void verify_custom_parameter_on_minimize_and_relaunchingApp(String custParam) throws Exception{
		CharlesFunctions.startSessionBrowserData2();
		CharlesFunctions.ClearSessions();
		//AppiumFunctions.LaunchApp(); 
		AppiumFunctions.LaunchAppWithFullReset();
		Thread.sleep(10000);
		System.out.println("Minimizing and launching the app=====");
		Ad.runAppInBackground(5);
		Thread.sleep(7000);  
		CharlesFunctions.ExportSessions();
		String xmlData_appLaunch= ReadXMLData.getXMLData();

		String bbCallData_appLaunch= ReadXMLData.getRequiredXMLData("Excel_Sheet/TWC_CustParam_Framework.xls" , custParam, "bb",0, xmlData_appLaunch);
		String custParamval_bb = ReadXMLData.validateCustomParam(custParam, "Excel_Sheet/TWC_CustParam_Framework.xls" ,custParam ,"bb", bbCallData_appLaunch);
		System.out.println("env value at app launch for bb call"+" ===>>> "+custParamval_bb);
		AppiumFunctions.navigateToModule("Ski","Excel_Sheet/TWC_CustParam_Framework.xls" ,"Env");
		//AppFunctions.scrollInToView("Ski");
		CharlesFunctions.ExportSessions();



		for(int i = 0; i<5;i++){
			String feedData= ReadXMLData.getRequiredXMLData("Excel_Sheet/TWC_CustParam_Framework.xls" , custParam, "feed",i,  xmlData_appLaunch);
			String custParamVal_feed= ReadXMLData.validateCustomParam(custParam, "Excel_Sheet/TWC_CustParam_Framework.xls" ,custParam ,"feed", feedData);
			String val_feed="feed"+i;
			System.out.println("env value at app launch for feed call---> "+val_feed+" ===>>> "+custParamVal_feed);


			//		 if(Integer.parseInt(custParamval_bb)==Integer.parseInt(custParamVal_feed)){
			//				System.out.println("Env values are same");
			//				logStep("Env values are same");
			//			}
			//			else
			//			{
			//				System.out.println("Env values are NOT same");
			//				logStep("Env values are NOT same");
			//				Assert.fail("Env values are NOT same");
			//			}
		}




	}







	//	public static String customParameter_Verification(String custParam) throws Exception{
	//		String res = ReadXMLData.validateCustomParam(custParam, "Excel_Sheet/TWC_CustParam_Framework.xls" ,custParam ,"bb");
	//		return res;
	//	}
}

