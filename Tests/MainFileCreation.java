import java.io.File;
import java.io.FileReader;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Timestamp;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.*;

public class MainFileCreation {

    public static void main(String[] args) {
        PostingBuild pf = new PostingFiles();
        Path corpus = Paths.get("C:\\Users\\Aviel\\IdeaProjects\\IR2\\corpus");
        Path indexPlace = Paths.get("C:\\Users\\Aviel\\IdeaProjects\\IR2\\here");

        ///// build indexing
        pf.startBuildingStock(indexPlace , corpus);

        ///////=================== remove
        pf.deleteFolderInformation(indexPlace);
    }



}
