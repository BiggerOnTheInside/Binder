/***************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                           */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/Binder.txt)   */
/***************************************************************************************************/

package net.BiggerOnTheInside.Binder;

import net.BiggerOnTheInside.Binder.BlockRenderer.BlockFace;


public abstract class Block {
	public static Block AIR = new BlockAir();
	public static Block GRASS = new BlockGrass();
	public static Block DIRT = new BlockDirt();
	
	public abstract byte getID();
	public abstract BlockTextureCoordinates getTextureCoordinates(BlockFace showing);
	
	public static Block getBlock(byte id){
		switch(id){
			case 0:
				return Block.AIR;
			case 1:
				return Block.GRASS;
			case 2:
				return Block.DIRT;
		}
		
		return Block.AIR;
	}

}
