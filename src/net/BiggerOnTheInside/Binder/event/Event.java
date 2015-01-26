/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder.event;

public abstract class Event {

	
	private boolean isCanceled;
	
	public abstract Event getEvent();
	public abstract String getEventName();
	//public abstract EventHandler getHandler();
	public abstract Event getType();
	
	public void setCanceled(boolean a){
		this.isCanceled = a;
	}
	
	public boolean isCanceled(){
		return this.isCanceled;
	}
}
