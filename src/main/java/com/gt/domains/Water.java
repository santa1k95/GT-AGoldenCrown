package com.gt.domains;

import com.gt.helpers.Constants;

public class Water implements Kingdom {
    public static Water instance = null;
    private final String name = Constants.WATER_NAME;
    private final String emblem = "octopus";
    private Integer cypherSecret;

    private Water() {
        createCypherSecret();
    }

    public String getName() {
        return name;
    }

    public String getEmblem() {
        return emblem;
    }

    public Integer getCypherSecret() {
        return cypherSecret;
    }

    private void createCypherSecret() {
        this.cypherSecret = emblem.length();
    }


    public static Water getInstance() {
        if (instance == null) {
            instance = new Water();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Water{" +
                "name='" + name + '\'' +
                ", emblem='" + emblem + '\'' +
                '}';
    }

}
