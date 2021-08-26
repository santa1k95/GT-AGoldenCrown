package com.gt.domains;

import com.gt.helpers.Constants;

public class Fire implements Kingdom {
    public static Fire instance = null;
    private String name = Constants.FIRE_NAME;
    private String emblem = "dragon";
    private Integer cypherSecret;

    private Fire() {
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


    public static Fire getInstance() {
        if (instance == null) {
            instance = new Fire();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Fire{" +
                "name='" + name + '\'' +
                ", emblem='" + emblem + '\'' +
                '}';
    }
}
