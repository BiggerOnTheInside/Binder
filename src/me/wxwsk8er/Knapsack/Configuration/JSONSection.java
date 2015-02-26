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
import org.json.simple.parser.ParseException;

public class JSONSection implements ConfigurationSection{
	private JSONObject obj;
	
	public JSONSection(JSONObject obj){
		this.obj = obj;
	}
	
	public JSONSection(JSONParser p, String data){
		try {
			this.obj = (JSONObject) p.parse(data);
		} catch (Exception e) {
			e.printStackTrace();
			
			this.obj = null;
		}
	}
	
	@Override
	public Object get(String path) {
		return obj.get(path);
	}

	@Override
	public ConfigurationSection getParent() {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Map<String, Object>> getKeys() {
		return obj.entrySet();
	}

	@Override
	public boolean isSet(String path) {
		return obj.get(path) != null;
	}

	@Override
	public ConfigurationSection createSection(String name, HashMap<?, ?> map) {
		obj.put(name, map);
		
		return new JSONSection(new JSONParser(), obj.get(name).toString());
	}

	@Override
	public String getString(String path) {
		return (String) get(path);
	}

	@Override
	public boolean isString(String path) {
		if(get(path) instanceof String){
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
		return (List<?>) get(path);
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
		return new JSONSection(new JSONParser(), obj.get(path).toString());
	}
}
