package ru.greg3d.util;
import org.json.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CapabilitiesLoader {

	protected static Logger LOG = LoggerFactory.getLogger(CapabilitiesLoader.class);
	
	public static DesiredCapabilities loadCapabilities(String fileName, String capabilitiesName){
		String json = IOHelper.readFileToString(fileName, IOHelper.ENCODING_UTF8);
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		try{
		JSONObject obj = new JSONObject(json);
    	
		for(Object name : obj.getJSONObject(capabilitiesName).names()){
    		cap.setCapability(name.toString(), obj.getJSONObject(capabilitiesName).getString(name.toString()));
    		LOG.debug("Cap ->{} Value ->{}",name.toString(), obj.getJSONObject(capabilitiesName).getString(name.toString()));

    	}
		}catch(org.json.JSONException e){
			LOG.error(e.getMessage());
		}
		return cap;
	}
}
