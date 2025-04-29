package com.example.demo;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class LoadSqlRunner implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        String sql = new String(Files.readAllBytes(Paths.get("src/main/resources/database_fixed.sql")));
        jdbcTemplate.execute(sql);
        System.out.println("✅ Se ejecutó project_dump.sql al arrancar.");
    }
}
