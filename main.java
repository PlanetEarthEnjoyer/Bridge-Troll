import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

class main{

    //Makes a new file.
    public static void newFile(String fileName, String filePath){
        try{
            FileOutputStream fos = new FileOutputStream(filePath + "" + fileName);
        } catch(Exception e){
            System.out.println(e);
        }
    }

    //makes a new file + writes on the file.
    public static void newFile(String fileName, String filePath, String fileContents){
        try{
            FileOutputStream fos = new FileOutputStream(filePath + "" + fileName);
            File file = new File(filePath + "" + fileName);
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

    //Writes on a file.
    public static void writeFile(String filePath,String fileContents){
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

    //Reads file contents.
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
        if(bongo < 0){
            System.out.println(filePath + " - Either the user made the troll go broke or the system is broken.");
        }
        return bongo;
    }

    public static void main(String[] args){

        File directory = new File("Trolls\\");

        newFile("Evil","Trolls/","0");

        File[] files = new File("Trolls/").listFiles();

        boolean hoardCheck = false;
        for(File file : files){
            String fileName = file.getName();

            if(fileName.equals("hoard")){
                System.out.println("hoard present");
                Troll hoard = new Troll("name");
                hoardCheck = true;
            } else{
                //
            }
        }
        if(hoardCheck==false){
            newFile("hoard","Trolls/","0");
            System.out.println("file");
            System.out.println("hoard made");
        }
        System.out.println(readFile("Trolls/hoard"));
    }
}