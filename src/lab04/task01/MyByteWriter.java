package lab04.task01;

import java.io.*;
import java.nio.file.Path;

public class MyByteWriter {

    BufferedInputStream sourceStream;
    Path targetFile;

    public MyByteWriter(InputStream sourceStream, Path targetFile){
        this.sourceStream = new BufferedInputStream(sourceStream);
        this.targetFile = targetFile;
    }

    public void run() throws IOException{

        byte[] data = new byte[1000];
        int dataLen;

        BufferedOutputStream targetStream = new BufferedOutputStream( new FileOutputStream( targetFile.toFile() ));

        while ( ( dataLen = sourceStream.read(data)) != -1 ){
            targetStream.write(data, 0, dataLen);
        }

        targetStream.flush();
        targetStream.close();
        sourceStream.close();
    }

}
