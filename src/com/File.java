package com;

public class File {
    private String fileName;
    private String filenameExtension;

    public File(String fileName, String filenameExtension) {
        this.fileName = fileName;
        this.filenameExtension = filenameExtension;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilenameExtension() {
        return filenameExtension;
    }

    public void setFilenameExtension(String filenameExtension) {
        this.filenameExtension = filenameExtension;
    }
}
