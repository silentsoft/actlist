package org.silentsoft.actlist.util;

import java.awt.event.InputEvent;

import org.silentsoft.actlist.ActlistConfig;
import org.silentsoft.actlist.BizConst;
import org.silentsoft.core.util.SystemUtil;
import org.silentsoft.io.memory.SharedMemory;

public class ConfigUtil {

	public static ActlistConfig getActlistConfig() {
		return (ActlistConfig) SharedMemory.getDataMap().get(BizConst.KEY_ACTLIST_CONFIG);
	}
	
	public static double getRootWidth() {
		Object rootWidth = getActlistConfig().get("rootWidth");
		if (rootWidth instanceof Integer) {
			return ((int) rootWidth) + 0.0;
		}
		return ((double) rootWidth);
	}
	
	public static void setRootWidth(double width) throws Exception {
		getActlistConfig().put("rootWidth", width);
	}
	
	public static double getRootHeight() {
		Object rootHeight = getActlistConfig().get("rootHeight");
		if (rootHeight instanceof Integer) {
			return ((int) rootHeight) + 0.0;
		}
		return ((double) rootHeight);
	}
	
	public static void setRootHeight(double height) throws Exception {
		getActlistConfig().put("rootHeight", height);
	}
	
	public static double getStageWidth() {
		Object stageWidth = getActlistConfig().get("stageWidth");
		if (stageWidth instanceof Integer) {
			return ((int) stageWidth) + 0.0;
		}
		return ((double) stageWidth);
	}
	
	public static void setStageWidth(double width) throws Exception {
		getActlistConfig().put("stageWidth", width);
	}
	
	public static double getStageHeight() {
		Object stageHeight = getActlistConfig().get("stageHeight");
		if (stageHeight instanceof Integer) {
			return ((int) stageHeight) + 0.0;
		}
		return ((double) stageHeight);
	}
	
	public static void setStageHeight(double height) throws Exception {
		getActlistConfig().put("stageHeight", height);
	}
	
	public static double getStageOpacity() {
		Object stageOpacity = getActlistConfig().get("stageOpacity");
		if (stageOpacity instanceof Integer) {
			return ((int) stageOpacity) + 0.0;
		}
		return ((double) stageOpacity);
	}
	
	public static void setStageOpacity(double opacity) throws Exception {
		getActlistConfig().put("stageOpacity", opacity);
	}
	
	public static boolean isAlwaysOnTop() {
		return (boolean) getActlistConfig().get("alwaysOnTop");
	}
	
	public static void setAlwaysOnTop(boolean value) throws Exception {
		getActlistConfig().put("alwaysOnTop", value);
	}
	
	public static boolean isAnimationEffect() {
		return (boolean) getActlistConfig().get("animationEffect");
	}
	
	public static void setAnimationEffect(boolean value) throws Exception {
		getActlistConfig().put("animationEffect", value);
	}
	
	public static int getShowHideActlistHotKeyModifier() {
		return (int) getActlistConfig().get("showHideActlistHotKeyModifier");
	}
	
	public static void setShowHideActlistHotKeyModifier(int modifier) throws Exception {
		getActlistConfig().put("showHideActlistHotKeyModifier", modifier);
	}
	
	public static int getShowHideActlistHotKeyCode() {
		return (int) getActlistConfig().get("showHideActlistHotKeyCode");
	}
	
	public static void setShowHideActlistHotKeyCode(int code) throws Exception {
		getActlistConfig().put("showHideActlistHotKeyCode", code);
	}
	
	public static String getShowHideActlistHotKeyText() {
		String hotKeyText = "";
		
		int modifier = getShowHideActlistHotKeyModifier();
		if ((modifier & InputEvent.CTRL_DOWN_MASK) == InputEvent.CTRL_DOWN_MASK) {
			hotKeyText = hotKeyText.concat("Ctrl + ");
		}
		if ((modifier & InputEvent.ALT_DOWN_MASK) == InputEvent.ALT_DOWN_MASK) {
			hotKeyText = hotKeyText.concat("Alt + ");
		}
		if ((modifier & InputEvent.SHIFT_DOWN_MASK) == InputEvent.SHIFT_DOWN_MASK) {
			hotKeyText = hotKeyText.concat("Shift + ");
		}
		if ((modifier & InputEvent.META_DOWN_MASK) == InputEvent.META_DOWN_MASK) {
			if (SystemUtil.isWindows()) {
				hotKeyText = hotKeyText.concat("Win + ");
			} else if (SystemUtil.isMac()) {
				hotKeyText = hotKeyText.concat("Cmd + ");
			} else {
				hotKeyText = hotKeyText.concat("Meta + ");
			}
		}
		
		return hotKeyText.concat(String.valueOf((char) getShowHideActlistHotKeyCode()));
	}
	
}
