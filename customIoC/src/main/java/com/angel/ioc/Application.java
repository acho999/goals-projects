package com.angel.ioc;

import com.angel.ioc.config.IoCConfiguration;
import com.angel.ioc.models.Directory;
import com.angel.ioc.services.DirectoryResolverImpl;

public class Application {

    public static void main(String[] args){

        run(Application.class);
    }

    public static void run(Class<?> startupClass){//this startupClass is for locating the file
        //from which our jar will start because this project will be used as a dependency

        run(startupClass,new IoCConfiguration());

    }

    public static void run(Class<?> startupClass, IoCConfiguration config){

        Directory dir = new DirectoryResolverImpl().resolveDyrectory(startupClass);

        System.out.println(startupClass.getProtectionDomain().getCodeSource().getLocation().getFile());

        System.out.println(dir.getDirectoryType());

    }

}
