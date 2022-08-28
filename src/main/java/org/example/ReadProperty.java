package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ReadProperty {

    String password;
    String user;
    String url;

    public void getInfo () {

        Properties prop = new Properties();
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream(System.getProperty("user.dir") + "/app.properties"), StandardCharsets.UTF_8)) {
            prop.load(isr);
        } catch (IOException e) {
            throw new RuntimeException("My message");
        }
        password = prop.getProperty("password");
        user = prop.getProperty("user");
        url = prop.getProperty("url");

    }

    public String getUser (){
        return this.user;
    }

    public String getUrl (){
        return this.url;
    }

    public String getPassword (){
        return this.password;
    }
}
