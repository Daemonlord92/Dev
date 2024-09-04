package org.blitmatthew;

public class Singleton {
    private Singleton singleton;

    private Singleton() {}

    public Singleton getSingleton() {
        if(singleton == null) {
            this.singleton = new Singleton();
        }
        return singleton;
    }
}
