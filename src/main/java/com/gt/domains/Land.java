package com.gt.domains;

import com.gt.helpers.Constants;

public class Land implements Kingdom {
    public static Land instance = null;
    private String name = Constants.LAND_NAME;
    private String emblem = "panda";
    private Integer cypherSecret;

    private Land() {
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

    public static Land getInstance() {
        if (instance == null) {
            instance = new Land();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Land{" +
                "name='" + name + '\'' +
                ", emblem='" + emblem + '\'' +
                '}';
    }
}
