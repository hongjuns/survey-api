package com.example.demo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootTest
public class MySQLConnectionTest {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    @Value("${spring.datasource.url}")
    String URL;
    @Value("${spring.datasource.username}")
    String USER;
    @Value("${spring.datasource.password}")
    String PW;

    @Test
    public void testConnection() throws Exception{
        System.out.println("URL"+URL);

        Class.forName(DRIVER);

        try(Connection conn = DriverManager.getConnection(URL, USER, PW)){
            System.out.println("success : "  + conn);
        } catch (Exception e) {
            System.out.println("error :" +e.getMessage());
        }

    }
}