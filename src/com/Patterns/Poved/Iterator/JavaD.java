package com.Patterns.Poved.Iterator;

public class JavaD implements Coll {
    private String name;
    private String[] skils;

    public JavaD(String name, String[] skils) {
        this.name = name;
        this.skils = skils;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getSkils() {
        return skils;
    }

    public void setSkils(String[] skils) {
        this.skils = skils;
    }

    @Override
    public Iterator getIterator() {
        return new JavaDIter();
    }

    private class JavaDIter implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            return index < skils.length;
        }

        @Override
        public Object next() {
            return skils[index++];
        }
    }
}
