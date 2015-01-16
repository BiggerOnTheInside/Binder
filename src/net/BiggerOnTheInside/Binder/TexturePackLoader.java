package net.BiggerOnTheInside.Binder;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class TexturePackLoader {
	public static final float TEXTURE_SIZE = 1 / 32f;

	private Texture texturePackTexture;
	
	public TexturePackLoader(String path, boolean autoBind){
		try {
			texturePackTexture = TextureLoader.getTexture("PNG", Binder.class.getResource(Util.RESOURCE_FOLDER_NAME + path).openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(autoBind){
			bind();
		}
	}
	
	private void bind(){
		texturePackTexture.bind();
	}
	
	private void release(){
		texturePackTexture.release();
	}
}
