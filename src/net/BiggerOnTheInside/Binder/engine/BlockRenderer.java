/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder.engine;

import org.lwjgl.opengl.GL11;

public class BlockRenderer{

	public static void renderBlock(Block b, float x, float y, float z) {
		GL11.glTranslatef(x * 2f, y * 2f, z * 2f); 
		
		GL11.glBegin(GL11.GL_QUADS);
			 GL11.glColor3f(0.0f, 1.0f, 0.0f);
				 GL11.glVertex3f(1.0f, 1.0f, -1.0f);
				 GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
				 GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
				 GL11.glVertex3f(1.0f, 1.0f, 1.0f);
			 GL11.glColor3f(1.0f, 0.5f, 0.0f);
				 GL11.glVertex3f(1.0f, -1.0f, 1.0f);
				 GL11.glVertex3f(-1.0f, -1.0f, 1.0f);
				 GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
				 GL11.glVertex3f(1.0f, -1.0f, -1.0f);
			 GL11.glColor3f(1.0f, 0.0f, 0.0f); 
				 GL11.glVertex3f(1.0f, 1.0f, 1.0f); 
				 GL11.glVertex3f(-1.0f, 1.0f, 1.0f); 
				 GL11.glVertex3f(-1.0f, -1.0f, 1.0f); 
				 GL11.glVertex3f(1.0f, -1.0f, 1.0f);
			 GL11.glColor3f(1.0f, 1.0f, 0.0f);
				 GL11.glVertex3f(1.0f, -1.0f, -1.0f); 
				 GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
				 GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
				 GL11.glVertex3f(1.0f, 1.0f, -1.0f);
			 GL11.glColor3f(0.0f, 0.0f, 1.0f);
				 GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
				 GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
				 GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
				 GL11.glVertex3f(-1.0f, -1.0f, 1.0f); 
			 GL11.glColor3f(1.0f, 0.0f, 1.0f);
				 GL11.glVertex3f(1.0f, 1.0f, -1.0f);
				 GL11.glVertex3f(1.0f, 1.0f, 1.0f);
				 GL11.glVertex3f(1.0f, -1.0f, 1.0f); 
				 GL11.glVertex3f(1.0f, -1.0f, -1.0f); 
		 GL11.glEnd();
		 
		 GL11.glTranslatef(0f, 0f, 0f);
	}

	public static void renderWireframeBlock(Block b, float x, float y, float z) {
			GL11.glTranslatef(x * 2f, y * 2f, z * 2f); 
		
		GL11.glBegin(GL11.GL_LINE_LOOP);
			 GL11.glColor3f(0.0f, 1.0f, 0.0f);
				 GL11.glVertex3f(1.0f, 1.0f, -1.0f);
				 GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
				 GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
				 GL11.glVertex3f(1.0f, 1.0f, 1.0f);
			 GL11.glColor3f(1.0f, 0.5f, 0.0f);
				 GL11.glVertex3f(1.0f, -1.0f, 1.0f);
				 GL11.glVertex3f(-1.0f, -1.0f, 1.0f);
				 GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
				 GL11.glVertex3f(1.0f, -1.0f, -1.0f);
			 GL11.glColor3f(1.0f, 0.0f, 0.0f); 
				 GL11.glVertex3f(1.0f, 1.0f, 1.0f); 
				 GL11.glVertex3f(-1.0f, 1.0f, 1.0f); 
				 GL11.glVertex3f(-1.0f, -1.0f, 1.0f); 
				 GL11.glVertex3f(1.0f, -1.0f, 1.0f);
			 GL11.glColor3f(1.0f, 1.0f, 0.0f);
				 GL11.glVertex3f(1.0f, -1.0f, -1.0f); 
				 GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
				 GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
				 GL11.glVertex3f(1.0f, 1.0f, -1.0f);
			 GL11.glColor3f(0.0f, 0.0f, 1.0f);
				 GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
				 GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
				 GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
				 GL11.glVertex3f(-1.0f, -1.0f, 1.0f); 
			 GL11.glColor3f(1.0f, 0.0f, 1.0f);
				 GL11.glVertex3f(1.0f, 1.0f, -1.0f);
				 GL11.glVertex3f(1.0f, 1.0f, 1.0f);
				 GL11.glVertex3f(1.0f, -1.0f, 1.0f); 
				 GL11.glVertex3f(1.0f, -1.0f, -1.0f); 
		 GL11.glEnd();
		 
		 GL11.glTranslatef(0f, 0f, 0f);
	}

}
