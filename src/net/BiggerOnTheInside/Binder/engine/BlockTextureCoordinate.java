/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder.engine;

import net.BiggerOnTheInside.Binder.Globals;

public class BlockTextureCoordinate {
	private float x, y;
	private float size = 1 / Globals.TEXTURES_PER_SHEET;
	
	public BlockTextureCoordinate(float x, float y){
		this.x = x * size;
		this.y = y * size;
	}
	
	public float x(){
		return this.x;
	}
	
	public float y(){
		return this.y;
	}
}
