package com;

public class Demo {
    public static void main(String[] args) throws RewriteException {
        FileSystem fileSystem = new FileSystem();
        fileSystem.elementAdd("root/folder1/file.txt");
        fileSystem.elementAdd("root2/folder2/list.txt");
        fileSystem.elementAdd("root2/folder3/list.txt");
        System.out.println(fileSystem);

    }
}
