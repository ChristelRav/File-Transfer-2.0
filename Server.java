/**
 * Server
 */package file;
import java.io.*;
import java.net.*;
public class Server extends Thread{
    String Ip;
    int port = 5000;
    String pathreceive;
    File freceive;
    File fsend;

    public File getFsend() {return fsend;}                  public void setFsend(File fsend) {this.fsend = fsend;}
    public String getPathreceive() {return pathreceive;}    public void setPathreceive(String pathreceive) {this.pathreceive = pathreceive;}
    public File getFreceive() {return freceive;}            public void setFreceive(File freceive) {this.freceive = freceive;}
    public String getIp() {return Ip;}                      public void setIp(String ip) {Ip = ip;}
    public int getPort() {  return port;}                   public void setPort(int port) {  this.port = port;}

    public Server(){}
    public Server(String ip , int port){
        this.setIp(ip);     this.setPort(port);
    }

    public void Toreceive(Client c){
        try{
            String path = this.getPathreceive();
            System.out.println("receive a file in local Server");
            String way = path +this.createFilename(c);
            File f = new File(way);
            System.out.println("okkkkkk");
            ServerSocket sv = new ServerSocket(this.getPort());
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
                System.out.println("aaaaa");
                System.out.println(e);
            }  
    }   
    public String createFilename(Client c ){
        String [] ext = {".txt" , ".jpg" , ".jar" , ".mp3" , ".zip" , ".sql" , ".php" , ".docx" , ".xlsx" ,".html","mp4"};
        String filename = new String();
        for (int i = 0; i < ext.length; i++) {
            String extension = ext[i]; 
            if(c.getExtension(c.getFileSend()).equalsIgnoreCase(extension)){
                filename = "new"+ext[i];
                System.out.println("ok --- "+filename);
            }
        }
        System.out.println("EXT ="+c.getExtension(c.getFileSend()));
        return filename;
    }
    public void toshare(Server1 s){
        try{
            System.out.println("method to send a file");
            Socket sc = new Socket(s.getIp(),2015 );
            File f = new File(this.getPathreceive()+getFreceive());
            System.out.println(f.getAbsolutePath());
            FileInputStream inf = new FileInputStream(f);
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
            System.out.println("ERROR");
             System.out.println(e);
        } 
    }
    public String getExtension(File fl){
        int lastIndexOf = fl.getName().lastIndexOf(".");
        if (lastIndexOf == -1) {
            return null; 
        }
        return fl.getName().substring(lastIndexOf);
    }
    public void run(){
       try {
        int n = 0;
        while(n++<5){
            System.out.println("compilation SERVEUR");
        }
        Client c = new Client();
        if(c.getFileSend() == null){
            c.setFileSend(this.getFreceive());
        }
        this.Toreceive(c);
        int i = 0;
        while (i++<15) {
                System.out.println("compilation SERVER - > CLIENT");
        }
        Server1 s = new Server1();
        this.toshare(s);
        Thread.sleep(3);
       } catch (Exception e) {
        System.out.println(e);
       }
    }

}