package com.example.design_patterns.creational.singleton;

/**
 * Variant of Singleton pattern.
 * The unique instance is only created at the moment of calling the getInstance() method, so no instance is created if
 * we don't require it.
 * Good for loading resources that are expensive as this decouples the effort of loading the resource from the initial
 * loading time of the application.
 *
 */
public class SingletonLazy {

    /**
     * Private restricts access to the instance.
     * Static ensures that only one instance is created for the class SingletonEager.
     */
    private static SingletonLazy instance;

    /**
     * Private constructor to ensure that no one creates instances except inside this class.
     */
    private SingletonLazy() {}

    /**
     * Single point of access to the unique instance.
     * Making this method synchronized ensures that this is a thread safe Singleton, and aquiring the lock on
     * SingletonLazy.class inside the first if condition reduces the extra overhead that would me generated if only
     * synchronized would be used as part of the method signature.
     * @return unique instance.
     */
    public static SingletonLazy getInstance() {
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
}
