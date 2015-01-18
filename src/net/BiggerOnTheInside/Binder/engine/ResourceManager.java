/***************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                           */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/Binder.txt)   */
/***************************************************************************************************/

package net.BiggerOnTheInside.Binder.engine;

import net.BiggerOnTheInside.Binder.JSONManager;

public class ResourceManager {
	private TextureManager textureManager;
	private JSONManager jsonManager;
	private String path;
	
	public ResourceManager(String resourceFolderPath){
		this.path = resourceFolderPath;
		
		init();
	}
	
	public void init(){
		this.textureManager = new TextureManager(path);
		this.jsonManager = new JSONManager(path);
	}
	
	public TextureManager getTextureManager(){
		return textureManager;
	}
	
	public JSONManager getJSONManager(){
		return jsonManager;
	}
}
