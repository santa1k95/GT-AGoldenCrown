package com.gt.domains;

public class KingdomImpl implements Kingdom{
    String name;
    String emblem;
    Integer cypherSecret;

    public KingdomImpl(){

    }

    public KingdomImpl(String name,String emblem){
        this.name=name;
        this.emblem=emblem;
        createCypherSecret();

    }

    public void createCypherSecret() {
        this.cypherSecret = emblem.length();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getEmblem() {
        return this.emblem;
    }

    @Override
    public Integer getCypherSecret() {
        return this.cypherSecret;
    }
}
