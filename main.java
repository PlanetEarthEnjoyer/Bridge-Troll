import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.FileWriter;
//import java.util.Scanner;

class main{
    public static void newFile(String fileName, String filePath){
        try{
            FileOutputStream fos = new FileOutputStream(filePath + "" + fileName + ".txt");
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public static void newFile(String fileName, String filePath, String fileContents){
        try{
            FileOutputStream fos = new FileOutputStream(filePath + "" + fileName + ".txt");
            File file = new File(filePath + "" + fileName + ".txt");
            FileWriter fileWriter = new FileWriter(file);

            if(file.isFile()){
                fileWriter.write(fileContents);
                fileWriter.flush();
                fileWriter.close();
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public static void writeFiles(String filePath,String fileContents){
        try {
            File file = new File(filePath);
            if(file.isFile()){
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(fileContents);
                fileWriter.flush();
                fileWriter.close();
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args){

        File directory = new File("Trolls\\");

        newFile("Evil","Trolls\\","0");

        File[] files = new File("Trolls/").listFiles();

        boolean hoard;
        for(File file : files){
            String fileName = file.getName();

            if(fileName.equals("hoard")){
                System.out.println("hoard present");
                hoard = true;
            } //else if

            if(hoard=false){
                //newFile("hoard","Trolls\\","0");
                System.out.println("file");
                System.out.println("hoard made");
            }
        }
    }
}