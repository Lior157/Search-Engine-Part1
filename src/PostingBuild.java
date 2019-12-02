import java.nio.file.Path;

public interface PostingBuild {
    void startBuildingStock(Path folderForFiles , Path CorpusPath );
    void deleteFolderInformation(Path folder);
    String nameOfDictionaryFile();
}
