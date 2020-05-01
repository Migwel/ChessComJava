package dev.migwel.chesscomjava.api.services;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ServiceLoader;

public final class FactoryCreator {
    private FactoryCreator() {}

    private static final ServiceFactory serviceFactory = loadFactory(ServiceFactory.class);

    private static <T> T loadFactory(Class<T> serviceClass) {
        ServiceLoader<T> loader = ServiceLoader.load(serviceClass);
        Iterator<T> iterator = loader.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        throw new NoSuchElementException("Could not find implementation for class: "+ serviceClass);
    }

    public static ServiceFactory getServiceFactory() {
        return serviceFactory;
    }
}
