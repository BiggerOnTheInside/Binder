package net.BiggerOnTheInside.Binder;

public enum BlockFace {
	VOID(0),
	FRONT(1),
	LEFT(2),
	RIGHT(3),
	BACK(4),
	TOP(5),
	BOTTOM(6);
	
	private int face;
	
	BlockFace(int face){
		this.setFace(face);
	}

	public int getFace() {
		return face;
	}

	public void setFace(int face) {
		this.face = face;
	}
}
