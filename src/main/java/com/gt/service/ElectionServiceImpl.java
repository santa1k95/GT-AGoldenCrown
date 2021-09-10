package com.gt.service;

import com.gt.domains.*;
import com.gt.helpers.Constants;

import java.util.*;

public class ElectionServiceImpl implements ElectionService {
    public static ElectionServiceImpl instance = null;
    Map<String, Kingdom> kingdoms = new HashMap<>();
    Map<String,List<Kingdom>> mapNameKingdomsWon = new HashMap<>();

    public Map<String, List<Kingdom>> getMapNameKingdomsWon() {
        return mapNameKingdomsWon;
    }

    /**
     * Default constructor for the singleton class ElectionServiceImpl
     */
    private ElectionServiceImpl() {
        createKingdoms();
        kingdoms.forEach((key,kingdom)->{
            mapNameKingdomsWon.put(kingdom.getName(),new ArrayList<Kingdom>());
        });
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
        return null;
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
//        this.wonKingdoms.clear();
//        wonKingdoms.add(kingdoms.get(Constants.SPACE_NAME));
    }

    /**
     * Initializes the election service with the kingdoms created
     */
    private void createKingdoms() {
        Kingdom space = new KingdomImpl("space".toUpperCase(Locale.ROOT),"gorilla");
        Kingdom air = new KingdomImpl("air".toUpperCase(Locale.ROOT),"owl");
        Kingdom water = new KingdomImpl("water".toUpperCase(Locale.ROOT),"octopus");
        Kingdom fire = new KingdomImpl("fire".toUpperCase(Locale.ROOT),"dragon");
        Kingdom land = new KingdomImpl("land".toUpperCase(Locale.ROOT),"panda");
        Kingdom ice = new KingdomImpl("ice".toUpperCase(Locale.ROOT),"mammoth");

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
        if(args.length<3){
            return false;
        }

        String senderKingdomName=args[0].toUpperCase(Locale.ROOT);
        String recieverKingdomName=args[1].toUpperCase(Locale.ROOT);


        String message="";
        for (int i=2;i<args.length;i++){
            message+=args[i];
        }

        String decodedMessage=kingdoms.get(recieverKingdomName).decodeMessage(message);
        boolean isAWin=kingdoms.get(recieverKingdomName).containsEmblem(decodedMessage);
        if(isAWin){
            mapNameKingdomsWon.get(senderKingdomName).add(kingdoms.get(recieverKingdomName));
        }
//        System.out.println("Command "+args[0]+ " " +args[1]);
        return true;
    }
}
