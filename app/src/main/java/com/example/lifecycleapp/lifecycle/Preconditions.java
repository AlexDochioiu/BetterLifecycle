package com.example.lifecycleapp.lifecycle;

/**
 * Created by Alex Dochioiu on 12/02/2019
 */
class Preconditions {
    static <T> T checkNotNull(final T object, final String message) {
        if(object == null) {
            throw new IllegalArgumentException("unexpected null value: " + message);
        }

        return object;
    }

    static <T> T checkNotNull(final T object) {
        if(object == null) {
            throw new IllegalArgumentException("unexpected null value");
        }

        return object;
    }

    static <T> T castNotNull(Object object) {
        //noinspection unchecked: expected to throw on fail cast
        return (T) checkNotNull(object);
    }
}
