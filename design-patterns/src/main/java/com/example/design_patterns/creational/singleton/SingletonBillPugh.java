package com.example.design_patterns.creational.singleton;

/**
 * Variant of Singleton pattern.
 * This version is also lazy (same characteristics) as the INSTANCE is only created when we call the getInstance()
 * method.
 * This version is thread safe without the need of synchronization.
 *
 */
public class SingletonBillPugh {

    /**
     * Private constructor to ensure that no one creates instances except inside this class.
     */
    private SingletonBillPugh() {}

    /**
     * Inner helper class with restricted access out of this scope. Contains the unique INSTANCE which is only
     * created when we call getInstance() method from the outer class. This ensures lazy initialization.
     * Thread safety is ensured since INSTANCE is a static constant here.
     */
    private static class SingletonBillPughInnerClass {

        public static final SingletonBillPugh INSTANCE = new SingletonBillPugh();

    }

    /**
     * Single point of access to the unique instance.
     * @return unique instance.
     */
    public static SingletonBillPugh getInstance() {
        return SingletonBillPughInnerClass.INSTANCE;
    }
}
