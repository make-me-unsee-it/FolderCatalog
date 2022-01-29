package com;

import java.util.HashMap;


public class Folder implements Element {
    private String name;
    private HashMap<String, Element> storage;

    public Folder(String[] elements, int n) {
        storage = new HashMap<>();
        if ((n != elements.length - 1)) {
            this.name = elements[n];
            storage.put(elements[n], new Folder(elements, n + 1));
        } else {
            if (ElementCounter.isFile(elements[n])) {
                this.name = elements[n];
                storage.put(elements[n], new File(elements[n]));
            }
            else {
                System.out.println(elements[n]);
                storage.put(elements[n], new Folder(elements[n]));
            }
        }
    }

    public Folder(String element) {
        storage = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Element> getStorage() {
        return storage;
    }

    @Override
    public void createElement() {
    }

    @Override
    public String toString() {
        return "Folder{" +
                "name='" + name + '\'' +
                ", storage=" + storage +
                '}';
    }
}
