import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class PictureLoader {

    /**
     * Loads a picture from the picture directory in the resources.
     * @param filename with file extension. Preferable a .png.
     * @return a two-dimensional array of the pixels with the brightness calculated by {@link #getBrightnessOfColor(int)}.
     * @throws IOException when file not found.
     */
    public static double[][] imageToBrightnessArray(String filename) throws IOException {
        final BufferedImage image = ImageIO.read(Objects.requireNonNull(PictureLoader.class.getResource("/pictures/" + filename)));
        double[][] output = new double[image.getHeight()][image.getWidth()];
        for (int x = 0; x < image.getHeight(); x++) {
            for (int y = 0; y < image.getWidth(); y++) {
                output[y][x] = getBrightnessOfColor(image.getRGB(x,y));
            }
        }
        return output;
    }

    /**
     * Calculates the brightness of a pixel in a range from 0.0 to 1.0.
     * @param color an integer pixel in the default RGB color model and default sRGB colorspace.
     * @return the brightness.
     */
    public static double getBrightnessOfColor(int color) {
        final int red = (color >>> 16) & 0xFF;
        final int green = (color >>> 8) & 0xFF;
        final int blue = (color) & 0xFF;
        return (red * 0.2126f + green * 0.7152f + blue * 0.0722f) / 255;
    }
}
