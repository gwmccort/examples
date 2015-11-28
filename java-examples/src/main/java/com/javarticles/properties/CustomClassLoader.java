package com.javarticles.properties;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class CustomClassLoader extends URLClassLoader {

    public CustomClassLoader(ClassLoader parent) throws MalformedURLException {
        super(new URL[] { new File(System.getProperty("user.dir")
                + "/jar/app.jar").toURI().toURL() }, parent);
    }
    
    public CustomClassLoader() throws MalformedURLException {
        super(new URL[] { new File(System.getProperty("user.dir")
                + "/jar/app.jar").toURI().toURL() });
    }

}
