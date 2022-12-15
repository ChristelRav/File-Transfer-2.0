package file;
import java.io.*;
import java.net.*;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
public class Client extends Thread{
    String Ipadd;
    int port = 5000;
    File fileSend;
    File fileget;

    public File getFileget() {return fileget;}    public void setFileget(File fileget) {this.fileget = fileget;}
    public File getFileSend() {return fileSend;}  public void setFileSend(File fileSend) {this.fileSend = fileSend;}
    public String getIpadd() {return Ipadd;}        public void setIpadd(String ipadd) {Ipadd = ipadd;}
    public int getPort() {return port;}             public void setPort(int port) {this.port = port;}
    
    public Client(){}
    public Client(String ip , int port){
        this.setIpadd(ip);  this.setPort(port);
    }

    public void Tosend(Server s) {
        try{
            System.out.println("method to send a file");
            Socket sc = new Socket(s.getIp(),s.getPort());
            FileInputStream inf = new FileInputStream(this.getFileSend());
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
           System.out.println(e);
        } 
    }
    public void Toget(){
        System.out.println("get a file in a local server");
    }
    public String getExtension(File fl){
        int lastIndexOf = fl.getName().lastIndexOf(".");
        if (lastIndexOf == -1) {
            return null; 
        }
        return fl.getName().substring(lastIndexOf);
    }
    public File chooseFile(){
        JFileChooser jfc = new JFileChooser();
        if(jfc.showOpenDialog(null) == jfc.APPROVE_OPTION){
            this.setFileSend(jfc.getSelectedFile());
        }
        return this.getFileSend();
    }
    public void run(){
        try {
            int n = 0;
            while (n++<7) {
                    System.out.println("compilation CLIENT");
            }
            Server s = new Server();

            this.Tosend(s); 
            Thread.sleep(4);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
