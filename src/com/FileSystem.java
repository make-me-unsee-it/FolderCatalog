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

    public void elementAdd(String elementPath) throws RewriteException {
        String[] allPathElements = ElementCounter.count(elementPath);
        storage = createElement(allPathElements, storage);
    }

    public void elementAdd() throws RewriteException {
        String elementPath = Scn.scan();
        String[] allPathElements = ElementCounter.count(elementPath);
        storage = createElement(allPathElements, storage);
    }

    protected HashMap<String, Element> createElement(String[] elements, HashMap<String, Element> storage) throws RewriteException {
        int n = 0;

        // для первого - предпоследнего элемента пути
        if (n != elements.length - 1) {

            // добавляем новый каталог первого уровня
            if ((!storage.containsKey(elements[n]))) {
                storage.put(elements[n], new Folder(elements, n));

                // если такая папка уже есть. Достать. Поменять содержимое. Положить обратно.
            } else {
                Element metaElement = storage.get(elements[n]);
                metaElement.createElement(elements, n, storage.get(elements[n]));
                storage.put(elements[n], metaElement);
            }
        }

        // если папка/файл размещаются в корневом каталоге (перый уровень - и есть последний)
        else {
            // если такой элемент есть там есть, то
            if ((storage.containsKey(elements[n]))) {
                if (ElementCounter.isFile(elements[n]))
                    throw new RewriteException("Файл " + elements[n] + " перезаписан");
            } else {
                // если такого элемента нет и это файл, то
                if (ElementCounter.isFile(elements[n])) storage.put(elements[n], new File(elements[n]));
                    // или если папка
                else storage.put(elements[n], new Folder(elements[n]));
            }
        }
        return storage;
    }

    @Override
    public String toString() {
        return "FileSystem" + storage;
    }

    public String print() {
        int hashMapSize = storage.size();
        String result = "FILESYSTEM:\n" + hashMapSize + "\n" + storage.values();
        return result;
    }

}
