package com.example.filesystem.model;

public class FileManager {

    private final Directory root;
    public FileManager() {
        this.root = new Directory("main");
    }

    public void ls(){
        root.ls(0);
    }

    public void ls(String path){
        root.ls(path.split("/") , 0);
    }

    // path should contains "/" , and should be in a valid form.
    public void mkdir(String path){
        root.mkdir(path.split("/") , 0);
    }

    public void add(FileSystem fileSystem){
        root.add(fileSystem);
    }
}
