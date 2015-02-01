/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder;


public class ResourceManager {
	private TextureManager textureManager;
	private JSONManager jsonManager;
	private String path;
	
	/* Note: Path is relative to the Binder class. */
	public ResourceManager(String resourceFolderPath){
		this.path = resourceFolderPath;
		
		init();
	}
	
	public void init(){
		this.textureManager = new TextureManager(path + "/textures/terrain.png");
		this.jsonManager = new JSONManager("Binder.json", false);
	}
	
	public TextureManager getTextureManager(){
		return textureManager;
	}
	
	public JSONManager getJSONManager(){
		return jsonManager;
	}
}
