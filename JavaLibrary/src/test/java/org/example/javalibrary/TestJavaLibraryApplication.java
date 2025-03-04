package org.example.javalibrary;

import org.springframework.boot.SpringApplication;

public class TestJavaLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.from(JavaLibraryApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
