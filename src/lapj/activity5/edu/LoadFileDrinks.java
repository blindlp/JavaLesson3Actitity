package lapj.activity5.edu;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by luispo on 3/6/17.
 */
public class LoadFileDrinks extends FileFooReader {

    private String fileTXT;

    public LoadFileDrinks(String fileTXT) {
        this.fileTXT = fileTXT;
    }



    public ArrayList<String> getFileDrinks() throws IOException {
        fileTXT = this.fileTXT;
        FileFooReader fileFooReader = new FileFooReader();
        ArrayList<String> allLines = fileFooReader.FileLoader(fileTXT);

        return allLines;
    }
}
