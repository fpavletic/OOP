package lab04.task01;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class MyByteReader implements FileVisitor<Path> {

    BufferedOutputStream targetStream;

    public MyByteReader(OutputStream targetStream){
        this.targetStream = new BufferedOutputStream(targetStream);
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException{
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{
        if ( !getExtension(file).equals("txt") ){
            return FileVisitResult.CONTINUE;
        }

        BufferedInputStream fileStream = new BufferedInputStream(new FileInputStream(file.toFile()));
        byte[] data = new byte[1000];
        int dataLen;
        while ( (dataLen = fileStream.read(data)) != -1 ){
            targetStream.write(data, 0, dataLen);
        }
        fileStream.close();
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException{
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException{
        return FileVisitResult.CONTINUE;
    }

    private static String getExtension ( Path file ){
        String filename = file.getFileName().toString();
        int dotIndex = filename.lastIndexOf('.');
        return dotIndex == -1 ? "" : filename.substring(dotIndex + 1);
    }
}
