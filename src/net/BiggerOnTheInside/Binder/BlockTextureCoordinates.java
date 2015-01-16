/***************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                           */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/Binder.txt)   */
/***************************************************************************************************/
package net.BiggerOnTheInside.Binder;

public class BlockTextureCoordinates {
	private static float x, y;
	
	public BlockTextureCoordinates(float x, float y){
		BlockTextureCoordinates.x = x;
		BlockTextureCoordinates.y = y;
	}
	
	public float x(){
		return x * (1 / BlockRenderer.TEXTURES_PER_SHEET);
	}
	
	public float y(){
		return y * (1 / BlockRenderer.TEXTURES_PER_SHEET);
	}
}
