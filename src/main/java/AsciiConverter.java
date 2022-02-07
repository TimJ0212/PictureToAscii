import java.io.IOException;
import java.util.Collections;

public class AsciiConverter {

    private final static char[] SORTED_ASCII_CHARACTER = " .'`^\",:;Il!i><~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$".toCharArray();

    /**
     * Converts an image to an ascii representation.
     * TODO: Currently the output is a little bit stretched. Feel free to fix this issue and open a PR.
     * @param filename with file extension. Preferable a .png.
     * @return An Ascii reprensation of the picture.
     * @throws IOException when file not found.
     */
    public static char[][] imageToAscii(String filename) throws IOException {
        final double[][] brightnessArray = PictureLoader.imageToBrightnessArray(filename);
        final int quantityOfAsciiCharacter = SORTED_ASCII_CHARACTER.length;
        char[][] output = new char[brightnessArray.length][brightnessArray[0].length];
        for (int i = 0; i < brightnessArray.length; i++) {
            for (int j = 0; j < brightnessArray[0].length; j++) {
                // max() because if the min brightness is 0, then we would want the brightest color.
                char ch = SORTED_ASCII_CHARACTER[Math.max((int) (brightnessArray[i][j]*quantityOfAsciiCharacter) -1, 0)];
                output[i][j] = ch;
            }
        }
        return output;
    }
}
