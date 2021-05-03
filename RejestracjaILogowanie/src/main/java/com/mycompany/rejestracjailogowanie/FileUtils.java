package com.mycompany.rejestracjailogowanie;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sawic
 */
public class FileUtils {
    private String file_name = "sekretnehasla.csv";

        public void saveToFile(String text){
            try {
                FileWriter fw = new FileWriter(new File(file_name),true);
                fw.write(text+"\n");
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
public String readFromFile(){
        try {
            String message = "";
            int ile = 0;
            Scanner sc = new Scanner(new File(file_name));
            while(sc.hasNext()){
//                String temp = sc.nextLine();
//                temp = temp.replaceAll(";", "\t");
//                message += temp+"\n";
                 message += sc.nextLine().replaceAll(";", "\t")+"\n"; // dokładnie to samo co wyżej
                 ile++;
            }
            System.out.println(ile);
            return message;
        } catch (FileNotFoundException ex) {
            return ex.toString();
        }
    }
}
