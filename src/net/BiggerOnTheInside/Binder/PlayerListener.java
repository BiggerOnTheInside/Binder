/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder;

import net.BiggerOnTheInside.Binder.event.Event;
import net.BiggerOnTheInside.Binder.event.Listener;
import net.BiggerOnTheInside.Binder.event.PlayerMoveEvent;


public class PlayerListener extends Listener {
	@Override
	public void catchEvent(Event e) {
		if(e.getType() instanceof PlayerMoveEvent){
			System.out.println("Hello!");
		}
	}
}
