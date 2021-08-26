package com.gt.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElectionServiceImplTest {

    ElectionService fixture=ElectionServiceImpl.getInstance();
    @Test
    void getKingdoms() {
        Object result=fixture.getKingdoms();
        assertNotNull(result);
    }

    @Test
    void getWonKingdoms() {
        Object result=fixture.getWonKingdoms();
        assertNotNull(result);
    }

    @Test
    void getInstance() {
        Object result=fixture.getKingdoms();
        assertNotNull(result);
    }

    @Test
    void resetElections() {
        fixture.resetElections();
        assertEquals(fixture.getWonKingdoms().size(),1);
    }

    @Test
    void messageKingdom() {
        fixture.messageKingdom("AIR ROZO".split(" "));
        assertEquals(fixture.getWonKingdoms().size(),2);
    }
}