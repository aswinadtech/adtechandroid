package twc.Regression.General;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.security.PublicKey;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.naming.spi.ObjectFactoryBuilder;
import javax.net.ssl.HostnameVerifier;

import junit.framework.ComparisonFailure;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import com.Genaral.readExcelValues;
//import com.weather.excel.ExcelData;
//import com.weather.excel.Write_result;

import twc.Regression.General.DeviceStatus;
import twc.Regression.HandleWithAppium.AppiumFunctions;

import twc.Regression.Driver.Drivers;
import twc.Regression.ReadDataFromFile.read_excel_data;
import twc.Regression.ReadDataFromFile.read_xml_data_into_buffer;
import twc.Regression.ReadDataFromFile.write_excel_data;
import twc.Regression.utils.ReadExcelData;

public class Functions extends Drivers{

	static int startY;
	static int endY;
	MobileElement skiModule=null;
	MobileElement AllergyModule=null;
	static WebElement coldFluModule =null;
	public static ArrayList<String> aaxSlots = new ArrayList<String>();
	public static String[] homescreenfeedad;
	public static String[] Deatailpagead;
	public static String adType;
	  public static final int maxTimeout = 60;
	public static void validate_API_Call_With_PubAds_Call(String excel_sheet_name) throws Exception{

		String apicall_results=null;
		String pubadscall_results=null;

		Map<String, String> api_call_results = read_API_Call_Data(excel_sheet_name);
		Map<String, String> pubads_call_results = read_Pub_Ad_Call_Data(excel_sheet_name);
		//System.out.println(api_call_results);
		//System.out.println(pubads_call_results);
		if(api_call_results.keySet().size() == 1){

			for (String key : api_call_results.keySet()) {
				//System.out.println("key: " + key + " value: " + api_call_results.get(key));
				apicall_results = api_call_results.get(key).toString().replace("[", "").replace("]", "");
				//System.out.println(apicall_results);
			}
			for (String pubkey : pubads_call_results.keySet()) {
				//System.out.println("key: " + pubkey + " value: " + pubads_call_results.get(pubkey));
				pubadscall_results = pubads_call_results.get(pubkey).toString().replace("[", "").replace("]", "");
				//System.out.println(pubadscall_results);
			}

			String[] pubadsresults = pubadscall_results.split(",");
			for(int i=0;i<pubadsresults.length;i++){
				if(apicall_results.contains(pubadsresults[i])){
					System.out.println("Matched With "+ pubadscall_results +" :::: " + pubadsresults[i]);
				}
				else{
					System.out.println("Does Not Matched With "+ pubadscall_results +" :::: " + pubadsresults[i]);
				}
			}

		}
		else{

			for (String key : api_call_results.keySet()) {
				//System.out.println("key: " + key + " value: " + api_call_results.get(key));
				apicall_results = api_call_results.get(key).toString().replace("[", "").replace("]", "");
				//ystem.out.println(apicall_results);
			}
			for (String pubkey : pubads_call_results.keySet()) {
				//System.out.println("key: " + pubkey + " value: " + pubads_call_results.get(pubkey));
				pubadscall_results = pubads_call_results.get(pubkey).toString().replace("[", "").replace("]", "");
				//System.out.println(pubadscall_results);

				String[] pubadsresults = pubadscall_results.split(",");
				//////////////////////////////////////////
				for(int i=0;i<pubadsresults.length;i++){
					if(!pubads_call_results.get(pubkey).equals("nl")){
						if(api_call_results.get(pubkey).contains(pubadsresults[i])){
							System.out.println("Matched With "+ pubads_call_results.get(pubkey) +" :::: " + pubadsresults[i]);
						}
						else{
							System.out.println("Does Not Matched With "+ pubads_call_results.get(pubkey) +" :::: " + pubadsresults[i]);
							Assert.fail("Does Not Matched With "+ pubads_call_results.get(pubkey) +" :::: " + pubadsresults[i]);
						}
					}
					else{
						System.out.println("Getting nl value for "+pubkey+" from pubads call");
					}
				}
			}
		}
	}
	public static Map<String , String>  read_API_Call_Data(String excel_sheet_name) throws Exception{
		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		Map<String , String> expected_map_results = new HashMap<String, String>();
		ArrayList<String> expected_Values_List = new ArrayList<String>();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		String validateValues = exceldata[11][Cap];
		String[] validate_Values = validateValues.split(",");


		//		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		//		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

		String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[2][Cap]));
		String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[3][Cap]));

		String expected_data = required_info.toString().substring(required_info.indexOf(exceldata[4][Cap])+7,required_info.indexOf(exceldata[5][Cap]));
		String expectedValues = expected_data.toString();

		if(validate_Values.length == 1){

			if(expected_data.toString().contains(exceldata[11][Cap])){

				String expecteddata = expected_data.substring(expected_data.indexOf("[")+1,expected_data.indexOf("]")-1);
				System.out.println("Expected Data ::"+expecteddata);

				String[] expecteddata_into_arrays = expecteddata.split("},");
				String[] expectedValue = null;
				for(String dataKeys:expecteddata_into_arrays)
				{

					expectedValue =dataKeys.split(",");

					for(String ExpectedValuesKey:expectedValue)
					{
						if(ExpectedValuesKey.contains(exceldata[12][Cap]))
						{
							String replaceWith = ExpectedValuesKey.toString().replace("{", "").trim();

							String[] contentkey = replaceWith.toString().split(",");
							String expected_key = contentkey[0].replaceAll("^\"|\"$","");
							String[] contentvalue = expected_key.split(":");
							String expected_results =contentvalue[1].replaceFirst("^\"|\"$","");
							expected_Values_List.add(expected_results);
							if(expected_key.contains(""))
							{
								Assert.assertNotNull(expected_key);
							}
						}
					}
				}
			}
			expected_map_results.put(exceldata[12][Cap], expected_Values_List.toString());
		}
		else{

			String validateSecondValues = exceldata[12][Cap];
			String[] validate_Second_Values = validateSecondValues.split(",");
			List<String> fgeo_res = new ArrayList<String>();
			List<String> faud_res = new ArrayList<String>();

			JSONParser parser = new JSONParser();
			Object obj = parser.parse(expectedValues);
			JSONObject jsonObject = (JSONObject) obj;

			JSONArray fgeoval = (JSONArray) jsonObject.get(validate_Values[0]);
			for(int i=0;i< fgeoval.size();i++){

				JSONObject filter = (JSONObject) fgeoval.get(i);
				if(filter.containsKey(validate_Second_Values[0])){
					fgeo_res.add(filter.get(validate_Second_Values[0]).toString());
				}
			}

			JSONArray faudval = (JSONArray) jsonObject.get(validate_Values[1]);
			for(int i=0;i< faudval.size();i++){

				JSONObject filter = (JSONObject) faudval.get(i);
				if(filter.containsKey(validate_Second_Values[1])){
					faud_res.add(filter.get(validate_Second_Values[1]).toString());
				}
			}

			expected_map_results.put("fgeo", fgeo_res.toString());
			expected_map_results.put("faud", faud_res.toString());
		}
		return expected_map_results;
	}

	public static Map<String , String> read_Pub_Ad_Call_Data(String excel_sheet_name) throws Exception{

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		Map<String , String> expected_results = new HashMap<String, String>();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		String validateValues = exceldata[16][Cap];
		String[] validate_Values = validateValues.split(",");

		//		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		//		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

		String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[17][Cap]));
		String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[7][Cap]));

		required_info= required_info.toString().replaceAll(exceldata[8][Cap], "=");
		required_info= required_info.toString().replaceAll(exceldata[9][Cap], "&");
		required_info= required_info.toString().replaceAll(exceldata[10][Cap], ",");

		required_info = required_info.substring(required_info.indexOf(exceldata[14][Cap]),required_info.indexOf(exceldata[15][Cap]));


		String pubad_cust_params_data = required_info.toString();

		String[] pubadvalue = pubad_cust_params_data.split(exceldata[13][Cap]);

		for(String pubadkey:pubadvalue){

			String[] key = pubadkey.split("=");

			for(int i=0;i<validate_Values.length;i++){	

				if(key[0].equals(validate_Values[i])){
					expected_results.put(validate_Values[i], key[1].toString());
				}
			}
		}
		return expected_results;
	}

	public static void clean_App_Launch(String excel_sheet_name) throws Exception{
		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();


		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		//		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		//		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

		String feedVal=exceldata[3][Cap].toString().trim();

		System.out.println("Feeds Val are :"+feedVal.trim());

		int feedcount=Integer.parseInt(feedVal);

		for(int Feed=0;Feed<=feedcount;Feed++){

			String pubadcal;

			if(Feed==0){
				pubadcal = sb.toString().substring(sb.toString().lastIndexOf(exceldata[1][Cap]));

				if(pubadcal.toString().contains(exceldata[1][Cap])){
					System.out.println("BB Ad call is pressent");
				}else{
					System.out.println("BB Ad call not presented");
					Assert.fail("BB Ad call not presented");
				}

			}
			else
			{
				String feedcall = exceldata[2][Cap]+Feed;

				pubadcal = sb.toString().substring(sb.toString().lastIndexOf(exceldata[2][Cap]+Feed));
				if(pubadcal.contains(feedcall)){
					System.out.println("Feed_"+Feed +" Ad call is pressent");
				}else{
					System.out.println("Feed_"+Feed +" Ad call is not pressent");
					Assert.fail();
				}

			}
		}
	}

	public static void bb_call_validation(String excel_sheet_name) throws Exception{

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		//		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		//		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

		String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[17][Cap]));
		String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[17][Cap]));

		String expected_data = required_info.toString().substring(required_info.indexOf(exceldata[14][Cap]),required_info.indexOf(exceldata[15][Cap]));
		String expectedValues = expected_data.toString();

		System.out.println("BB Call Value is : "+expectedValues);
		if(expectedValues.contains(exceldata[17][Cap])){
			System.out.println("BB Call generated");
		}
		else{
			System.out.println("BB Call not generated");
			Assert.fail("BB Call not generated ");
		}
	}

	@SuppressWarnings("unchecked")
	public static void thirdParty_beacons_validation(String excel_sheet_name) throws Exception{
		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		Thread.sleep(4000);
		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		//		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		//		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

		String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[2][Cap]));
		String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[2][Cap]));
		String expected_data = required_info.toString().substring(required_info.indexOf(exceldata[2][Cap]),required_info.indexOf(exceldata[3][Cap]));
		String expectedValues = expected_data.toString();

		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		String[] keypairs = expectedValues.split(exceldata[4][Cap]);

		for (String keyvalue : keypairs)
		{
			String[] key_value = keyvalue.split(exceldata[5][Cap]);
			map.put(key_value[0], key_value[1]);
		}

		if(!empty(map.get(exceldata[6][Cap])) && !empty(map.get(exceldata[7][Cap])) && !empty(map.get(exceldata[8][Cap]))){
			System.out.println(exceldata[6][Cap]+" Value is "+map.get(exceldata[6][Cap]));
			System.out.println(exceldata[7][Cap]+" Value is "+map.get(exceldata[7][Cap]));
			System.out.println(exceldata[8][Cap]+" Value is "+map.get(exceldata[8][Cap]));
		}
		else{
			System.out.println(exceldata[1][Cap] +" not available.");
			Assert.fail(exceldata[1][Cap] +" not available.");
		}

	}
	private static boolean empty(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	//	public static String get_pub_ad_call(int feed) throws Exception{
	//		
	//		DeviceStatus device_status = new DeviceStatus();
	//		int Cap = device_status.Device_Status();
	//		
	//		String expectedValues =null;
	//		String[][] exceldata = read_excel_data.exceldataread("AllFeeds");
	//		
	////		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	////		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	//		
	//		for(int i=0;i<=10;i++){
	//		if(sb.toString().contains(exceldata[17][Cap]+feed)){
	//			
	//		String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[17][Cap]+feed));
	//		String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[7][Cap]));
	//		required_info= required_info.toString().replaceAll(exceldata[8][Cap], "=");
	//		required_info= required_info.toString().replaceAll(exceldata[9][Cap], "&");
	//		required_info= required_info.toString().replaceAll(exceldata[10][Cap], ",");
	//		
	//		String expected_data = required_info.toString().substring(required_info.indexOf(exceldata[14][Cap]),required_info.indexOf(exceldata[15][Cap]));
	//		expectedValues = expected_data.toString();
	//		}
	//		}
	//		return expectedValues;
	//	}
	//	

	public static String get_pub_ad_call(int feed) throws Exception{

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		String expectedValues =null;
		String[][] exceldata = read_excel_data.exceldataread("AllFeeds");
		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		//xml_data_into_buffer.read_xml_file_into_buffer_string("normal");
		//for(int i=0;i<=10;i++){
		String pubad = null;
		if(adType.equalsIgnoreCase("DetailsPages")) {
			pubad = exceldata[18][Cap].toString();
			pubad=pubad+Deatailpagead[feed];
		}else if(adType.equalsIgnoreCase("HomeScreen")){
			pubad = exceldata[17][Cap].toString();
			pubad=pubad+homescreenfeedad[feed];
		}
		if(sb.toString().contains(pubad)){

			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(pubad));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[7][Cap]));
			required_info= required_info.toString().replaceAll(exceldata[8][Cap], "=");
			required_info= required_info.toString().replaceAll(exceldata[9][Cap], "&");
			required_info= required_info.toString().replaceAll(exceldata[10][Cap], ",");

			String expected_data = required_info.toString().substring(required_info.indexOf(exceldata[14][Cap]),required_info.indexOf(exceldata[15][Cap]));
			expectedValues = expected_data.toString();
		}
		//	}
		return expectedValues;
	}



	public static void validate_CXTG_values(String excel_sheet_name) throws Exception{

		Map<String, String> cxtg_res = get_wfxtriggers_call(excel_sheet_name);
		Map<String, String> pubad_res = null;
		List<String> cxtg_not_match = new ArrayList<String>();
		String finalval=null;
		boolean isExceptionOccered = false;
		Set<String> keys = cxtg_res.keySet();
		for (String key : keys) {
			pubad_res = get_pubad_call_by_zip(excel_sheet_name,"zip%3D"+key);
			finalval = cxtg_res.get(key).substring(1, cxtg_res.get(key).length() -1);
			System.out.println("CXTG Zip:::"+key+" CXTG Value :::"+finalval);
			System.out.println("Pub Zip:::"+pubad_res.get("zip")+" CXTG Value :::"+pubad_res.get("cxtg"));
			try {
				Assert.assertEquals(pubad_res.get("cxtg"),finalval);
			} catch (ComparisonFailure e) {
				System.out.println(key + " Doesn't Match");
				cxtg_not_match.add(key);
				isExceptionOccered= true;
			}
			if(isExceptionOccered){
				System.out.println(cxtg_not_match);
				Assert.fail(cxtg_not_match + " are not matched");
			}
		}
	}

	public static Map<String, String> get_wfxtriggers_call(String excel_sheet_name) throws Exception{

		Map<String , String> wfxtriggers_values = new HashMap<String, String>();
		String wxtgValues="";

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		String jsonValues = exceldata[11][Cap];
		String[] json_Values = jsonValues.split(",");

		String validateValues = exceldata[16][Cap];
		String[] validate_Values = validateValues.split(",");

		/* --- Start JSON Parser for wfxtg Values --- */


		//			read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		//			String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

		String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[2][Cap]));
		String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[3][Cap]));

		String expected_data = required_info.toString().substring(required_info.indexOf(exceldata[4][Cap])+7,required_info.indexOf(exceldata[5][Cap]));
		wxtgValues = expected_data.toString();

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(wxtgValues);
		JSONObject jsonObject = (JSONObject) obj;
		JSONObject wfxtgval = (JSONObject) jsonObject.get(json_Values[0]);
		JSONArray scatterSegsVal = (JSONArray) wfxtgval.get(json_Values[1]); 

		/* --- Start For Loop Main JSON Parser --- */
		for(int i=0;i< scatterSegsVal.size();i++){

			JSONObject zcsVal = (JSONObject) scatterSegsVal.get(i);
			/* --- Start Key Pair Contains ZCS --- */
			if(zcsVal.containsKey(exceldata[12][Cap])){
				JSONArray jsonArray = (JSONArray) zcsVal.get(exceldata[12][Cap]);
				/* --- Start ZCS contains multipul ZIP Values --- */
				for(int j=0;j< jsonArray.size();j++){
					JSONObject zipval = (JSONObject) jsonArray.get(j);
					/* --- Start Key Pair Contains ZIP --- */
					if(zipval.containsKey(validate_Values[0])){
						wfxtriggers_values.put(zipval.get(validate_Values[0]).toString(), zipval.get(validate_Values[1]).toString());
					}/* --- End Key Pair Contains ZIP --- */

				}/* --- End ZCS contains multipul ZIP Values --- */

			}/* --- End Key Pair Contains ZCS --- */

		}/* --- End For Loop Main JSON Parser --- */
		return wfxtriggers_values;
	}

	public static Map<String, String> get_pubad_call_by_zip(String excel_sheet_name,String Zip) throws Exception{

		Map<String , String> cxtg_values = new HashMap<String, String>();
		String cxtgValues="";

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		String validateValues = exceldata[16][Cap];
		String[] validate_Values = validateValues.split(",");
		/* --- Start JSON Parser for wfxtg Values --- */
		//		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		//		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

		String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(Zip));
		String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(Zip));
		String expected_data = required_info.toString().substring(required_info.indexOf(Zip),required_info.indexOf(exceldata[15][Cap]));
		expected_data= expected_data.toString().replaceAll(exceldata[8][Cap], "=");
		expected_data= expected_data.toString().replaceAll(exceldata[9][Cap], "&");
		expected_data= expected_data.toString().replaceAll(exceldata[10][Cap], ",");
		cxtgValues = expected_data.toString();

		String[] arrays = cxtgValues.split("&");
		for(String keys : arrays){
			if(keys.contains("=")){
				String[] key = keys.split("=");
				if(key[0].equals(validate_Values[0])){
					cxtg_values.put(key[0], key[1]);
				}
				if(key[0].equals(validate_Values[1])){
					cxtg_values.put(key[0], key[1]);
				}
			}
		}
		return cxtg_values;
	}

	public static void verifySavedAddressList() throws Exception{

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();
		/* --- Start For Android Device --- */
		if(Cap == 2){
			String[][] addressdata = read_excel_data.exceldataread("AddressPage");

			WebDriverWait wait4 = new WebDriverWait(Ad, 10);
			wait4.until(ExpectedConditions.presenceOfElementLocated(By.id(addressdata[4][Cap])));

			//Root Location Element
			Ad.findElementById(addressdata[4][Cap]).click();

			WebDriverWait wait5 = new WebDriverWait(Ad, 20);
			wait5.until(ExpectedConditions.presenceOfElementLocated(By.id(addressdata[6][Cap])));

			//List Location Element
			@SuppressWarnings("unchecked")
			List<MobileElement> loclist = Ad.findElements(By.id(addressdata[6][Cap]));

			int loc_size = loclist.size() -1;

			String loc_length = Integer.toString(loc_size);

			System.out.println("Total Saved Address List :::::" + loc_length);

			Thread.sleep(2000);

			System.out.println("Start Select Address List");

			String firsteleXpath = addressdata[5][Cap];
			String[] parts = firsteleXpath.split("Count");
			/* --- Start For Loop For Location Click --- */
			for(int i=2;i<= loclist.size();i++){

				String element = null;

				try {

					element = parts[0]+i+parts[1];

					MobileElement ele = (MobileElement) Ad.findElementByXPath(element);
					System.out.println("For This Location ====>"+ele.getText());

					WebDriverWait wait9 = new WebDriverWait(Ad, 20);
					wait9.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));

					Ad.findElementByXPath(element).click();

					WebDriverWait wait10 = new WebDriverWait(Ad, 20);
					wait10.until(ExpectedConditions.presenceOfElementLocated(By.id(addressdata[4][Cap])));

					Ad.findElementById(addressdata[4][Cap]).click();
				} catch (Exception e) {

					System.out.println(element+" is not found in the location list");
				}
			}/* --- End For Loop For Location Click --- */

			Thread.sleep(8000);

			WebDriverWait wait12 = new WebDriverWait(Ad, 10);
			wait12.until(ExpectedConditions.presenceOfElementLocated(By.xpath(parts[0]+1+parts[1])));

			Ad.findElementByXPath(parts[0]+1+parts[1]).click();
		}/* --- End For Android Device --- */
		System.out.println("End Select Address List");
	}

	public static void CleanLaunch_launch(String excel_sheet_name) throws Exception
	{
		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		for(int i=1;i<=2 ;i++){
			Thread.sleep(2000);
			Swipe();
			Thread.sleep(2000);
		}

		int MAX_SWIPES = 10;

		for (int j = 0; j < MAX_SWIPES; j++) {

			MobileElement module = null;

			try {

				WebDriverWait wait0 = new WebDriverWait(Ad, 10);
				wait0.until(ExpectedConditions.visibilityOf(Ad.findElementByXPath(exceldata[1][Cap])));
				module = (MobileElement) Ad.findElementByXPath(exceldata[1][Cap]);


			} catch (Exception e) {
				// System.out.println(e);
			}


			if (module!=null && module.isDisplayed()) {
				System.out.println("Last module is present");
				Swipe();
				break;
			} 
			else {
				System.out.println("Last module is NOT present,scrolling down");
				Swipe();
			}
		}
	}

	public static void verify_Vedio_Module_Click_On_Forecast_Video(String excel_sheet_name) throws Exception{

		System.out.println("Searching for Video module");
		Thread.sleep(5000);
		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
		int swipe = 4;
		//Integer.parseInt(exceldata[2][Cap]);

		for(int i=1;i<=1 ;i++){
			Swipe();
			Thread.sleep(1000);
		}

		int MAX_SWIPES = 5;

		for (int i = 0; i<MAX_SWIPES; i++) {

			MobileElement video = null;

			try {
				Ad.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				//WebDriverWait wait0 = new WebDriverWait(Ad, 10);
				//wait0.until(ExpectedConditions.visibilityOf(Ad.findElementById(exceldata[5][Cap])));
				video = (MobileElement) Ad.findElementById(exceldata[5][Cap]);

			} catch (Exception e) {
				// System.out.println("Exception message :: "+e);	
			}

			if(video!=null && video.isDisplayed())
			{  
				System.out.println("Video module is present ");
				Ad.findElementById(exceldata[5][Cap]).click();
				Thread.sleep(5000);
				Ad.findElementByClassName(exceldata[6][Cap]).click();
				Thread.sleep(2000);
				break;
			}else
			{
				System.out.println("Video module is NOT present and scrolling down");
				Swipe();
			}
		}
	}








	/*public static void Swipe(){
		Dimension dimensions = Ad.manage().window().getSize();
		Double startY1 = dimensions.getHeight() * 0.7;  
		startY = startY1.intValue();
		Double endY1 = (double) (dimensions.getHeight()/40);  //  dimensions.getHeight()  0.2;  == 512.0
		endY = endY1.intValue();
		Ad.swipe(0, startY, 0, endY,2000);
	}*/
	public static void Swipe() throws Exception{
		Dimension dimensions = Ad.manage().window().getSize();//throwing exception

		Double startY1 = dimensions.getHeight() * 0.8;  
		startY = startY1.intValue();
		Double endY1 = (double) (dimensions.getHeight()/40);  //  dimensions.getHeight()  0.2;  == 512.0
		endY = endY1.intValue();
		Thread.sleep(5000);
		Ad.swipe(0, startY, 0, endY,2000);
		//Ad.swipe(startx, starty, endx, endy, duration);

	}

	public static Map<String , String> read_Video_Pub_Ad_Call_Data(String excel_sheet_name) throws Exception{

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		Map<String , String> expected_results = new HashMap<String, String>();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		String validateValues = exceldata[16][Cap];
		String[] validate_Values = validateValues.split(",");

		//		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		//		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

		try {

			if(sb.toString().contains(exceldata[17][Cap])){
				String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[17][Cap]));
				String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[7][Cap]));

				required_info= required_info.toString().replaceAll(exceldata[8][Cap], "=");
				required_info= required_info.toString().replaceAll(exceldata[9][Cap], "&");
				required_info= required_info.toString().replaceAll(exceldata[10][Cap], ",");
				required_info = required_info.substring(required_info.indexOf(exceldata[14][Cap]),required_info.indexOf(exceldata[15][Cap]));
				String pubad_cust_params_data = required_info.toString();
				String[] pubadvalue = pubad_cust_params_data.split(exceldata[13][Cap]);

				for(String pubadkey:pubadvalue){

					String[] key = pubadkey.split("=");
					for(int i=0;i<validate_Values.length;i++){	

						if(key[0].equals(validate_Values[i])){
							expected_results.put(validate_Values[i], key[1].toString());
						}
					}
				}
				expected_results.put("iu",exceldata[17][Cap]);
			}
		} catch (Exception e) {
			System.out.println("Video Pub Ad Call Not Generated. Ex : "+exceldata[17][Cap]);
			Assert.fail("Video Pub Ad Call Not Generated. Ex : "+exceldata[17][Cap]);
		}

		return expected_results;
	}
	
	public static Map<String , String> read_Video_Pub_Ad_Call_request(String excel_sheet_name) throws Exception{

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		Map<String , String> expected_results = new HashMap<String, String>();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		String validateValues = exceldata[16][Cap];
		String[] validate_Values = validateValues.split(",");

		//		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		//		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

		try {

			if(sb.toString().contains(exceldata[17][Cap])){
				String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[17][Cap]));
				String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[7][Cap]));

				required_info= required_info.toString().replaceAll(exceldata[8][Cap], "/");
			required_info= required_info.toString().replaceAll(exceldata[9][Cap], ":");
		//		required_info= required_info.toString().replaceAll(exceldata[10][Cap], ",");
				required_info = required_info.substring(required_info.indexOf(exceldata[14][Cap]),required_info.indexOf(exceldata[15][Cap]));
				String pubad_cust_params_data = required_info.toString();
				String[] pubadvalue = pubad_cust_params_data.split(exceldata[13][Cap]);

				for(String pubadkey:pubadvalue){

					String[] key = pubadkey.split("=");
					for(int i=0;i<validate_Values.length;i++){	

						if(key[0].equals(validate_Values[i])){
							expected_results.put(validate_Values[i], key[1].toString());
						}
					}
				}
				expected_results.put("iu",exceldata[17][Cap]);
			}
		} catch (Exception e) {
			System.out.println("Video Pub Ad Call Not Generated. Ex : "+exceldata[17][Cap]);
			Assert.fail("Video Pub Ad Call Not Generated. Ex : "+exceldata[17][Cap]);
		}

		return expected_results;
	}


	public static void verify_Road_Conditions(String excel_sheet_name) throws Exception{

		System.out.println("Searching for Road Conditions");

		Thread.sleep(5000);
		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
		int swipe = Integer.parseInt(exceldata[2][Cap]);

		for(int i=1;i<=swipe ;i++){
			Swipe();
			Thread.sleep(1000);
		}

		int MAX_SWIPES = 5;

		for (int i = 0; i<MAX_SWIPES; i++) {

			MobileElement roads = null;

			try {
				WebDriverWait wait0 = new WebDriverWait(Ad, 10);
				wait0.until(ExpectedConditions.visibilityOf(Ad.findElementByName(exceldata[1][Cap])));
				roads = (MobileElement) Ad.findElementByName(exceldata[1][Cap]);


			} catch (Exception e) {
				// System.out.println("Exception message :: "+e);	
			}

			if(roads!=null && roads.isDisplayed())
			{  
				System.out.println("Road Conditions module is present ");
				Ad.findElementByName(exceldata[1][Cap]).click();
				Thread.sleep(2000);
				if(Ad.findElementByXPath(exceldata[5][Cap]).isDisplayed()){
					Thread.sleep(2000);
					Ad.findElementByXPath(exceldata[5][Cap]).click();
				}
				Thread.sleep(2000);
				Ad.findElementByClassName(exceldata[3][Cap]).click();
				Thread.sleep(2000);
				break;
			}else
			{
				System.out.println("Road Conditions is NOT present and scrolling down");
				Swipe();
			}
		}
	}

	public static Map<String , String> ddi_validation(String excel_sheet_name) throws Exception{

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		Map<String , String> expected_results = new HashMap<String, String>();

		Thread.sleep(4000);
		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
		@SuppressWarnings("unused")
		Map<String, String> map = new HashMap<String, String>();

		//		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		//		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

		try {

			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[15][Cap]));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[15][Cap]));
			String expected_data = required_info.toString().substring(required_info.indexOf(exceldata[13][Cap]),required_info.indexOf(exceldata[14][Cap]));
			expected_data= expected_data.toString().replaceAll(exceldata[7][Cap], "=");
			expected_data= expected_data.toString().replaceAll(exceldata[8][Cap], "&");
			expected_data= expected_data.toString().replaceAll(exceldata[9][Cap], ",");

			String expectedValues = expected_data.toString();

			String[] keypairs = expectedValues.split(exceldata[12][Cap]);

			for (String keyvalue : keypairs)
			{
				if(keyvalue.contains("=")){
					String[] key_value = keyvalue.split(exceldata[11][Cap]);
					if(key_value[0].contains(exceldata[16][Cap])){
						expected_results.put(key_value[0], key_value[1]);
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println(exceldata[15][Cap] + " Value Not Generated");
			Assert.fail(exceldata[15][Cap] + " Value Not Generated");
		}

		return expected_results;

	}
	public static void SwipeUp_Counter_lifestyle_coldflumodule() throws Exception{
		System.out.println("Searching for cold&flumodule  ");

		//int swipeup = Counter;

		for(int i=1;i<=7 ;i++){

			Swipe();

			Boolean b=verifyElement(By.id("com.weather.Weather:id/combo_item_container"));
			//Ad.findElementByName("HEALTH & ACTIVITIES").getAttribute("")
			//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
			//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
			if(b==true)
			{
				try {
					Ad.findElementById("com.weather.Weather:id/combo_item_container").click();
					Thread.sleep(1000);
					for(int j=1;j<=3 ;j++){

						Swipe();
					}
				}
				catch(Exception e)
				{					
					Ad.findElementById("Ccom.weather.Weather:id/combo_module_arrow_text").click();
					Thread.sleep(4000);
					for(int j=1;j<=3 ;j++){
						Swipe();
					}
				}

				//AppiumFunctions.Check_Lifestyle_Module_ad();
				//Ad.findElementByClassName("android.widget.ImageButton").click();
				Thread.sleep(5000);				
				break;
			}
			else
			{
				System.out.println("Module is not present scroll down");
			}



		}
	}
	public static void SwipeUp_Counter_lifestyle_allergymodule() throws Exception{
		System.out.println("Searching for cold&flumodule  ");
		Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout"));
		//Ad.findElementByName("HEALTH & ACTIVITIES").getAttribute("")
		//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
		//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
		if(b==true)
		{
			try {
				Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout").click();
				Thread.sleep(5000);	
				for(int j=1;j<=3 ;j++){

					Swipe();
				}

			}
			catch(Exception e)
			{					
				Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout").click();
				Thread.sleep(5000);	
			}
		}


		else
		{
			System.out.println("Module is not present scroll down");
		}


	}

	public static void SwipeUp_Counter_lifestyle_boatBeachmodule() throws Exception{
		System.out.println("Searching for Boat&beach module  ");
		Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout"));

		//Ad.findElementByName("HEALTH & ACTIVITIES").getAttribute("")
		//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
		//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
		if(b==true)
		{
			try {
				Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout").click();
				Thread.sleep(5000);	
				for(int j=1;j<=3 ;j++){

					Swipe();
				}
			}
			catch(Exception e)
			{					
				Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout").click();
				Thread.sleep(5000);	
			}
		}


		else
		{
			System.out.println("Module is not present scroll down");
		}


	}
	public static void SwipeUp_Counter_lifestyle_goRunmodule() throws Exception{
		System.out.println("Searching for GoRun module  ");
		Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout"));
		//Ad.findElementByName("HEALTH & ACTIVITIES").getAttribute("")
		//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
		//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
		if(b==true)
		{
			try {
				Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout").click();
				Thread.sleep(5000);	
				for(int j=1;j<=3 ;j++){

					Swipe();
				}
			}
			catch(Exception e)
			{					
				Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout").click();
				Thread.sleep(5000);	
			}
		}


		else
		{
			System.out.println("Module is not present scroll down");
		}


	}
	public static void SwipeUp_Counter_lifestyle_skimodule() throws Exception{
		System.out.println("Searching for cold&flumodule  ");
		Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout"));
		//Ad.findElementByName("HEALTH & ACTIVITIES").getAttribute("")
		//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
		//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
		if(b==true)
		{
			try {
				Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout").click();
				Thread.sleep(5000);	
			}
			catch(Exception e)
			{					
				Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout").click();
				Thread.sleep(5000);	
			}
		}


		else
		{
			System.out.println("Module is not present scroll down");
		}


	}

	public static void Clickon_Back_Button() throws Exception 
	{
		try{
			logStep("Clicking on backbuton");
			Ad.findElementByClassName("android.widget.ImageButton").click();
			Thread.sleep(3000);
		}
		catch(Exception e )
		{
			logStep("Clicking on backbuton");
			Ad.findElementByClassName("android.widget.ImageButton").click();
			Thread.sleep(3000);
		}
	}

	public static void SwipeUp_Counter_hourly_submodules() throws Exception{

		//int swipeup = Counter;

		for(int i=1;i<=7 ;i++){

			Swipe();


			Boolean b=verifyElement(By.id("com.weather.Weather:id/hourly_more"));
			if(b==true)
			{
				logStep("Hourly page is presented on the screen");		
				Ad.findElementById("com.weather.Weather:id/hourly_more").click();
				logStep("clicked the hourly page link");
				Ad.findElementByClassName("android.widget.ImageButton").click();
				Thread.sleep(5000);


				break;
			}
			else
			{
				System.out.println("Module is not present scroll down");
			}



		}
	}
	public static void SwipeUp_Counter_Daily_submodule() throws Exception{

		//int swipeup = Counter;

		for(int i=1;i<=7 ;i++){

			Swipe();

			Boolean b=verifyElement(By.id("com.weather.Weather:id/daily_more"));
			if(b==true)
			{
				logStep("Daily page is presented on the screen");
				Ad.findElementById("com.weather.Weather:id/daily_more").click();
				logStep("clicked the Daily page link");
				Ad.findElementByClassName("android.widget.ImageButton").click();
				Thread.sleep(5000);				
				break;
			}
			else
			{
				System.out.println("Module is not present scroll down");
			}


		}
	}

	public static void SwipeUp_Counter_Maps_submodule() throws Exception{

		//int swipeup = Counter;

		for(int i=1;i<=7 ;i++){

			//Swipe();

			Boolean b=verifyElement(By.id("com.weather.Weather:id/map_module_title"));

			if(b==true)
			{
				logStep("Maps page is presented on the screen");
				try
				{

					Ad.findElementById("com.weather.Weather:id/map_module_thumbnail").click();
					logStep("clicked the Daily page link");
				}
				catch(Exception e)
				{
					Ad.findElementById("com.weather.Weather:id/map_module_more").click();
					logStep("clicked the Daily page link");
				}
				Ad.findElementByClassName("android.widget.ImageButton").click();
				Thread.sleep(5000);				
				break;
			}
			else
			{
				System.out.println("Module is not present scroll down");
			}



		}
	}
	public static void SwipeUp_Counter_news_submodules() throws Exception{

		//int swipeup = Counter;

		for(int i=1;i<=12 ;i++){

			Swipe();


			Boolean b=verifyElement(By.id("com.weather.Weather:id/news_title"));
			if(b==true)
			{
				Ad.findElementById("com.weather.Weather:id/news_grid_item_0").click();
				Thread.sleep(5000);
				//Ad.findElementByClassName("android.widget.ImageButton").click();
				//Thread.sleep(5000);
				break;
			}
			else
			{
				System.out.println("Module is not present scroll down");
			}



		}
	}

	public static void Change_to_Test_Mode(String excel_sheet_name) throws Exception{

		logStep("Make Ads As Test From Test Mode Settings In Order To Get BB Ad Call");
		logStep("TestMode Settings: 1) Click On Menu Button 2) Click On Settings 3) Click On About This App 4) Click 10 Times On App Version 5) TestMode Setting Enabled 6) Click On TestMode Settings 7) Click On Ads");


		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		WebDriverWait wait = new WebDriverWait(Ad, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className(exceldata[2][Cap])));//settings button

		MobileElement menu = (MobileElement) Ad.findElement(By.className(exceldata[2][Cap]));
		menu.click();
		System.out.println("clicking on Menu option");
		Thread.sleep(4000);
		try {
			Ad.findElementByName(exceldata[5][Cap]).click(); 
		}
		catch(Exception e)
		{
			List<MobileElement> sett=	Ad.findElementsById("com.weather.Weather:id/design_menu_item_text");
			sett.get(1).click();
		}
		System.out.println("clicking on settings option");
		Thread.sleep(4000);
		try {
			//Ad.findElementByName(exceldata[6][Cap]).click();;//about this app
			Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[6]/android.widget.RelativeLayout/android.widget.TextView").click();
		}

		catch(Exception e)
		{
			List<MobileElement> aboutelem = Ad.findElementsById("android:id/title");
			System.out.println("elements in setting page"+aboutelem);
			aboutelem.get(1).click();
		}
		//aboutThisAPP.click();
		System.out.println("clicking on about this app option");
		System.out.println("tapping continously to get test mode option");	
		for (int i=1; i<=8; i++){
			Ad.findElementById(exceldata[18][Cap]).click();
		}
		Thread.sleep(4000);
		try {
			Ad.findElementByName(exceldata[19][Cap]).click();
		}
		catch(Exception e)
		{
			Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]").click();
		}
		System.out.println("clicking on test mode settings");	


		try {
			Ad.findElementByName("Airlock").click();
		}
		catch(Exception e)
		{
			Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[7]/android.widget.RelativeLayout/android.widget.TextView").click();
		}
		try {
			Ad.findElementByName("User Groups").click();
		}
		catch(Exception e)
		{
			Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView[1]").click();
		}
		Ad.findElementById("com.weather.Weather:id/search_bar").sendKeys("11089");
		Thread.sleep(4000);
		try {
			Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.CheckedTextView[1]").click();
		}
		catch(Exception e)
		{
			Ad.findElementById("android:id/text1").click();
		}
		Thread.sleep(5000);
		///hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.CheckedTextView[1]
	}
	public static void Kill_launch() throws Exception{
		try{
		
			Ad.closeApp();		
			Ad.launchApp();
			After_launch();
		}catch(Exception e){

			try {

				Ad.closeApp();		
				Ad.launchApp();
				After_launch();
			}
			catch(Exception e1) {
				
			}
		}
	}

	public static void After_launch(){
		try{
			
        	AppiumFunctions.clickONNext();
        	AppiumFunctions.ClickonIUnderstand();
        	AppiumFunctions.clickOnAllow();
		}catch(Exception e){
			
		}

	}
	public static void scroll_onelement_to_otherelement() throws Exception{
		TouchAction touchAction = new TouchAction(Ad);

		MobileElement ColdFlu=(MobileElement) Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout");
		MobileElement BoatBeach=(MobileElement) Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout");
		Point ColdFluPoint = ColdFlu.getLocation();
		Point BoatBeachPoint =BoatBeach.getLocation();

		int ColdFluX=ColdFluPoint.getX();
		int ColdFluY=ColdFluPoint.getY();
		ColdFluX=ColdFluX+40;
		int BoatBeachX=BoatBeachPoint.getX();
		int BoatBeachY=BoatBeachPoint.getY();

		Ad.swipe(BoatBeachX, BoatBeachY, ColdFluX, ColdFluY, 4000);


	}
	public static void scroll_onelement_to_otherelement1() throws Exception{


		MobileElement ColdFlu=(MobileElement) Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout");
		MobileElement BoatBeach=(MobileElement) Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout");
		Point ColdFluPoint = ColdFlu.getLocation();
		Point BoatBeachPoint =BoatBeach.getLocation();

		int ColdFluX=ColdFluPoint.getX();
		int ColdFluY=ColdFluPoint.getY();
		ColdFluX=ColdFluX+40;
		int BoatBeachX=BoatBeachPoint.getX();
		int BoatBeachY=BoatBeachPoint.getY();

		Ad.swipe(BoatBeachX, BoatBeachY, ColdFluX, ColdFluY, 4000);


	}
	public static void get_aaxcals() throws Exception {
		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		xml_data_into_buffer.read_xml_file_into_buffer_string("aax");
		String slotID =null;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM");  
		LocalDateTime now = LocalDateTime.now();  
		String date = dtf.format(now);
		System.out.println("date is : "+date);
		//Write_result wrResult2 = new Write_result();
		write_excel_data wrResult2= new write_excel_data();
		read_excel_data.exceldataread_Custom_Parameters("aaxCals","Ad Slots_Android");
		try {

			for(int j=1;j<=read_excel_data.rowCount;j++) {
				wrResult2.writeResult("Ad Slots_Android","-",j,9);
			}
			for(String aaxSlot : aaxSlots) {
				//				aaxSlot=aaxSlot.toString().trim().replaceAll("<body><![CDATA[", "");
				//				aaxSlot=aaxSlot.toString().trim().replaceAll("]]></body></request>", "");
				aaxSlot = aaxSlot.toString().substring(aaxSlot.indexOf("[CDATA")+7,aaxSlot.indexOf("]]></body></request>"));
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(new String(aaxSlot.toString()));
				JSONObject jsonObject = (JSONObject) obj;
				JSONArray jArray = (JSONArray) jsonObject.get("slots");
				jsonObject =(JSONObject) jArray.get(0);
				slotID=jsonObject.get("slot").toString();
				//System.out.println("Slot Name is  : "+slotID);

				//readExcelValues.excelValues("AdUnits","Ad Slots_iPhone");
				String[][] exceldata = read_excel_data.exceldataread_Custom_Parameters("aaxCals", "Ad Slots_Android");

				for(int i=1;i<=read_excel_data.rowCount;i++) {
					if(slotID.equals(exceldata[i][8].toString().trim())) {
						System.out.println("slot id mached from for"+exceldata[i][5] +" is : "+exceldata[i][8] + "----"+slotID);
						wrResult2.writeResult("Ad Slots_Android","Passed"+date,i,9);

						break;
					}else {
						if(i==read_excel_data.rowCount) {
							System.out.println("Slot Id not Matched "+slotID );

						}
					}
				}

			}

		}catch(Exception e) {

		}
	}

	public static void SwipeUp_Counter_lifestyle_skidetailßmodule() throws Exception{
		System.out.println("Searching for GoRun module  ");
		Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout"));
		//Ad.findElementByName("HEALTH & ACTIVITIES").getAttribute("")
		//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
		//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
		if(b==true)
		{
			try {
				Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout").click();
				Thread.sleep(5000);	
			}
			catch(Exception e)
			{					
				Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout").click();
				Thread.sleep(5000);	
			}
		}


		else
		{
			System.out.println("Module is not present scroll down");
		}


	}

	public static void SwipeUp_Counter_lifestyle_skiresortsmodule() throws Exception{
		System.out.println("Searching for GoRun module  ");
		Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout"));
		//Ad.findElementByName("HEALTH & ACTIVITIES").getAttribute("")
		//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
		//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
		if(b==true)
		{
			try {
				Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout").click();
				Thread.sleep(5000);	
			}
			catch(Exception e)
			{					
				Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout").click();
				Thread.sleep(5000);	
			}
		}


		else
		{
			System.out.println("Module is not present scroll down");
		}


	}
	
	public static void selectCurrentLocationOnPushNotifications()  {
		try {
			if(Ad.findElementById("android:id/button1").isDisplayed()) {
		if(Ad.findElementById("android:id/button1").getText().contains("SELECT LOCATION"));
		Ad.findElementById("android:id/button1").click();
			}
		
		}
		catch(Exception e) {
			
					Ad.findElementById("com.weather.Weather:id/checkbox").click();
					System.out.println("enabled the checkbox");
				}
			
	}
	public static void clickOnNotificationsBellIcon() throws Exception  {
		System.out.println("Clicking alerts notification Icon");
		logStep("Clicking alerts notification Icon");
		try {
			Ad.findElementByAccessibilityId("Go to Alerts and Notifications").click();
			Thread.sleep(5000);
		}
		catch(Exception e) {
			Ad.findElementById("com.weather.Weather:id/notifications_icon").click();
			Thread.sleep(5000);
		}
	}
	
	public static void clickOnManage() throws Exception  {
		System.out.println("Clicking on Manage button");
		logStep("Clicking on Manage button");
		try {
			Ad.findElementByAccessibilityId("Manage").click();
			Thread.sleep(5000);
		}
		catch(Exception e) {
			Ad.findElementByAccessibilityId("Manage").click();
			Thread.sleep(5000);
		}
	}
	public static void enableSignificantweatherforecast_Notifications()  throws Exception{
		 clickOnNotificationsBellIcon();
		 clickOnManage();
			Thread.sleep(10000);
			
			Ad.findElementById("com.weather.Weather:id/my_alerts_layout_0").click();
			//Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.TextView[1]").click();
			Thread.sleep(15000);
		/*	List<WebElement> notifications;
			

				Thread.sleep(5000);
				try {
					notifications=Ad.findElementsById("com.weather.Weather:id/my_alerts_layout_0");
				}
				catch(Exception e) {
					notifications=Ad.findElementsById("com.weather.Weather:id/my_alerts_layout_0");
				}
			
		for(WebElement weather:notifications) {	
			Thread.sleep(6000);
			if(weather.getText().equalsIgnoreCase("Significant weather forecast")) {
				Thread.sleep(6000);
				weather.click();*/
			   enbleAlertSwitch();
			selectCurrentLocationOnPushNotifications();
			clickBackButtonAlerts();
			clickBackButtonAlerts();
			}			
			
	
	
	
	
	
	public static void enable_Alert_Notifications(String Notification)  throws Exception{
		 clickOnNotificationsBellIcon();
		 clickOnManage();
			Thread.sleep(2000);
		//	Ad.findElementById("com.weather.Weather:id/my_alerts_layout_3").click();
			//Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.ScrollView[3]/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[4]/android.widget.TextView[1]").click();
			Thread.sleep(6000);
			List<WebElement> notifications;
			
				Thread.sleep(5000);
				notifications=Ad.findElementsById("android.widget.TextView");
		for(WebElement weather:notifications) {	
			Thread.sleep(6000);
			if(weather.getText().equalsIgnoreCase(Notification)) {
				Thread.sleep(6000);
				//System.out.println(weather.getAttribute("text"));
				weather.click();
				Thread.sleep(6000);
				enbleAlertSwitch();
				clickBackButtonAlerts();
				clickBackButtonAlerts();
			}			
		}
	}
	
	public static void enable_Alert_Notifications_bn(String Notification)  throws Exception{
		 clickOnNotificationsBellIcon();
		 clickOnManage();
			Thread.sleep(6000);
			//Ad.findElementById("com.weather.Weather:id/my_alerts_layout_5").click();
			Ad.findElementByXPath("\"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.ScrollView[4]/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[6]/android.widget.TextView[1]").click();
			Thread.sleep(6000);
			/*List<WebElement> notifications;
			
				Thread.sleep(5000);
				notifications=Ad.findElementsById("com.weather.Weather:id/my_alerts_layout_5");
		for(WebElement weather:notifications) {	
			Thread.sleep(6000);
			if(weather.getText().equalsIgnoreCase(Notification)) {
				Thread.sleep(6000);
				//System.out.println(weather.getAttribute("text"));
				weather.click();
				Thread.sleep(6000);*/
				enbleAlertSwitch();
				clickBackButtonAlerts();
				clickBackButtonAlerts();
			}			
			
	
	
	public static void enable_Alert_Notifications_rtr(String Notification)  throws Exception{
		 clickOnNotificationsBellIcon();
		 clickOnManage();
			Thread.sleep(6000);
	//Ad.findElementById("com.weather.Weather:id/my_alerts_layout_2").click();
			Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.ScrollView[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[3]/android.widget.TextView[1]").click();
			Thread.sleep(6000);
			/*Thread.sleep(2000);
			List<WebElement> notifications;
			
				Thread.sleep(5000);
				notifications=Ad.findElementsById("com.weather.Weather:id/my_alerts_layout_2");
		for(WebElement weather:notifications) {	
			Thread.sleep(6000);
			if(weather.getText().equalsIgnoreCase(Notification)) {
				Thread.sleep(6000);
				//System.out.println(weather.getAttribute("text"));
				weather.click();*/
				Thread.sleep(6000);
				enbleAlertSwitch();
				clickBackButtonAlerts();
				clickBackButtonAlerts();
			}			
			
	
	public static void push() throws Exception {
		// selectCurrentLocationOnPushNotifications();
	
		
			clickBackButtonAlerts();
		
	}
	
	
	public static void enablePushalerts()  throws Exception{
		
		//clicking menu button
		//click the view more
				try {
				Ad.findElementByAccessibilityId("Go to Alerts and Notifications").click();
				Thread.sleep(2000);
				}
				catch(Exception e) {
					Ad.findElementById("com.weather.Weather:id/notifications_icon").click();
					Thread.sleep(3000);
				}
				//click manage button
				
					Ad.findElementByAccessibilityId("Manage").click();
					Thread.sleep(2000);
					
			//click significant forecast alert
					try {
						Ad.findElementById("com.weather.Weather:id/my_alerts_layout_0").click();
						Thread.sleep(2000);
						}
						catch(Exception e) {
							
								List<WebElement> airlock=Ad.findElementsByClassName("android.widget.RelativeLayout");
								airlock.get(0).click();
								Thread.sleep(3000);
						}		
					enbleAlertSwitch();
					
					
					Ad.findElementById("android:id/button1").click();
					
					Thread.sleep(3000);
					
					
				/*	try {
						Ad.findElementById("com.weather.Weather:id/checkbox").click();
						Thread.sleep(2000);
						}
						catch(Exception e) {
							
								Ad.findElementByClassName("android.widget.TextView").click();
								Thread.sleep(3000);
						}	*/
					clickBackButtonAlerts();
					//enable lighting alerts
					try {
						Ad.findElementById("com.weather.Weather:id/my_alerts_layout_3").click();
						Thread.sleep(2000);
						}
						catch(Exception e) {
							
								List<WebElement> airlock=Ad.findElementsByClassName("android.widget.RelativeLayout");
								airlock.get(3).click();
								Thread.sleep(3000);
						}	
					enbleAlertSwitch();
					clickBackButtonAlerts();
					
					//enable daily rain &Snow  alerts
					try {
						Ad.findElementById("com.weather.Weather:id/my_alerts_layout_6").click();
						Thread.sleep(2000);
						}
						catch(Exception e) {
							
								List<WebElement> airlock=Ad.findElementsByClassName("android.widget.RelativeLayout");
								airlock.get(6).click();
								Thread.sleep(3000);
						}	
					enbleAlertSwitch();
					Ad.findElementById("com.weather.Weather:id/checkbox").click();
					Thread.sleep(3000);
					
					clickBackButtonAlerts();
					Thread.sleep(3000);
					//enable daily pollen alert
					try {
						Ad.findElementById("com.weather.Weather:id/my_alerts_layout_7").click();
						Thread.sleep(2000);
						}
						catch(Exception e) {
							
								List<WebElement> airlock=Ad.findElementsByClassName("android.widget.RelativeLayout");
								airlock.get(7).click();
								Thread.sleep(3000);
						}	
					enbleAlertSwitch();
					
					clickBackButtonAlerts();
					clickBackButtonAlerts();

	}

public static void enbleAlertSwitch() throws Exception {
	
	Thread.sleep(15000);
	String on_off=Ad.findElementById("com.weather.Weather:id/alert_switch").getText();
	if(on_off.contains("Off OFF")) {
		Ad.findElementById("com.weather.Weather:id/alert_switch").click();
		Thread.sleep(10000);
	}
	if(on_off.contains("On ON")) {
		
		Thread.sleep(3000);
	}
	
}

public static void clickBackButtonAlerts() throws Exception {
	//enble alert swtich
	try {
	Ad.findElementByAccessibilityId("Navigate up").click(); 
		Thread.sleep(3000);
		
	}
	catch(Exception e) {
		Ad.findElementByClassName("android.widget.ImageButton").click();
		Thread.sleep(3000);
	}
}


//clicking alerts
public static void clickAelrtsadwd() throws Exception {
	
	//click the view more
			try {
			Ad.findElementByAccessibilityId("View More").click();
			Thread.sleep(2000);
			}
			catch(Exception e) {
				Ad.findElementById("com.weather.Weather:id/more_icon").click();
				Thread.sleep(3000);
			}
}


public static void clickbreakingnewsAlert() throws Exception {
	try {
		List<WebElement> airlock=Ad.findElementsById("android:id/text1");
		airlock.get(3).click();
		Thread.sleep(3000);
	
	}
	catch(Exception e) {
		List<WebElement> airlock=Ad.findElementsByClassName("android.widget.TextView");
		airlock.get(3).click();
		Thread.sleep(3000);
	}
}

public static void clickrealtimerainAlert() throws Exception {
	try {
		List<WebElement> airlock=Ad.findElementsById("android:id/text1");
		airlock.get(4).click();
		Thread.sleep(3000);
	
	}
	catch(Exception e) {
		List<WebElement> airlock=Ad.findElementsByClassName("android.widget.TextView");
		airlock.get(4).click();
		Thread.sleep(3000);
	}
}
public static void clickrealtimelightningAlert() throws Exception {
	try {
		List<WebElement> airlock=Ad.findElementsById("android:id/text1");
		airlock.get(5).click();
		Thread.sleep(3000);
	
	}
	catch(Exception e) {
		List<WebElement> airlock=Ad.findElementsByClassName("android.widget.TextView");
		airlock.get(5).click();
		Thread.sleep(3000);
	}	
}
public static void clickheavyrainfallAlert() throws Exception {
	try {
		List<WebElement> airlock=Ad.findElementsById("android:id/text1");
		airlock.get(6).click();
		Thread.sleep(3000);
	
	}
	catch(Exception e) {
		List<WebElement> airlock=Ad.findElementsByClassName("android.widget.TextView");
		airlock.get(6).click();
		Thread.sleep(3000);
	}	
}
public static void clickthunderstormAlert() throws Exception {
	try {
		List<WebElement> airlock=Ad.findElementsById("android:id/text1");
		airlock.get(7).click();
		Thread.sleep(3000);
	
	}
	catch(Exception e) {
		List<WebElement> airlock=Ad.findElementsByClassName("android.widget.TextView");
		airlock.get(7).click();
		Thread.sleep(3000);
	}	
}

public static void clickhightheatAlert() throws Exception {
	try {
		List<WebElement> airlock=Ad.findElementsById("android:id/text1");
		airlock.get(8).click();
		Thread.sleep(3000);
	
	}
	catch(Exception e) {
		List<WebElement> airlock=Ad.findElementsByClassName("android.widget.TextView");
		airlock.get(8).click();
		Thread.sleep(3000);
	}	
}

public static void clickhighwindAlert() throws Exception {
	try {
		List<WebElement> airlock=Ad.findElementsById("android:id/text1");
		airlock.get(9).click();
		Thread.sleep(3000);
	
	}
	catch(Exception e) {
		List<WebElement> airlock=Ad.findElementsByClassName("android.widget.TextView");
		airlock.get(9).click();
		Thread.sleep(3000);
	}	
}
public static void clickdensefogAlert() throws Exception {
	try {
		List<WebElement> airlock=Ad.findElementsById("android:id/text1");
		airlock.get(10).click();
		Thread.sleep(3000);
	
	}
	catch(Exception e) {
		List<WebElement> airlock=Ad.findElementsByClassName("android.widget.TextView");
		airlock.get(10).click();
		Thread.sleep(3000);
	}	
}
public static void clickverycoldlert() throws Exception {
	try {
		List<WebElement> airlock=Ad.findElementsById("android:id/text1");
		airlock.get(11).click();
		Thread.sleep(3000);
	
	}
	catch(Exception e) {
		List<WebElement> airlock=Ad.findElementsByClassName("android.widget.TextView");
		airlock.get(11).click();
		Thread.sleep(3000);
	}	
}

public static void clickheavysnowfalllert() throws Exception {
	try {
		List<WebElement> airlock=Ad.findElementsById("android:id/text1");
		airlock.get(12).click();
	
	}
	catch(Exception e) {
		Thread.sleep(3000);
		List<WebElement> airlock=Ad.findElementsByClassName("android.widget.TextView");
		airlock.get(12).click();
		Thread.sleep(3000);
	}	
}

public static void clickicealert() throws Exception {
	try {
		List<WebElement> airlock=Ad.findElementsById("android:id/text1");
		airlock.get(13).click();
		Thread.sleep(3000);
	
	}
	catch(Exception e) {
		List<WebElement> airlock=Ad.findElementsByClassName("android.widget.TextView");
		airlock.get(13).click();
		Thread.sleep(3000);
	}	
}

public static void clickwinterbreakingalert() throws Exception {
	try {
		List<WebElement> airlock=Ad.findElementsById("android:id/text1");
		airlock.get(12).click();
		Thread.sleep(3000);
	
	}
	catch(Exception e) {
		List<WebElement> airlock=Ad.findElementsByClassName("android.widget.TextView");
		airlock.get(12).click();
		Thread.sleep(3000);
	}	
}

public static void clickfluxtomorrowalert() throws Exception {
	try {
		List<WebElement> airlock=Ad.findElementsById("android:id/text1");
		airlock.get(13).click();
		Thread.sleep(3000);
	
	}
	catch(Exception e) {
		List<WebElement> airlock=Ad.findElementsByClassName("android.widget.TextView");
		airlock.get(13).click();
		Thread.sleep(3000);
	}	
}
public static void clickfluxtodayalert() throws Exception {
	try {
		List<WebElement> airlock=Ad.findElementsById("android:id/text1");
		airlock.get(14).click();
		Thread.sleep(3000);
	
	}
	catch(Exception e) {
		List<WebElement> airlock=Ad.findElementsByClassName("android.widget.TextView");
		airlock.get(14).click();
		Thread.sleep(3000);
	}	
}

public static void swipefornotification() {

	try {
	TouchAction ta=new TouchAction(Ad);
	Ad.swipe(688, 52, 642, 1579,2000);	
	}
	catch(Exception e) {
		try {
			TouchAction ta=new TouchAction(Ad);
			Ad.swipe(688, 52, 642, 1579,2000);	
		}
		catch(Exception e1) {
			try {
				TouchAction ta=new TouchAction(Ad);
				Ad.swipe(688, 52, 642, 1579,2000);		
			}catch(Exception e4) {
				
			}
		}
	}
}


public static void click_BN() throws Exception {
Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]").click();
	System.out.println("breaking news alert was clicked");
	logStep("breaking news alert was clicked");
	Thread.sleep(5000);

}


