package com.gt.domains;

import com.gt.helpers.Constants;

public class Space implements Kingdom {
    public static Space instance = null;
    private final String name = Constants.SPACE_NAME;
    private final String emblem = "gorilla";
    private Integer cypherSecret;

    private Space() {
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


    public static Space getInstance() {
        if (instance == null) {
            instance = new Space();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Space{" +
                "name='" + name + '\'' +
                ", emblem='" + emblem + '\'' +
                '}';
    }
}
