/***************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                           */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/Binder.txt)   */
/***************************************************************************************************/
package net.BiggerOnTheInside.Binder;

public enum ColorRGB {
	White(new float[]{
			1f, 1f, 1f
	}),
	
	Black(new float[]{
			0f, 0f, 0f
	}),
	
	Blue(new float[]{
			0f, 0f, 1f
	}),
	
	Green(new float[]{
			0f, 1f, 0f
	}),
	
	Red(new float[]{
			1f, 0f, 0f
	}),
	
	Yellow(new float[]{
			1f, 1f, 0f
	}),
	
	Cyan(new float[]{
			0f, 1f, 1f
	}),
	
	Magenta(new float[]{
			1f, 0f, 1f
	}),
	
	Aquamarine(new float[]{
			0.439216f, 0.858824f, 0.576471f
	}),
	
	BlueViolet(new float[]{
			0.62352f, 0.372549f, 0.623529f
	}),
	
	Brown(new float[]{
			0.647059f, 0.164706f, 0.164706f
	}),
	
	CadetBlue(new float[]{
			0.372549f, 0.623529f, 0.623529f
	}),
	
	Coral(new float[]{
			1.0f, 0.498039f, 0.0f
	}),
	
	CornFlowerBlue(new float[]{
			0.258824f, 0.258824f, 0.435294f
	}),
	
	DarkGreen(new float[]{
			
	}),
	
	DarkOliveGreen(new float[]{
			
	}),
	
	DarkOrchid(new float[]{
			
	}),
	
	DarkSlateBlue(new float[]{
			
	}),
	
	DarkSlateGray(new float[]{
			
	}),
	
	DarkTurquoise(new float[]{
			
	}),
	
	Firebrick(new float[]{
			
	}),
	
	ForestGreen(new float[]{
			
	}),
	
	Gold(new float[]{
			
	}),
	
	GoldenRod(new float[]{
			
	}),
	
	GreenYellow(new float[]{
			
	}),
	
	IndianRed(new float[]{
			
	}),
	
	Khaki(new float[]{
			
	}),
	
	LightBlue(new float[]{
			
	}),
	
	LightSlateBlue(new float[]{
			
	}),
	
	VeryDarkBrown(new float[]{
			
	}),
	
	DarkBrown(new float[]{
			
	}),
	
	NewMidnightBlue(new float[]{
			
	});
	public float[] array;
	
	ColorRGB(float[] a){
		this.array = a;
	}
	
	public float[] getFloatArray(){
		return this.array;
	}
	
	public float red(){
		return this.array[0];
	}
	
	public float green(){
		return this.array[1];
	}
	
	public float blue(){
		return this.array[2];
	}


}
