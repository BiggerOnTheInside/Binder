/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder;


public class Time {
	private static long lastTime;
	
	/**
	 * Get the time in milliseconds
	 * 
	 * @return The system time in milliseconds
	 */
	public static long getTime() {
	    return System.nanoTime();
	}
	
	public static int getDelta() {
	    long time = getTime();
	    int delta = (int) (time - lastTime) / 1000;
	    lastTime = time;
	         
	    System.out.println(delta);
	    
	    return delta;
	}
	
	public static void update(){
		lastTime = System.nanoTime();
	}
}
