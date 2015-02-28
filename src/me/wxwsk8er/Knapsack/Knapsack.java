/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package me.wxwsk8er.Knapsack;

import java.util.HashMap;

import me.wxwsk8er.Knapsack.Configuration.JSONConfiguration;
import me.wxwsk8er.Knapsack.java.JavaPlugin;

public class Knapsack {
	private HashMap<JavaPlugin, String> plugins;
	
	public static void main(String... a){
		JSONConfiguration b = new JSONConfiguration("/Users/Walt/test.json");
		HashMap<String, Object> o = new HashMap<String, Object>();
		
		System.out.println(b.getString("test"));
		o.put("a", 1);
		b.createSection("testy", o);
		b.save();
	}
}
