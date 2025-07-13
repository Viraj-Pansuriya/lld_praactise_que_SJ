package com.example.filesystem.model;

import java.util.List;

public interface FileSystem {

    String getName();
    void ls(int level);
    List<String> ls(String path);
    void ls(String[] components , int level);
}
