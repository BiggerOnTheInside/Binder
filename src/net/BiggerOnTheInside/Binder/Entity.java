/***************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                           */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/Binder.txt)   */
/***************************************************************************************************/
package net.BiggerOnTheInside.Binder;

/**
 * @author Walt
 * @category Entity
 */
public abstract class Entity {
	protected String name;
	protected EntityType type;
	
	public abstract String getName();
	public abstract EntityType getType();
	
	public Entity(String a, EntityType b) {
		this.name = a;
		this.type = b;
	}
}
