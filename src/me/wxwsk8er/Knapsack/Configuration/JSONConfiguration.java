/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package me.wxwsk8er.Knapsack.Configuration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONConfiguration extends FileConfiguration{
	private JSONParser parser = null;
	private JSONObject jObject = null;
	private Object jData;
	
	public JSONConfiguration(String filePath){
		this.filePath = filePath;
		this.options = new DefaultConfigurationOptions();
		
		parse();
	}
	
	public JSONConfiguration(String filePath, DefaultConfigurationOptions options){
		this.filePath = filePath;
		this.options = options;
		
		parse();
	}
	
	private void parse(){
		try {
			this.parser = new JSONParser();
			this.jData = parser.parse(new FileReader(this.filePath));
			this.jObject = (JSONObject) jData;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Object get(String path) {
		return jObject.get(path);
	}
	
	@Override
	public ConfigurationSection getParent() {
		return this;
	}

	@Override
	public Set<Map<String, Object>> getKeys() {
		return jObject.entrySet();
	}

	@Override
	public boolean isSet(String path) {
		return jObject.get(path) != null;
	}

	@Override
	public ConfigurationSection createSection(String name, HashMap<?, ?> map) {
		if(!isSet(name)){
			jObject.put(name, map);
			
			return getConfigurationSection(name);
		}
		
		return getConfigurationSection(name);
	}

	@Override
	public String getString(String path) {
		return (String) get(path);
	}

	@Override
	public boolean isString(String path) {
		if(get(path) instanceof Integer){
			return true;
		}
		
		return false;
	}

	@Override
	public int getInt(String path) {
		return (Integer) get(path);
	}

	@Override
	public boolean isInt(String path) {
		if(get(path) instanceof Integer){
			return true;
		}
		
		return false;
	}

	@Override
	public double getDouble(String path) {
		return (Double) get(path);
	}

	@Override
	public boolean isDouble(String path) {
		if(get(path) instanceof Double){
			return true;
		}
		
		return false;
	}

	@Override
	public long getLong(String path) {
		return (Long) get(path);
	}

	@Override
	public boolean isLong(String path) {
		if(get(path) instanceof Long){
			return true;
		}
		
		return false;
	}

	@Override
	public boolean getBoolean(String path) {
		return (Boolean) get(path);
	}

	@Override
	public boolean isBoolean(String path) {
		if(get(path) instanceof Boolean){
			return true;
		}
		
		return false;
	}

	@Override
	public byte getByte(String path) {
		return (Byte) get(path);
	}

	@Override
	public List<?> getList(String path) {
		return (List<?>) jObject.get(path);
	}

	@Override
	public boolean isList(String path) {
		if(get(path) instanceof List<?>){
			return true;
		}
		
		return false;
	}

	@Override
	public ConfigurationSection getConfigurationSection(String path) {
		return new JSONSection(parser, jObject.get(path).toString());
	}

	@Override
	public void save() {
		Writer writer = null;

		try {
		    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.filePath), "utf-8"));
		    writer.write(jObject.toJSONString());
		    writer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void reload() {
		// TODO Auto-generated method stub
		
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
}
