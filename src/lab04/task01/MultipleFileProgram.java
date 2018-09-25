package lab04.task01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MultipleFileProgram {

    public static void main(String[] args) throws IOException{

        File targetFile = new File("./src/lab04/singleout.txt");

        if ( !targetFile.exists() ){
            targetFile.createNewFile();
        }

        Path sourceFolder = new File("./src/lab04/racuni").toPath();

        MyByteReader mbr = new MyByteReader(new FileOutputStream(targetFile));

        Files.walkFileTree(sourceFolder, mbr);

    }

}
