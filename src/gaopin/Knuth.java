package gaopin;

/**
 * 完美洗牌
 */
public class Knuth {
    // this class should not be instantiated
    private Knuth() { }

    /**
     * Rearranges an array of objects in uniformly random order
     * (under the assumption that {@code Math.random()} generates independent
     * and uniformly distributed numbers between 0 and 1).
     * @param a the array to be shuffled
     */
    public static void shuffle(Object[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // choose index uniformly in [0, i]
            //唯一修改的就是随机牌 j选取的方法，在拿起第i张牌时，只从它前面的牌随机选出j，而不是从整副牌里面随机选取。
            int r = (int) (Math.random() * (i + 1));
            Object swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }

    /**
     * Rearranges an array of objects in uniformly random order
     * (under the assumption that {@code Math.random()} generates independent
     * and uniformly distributed numbers between 0 and 1).
     * @param a the array to be shuffled
     */
    public static void shuffleAlternate(Object[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // choose index uniformly in [i, n-1]
            int r = i + (int) (Math.random() * (n - i));
            Object swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }

    /**
     * Reads in a sequence of strings from standard input, shuffles
     * them, and prints out the results.
     *
     * @param args the command-line arguments
     */
    //public static void main(String[] args) {
    //
    //    // read in the data
    //    String[] a = StdIn.readAllStrings();
    //
    //    // shuffle the array
    //    Knuth.shuffle(a);
    //
    //    // print results.
    //    for (int i = 0; i < a.length; i++)
    //        StdOut.println(a[i]);
    //}
}