public static void click_RTR() throws Exception {
	Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[5]").click();
	System.out.println("real time rain alert was clicked");
	logStep("real time rain alert was clicked");
	Thread.sleep(5000);
	
}

public static void click_thunderstorm() throws Exception {
	
	Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[8]").click();
	System.out.println("thunderstorm alert  alert was clicked");
	logStep("thunderstorm alert  alert was clicked");
	Thread.sleep(5000);
}

public static void click_severe() throws Exception {

	Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]").click();
	Thread.sleep(3000);
	System.out.println("severe alert  was clicked");
	logStep("severe alert  was clicked");

}
public static void clickOnRequiredPushNotification(String notification) throws Exception {

try {
	
	List<WebElement> notifications=Ad.findElementsById("android:id/text1");
	Thread.sleep(5000);
	for(WebElement ChooseAlertTypel:notifications) {
		Thread.sleep(5000);
		if(ChooseAlertTypel.getAttribute("text").equalsIgnoreCase(notification)) {
			Thread.sleep(5000);
			try {
				System.out.println(notification +" was clicked");
				logStep(notification +" was clicked");
			ChooseAlertTypel.click();
			ChooseAlertTypel.click();
			ChooseAlertTypel.click();
			}catch(Exception e5) {
				//System.out.println(notification +" was clicked");
				//logStep(notification +" was clicked");

			}
	
	//	Thread.sleep(5000);
		break;
}
	}
}
	catch(Exception e){
		
	
		}
	}




