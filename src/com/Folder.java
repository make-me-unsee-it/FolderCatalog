package com;

import java.util.HashMap;

public class Folder implements Element {
    private String name;
    private HashMap<String, Element> storage;

    public Folder(String[] elements, int n) {
        // это конструктор для впервые создаваемых каталогов
        // инициализируем хранилище данных
        storage = new HashMap<>();

        // любой уровень кроме нижнего
        // присваиваем имя папки (ключ) и создаем саму папку в хранилище
        if ((n != elements.length - 1)) {
            this.name = elements[n];
            storage.put(elements[n], new Folder(elements, n + 1));

            // на нижнем уровне проверяем что создаем - папку или файл
        } else {
            // создаем файл
            if (ElementCounter.isFile(elements[n])) {
                this.name = elements[n];
                storage.put(elements[n], new File(elements[n]));
            }
            // создаем папку
            else {
                storage.put(elements[n], new Folder(elements[n]));
            }
        }
    }

    public Folder(String element) {
        this.name = element;
        this.storage = null;
    }

    public Folder (String name, HashMap<String, Element> storage) {
        this.name = name;
        this.storage = storage;
    }

    @Override
    public HashMap<String, Element> getStorage() {
        return storage;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Element createElement(String[] elements, int n, Element oldStorage) throws RewriteException{

        // все уровни кроме последнего
        if ((n != elements.length - 1)) {
            // если на этом уровне такой папки нет - создаем новую ветку каталогов
            if ((!oldStorage.getStorage().containsKey(elements[n]))) {
                HashMap<String, Element> metaStorage = oldStorage.getStorage();
                metaStorage.put(elements[n], new Folder(elements, n + 1));
                return new Folder(oldStorage.getName(),metaStorage);
            }
            // если на этом уровне такая папке есть - передаем содержимое с помощью рекурсии дальше
            else {
                return oldStorage.createElement(elements, n + 1, oldStorage.getStorage().get(elements[n]));
            }
        }
        // последний уровень
        else {
            // если такой элемент есть
            if ((oldStorage.getStorage().containsKey(elements[n]))) {
                if (ElementCounter.isFile(elements[n]))
                    throw new RewriteException("Файл " + elements[n] + " перезаписан");
            }
            // такого элемента нет
            else {
                // создаем файл
                if (ElementCounter.isFile(elements[n])) {
                    return oldStorage.getStorage().put(elements[n], new File(elements[n]));

                }
                // или создаем папку
                else {
                    HashMap<String, Element> metaStorage = oldStorage.getStorage();
                    metaStorage.put(elements[n], new Folder(elements[n]));
                    return new Folder(oldStorage.getName(),metaStorage);
                }
            }

        }
        return oldStorage;
    }

    @Override
    public String toString() {
        return "{" + storage + '}';
    }
}


