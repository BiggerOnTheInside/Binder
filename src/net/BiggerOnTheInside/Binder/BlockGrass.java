package net.BiggerOnTheInside.Binder;

import net.BiggerOnTheInside.Binder.BlockRenderer.BlockFace;

public class BlockGrass extends Block {

	@Override
	public byte getID() {
		return 1;
	}

	@Override
	public BlockTextureCoordinates getTextureCoordinates(BlockFace showing) {
		if(showing == BlockFace.Front || showing == BlockFace.Left || showing == BlockFace.Right || showing == BlockFace.Back){
			return new BlockTextureCoordinates(7f, 0f);
		}
		else if(showing == BlockFace.Bottom){
			// 5, 0
			return new BlockTextureCoordinates(5f, 0f);
		}
		else if(showing == BlockFace.Top){
			// 8, 0
			return new BlockTextureCoordinates(8f, 0f);
		}
		
		return new BlockTextureCoordinates(-1f, -1f);
	}

}
