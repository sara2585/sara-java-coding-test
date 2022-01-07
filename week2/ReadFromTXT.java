// read from txt files:

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.NoSuchElementException;


public class ReadFromTXT implements ReadData {
    public String[][] readData(String dir) {

        // String dir = "C:/Users/Sara_Yu/Desktop/Java/sara-java-coding-test/week2/input/vegetables.txt";
        List<String> veg_list = new ArrayList<>();
        try {
            File file = new File(dir);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){ // add items to list:

                veg_list.add(sc.nextLine());
            }
            sc.close();
        }catch (FileNotFoundException e) {
            System.out.println("Cannot find the file, please check the file path");
        } catch (NoSuchElementException e) {
            System.out.println("No line found");
        }
        // add the list item to String[][]
        int row = veg_list.size();
        String[][] items = new String[row][2];
        for(int i = 0; i < row; i++) {
            String veg = veg_list.get(i);
            items[i][0] = veg.split(",")[0];
            items[i][1] = veg.split(",")[1];
            // System.out.println(items[i][0]);
        }          
        return(items);

        
    }
    public static void main(String[] args) {
        // String dir = "C:/Users/Sara_Yu/Desktop/Java/sara-java-coding-test/week2/input/vegetables.txt";
        String dir= "C:/Users/Sara_Yu/Desktop/Java/sara-java-coding-test/week2/input/flavors.txt";
        ReadFromTXT read = new ReadFromTXT();
        try {
            String[][] items = read.readData(dir);
            for(int i = 0; i < items.length; i++){
                System.out.println(items[i][0] + ":" + items[i][1]);
            }
        }catch (Exception e) {
            System.out.println("error");
        }

    }
}