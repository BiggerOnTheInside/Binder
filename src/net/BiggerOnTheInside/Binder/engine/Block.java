/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/
package net.BiggerOnTheInside.Binder.engine;

import net.BiggerOnTheInside.Binder.BlockDirt;

public abstract class Block {
	public static BlockDirt DIRT = new BlockDirt();

	public Block getBlock(byte id){
		switch(id){
			case 0:
		}
		
		return null;
	}
	
	public abstract byte getID();
	public abstract BlockTextureCoordinate getTextureCoordinates();
}
