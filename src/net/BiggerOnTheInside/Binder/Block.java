/***************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                           */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/Binder.txt)   */
/***************************************************************************************************/

package net.BiggerOnTheInside.Binder;

public abstract class Block {
	public static Block a;

	public Block getBlock(byte id){
		switch(id){
			case 0:
		}
		
		return null;
	}
	
	public abstract byte getID();
	public abstract BlockTextureCoordinate getTextureCoordinates();
}
