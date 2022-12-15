/**
 * Server
 */package file;
 import java.io.*;
 import java.net.*;
 public class Server1 extends Thread{
     String Ip;
     int port = 5000;
     String pathreceive;
     File freceive;
 
     public String getPathreceive() {return pathreceive;}    public void setPathreceive(String pathreceive) {this.pathreceive = pathreceive;}
     public File getFreceive() {return freceive;}            public void setFreceive(File freceive) {this.freceive = freceive;}
     public String getIp() {return Ip;}                      public void setIp(String ip) {Ip = ip;}
     public int getPort() {  return port;}                   public void setPort(int port) {  this.port = port;}
 
     public Server1(){}
     public Server1(String ip , int port){
         this.setIp(ip);     this.setPort(port);
     }
 
     public void ToreceiveServer(Server serv){
         try{
             String path = this.getPathreceive();
             System.out.println("receive a file in  Server ONE");
             //System.out.println(serv.getPathreceive()+serv.getFreceive());
             String way = this.getPathreceive()+this.createFilename(freceive);

             File f = new File(way);
 
             ServerSocket sv = new ServerSocket(2015);
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
                 System.out.println(e);
             }  
     }
     
     public String createFilename(File f){
        Server c = new Server();
         String [] ext = {".txt" , ".jpg" , ".jar" , ".mp3" , ".zip" , ".sql" , ".php" , ".docx" , ".xlsx" ,".html","mp4"};
         String filename = new String();
         for (int i = 0; i < ext.length; i++) {
             String extension = ext[i]; 
             if(c.getExtension(f).equalsIgnoreCase(extension)){
                 filename = "server1"+ext[i];
                 System.out.println("ok --- "+filename);
             }
         }
         System.out.println("EXT ="+c.getExtension(f));
         return filename;
     }
     public void run(){
        try {
         int n = 0;
         while(n++<15){
             System.out.println("compilation SERVEUR  111111111111");
         }
         Server s1  = new Server();
        // System.out.println(s1.getPathreceive()+s1.getFreceive());
         this.ToreceiveServer(s1);
         Thread.sleep(3);
        } catch (Exception e) {
            System.out.println("SERVER1");
            System.out.println(e);
        }
     }
 
 }