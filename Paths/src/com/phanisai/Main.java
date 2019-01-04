package com.phanisai;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void main(String[] args) {
        try {

//            Copying files .
//            Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

//            Moving files or Directories.
//            Path fileToMove = FileSystems.getDefault().getPath("Examples","Dir1", "file2.txt");
//            Path moveToDestination = FileSystems.getDefault().getPath("Examples","file2.txt");
//            Files.move(fileToMove, moveToDestination);
//            Files.move(moveToDestination, fileToMove);

//            Renaming files or dirs.
//            Path RenameTO = FileSystems.getDefault().getPath("Examples", "file2.txt");
//            Path RenamingFile = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
//            Files.move( RenamingFile,RenameTO);

//            Deleting Files or Dirs.
//            Path deleteFile = FileSystems.getDefault().getPath("Examples", "file2.txt");
//            Files.deleteIfExists(deleteFile);

//            Creating files and Dirs.
//            Path createNew = FileSystems.getDefault().getPath("Examples\\file2.txt");
//            Files.createFile(createNew);

//            Path createNew = FileSystems.getDefault().getPath("Examples\\Dir4");
//            Path createNew = FileSystems.getDefault().getPath("Examples\\Dir1\\Dir4\\Dir5\\Dir6");
//            Files.createDirectories(createNew);


            Path filePath = FileSystems.getDefault().getPath("Examples\\Dir1\\file1.txt");
            BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
            System.out.println("Size = "+attrs.size());
            System.out.println("Last modified = "+attrs.lastAccessTime());
            System.out.println("Created on = "+attrs.creationTime());
            System.out.println("Is it a Dir = "+attrs.isDirectory());
            System.out.println("Is it a file = "+attrs.isRegularFile());


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
//
//        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
//        printFile(path);
//        System.out.println();
//
////        path = FileSystems.getDefault().getPath("files", "SubDirectoryFile.txt");
//        path = Paths.get(".", "files", "SubDirectoryFile.txt");
//        printFile(path);
//        System.out.println();
//
////        path = Paths.get("D:\\Programs\\Java\\OutThereFile.txt");
//        path = Paths.get("D:\\Programs\\Java\\..\\Java\\OutThereFile.txt");
//        System.out.println(path.normalize().toAbsolutePath());
//        printFile(path);
//        System.out.println();
//
//        path = Paths.get(".", "files");
//        System.out.println("Exists : "+Files.exists(path));
    }


//    Prints the content in the file in the path
//    (Which is sent to the method as a parameter)

//    private static void printFile(Path path) {
//        try (BufferedReader reader = Files.newBufferedReader(path)) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
