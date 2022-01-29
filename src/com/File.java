package com;

public class File implements Element{
    private String name;

    public File(String fileName) {
        this.name = fileName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void createElement() {
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                '}';
    }
}
