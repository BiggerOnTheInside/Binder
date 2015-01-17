/***************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                           */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/Binder.txt)   */
/***************************************************************************************************/

package net.BiggerOnTheInside.Binder;

import static org.lwjgl.opengl.GL11.GL_CULL_FACE;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;

import java.awt.Font;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.Texture;

/**
 * This is the main class for Binder. It all starts from here, rendering, updating, etc.
 * 
 * @author Walt Pach
 * @version 0.0.1
 * @since 1/11/15
 */
//@SuppressWarnings("unused")
public class Binder {
	
	/* This is the chunk size for each chunk, in blocks. */
	public static final int CHUNK_SIZE = 4;
	
	/* This is the wideltah, length, and height of each cube, in world units. */
	public static final float CUBE_WIDTH = 2f;

	/* This is the mouse sensitivity measurement, used to calculate the speed of the first person
	 * viewing movement.
	 */
    public static final float MOUSE_SENSITIVITY = 0.05f;
    
    /* This is the speed at which the player moves a second, in world units. */
    public static final float MOVEMENT_SPEED = 10.0f;
    
    /* This is the logger object for Binder. */
	public static final Logger log = Logger.getLogger("Binder");

	private static final int WINDOW_Y = 480;

	private static final int WINDOW_X = 680;

	/* This is the cam object for the current player, controlled through this class only. */
	public static Player player;
	
	/* This is the boolean that we use to create a full screen window or not. */
	public static boolean WINDOW_FULLSCREEN = false;
	
	/* This is the string object we use to title the window. */
	public static String WINDOW_NAME = "Binder 0.0.1";
	
	/* This is the display mode that is used for the game window. */
	private DisplayMode displayMode;

	private TexturePackLoader texturePackLoader;
	
	private static JSONManager configManager;
	
	private TrueTypeFont font;
	public static Font defaultFont = new Font("Times New Roman", Font.BOLD, 24);
	
	/**
	 * <p>Basically just starts the game, creates the cam, grabbes the mouse, and calls some methods.</p>
	 */
	public void Start() {
		/* This try-catch loop will catch any exceptions caused by the lwjgl init, window creation, and game loop. */
		try {
			CreateWindow();
			InitGL();
			Run();
		} catch (Exception e) {
			log.severe(Util.ERROR_MESSAGE + " Generated from Start() method.");
			e.printStackTrace();
			Display.destroy();
		}
	}

	/**
	 * @throws LWJGLException Throws the LWJGLException if error happens during display mode scan.
	 */
	private void CreateWindow() throws LWJGLException{		
		/* Set the display to be the value of the full screen constant (see top). */
		Display.setFullscreen(Util.WINDOW_FULLSCREEN);
		
		/* Create a DisplayMode array object, containing all the possible display modes. */
		DisplayMode d[] = Display.getAvailableDisplayModes();
		
		/* Loop through all the display modes. */
		for (int i = 0; i < d.length; i++) {
			/* Is the display mode ideal? */
			if (d[i].getWidth() == 640 && d[i].getHeight() == 480 && d[i].getBitsPerPixel() == 32) {
				/* Set the display mode to the loop-display-mode. */
				displayMode = d[i];
				
				/* Lets get out of the loop. */
				break;
			}
		}
		
		/* Set the display mode of the display to our DisplayMode object. */
		Display.setDisplayMode(displayMode);
		
		/* Set the title of the display window (if not full screen) to our WINDOW_NAME constant (see top). */
		Display.setTitle(WINDOW_NAME);
		
		/* Go ahead and create the display window.  */
		Display.create();
	}

