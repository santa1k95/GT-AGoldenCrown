package com.gt;

import com.gt.domains.Kingdom;
import com.gt.service.ElectionService;
import com.gt.service.ElectionServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class CommandLineApplication {
    /**
     * Load the file from resources folder provided the filename
     * @param fileName
     * @return Scanner
     */
    private static Scanner loadFile(String fileName){
        File file=null;
        Scanner sc = null;
        URL resource = CommandLineApplication.class.getClassLoader().getResource(fileName);
        if (resource == null) {
            System.out.println("File not found!");;
        } else {
            try {
                file=new File(resource.toURI());
                sc=new Scanner(file);
            } catch (URISyntaxException | FileNotFoundException e) {
                System.out.println("File not found!");;
                e.printStackTrace();
            }
        }
        return sc;
    }

    public static void main(String[] args) {
        if(args.length==0) {
            System.out.println("File not provided in arguments");
            return;
        }
        ElectionService electionService= ElectionServiceImpl.getInstance();
        int kingdomsWon=0;
        String fileName=args[0];
        Map<String,Boolean> msgSentTo=new HashMap<>();
//        Scanner scanner=loadFile(fileName);
        File file=new File(fileName);

        Scanner scanner= null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");;
            e.printStackTrace();
        }
        while (scanner!=null && scanner.hasNext()){

            String message=scanner.nextLine();
            String [] command=message.split(" ");
            boolean result=electionService.messageKingdom(command);
            if(result){
                kingdomsWon++;
            }

        }
        Map<String,List<Kingdom>> mapNameKingdomsWon=electionService.getMapNameKingdomsWon();
        Map<String,Integer> mapNameTotalWins=new HashMap<>();
        mapNameKingdomsWon.forEach((key,wonKingdom)->{
            mapNameTotalWins.put(key,wonKingdom.size());
        });

        mapNameTotalWins.forEach((key,value)->{
            System.out.println(key+" "+value);
        });

        final Integer[] max = {0};
        final String[] winnerKingdom = new String[1];
        for(int i=0;i<mapNameTotalWins.size();i++){

        }
        mapNameTotalWins.forEach((key,totalWin)->{
            if(totalWin > max[0]){
                max[0] =totalWin;
                winnerKingdom[0] =key;
            }
        });
        System.out.println(winnerKingdom[0]);

//        Set<Kingdom> uniqueWonKingdoms = new LinkedHashSet<>();
//        for (Kingdom it : wonKingdoms)
//            uniqueWonKingdoms.add(it);
//
//        if(uniqueWonKingdoms.size()>1){
//            uniqueWonKingdoms.forEach(kingdom -> {
//                System.out.print(kingdom.getName());
//                System.out.print(" ");
//            });
//            System.out.println();
//        }else System.out.println("NONE");
    }
}
