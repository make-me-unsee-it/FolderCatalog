package com.melarossa.hryshkin.models;

import com.melarossa.hryshkin.utils.InputUtils;

import java.util.Objects;

public class FileSystem {

    private static FileSystem instance;

    private Folder rootFolder;

    private FileSystem() {
        this.rootFolder = new Folder(0, "...");
    }

    public Folder getRootFolder() {
        return rootFolder;
    }

    public void setRootFolder(Folder rootFolder) {
        this.rootFolder = rootFolder;
    }

    public static FileSystem getInstance() {
        if (instance == null) instance = new FileSystem();
        return instance;
    }

    public void print() {
        System.out.println("FILE SYSTEM STRUCTURE: \n" + rootFolder.printFolder(rootFolder).toString());
    }

    public void createEntity(String entity) {
        String[] rootSequence = InputUtils.commandToRootSequence(entity);
        if (rootSequence.length != 0) {
            setRootFolder(rootFolder.folderUpdate(rootFolder, 0, rootSequence));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FileSystem that)) return false;
        return Objects.equals(rootFolder, that.rootFolder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rootFolder);
    }

    @Override
    public String toString() {
        return "FILE SYSTEM STRUCTURE: \n" + rootFolder.printFolder(rootFolder).toString();
    }
}
