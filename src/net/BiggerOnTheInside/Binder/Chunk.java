/***************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                           */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/Binder.txt)   */
/***************************************************************************************************/
package net.BiggerOnTheInside.Binder;

import java.util.Random;

import org.lwjgl.util.vector.Vector3f;

/**
 * @author Walt Pach (freelance)
 */
public class Chunk extends WorldObject {
	public static final int CHUNK_AIR_GEN = 0;
	public static final int CHUNK_SIZE = 16;
	
	private Vector3f pos;
	
	private byte[][][] blocks;
	private Random randGen;
	
	public Chunk(float x, float y, float z){
		x *= 16f;
		y *= 15f;
		y += 15f;
		z *= 16f;
		
		this.pos = new Vector3f(x, y, z);
		this.blocks = new byte[CHUNK_SIZE][CHUNK_SIZE][CHUNK_SIZE];
		this.randGen = new Random();
		
		rebuild();
	}
	
	private boolean isTileNotInView(int x, int y, int z){
		boolean facesHidden[] = new boolean[6];
		
		if(x > 0){
			if(blocks[x - 1][y][z] != Block.AIR.getID()) facesHidden[0] = true;
			else facesHidden[0] = false;
		}
		else{
			facesHidden[0] = false;
		}
		if(x < CHUNK_SIZE - 1){
			if(blocks[x + 1][y][z] != Block.AIR.getID()) facesHidden[1] = true;
			else facesHidden[1] = false;
		}
		else{
			facesHidden[1] = false;
		}
		
		
		if(y > 0){
			if(blocks[x][y - 1][z] != Block.AIR.getID()) facesHidden[2] = true;
			else facesHidden[2] = false;
		}
		else{
			facesHidden[2] = false;
		}
		if(y < CHUNK_SIZE - 1){
			if(blocks[x][y + 1][z] != Block.AIR.getID()) facesHidden[3] = true;
			else facesHidden[3] = false;
		}
		else{
			facesHidden[3] = false;
		}
		
		if(z > 0){
			if(blocks[x][y][z - 1] != Block.AIR.getID()) facesHidden[4] = true;
			else facesHidden[4] = false;
		}
		else{
			facesHidden[4] = false;
		}
		if(z < CHUNK_SIZE - 1){
			if(blocks[x][y][z + 1] != Block.AIR.getID()) facesHidden[5] = true;
			else facesHidden[5] = false;
		}
		else{
			facesHidden[5] = false;
		}
		
		return facesHidden[0] && facesHidden[1] && facesHidden[2] && facesHidden[3] && facesHidden[4] && facesHidden[5];
	}

	@Override
	public void update() {
		
	}

	@Override
	public void rebuild() {
		for(int x = 0; x < CHUNK_SIZE - 1; x++){
			for(int y = 0; y < CHUNK_SIZE - 1; y++){
				for(int z = 0; z < CHUNK_SIZE - 1; z++){
					blocks[x][y][z] = Block.DIRT.getID();
					
					if(randGen.nextInt(10) == CHUNK_AIR_GEN){
						blocks[x][y][z] = Block.AIR.getID();
					}
				}
			}
		}
	}

	@Override
	public void render() {
		for(int x = (int) pos.x; x < pos.x + (CHUNK_SIZE - 1); x++){
			for(int y = (int) pos.y; y < pos.y + (CHUNK_SIZE - 1); y++){
				for(int z = (int) pos.z; z < pos.z + (CHUNK_SIZE - 1); z++){
					int nx = (int) ((x - pos.x));
					int ny = (int) ((y - pos.y));
					int nz = (int) ((z - pos.z));
					
					if(blocks[nx][ny][nz] != Block.AIR.getID() && !isTileNotInView(nx, ny, nz)){
						BlockRenderer.renderBlock(Block.getBlock(blocks[nx][ny][nz]), (float)x, (float)y, (float)z);
					}
				}
			}
		}
	}
	
	public Vector3f getPos(){
		return pos;
	}
}
