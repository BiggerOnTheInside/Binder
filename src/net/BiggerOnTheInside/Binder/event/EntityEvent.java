/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder.event;

import net.BiggerOnTheInside.Binder.Entity;

public abstract class EntityEvent extends Event{
	public abstract String getEntityName();
	public abstract Entity getEntity();
}
