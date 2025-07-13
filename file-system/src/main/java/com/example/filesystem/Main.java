package com.example.filesystem;

import com.example.filesystem.model.Directory;
import com.example.filesystem.model.File;
import com.example.filesystem.model.FileManager;
import com.example.filesystem.model.FileSystem;

public class Main {
    public static void main(String[] args) {

        FileManager fileManager = new FileManager();

        // all path should have been start with main.
        FileSystem movie1 = new File("soley");
        FileSystem movie2 = new File("housefull");
        Directory comedyMovieFolder = new Directory("ComedyMovie");

        FileSystem movie3 = new File("chennai_express");

        comedyMovieFolder.add(movie3 , movie2);

        Directory mainMovieFolder = new Directory("MainMovie");
        mainMovieFolder.add(comedyMovieFolder,movie1);

        fileManager.add(mainMovieFolder);



        fileManager.mkdir("viraj/dsa");
        fileManager.mkdir("viraj/dsa/file1.txt");
        fileManager.ls();
        fileManager.ls("viraj/dsa/file1.txt");
//        fileManager.ls("viraj/dsa/file2.txt");
//        fileManager.mkdir("viraj/dsa/file2.txt");
//        fileManager.ls("viraj/dsa/file2.txt");

//        String path = "/MainMovie/chennai_express";
//        String[] components = path.split("/");
//        mainMovieFolder.ls(components , 0);

    }

}
