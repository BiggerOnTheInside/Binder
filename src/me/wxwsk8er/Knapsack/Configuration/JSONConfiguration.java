/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package me.wxwsk8er.Knapsack.Configuration;

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
			this.jData = parser.parse(this.filePath);
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInt(String path) {
		return (Integer) get(path);
	}

	@Override
	public boolean isInt(String path) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getDouble(String path) {
		return (Double) get(path);
	}

	@Override
	public boolean isDouble(String path) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long getLong(String path) {
		return (String) get(path);
	}

	@Override
	public boolean isLong(String path) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getBoolean(String path) {
		return (String) get(path);
	}

	@Override
	public boolean isBoolean(String path) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public byte getByte(String path) {
		return (String) get(path);
	}

	@Override
	public List<?> getList(String path) {
		return (String) get(path);
	}

	@Override
	public boolean isList(String path) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ConfigurationSection getConfigurationSection(String path) {
		return (String) get(path);
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reload() {
		// TODO Auto-generated method stub
		
	}
}
