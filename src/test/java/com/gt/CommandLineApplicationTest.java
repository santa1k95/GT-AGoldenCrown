package com.gt;

import org.junit.jupiter.api.Test;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class CommandLineApplicationTest {

    @Test
    void main() {
        URL resource = CommandLineApplication.class.getClassLoader().getResource("input1.txt");
        CommandLineApplication.main(resource.getPath().split(" "));
    }
    @Test
    void mainTest2() {
        URL resource = CommandLineApplication.class.getClassLoader().getResource("input2.txt");
        CommandLineApplication.main(resource.getPath().split(" "));
    }
}