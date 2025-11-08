import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Algoritmi {

    public static void main(String[] args) {

        System.out.println("*************************");
        System.out.println(" --- STACK ----");
        System.out.println("*************************");

        Stack<String> stack = new Stack<>();
        System.out.println(stack.empty());

        stack.push("Milenko");
        stack.push("Micko");
        stack.push("Nikola");
        stack.push("Darko");
        System.out.println(stack);

        String x = stack.pop();
        System.out.println(x);
        System.out.println(stack);

        System.out.println(stack.search("monika"));   // -1 ako ne postoji
        System.out.println(stack.search("Milenko"));  // pozicija od vrha (1-based)

        // QUEUE (FIFO)
        System.out.println("*************************");
        System.out.println(" --- QUEUE ----");
        System.out.println("*************************");

        Queue<String> queue = new LinkedList<>();
        queue.offer("Micko");
        queue.offer("Nikola");
        queue.offer("Darko");
        System.out.println(queue);

        queue.poll();
        System.out.println(queue);

        // LinkedList
        System.out.println("*************************");
        System.out.println(" --- LinkedList ----");
        System.out.println("*************************");

        LinkedList<String> list = new LinkedList<>();

        // Kao queue
        list.offer("B");
        list.offer("C");
        list.offer("D");
        list.offer("E");
        list.poll();
        System.out.println(list);

        System.out.println("*************************");
        System.out.println(" --- DynamicArray ----");
        System.out.println("*************************");

        // Pretpostavljam da imate svoju klasu DynamicArray sa poljima size/capacity i metodama add/insert/delete/sreach
        DynamicArray dynamiArray = new DynamicArray(5);
        System.out.println(dynamiArray.capacity);
        dynamiArray.add("A");
        dynamiArray.add("B");
        dynamiArray.add("C");
        dynamiArray.add("D");
        dynamiArray.add("E");
        dynamiArray.add("F");

        System.out.println("OVO JE SIZE: " + dynamiArray.size + " OVO JE KAPACITET: " + dynamiArray.capacity);
        System.out.println(dynamiArray.toString());
        System.out.println(dynamiArray);

        dynamiArray.insert(0, "X");
        System.out.println("OVO JE NOVI NIZ " + dynamiArray);

        dynamiArray.delete("X");
        System.out.println("OVO JE NOVI NIZ " + dynamiArray);

        System.out.println("PRETRAGA U NIZ: " + dynamiArray.sreach("A"));

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

        int index = linearSreach(array, 1);
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }

        int idx2 = binarySreach(array, 12);
        if (idx2 != -1) {
            System.out.println("Element (bin) at index: " + idx2);
        } else {
            System.out.println("Element (bin) not found");
        }

        int idx3 = interpolationSreach(array,2);
        System.out.println("Interpolation Sreach: " + idx3);
    }

    // ispravljeno: vraća indeks
    private static int linearSreach(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i; // indeks, ne vrijednost
            }
        }
        return -1;
    }

    // ispravljeno: granice i pomaci
    private static int binarySreach(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = array[mid];

            System.out.println("Middle: " + value);
            if (value < target) {
                low = mid + 1;    
            } else if (value > target) {
                high = mid - 1; 
            } else {
                return mid; 
            }
        }
        return -1;
    }

    private static int interpolationSreach(int[] array, int value){
        int low = 0;
        int high = array.length - 1;

        while(value > array[low] && value < array[high] && low <= high){
            int probe = low + (high-low) * (value - array[low]) / (array[high] - array[low]);
            System.out.println("Probe: " + probe);

            if(array[probe] == value){
                return probe;
            }
        }
        return 0;
    }
}
