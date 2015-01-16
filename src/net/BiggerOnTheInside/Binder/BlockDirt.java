package net.BiggerOnTheInside.Binder;

import net.BiggerOnTheInside.Binder.BlockRenderer.BlockFace;

public class BlockDirt extends Block{

	@Override
	public byte getID() {
		return 2;
	}

	@Override
	public BlockTextureCoordinates getTextureCoordinates(BlockFace showing) {
		return new BlockTextureCoordinates(5f, 0f);
	}

}
