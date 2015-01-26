/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder.event;

import java.util.ArrayList;

public class EventManager {
	private static ArrayList<Listener> listeners = new ArrayList<Listener>();
	
	public static void addListener(Listener a){
		if(!listeners.contains(a)){
			listeners.add(a);
		}
	}
	
	public static void fireEvent(Event e){
		for(Listener a : listeners){
			a.catchEvent(e);
		}
	}
}
