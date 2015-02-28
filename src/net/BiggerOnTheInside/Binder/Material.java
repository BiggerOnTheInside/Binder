/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder;

import net.BiggerOnTheInside.Binder.block.AirBlock;
import net.BiggerOnTheInside.Binder.block.BedrockBlock;
import net.BiggerOnTheInside.Binder.block.DirtBlock;
import net.BiggerOnTheInside.Binder.block.GrassBlock;

public enum Material {
	AIR("air", (byte)0, new AirBlock()),
	DIRT("dirt", (byte)1, new DirtBlock()),
	GRASS("grass", (byte)2, new GrassBlock()),
	BEDROCK("bedrock", (byte)3, new BedrockBlock());
	
	private String name;
	private byte id;
	private Block b_class;
	
	/**
	 * @param name The name of material.
	 * @param id The byte-id of material.
	 * @param b_class The block class if any.
	 */
	Material(String name, byte id, Object b_class){
		this.name = name;
		this.id = id;
		
		if(b_class instanceof Block){
			this.b_class = (Block) b_class;
		}
		else{
			this.b_class = new AirBlock();
		}
	}
	
	public byte getID(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public Block getBlock(){
		return b_class;
	}
}
