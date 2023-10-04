package com.example.design_patterns.creational.singleton;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author blackgersain
 * Variant of Singleton pattern.
 * The unique instance is only created at the moment of calling the getInstance() method, so no instance is created if
 * we don't require it.
 * Good for loading resources that are expensive as this decouples the effort of loading the resource from the initial
 * loading time of the application.
 * This version of the Singleton takes care of not breaking the pattern when we load a Singleton (deserialize it).
 */
public class SingletonSerializable implements Serializable {

    private static final long serialVersionUID = -7604766932017737115L;

    /**
     * Private constructor to ensure that no one creates instances except inside this class.
     */
    private SingletonSerializable() {}

    /**
     * Inner helper class with restricted access out of this scope. Contains the unique INSTANCE which is only
     * created when we call getInstance() method from the outer class. This ensures lazy initialization.
     * Thread safety is ensured since INSTANCE is a static constant here.
     */
    private static class SingletonSerializableInnerClass {

        public static final SingletonSerializable INSTANCE = new SingletonSerializable();

    }

    /**
     * Single point of access to the unique instance.
     * @return unique instance.
     */
    public static SingletonSerializable getInstance() {
        return SingletonSerializableInnerClass.INSTANCE;
    }

    @Serial
    protected Object readResolve() {
        return getInstance();
    }
}
