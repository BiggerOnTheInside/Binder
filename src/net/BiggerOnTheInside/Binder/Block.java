/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/
package net.BiggerOnTheInside.Binder;


public abstract class Block {
	public static BlockAir  AIR  = new BlockAir();
	public static BlockDirt DIRT = new BlockDirt();
	
	public static Block getBlock(byte id){
		switch(id){
			case 0:
				return Block.AIR;
			case 1:
				return Block.DIRT;
		}
		
		return null;
	}
	
	public abstract byte getID();
	public abstract BlockTextureCoordinate getTextureCoordinates(BlockFace a);
}
