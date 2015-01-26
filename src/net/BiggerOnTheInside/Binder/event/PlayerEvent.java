/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder.event;

import net.BiggerOnTheInside.Binder.Entity;
import net.BiggerOnTheInside.Binder.Player;

public abstract class PlayerEvent extends EntityEvent{
	Player player; 
	
	public PlayerEvent(Player p){
		this.player = p;
	}
	
	public abstract Player getPlayer();
	
	@Override
	public Entity getEntity(){
		return player;
	}
}
