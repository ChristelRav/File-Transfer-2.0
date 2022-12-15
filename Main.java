package main;

import java.io.File;

import file.*;
import figure.Frame;

public class Main {
    public static void main(String[] args) throws Exception{
       try {
         Frame f = new Frame();
        //System.out.println("MUST CREATE DE REPOSITORY OF SERVER 1");

// TRANSFERT 
        // Server s = new Server();
        // s.setIp("127.0.0.1");   s.setPort(5000);
        // s.setPathreceive("D:/semestre III/RESEAUX/Launched File/REPOSITORY/");
        
// CLIENT-SERVER
//         Client c = new Client();
//         File f = new File("D:/doc.txt");  
//         c.setFileSend(f);
// //SERVER-SERVER1   
        // s.setFreceive(new File(s.createFilename(c)));
        // s.setFsend(new File(s.getPathreceive()+s.getFreceive()));
        
        // Server1 s1  = new Server1();
        // s1.setIp("127.0.0.1");   s1.setPort(5000);
        // s1.setPathreceive("D:/semestre III/RESEAUX/Launched File/SERVER1/");
        // s1.setFreceive(s.getFreceive());
        // System.out.println("AAAAAAAAAAAAAA"+s1.getFreceive());
      
      
        
        //  s.start(); 
        //  c.start();
        // s1.start();
       } catch (Exception e) {
       System.out.println(e);
       }
    }
}
