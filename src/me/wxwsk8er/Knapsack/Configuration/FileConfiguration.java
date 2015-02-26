/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package me.wxwsk8er.Knapsack.Configuration;


public abstract class FileConfiguration implements ConfigurationSection {
	protected String filePath;
	protected DefaultConfigurationOptions options;
	protected ConfigurationSection main;
	
	public abstract void save();
	public abstract void reload();
	
	public String getPath(){
		return filePath;
	}
	
	public DefaultConfigurationOptions getOptions(){
		return options;
	}
	
	public ConfigurationSection getConfiguration(){
		return main;
	}
}
