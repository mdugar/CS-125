//UIUC CS125 SPRING 2016 MP. File: RGBUtilities.java, CS125 Project: Challenge4-Photoscoop, Version: 2016-02-22T08:07:56-0600.345149194
/* Manipulates RGB values
 * 
 * Todo: Put your netid (i.e. username) in the line below
 * 
 * @author ywang443
 */

public class RGBUtilities {

/**
 * Extracts the red component (0..255)
 * Hint: see ch13.1.2 Working With Pixels 
 * http://math.hws.edu/javanotes/c13/s1.html#GUI2.1.2
 * 
 * ... also see the notes in READ-ME-FIRST
 * 
 * @param rgb the encoded color int
 * @return the red component (0..255)
 */
	public static int toRed(int rgb) {
		return (rgb >> 16) & 0xFF; // FIX ME
	}

	public static int toGreen(int rgb) {
		return (rgb >> 8) & 0xFF; // FIX THIS
	}

	public static int toBlue(int rgb) {
		return rgb & 0xFF; // FIX THIS
	}

	/**
	 * 
	 * @param r the red component (0..255)
	 * @param g the green component (0..255)
	 * @param b the blue component (0..255)
	 * @return a single integer representation the rgb color (8 bits per component) rrggbb
	 */
	static int toRGB(int r, int g, int b) {
		
		return (r << 16) | (g << 8) | b; // FIX THIS
	}

}
