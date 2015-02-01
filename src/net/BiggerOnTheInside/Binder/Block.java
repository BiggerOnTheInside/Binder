/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/
package net.BiggerOnTheInside.Binder;

import net.BiggerOnTheInside.Binder.block.BlockAir;
import net.BiggerOnTheInside.Binder.block.BlockBookcase;
import net.BiggerOnTheInside.Binder.block.BlockDirt;
import net.BiggerOnTheInside.Binder.block.BlockGrass;


public abstract class Block {
	public static BlockAir  AIR  = new BlockAir();
	public static BlockDirt DIRT = new BlockDirt();
	public static BlockGrass GRASS = new BlockGrass();
	public static BlockBookcase BOOKCASE = new BlockBookcase();
	
	public static Block getBlock(byte id){
		switch(id){
			case 0:
				return Block.AIR;
			case 1:
				return Block.DIRT;
			case 2:
				return Block.GRASS;
			case 3:
				return Block.BOOKCASE;
		}
		
		return null;
	}
	
	public abstract byte getID();
	public abstract BlockTextureCoordinate getTextureCoordinates(BlockFace a);
}
