/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder;

import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;


public class Time{
	static long lastFPS;
	static int fps;
	
	public static void start() {
		//some startup code
		lastFPS = getTime(); //set lastFPS to current Time
	}
 
 
	/**
	 * Calculate the FPS and set it in the title bar
	 */
	public static void updateFPS() {
	    if (getTime() - lastFPS > 1000) {
	    	GameLoop.fps = fps;
	        fps = 0; //reset the FPS counter
	        lastFPS += 1000; //add one second
	    }
	    
	    fps++;
	}

	
	public static int getFPS(){
		return fps;
	}
	
	public static float getDelta(){
		return (getTime() - lastFPS) / 100;
	}
	
	/**
	 * Get the time in milliseconds
	 * 
	 * @return The system time in milliseconds
	 */
	public static long getTime() {
	    return System.nanoTime() / 1000000;
	}
}
