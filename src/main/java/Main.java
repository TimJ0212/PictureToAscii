import java.io.IOException;

public class Main {
    public static void main(String... args) throws IOException {
        final char[][] c = AsciiConverter.imageToAscii("picture1.png");
        OutputFileSaver.saveChar2DArrayToFile(c, "output1");
    }
}
