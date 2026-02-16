package com.tmehulic.designpatterns.strategy.java;

import java.io.File;
import java.io.FileFilter;
import java.util.List;
import java.util.stream.Stream;

public class FilteringExample {

    public List<String> filter(String extension) {
        File currentDirectory = new File(".");

        FileFilter filter = pathname -> pathname.getName().endsWith(extension);
        File[] files = currentDirectory.listFiles(filter);

        return files != null ? Stream.of(files).map(File::getName).toList() : List.of();
    }
}