public static void  finding_BreakingNews_iu_value() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = read_xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fbreaking")) {
	System.out.println("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fbreaking ad call was trigred");
	logStep("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fbreaking ad call was trigred ");
}
if(!sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fbreaking")) {
System.out.println("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fbreaking ad call was not trigred");
logStep("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fbreaking ad call was not trigred");
Assert.fail("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fbreaking ad call was not trigred");
}

}




public static void  VerifyBNAlert() throws Exception{
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fbreaking")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fbreaking"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("alert%3D"),required_info.indexOf("%26atfid"));			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String Alert=expectedValues.replaceAll("%3D", "=");
			
			if(expectedValues.contains("breaking")) {
				logStep("Breaking news push notification alert cust param value is "     +Alert);
				System.out.println("Breaking news push notification alert cust param value is "     +Alert);
			}
			else {
				System.out.println("Breaking news push notification alert cust param value is"      + Alert);
				logStep("Breaking news push notification alert cust param value is"      + Alert);
				Assert.fail("Beaking news push notification alert cust param value is"      + Alert);
			}
			//System.out.println(expectedValues);
			
		}
	
}


public static String read_xml_file_into_buffer_string()throws Exception{
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	
	String[][] paths = read_excel_data.exceldataread("Paths");
	String xml_file_path=null;
	File folder = new File(paths[4][Cap]);
	File[] listOfFiles = folder.listFiles();
	String Filename = null;
	for (File file : listOfFiles) {
		if (file.isFile()) {
			Filename = file.getName();
			xml_file_path = paths[4][Cap]+Filename;
			System.out.println("XML File Name is : "+Filename);
		}
	}
	
	StringBuilder sb=null;
	
	try {
		File xmlFile = new File(xml_file_path); 
		Reader fileReader = new FileReader(xmlFile); 
		BufferedReader bufReader = new BufferedReader(fileReader); 
		sb = new StringBuilder(); 
		String line = bufReader.readLine(); 
		while( (line=bufReader.readLine()) != null)
		{ 
			sb.append(line).append("\n"); 
		} 
		bufReader.close();
	} catch (Exception e) {
		System.out.println("No Data Found in XML File");
	}
	return sb.toString();
	
}

