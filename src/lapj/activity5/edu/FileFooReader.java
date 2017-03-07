package lapj.activity5.edu;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by luispo on 3/6/17.
 */
public class FileFooReader implements FileLoaderTXT {


    @Override
    public ArrayList<String> FileLoader(String fileTXT) throws IOException{

        ArrayList<String> fileLines = new ArrayList<>();
        BufferedReader input = null;
        String line;
        try {
            input = new BufferedReader(new FileReader(fileTXT));

            while ((line = input.readLine()) != null) {
                    fileLines.add(line.trim());
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(input !=null) {
                    input.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }



        return fileLines;
    }
}
