/***************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                           */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/Binder.txt)   */
/***************************************************************************************************/
package net.BiggerOnTheInside.Binder;

public class Util {
	/* Messages */
	public static String CREATING_PLAYER_OBJECT = Binder.getConfig().getStringFromArray("messages", "CreatingPlayerObject");
	public static String HIDING_MOUSE 			= Binder.getConfig().getStringFromArray("messages", "HidingMouse");
	public static String ENTERING_GAME_LOOP		= Binder.getConfig().getStringFromArray("messages", "EnteringGameLoop");
	public static String LOADING_TEXTURE_PACK	= Binder.getConfig().getStringFromArray("messages", "LoadingTexturePack");
	public static String STARTING_GAME			= Binder.getConfig().getStringFromArray("messages", "StartingGame");
	public static String ERROR_MESSAGE			= Binder.getConfig().getStringFromArray("messages", "ErrorMessage");
	
	/* Configuration Strings. */
	public static String RESOURCE_FOLDER_NAME	= Binder.getConfig().getStringFromArray("config", "ResourcesLocation");
	public static boolean WINDOW_FULLSCREEN 	= Binder.getConfig().getBooleanFromArray("config", "WindowFullscreen");
	public static String DYNAMIC_SPACE			= Binder.getConfig().getStringFromArray("config", "DynamicSpace");
	public static String DYNAMIC_BY				= Binder.getConfig().getStringFromArray("config", "DynamicBy");
	
	/* Game info. */
	public static String GAME_VERSION			= Binder.getConfig().getStringFromArray("game", "Version");
	public static String MADE_BY				= Binder.getConfig().getStringFromArray("game", "MadeBy");
	
	public static String WELCOME = Util.STARTING_GAME + Util.DYNAMIC_SPACE + Util.GAME_VERSION + Util.DYNAMIC_SPACE + Util.DYNAMIC_BY + Util.DYNAMIC_SPACE + Util.MADE_BY;
}
