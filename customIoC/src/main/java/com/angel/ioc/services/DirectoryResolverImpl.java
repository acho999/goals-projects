package com.angel.ioc.services;

import com.angel.ioc.enums.DirectoryType;
import com.angel.ioc.models.Directory;

import java.io.File;

public class DirectoryResolverImpl implements DirectoryResolver {

    private static final String JAR_FILE_EXTENTION = ".jar";

    @Override
    public Directory resolveDyrectory(Class<?> startupClass) {
        final String directory = getDirectory(startupClass);
        return new Directory(directory, getDirectoryType(directory));
    }

    private String getDirectory(Class<?> startupClass) {
        return startupClass.getProtectionDomain().getCodeSource().getLocation().getFile();
    }

    private DirectoryType getDirectoryType(String directory) {

        File file = new File(
            directory);//here we create a file to use isFile or isDirectory methods for check

        if (file.isFile() && directory.endsWith(JAR_FILE_EXTENTION)) {
            return DirectoryType.JAR_FILE;
        } else {
            return DirectoryType.DIRECTORY;
        }

    }
}
