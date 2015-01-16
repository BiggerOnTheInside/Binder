/***************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                           */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/Binder.txt)   */
/***************************************************************************************************/
package net.BiggerOnTheInside.Binder;

import java.util.concurrent.ConcurrentHashMap;

import org.lwjgl.util.vector.Vector3f;

public class World extends WorldObject {
	private ConcurrentHashMap<Vector3f, Chunk> chunks;
	private String worldName;
	private Vector3f nextChunkCoords;

	public World(String name, boolean autoGen){
		this.worldName = name;
		
		if(autoGen){
			rebuild();
		}
	}
	
	@Override
	public void update() {
		
	}

	@Override
	public void rebuild() {
		if(chunks.size() != 0 && chunks.size() != -1){
			chunks.get(
					new Vector3f(
							Binder.getPlayerObject().getLocation().x,
							Binder.getPlayerObject().getLocation().y,
							Binder.getPlayerObject().getLocation().z
					)
			).rebuild();
		}
		else{
			
		}
	}

	@Override
	public void render() {
		chunks.get(
				new Vector3f(
						Binder.getPlayerObject().getLocation().x,
						Binder.getPlayerObject().getLocation().y,
						Binder.getPlayerObject().getLocation().z
				)
		).render();
	}
}
