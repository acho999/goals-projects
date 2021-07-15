package com.angel.ioc.services;

import com.angel.ioc.exceptions.ClassLocatorException;

import java.util.Set;

public class ClassLocatorForDirectory implements ClassLocator{

    @Override
    public Set<Class<?>> locateClasses(String directory) throws ClassLocatorException {
        return null;
    }
}
