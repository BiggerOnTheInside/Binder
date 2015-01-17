/***************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                           */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/Binder.txt)   */
/***************************************************************************************************/

package net.BiggerOnTheInside.Binder;

import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class DimensionSwitcher {
	public static void setOrphoOn(float width, float height) {
		 GL11.glDisable(GL11.GL_TEXTURE_2D);
				  GL11.glDisable(GL11.GL_LIGHTING);
				  GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);                
				  GL11.glClearDepth(1);
				  GL11.glViewport(0,0, (int)width,(int)height);
				  GL11.glMatrixMode(GL11.GL_MODELVIEW);
				  GL11.glMatrixMode(GL11.GL_PROJECTION);
				  GL11.glLoadIdentity();
				  GL11.glOrtho(0, width, 0, height, 1, -1);

				  //GL11.glOrtho(0, width, height, 0, 1, -1);
				  GL11.glMatrixMode(GL11.GL_MODELVIEW);
				  GL11.glLoadIdentity();
		}

		public static void setOrphoOff(float width, float height) {
		    GL11.glEnable(GL11.GL_LIGHTING);
				
				GL11.glMatrixMode(GL11.GL_PROJECTION);
				GL11.glLoadIdentity();

				GLU.gluPerspective((float) 100, width / height, 0.001f, 1000);
				GL11.glMatrixMode(GL11.GL_MODELVIEW);
				
				// enable alpha blending
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

				GL11.glEnable(GL11.GL_TEXTURE_2D);
				GL11.glShadeModel(GL11.GL_SMOOTH);
				GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);
				GL11.glClearDepth(1.0f);
				GL11.glEnable(GL11.GL_DEPTH_TEST);
				GL11.glDepthFunc(GL11.GL_LEQUAL);
		}

}