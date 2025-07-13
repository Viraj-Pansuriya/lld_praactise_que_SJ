package com.example.filesystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class File implements FileSystem{

    private String name;

    @Override
    public void ls(int level) {
        System.out.println("  ".repeat(level) + "File: " + name);
    }

    @Override
    public List<String> ls(String path) {
        return List.of();
    }

    @Override
    public void ls(String[] components, int level) {

    }
}
