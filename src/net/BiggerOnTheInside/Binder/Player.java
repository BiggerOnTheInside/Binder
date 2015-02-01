package net.BiggerOnTheInside.Binder;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

/**
 * @author Walt
 * @since  1/14/15
 * @category Human/Player Control
 */ 
public class Player extends HumanEntity {
    
	private FirstPersonCamera cam;
	
	public Player(String name, float maxLife, float life){
		super(name, maxLife, life, false);
		
		init(name, maxLife, life);
	}
	
	private void init(String name, float maxLife, float life) {
		this.name = name;
		this.maxLife = maxLife;
		this.life = life;
		this.location = new Vector3f(0f, 0f, 0f);
		
		this.cam = new FirstPersonCamera(location.x, location.y, location.z);
		cam.lookThrough();
	}

	@Override
	public boolean isAlive() {
		return this.isAlive;
	}

	@Override
	public boolean isFalling() {
		return this.isFalling;
	}

	@Override
	public float getLife() {
		return this.life;
	}

	@Override
	public float getMaxLife() {
		return this.maxLife;
	}

	@Override
	public Vector3f getLocation() {
		return this.location;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setLife(float a) {
		this.life = a;
	}

	@Override
	protected void setMaxLife(float a) {
		this.maxLife = a;
	}

	@Override
	public void setFalling(boolean a) {
		this.isFalling = a;
	}

	@Override
	public void takeLife(float a) {
		this.setLife(life - a);
	}

	@Override
	public void giveLife(float a) {
		this.setLife(life + a);
	}

	@Override
	public void a() {
		PlayerConstants.DELTA_TIME = Time.getDelta(); //(time - lastTime)/1000.0f;
        //distance in mouse movement from the last getDX() call.
		PlayerConstants.DELTA_X = Mouse.getDX();
        //distance in mouse movement from the last getDY() call.
		PlayerConstants.DELTA_Y = Mouse.getDY();

        //control cam yaw from x movement from the mouse
        cam.yaw(PlayerConstants.DELTA_X * PlayerConstants.MOUSE_SENSITIVITY);
        //control cam pitch from y movement from the mouse
        cam.pitch(-PlayerConstants.DELTA_Y * PlayerConstants.MOUSE_SENSITIVITY);


        //when passing in the distrance to move
        //we times the movementSpeed with dt this is a time scale
        //so if its a slow frame u move more then a fast frame
        //so on a slow computer you move just as fast as on a fast computer
        
        //OVER HERE! What do I do to make the boolean canWalk actually work the right way?
        
        if (Keyboard.isKeyDown(Keyboard.KEY_W))//move forward
        {
            cam.walkForward(PlayerConstants.MOVEMENT_SPEED * PlayerConstants.DELTA_TIME);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_S))//move backwards
        {
            cam.walkBackwards(PlayerConstants.MOVEMENT_SPEED * PlayerConstants.DELTA_TIME);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_A))//strafe left
        {
            cam.strafeLeft(PlayerConstants.MOVEMENT_SPEED * PlayerConstants.DELTA_TIME);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_D))//strafe right
        {
            cam.strafeRight(PlayerConstants.MOVEMENT_SPEED * PlayerConstants.DELTA_TIME);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
        	cam.floatUp(PlayerConstants.MOVEMENT_SPEED * PlayerConstants.DELTA_TIME);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_Z)){
        	cam.floatDown(PlayerConstants.MOVEMENT_SPEED * PlayerConstants.DELTA_TIME);
        }
        //set the modelview matrix back to the identity
        GL11.glLoadIdentity();
        //look through the cam before you draw anything
        cam.lookThrough();
	}

	/**
	 * @deprecated
	 */
	@Override
	public void b() {}
	
	/**
	 * @deprecated
	 */
	@Override
	public void c() {}

	/**
	 * @deprecated
	 */
	@Override
	public void d() {}

	@Override
	public void update() {
		a();
	}
}
