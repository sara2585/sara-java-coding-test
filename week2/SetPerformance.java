//SetPerformance.java
// Demonstrate performance differences in Sets
import java.util.*;

public class SetPerformance {
    private static final int REPS = 200;
    private abstract static class Tester {
        String name;
        Tester(String name) {this.name = name;}
        abstract void test(Set<String> s, int size);
    }
    private static Tester[] tests = {
        new Tester("add") {
            void test(Set<String> s, int size) {
                for(int i = 0; i < REPS; i++) {
                    s.clear();
                    Collection1.fill(s, size);
                }
            }
        },
        new Tester("contains") {
            void test(Set<String> s, int size) {
                for(int i = 0; i < REPS; i++) {
                    for(int j = 0; j < size; j++) {
                        s.contains(Integer.toString(j));
                    }
                }
            }
        },
        new Tester("iteration") {
            void test(Set<String> s, int size) {
                for(int i = 0; i < REPS * 10; i++) {
                    Iterator<String> it = s.iterator();
                    while(it.hasNext())
                        it.next();
                }
            }
        },
        new Tester("remove") {
            void test(Set<String> s, int size) {
                for(int i = 0; i < REPS * 10; i++) {
                    Iterator<String> it = s.iterator();
                    while(it.hasNext()){
                        it.next();
                        it.remove();
                    }

                }

            }
        },

    };
    public static void test(Set<String> s, int size) {
        // A trick to print out the class name:
        System.out.println("Testing" + s.getClass().getName());
        Collection1.fill(s, size);
        for(int i = 0; i < tests.length; i++) {
            System.out.print(tests[i].name);
            long t1 = System.currentTimeMillis();
            tests[i].test(s, size);
            long t2 = System.currentTimeMillis();
            System.out.println(":" + ((double)(t2-t1)/(double)size));
        }
    }
    public static void main(String[] args) {
        // Small:
        test(new TreeSet<>(), 10);
        test(new HashSet<>(), 10);
        // Large:
        test(new TreeSet<>(), 1000);
        test(new HashSet<>(), 1000);
    }
}