public static Boolean verifyElement(By by) {
	try {
		// Get the element using the Unique identifier of the element
		Ad.findElement(by);
	} catch (NoSuchElementException e) {
		// Return false if element is not found
		return false;
	}  catch (Exception e) {
		return false;
	}
	//Return true if element is found
	return true;
}


public static void clickAlerts() throws Exception{
	
	//cliking View more Button		
 	clickOnviewMore();
 	//cliking on aboutthisapp
 	clickOnAboutthisapp();	
 	 clickOnVersionnumber();
 	clickOntestmodesettings() ;
 	
 	clickOnAlerts();
 
 	
}

public static void clickOnviewMore() {
Functions.verifyElement(ByAccessibilityId("View More"));
	try {
	System.out.println("Clicking on View More");
	logStep("Clicking on View More");
	new WebDriverWait(Ad, Functions.maxTimeout).until(ExpectedConditions.elementToBeClickable(Ad.findElementByAccessibilityId("View More")));
	Ad.findElementByAccessibilityId("View More").click();
	//Thread.sleep(5000);
	}
	catch(Exception e) {
		try {
			new WebDriverWait(Ad, Functions.maxTimeout).until(ExpectedConditions.elementToBeClickable(Ad.findElementByAccessibilityId("View More")));
			Ad.findElementByAccessibilityId("View More").click();
		}
		catch(Exception e1) {
			
		}
	}
}

