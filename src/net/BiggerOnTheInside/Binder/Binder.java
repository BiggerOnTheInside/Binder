/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

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
	private GameLoop loop;
	
	public void start(){
		loop = new GameLoop();
		
		try{
			createWindow();
			initGL();
			loop.run();
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
	
	public static void main(String args[]){
		new Binder().start();
	}
}
