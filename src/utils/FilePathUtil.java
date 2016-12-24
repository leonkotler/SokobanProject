package utils;

/* FilePathUtil provides method for working with file paths */

public class FilePathUtil {

    public String getExtension(String filePath){

        String ext;
        // getting the substring after the last dot
        int i = filePath.lastIndexOf(".");
        if (i>=0) {
            ext = filePath.substring(i + 1);
            return ext;
        } else
            return null;
    }
}
