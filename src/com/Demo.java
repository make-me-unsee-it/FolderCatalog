package com;

public class Demo {
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        fileSystem.elementAdd("root/folder1/file");
        System.out.println(fileSystem.toString());

    }
}
