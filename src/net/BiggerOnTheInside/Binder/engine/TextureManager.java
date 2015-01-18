/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder.engine;

import net.BiggerOnTheInside.Binder.Binder;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class TextureManager {
	private String path;
	private Texture sheet;
	
	public TextureManager(String path){
		this.path = path;
	}
	
	public void loadTextureSheet(String name){
		try {
			this.sheet = TextureLoader.getTexture("PNG", Binder.class.getResource(path + name).openStream());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadTextureSheet(String name, boolean autoBind){
		try {
			this.sheet = TextureLoader.getTexture("PNG", Binder.class.getResource(path + name).openStream());
			this.sheet.bind();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void releaseTextureSheet(){
		if(this.sheet != null){
			this.sheet.release();
		}
	}
}
