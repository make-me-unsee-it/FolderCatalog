package com.melarossa.hryshkin.models;

import com.melarossa.hryshkin.utils.InputUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class Folder {
    private int folderLevel;
    private String folderName;
    private ArrayList<Folder> innerFolders;
    private ArrayList<String> innerFiles;

    public Folder(int folderLevel, String folderName) {
        this.folderLevel = folderLevel;
        this.folderName = folderName;
        this.innerFolders = new ArrayList<>();
        this.innerFiles = new ArrayList<>();
    }

    public int getFolderLevel() {
        return folderLevel;
    }

    public void setFolderLevel(int folderLevel) {
        this.folderLevel = folderLevel;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public ArrayList<Folder> getInnerFolders() {
        return innerFolders;
    }

    public void setInnerFolders(ArrayList<Folder> innerFolders) {
        this.innerFolders = innerFolders;
    }

    public ArrayList<String> getInnerFiles() {
        return innerFiles;
    }

    public void setInnerFiles(ArrayList<String> innerFiles) {
        this.innerFiles = innerFiles;
    }

    public Folder folderUpdate(Folder folder, int topFolderLevel, String[] command) {
        if (command.length == topFolderLevel + 1) {
            if (InputUtils.isFileCheck(command[topFolderLevel])) {
                String createdFile = command[topFolderLevel];
                ArrayList<String> currentFolderFileList = folder.getInnerFiles();
                boolean fileConsistCheck = false;

                for (String currentFileName : currentFolderFileList) {
                    if (currentFileName.equals(createdFile)) {
                        fileConsistCheck = true;
                        break;
                    }
                }

                if (!fileConsistCheck) {
                    currentFolderFileList.add(createdFile);
                    Collections.sort(currentFolderFileList);
                    folder.setInnerFiles(currentFolderFileList);
                }
                return folder;
            }
        }

        if (topFolderLevel < command.length) {
            String createdFolder = command[topFolderLevel];
            ArrayList<Folder> listOfInnerFolders = folder.getInnerFolders();
            int forEachIndex = 0;
            boolean folderConsistCheck = false;
            String currentFolderName;

            for (Folder currentFolder : listOfInnerFolders) {
                currentFolderName = currentFolder.getFolderName();
                if (currentFolderName.equals(createdFolder)) {
                    folderConsistCheck = true;
                    if (topFolderLevel < command.length) {
                        currentFolder = currentFolder.folderUpdate(currentFolder, topFolderLevel + 1, command);
                    }
                    listOfInnerFolders.set(forEachIndex, currentFolder);
                }
                forEachIndex++;
            }

            if (!folderConsistCheck) {
                Folder newFolder = new Folder(topFolderLevel + 1, createdFolder);
                if (topFolderLevel < command.length) {
                    newFolder = newFolder.folderUpdate(newFolder, topFolderLevel + 1, command);
                }
                listOfInnerFolders.add(newFolder);
                listOfInnerFolders.sort(Comparator.comparing(Folder::getFolderName));
            }
            folder.setInnerFolders(listOfInnerFolders);
        }
        return folder;
    }

    public StringBuilder printFolder(Folder folder) {
        StringBuilder folderContent = new StringBuilder();
        if (folder.getInnerFolders() != null) {
            for (Folder innerFolder : folder.getInnerFolders()) {
                int innerFolderLevel = innerFolder.getFolderLevel() - 1;
                for (int i = 0; i < innerFolderLevel; i++) {
                    if (i < innerFolderLevel - 1) folderContent.append("       ");
                    if (i == innerFolderLevel - 1) folderContent.append("└──────");
                }
                folderContent.append(innerFolder.getFolderName()).append("\n");
                folderContent.append(innerFolder.printFolder(innerFolder));
            }
        }
        if (folder.getInnerFiles() != null) {
            int innerFileLevel = folder.getFolderLevel() - 1;
            for (String innerFile : folder.getInnerFiles()) {
                for (int i = 0; i <= innerFileLevel; i++) {
                    if (i < innerFileLevel) folderContent.append("       ");
                    if (i == innerFileLevel) folderContent.append("└──────");
                }
                folderContent.append(innerFile).append("\n");
            }
        }
        return folderContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Folder folder)) return false;
        return folderLevel == folder.folderLevel && Objects.equals(folderName, folder.folderName) && Objects.equals(innerFolders, folder.innerFolders) && Objects.equals(innerFiles, folder.innerFiles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(folderLevel, folderName, innerFolders, innerFiles);
    }

    @Override
    public String toString() {
        return "Folder{" +
                "folderLevel=" + folderLevel +
                ", folderName='" + folderName + '\'' +
                ", innerFolders=" + innerFolders +
                ", innerFiles=" + innerFiles +
                '}';
    }
}
