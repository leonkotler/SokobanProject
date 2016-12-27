package utils;

/* FilePathUtil provides method for working with file paths */

import java.io.FileNotFoundException;

public class FilePathUtil {

    public String getExtension(String filePath) throws FileNotFoundException{

        if (filePath==null)
            throw new FileNotFoundException("No file name provided");
        String ext;
        // getting the substring after the last dot
        int i = filePath.lastIndexOf(".");
        if (i>=0) {
            ext = filePath.substring(i + 1);
            return ext;
        } else
            return null;
    }

    public String getFileNameFromPath(String filePath) throws FileNotFoundException{

        if (filePath==null)
            throw new FileNotFoundException("No file name provided");

        String fileName;
        int i = filePath.lastIndexOf("\\");
        if (i>=0) {
            fileName = filePath.substring(i + 1);
            return fileName;
        } else
            return null;
    }
}