public static void clickOnAboutthisapp() throws Exception {
//	Functions.verifyElement(ByAccessibilityId("About this App"));
	try {
	System.out.println("Clicking on About this App");
	logStep("Clicking on About this App");
	new WebDriverWait(Ad, Functions.maxTimeout).until(ExpectedConditions.elementToBeClickable(Ad.findElementByAccessibilityId("About this App")));
	Ad.findElementByAccessibilityId("About this App").click();
	//About this App
//	Thread.sleep(5000);
	}
	catch(Exception e) {	
		new WebDriverWait(Ad, Functions.maxTimeout).until(ExpectedConditions.elementToBeClickable(Ad.findElementById("com.weather.Weather:id/item_about")));
		Ad.findElementById("com.weather.Weather:id/item_about").click();
	Thread.sleep(5000);
	}
}



public static void clickOnVersionnumber() throws Exception {
try {
	//Thread.sleep(15000);
	Functions.verifyElement(By.id("com.weather.Weather:id/test_mode_settings"));
		//Thread.sleep(15000);
		System.out.println("Clicking on test mode settings");
		logStep("Clicking on test mode settings");
		//Thread.sleep(15000);
		new WebDriverWait(Ad, Functions.maxTimeout).until(ExpectedConditions.elementToBeClickable(Ad.findElementById("com.weather.Weather:id/test_mode_settings")));
		Ad.findElementById("com.weather.Weather:id/test_mode_settings").click();
		//Thread.sleep(5000);		
}
catch(Exception e) {
System.out.println("Clicking on BuildNumber till test mode settings option is displaying");
logStep("Clicking on BuildNumber till test mode settings option is displaying");	
for(int i=1;i<10;i++) {
	 //Thread.sleep(7000);
	 new WebDriverWait(Ad, Functions.maxTimeout).until(ExpectedConditions.elementToBeClickable(Ad.findElementById("com.weather.Weather:id/about_version")));
	Ad.findElementById("com.weather.Weather:id/about_version").click();
	 //Thread.sleep(6000);
}
}
}

public static void clickOntestmodesettings() throws Exception {
	try {
		Functions.verifyElement(By.id("com.weather.Weather:id/test_mode_settings"));
		if(Ad.findElementById("com.weather.Weather:id/test_mode_settings").isDisplayed())
			//Thread.sleep(5000);
			System.out.println("Clicking on test mode settings");
			logStep("Clicking on test mode settings");
		//Thread.sleep(5000);
			new WebDriverWait(Ad, Functions.maxTimeout).until(ExpectedConditions.elementToBeClickable(Ad.findElementById("com.weather.Weather:id/test_mode_settings")));
			Ad.findElementById("com.weather.Weather:id/test_mode_settings").click();
		}

	catch(Exception e) {
		
	}
}



public static void clickOnAlertNotificatons( String pushNotifications) throws Exception {
	
	//clicking on Airlock
	try {
		Thread.sleep(5000);

System.out.println("Clicking push alert notification alert on device");
logStep("Clicking push alert notification alert on device");
Thread.sleep(5000);
	 List<WebElement> all=Ad.findElementsById("android:id/title");
	Thread.sleep(5000);
	 for(WebElement Airlock:all) {
		if( Airlock.getAttribute("text").equalsIgnoreCase(pushNotifications)) {
			System.out.println(pushNotifications +" alert is generated on the screen");
			 logStep(pushNotifications +" alert is generated on the screen");
			// System.out.println(Airlock.getAttribute("text"));
			new WebDriverWait(Ad, Functions.maxTimeout).until(ExpectedConditions.elementToBeClickable(Airlock));
			Airlock.click();
	 Thread.sleep(5000);
			 break;
		 }
		else{
			System.out.println(pushNotifications +" push notification is not generated on the device");
			 logStep(pushNotifications +" push notification is not generated on the device");
			 Assert.fail(pushNotifications +"push notification is not generated on the device");
			 
		}
	 }
	}
	catch(Exception e) {
		Thread.sleep(5000);
		System.out.println(pushNotifications +" alert is not generated");
		 logStep(pushNotifications +" alert is not generated");
	
}
}



