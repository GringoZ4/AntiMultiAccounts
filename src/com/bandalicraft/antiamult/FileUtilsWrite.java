/*  1:   */ package recoverypass;
/*  2:   */ 
/*  3:   */ import java.io.BufferedReader;
/*  4:   */ import java.io.File;
/*  5:   */ import java.io.FileNotFoundException;
/*  6:   */ import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
/*  7:   */ 
/*  8:   */ public class FileUtilsWrite
/*  9:   */ {
   public File ar;
      List strings = new ArrayList();
     public String fileLocation;
      public FileUtilsWrite(String loc){
          
          this.ar = new File(loc);
          if(!ar.exists()){
              try{
              ar.createNewFile();
              }catch(Exception e){
                   System.out.println("Error cargando el archivo");
              }
              }
          this.fileLocation=loc;
          
      }
      public  void loadFile()
/* 11:   */   {
             
/* 12:   */     try
/* 13:   */     {
/* 14:15 */       File file = new File(this.fileLocation);
/* 15:   */       
/* 16:17 */       BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
/* 17:19 */       for (String readString = ""; (readString = bufferedReader.readLine()) != null;) {
/* 18:20 */        this.strings.add(readString);
                  
                  
/* 19:   */       }
/* 20:   */     }
/* 21:   */     catch (Exception e)
/* 22:   */     {
/* 23:23 */      System.out.println("Error leyendo datos");
/* 24:   */     }
/* 25:   */   }
      public boolean contentes(String args){
          return this.strings.contains(args);
      }
/* 10:   */   public  void WriteFile(String args)
/* 11:   */   {
             
/* 12:   */    FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(this.fileLocation,true);
            pw = new PrintWriter(fichero);
 
           
                pw.println(args);
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
               pw.close();
              fichero.close();
              
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
     
/* 25:   */   }
public List<String> getStrings(){
    List <String> users = new ArrayList();
     try
/* 13:   */     {
/* 14:15 */       File file = new File(this.fileLocation);
/* 15:   */       
/* 16:17 */       BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
/* 17:19 */       for (String readString = ""; (readString = bufferedReader.readLine()) != null;) {
/* 18:20 */        users.add(readString);
                  
                  
/* 19:   */       }
/* 20:   */     }
/* 21:   */     catch (Exception e)
/* 22:   */     {
/* 23:23 */      System.out.println("Error leyendo datos");
/* 24:   */     }
    
    
    return users;
}


public void removeLineFromFile(String file, String lineToRemove) {
 
    try {
 
      File inFile = new File(file);
      
      if (!inFile.isFile()) {
        System.out.println("Parameter is not an existing file");
        return;
      }
       
      //Construct the new file that will later be renamed to the original filename. 
      File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
      
      BufferedReader br = new BufferedReader(new FileReader(file));
      PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
      
      String line = null;
 
      //Read from the original file and write to the new 
      //unless content matches data to be removed.
      while ((line = br.readLine()) != null) {
        
        if (!line.trim().equals(lineToRemove)) {
 
          pw.println(line);
          pw.flush();
        }
      }
      pw.close();
      br.close();
      
      //Delete the original file
      if (!inFile.delete()) {
        System.out.println("Could not delete file");
        return;
      } 
      
      //Rename the new file to the filename the original file had.
      if (!tempFile.renameTo(inFile))
        System.out.println("Could not rename file");
      
    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
  }

        
/* 26:   */ }




