package com.reme.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class FileUtilsService {
    /*
    Reads file contents into Array
    */
    ClassLoader classLoader = getClass().getClassLoader();
    File data = new File(classLoader.getResource("data.txt").getFile());

    @Bean
    public  String[] getRepos() throws IOException {
    List<String> repoList = new ArrayList<String>();
    BufferedReader bf = new BufferedReader(new FileReader(data));
    String line = bf.readLine();
    while (line != null) {
            repoList.add(line);
            line = bf.readLine();
        }

    bf.close();
    return repoList.toArray(new String[0]);
    }
}
