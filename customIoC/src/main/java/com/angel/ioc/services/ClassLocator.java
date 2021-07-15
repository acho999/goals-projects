package com.angel.ioc.services;

import com.angel.ioc.exceptions.ClassLocatorException;

import java.util.Set;

public interface ClassLocator {

    Set<Class<?>> locateClasses(String directory) throws ClassLocatorException;

}
