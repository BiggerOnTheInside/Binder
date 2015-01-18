/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;

import net.BiggerOnTheInside.Binder.engine.Block;
import net.BiggerOnTheInside.Binder.engine.BlockRenderer;
import net.BiggerOnTheInside.Binder.engine.DownloadManager;
import net.BiggerOnTheInside.Binder.engine.JSONManager;
import net.BiggerOnTheInside.Binder.engine.ResourceManager;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class GameLoop {
	private GameState state;
	private ResourceManager resourceManager;
	private File binderHomeFolder = new File(System.getProperty("Binder.home"));
	
	public void init(){
		System.setProperty("Binder.home", System.getProperty("user.home") + "/Binder/");
		
		if(!binderHomeFolder.exists()){
			binderHomeFolder.mkdirs();
			
			JSONManager downloadManager = new JSONManager("https://raw.githubusercontent.com/BiggerOnTheInside/Binder/master/downloads.json", true);
			
			DownloadManager.downloadFile(downloadManager.getStringFromArray("game", "Binary"), System.getProperty("Binder.home") + "Binder.jar");
		}
		
		resourceManager = new ResourceManager("resources");
	}

	public void run(){
		init();
		
		state = GameState.Playing;
		
		while(!Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
			render();
			update();
			
			Display.update();
			Display.sync(60);
		}
		
		state = GameState.End;
		Display.destroy();
	}
	
	public void update(){}
	
	public void render(){
		if(state == GameState.Playing){
			 render2D();
			 render3D();
		}
	}
	
	public void render2D(){}
	
	public void render3D(){
		 GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		 GL11.glLoadIdentity();
		 GL11.glTranslatef(-3f, 0.0f, -20f);
		 GL11.glRotatef(45f, 0.4f, 1.0f, 0.1f);
		 GL11.glColor3f(0.5f, 0.5f, 1.0f); 
		 
		 BlockRenderer.renderBlock(Block.DIRT, 0f, 0f, 0f);
		 BlockRenderer.renderWireframeBlock(Block.DIRT, 0f, 1f, 1f);
	}
}
