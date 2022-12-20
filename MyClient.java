
package fichier;

import java.net.*;

import fichier.InfoFile;

import java.io.*;
public class MyClient extends Thread {
    InfoFile infoF;
    String ip = "127.0.0.1";
    int port = 5000;
    boolean boo = false;


    public int getPort() {return port; }              public void setPort(int port) {this.port = port;}
    public String getIp() {return ip;}                public void setIp(String ip) {this.ip = ip;}
    public boolean getBoo (){ return boo;}            public void setBoo(boolean b ){this.boo = b;}
    public InfoFile getInfoF() {return infoF;}        public void setInfoF(InfoFile infoF) {this.infoF = infoF;}
    public String sendMessage() throws Exception{
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
    public void Tosend() {
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
    public String checkMessage()throws Exception{
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
    public void Toupload(String str){
        try{
            System.out.println("UPLOAD a file in local Server");
            String way = new String();
            ServerSocket sv = new ServerSocket(this.getPort());
            System.out.println();
            way = "DOC/"+ str;
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
    public void run(){
        try {
            int time =0;
            if (!boo) {
                while (time++ < 5) {
                    System.out.println("CLIENT"+time);
                }
                String v = sendMessage();
                Tosend();
            }else{
                String val = checkMessage();
                Toupload(val);
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    // public static void main(String[] args) {
    //     InfoFile inf = new InfoFile(new File("D:/mp3agic-0.9.1-sources.jar"));
    //     InfoFile info = new InfoFile(new File("D:/doc.txt"));
    //     MyClient c = new MyClient();
    //     //MyClient c1 = new MyClient();
    //     c.start();  //c1.start();
    // }
}
