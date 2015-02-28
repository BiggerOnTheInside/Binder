/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder;

import java.util.Random;

import org.lwjgl.util.vector.Vector3f;

@SuppressWarnings("unused")
public class Chunk implements WorldObject{
	public static int CHUNK_SIZE = 16;
	public static int CHUNK_TYPE_AIR = 0;
	public static int CHUNK_TYPE_MIXED = 1;
	public static int CHUNK_AIR_CHANCE = -1;
	
	private byte[][][] blocks;
	private boolean isActive;
	public Vector3f position;
	private Random randGen;
	
	public Chunk(float x, float y, float z){
		x *= 15f; x += 15f;
		y *= 15f; y += 15f;
		z *= 15f; z += 15f;
		
		this.position = new Vector3f(x, y, z);
		this.blocks   = new byte[CHUNK_SIZE][CHUNK_SIZE][CHUNK_SIZE];
		this.randGen  = new Random();
		
		d();
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
	public void a() {}


	@Override
	public void b() {
		for(int x = (int) position.x; x < position.x + (CHUNK_SIZE - 1); x++){
			for(int y = (int) position.y; y < position.y + (CHUNK_SIZE - 1); y++){
				for(int z = (int) position.z; z < position.z + (CHUNK_SIZE - 1); z++){
					int nx = (int) ((x - position.x));
					int ny = (int) ((y - position.y));
					int nz = (int) ((z - position.z));
					
					if(blocks[nx][ny][nz] != Block.AIR.getID() && !isTileNotInView(nx, ny, nz)){
						//BlockRenderer.renderBlock(Block.getBlock(blocks[nx][ny][nz]), (float)x, (float)y, (float)z);
					}
				}
			}
		}
	}
	
	@Override
	public void c() {}
	
	@Override
	public void d() {
		for(int x = 0; x < CHUNK_SIZE - 1; x++){
			for(int y = 0; y < CHUNK_SIZE - 1; y++){
				for(int z = 0; z < CHUNK_SIZE - 1; z++){
					
					if(randGen.nextInt(10) == Chunk.CHUNK_AIR_CHANCE){
						blocks[x][y][z] = Block.AIR.getID();
					}
					
					if(y == 0){
						blocks[x][y][z] = Block.DIRT.getID();
					}
					
					if(y < 6 && y > 0){
						blocks[x][y][z] = Block.GRASS.getID();
					}
					
					if(y > 6){
					}
				}
			}
		}
	}
	
	public void e(Block b, int x, int y, int z){
		blocks[x][y][z] = b.getID();
	}
}
