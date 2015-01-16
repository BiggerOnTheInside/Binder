/***************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                           */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/Binder.txt)   */
/***************************************************************************************************/
package net.BiggerOnTheInside.Binder;

public enum BlockType {
	Air(0),
	Dirt(1),
	CobbleStone(2);
	
	int t;
	
	BlockType(int i){
		t = i;
	}
	
	public int getID(){
		return t;
	}
}
