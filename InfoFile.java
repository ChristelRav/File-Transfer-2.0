package fichier;

import java.io.*;
import java.io.Serial;

public class InfoFile {
    File f;

    public File getF() {return f;}                          public void setF(File fileget) {this.f = fileget;}
    public InfoFile(){}

    public InfoFile(File f){
        this.setF(f);  
    }
    public String checkExtension(){
        int lastIndexOf = this.getF().getName().lastIndexOf(".");
        if (lastIndexOf == -1) {
            return null; 
        }
        return this.getF().getName().substring(lastIndexOf);
    }
    public String createNameFile(){
        String [] ext = {".txt" , ".jpg" , ".jar" , ".mp3" , ".zip" , ".sql" , ".php" , ".docx" , ".xlsx" ,".html","mp4"};
        String filename = new String();
        for (int i = 0; i < ext.length; i++) {
            String extension = ext[i]; 
            if(this.checkExtension().equalsIgnoreCase(extension)){
                filename = "new"+ext[i];
                System.out.println("FILE = "+filename);
            }
        }
        System.out.println("EXT ="+this.checkExtension());
        return filename;
    }

}
