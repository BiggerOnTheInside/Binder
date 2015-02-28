/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder.block;

import net.BiggerOnTheInside.Binder.Block;
import net.BiggerOnTheInside.Binder.BlockFace;
import net.BiggerOnTheInside.Binder.BlockTextureCoordinate;

public class GrassBlock extends Block {

	@Override
	public byte getID() {
		return 2;
	}

	@Override
	public BlockTextureCoordinate getTextureCoordinates(BlockFace a) {
		if(a == BlockFace.Back || a == BlockFace.Front || a == BlockFace.Left || a == BlockFace.Right){
			return new BlockTextureCoordinate(7, 0);
		}
		else if(a == BlockFace.Top){
			return new BlockTextureCoordinate(8, 0);
		}
		else if(a == BlockFace.Bottom){
			return new BlockTextureCoordinate(5, 0);
		}
		
		return new BlockTextureCoordinate(5, 0);
	}

}
