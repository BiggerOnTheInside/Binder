/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

/**
 * @author Walt Pach
 * @category BinderInstance
 * @since 1/29/15
 * @version 0.0.2
 */
public class Binder {
	/* The current display mode object for Binder. */
	private static DisplayMode displayMode;
	
	/* The main gameloop instance used by Binder. */
	private GameLoop loop;
	
	/** 
	 * <p>Creates the window, sets up LWJGL, and starts the gameloop, starting the game.</p>
	 */
	public void start(){
		/* Create a new instance of gameloop. */
		loop = new GameLoop();
		
		try{
			/* Create the window for Binder. */
			createWindow();
			
			/* Setup LWJGL/OpenGL. */
			initGL();
			
			/* Start the loop! */
			loop.run();
		}
		catch(Exception e){
			/* Just to be face, let's catch anything that Binder throws at us :P */
			e.printStackTrace();
		}
	}
	
	/**
	 * <p>Sets up OpenGL.</p>
	 */
	public void initGL(){
		int width = displayMode.getWidth();
		int height = displayMode.getHeight();
		
		/* Enable 2D texturing. */
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		
		/* Make all models smoothly textured. */
        GL11.glShadeModel(GL11.GL_SMOOTH);
        
        /* Set the background color to that signature blue. */
        GL11.glClearColor(0.9f, 1.0f, 1.0f, 0.0f); 
        
        /* Set the clear depth to all-the-way */
        GL11.glClearDepth(1.0); 
        
        /* Enable the depth system. */
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        
        /* Set the function for depth to GL_LEQUAL. */
        GL11.glDepthFunc(GL11.GL_LEQUAL); 

        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        /* Enable face culling, basically don't render this face relative to the camera's position. */
        GL11.glEnable(GL11.GL_CULL_FACE);
        
        /* Set OpenGL to cull the back face of our spatials. */
        GL11.glCullFace(GL11.GL_BACK);
        
        /* Set the matrix mode to projection. */
        GL11.glMatrixMode(GL11.GL_PROJECTION); 
        
        /* Reset the OpenGL configuration, loading our above prefrences. */
        //GL11.glLoadIdentity();

        /* Set the perspective. */
        GLU.gluPerspective(45.0f, (float)displayMode.getWidth()/(float)displayMode.getHeight(),0.1f,100.0f);

        /* Set the matrix mode to be model view. */
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        
        /* Set the perspective correction hint to finest quality. */
        GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST);
	}
	
	/**
	 * <p>This method creates our window for Binder.</p>
	 * @throws LWJGLException Any error that LWJGL gives us.
	 */
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
        Display.setTitle("LWJGL Voxel engine AKA Binder");
        Display.create();
	}
	
	public static DisplayMode getDisplayMode(){
		return displayMode;
	}
	
	/**
	 * <p>Called by the virtual machine.</p>
	 * @param args The command line arguments.
	 */
	public static void main(String args[]){
		new Binder().start();
	}
}
