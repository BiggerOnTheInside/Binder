/***************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                           */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/Binder.txt)   */
/***************************************************************************************************/

package net.BiggerOnTheInside.Binder;


public abstract class VoxelRenderer {
	public abstract void renderBlock(Block b, float x, float y, float z);
	public abstract void renderWireframeBlock(Block b, float x, float y, float z);
}
