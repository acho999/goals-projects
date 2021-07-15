package com.angel.ioc.services;

import com.angel.ioc.models.Directory;

public interface DirectoryResolver {

    Directory resolveDyrectory(Class<?> startupClass);

}
