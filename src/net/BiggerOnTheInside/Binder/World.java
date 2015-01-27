/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import org.lwjgl.util.vector.Vector3f;

public class World implements WorldObject {
	private ArrayList<Chunk> chunks;
	
	@Override
	public void a() {

	}

	@Override
	public void b() {
		for(Chunk a : (Chunk[])chunks.toArray()){
			a.b();
		}
	}

	@Override
	public void c() {
		chunks.clear();
	}

	@Override
	public void d() {
		Chunk a = new Chunk(0, 0, 0), b = new Chunk(1, 0, 0), c = new Chunk(0, 1, 1);
		
		chunks.add(a);
		chunks.add(b);
		chunks.add(c);
	}
}