package net.BiggerOnTheInside.Binder;

public enum EntityType {
	NetherSphere(Byte.parseByte("0")),
	Overworld(Byte.parseByte("1")),
	Realmer(Byte.parseByte("2")),
	OffPlanet(Byte.parseByte("3")),
	Human(Byte.parseByte("4")),
	Living(Byte.parseByte("5"));
	
	private byte type;
	
	EntityType(byte type){
		this.type = type;
	}
	
	public byte getType(){
		return type;
	}
}
