package com.angel.ioc.services;

import com.angel.ioc.constants.Constants;
import com.angel.ioc.exceptions.ClassLocatorException;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ClassLocatorForJarFile implements ClassLocator{

    @Override
    public Set<Class<?>> locateClasses(String directory) throws ClassLocatorException {
        final Set<Class<?>> classes = new HashSet<>();
        try{
            JarFile jarFile = new JarFile(new File(directory));
            Enumeration<JarEntry> entries = jarFile.entries();
            while(entries.hasMoreElements()){
                JarEntry entry = entries.nextElement();

                if(!entry.getName().endsWith(Constants.JAVA_BINARY_EXTENTION)){
                    continue;
                }

                final String className = entry.getName()
                    .replace(Constants.JAVA_BINARY_EXTENTION,"")
                    .replaceAll("\\\\",".")
                    .replaceAll("/",".");

                classes.add(Class.forName(className));
            }
        } catch (IOException  | ClassNotFoundException ex){
            throw new ClassLocatorException(ex.getMessage());
        }

        return classes;
    }
}