public static void clickOnAlertType( String AlertType) throws Exception {
	
	//clicking on Airlock
	try {
		Thread.sleep(5000);

System.out.println("Clicking on required alert type");
logStep("Clicking on required alert type");
Thread.sleep(5000);	
	// List<WebElement> all=Ad.findElementsById("android:id/text1");
 List<WebElement> all=Ad.findElementsByClassName("android.widget.TextView");

	Thread.sleep(5000);
	 for(WebElement Airlock:all) {
		if( Airlock.getText().equalsIgnoreCase(AlertType)) {
			new WebDriverWait(Ad, Functions.maxTimeout).until(ExpectedConditions.elementToBeClickable(Airlock));
			Airlock.click();
			System.out.println("Clicked the "+ AlertType);
			logStep("Clicked the "+ AlertType);
	 Thread.sleep(5000);
			 break;
		 }
	 }
	}
	catch(Exception e) {
		System.out.println("need to click");
		Thread.sleep(10000);
}
}


public static void clickOnAlerts() throws Exception {
	
	//clicking on Airlock
	try {
		Thread.sleep(5000);
System.out.println("Clicking on Alerts");
logStep("Clicking on Alerts");
WebElement all=(WebElement) Ad.findElementsById("android:id/title").get(4);
all.click();
Thread.sleep(5000);
	}
	catch(Exception e) {
		Thread.sleep(5000);
		 List<WebElement> all=Ad.findElementsById("android:id/title");
		Thread.sleep(5000);
		 for(WebElement Airlock:all) {
			if( Airlock.getAttribute("text").equalsIgnoreCase("Alerts")) {
				new WebDriverWait(Ad, Functions.maxTimeout).until(ExpectedConditions.elementToBeClickable(Airlock));
				Airlock.click();
		 Thread.sleep(5000);
				 break;
			 }
		 }
 }
}


public static void clickOnRTRnotification() {
	
	String text=Ad.findElementById("android:id/title").getText();
	if(text.contains("Real-time")) {
		System.out.println(text +"alert generated");
		Ad.findElementById("android:id/title").click();
	}
	else{
		System.out.println(text+"alert is not generated");
		Assert.fail(text+"alert is not generated");
	}
}
public static Map<String, String> finding_Radar_Map_card_iu_value() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps")) {
	System.out.println("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps call was trigred");
	logStep("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps call was trigred");
}
if(!sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps")) {
System.out.println("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps call was not  trigred");
logStep("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps call was not  trigred");
Assert.fail("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps call was not trigred");
}
return wfxtriggers_values;
}
public static void  VerifyRTRAlert() throws Exception{
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("alert%3D"),required_info.indexOf("%26atfid"));			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String Alert=expectedValues.replaceAll("%3D", "=");
			
			if(expectedValues.contains("real")) {
				System.out.println("real time rain  push notification alert cust param value is "     +Alert);
				logStep("real time rain  push notification alert cust param value is "     +Alert);
			}
			else {
				System.out.println("real time rain  push notification alert cust param value is "      + Alert);
				logStep("real time rain  push notification alert cust param value is "      + Alert);
				Assert.fail("real time rain  push notification alert cust param value is "      + Alert);
			}
			//System.out.println(expectedValues);
			
		}
}

public static Map<String, String> finding_hourly_details_card_iu_value() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fhourly")) {
	System.out.println("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fhourly ad call was trigred");
	logStep("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fhourly ad call was trigred");
}
if(!sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fhourly")) {
System.out.println("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fhourly ad call was not  trigred");
logStep("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fhourly ad call was not  trigred");
Assert.fail("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fhourly ad call was not  trigred");
}
return wfxtriggers_values;

}

public static void  Verifyheavyrainfallalert() throws Exception{
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fhourly")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().indexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fhourly"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("alert%3D"),required_info.indexOf("%26atfid"));			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String Alert=expectedValues.replaceAll("%3D", "=");
			
			if(expectedValues.contains("heavyrain")) {
				System.out.println("rain/snow push notification alert cust param value is "     +Alert);
				logStep("rain/snow push notification alert cust param value is "     +Alert);
			}
			else {
				System.out.println("heavy rain fall push notification alert cust param value is "      + Alert);
				logStep("heavy rain fall  push notification alert cust param value is "      + Alert);
				Assert.fail("heavy rain fall push notification alert cust param value is "      + Alert);
			}
			//System.out.println(expectedValues);
			
		}
}

public static void  Verifythunderstormalert() throws Exception{
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fhourly")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fhourly"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("alert%3D"),required_info.indexOf("%26atfid"));			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String Alert=expectedValues.replaceAll("%3D", "=");
			
			if(expectedValues.contains("thunderstm")) {
				System.out.println("thunderstorm push notification alert cust param value is "     +Alert);
				logStep("thunderstorm push notification alert cust param value is "     +Alert);
			}
			else {
				System.out.println("thunderstorm push notification alert cust param value is "      + Alert);
				Assert.fail("thunderstorm push notification alert cust param value is "      + Alert);
			}
			//System.out.println(expectedValues);
			
		}
}

public static Map<String, String> finding_daily_details_card_iu_value() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	String expected_data = null;
	String today = null;
	try {
    today=Ad.findElementById("com.weather.Weather:id/daily_details_day_title").getText();
	}catch(Exception e) {
		
	}
	String days=today.replace(today, today+1);
	//System.out.println("day from the UI is  " +day);
	//logStep("day from the UI is  " +day);
	String currentday1=days.toLowerCase();
	DeviceStatus device_status = new DeviceStatus();
	
	
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2F10day_")) {
		
			try {			
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2F10day_"));
	//		String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("&amp"));
			 expected_data = Read_API_Call_Data.toString().substring(Read_API_Call_Data.indexOf("iu"),Read_API_Call_Data.indexOf("&correlator"));
			System.out.println("Charles data value is "+expected_data);
			logStep("Charles data value is "+expected_data);			
				}
			catch(Exception e) {
				
			}
		}
	else {
		System.out.println("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2F10day_"+currentday1 +" was not trigered");
		logStep("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2F10day_"+currentday1 +" was not trigered");
		Assert.fail("daily details ad call was not trigred");
	}

return wfxtriggers_values;
}

public static void  Verifyheavysnowfallalert() throws Exception{
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2F10day")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2F10day"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("alert%3D"),required_info.indexOf("%26atfid"));			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String Alert=expectedValues.replaceAll("%3D", "=");
			
			if(expectedValues.contains("heavysnow")) {
				System.out.println("heavy snowfall push notification alert cust param value is "     +Alert);
				logStep("heavy snowfall push notification alert cust param value is "     +Alert);
			}
			else {
				System.out.println("heavy snowfall cold push notification alert cust param value is "      + Alert);
				logStep("heavy snowfall cold push notification alert cust param value is "      + Alert);
				Assert.fail("heavy snowfall push notification alert cust param value is "      + Alert);
			}
			//System.out.println(expectedValues);
			
		}
}

public static Map<String, String> findind_alertsiu_value() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Falerts")) {
	System.out.println("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Falerts ad call was trigred");
	logStep("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Falerts ad call was trigred");
}
if(!sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Falerts")) {
System.out.println("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Falerts ad call was not  trigred");
logStep("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Falerts ad call was not  trigred");
Assert.fail("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Falerts ad call was not  trigred");
}
return wfxtriggers_values;
}


public static void  VerifysevereAlert() throws Exception{
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Falerts")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Falerts"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("alert%3D"),required_info.indexOf("%26atfid"));			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String Alert=expectedValues.replaceAll("%3D", "=");
			
			if(expectedValues.contains("severe")) {
				System.out.println("Severe push notification alert cust param value is "     +Alert);
				logStep("Severe push notification alert cust param value is "     +Alert);
			}
			else {
				System.out.println("Severe push notification alert cust param value is"      + Alert);
				logStep("Severe push notification alert cust param value is"      + Alert);
				Assert.fail("Severe push notification alert cust param value is"      + Alert);
			}
			//System.out.println(expectedValues);
			
		}
	
}


public static void  Verifyicealert() throws Exception{
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2F10day")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2F10day"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("alert%3D"),required_info.indexOf("%26atfid"));			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String Alert=expectedValues.replaceAll("%3D", "=");
			
			if(expectedValues.contains("ice")) {
				System.out.println("ice push notification alert cust param value is "     +Alert);
				logStep("ice push notification alert cust param value is "     +Alert);
			}
			else {
				System.out.println("ice push notification alert cust param value is "      + Alert);
				logStep("ice push notification alert cust param value is "      + Alert);
				Assert.fail("ice push notification alert cust param value is "      + Alert);
			}
			//System.out.println(expectedValues);
			
		}
}
public static void  VerifyWBNAlert() throws Exception{
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fbreaking")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fbreaking"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("alert%3D"),required_info.indexOf("%26atfid"));			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String Alert=expectedValues.replaceAll("%3D", "=");
			
			if(expectedValues.contains("breaking")) {
				System.out.println("Winter Breaking news push notification alert cust param value is "     +Alert);
				logStep("Winter Breaking news push notification alert cust param value is "     +Alert);
			}
			else {
				System.out.println("Winter Breaking news push notification alert cust param value is"      + Alert);
				logStep("Winter Breaking news push notification alert cust param value is"      + Alert);
				Assert.fail("Winter Beaking news push notification alert cust param value is"      + Alert);
			}
			//System.out.println(expectedValues);
			
		}
	
}

public static void  VerifyRTLAlert() throws Exception{
		
		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();
		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
			if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps")){
				String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps"));
				String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
				String expected_data = required_info.toString().substring(required_info.indexOf("alert%3D"),required_info.indexOf("%26atfid"));			
				//6sod%3Dno%
				String expectedValues = expected_data.toString();
				String Alert=expectedValues.replaceAll("%3D", "=");
				
				if(expectedValues.contains("lightning")) {
					System.out.println("real time lightning  push notification alert cust param value is "     +Alert);
					logStep("real time lightning  push notification alert cust param value is "     +Alert);
				}
				else {
					System.out.println("real time lightning  push notification alert cust param value is "      + Alert);
					logStep("real time lightning  push notification alert cust param value is "      + Alert);
					Assert.fail("real time lightning  push notification alert cust param value is "      + Alert);
				}
				//System.out.println(expectedValues);
				
			}
	}
public static void clickNotification(String notification) throws Exception {
	
	String text=Ad.findElementById("android:id/title").getText();
		Thread.sleep(5000);
			if(text.contains(notification)) {
			Ad.findElementById("android:id/title").click();
				Thread.sleep(3000);
			}
		}
		
private static By ByAccessibilityId(String string) {
	// TODO Auto-generated method stub
	return null;
}

public static void tapping() {
	Ad.tap(1, 763, 2296, 3000);
}

public static  void Verify_Privacy_Card_onScreen() throws Exception{
	Thread.sleep(8000);
	String Module = null;
	logStep("Scroll the app till Privay card");
	System.out.println("Scroll the app till Privay card");
	for(int i=0;i<20;i++)
	{
		try {
		AppiumFunctions.SwipeUp_Counter(i);
	}
		
		catch(Exception e) {
		
		}
	}		
	}


//Swipe based on counter  //by naresh
	public static void Swipe_Conter(int Counter) throws Exception{

		int swipe = Counter;

		for(int i=1;i<=swipe ;i++){
AppiumFunctions.Swipe_feed();
			Thread.sleep(2000);
		}
	
}
	

public static  void selecting_opt_out_mode() throws Exception{
		
		//Clicking privacy arrow button
		/*System.out.println("Clicking privacy arrow button");
		logStep("Clicking privacy arrow button");
	    Ad.findElementById("com.weather.Weather:id/privacy_card_personal_info_container").click();*/
	    Thread.sleep(8000);
		Swipe_Conter(10);
		 Thread.sleep(10000);
		 TouchAction ta=new TouchAction(Ad);
		 ta.tap(480, 1369).perform();
		//Selecting  Opt out  mode option in privacy card
		System.out.println("Selecting  Opt out  mode option in privacy card");
		logStep("Selecting  Opt out  mode option in privacy card");
		 Thread.sleep(3000);		
	}


public static void SwipeUp_Counter_video_maps_feedcards(int Counter) throws Exception{
	int swipeup = Counter;
//System.out.println("swipeup");
	for(int i=1;i<=swipeup ;i++){
		AppiumFunctions.Swipe_feed();
		String ModuleName;
		try {
		if(Ad.findElementById("com.weather.Weather:id/header_title").isDisplayed()) {
			try {
 ModuleName=Ad.findElementById("com.weather.Weather:id/header_title").getAttribute("text");
			}
catch(Exception e) {
 ModuleName=Ad.findElementById("com.weather.Weather:id/header_title").getText();
}
	System.out.println(ModuleName.toString() +" feed card is presented on the screen");
	
	if(ModuleName.toString().contains("Top Stories") ||ModuleName.toString().contains("Low Stories") || ModuleName.toString().contains("Videos")){
		
		AppiumFunctions.clickOnVideoElement();
	AppiumFunctions.clickOnBackArrowElement();
		}
if(ModuleName.toString().contains("Maps") ||ModuleName.toString().contains("Thunderstorms possible") || ModuleName.toString().contains("Thunderstorms ending") || ModuleName.toString().contains("Thunderstorms starts")||ModuleName.toString().contains("Dry conditions")) {
AppiumFunctions.clickOnRadarMaps();
	AppiumFunctions.clickOnBackArrowElement();
	i=50;
	break;
	
}
		}
		}
		catch(Exception e) {
			try {
			Swipe();
			Ad.findElementById("com.weather.Weather:id/header_title").isDisplayed();
			}
			catch(Exception e1) {
				Swipe();
			}
	
			
		}
			}	
}

