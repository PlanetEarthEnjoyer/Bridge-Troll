import java.io.Serializable;

/*
public Troll(String name): 
Troll has two contructors that sets the troll's name and sets their personal gold stash.

public void collect(double toll): collect a toll and add to personal gold

public double stash(): return the amount in the personal stash of the current troll

public void bank(double amount): transfer the amount from personal stash to the hoard. Any number greater than the personal stash transfers the whole stash (personal stash cannot be negative because troll economics are a hard-backed currency basis)

public void bank(): calling bank with no parameter transfers the whole stash

public void nameChange(String newName): Change the troll's name to newName.

public static double hoard(): return the amount in the hoard

beautifal API documentation (not done by me), this is now under GP License!!!!!!
Credit to my teacher for the API documentation (it is nearly word for word the part 1 of the assignment)
*/

class Troll implements Serializable{ //make it work blegh

    static double hoard = 0;
    String trollName;
    double stash;

    public Troll(String name){
        if(!(name.equals("hoard"))){
            trollName = name;
            stash = 0;
            //main.newFile(trollName,"Trolls/",stash); - Deprecated
        } else{
            System.out.println("Troll cannot be named \"hoard\"");
        }
    }

    public Troll(String name,double value){
        if(!(name.equals("hoard"))){
            trollName = name;
            stash = value;
            //main.newFile(trollName,"Trolls/",stash);
        } else{
            trollName = name;
            stash = value;
            hoard = value;
            //updateFile();
        }
    }

    public void collect(double toll){
        stash += toll;
    }

    public double stash(){
        return(stash);
    }

    public void bank(){
        hoard += stash;
        stash = 0;
    }

    public void nameChange(String newName){
        trollName = newName;
    }

    public static double hoard(){
        return(hoard);
    }

    public static void setHoard(double num){
        hoard = num;
    }

    /* DEPRECATED
    public static void updateFile(){
        trollFilePath = "Trolls/" + trollName;
        if (trollName == hoard){
            main.writeFile(trollFilePath,hoard);
        } else{
            main.writeFile(trollFilePath,stash);
        }
    }*/
}