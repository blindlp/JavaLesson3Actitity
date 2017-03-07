package lapj.activity5.edu;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by luispo on 3/6/17.
 */
public class LoadFileMainDish extends FileFooReader{
    private String fileTXT;

    public LoadFileMainDish(String fileTXT) {
        this.fileTXT = fileTXT;
    }

    public ArrayList<String> getFileMainDish() throws IOException {

        FileFooReader fileFooReader = new FileFooReader();
        ArrayList<String> allLines = fileFooReader.FileLoader(fileTXT);

        return allLines;
    }

}
