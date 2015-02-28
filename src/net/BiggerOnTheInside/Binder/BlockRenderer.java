/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved. */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt) */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder;

import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_LEQUAL;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_NICEST;
import static org.lwjgl.opengl.GL11.GL_PERSPECTIVE_CORRECTION_HINT;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glDepthFunc;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glHint;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;

import java.awt.Font;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

public class BlockRenderer{
	public static void renderBlock(Block b, float x, float y, float z) {
		GL11.glPushMatrix();
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
		GL11.glTranslatef(x * 2f, y * 2f, z * 2f);
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glColor3f(1f, 1f, 1f);
	
			// Top face.
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Top).x(), b.getTextureCoordinates(BlockFace.Top).y());
				GL11.glVertex3f(1.0f, 1.0f, -1.0f);
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Top).x() + Globals.TEXTURE_SIZE, b.getTextureCoordinates(BlockFace.Top).y());
				GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Top).x() + Globals.TEXTURE_SIZE, b.getTextureCoordinates(BlockFace.Top).y() + Globals.TEXTURE_SIZE);
				GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Top).x(), b.getTextureCoordinates(BlockFace.Top).y() + Globals.TEXTURE_SIZE);
				GL11.glVertex3f(1.0f, 1.0f, 1.0f);
		 
			// Bottom.
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Bottom).x(), b.getTextureCoordinates(BlockFace.Bottom).y());
				GL11.glVertex3f(1.0f, -1.0f, 1.0f);
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Bottom).x() + Globals.TEXTURE_SIZE, b.getTextureCoordinates(BlockFace.Bottom).y());
				GL11.glVertex3f(-1.0f, -1.0f, 1.0f);
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Bottom).x() + Globals.TEXTURE_SIZE, b.getTextureCoordinates(BlockFace.Bottom).y() + Globals.TEXTURE_SIZE);
				GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Bottom).x(), b.getTextureCoordinates(BlockFace.Bottom).y() + Globals.TEXTURE_SIZE);
				GL11.glVertex3f(1.0f, -1.0f, -1.0f);
		 
			// Front.
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Front).x(), b.getTextureCoordinates(BlockFace.Front).y());
				GL11.glVertex3f(1.0f, 1.0f, 1.0f); 
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Front).x() + Globals.TEXTURE_SIZE, b.getTextureCoordinates(BlockFace.Front).y());
				GL11.glVertex3f(-1.0f, 1.0f, 1.0f); 
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Front).x() + Globals.TEXTURE_SIZE, b.getTextureCoordinates(BlockFace.Front).y() + Globals.TEXTURE_SIZE);
				GL11.glVertex3f(-1.0f, -1.0f, 1.0f); 
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Front).x(), b.getTextureCoordinates(BlockFace.Front).y() + Globals.TEXTURE_SIZE);
				GL11.glVertex3f(1.0f, -1.0f, 1.0f);
		
			// Back.
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Back).x(), b.getTextureCoordinates(BlockFace.Back).y());
				GL11.glVertex3f(1.0f, -1.0f, -1.0f); 
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Back).x() + Globals.TEXTURE_SIZE, b.getTextureCoordinates(BlockFace.Back).y());
				GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Back).x() + Globals.TEXTURE_SIZE, b.getTextureCoordinates(BlockFace.Back).y() + Globals.TEXTURE_SIZE);
				GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Back).x(), b.getTextureCoordinates(BlockFace.Back).y() + Globals.TEXTURE_SIZE);
				GL11.glVertex3f(1.0f, 1.0f, -1.0f);
		
			// Left
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Left).x(), b.getTextureCoordinates(BlockFace.Left).y());
				GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Left).x() + Globals.TEXTURE_SIZE, b.getTextureCoordinates(BlockFace.Left).y());
				GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Left).x() + Globals.TEXTURE_SIZE, b.getTextureCoordinates(BlockFace.Left).y() + Globals.TEXTURE_SIZE);
				GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Left).x(), b.getTextureCoordinates(BlockFace.Left).y() + Globals.TEXTURE_SIZE);
				GL11.glVertex3f(-1.0f, -1.0f, 1.0f); 
			
			// Right.
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Right).x(), b.getTextureCoordinates(BlockFace.Right).y());
				GL11.glVertex3f(1.0f, 1.0f, -1.0f);
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Right).x() + Globals.TEXTURE_SIZE, b.getTextureCoordinates(BlockFace.Right).y());
				GL11.glVertex3f(1.0f, 1.0f, 1.0f);
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Right).x() + Globals.TEXTURE_SIZE, b.getTextureCoordinates(BlockFace.Right).y() + Globals.TEXTURE_SIZE);
				GL11.glVertex3f(1.0f, -1.0f, 1.0f); 
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Right).x(), b.getTextureCoordinates(BlockFace.Right).y() + Globals.TEXTURE_SIZE);
				GL11.glVertex3f(1.0f, -1.0f, -1.0f); 
		GL11.glEnd();
		GL11.glTranslatef(0f, 0f, 0f);
		GL11.glPopMatrix();
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