	/* Initializes OpenGL. */
	private void InitGL() {
		/* Enable 2D texturing. */
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		
		/* Set the shade model to smooth. */
		GL11.glShadeModel(GL11.GL_SMOOTH);
        
        /* Set the OpenGL clear color to clear. */
		//GL11.glClearColor(.9f, 1.0f, 1.0f, 0.0f);
        
        /* Set the OpenGL clear color depth to 1 (full) */
		GL11.glClearDepth(1.0); 
        
        /* Enable OpenGL depth test. */
		//GL11.glEnable(GL_DEPTH_TEST);
        
        /* Enable OpenGL face culling. */
		GL11.glEnable(GL_CULL_FACE);
        
        /* Add the back face as a culled face. */
		GL11.glCullFace(GL11.GL_BACK);
        
        /* Set the OpenGL depth function to lequal. */
      //  GL11.glDepthFunc(GL11.GL_LEQUAL); 

        /* Set the OpenGL matrix mode to projection. */
        GL11.glMatrixMode(GL11.GL_PROJECTION); 
        
        GL11.glClearColor(.9f, 1f, 1f, 0.0f);
        /* Load the OpenGL identity. */
        GL11.glLoadIdentity();

        /* Set the perspective of our game, with the center of the window as the eye-level */
        GLU.gluPerspective(45.0f,(float)displayMode.getWidth()/(float)displayMode.getHeight(),0.1f,100.0f);

        /* Reset the OpenGL matrix mode to model-view. */
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        
        /* Set the OpenGL hint to perspective correction hint, and make the textures as nice as possible. */
        GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST);
	}
	
	/**
	 * <p>Starts the game, called from Start(). </p>
	 */
	private void Run(){
		// Alert user of current action.
		log.info(Util.LOADING_TEXTURE_PACK);
		
		// Load the texture pack, at location stored in JSON file, and auto bind it. See the jsonManager object for more info on configuration.
		texturePackLoader = new TexturePackLoader("sheets/terrain.png", true);
		
		// Tell log what we are doing to their game!
        log.info(Util.CREATING_PLAYER_OBJECT);
        
        // Create a new Player object, with full life.
        player = new Player("Kirk", 100, 100);
         
        // Catch that mouse with your new trap!
        log.info(Util.HIDING_MOUSE);
        
        font = new TrueTypeFont(defaultFont, true);
        
        // Hide the mouse.
        Mouse.setGrabbed(true);

        log.info(Util.ENTERING_GAME_LOOP);
		while (!Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			RenderForeground();
	        Render();
	        Display.update();
	        Display.sync(30);
	        
			try {
				update();
			        
	            if (Display.isCloseRequested()) {
	            		break;
	                }
	            if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
	            {
	                Sys.alert("Close","To continue, press ESCAPE on your keyboard or OK on the screen.");
	                System.exit(0);
	                 
	            }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Display.destroy();

	}
	
	/**
	 * @category Renderer
	 * <p>This is the main render method, it clears the screen, calls the world renderer function, which renders all the visible chunks.</p>
	 */
	private void Render() {
		DimensionSwitcher.setOrphoOff(displayMode.getWidth(), displayMode.getHeight());
		BlockRenderer.renderBlock(Block.DIRT, 0f, 0f, 0f);
	}

	private void Clear(){
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		GL11.glClearColor(.9f, 1f, 1f, 0f);
	}
	
	private void RenderForeground(){
		DimensionSwitcher.setOrphoOn(displayMode.getWidth(), displayMode.getHeight());
		TextRenderer.drawString("testy test", 100, 200);
	}
	
	/**
	 * <p>Updates player object.</p>
	 */
	public void update(){
		 player.update();
	}
	
	/**
	 * @return Player object currently in use.
	 */
	public static Player getPlayerObject() {
		return player;
	}
	
	public static JSONManager getConfig(){
		return configManager;
	}
	
	/**
	 * @param args
	 * @throws LWJGLException
	 * <p>Creates log object, and starts the game.</p>
	 */
	public static void main(String[] args) throws LWJGLException {
		log.setUseParentHandlers(false);
		
		BinderFormatter formatter = new BinderFormatter();
		ConsoleHandler handler = new ConsoleHandler();
		
		handler.setFormatter(formatter);
		log.addHandler(handler);
		
		configManager = new JSONManager(System.getProperty("user.home") + "/Binder.json");
		
		log.info(Util.WELCOME);
		Binder r = new Binder();
		r.Start();
	}
}