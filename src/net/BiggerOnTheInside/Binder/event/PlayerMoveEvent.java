/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder.event;

import net.BiggerOnTheInside.Binder.Player;

public class PlayerMoveEvent extends PlayerEvent{
	public PlayerMoveEvent(Player p){
		super(p);
	}
	
	@Override
	public Player getPlayer() {
		return this.player;
	}

	@Override
	public String getEntityName() {
		return this.player.getName();
	}

	@Override
	public Event getEvent() {
		return this;
	}

	@Override
	public String getEventName() {
		return "PlayerMoveEvent";
	}

	@Override
	public Event getType() {
		return this;
	}
}
