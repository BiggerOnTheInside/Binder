/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder;

public abstract class Entity implements WorldObject{
	protected String name;
	
	public Entity(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
}
