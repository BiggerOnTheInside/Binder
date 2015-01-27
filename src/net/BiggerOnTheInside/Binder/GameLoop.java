/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;

import net.BiggerOnTheInside.Binder.event.EventManager;
import net.BiggerOnTheInside.Binder.event.PlayerMoveEvent;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class GameLoop {
	private GameState state;
	private ResourceManager resourceManager;
	static Player p;
	
	public void init(){
		System.setProperty("Binder.home", System.getProperty("user.home") + "/Binder/");
		
		resourceManager = new ResourceManager("resources");
		resourceManager.getTextureManager().loadTextureSheet("textures/terrain.png", true);
		
		EventManager.addListener(new PlayerListener());
	}

	public void run(){
		init();
		state = GameState.Playing;
		p = new Player("Kirk", 100, 100);
		
		Mouse.setGrabbed(true);
		while(!Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
			render();
			update();
			
			Display.update();
			Display.sync(60);
		}
		
		state = GameState.End;
		Display.destroy();
	}

	public void update(){
		//EventManager.fireEvent(new PlayerMoveEvent(p));
		p.update();
		
		System.out.println(p.getLocation().x);
	}
	Chunk c = new Chunk(0, 0, 0);
	
	public void render(){
		if(state == GameState.Playing){
			 render2D();
			 render3D();
		}
	}
	
	public void render2D(){}
	
	public void render3D(){
		 GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		 
		 /* For some reason, needs commenting for camera to work :p */
		 //GL11.glLoadIdentity();
		 
		 c.b();
		 BlockRenderer.renderBlock(Block.DIRT, 0f, 0f, 0f);
		 BlockRenderer.renderWireframeBlock(Block.DIRT, 0f, 1f, 1f);
	}
	
	public static Player getPlayerObject(){
		return p;
	}
}
