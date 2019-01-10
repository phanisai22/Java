package com.phanisai;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {

        Path directory = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
//        Path directory = FileSystems.getDefault().getPath("FileTree\\Dir2");


//        Filtered expression to print only the regular files.

//        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
//            @Override
//            public boolean accept(Path entry) throws IOException {
//                return (Files.isRegularFile(entry));
//            }
//        };

//        Using lambda expression.
        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);

        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) {

            for (Path fileName : contents) {
                System.out.println(fileName.getFileName());
            }

        } catch (IOException | DirectoryIteratorException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- walking tree for Dir2---");
        Path dir2File = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
        try {
            Files.walkFileTree(dir2File, new TraverseFiles());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("---copying file Dir2 to Dir4\\Dir2Copy---");
        Path copyPath = FileSystems.getDefault().getPath("FileTree"
                + File.separator + "Dir4" + File.separator + "Dir2Copy");

        try {
            Files.walkFileTree(dir2File, new CopyFiles(dir2File, copyPath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}