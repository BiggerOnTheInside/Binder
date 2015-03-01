/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder;

import java.awt.Font;
import java.util.HashMap;

import me.wxwsk8er.Knapsack.ChatColor;

import org.newdawn.slick.TrueTypeFont;


public class TextRenderer {
	private Binder instance;
	private HashMap<String, TrueTypeFont> fonts = new HashMap<String, TrueTypeFont>();
	
	public TextRenderer(){		
		try {
			System.out.println(Font.createFont(Font.TRUETYPE_FONT, Binder.class.getResource("resources/fonts/Joystix.ttf").openStream()).getName());
			addFont(new Font("Times New Roman", Font.BOLD, 24), false);
			
			Font _tmp = Font.createFont(Font.TRUETYPE_FONT, Binder.class.getResourceAsStream("resources/fonts/Joystix.ttf"));
			Font a = _tmp.deriveFont(Font.PLAIN, 24);
			
			addFont("Default", a, false);
		} 
		catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addFont(Font f, boolean antiA){
		fonts.put(f.getName(), new TrueTypeFont(f, antiA));
	}
	
	public void addFont(String s, Font f, boolean antiA){
		fonts.put(s, new TrueTypeFont(f, antiA));
	}
	
	public void renderString(String fontName, int x, int y, String s, ChatColor c){
		fonts.get(fontName).drawString(x, y, s, c.getColor());
	}
	
	public void renderString(int x, int y, String s, ChatColor c){
		fonts.get("Default").drawString(x, y, s, c.getColor());
	}
}
