package com.javarticles.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class FileCompressionExample {
    public static void main(String[] args) throws ParserConfigurationException,
            SAXException, IOException {
        String[] zipEntryFiles = new String[] { "emp.xml", "x.properties", "y.txt" };

        FileOutputStream dest = new FileOutputStream("allFiles.zip");
        CheckedOutputStream checksum = new CheckedOutputStream(dest,
                new Adler32());
        ZipOutputStream zos = new ZipOutputStream(checksum);
        BufferedOutputStream bos = new BufferedOutputStream(zos);        
        try {
            zos.setComment("Javaticles - Compressing files example");
            byte[] data = new byte[1024];
            for (String zipEntryFile : zipEntryFiles) {                
                BufferedInputStream bis = new BufferedInputStream(
                        FileCompressionExample.class
                                .getResourceAsStream(zipEntryFile));
                try {
                    String fileName =  "com/javarticles/io/" + zipEntryFile;
                    ZipEntry entry = new ZipEntry(fileName);
                    System.out.println("Adding file: " + fileName);
                    zos.putNextEntry(entry);
                    int count;
                    while ((count = bis.read(data, 0, data.length)) != -1) {
                        bos.write(data, 0, count);
                    }
                } finally {
                    bis.close();
                    bos.flush();
                }
            }
            System.out
                    .println("checksum: " + checksum.getChecksum().getValue());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bos.close();
        }

    }
}
