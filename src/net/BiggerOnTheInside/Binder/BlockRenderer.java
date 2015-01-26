/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder;

import org.lwjgl.opengl.GL11;

public class BlockRenderer{

	public static void renderBlock(Block b, float x, float y, float z) {
		   GL11.glPushMatrix();
		      GL11.glTranslatef(x * 2f, y * 2f, z * 2f);
		      GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
		        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
		      GL11.glBegin(GL11.GL_QUADS);

		      float size = 1f / Globals.TEXTURES_PER_SHEET;

		      // Top Face
		      //GL11.glNormal3f(0.0f, 0.0f, -1.0f);
		      GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Top).x(), b.getTextureCoordinates(BlockFace.Top).y());
		         GL11.glVertex3f( 1.0f, 1.0f,-1.0f);  
		      GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Top).x() + size, b.getTextureCoordinates(BlockFace.Top).y());
		         GL11.glVertex3f(-1.0f, 1.0f,-1.0f);
		      GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Top).x() + size, b.getTextureCoordinates(BlockFace.Top).y() + size);
		         GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
		      GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Top).x(), b.getTextureCoordinates(BlockFace.Top).y() + size);
		         GL11.glVertex3f( 1.0f, 1.0f, 1.0f); 
		 
		        // Bottom Face
		        //GL11.glNormal3f(0.0f, 0.0f, 1.0f);
		         GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Bottom).x(), b.getTextureCoordinates(BlockFace.Bottom).y());
		           GL11.glVertex3f( 1.0f,-1.0f, 1.0f);   // Bottom Right Of The Texture and Quad
		        GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Bottom).x() + size, b.getTextureCoordinates(BlockFace.Bottom).y());
		           GL11.glVertex3f(-1.0f,-1.0f, 1.0f);   // Top Right Of The Texture and Quad
		        GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Bottom).x() + size, b.getTextureCoordinates(BlockFace.Bottom).y() + size);
		           GL11.glVertex3f(-1.0f,-1.0f,-1.0f);  // Top Left Of The Texture and Quad
		        GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Bottom).x(), b.getTextureCoordinates(BlockFace.Bottom).y() + size);
		           GL11.glVertex3f( 1.0f,-1.0f,-1.0f);  // Bottom Left Of The Texture and Quad

		      
		        // Back Face
		        //GL11.glNormal3f(1.0f, 0.0f, 0.0f);
		        GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Back).x(), b.getTextureCoordinates(BlockFace.Back).y());
		           GL11.glVertex3f( 1.0f, 1.0f, 1.0f);   // Top Left Of The Texture and Quad
		        GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Back).x() + size, b.getTextureCoordinates(BlockFace.Back).y());
		           GL11.glVertex3f(-1.0f, 1.0f, 1.0f);  // Bottom Left Of The Texture and Quad
		        GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Back).x() + size, b.getTextureCoordinates(BlockFace.Back).y() + size);
		             GL11.glVertex3f(-1.0f,-1.0f, 1.0f);  //Bottom Right Of The Texture and Quad
		        GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Back).x(), b.getTextureCoordinates(BlockFace.Back).y() + size);
		           GL11.glVertex3f( 1.0f,-1.0f, 1.0f);   // Top Right Of The Texture and Quad

		        // Front Face
		        //GL11.glNormal3f(-1.0f, 0.0f, 0.0f);
		           GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Front).x(), b.getTextureCoordinates(BlockFace.Front).y());
		              GL11.glVertex3f( 1.0f,-1.0f,-1.0f);   // Top Right Of The Texture and Quad
		           GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Front).x() + size, b.getTextureCoordinates(BlockFace.Front).y());
		              GL11.glVertex3f(-1.0f,-1.0f,-1.0f);   // Top Left Of The Texture and Quad
		           GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Front).x() + size, b.getTextureCoordinates(BlockFace.Front).y() + size);
		              GL11.glVertex3f(-1.0f, 1.0f,-1.0f);   // Bottom Left Of The Texture and Quad
		           GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Front).x(), b.getTextureCoordinates(BlockFace.Front).y() + size);
		              GL11.glVertex3f( 1.0f, 1.0f,-1.0f);   // Bottom Right Of The Texture and Quad

		        // Right face
		       //GL11.glNormal3f(0.0f, -1.0f, 0.0f);
		          GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Right).x(), b.getTextureCoordinates(BlockFace.Right).y());
		             GL11.glVertex3f(-1.0f, 1.0f, 1.0f);   // Bottom Right Of The Texture and Quad
		           GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Right).x() + size, b.getTextureCoordinates(BlockFace.Right).y());
		              GL11.glVertex3f(-1.0f, 1.0f,-1.0f);   // Top Right Of The Texture and Quad
		           GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Right).x() + size, b.getTextureCoordinates(BlockFace.Right).y() + size);
		              GL11.glVertex3f(-1.0f,-1.0f,-1.0f);   // Top Left Of The Texture and Quad
		           GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Right).x(), b.getTextureCoordinates(BlockFace.Right).y() + size);
		              GL11.glVertex3f(-1.0f,-1.0f, 1.0f);   // Bottom Left Of The Texture and Quad

		        // Left Face
		       //GL11.glNormal3f(0.0f, 1.0f, 0.0f);
		           GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Left).x(), b.getTextureCoordinates(BlockFace.Left).y());
		              GL11.glVertex3f( 1.0f, 1.0f,-1.0f);   // Bottom Left Of The Texture and Quad
		           GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Left).x() + size, b.getTextureCoordinates(BlockFace.Left).y());
		              GL11.glVertex3f( 1.0f, 1.0f, 1.0f);   // Bottom Right Of The Texture and Quad
		           GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Left).x() + size, b.getTextureCoordinates(BlockFace.Left).y() + size);;
		              GL11.glVertex3f( 1.0f,-1.0f, 1.0f);   // Top Right Of The Texture and Quad
		           GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Left).x(), b.getTextureCoordinates(BlockFace.Left).y() + size);
		              GL11.glVertex3f( 1.0f,-1.0f,-1.0f);   // Top Left Of The Texture and Quad

		       GL11.glEnd();
		       GL11.glTranslatef(FirstPersonCamera.getPosition().x, FirstPersonCamera.getPosition().y, FirstPersonCamera.getPosition().z);
		       GL11.glPopMatrix();
		  
	}
		/*GL11.glPushMatrix();
		float size = 1f / Globals.TEXTURES_PER_SHEET;
		
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
	    GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
	    
	    GL11.glTranslatef(x * 2f, y * 2f, z * 2f);
	    
		
		GL11.glBegin(GL11.GL_QUADS);
		
			// Top face.
			//GL11.glColor3f(0.0f, 1.0f, 0.0f);
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Top).x(), b.getTextureCoordinates(BlockFace.Top).y());
				 GL11.glVertex3f(1.0f, 1.0f, -1.0f);
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Top).x() + size, b.getTextureCoordinates(BlockFace.Top).y());
				 GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Top).x() + size, b.getTextureCoordinates(BlockFace.Top).y() + size);
				 GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Top).x(), b.getTextureCoordinates(BlockFace.Top).y() + size);
				 GL11.glVertex3f(1.0f, 1.0f, 1.0f);
				 
			// Bottom.
			//GL11.glColor3f(1.0f, 0.5f, 0.0f);
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Bottom).x(), b.getTextureCoordinates(BlockFace.Bottom).y());
				 GL11.glVertex3f(1.0f, -1.0f, 1.0f);
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Bottom).x() + size, b.getTextureCoordinates(BlockFace.Bottom).y());
				 GL11.glVertex3f(-1.0f, -1.0f, 1.0f);
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Bottom).x() + size, b.getTextureCoordinates(BlockFace.Bottom).y() + size);
				 GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Bottom).x(), b.getTextureCoordinates(BlockFace.Bottom).y() + size);
				 GL11.glVertex3f(1.0f, -1.0f, -1.0f);
				 
			// Front.
			 //GL11.glColor3f(1.0f, 0.0f, 0.0f); 
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Front).x(), b.getTextureCoordinates(BlockFace.Front).y());
				 GL11.glVertex3f(1.0f, 1.0f, 1.0f); 
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Front).x() + size, b.getTextureCoordinates(BlockFace.Front).y());
				 GL11.glVertex3f(-1.0f, 1.0f, 1.0f); 
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Front).x() + size, b.getTextureCoordinates(BlockFace.Front).y() + size);
				 GL11.glVertex3f(-1.0f, -1.0f, 1.0f); 
			GL11.glTexCoord2f(b.getTextureCoordinates(BlockFace.Front).x(), b.getTextureCoordinates(BlockFace.Front).y() + size);
				 GL11.glVertex3f(1.0f, -1.0f, 1.0f);
			
			// Back.
			 //GL11.glColor3f(1.0f, 1.0f, 0.0f);
				 GL11.glVertex3f(1.0f, -1.0f, -1.0f); 
				 GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
				 GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
				 GL11.glVertex3f(1.0f, 1.0f, -1.0f);
				
				 // Left
			// GL11.glColor3f(0.0f, 0.0f, 1.0f);
				 GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
				 GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
				 GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
				 GL11.glVertex3f(-1.0f, -1.0f, 1.0f); 
				
			// Right.
			// GL11.glColor3f(1.0f, 0.0f, 1.0f);
				 GL11.glVertex3f(1.0f, 1.0f, -1.0f);
				 GL11.glVertex3f(1.0f, 1.0f, 1.0f);
				 GL11.glVertex3f(1.0f, -1.0f, 1.0f); 
				 GL11.glVertex3f(1.0f, -1.0f, -1.0f); 
		 GL11.glEnd();
		 
		// GL11.glTranslatef(GameLoop.getPlayerObject().getLocation().x, GameLoop.getPlayerObject().getLocation().y, GameLoop.getPlayerObject().getLocation().z);
		 GL11.glTranslatef(0f, 0f, 0f);
		 GL11.glPopMatrix();
	}
*/
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
