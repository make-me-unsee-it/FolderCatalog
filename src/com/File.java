package com;

import java.util.HashMap;

public class File implements Element{
    private final String name;

    public File(String fileName) {
        this.name = fileName;
    }

    public String getName() {
        return name;
    }

    @Override
    public Element createElement(String[] elements, int n, Element oldStorage) {
        return null;
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public HashMap<String, Element> getStorage() {
        return null;
    }
}
