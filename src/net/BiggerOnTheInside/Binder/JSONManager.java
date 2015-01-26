/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONManager {
	private JSONParser parser;
	private JSONObject jsonObject;
	private String path;
	private Object jsonData;
	
	public JSONManager(String file, boolean remote){
		this.path = file;
		
		init(remote);
	}
	
	public void init(boolean a){
		this.parser = new JSONParser();
		
		if(!a){
			try {
				this.jsonData = parser.parse(new FileReader(System.getProperty("Binder.home") + path));
				this.jsonObject = (JSONObject) jsonData;
			} 
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else{
			try {
				this.jsonData = parser.parse(this.readUrl(path));
				this.jsonObject = (JSONObject) jsonData;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getString(String path){
		return (String) jsonObject.get(path);
	}
	
	public double getDouble(String path){
		return (Double) jsonObject.get(path);
	}
	
	public int getInt(String path){
		return (Integer) jsonObject.get(path);
	}
	
	public boolean getBoolean(String path){
		return (Boolean) jsonObject.get(path);
	}
	
	public JSONObject getArray(String path){
		return (JSONObject) jsonObject.get(path);
	}
	
	public int getIntFromArray(String arrayPath, String path){
		return (Integer) ((JSONObject) jsonObject.get(arrayPath)).get(path);
	}
	
	public String getStringFromArray(String arrayPath, String path){
		return (String) ((JSONObject) jsonObject.get(arrayPath)).get(path);
	}
	
	public boolean getBooleanFromArray(String arrayPath, String path){
		return (Boolean) ((JSONObject) jsonObject.get(arrayPath)).get(path);
	}
	
	private static String readUrl(String urlString) throws Exception {
	    BufferedReader reader = null;
	    try {
	        URL url = new URL(urlString);
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        
	        while ((read = reader.read(chars)) != -1)
	            buffer.append(chars, 0, read); 

	        return buffer.toString();
	    } finally {
	        if (reader != null)
	            reader.close();
	    }
	}

	private static JSONObject parseString(String s) throws ParseException{
		return (JSONObject)(new JSONParser().parse(s));
	}
	
	class JSONArrayManager{
		public String getString(JSONObject object, String path){
			return (String) object.get(path);
		}
		
		public double getDouble(JSONObject object, String path){
			return (Double) object.get(path);
		}
		
		public int getInt(JSONObject object, String path){
			return (Integer) object.get(path);
		}
		
		public boolean getBoolean(JSONObject object, String path){
			return (Boolean) object.get(path);
		}
	}
}
