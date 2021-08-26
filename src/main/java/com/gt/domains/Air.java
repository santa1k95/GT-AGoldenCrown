package com.gt.domains;

import com.gt.helpers.Constants;

public class Air implements Kingdom {
    public static Air instance = null;
    private String name = Constants.AIR_NAME;
    private String emblem = "owl";
    private Integer cypherSecret;

    private Air() {
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


    public static Air getInstance() {
        if (instance == null) {
            instance = new Air();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Air{" +
                "name='" + name + '\'' +
                ", emblem='" + emblem + '\'' +
                '}';
    }
}
