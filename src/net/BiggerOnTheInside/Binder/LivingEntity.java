package net.BiggerOnTheInside.Binder;

import org.lwjgl.util.vector.Vector3f;

public abstract class LivingEntity extends Entity{
	protected boolean isAlive;
	protected boolean isFalling;
	protected float maxLife;
	protected float life;
	protected Vector3f location;
	
	public LivingEntity(String a, float b, float c, boolean d){
		super(a);
	}
	
	public abstract boolean isAlive();
	public abstract boolean isFalling();
	public abstract float getLife();
	public abstract float getMaxLife();
	public abstract Vector3f getLocation();
	public abstract String getName();
	protected abstract void setLife(float a);
	protected abstract void setMaxLife(float a);
	protected abstract void setFalling(boolean a);
	public abstract void takeLife(float a);
	public abstract void giveLife(float a);
	public abstract void update();
}
