/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package me.wxwsk8er.Knapsack.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ConfigurationSection {
	public Object get(String path);
	public ConfigurationSection getParent();
	public Set<Map<String, Object>> getKeys();
	public boolean isSet(String path);
	public ConfigurationSection createSection(String name, HashMap<?, ?> map);
	
	public String getString(String path);
	public boolean isString(String path);
	
	public int getInt(String path);
	public boolean isInt(String path);
	
	public double getDouble(String path);
	public boolean isDouble(String path);
	
	public long getLong(String path);
	public boolean isLong(String path);
	
	public boolean getBoolean(String path);
	public boolean isBoolean(String path);
	
	public byte getByte(String path);
	
	public List<?> getList(String path);
	public boolean isList(String path);
	
	public ConfigurationSection getConfigurationSection(String path);
}
