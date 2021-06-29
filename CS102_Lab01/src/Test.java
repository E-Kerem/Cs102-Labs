/**
 * @author Efe Kerem Kesgin
 * @version 05/10/2020
 */
public class Test {
    public static void main(String[] args) {
        IntBag a1 = new IntBag();
        System.out.println(a1);
        a1.add(1);
        System.out.println(a1);
        a1.add(3);
        System.out.println(a1);
        a1.add(1);
        a1.add(76);
        a1.add(23);
        a1.remove(3);
        System.out.println(a1);
        /**
         * Fibonacci Part
         *
         */
        a1 = new IntBag();
        System.out.println(a1);
        a1.add(0);
        a1.add(1);
        System.out.println(a1);
        for (int i = 0; i < 39; i++) {
            a1.add(a1.getElement(i) + a1.getElement(i + 1));
        }
        a1.removeAll(-1);
        System.out.println(a1);
    }
}
