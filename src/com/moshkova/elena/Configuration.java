package com.moshkova.elena;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

    private static Configuration instance;

    public static Configuration getInstance() {
        if (instance == null) {
            try {
                instance = new Configuration();
            } catch (IOException e) {
                System.out.println("Нет файла настроек");
                System.exit(0);
            }
        }
        return instance;
    }

    private Configuration() throws IOException{
        // запускаем настройки программы по умолчанию
        Properties defaultProperties = new Properties();
            defaultProperties.load(new FileInputStream("application.properties"));


        // загружаем настройки пользователя
        Properties personProperties = new Properties(defaultProperties);
        try {
            personProperties.load(new FileInputStream("person1.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
