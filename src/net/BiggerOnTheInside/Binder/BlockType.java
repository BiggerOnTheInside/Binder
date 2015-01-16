package net.BiggerOnTheInside.Binder;

public enum BlockType {
	Air(0),
	Dirt(1),
	CobbleStone(2);
	
	int t;
	
	BlockType(int i){
		t = i;
	}
	
	public int getID(){
		return t;
	}
}
