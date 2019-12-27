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
        pf.deleteFolderInformation(Paths.get("D:\\מסמכים\\לימודים\\שנה ג\\איחזור\\fbi10"));
        Path corpus = Paths.get("D:\\מסמכים\\לימודים\\שנה ג\\איחזור\\corpus");
        Path indexPlace = Paths.get("D:\\מסמכים\\לימודים\\שנה ג\\איחזור\\fbi10");

        ///// build indexing
        String[] ans = pf.startBuildingStock(indexPlace , corpus);
        for (String message:
             ans) {
            System.out.println(message);
        }
        ///////=================== remove
      //  pf.deleteFolderInformation(indexPlace);
    }



}
