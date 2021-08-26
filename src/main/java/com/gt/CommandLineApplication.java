package com.gt;

import com.gt.domains.Kingdom;
import com.gt.service.ElectionService;
import com.gt.service.ElectionServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

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
        Scanner scanner=loadFile(fileName);
        while (scanner!=null && scanner.hasNext()){
            String message=scanner.nextLine();
            String [] command=message.split(" ");
            boolean result=electionService.messageKingdom(command);
            if(result){
                kingdomsWon++;
            }

        }
        List<Kingdom> wonKingdoms=electionService.getWonKingdoms();
        if(wonKingdoms.size()>1){
            wonKingdoms.forEach(kingdom -> {
                System.out.print(kingdom.getName());
                System.out.print(" ");
            });
            System.out.println();
        }else System.out.println("NONE");
    }
}
