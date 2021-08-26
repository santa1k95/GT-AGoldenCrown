package com.gt.service;

import com.gt.domains.*;
import com.gt.helpers.Constants;

import java.util.*;

public class ElectionServiceImpl implements ElectionService {
    public static ElectionServiceImpl instance = null;
    Map<String, Kingdom> kingdoms = new HashMap<>();
    List<Kingdom> wonKingdoms = new ArrayList<>();

    /**
     * Default constructor for the singleton class ElectionServiceImpl
     */
    private ElectionServiceImpl() {
        createKingdoms();
        wonKingdoms.add(kingdoms.get(Constants.SPACE_NAME));
    }

    /**
     * Getter to get the kingdoms
     * @return Map<String, Kingdom>
     */
    public Map<String, Kingdom> getKingdoms() {
        return kingdoms;
    }

    /**
     * Getter to get the list of won kingdoms
     * @return List<Kingdom>
     */
    public List<Kingdom> getWonKingdoms() {
        return wonKingdoms;
    }


    /**
     * Static method to get the instance of ElectionServiceImpl class
     * @return ElectionServiceImpl
     */
    public static ElectionServiceImpl getInstance() {
        if (instance == null) {
            instance = new ElectionServiceImpl();
        }
        return instance;
    }

    /**
     * Clears the list of won kingdoms
     */
    public void resetElections() {
        this.wonKingdoms.clear();
        wonKingdoms.add(kingdoms.get(Constants.SPACE_NAME));
    }

    /**
     * Initializes the election service with the kingdoms created
     */
    private void createKingdoms() {
        Kingdom space = Space.getInstance();
        Kingdom air = Air.getInstance();
        Kingdom water = Water.getInstance();
        Kingdom fire = Fire.getInstance();
        Kingdom land = Land.getInstance();
        Kingdom ice = Ice.getInstance();

        this.kingdoms.put(Constants.AIR_NAME, air);
        this.kingdoms.put(Constants.SPACE_NAME, space);
        this.kingdoms.put(Constants.WATER_NAME, water);
        this.kingdoms.put(Constants.FIRE_NAME, fire);
        this.kingdoms.put(Constants.LAND_NAME, land);
        this.kingdoms.put(Constants.ICE_NAME, ice);
    }

    /**
     * Message command to win kingdoms based on the decode of message and relevant conditions
     * @param args Single command with Kingdom to send the message and the message itself
     * @return true if the kingdom is won false otherwise
     */
    @Override
    public boolean messageKingdom(String[] args) {
//        resetElections();
        if(args.length<2){
            return false;
        }

        String kingdomName=args[0].toUpperCase(Locale.ROOT);
        if(wonKingdoms.contains(kingdoms.get(kingdomName))){
            return  false;
        }
        String message="";
        for (int i=1;i<args.length;i++){
            message+=args[i];
        }

        String decodedMessage=kingdoms.get(kingdomName).decodeMessage(message);
        boolean isAWin=kingdoms.get(kingdomName).containsEmblem(decodedMessage);
        if(isAWin){
            wonKingdoms.add(kingdoms.get(kingdomName));
        }
//        System.out.println("Command "+args[0]+ " " +args[1]);
        return true;
    }
}
