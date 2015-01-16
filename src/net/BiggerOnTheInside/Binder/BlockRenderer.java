/***************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                           */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/Binder.txt)   */
/***************************************************************************************************/
package net.BiggerOnTheInside.Binder;

import org.lwjgl.opengl.GL11;
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
}