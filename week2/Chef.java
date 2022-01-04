
import java.util.*;
import java.util.Scanner;


// Chef.java
// Make salad with different vegetables.

interface vegetables {
    class getCalorie {};
    class addVegetable {};
}

abstract class flavor {
    String taste = null;
    int cal;
    public abstract void addFlavor();
}

// vegetables
class GreenVegetables implements vegetables{
    // Defile calorie per gram.
    public static int cal = 0;
    public static String color = null;
    public static int getCalorie(int a) {
        cal = a;
        return cal;
    }
    public void addVegetable () {
        System.out.println("Add vegetables");
    }
}

// pepper
class pepper extends GreenVegetables {
    int cal = getCalorie(10);
    static String color = "Green";
    public  void addVegetable() {
        System.out.println("Add peppers");
    }
}

// cabbage
class cabbage extends GreenVegetables {
    int cal = getCalorie(15);
    static String color = "Purple";
    public void addVegetable() {
        System.out.println("Add cabbages");
    }
}

// tomato
class tomato extends GreenVegetables {
    int cal = getCalorie(5);
    static String color = "Red";
    public void addVegetable() {
        System.out.println("Add tomatos");
    }
}

// cucumber
class cucumber extends GreenVegetables {
    int cal = getCalorie(8);
    static String color = "Green";
    public void addVegetable() {
        System.out.println("Add cucumbers");
    }
}
 // ice plant
 class icePlant extends GreenVegetables {
    int cal = getCalorie(4);
    String color = "Green";
    public void addVegetable() {
        System.out.println("Add ice plant");
    }
 }

// oil;
class OliveOil extends flavor {
    String taste = "No taste";
    int cal = 20;
    public void addFlavor() {
        System.out.println("Add Olive Oil");
    };
}

// salad dressing
class SaladDressing extends flavor {
    String taste = "Salt";
    int cal = 40;
    public void addFlavor() {
        System.out.println("Add salad dressing");
    };  
}

// honey
class Honey extends flavor {
    String taste = "Salt";
    int cal = 25;
    public void addFlavor() {
        System.out.println("Add honey");
    };  
}

public class Chef {
    //To mix the vegetables and flavors together to make the salad: add the inputs into a map
    public static Map<String, Integer> makeSalad(String[][] vegtables, String[][] flavors) {
        Map<String, Integer> salad = new HashMap<String, Integer>();
        // add vegetables:
        for(int i = 0; i < vegtables.length; i++){
            int cal = 0;
            // salad.put(vegtables[i][0], Integer.valueOf(vegtables[i][1]));
            switch(vegtables[i][0]) {
                case "pepper": {
                    pepper p = new pepper();
                    p.addVegetable();
                    cal = p.cal;
                    break;}
                case "cabbage": {
                    cabbage c = new cabbage();
                    c.addVegetable();
                    cal = c.cal;
                    break;}
                case "tomato": {
                    tomato t = new tomato();
                    t.addVegetable();
                    cal = t.cal;
                    break;}
                case "cucumber": {
                    cucumber cu = new cucumber();
                    cu.addVegetable();
                    cal = cu.cal; 
                    break;}
                case "ice plant": {
                    icePlant ic = new icePlant();
                    ic.addVegetable();
                    cal = ic.cal;
                    break; }
            }
            int caloriesCount = cal * Integer.valueOf(vegtables[i][1]);
            salad.put(vegtables[i][0], caloriesCount);
        }
        // add flavors:
        for(int j = 0; j < flavors.length; j++ ) {
            int cal = 0;
            // salad.put(flavors[j][0], Integer.valueOf(flavors[j][1]));
            switch(flavors[j][0]) {
                case "oil": {
                    OliveOil o = new OliveOil();
                    o.addFlavor();
                    cal = o.cal;
                    break;}
                case "salad dressing": {
                    SaladDressing sd = new SaladDressing();
                    sd.addFlavor();
                    cal = sd.cal;
                    break;}
                case "honey": {
                    Honey h = new Honey();
                    h.addFlavor();
                    cal = h.cal;
                    break;}
            }
            int caloriesCount = cal * Integer.valueOf(flavors[j][1]);
            salad.put(flavors[j][0], caloriesCount);
        }
        return salad;
    }

    // Count total calcories of the salad:
    public int countCalories(Map<String, Integer> salad) {
        int calories = 0;
        for(var entry: salad.entrySet()) {
            calories += entry.getValue();
        }
        return calories;
    }

    // Sort vegetables by calories of each:
    public static void sortVegetables(Map<String, Integer> m) {
        System.out.println("Sorting the vegetables and flavors in the salad by their calories: ");
        m.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue())
        .forEach(System.out::println);
    }

    // Search the vegetable which contains the most carlories.
    public static void searchVegetables(Map<String, Integer> m) {
        int maxValue = Collections.max(m.values());
        for(var entry: m.entrySet()) {
            if(entry.getValue() == maxValue){
                System.out.println("The vegetable has most carlories is: " + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let's make a salad");
        System.out.print("how many vegetables you want put in salad: ");
        int r = scanner.nextInt();
        int c = 2;
        scanner.nextLine();
        System.out.println("vegetables options: pepper, cabbage , tomato, cucumber, ice plant, please input the vegetable name first, press enter, then its grams");
        String[][] vegetables = new String[r][2];
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                vegetables[i][j] = scanner.nextLine();
            }
        }
        scanner.nextLine();
        // System.out.println(vegetables);

        System.out.println("how many flavors you want to put in  salad: ");
        int row = scanner.nextInt();
        String[][] flavors = new String[row][2];
        scanner.nextLine();
        System.out.println("flavors options: oil, salad dressing , honey, please input the flavor name first, press enter, then its grams");
        for(int i = 0; i<row; i++){
            for(int j = 0; j<c; j++){
                flavors[i][j] = scanner.nextLine();
            }
        }
        // System.out.println(flavors);
        scanner.close();
  
        // String[][] vegetables = { {"pepper", "10"}, {"tomato", "10"}, {"cucumber", "5"}, {"salad dressing", "10"}};
        // String[][] flavors = {{"salad dressing", "10"}, {"honey", "5"}};
        // make salad:
        System.out.println("Now let's make the salad: add vegetables and flavors together...");
        Map<String, Integer> salad = makeSalad(vegetables, flavors);
        System.out.print(salad);
        // Sort the salad by calcories of each:
        sortVegetables(salad);
        // Search the vegetables contain most calories:
        searchVegetables(salad);
    }
}