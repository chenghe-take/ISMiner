import java.util.Arrays;
import java.util.List;

public class Itemset implements Comparable<Itemset> {
    /** use an array to store all items */
    private int[] items;
    private int size;

    public Itemset(List<Integer> prefixItems, Integer newItem) {
        size = prefixItems.size() + 1;
        items = new int[size];
        for (int i = 0; i < prefixItems.size(); i++) {
            items[i] = prefixItems.get(i);
        }
        items[size-1] = newItem;
        Arrays.sort(items);
    }

//    public Itemset(int n) {
//        size = 1;
//        items = new int[size];
//        items[0] = n;
//    }

    public Itemset(String str) {
        String newStr = str.substring(1, str.length()-1);
        String[] splitItems = newStr.split(",");
        size = splitItems.length;
        items = new int[size];
        for (int i = 0; i < size; i++) {
            items[i] = Integer.parseInt(splitItems[i]);
        }
        Arrays.sort(items);
    }

    public int[] getItems() {
        return items;
    }

    public int getItemAT(int i) {
        return items[i];
    }

    public int getSize() {
        return size;
    }

    public boolean isSupersetOf(Itemset another) {
        int thisLength = this.items.length;
        int anotherLength = another.size;
        int[] anotherItems = another.items;
        if (thisLength < anotherLength)
            return false;
        int i = 0, j = 0;
        while (i < thisLength && j < anotherLength) {
            if (this.items[i] > anotherItems[j]) {
                return false;
            } else if (this.items[i] == anotherItems[j]) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return (i == thisLength && j == anotherLength) || i != thisLength;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i : items) {
            sb.append(i).append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(")");
        return sb.toString();
    }

    public static void main(String[] args) {
        //test if isSuperset() is right
        Itemset itemset1 = new Itemset("(4,5,1)");
        Itemset itemset2 = new Itemset("(1,5)");
        System.out.println(itemset1.isSupersetOf(itemset2));
    }


    /**
     * This method implement interface of Comparable by lexicographical order.
     * @param o object to be compared
     * @return 1, 0, -1 if this object is larger, equal, less than that object
     */
    @Override
    public int compareTo(Itemset o) {
        if (o == null)
            return 1;
        if (!(o instanceof Itemset))
            return 1;
        Itemset that = (Itemset) o;
        int commeonL = this.size > that.getSize() ? that.getSize(): this.size;
        for (int i = 0; i < commeonL; i++) {
            if (this.items[i] < that.getItemAT(i))
                return -1;
            else if(this.items[i] > that.getItemAT(i))
                return 1;
        }
        return this.size - that.getSize();
    }
}
