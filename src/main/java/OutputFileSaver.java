import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class OutputFileSaver {

    /**
     * Saves a two-dimensional char array to a file. <br>
     * The file normally get saved in the target directory.
     * @param c is the two-dimensional char array.
     * @param filename without the file extension.
     * @throws IOException when file could not be created.
     */
    public static void saveChar2DArrayToFile(char[][] c, String filename) throws IOException {
        final Path output = Paths.get(Objects.requireNonNull(OutputFileSaver.class.getResource("/")).getPath() +  "/output/");
        Files.createDirectories(output);
        final File file = new File(output.toAbsolutePath() + "/" + filename + ".txt");
        final FileWriter fileWriter = new FileWriter(file);
        final StringBuilder stringBuilder = new StringBuilder();
        for (char[] a: c) {
            stringBuilder.append("\n");
            for(char b: a) {
                stringBuilder.append(b);
            }
        }
        fileWriter.write(stringBuilder.toString());
        fileWriter.close();
    }
}