public static void Verify_video_ad_call_Optoutmode( )throws Exception{
	  read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
		System.out.println("Verifying   iu=%2F7646%2Fapp_android_us%2Fvideo  ad call");
		logStep("Verifying iu=%2F7646%2Fapp_android_us%2Fvideo ad calll");
	if(sb.contains("%2F7646%2Fapp_android_us%2Fvideo")) {
	System.out.println("/7646/app_android_us/video call was trigred");
	logStep("/7646/app_android_us/video call was trigred");
	}

	if(!sb.contains("%2F7646%2Fapp_android_us%2Fvideo")) {
	System.out.println("/7646/app_android_us/video call was not trigred");
	logStep("/7646/app_android_us/video call was not trigred");
	Assert.fail("/7646/app_android_us/video call was not trigred");

	}

	}

public static void verifying_feedcalls(int i) throws Exception {


	String expected_data = null;
	String today=null;
	String day1=null;
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	String[][] exceldata=read_excel_data.exceldataread("feedcards");
//	logStep("Verifying  SOD custum param for  iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fradar ad call");
	//String feed="iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_";
	String feed=exceldata[1][1];
	       logStep("checking for " +feed+i);
			System.out.println("checking for "  +feed+i);
			logStep("Verifying iu value should't be nl");
			System.out.println("Verifying iu value should't be nl");
	if(i!=1) {
		if(sb.contains(feed+i) &&  !(feed+i).isEmpty() && !(feed+i).contains("nl") ) {			
		System.out.println(feed+i +" call was trigred");
		logStep(feed+i +" call was trigred");
		
		String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(feed+i));
		//		String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("&amp"));
				 expected_data = Read_API_Call_Data.toString().substring(Read_API_Call_Data.indexOf("iu"),Read_API_Call_Data.indexOf("&correlator="));
				String val[]=expected_data.split("&");
		
				System.out.println("Size of the "+feed+i+" is  " + val[1]);
				logStep("Size of the "+feed+i+" is " + val[1]);
		//	System.out.println("Charles data value is "+expected_data);
		//	logStep("Charles data value is "+expected_data);			
		
		}	else{
			System.out.println(feed+i +"call was not trigred");
			logStep(feed+i +" call was not trigred");
		     Assert.fail(feed+i + " call was not trigred");
			}
		}
	
	 if(i==1) {
		if(sb.contains(feed+i) &&  !(feed+i).isEmpty()) {			
			System.out.println(feed+i +" call was trigred");
			logStep(feed+i +" call was trigred");
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("sz=320x50%7C320x100"));
			
			//		String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("&amp"));
					 expected_data = Read_API_Call_Data.toString().substring(Read_API_Call_Data.indexOf("sz"),Read_API_Call_Data.indexOf("&correlator="));
					 expected_data= expected_data .replace("%7C", "|");
			      String val[]=expected_data.split("&");
			      System.out.println("Size of the "+feed+i+" is  " + val[0]);
					logStep("Size of the "+feed+i+" is " + val[0]);
			
			 
		}
		
	 
		else {
			System.out.println(feed+i +"call was not trigred");
			logStep(feed+i +" call was not trigred");
		     Assert.fail(feed+i + " call was not trigred");
		}
	 }
	
	
}
public static void Verifying_detail_gampadcalls_Optoutmode() throws Exception{
	
read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	//CharlesFunctions.ExportSession();
	System.out.println("Verifying  iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps ad call");
	logStep("Verifying iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps ad calll");
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps")) {
	System.out.println("iu=/7646/app_android_us/db_display/details/maps call was trigred");
	logStep("iu=/7646/app_android_us/db_display/details/maps call was trigred");
}
if(!sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps")) {
	System.out.println("iu=/7646/app_android_us/db_display/details/maps call was not trigred");
	logStep("iu=/7646/app_android_us/db_display/details/maps call was not trigred");
Assert.fail("iu=/7646/app_android_us/db_display/details/maps call was not trigred");
}
}



public static Map<String, String> validating_bcp_privacy_Optoutmode_scenarion() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();	
	logStep("Verifying for  https://bcp.crwdcntrl.net api url");
	if(sb.contains("bcp.crwdcntrl.net")) {
	logStep("https://bcp.crwdcntrl.net/ url was trigred");
	System.out.println("https://bcp.crwdcntrl.net/ url was trigred");
	Assert.fail("https://bcp.crwdcntrl.net/ url was trigred");
	
}
if(!sb.contains("bcp.crwdcntrl.net")) {
	logStep("https://bcp.crwdcntrl.net/ url was not trigred");
System.out.println("https://bcp.crwdcntrl.net/ url was not trigred");

}
return wfxtriggers_values;
}
	
public static Map<String, String> validating_adcrw_privacy_Optoutmode_scenarion()  throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();	
	//https://ad.crwdcntrl.net
	logStep("Verifying  https://ad.crwdcntrl.net api url");
	if(sb.contains("ad.crwdcntrl.net")) {
		System.out.println("https://ad.crwdcntrl.net/ url was trigred");
		logStep("https://ad.crwdcntrl.net/ url was trigred");
		Assert.fail("https://ad.crwdcntrl.net/ url was trigred");
	
}
if(!sb.contains("ad.crwdcntrl.net")) {
	logStep("https://ad.crwdcntrl.net/ url was  not trigred");
	System.out.println("https://ad.crwdcntrl.net/ url was  not trigred");
}
return wfxtriggers_values;
}


public static Map<String, String> validating_Fatualcall_privacy_Optoutmode_scenarion() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();	
logStep("Verifying https://location.wfxtriggers.com api url");
	if(sb.contains("location.wfxtriggers.com")) {
		logStep("https://location.wfxtriggers.com url was  trigred");
		System.out.println("https://location.wfxtriggers.com url was  trigred");
		Assert.fail("https://location.wfxtriggers.com url was  trigred");
		}

if(!sb.contains("location.wfxtriggers.com")) {
	logStep("https://location.wfxtriggers.com url was not trigred");
System.out.println("https://location.wfxtriggers.com url was not trigred");

}
return wfxtriggers_values;
}
public static Map<String, String> validating_aax_privacy_Optoutmode_scenarion() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();	
	if(sb.contains("aax")) {
		System.out.println("amazon aax calls  was trigred");
		Assert.fail("amazon aax calls  was trigred");
		}

if(!sb.contains("aax")) {
System.out.println("amazon aax calls was not trigred");

}
return wfxtriggers_values;
}
public static void validating_aax_privacy_Optoutmode_scenario() throws Exception{

	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	logStep("Verifying for amazon aax calls");
	//System.out.println("Slot Name is  : "+slotID);
	if(sb.contains("752a96eb-3198-4991-b572-17ec04883b6c")) {
	System.out.println("amazon aax slot id's are  trigreed for privacy Optoutmode scenario");
	logStep("amazon aax slot id's are  trigreed for privacy Optoutmode scenario");
	Assert.fail("amazon aax slot id's are  trigreed for privacy Optoutmode scenario");
	}
	if(!sb.contains("752a96eb-3198-4991-b572-17ec04883b6c")) {
	logStep("amazon aax slot id's are  not trigreed for privacy Optoutmode scenario");
	System.out.println("amazon aax slot id's are  not trigreed for privacy Optoutmode scenario");
		
		}
	

}
public static Map<String, String> finding_Homescreen_marquee_iu_value() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	logStep("checking for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee ad call");
	System.out.println("checking for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee ad call");
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee")) {
	System.out.println("iu=/7646/app_android_us/db_display/home_screen/marquee call was trigred");
	logStep("iu=/7646/app_android_us/db_display/home_screen/marquee call was trigred");
}
if(!sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee")) {

	System.out.println("iu=/7646/app_android_us/db_display/home_screen/marquee call was not trigred");
	logStep("iu=/7646/app_android_us/db_display/home_screen/marquee call was not trigred");
    Assert.fail("iu=/7646/app_android_us/db_display/home_screen/marquee call was not trigred");
}
return wfxtriggers_values;
}


public static void validate_SOD_Cust_param_homescreenHourly_Optoutmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	//String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
	logStep("Verifying  SOD custum param for  iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly ad call");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("sod%3D"),required_info.indexOf("%26tmp%3D"));
			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String SOD=expectedValues.replaceAll("%3D", "=");
			
			if(SOD.contains("no")) {
				System.out.println("SOD cust param value for   iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly  is " +SOD);
				logStep("SOD cust param value for   iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%%2Fhourly  is " +SOD);
			}
			else {
				System.out.println("SOD cust param value for   iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly   is not matchged with"     +SOD);
				logStep("SOD cust param value for   iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly  is not matchged with"     +SOD);
				Assert.fail("SOD cust param value for   iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly  is not matchged with"     +SOD);
			}
			//System.out.println(expectedValues);
			
		}
}


public static void validate_SOD_Cust_param_homescreen_Optoutmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	//String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
	logStep("Verifying  SOD custum param for  iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1 ad call");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("sod%3D"),required_info.indexOf("%26tmp%3D"));
			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String SOD=expectedValues.replaceAll("%3D", "=");
			
			if(SOD.contains("no")) {
				System.out.println("SOD cust param value for  iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1 is " +SOD);
				logStep("SOD cust param value for  iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1 is " +SOD);
			}
			else {
				System.out.println("SOD cust param value for  iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1 is not matchged with"     +SOD);
				logStep("SOD cust param value for  iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1 is not matchged with"     +SOD);
				Assert.fail("SOD cust param value for  iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1 is not matchged with"     +SOD);
			}
			//System.out.println(expectedValues);
			
		}
}



public static void validate_SOD_Cust_param_homescreenmarquee_Optoutmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
	logStep("Verifying  SOD custum param for  iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee ad call");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("sod%3D"),required_info.indexOf("%26tmp%3D"));
			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String SOD=expectedValues.replaceAll("%3D", "=");
			
			if(SOD.contains("no")) {
				System.out.println("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee is " +SOD);
				logStep("SOD cust param value for  iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee is " +SOD);
			}
			else {
				System.out.println("SOD cust param value for  iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee is not matchged with"     +SOD);
				logStep("SOD cust param value for  iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee is not matchged with"     +SOD);
				Assert.fail("SOD cust param value for  iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee is not matchged with"     +SOD);
			}
			//System.out.println(expectedValues);
			
		}
}

public static void validate_SOD_Cust_param_feed_Optoutmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
	logStep("Verifying  SOD custum param for  iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fradar ad call");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fradar")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fradar"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("sod%3D"),required_info.indexOf("%26tmp%3D"));
			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String SOD=expectedValues.replaceAll("%3D", "=");
			
			if(SOD.contains("no")) {
				System.out.println("SOD cust param value for Feed call is " +SOD);
				logStep("SOD cust param value for Feed call is " +SOD);
			}
			else {
				System.out.println("SOD cust param value for Feed call is not matchged with"     + SOD);
				logStep("SOD cust param value for Feed call is not matchged with"     + SOD);
				Assert.fail("SOD cust param value for Feed call is not matchged with"     + SOD);
			}
			//System.out.println(expectedValues);
			
		}
}

public static void validate_SOD_Cust_param_deatiledfeed_Optoutmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
//	String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
	logStep("Verifying  SOD custum param for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps ad call");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("sod%3D"),required_info.indexOf("%26tmp%3D"));
			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String SOD=expectedValues.replaceAll("%3D", "=");
			
			if(SOD.contains("no")) {
				System.out.println("SOD cust param value for  iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps ad call is " +SOD);
				logStep("SOD cust param value for  iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps ad call is " +SOD);
			}
			else {
				System.out.println("SOD cust param value for deatiled  iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps ad call is not matchged with"     + SOD);
				logStep("SOD cust param value for deatiled  iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps ad call is not matchged with"     + SOD);
				Assert.fail("SOD cust param value for deatiled  iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps ad call is not matchged with"     + SOD);
			}
			//System.out.println(expectedValues);
			
		}
}

public static void validate_SOD_Cust_param_video_Optoutmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
	logStep("Verifying  SOD custum param for iu=%2F7646%2Fapp_android_us%2Fvideo ad call");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fvideo")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fvideo"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("sod%3D"),required_info.indexOf("&amp"));
			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String SOD=expectedValues.replaceAll("%3D", "=");
			
			if(SOD.contains("no")) {
				System.out.println("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fvideo ad call is " +SOD);
				logStep("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fvideo ad call is " +SOD);
			}
			else {
				System.out.println("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fvideo ad call is not matchged with"     + SOD);
				logStep("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fvideo ad call is not matchged with"     + SOD);
				Assert.fail("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fvideo ad call is not matchged with"     + SOD);
			}
			//System.out.println(expectedValues);
			
		}
}

public static void validate_RDP_homescreen_Optoutmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	//String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
	logStep("Verifying RDP keyword in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1  ad call url");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1"));
		
		if(sb.contains("rdp=1")){
			System.out.println("RDP value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1 ad call is " +"1");	
			logStep("RDP value for feed_1 ad call is " +"1");
			}
		else {
				System.out.println("RDP  value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1 ad call is not matchged with"     +"1");
				logStep("RDP  value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1 ad call is not matchged with"     +"1");
				Assert.fail("RDP  value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1 ad call is not matchged with"     +"1");
			}
			
		}
}

public static void validate_RDP_homescreenmarquee_Optoutmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	//String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
	logStep("Verifying RDP keyword in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee  ad call url");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee"));
		
		if(sb.contains("rdp=1")){
			System.out.println("RDP value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee ad call is " +"1");	
			logStep("RDP value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee  ad call is " +"1");
			}
		else {
				System.out.println("RDP  value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee ad call is not matchged with"     +"1");
				logStep("RDP  value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee ad call is not matchged with"     +"1");
				Assert.fail("RDP  value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee ad call is not matchged with"     +"1");
			}
			
		}
}


