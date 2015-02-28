/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder;

import java.awt.Font;
import java.util.ArrayList;

import net.BiggerOnTheInside.Binder.event.EventManager;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;

public class GameLoop {
	private GameState state;
	private ResourceManager resourceManager;
	static Player p;
	private ArrayList<Chunk> chunks = new ArrayList<Chunk>();
	
	public void init(){
		System.setProperty("Binder.home", System.getProperty("user.home") + "/Binder/");
		
		resourceManager = new ResourceManager("resources");
		resourceManager.getTextureManager().loadTextureSheet("textures/terrain.png", true);
		
		EventManager.addListener(new PlayerListener());
	}

	public void run(){
		//fontRenderer = new FontRenderer();
		
		init();
		state = GameState.Playing;
		p = new Player("Kirk", 100, 100);
		
		for(int x = 0; x < 2; x++){
			for(int y = 0; y < 1; y++){
				for(int z = 0; z < 2; z++){
					chunks.add(new Chunk(x, y, z));
				}
			}
		}
		
		for(Chunk c : chunks){
			c.d();
		}
		
		Mouse.setGrabbed(true);
		while(!Display.isCloseRequested() && !Keyboard.isKeyDown(Globals.EXIT_KEY)){
			render();
			update();
			
			Display.update();
			Display.sync(120);
		}
		
		state = GameState.End;
		Display.destroy();
	}

	public void update(){
		Time.update();
		
		p.update();
		
		System.out.println(p.getLocation().x);
	}
	World c = new World();
	
	public void render(){
		if(state == GameState.Playing){
			//render2D();
			render3D();
		}
	}
	
	FontRenderer fontRenderer;
	
	/*public void render2D(){
		glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, Binder.getDisplayMode().getWidth(), Binder.getDisplayMode().getHeight(), 0, -1, 1);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
      
        fontRenderer.drawString("FPS: " + 10, 15, 25);

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
      
        glViewport(0, 0, Binder.getDisplayMode().getWidth(), Binder.getDisplayMode().getHeight());
        GLU.gluPerspective(45f, (float)(Binder.getDisplayMode().getWidth() / Binder.getDisplayMode().getHeight()), 0.001f, 1000f);      
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
	}*/

	
	public void render3D(){
		/* For some reason, needs commenting for camera to work :p */
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT); // Clear The Screen And The Depth Buffer
	    
		BlockRenderer.renderBlock(Block.DIRT, 0f, 0f, 0f);
		BlockRenderer.renderWireframeBlock(Block.DIRT, 0f, 1f, 1f);
	}

	
	public static Player getPlayerObject(){
		return p;
	}
}
