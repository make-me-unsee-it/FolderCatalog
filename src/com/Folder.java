package com;

public class Folder {
    private String folderName;

    public Folder (){
        this.folderName = "Новая папка";
    }

    public Folder (String name) {
        this.folderName = name;
    }

    public String getName() {
        return folderName;
    }

    public void setName(String name) {
        this.folderName = name;
    }
}
