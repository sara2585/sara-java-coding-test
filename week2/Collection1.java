import java.util.*;

public class Collection1 {
    //Fill with 'size' elements, start counting at 'start':
    public static Collection<String> fill(Collection<String> c, int start, int size) {
        for(int i = start; i < start+size; i++)
            c.add(Integer.toString(i));
        return c;
    }
    //Default to a "start" fo 0:
    public static Collection<String> fill(Collection<String> c, int size) {
        return fill(c, 0, size);
    }
    // Default to 10 elements:
    public static Collection<String> fill(Collection<String> c) {
        return fill(c, 0, 10);
    }
    //Create & upcast to Collection:
    public static Collection<String> newCollection() {
        return fill(new ArrayList<String>());
    }
    // Fill a Collection with a range of values:
    public static Collection<String> newCollection(int start, int size) {
        return fill(new ArrayList<>(), start, size);
    }
    //Moving through a List with an iterator:
    public static void print(Collection<String> c) {
        for(Iterator<String> x  = c.iterator(); x.hasNext();)
            System.out.println(x.next() + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        Collection<String> c = newCollection();
        c.add("ten");
        c.add("evelen");
        print(c);
        // Make an array from the List:
        // Object[] array = c.toArray();
        //Make a String array from the List:
        // String[] str = (String[])c.toArray(new String[1]);
        System.out.println("Collections.max(c) = " + Collections.max(c));
        System.out.println("Collections.min(c) = " + Collections.min(c));
        // Add a Collection to another Collection
        c.addAll(newCollection());
        print(c);
        c.remove("3");
        print(c);
        c.remove("3");
        c.removeAll(newCollection());
        print(c);
        // Is an element in this Collection?
        System.out.println("c.contains(\"4\") = " + c.contains("4"));
        //Is a Collection in this Collection?
        System.out.println("c.containsAll(newCollection()) =  " + c.containsAll(newCollection()));
        Collection<String> c2 = newCollection(5, 3);
        //Keep all the elements that are in c and c2:
        c.retainAll(c2);
        print(c);
        //Throw away all the elements in c that also appear in c2:
        c.removeAll(c2);
        System.out.println("c.isEmpty() = " + c.isEmpty());
        c = newCollection();
        print(c);
        c.clear(); //remove all elements
        System.out.println("after c.clear()");
        print(c);

    }
}
