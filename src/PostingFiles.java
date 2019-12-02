import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PostingFiles implements PostingBuild{

    private final String withStemmimgFolderName="withStem";
    private final String withoutStemmimgFolderName="withoutStem";
    private final String dictionaryFileName =" AllDictionary.txt";
    public void startBuildingStock(Path folderForFiles , Path CorpusPath ){
        //------------------------------------------- withStemming
        Parse.TurnOnStem();
        ReadFile.initialazleVariable();
        Indexer.initialazleVariable();
        Path withStem = Paths.get(folderForFiles.toString()+"\\"+withStemmimgFolderName);
        buildInvertedFiles(withStem ,  CorpusPath);
        //-------------------------------------------- withoutStemming
        Parse.TurnOffStem();
        ReadFile.initialazleVariable();
        Indexer.initialazleVariable();
        Path withOutStem = Paths.get(folderForFiles.toString()+"\\"+withoutStemmimgFolderName);
        buildInvertedFiles(withOutStem ,  CorpusPath);
    }
    private void buildInvertedFiles(Path folderForFiles , Path CorpusPath){
        File folder = new File(CorpusPath.toString());
        Path p = folderForFiles;

        long start = System.currentTimeMillis();
////        ReadFile rf = new ReadFile(p ,folder);
////        rf.run();
////
        int cores = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[cores];
        System.out.println(cores);
        for(int i=0 ; i< threads.length ;i++) {
            threads[i] = new Thread(new ReadFile(p ,folder));
            threads[i].start();
        }
        try {
            for (int i = 0; i < threads.length; i++) {
                threads[i].join();
            }
        }catch (Exception e) {
        }
        File TemporaryFiles = new File(folderForFiles.toString()+"\\TemporaryFiles");
        File Docs_Information = new File(folderForFiles.toString()+"\\@Docs_Information.txt");
        Path PostingFiles = Paths.get(folderForFiles.toString()+"PostingFiles");
        Path AllDictionary = Paths.get(folderForFiles.toString()+dictionaryFileName);
       // Path po = folderForFiles
        Indexer.MergeTemporaryFile( TemporaryFiles,PostingFiles,Docs_Information,folderForFiles, AllDictionary);
////
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
    public void deleteFolderInformation(Path folder){
        ReadFile.deleteDirectory(new File(folder.toString()));
    }
    public String nameOfDictionaryFile(){
        return dictionaryFileName;
    }
}
