package com;

import java.util.HashMap;

public class FileSystem {
    private HashMap<String, Element> storage;

    public FileSystem() {
        storage = new HashMap<>();
    }

    public HashMap<String, Element> getStorage() {
        return storage;
    }

    public void elementAdd(String elementPath) {
        String[] allPathElements = ElementCounter.count(elementPath);
        storage = createElement(allPathElements, storage);
    }

    protected HashMap<String, Element> createElement(String[] elements, HashMap<String, Element> storage) {
        int n = 0;
        if ((!storage.containsKey(elements[n]) & (n != elements.length - 1))) {
            storage.put(elements[n], new Folder(elements, n + 1));
        } else if ((storage.containsKey(elements[n]) & (n != elements.length - 1))) {
            n = n + 1;
        }
        return storage;
    }

    @Override
    public String toString() {
        return "FileSystem{" +
                "storage=" + storage +
                '}';
    }
}
