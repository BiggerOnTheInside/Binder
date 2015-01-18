/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/
 
package net.BiggerOnTheInside.Binder;

import net.BiggerOnTheInside.Binder.engine.Block;
import net.BiggerOnTheInside.Binder.engine.BlockTextureCoordinate;

public class BlockDirt extends Block{

	@Override
	public byte getID() {
		return 1;
	}

	@Override
	public BlockTextureCoordinate getTextureCoordinates() {
		return new BlockTextureCoordinate(5f, 0f);
	}

}
