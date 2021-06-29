import java.util.Arrays;
/**
 * @author Efe Kerem Kesgin
 * @version 05/10/2020
 */
public class IntBag {
    private int[] bag;
    /**
     * a constructor that creates an array
     * length of four with values of -1
     */
    public IntBag() {
        bag = new int[4];
        fill();
    }
    /**
     * a get method for array
     *
     * @return bag
     */
    public int[] getBag() {
        return bag;
    }
    /**
     * a get method which adds the values
     * into the array
     *
     * @param num
     */
    public void add(int num) {
        int count = 0;
        for (int x : bag) {
            if (x == -1) {
                count++;
            }
        }
        if (count == 0) {
            int prevSize = this.bag.length;
            this.bag = Arrays.copyOf(bag, 2 * bag.length);
            for (int i = bag.length - 1; i >= prevSize; i--) {
                bag[i] = -1;
            }
        }
        for (int i = 0; i < this.bag.length; i++) {
            if (this.bag[i] == -1) {
                bag[i] = num;
                return;
            }
        }
    }
    /**
     * a get method which adds the values
     * into the specific index
     *
     * @param num
     * @param index
     */
    public void add(int num, int index) {
        if (index > bag.length - 1 || (bag[bag.length - 1] != -1 || (index == (bag.length - 1)))) {
            int prevSize = this.bag.length;
            this.bag = Arrays.copyOf(bag, 2 * bag.length);
            for (int i = bag.length - 1; i >= prevSize; i--) {
                bag[i] = -1;
            }
        }
        for (int i = bag.length - 1; i > index; i--) {
            bag[i] = bag[i - 1];
        }
        bag[index] = num;
    }
    /**
     * a get method which looks for the number
     * and check if it is there or not
     *
     * @param num
     * @return true or false
     */
    public boolean test(int num) {
        boolean flag = false;
        for (int i = 0; i < bag.length; i++) {
            if (bag[i] == num)
                flag = true;
        }
        return flag;
    }
    /**
     * a get method which removes the item in
     * that index
     *
     * @param index
     */
    public void remove(int index) {
        int pos = 0;
        for (int i = bag.length - 1; i > 0; i--) {
            if (bag[i] != -1) {
                pos = i;
                break;
            }
        }
        bag[index] = bag[pos];
        bag[pos] = -1;
        bag = Arrays.copyOf(this.bag, (this.bag.length - 1));
    }
    /**
     * a get method which removes all the specific
     * number in that array
     *
     * @param num
     */
    public void removeAll(int num) {
        int[] arr = new int[bag.length];
        int count = 0;
        for (int i = 0; i < bag.length; i++) {
            if (this.bag[i] != num) {
                arr[count] = bag[i];
                count++;
            }
        }
        bag = Arrays.copyOf(arr, count);
    }
    /**
     * a get method which returns the
     * number of values currently in the collection
     * @return size
     */
    public int size() {
        int size = 0;
        for(int i = 0; i < bag.length; i++) {
            if(this.bag[i] > 0 ) {
                size++;
            }
        }
        return size;
    }
    /**
     * a get method which returns the number
     * in that index
     *
     * @param index
     * @return integer
     */
    public int getElement(int index) {
        if (index <= this.bag.length - 1) {
            return this.bag[index];
        } else
            return -1;
    }
    /**
     * a get method which fill all the array
     * with value of -1
     */
    public void fill() {
        for (int i = 0; i < bag.length; ++i) {
            this.bag[i] = -1;
        }
    }
    @Override
    public String toString() {
        return "bag =" + Arrays.toString(bag);
    }
}
