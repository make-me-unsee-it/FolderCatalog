package com;

import java.util.HashMap;

public interface Element {

    Element createElement(String[] elements, int n, Element oldStorage) throws RewriteException;

    HashMap<String, Element> getStorage();

    String getName();
}
