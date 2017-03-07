package lapj.activity5.edu;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by luispo on 3/6/17.
 */
public class LoadFileDessert extends FileFooReader {

    private String fileTXT;

    public LoadFileDessert(String fileTXT) {
        this.fileTXT = fileTXT;
    }

    public ArrayList<String> getFileDessert() throws IOException{
        fileTXT = this.fileTXT;
        FileFooReader fileFooReader = new FileFooReader();
        ArrayList<String> allLines = fileFooReader.FileLoader(fileTXT);

        return allLines;

    }
}
