package com.gustavofao.jsonapi.testutils;

import java.io.*;

public class FileLoader {

    private String getContentOf(String path) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(path).getFile());
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String text;
            StringBuilder builder = new StringBuilder();

            while ((text = reader.readLine()) != null) {
                if (!builder.toString().isEmpty()) {
                    builder.append("\n");
                }
                builder.append(text);
            }

            return builder.toString();
        } else {
            throw new FileNotFoundException();
        }
    }

    public String getContent(String path) {
        try {
            return getContentOf(path);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
