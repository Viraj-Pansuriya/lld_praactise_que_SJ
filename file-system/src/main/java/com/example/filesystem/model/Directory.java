package com.example.filesystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Directory implements FileSystem{
    private String name;
    private List<FileSystem> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void add(FileSystem ... fileSystem) {
        children.addAll(Arrays.stream(fileSystem).toList());
    }
    @Override
    public void ls(int level) {
        System.out.println("  ".repeat(level) + "Directory: " + name);
        for (FileSystem fileSystem : children) {
            fileSystem.ls(level + 1);
        }
    }

    @Override
    public List<String> ls(String path) {
        return List.of();
    }

    @Override
    public void ls(String[] components, int level) {

        boolean isFile = components[level].contains(".");
        FileSystem fileSystem = null;
        for(FileSystem fs : children){
            if(fs.getName().equals(components[level])){
                fileSystem = fs;
                break;
            }
        }
        if(fileSystem == null){
            System.out.println("ERROR : No Such File OR Directory found for a given path");
            return ;
        }
        if(isFile && (level != components.length - 1)){
            System.out.println("ERROR : Invalid path , path can not contains more than one file");
            return ;
        }

        if(isFile){
            System.out.println("Executing a LS command");
            generateFilePath(components);
            return;
        }
        if(level == (components.length - 1)){
            System.out.println("Executing a LS command");
            for(FileSystem fs : ((Directory)fileSystem).getChildren()){
                System.out.println(fs.getName());
            }
            return ;
        }
        fileSystem.ls(components , level + 1);
    }

    private void generateFilePath(String[] components) {
        StringBuilder sb = new StringBuilder();
        for(String cmp : components){
            sb.append("/");
            sb.append(cmp);
        }
        System.out.println(sb.toString());
    }

    public void mkdir(String[] components, int level) {
        if(level == components.length){
            System.out.println("directory have been created");
            return ;
        }
        String name = components[level];
        FileSystem fileSystem = null;
        for(FileSystem fs : children) {
            if(fs.getName().equals(name)){
                fileSystem = fs;
                break;
            }
        }
        boolean isFile = name.contains(".");
        boolean isCreated = (fileSystem == null);
        if(fileSystem == null){
            if(isFile) fileSystem = new File(name);
            else fileSystem = new Directory(name);
        }
        if(isCreated)
            this.children.add(fileSystem);

        if(!isFile)
           ((Directory) fileSystem).mkdir(components, level + 1);
    }
}
