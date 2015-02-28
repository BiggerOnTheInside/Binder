/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/
package net.BiggerOnTheInside.Binder;

import net.BiggerOnTheInside.Binder.block.AirBlock;
import net.BiggerOnTheInside.Binder.block.DirtBlock;
import net.BiggerOnTheInside.Binder.block.GrassBlock;


public abstract class Block {
	public static AirBlock  AIR  = new AirBlock();
	public static DirtBlock DIRT = new DirtBlock();
	public static GrassBlock GRASS = new GrassBlock();
	
	public static Block getBlock(byte id){
		switch(id){
			case 0:
				return Block.AIR;
			case 1:
				return Block.DIRT;
			case 2:
				return Block.GRASS;
		}
		
		return null;
	}
	
	public abstract byte getID();
	public abstract BlockTextureCoordinate getTextureCoordinates(BlockFace a);
}
