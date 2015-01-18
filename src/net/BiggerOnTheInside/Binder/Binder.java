/***************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                           */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/Binder.txt)   */
/***************************************************************************************************/

package net.BiggerOnTheInside.Binder;

import net.BiggerOnTheInside.Binder.engine.Block;
import net.BiggerOnTheInside.Binder.engine.BlockRenderer;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class Binder {
	private DisplayMode displayMode;
	
	public void start(){
		try{
			createWindow();
			initGL();
			init();
			run();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void initGL(){
		GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); 
        GL11.glClearDepth(1.0); 
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDepthFunc(GL11.GL_LEQUAL); 

        GL11.glMatrixMode(GL11.GL_PROJECTION); 
        GL11.glLoadIdentity();

        
        GLU.gluPerspective(45.0f, (float)displayMode.getWidth()/(float)displayMode.getHeight(),0.1f,100.0f);

        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST);
	}
	
	public void createWindow() throws LWJGLException{
		Display.setFullscreen(false);
        DisplayMode d[] = Display.getAvailableDisplayModes();
        for (int i = 0; i < d.length; i++) {
            if (d[i].getWidth() == 640
                && d[i].getHeight() == 480
                && d[i].getBitsPerPixel() == 32) {
                displayMode = d[i];
                break;
            }
        }
        Display.setDisplayMode(displayMode);
        Display.setTitle("LWJGL Voxel engine");
        Display.create();
	}
	
	public void init(){
		
	}
	
	public void run(){
		while(!Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
			render();
			update();
			
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
	}
	
	public void update(){}
	
	public void render(){
		 render2D();
		 render3D();
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
	public static void main(String args[]){
		new Binder().start();
	}
}
