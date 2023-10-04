package com.example.design_patterns.creational.singleton;

/**
 * @author blackgersain
 * Variant of Singleton pattern.
 * The unique instance is created at the moment of loading the class.
 * The instance is created although the application doesn't need to use it.
 * Good for loading resources that are not very expensive as this recharges initial loading time of the application.
 *
 */
public class SingletonEager {

    /**
     * Private restricts access to the instance.
     * Static ensures that only one instance is created for the class SingletonEager.
     */
    private static SingletonEager instance;

    /**
     * Initialization of the instance as soon as we are loading the class.
     * This static block gives us the possibility of handling exceptions for the creation of the instance.
     */
    static {
        try {
           instance = new SingletonEager();
        }
        catch(Exception e) {
            throw new RuntimeException("Exception creating SingletonEager");
        }
    }

    /**
     * Private constructor to ensure that no one creates instances except inside this class.
     */
    private SingletonEager() {}

    /**
     * Single point of access to the unique created instance.
     * @return unique instance.
     */
    public static SingletonEager getInstance() {
        return instance;
    }
}
