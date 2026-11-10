import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

    public static double readFile(String filePath){
        File obj = new File(filePath);
        double bongo = -1;
        try(Scanner reader = new Scanner(obj)){
            while(reader.hasNextLine()){
                String data = reader.nextLine();
                bongo = Double.parseDouble(data);
                System.out.println(bongo + "|" + data);
                
            }
        } catch(FileNotFoundException e){
            System.out.println("The file was not read.");
            e.printStackTrace();
        }
        return bongo;
    }

    public static void main(String[] args){

        File directory = new File("Trolls\\");

        newFile("Evil","Trolls\\","0");

        File[] files = new File("Trolls/").listFiles();

        boolean hoard = false;
        for(File file : files){
            String fileName = file.getName();

            if(fileName.equals("hoard")){
                System.out.println("hoard present");
                hoard = true;
            }
        }
        if(hoard=false){
            newFile("hoard","Trolls/","0");
            System.out.println("file");
            System.out.println("hoard made");
        }
        System.out.println(readFile("Trolls/Evil.txt"));
    }
}