import java.nio.file.Path;

/**
 * This interface exists for building the dictionary and the Posting files in the given paths and also clean all the data if the user wants
 */
public interface PostingBuild {
    void startBuildingStock(Path folderForFiles , Path CorpusPath );
    void deleteFolderInformation(Path folder);
    String nameOfDictionaryFile();
}
