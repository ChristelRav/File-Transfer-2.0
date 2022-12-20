package fichier;

import java.net.*;
import java.util.Vector;
import java.io.*;
public class MyServer extends Thread{
    int port= 5000;
    ServerSocket sv;
    String ip = "127.0.0.1";
    String pathSv = "D:/semestre III/RESEAUX/transfertFile/REPOSITORY/";
    InfoFile infoF;
    boolean boo = false;

    public String getIp() {return ip;}                      public void setIp(String ip) {this.ip = ip;}
    public boolean getBoo (){ return boo;}                  public void setBoo(boolean b ){this.boo = b;}
    public InfoFile getInfoF() {return infoF;}              public void setInfoF(InfoFile infoF) {this.infoF = infoF;}
    public  String getPathSv() {return pathSv;}             public void setPathSv(String pathSv) {this.pathSv = pathSv;}
    public int getPort() {  return port;}                   public void setPort(int port) {  this.port = port;}
   
    public String getMessage()throws Exception{
        try {    
         ServerSocket server = new ServerSocket(this.getPort());
         Socket socket = server.accept();
         ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
         String message = (String) ois.readObject();
         System.out.println(message);
         ois.close();
         socket.close();
         server.close();
         return message;
        } catch (Exception e) {
         e.printStackTrace();
        }
        return null;
     } 
    public void Toreceive(String val){
        try{
            System.out.println("receive a file in local Server");
            String way = new String();
                sv = new ServerSocket(this.getPort());
                way = this.getPathSv()+val;
                System.out.println("FILE="+way);
          
            File f = new File(way);
            Socket s=sv.accept();
            ObjectInputStream in=new ObjectInputStream(s.getInputStream());
            FileOutputStream out =new FileOutputStream(f);
            byte buf[] = new byte[1024];
            int n;
            while((n=in.read(buf))!=-1){
                out.write(buf,0,n);                                         
            }
            out.close();  
         
            }catch(Exception e){
               e.printStackTrace();
            }  
    }
    public String shareMessage() throws Exception{
        try {
         ObjectOutputStream oos = null;
         Socket sc = new Socket(this.getIp(),this.getPort());
             oos = new ObjectOutputStream(sc.getOutputStream());
             oos.writeObject(this.getInfoF().getF().getName());
             oos.close();
             Thread.sleep(100);
             return this.getInfoF().getF().getName();
        } catch (Exception e) {
         e.printStackTrace();
        }
        return null;
     }
    public void Toshare(){
        try{
            System.out.println("method to send a file");
            Socket sc = new Socket(this.getIp(),this.getPort());
            FileInputStream inf = new FileInputStream(this.getInfoF().getF());
            ObjectOutputStream outp = new ObjectOutputStream(sc.getOutputStream());
            byte [] buff = new byte[1024];
            int countb;
            while ((countb = inf.read(buff)) != -1) {
                outp.write(buff,0,countb);
            }
            inf.close();
            outp.close();
            sc.close();
        }catch (Exception e) {
           e.printStackTrace();
        } 
    }
    public Vector<String> checkFile(){
        Vector<String>  vf = new  Vector<String> ();
        File dir  = new File(this.getPathSv());
        File[] liste = dir.listFiles();
        for(File item : liste){
          if(item.isFile())
          { 
            vf.add(item.getName()); 
          }
        }
        return vf;
    }
    public void run(){
        try {
            int time = 0;
             if (!boo) {
                while (time++<1) {
                    System.out.println("SERVEUR"+time);
                }
                String a = getMessage();
                System.out.println(a);
                Toreceive(a);
             }else{
                String vl = shareMessage();
                Toshare();
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // public static void main(String[] args) {
    //     MyServer s = new MyServer();
    //     s.Toreceive();
    //     s.start();
    // } 
}
