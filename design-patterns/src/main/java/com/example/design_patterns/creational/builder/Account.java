package com.example.design_patterns.creational.builder;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

/**
 * @author blackgersain
 * This is a bean class that have some mandatory and some optional parameters, so we can properly demonstrate the use
 * of Builder pattern and optimize it to inform about missing mandatory parameters at compile time.
 */
public class Account {

    private @PositiveOrZero long id;
    private @NotNull String name;
    private @NotNull String mail;
    private boolean isAdmin;
    private String language;

    /**
     * The constructor is private, so it can be only called by the builder inner class.
     * @param builder
     */
    private Account(Builder builder) {
        id = builder.id;
        name = builder.name;
        mail = builder.mail;
        isAdmin = builder.isAdmin;
        language = builder.language;
    }

    /**
     * We should offer a static factory method to return the correct interface to start with.
     * @return interface to start with
     */
    public static Id builder() {
        return new Builder();
    }

    /**
     * For every mandatory parameter we implement a new interface that points to the next in the chain.
     */
    public interface Id {
        Name id(long id);
    }

    public interface Name {
        Mail name(String name);
    }

    public interface Mail {
        Build mail(String mail);
    }

    /**
     * All optional parameters are in the interface that defines the build() method.
     */
    public interface Build {
        Build isAdmin(boolean isAdmin);
        Build language(String language);
        Account build();
    }

    /**
     * Class in charge of building the complex object.
     * Our Builder must implement the interfaces.
     */
    private static class Builder implements Id, Name, Mail, Build {

        private long id;
        private String name;
        private String mail;

        /**
         * The builder sets the default value for optional parameters
         */
        private boolean isAdmin = false;
        private String language = "en";

        /**
         * All of this methods return the current instance of the Builder class, so we achieve the fluent design
         * chaining one method call to the others.
         * @param id parameter that we want to set up.
         * @return instance of Builder that has the parameter already setup.
         */
        @Override
        public Name id(long id) {
            this.id = id;
            return this;
        }

        
        @Override
        public Mail name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public Build mail(String mail) {
            this.mail = mail;
            return this;
        }

        @Override
        public Build isAdmin(boolean isAdmin) {
            this.isAdmin = isAdmin;
            return this;
        }
        @Override
        public Build language(String language) {
            this.language = language;
            return this;
        }

        /**
         * As a final step in the build process we call build() method, which is in charge of actually creating
         * and returning an instance of the enclosing class, with all the parameters currently setup in the builder.
         * @return instance of the enclosing class, in this case Account.
         */
        @Override
        public Account build() {
            return new Account(this);
        }
    }
}
