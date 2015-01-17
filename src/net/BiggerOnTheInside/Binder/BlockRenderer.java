/***************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                           */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/Binder.txt)   */
/***************************************************************************************************/
package net.BiggerOnTheInside.Binder;

import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;

import java.awt.Font;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.Texture;

/**
 * 
 * @author Walt Pach (wxwsk8er)
 * 
 */
public class BlockRenderer {
	/*
	 * Global Constants.
	 */
	public static float TEXTURES_PER_SHEET = 32f;
	public static Texture blockTextureTemp;
	
	static Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
    static TrueTypeFont font = new TrueTypeFont(awtFont, false);
    
	/**
	 * @category Renderer
	 * @param b The block object you want to render.
	 * @param x The X-Coordinate for the block you want to render.
	 * @param y The Y-Coordinate for the block you want to render.
	 * @param z The Z-Coordinate for the block you want to render.
	 */
	public static void renderBlock(Block b, float x, float y, float z){
		GL11.glPushMatrix();

		GL11.glTranslatef(x * 2f, y * 2f, z * 2f);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
		GL11.glBegin(GL11.GL_QUADS);

		float size = 1f / TEXTURES_PER_SHEET;

		// Top Face
		GL11.glNormal3f(0.0f, 0.0f, -1.0f);
		GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Top).x(), b.getTextureCoordinates(BlockFace.Top).y());
			GL11.glVertex3f( 1.0f, 1.0f,-1.0f);  
		GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Top).x() + size, b.getTextureCoordinates(BlockFace.Top).y());
			GL11.glVertex3f(-1.0f, 1.0f,-1.0f);
		GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Top).x() + size, b.getTextureCoordinates(BlockFace.Top).y() + size);
			GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
		GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Top).x(), b.getTextureCoordinates(BlockFace.Top).y() + size);
			GL11.glVertex3f( 1.0f, 1.0f, 1.0f); 
 
        // Bottom Face
        GL11.glNormal3f(0.0f, 0.0f, 1.0f);
		GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Bottom).x(), b.getTextureCoordinates(BlockFace.Bottom).y());
        	GL11.glVertex3f( 1.0f,-1.0f, 1.0f);   // Bottom Right Of The Texture and Quad
        GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Bottom).x() + size, b.getTextureCoordinates(BlockFace.Bottom).y());
        	GL11.glVertex3f(-1.0f,-1.0f, 1.0f);   // Top Right Of The Texture and Quad
        GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Bottom).x() + size, b.getTextureCoordinates(BlockFace.Bottom).y() + size);
        	GL11.glVertex3f(-1.0f,-1.0f,-1.0f);  // Top Left Of The Texture and Quad
        GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Bottom).x(), b.getTextureCoordinates(BlockFace.Bottom).y() + size);
        	GL11.glVertex3f( 1.0f,-1.0f,-1.0f);  // Bottom Left Of The Texture and Quad

      
        // Back Face
        GL11.glNormal3f(1.0f, 0.0f, 0.0f);
        GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Back).x(), b.getTextureCoordinates(BlockFace.Back).y());
        	GL11.glVertex3f( 1.0f, 1.0f, 1.0f);   // Top Left Of The Texture and Quad
        GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Back).x() + size, b.getTextureCoordinates(BlockFace.Back).y());
        	GL11.glVertex3f(-1.0f, 1.0f, 1.0f);  // Bottom Left Of The Texture and Quad
        GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Back).x() + size, b.getTextureCoordinates(BlockFace.Back).y() + size);
       		GL11.glVertex3f(-1.0f,-1.0f, 1.0f);  //Bottom Right Of The Texture and Quad
        GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Back).x(), b.getTextureCoordinates(BlockFace.Back).y() + size);
        	GL11.glVertex3f( 1.0f,-1.0f, 1.0f);   // Top Right Of The Texture and Quad

        // Front Face
        GL11.glNormal3f(-1.0f, 0.0f, 0.0f);
	     GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Front).x(), b.getTextureCoordinates(BlockFace.Front).y());
	     	GL11.glVertex3f( 1.0f,-1.0f,-1.0f);   // Top Right Of The Texture and Quad
	     GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Front).x() + size, b.getTextureCoordinates(BlockFace.Front).y());
	     	GL11.glVertex3f(-1.0f,-1.0f,-1.0f);   // Top Left Of The Texture and Quad
	     GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Front).x() + size, b.getTextureCoordinates(BlockFace.Front).y() + size);
	     	GL11.glVertex3f(-1.0f, 1.0f,-1.0f);   // Bottom Left Of The Texture and Quad
	     GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Front).x(), b.getTextureCoordinates(BlockFace.Front).y() + size);
	     	GL11.glVertex3f(1.0f, 1.0f,-1.0f);   // Bottom Right Of The Texture and Quad

        // Right face
	    GL11.glNormal3f(0.0f, -1.0f, 0.0f);
	    	GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Right).x(), b.getTextureCoordinates(BlockFace.Right).y());
	    		GL11.glVertex3f(-1.0f, 1.0f, 1.0f);   // Bottom Right Of The Texture and Quad
	        GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Right).x() + size, b.getTextureCoordinates(BlockFace.Right).y());
	        	GL11.glVertex3f(-1.0f, 1.0f,-1.0f);   // Top Right Of The Texture and Quad
	        GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Right).x() + size, b.getTextureCoordinates(BlockFace.Right).y() + size);
	        	GL11.glVertex3f(-1.0f,-1.0f,-1.0f);   // Top Left Of The Texture and Quad
	        GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Right).x(), b.getTextureCoordinates(BlockFace.Right).y() + size);
	        	GL11.glVertex3f(-1.0f,-1.0f, 1.0f);   // Bottom Left Of The Texture and Quad

        // Left Face
	    GL11.glNormal3f(0.0f, 1.0f, 0.0f);
	        GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Left).x(), b.getTextureCoordinates(BlockFace.Left).y());
	        	GL11.glVertex3f( 1.0f, 1.0f,-1.0f);   // Bottom Left Of The Texture and Quad
	        GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Left).x() + size, b.getTextureCoordinates(BlockFace.Left).y());
	        	GL11.glVertex3f( 1.0f, 1.0f, 1.0f);   // Bottom Right Of The Texture and Quad
	        GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Left).x() + size, b.getTextureCoordinates(BlockFace.Left).y() + size);;
	        	GL11.glVertex3f( 1.0f,-1.0f, 1.0f);   // Top Right Of The Texture and Quad
	        GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Left).x(), b.getTextureCoordinates(BlockFace.Left).y() + size);
	        	GL11.glVertex3f( 1.0f,-1.0f,-1.0f);   // Top Left Of The Texture and Quad

	    GL11.glEnd();
	    GL11.glTranslatef(Binder.getPlayerObject().getLocation().x, Binder.getPlayerObject().getLocation().y, Binder.getPlayerObject().getLocation().z);
	    GL11.glPopMatrix();
	}
	
	
	public enum BlockFace{
		Top, Bottom, Left, Right, Back, Front;
	}
	
	public static void init(){
			
	}
	
	public static void drawString(String s, int x, int y) {
	      int startX = x;
	      GL11.glBegin(GL11.GL_POINTS);
	      for (char c : s.toLowerCase().toCharArray()) {
	         if (c == 'a') {
	            for (int i = 0; i < 8; i++) {
	               GL11.glVertex2f(x + 1, y + i);
	               GL11.glVertex2f(x + 7, y + i);
	            }
	            for (int i = 2; i <= 6; i++) {
	               GL11.glVertex2f(x + i, y + 8);
	               GL11.glVertex2f(x + i, y + 4);
	            }
	            x += 8;
	         } else if (c == 'b') {
	            for (int i = 0; i < 8; i++) {
	               GL11.glVertex2f(x + 1, y + i);
	            }
	            for (int i = 1; i <= 6; i++) {
	               GL11.glVertex2f(x + i, y);
	               GL11.glVertex2f(x + i, y + 4);
	               GL11.glVertex2f(x + i, y + 8);
	            }
	            GL11.glVertex2f(x + 7, y + 5);
	            GL11.glVertex2f(x + 7, y + 7);
	            GL11.glVertex2f(x + 7, y + 6);
	            GL11.glVertex2f(x + 7, y + 1);
	            GL11.glVertex2f(x + 7, y + 2);
	            GL11.glVertex2f(x + 7, y + 3);
	            x += 8;
	         } else if (c == 'c') {
	            for (int i = 1; i <= 7; i++) {
	               GL11.glVertex2f(x + 1, y + i);
	            }
	            for (int i = 2; i <= 5; i++) {
	               GL11.glVertex2f(x + i, y);
	               GL11.glVertex2f(x + i, y + 8);
	            }
	            GL11.glVertex2f(x + 6, y + 1);
	            GL11.glVertex2f(x + 6, y + 2);

	            GL11.glVertex2f(x + 6, y + 6);
	            GL11.glVertex2f(x + 6, y + 7);

	            x += 8;
	         } else if (c == 'd') {
	            for (int i = 0; i <= 8; i++) {
	               GL11.glVertex2f(x + 1, y + i);
	            }
	            for (int i = 2; i <= 5; i++) {
	               GL11.glVertex2f(x + i, y);
	               GL11.glVertex2f(x + i, y + 8);
	            }
	            GL11.glVertex2f(x + 6, y + 1);
	            GL11.glVertex2f(x + 6, y + 2);
	            GL11.glVertex2f(x + 6, y + 3);
	            GL11.glVertex2f(x + 6, y + 4);
	            GL11.glVertex2f(x + 6, y + 5);
	            GL11.glVertex2f(x + 6, y + 6);
	            GL11.glVertex2f(x + 6, y + 7);

	            x += 8;
	         } else if (c == 'e') {
	            for (int i = 0; i <= 8; i++) {
	               GL11.glVertex2f(x + 1, y + i);
	            }
	            for (int i = 1; i <= 6; i++) {
	               GL11.glVertex2f(x + i, y + 0);
	               GL11.glVertex2f(x + i, y + 8);
	            }
	            for (int i = 2; i <= 5; i++) {
	               GL11.glVertex2f(x + i, y + 4);
	            }
	            x += 8;
	         } else if (c == 'f') {
	            for (int i = 0; i <= 8; i++) {
	               GL11.glVertex2f(x + 1, y + i);
	            }
	            for (int i = 1; i <= 6; i++) {
	               GL11.glVertex2f(x + i, y + 8);
	            }
	            for (int i = 2; i <= 5; i++) {
	               GL11.glVertex2f(x + i, y + 4);
	            }
	            x += 8;
	         } else if (c == 'g') {
	            for (int i = 1; i <= 7; i++) {
	               GL11.glVertex2f(x + 1, y + i);
	            }
	            for (int i = 2; i <= 5; i++) {
	               GL11.glVertex2f(x + i, y);
	               GL11.glVertex2f(x + i, y + 8);
	            }
	            GL11.glVertex2f(x + 6, y + 1);
	            GL11.glVertex2f(x + 6, y + 2);
	            GL11.glVertex2f(x + 6, y + 3);
	            GL11.glVertex2f(x + 5, y + 3);
	            GL11.glVertex2f(x + 7, y + 3);

	            GL11.glVertex2f(x + 6, y + 6);
	            GL11.glVertex2f(x + 6, y + 7);

	            x += 8;
	         } else if (c == 'h') {
	            for (int i = 0; i <= 8; i++) {
	               GL11.glVertex2f(x + 1, y + i);
	               GL11.glVertex2f(x + 7, y + i);
	            }
	            for (int i = 2; i <= 6; i++) {
	               GL11.glVertex2f(x + i, y + 4);
	            }
	            x += 8;
	         } else if (c == 'i') {
	            for (int i = 0; i <= 8; i++) {
	               GL11.glVertex2f(x + 3, y + i);
	            }
	            for (int i = 1; i <= 5; i++) {
	               GL11.glVertex2f(x + i, y + 0);
	               GL11.glVertex2f(x + i, y + 8);
	            }
	            x += 7;
	         } else if (c == 'j') {
	            for (int i = 1; i <= 8; i++) {
	               GL11.glVertex2f(x + 6, y + i);
	            }
	            for (int i = 2; i <= 5; i++) {
	               GL11.glVertex2f(x + i, y + 0);
	            }
	            GL11.glVertex2f(x + 1, y + 3);
	            GL11.glVertex2f(x + 1, y + 2);
	            GL11.glVertex2f(x + 1, y + 1);
	            x += 8;
	         } else if (c == 'k') {
	            for (int i = 0; i <= 8; i++) {
	               GL11.glVertex2f(x + 1, y + i);
	            }
	            GL11.glVertex2f(x + 6, y + 8);
	            GL11.glVertex2f(x + 5, y + 7);
	            GL11.glVertex2f(x + 4, y + 6);
	            GL11.glVertex2f(x + 3, y + 5);
	            GL11.glVertex2f(x + 2, y + 4);
	            GL11.glVertex2f(x + 2, y + 3);
	            GL11.glVertex2f(x + 3, y + 4);
	            GL11.glVertex2f(x + 4, y + 3);
	            GL11.glVertex2f(x + 5, y + 2);
	            GL11.glVertex2f(x + 6, y + 1);
	            GL11.glVertex2f(x + 7, y);
	            x += 8;
	         } else if (c == 'l') {
	            for (int i = 0; i <= 8; i++) {
	               GL11.glVertex2f(x + 1, y + i);
	            }
	            for (int i = 1; i <= 6; i++) {
	               GL11.glVertex2f(x + i, y);
	            }
	            x += 7;
	         } else if (c == 'm') {
	            for (int i = 0; i <= 8; i++) {
	               GL11.glVertex2f(x + 1, y + i);
	               GL11.glVertex2f(x + 7, y + i);
	            }
	            GL11.glVertex2f(x + 3, y + 6);
	            GL11.glVertex2f(x + 2, y + 7);
	            GL11.glVertex2f(x + 4, y + 5);

	            GL11.glVertex2f(x + 5, y + 6);
	            GL11.glVertex2f(x + 6, y + 7);
	            GL11.glVertex2f(x + 4, y + 5);
	            x += 8;
	         } else if (c == 'n') {
	            for (int i = 0; i <= 8; i++) {
	               GL11.glVertex2f(x + 1, y + i);
	               GL11.glVertex2f(x + 7, y + i);
	            }
	            GL11.glVertex2f(x + 2, y + 7);
	            GL11.glVertex2f(x + 2, y + 6);
	            GL11.glVertex2f(x + 3, y + 5);
	            GL11.glVertex2f(x + 4, y + 4);
	            GL11.glVertex2f(x + 5, y + 3);
	            GL11.glVertex2f(x + 6, y + 2);
	            GL11.glVertex2f(x + 6, y + 1);
	            x += 8;
	         } else if (c == 'o' || c == '0') {
	            for (int i = 1; i <= 7; i++) {
	               GL11.glVertex2f(x + 1, y + i);
	               GL11.glVertex2f(x + 7, y + i);
	            }
	            for (int i = 2; i <= 6; i++) {
	               GL11.glVertex2f(x + i, y + 8);
	               GL11.glVertex2f(x + i, y + 0);
	            }
	            x += 8;
	         } else if (c == 'p') {
	            for (int i = 0; i <= 8; i++) {
	               GL11.glVertex2f(x + 1, y + i);
	            }
	            for (int i = 2; i <= 5; i++) {
	               GL11.glVertex2f(x + i, y + 8);
	               GL11.glVertex2f(x + i, y + 4);
	            }
	            GL11.glVertex2f(x + 6, y + 7);
	            GL11.glVertex2f(x + 6, y + 5);
	            GL11.glVertex2f(x + 6, y + 6);
	            x += 8;
	         } else if (c == 'q') {
	            for (int i = 1; i <= 7; i++) {
	               GL11.glVertex2f(x + 1, y + i);
	               if (i != 1)
	                  GL11.glVertex2f(x + 7, y + i);
	            }
	            for (int i = 2; i <= 6; i++) {
	               GL11.glVertex2f(x + i, y + 8);
	               if (i != 6)
	                  GL11.glVertex2f(x + i, y + 0);
	            }
	            GL11.glVertex2f(x + 4, y + 3);
	            GL11.glVertex2f(x + 5, y + 2);
	            GL11.glVertex2f(x + 6, y + 1);
	            GL11.glVertex2f(x + 7, y);
	            x += 8;
	         } else if (c == 'r') {
	            for (int i = 0; i <= 8; i++) {
	               GL11.glVertex2f(x + 1, y + i);
	            }
	            for (int i = 2; i <= 5; i++) {
	               GL11.glVertex2f(x + i, y + 8);
	               GL11.glVertex2f(x + i, y + 4);
	            }
	            GL11.glVertex2f(x + 6, y + 7);
	            GL11.glVertex2f(x + 6, y + 5);
	            GL11.glVertex2f(x + 6, y + 6);

	            GL11.glVertex2f(x + 4, y + 3);
	            GL11.glVertex2f(x + 5, y + 2);
	            GL11.glVertex2f(x + 6, y + 1);
	            GL11.glVertex2f(x + 7, y);
	            x += 8;
	         } else if (c == 's') {
	            for (int i = 2; i <= 7; i++) {
	               GL11.glVertex2f(x + i, y + 8);
	            }
	            GL11.glVertex2f(x + 1, y + 7);
	            GL11.glVertex2f(x + 1, y + 6);
	            GL11.glVertex2f(x + 1, y + 5);
	            for (int i = 2; i <= 6; i++) {
	               GL11.glVertex2f(x + i, y + 4);
	               GL11.glVertex2f(x + i, y);
	            }
	            GL11.glVertex2f(x + 7, y + 3);
	            GL11.glVertex2f(x + 7, y + 2);
	            GL11.glVertex2f(x + 7, y + 1);
	            GL11.glVertex2f(x + 1, y + 1);
	            GL11.glVertex2f(x + 1, y + 2);
	            x += 8;
	         } else if (c == 't') {
	            for (int i = 0; i <= 8; i++) {
	               GL11.glVertex2f(x + 4, y + i);
	            }
	            for (int i = 1; i <= 7; i++) {
	               GL11.glVertex2f(x + i, y + 8);
	            }
	            x += 7;
	         } else if (c == 'u') {
	            for (int i = 1; i <= 8; i++) {
	               GL11.glVertex2f(x + 1, y + i);
	               GL11.glVertex2f(x + 7, y + i);
	            }
	            for (int i = 2; i <= 6; i++) {
	               GL11.glVertex2f(x + i, y + 0);
	            }
	            x += 8;
	         } else if (c == 'v') {
	            for (int i = 2; i <= 8; i++) {
	               GL11.glVertex2f(x + 1, y + i);
	               GL11.glVertex2f(x + 6, y + i);
	            }
	            GL11.glVertex2f(x + 2, y + 1);
	            GL11.glVertex2f(x + 5, y + 1);
	            GL11.glVertex2f(x + 3, y);
	            GL11.glVertex2f(x + 4, y);
	            x += 7;
	         } else if (c == 'w') {
	            for (int i = 1; i <= 8; i++) {
	               GL11.glVertex2f(x + 1, y + i);
	               GL11.glVertex2f(x + 7, y + i);
	            }
	            GL11.glVertex2f(x + 2, y);
	            GL11.glVertex2f(x + 3, y);
	            GL11.glVertex2f(x + 5, y);
	            GL11.glVertex2f(x + 6, y);
	            for (int i = 1; i <= 6; i++) {
	               GL11.glVertex2f(x + 4, y + i);
	            }
	            x += 8;
	         } else if (c == 'x') {
	            for (int i = 1; i <= 7; i++)
	               GL11.glVertex2f(x + i, y + i);
	            for (int i = 7; i >= 1; i--)
	               GL11.glVertex2f(x + i, y + 8 - i);
	            x += 8;
	         } else if (c == 'y') {
	            GL11.glVertex2f(x + 4, y);
	            GL11.glVertex2f(x + 4, y + 1);
	            GL11.glVertex2f(x + 4, y + 2);
	            GL11.glVertex2f(x + 4, y + 3);
	            GL11.glVertex2f(x + 4, y + 4);

	            GL11.glVertex2f(x + 3, y + 5);
	            GL11.glVertex2f(x + 2, y + 6);
	            GL11.glVertex2f(x + 1, y + 7);
	            GL11.glVertex2f(x + 1, y + 8);

	            GL11.glVertex2f(x + 5, y + 5);
	            GL11.glVertex2f(x + 6, y + 6);
	            GL11.glVertex2f(x + 7, y + 7);
	            GL11.glVertex2f(x + 7, y + 8);
	            x += 8;
	         } else if (c == 'z') {
	            for (int i = 1; i <= 6; i++) {
	               GL11.glVertex2f(x + i, y);
	               GL11.glVertex2f(x + i, y + 8);
	               GL11.glVertex2f(x + i, y + i);
	            }
	            GL11.glVertex2f(x + 6, y + 7);
	            x += 8;
	         } else if (c == '1') {
	            for (int i = 2; i <= 6; i++) {
	               GL11.glVertex2f(x + i, y);
	            }
	            for (int i = 1; i <= 8; i++) {
	               GL11.glVertex2f(x + 4, y + i);
	            }
	            GL11.glVertex2f(x + 3, y + 7);
	            x += 8;
	         } else if (c == '2') {
	            for (int i = 1; i <= 6; i++) {
	               GL11.glVertex2f(x + i, y);
	            }
	            for (int i = 2; i <= 5; i++) {
	               GL11.glVertex2f(x + i, y + 8);
	            }
	            GL11.glVertex2f(x + 1, y + 7);
	            GL11.glVertex2f(x + 1, y + 6);

	            GL11.glVertex2f(x + 6, y + 7);
	            GL11.glVertex2f(x + 6, y + 6);
	            GL11.glVertex2f(x + 6, y + 5);
	            GL11.glVertex2f(x + 5, y + 4);
	            GL11.glVertex2f(x + 4, y + 3);
	            GL11.glVertex2f(x + 3, y + 2);
	            GL11.glVertex2f(x + 2, y + 1);
	            x += 8;
	         } else if (c == '3') {
	            for (int i = 1; i <= 5; i++) {
	               GL11.glVertex2f(x + i, y + 8);
	               GL11.glVertex2f(x + i, y);
	            }
	            for (int i = 1; i <= 7; i++) {
	               GL11.glVertex2f(x + 6, y + i);
	            }
	            for (int i = 2; i <= 5; i++) {
	               GL11.glVertex2f(x + i, y + 4);
	            }
	            x += 8;
	         } else if (c == '4') {
	            for (int i = 2; i <= 8; i++) {
	               GL11.glVertex2f(x + 1, y + i);
	            }
	            for (int i = 2; i <= 7; i++) {
	               GL11.glVertex2f(x + i, y + 1);
	            }
	            for (int i = 0; i <= 4; i++) {
	               GL11.glVertex2f(x + 4, y + i);
	            }
	            x += 8;
	         } else if (c == '5') {
	            for (int i = 1; i <= 7; i++) {
	               GL11.glVertex2f(x + i, y + 8);
	            }
	            for (int i = 4; i <= 7; i++) {
	               GL11.glVertex2f(x + 1, y + i);
	            }
	            GL11.glVertex2f(x + 1, y + 1);
	            GL11.glVertex2f(x + 2, y);
	            GL11.glVertex2f(x + 3, y);
	            GL11.glVertex2f(x + 4, y);
	            GL11.glVertex2f(x + 5, y);
	            GL11.glVertex2f(x + 6, y);

	            GL11.glVertex2f(x + 7, y + 1);
	            GL11.glVertex2f(x + 7, y + 2);
	            GL11.glVertex2f(x + 7, y + 3);

	            GL11.glVertex2f(x + 6, y + 4);
	            GL11.glVertex2f(x + 5, y + 4);
	            GL11.glVertex2f(x + 4, y + 4);
	            GL11.glVertex2f(x + 3, y + 4);
	            GL11.glVertex2f(x + 2, y + 4);
	            x += 8;
	         } else if (c == '6') {
	            for (int i = 1; i <= 7; i++) {
	               GL11.glVertex2f(x + 1, y + i);
	            }
	            for (int i = 2; i <= 6; i++) {
	               GL11.glVertex2f(x + i, y);
	            }
	            for (int i = 2; i <= 5; i++) {
	               GL11.glVertex2f(x + i, y + 4);
	               GL11.glVertex2f(x + i, y + 8);
	            }
	            GL11.glVertex2f(x + 7, y + 1);
	            GL11.glVertex2f(x + 7, y + 2);
	            GL11.glVertex2f(x + 7, y + 3);
	            GL11.glVertex2f(x + 6, y + 4);
	            x += 8;
	         } else if (c == '7') {
	            for (int i = 0; i <= 7; i++)
	               GL11.glVertex2f(x + i, y + 8);
	            GL11.glVertex2f(x + 7, y + 7);
	            GL11.glVertex2f(x + 7, y + 6);

	            GL11.glVertex2f(x + 6, y + 5);
	            GL11.glVertex2f(x + 5, y + 4);
	            GL11.glVertex2f(x + 4, y + 3);
	            GL11.glVertex2f(x + 3, y + 2);
	            GL11.glVertex2f(x + 2, y + 1);
	            GL11.glVertex2f(x + 1, y);
	            x += 8;
	         } else if (c == '8') {
	            for (int i = 1; i <= 7; i++) {
	               GL11.glVertex2f(x + 1, y + i);
	               GL11.glVertex2f(x + 7, y + i);
	            }
	            for (int i = 2; i <= 6; i++) {
	               GL11.glVertex2f(x + i, y + 8);
	               GL11.glVertex2f(x + i, y + 0);
	            }
	            for (int i = 2; i <= 6; i++) {
	               GL11.glVertex2f(x + i, y + 4);
	            }
	            x += 8;
	         } else if (c == '9') {
	            for (int i = 1; i <= 7; i++) {
	               GL11.glVertex2f(x + 7, y + i);
	            }
	            for (int i = 5; i <= 7; i++) {
	               GL11.glVertex2f(x + 1, y + i);
	            }
	            for (int i = 2; i <= 6; i++) {
	               GL11.glVertex2f(x + i, y + 8);
	               GL11.glVertex2f(x + i, y + 0);
	            }
	            for (int i = 2; i <= 6; i++) {
	               GL11.glVertex2f(x + i, y + 4);
	            }
	            GL11.glVertex2f(x + 1, y + 0);
	            x += 8;
	         } else if (c == '.') {
	            GL11.glVertex2f(x + 1, y);
	            x += 2;
	         } else if (c == ',') {
	            GL11.glVertex2f(x + 1, y);
	            GL11.glVertex2f(x + 1, y + 1);
	            x += 2;
	         } else if (c == '\n') {
	            y -= 10;
	            x = startX;
	         } else if (c == ' ') {
	            x += 8;
	         }
	      }
	      GL11.glEnd();
	   }
}