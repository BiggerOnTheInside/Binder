/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder;

import java.awt.Font;
import java.util.ArrayList;

import me.wxwsk8er.Knapsack.ChatColor;
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
	public static int fps;
	
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
		textRenderer = new TextRenderer();
		Time.start();
		
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
			update();
			render();
			
			Display.update();
			Display.sync(120);
		}
		
		state = GameState.End;
		Display.destroy();
	}

	public void update(){
		Time.updateFPS();
		
		p.update();
		
		//System.out.println(p.getLocation().x);
	}
	
	World c = new World();
	TextRenderer textRenderer;
	
	public void render(){
		if(state == GameState.Playing){
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT); // Clear The Screen And The Depth Buffer
			render3D();
			
			ViewHelper.setOrthoOn();
			render2D();
			ViewHelper.setOrthoOff();
		}
	}
	

	TrueTypeFont _font;
	
	private void render2D(){
	    GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
	    Color.white.bind();
	    
	    renderDebug();
	}
	
	private void render3D(){
		/* For some reason, needs commenting for camera to work :p */
		resourceManager.getTextureManager().loadTextureSheet("resources/textures/terrain.png", true);
		
		BlockRenderer.renderBlock(Block.DIRT, 0f, 0f, 0f);
		BlockRenderer.renderWireframeBlock(Block.DIRT, 0f, 1f, 1f);
	}

	private void renderDebug(){
		int width = Binder.getDisplayMode().getWidth(), height = Binder.getDisplayMode().getHeight();

		textRenderer.renderString(0, 0, "FPS: " + fps, ChatColor.BLACK);
		textRenderer.renderString(0, 24, "Location: (" + (int)getPlayerObject().getLocation().getX() + ", " + (int)getPlayerObject().getLocation().getY() + ", " + (int)getPlayerObject().getLocation().getZ() + ")", ChatColor.BLACK);
	}
	
	public static Player getPlayerObject(){
		return p;
	}
}
