package github.algorithms.assignment.symbol_table;

/**
 * Find values such that (a==b) is true but a.equals(b) is false
 * Find values such that (a==b) is false but a.equals(b) is true
 */
public class AutoboxingEqual {

    public static void main(String[] args) {
        double x1 = 0.0, y1 = -0.0;
        Double a1 = x1, b1 = y1;
        System.out.println(x1 == y1);
        System.out.println(a1.equals(b1));

        double x2 = 0.0 / 0.0, y2 = 0.0 / 0.0;
        Double a2 = x2, b2 = y2;
        System.out.println(x2 == y2);
        System.out.println(a2.equals(b2));
    }
}
