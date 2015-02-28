package net.BiggerOnTheInside.Binder;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

public class FontRenderer
{
    private UnicodeFont font;
     
    @SuppressWarnings("unchecked")
	public FontRenderer()
    {
        try
        {
            font = new UnicodeFont(new Font("Verdana", Font.BOLD, 12));
            font.getEffects().add(new ColorEffect());
            font.addAsciiGlyphs();
            font.loadGlyphs();
        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
    }
 
    public void drawString(String text, int x, int y)
    {
        font.drawString(x, y, text, Color.red);     
    }
}