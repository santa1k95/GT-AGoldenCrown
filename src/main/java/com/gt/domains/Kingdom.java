package com.gt.domains;

/**
 * IKingdom
 */

import java.util.*;

public interface Kingdom {
    public String getName();
    public String getEmblem();
    public Integer getCypherSecret();
    default String decodeMessage(String message){
        String decodedMsg="";
        message=message.toLowerCase(Locale.ROOT);
        char[] messageArr=message.toCharArray();
        for(char alphabet:messageArr){
            if(alphabet >= 'a' && alphabet <= 'z')
            {
                alphabet = (char) (alphabet - getCypherSecret());
                if(alphabet < 'a') {
                    alphabet = (char) (alphabet-'a'+'z'+1);
                }
                decodedMsg = decodedMsg + alphabet;
            }
        }
        return decodedMsg;
    }
    default boolean containsEmblem(String message){
        List<Character> listMessage=new ArrayList();
        List<Character> listEmblem=new ArrayList();
        for (char c : message.toCharArray()) {
            listMessage.add(c);
        }
        for (char c : getEmblem().toCharArray()) {
            listEmblem.add(c);
        }
        return listMessage.containsAll(listEmblem);
    }


}
