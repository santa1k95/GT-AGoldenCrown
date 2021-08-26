package com.gt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandLineApplicationTest {

    @Test
    void main() {
        CommandLineApplication.main("input1.txt".split(" "));
    }
    @Test
    void mainTest2() {
        CommandLineApplication.main("input2.txt".split(" "));
    }
}