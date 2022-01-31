package com;

public class Demo {
    public static void main(String[] args) throws RewriteException {
        FileSystem fileSystem = new FileSystem();
        fileSystem.elementAdd("root/folder1/folder1-1/file.txt");
        fileSystem.elementAdd("root/folder1/list.txt");
        fileSystem.elementAdd("root2/folder3");
        System.out.println(fileSystem);

    }
}
