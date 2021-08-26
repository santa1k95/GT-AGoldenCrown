package com.gt.domains;

import com.gt.helpers.Constants;

public class Ice implements Kingdom {
    public static Ice instance = null;
    private String name = Constants.ICE_NAME;
    private String emblem = "mammoth";
    private Integer cypherSecret;

    private Ice() {
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


    public static Ice getInstance() {
        if (instance == null) {
            instance = new Ice();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Ice{" +
                "name='" + name + '\'' +
                ", emblem='" + emblem + '\'' +
                '}';
    }
}
