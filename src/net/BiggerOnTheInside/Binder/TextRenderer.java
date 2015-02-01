/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder;

import java.awt.Font;
import java.io.IOException;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.TextureLoader;

import com.nishu.utils.Color4f;

public class TextRenderer {
	static TrueTypeFont ttf;
	
	public static void renderString(String s){
		ttf = new TrueTypeFont(new Font("Times New Roman", Font.BOLD, 10), false);
		
		ttf.drawString(10f, 25f, s, Color.yellow);
	}
}
