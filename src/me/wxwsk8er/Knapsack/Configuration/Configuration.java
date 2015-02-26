/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package me.wxwsk8er.Knapsack.Configuration;

public interface Configuration extends ConfigurationSection{
	public DefaultConfigurationOptions getOptions();
	public Configuration getDefaults();
	public void setDefaults(Configuration defaults);
	public void addDefault(String path, Object object);
}
