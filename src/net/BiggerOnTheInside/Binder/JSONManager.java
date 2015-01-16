package net.BiggerOnTheInside.Binder;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONManager {
	private JSONParser parser;
	private JSONObject jsonObject;
	private String path;
	private Object jsonData;
	
	public JSONManager(String file){
		this.path = file;
		
		init();
	}
	
	public void init(){
		this.parser = new JSONParser();
		try {
			this.jsonData = parser.parse(new FileReader(path));
			this.jsonObject = (JSONObject) jsonData;
		} 
		catch(Exception e) {
			e.printStackTrace();
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
	
	public int getIntFromArray(JSONArray array, String path){
		return (Integer) array.get(array.indexOf(path));
	}
	
	public String getStringFromArray(String arrayPath, String path){
		return (String) ((JSONObject) jsonObject.get(arrayPath)).get(path);
	}
	
	public boolean getBooleanFromArray(String arrayPath, String path){
		return (Boolean) ((JSONObject) jsonObject.get(arrayPath)).get(path);
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
