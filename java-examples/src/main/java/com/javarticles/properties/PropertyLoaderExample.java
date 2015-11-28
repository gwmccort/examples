package com.javarticles.properties;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Properties;

public class PropertyLoaderExample {
    Properties properties;
    
    public static void main(String[] args) throws MalformedURLException {
        Thread.currentThread().setContextClassLoader(new CustomClassLoader());
        PropertyLoaderExample propLoaderExample = new PropertyLoaderExample();
        propLoaderExample.load("application.properties");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Fetch properties");
        propLoaderExample.printProperty("blog");
        propLoaderExample.printProperty("article");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Reload properties with custom loader's parent set to null");
        Thread.currentThread().setContextClassLoader(new CustomClassLoader(null));
        propLoaderExample = new PropertyLoaderExample();
        propLoaderExample.load("application.properties");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Fetch properties");
        propLoaderExample.printProperty("blog");
        propLoaderExample.printProperty("article");
    }
    
    void printProperty(String key) {
        System.out.println(key + "=" + properties.getProperty(key)); 
    }

    public void load(final String propertiesFileName) {
        final Properties properties = new Properties(); 
        Collection<URL> propertyUrls = findPropertyUrls(propertiesFileName);
        System.out.println("-----------------------------------------------------------");
        System.out.println("Start load property resources");
        for (final URL url : propertyUrls) {
            System.out.println("Load " + url);
            InputStream in = null;
            try {
                in = url.openStream();
                properties.load(in);
            } catch (final IOException ioe) {
                System.out.println("Unable to " + url.toString() + " exception " +  ioe);
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (final IOException ioe) {
                        System.out.println("Unable to close " + url.toString() + " exception " + ioe);
                    }
                }
            }
        }
        this.properties = properties;
    }
    
    private static Collection<URL> findPropertyUrls(final String resource) {
        System.out.println("Find property resources");
        final ClassLoader[] classloaders = {Thread.currentThread().getContextClassLoader(), 
                PropertyLoaderExample.class.getClassLoader(), ClassLoader.getSystemClassLoader()};
        final Collection<URL> propResources = new LinkedHashSet<URL>();
        for (final ClassLoader cl : classloaders) {
            if (cl != null) {
                System.out.println("class loader is " + cl);
                try {
                    final Enumeration<URL> resourceEnum = cl.getResources(resource);
                    while (resourceEnum.hasMoreElements()) {
                        URL url = resourceEnum.nextElement();
                        System.out.println("Add resource " + url);
                        propResources.add(url);
                    }
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return propResources;
    }

}