public static void validate_RDP_homescrenhourly_Optoutmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	//String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
	logStep("Verifying RDP keyword in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly  ad call url");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly"));
		
		if	(sb.contains("rdp=1")){
			System.out.println("RDP value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly ad call is " +"1");	
			logStep("RDP value for feed_1 ad call is " +"1");
			}
		else {
				System.out.println("RDP  value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly ad call is not matchged with"     +"1");
				logStep("RDP  value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly ad call is not matchged with"     +"1");
				Assert.fail("RDP  value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly ad call is not matchged with"     +"1");
			}
			
		}
}


public static void validate_RDP_feed_Optoutmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	//String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
	logStep("Verifying RDP keyword in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fradar  ad call url");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fradar")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fradar"));
		
		if	(Read_API_Call_Data.contains("rdp=1")){
			System.out.println("RDP value for feed ad call is " +"1");	
			logStep("RDP value for feed ad call is " +"1");
			}
		else {
				System.out.println("RDP  value for feed ad call is not matchged with"     +"1");
				logStep("RDP  value for feed ad call is not matchged with"     +"1");
				Assert.fail("RDP for feed ad call call  is not matchged with"     +"1");
			}
			
		}
}

public static void validate_RDP_detailed_feed_Optoutmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	//String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
	logStep("Verifying RDP keyword in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps  ad call url");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps"));
		
		if(sb.contains("rdp")){
			System.out.println("RDP value for  iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps ad call is " +"1");	
			logStep("RDP value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps ad call is " +"1");
			}
		else {
				System.out.println("RDP  value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps ad call is not matchged with"     +"1");
				logStep("RDP  value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps ad call is not matchged with"     +"1");
				Assert.fail("RDP for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps ad call  is not matched with"     +"1");
			}
			
		}
}

public static void validate_RDP_video_ad_Optoutmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	//String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
	logStep("Verifying RDP keyword in iu=%2F7646%2Fapp_android_us%2Fvideo  ad call url");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fvideo")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fvideo"));
		
		if	(sb.contains("rdp=1")){
			System.out.println("RDP value for iu=%2F7646%2Fapp_android_us%2Fvideo  ad call is " +"1");	
			logStep("RDP value for iu=%2F7646%2Fapp_android_us%2Fvideo ad call is " +"1");
			}
		else {
				System.out.println("RDP  value for iu=%2F7646%2Fapp_android_us%2Fvideo ad call is not matchged with"     +"1");
				logStep("RDP  value for iu=%2F7646%2Fapp_android_us%2Fvideo ad call is not matchged with"     +"1");
				Assert.fail("RDP for iu=%2F7646%2Fapp_android_us%2Fvideo ad call  is not matchged with"     +"1");
			}
			
		}
}
public static void finding_Homescreen_iu_value() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	System.out.println("Verifying for  iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly ad call");
	logStep("Verofying for  iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly ad call");
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly")) 
{
	System.out.println("iu=/7646/app_android_us/db_display/home_screen/hourly call was trigred");
	logStep("7646/app_android_us/db_display/home_screen/hourly call was trigred");
}
if(!sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly")) {
	System.out.println("iu=/7646/app_android_us/db_display/home_screen/hourly call was not trigred");
	logStep("iu=/7646/app_android_us/db_display/home_screen/hourly call was not trigred");
    Assert.fail("iu=/7646/app_android_us/db_display/home_screen/hourly call was not trigred");
}
}

public static  void selecting_opt_in_mode() throws Exception{
	
	   Thread.sleep(8000);
			Swipe_Conter(10);
	 Thread.sleep(30000);
	  //Selecting  Opt out  mode option in privacy card
		System.out.println("Selecting  Opt in  mode option in privacy card");
		logStep("Selecting  Opt in  mode option in privacy card");
	  TouchAction ta=new TouchAction(Ad);
	 ta.tap(347, 1070).perform();
	 Ad.findElementById("com.weather.Weather:id/popup_positive_button").click();
	    Thread.sleep(10000);
   //Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[4]/android.widget.ListView/android.view.View[2]").click();	
}

public static Map<String, String> validating_bcp_privacy_Optinmode_scenarion() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();	
	logStep("Verifying for https://bcp.crwdcntrl.net url ");
	if(sb.contains("bcp.crwdcntrl.net")) {
		System.out.println("https://bcp.crwdcntrl.net/ url was trigred");
		logStep("https://bcp.crwdcntrl.net/ url was trigred");

}
if(!sb.contains("bcp.crwdcntrl.net")) {
	System.out.println("https://bcp.crwdcntrl.net/ url was not trigred");
	logStep("https://bcp.crwdcntrl.net/ url was not trigred");
	Assert.fail("https://bcp.crwdcntrl.net/ url was not trigred");


}
return wfxtriggers_values;
}
	
public static Map<String, String> validating_adcrw_privacy_Optinmode_scenarion()  throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();	
	//https://ad.crwdcntrl.net
	logStep("Verifying for https://ad.crwdcntrl.net  url ");
	if(sb.contains("ad.crwdcntrl.net")) {
		System.out.println("https://ad.crwdcntrl.net url was trigred");
		logStep("https://ad.crwdcntrl.net/ url was trigred");
}
if(!sb.contains("ad.crwdcntrl.net")) {
	System.out.println("https://ad.crwdcntrl.net/ url was not trigred");
	logStep("https://ad.crwdcntrl.net/ url was not trigred");
	Assert.fail("https://ad.crwdcntrl.net/ url was not trigred");
	
}
return wfxtriggers_values;
}
public static Map<String, String> validating_Fatualcall_privacy_Optinmode_scenarion() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();	
	logStep("Verifying forlocation.wfxtriggers.com url ");
	if(sb.contains("location.wfxtriggers.com")) {
		System.out.println("https://location.wfxtriggers.com url was trigred");
		logStep("https://location.wfxtriggers.com url was trigred");
		}

if(!sb.contains("location.wfxtriggers.com")) {
	System.out.println("https://location.wfxtriggers.com url was not trigred");
	logStep("https://location.wfxtriggers.com url was not trigred");
	Assert.fail("https://location.wfxtriggers.com url was not trigred");


}
return wfxtriggers_values;
}
public static Map<String, String> validating_aax_privacy_Optinmode_scenarion() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();	
	if(sb.contains("aax")) {
		System.out.println("amazon aax calls was trigred");
		}

if(!sb.contains("aax")) {
	System.out.println("amazon aax calls  was not trigred");
	Assert.fail("amazon aax calls  were not trigred");


}
return wfxtriggers_values;
}
public static void validating_aax_privacy_Optinmode_scenario() throws Exception{

	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	logStep("Verifying for amazon aax calls");
	//System.out.println("Slot Name is  : "+slotID);
	if(sb.contains("869c843c-7cf8-47ae-b6ed-088057e4bc8a")) {
	System.out.println("amazon aax slot id's are  trigreed for privacy Optinmode scenario");
	logStep("amazon aax slot id's are  trigreed for privacy Optinmode scenario");
	
	}
	if(!sb.contains("869c843c-7cf8-47ae-b6ed-088057e4bc8a")) {
		System.out.println("amazon aax slot id's  are  not trigreed for privacy Optinmode scenario");
		logStep("amazon aax slot id's  are  not trigreed for privacy Optinmode scenario");
		Assert.fail("amazon aax slot id's  are  not trigreed for privacy Optinmode scenario");
		
		}
	

}
public static void validate_SOD_Cust_param_homescreen_Optinmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
	logStep("Verifying the  SOD custum parameter in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee ad call");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("sod%3D"),required_info.indexOf("%26tmp%3D"));
			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String SOD=expectedValues.replaceAll("%3D", "=");
			
			if(SOD.contains("yes")) {
				System.out.println("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee call is " +SOD);
				logStep("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee call is " +SOD);
			}
			else {
				System.out.println("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee call is not matchged with"     +SOD);
				logStep("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee call is not matchged with"     +SOD);
				Assert.fail("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee call is not matchged with"     +SOD);
			}
			//System.out.println(expectedValues);
			
		}
}

public static void validate_SOD_Cust_param_homescreenhourly_Optinmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
	logStep("Verifying the  SOD custum parameter in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly ad call");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("sod%3D"),required_info.indexOf("%26tmp%3D"));
			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String SOD=expectedValues.replaceAll("%3D", "=");
			
			if(SOD.contains("yes")) {
				System.out.println("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly call is " +SOD);
				logStep("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly call is " +SOD);
			}
			else {
				System.out.println("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly call is not matchged with"     +SOD);
				logStep("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly call is not matchged with"     +SOD);
				Assert.fail("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly call is not matchged with"     +SOD);
			}
			//System.out.println(expectedValues);
			
		}
}

public static void validate_SOD_Cust_param_feed_Optinmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
	logStep("Verifying the  SOD custum parameter in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1 ad call");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("sod%3D"),required_info.indexOf("%26tmp%3D"));
			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String SOD=expectedValues.replaceAll("%3D", "=");
			
			if(SOD.contains("yes")) {
				System.out.println("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1 call is " +SOD);
				logStep("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1 call is " +SOD);
			}
			else {
				System.out.println("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1 call is not matchged with"     + SOD);
				logStep("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1 call is not matchged with"     + SOD);
				Assert.fail("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1 call is not matchged with"     + SOD);
			}
			//System.out.println(expectedValues);
			
		}
}

public static void validate_SOD_Cust_param_deatiledfeed_Optinmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
	logStep("Verifying the  SOD custum parameter in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps call");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("sod%3D"),required_info.indexOf("%26tmp%3D"));
			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String SOD=expectedValues.replaceAll("%3D", "=");
			
			if(SOD.contains("yes")) {
				System.out.println("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps ad call is " +SOD);
				logStep("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps ad call is " +SOD);
			}
			else {
				System.out.println("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps ad call is not matchged with"     + SOD);
				logStep("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps ad call is not matchged with"     + SOD);
				Assert.fail("SOD cust param value for deatiled iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps call is not matchged with"     + SOD);
			}
			//System.out.println(expectedValues);
			
		}
}

public static void validate_SOD_Cust_param_video_Optinmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
	logStep("Verifying the  SOD custum parameter in iu=%2F7646%2Fapp_android_us%2Fvideo call");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fvideo")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fvideo"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("sod%3D"),required_info.indexOf("&amp"));
			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String SOD=expectedValues.replaceAll("%3D", "=");
			
			if(SOD.contains("yes")) {
				System.out.println("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fvideo ad call is " +SOD);
				logStep("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fvideo ad call is " +SOD);
			}
			else {
				System.out.println("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fvideo ad call is not matchged with"     + SOD);
				logStep("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fvideo ad call is not matchged with"     + SOD);
				Assert.fail("SOD cust param value for iu=%2F7646%2Fapp_android_us%2Fvideo ad call is not matchged with"     + SOD);
			}
			//System.out.println(expectedValues);
			
		}
}

public static void validate_RDP_homescreen_Optinmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	//String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
	logStep("Verifying RDP keyword in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee ad call url");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee"));
		
		if	(sb.contains("rdp=1")){
			System.out.println("RDP key word preseted in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee call url");	
			logStep("RDP key word preseted in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee call url");
			Assert.fail("RDP key word preseted in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee call url");
			}
		else {
			System.out.println("RDP key word is not preseted in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee call url");
          logStep("RDP key word is not preseted in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee call url");
			}
			
		}
}

public static void validate_RDP_homescreenhourly_Optinmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	//String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
	logStep("Verifying RDP keyword in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly ad call url");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly"));
		
		if(sb.contains("rdp=1")){
			System.out.println("RDP key word preseted in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly call url");	
			logStep("RDP key word preseted in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly call url");
			Assert.fail("RDP key word preseted in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly call url");
			}
		else {
			System.out.println("RDP key word is not preseted in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly call url");
          logStep("RDP key word is not preseted in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly call url");
			}
			
		}
}


public static void validate_RDP_feed_Optinmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	//String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
	logStep("Verifying RDP keyword in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1  ad call url");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1"));
		
		if(sb.contains("rdp=1")){
			System.out.println("RDP key word preseted in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1 ad call url");	
			logStep("RDP key word preseted in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1 ad call url");
			Assert.fail("RDP key word preseted in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1 ad call url");
			}
		else {
				System.out.println("RDP key word is not preseted in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1 ad call url");
				logStep("RDP key word is not preseted in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Ffeed%2Ffeed_1 ad call url");
			
			}
			
		}
}

public static void validate_RDP_detailed_feed_Optinmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	//String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
	logStep("Verifying RDP keyword in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps  ad call url");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps"));
		
		if(sb.contains("rdp=1")){
			System.out.println("RDP key word preseted in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps ad call url");	
			logStep("RDP key word preseted in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps ad call url");
			Assert.fail("RDP key word preseted in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps ad call url");
			}
		else {
			System.out.println("RDP key word is not preseted in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps ad call url");
			logStep("RDP key word is not preseted in iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps ad call url");
			}
			
		}
}


public static void validate_RDP_video_ad_Optinmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	//String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
	logStep("Verifying RDP keyword in iu=%2F7646%2Fapp_android_us%2Fvideo  ad call url");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fvideo")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fvideo"));
		
		if	(sb.contains("rdp=1")){
			System.out.println("RDP key word preseted in iu=%2F7646%2Fapp_android_us%2Fvideo ad call url");	
			logStep("RDP key word preseted in iu=%2F7646%2Fapp_android_us%2Fvideo ad call url");
			Assert.fail("RDP key word preseted in iu=%2F7646%2Fapp_android_us%2Fvideo ad call url");
			}
		else {
			System.out.println("RDP key word preseted in not  presented in iu=%2F7646%2Fapp_android_us%2Fvideo call url");	
			logStep("RDP key word preseted in not presented iu=%2F7646%2Fapp_android_us%2Fvideo call url");
			}
			
		}
}


}
