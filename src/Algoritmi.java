import java.util.Arrays;
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

        int[] array2 = {2,4,8,16,32,64,128,256,512,1024};
        int idx4 = interpolationSreach(array2,1024);
        System.out.println("Interpolation Sreach on Array2: " + idx4);

        System.out.println("*************************");
        System.out.println(" --- Bubble Sort ----");
        System.out.println("*************************");

        int[] array3 = {9,10,8,1,32,100,43,90,2};
        bubbleSort(array3);
        selectedSort(array3);
        insertionSort(array3);

        IO.println("\n0VO JE FAKTORIAL:");
        IO.println(factorial(7));

        IO.println("0VO JE je stepen:");
        IO.println(power(2,4));

        mergeSort(array3);
        IO.println("Ovo je niz posle Merge Sort-a: " + Arrays.toString(array3));

        System.out.println("*************************");
        System.out.println(" --- Quick Sort ----");
        System.out.println("*************************");

        int[] array4 = {9,10,8,1,32,100,43,90,2,87,120};

        quickSort(array4,0, array4.length - 1);
        IO.println("Ovo je niz posle Quick Sort-a: " + Arrays.toString(array4));


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

        while(value >= array[low] && value <= array[high] && low <= high){
            int probe = low + ((high-low) * (value - array[low])) / (array[high] - array[low]);
            System.out.println("Probe: " + probe + " High: " + high + " Low: " + low);

            if(array[probe] == value){
                return probe;
            }else if(array[probe] < value){
                low = probe+1;
            }else{
                high = probe-1;
            }
        }
        return -1;
    }

    public static void bubbleSort(int[] array){
        //int temp = array.get(0);
        // {9,10,8,1,32,100,43,90,2}
        int temp;
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length - i -1;j++){
                if(array[j+1] < array[j]){
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.println("Konacan niz je:");
        for(int num:array){
            System.out.print(num + " ");
        }
    }

    public static void selectedSort(int[] array){
        //int min = array[0];
        int temp;
        // int pos=0;
        for(int i=0;i<array.length-1;i++){
            int min = array[i];
            int pos = i;
            for(int j=i+1; j<array.length-1;j++){
                if(array[j] < min){
                    min = array[j];
                    pos = j;
                }
            }
            temp = array[i];
            array[i] = array[pos];
            array[pos] = temp;
        }
        System.out.println("Konacan niz za Select Sort je: ");
        for(int num:array){
            System.out.print(num + " ");
        }

    }

    // {9,10,8,1,32,100,43,90,2}
    public static void insertionSort(int[] array){
        int temp;
        int t;
        for(int i=1;i<array.length-1;i++){
            temp = array[i];
            int j = i-1;
            // for(int j=i-1;j>=0;j--){
            //     if(temp < array[j]){
            //         t = temp;
            //         temp = array[j];
            //         array[j] = t;
            //     }else{
            //         break;
            //     }
            while(j >= 0 && array[j] > temp){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = temp;
            }
        System.out.println("Konacan niz za Insertion Sort je: ");
        for(int num:array){
            System.out.print(num + " ");
        }
    }

    private static int factorial(int num){
        if(num < 1) return 1;
        return num * factorial(num-1);
    }

    private static int power(int base,int exponent){
        if(exponent <  1) return 1;
        return base * power(base, exponent - 1);
    }

    private static void mergeSort(int[] array){
        int length = array.length;
        if(length <= 1) return; // base case

        int middle = length/2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length-middle];

        int i=0; //left array
        int j=0; // right array


        // punimo nizove left i rght
        for(i=0; i<length;i++){
            if(i < middle){
                leftArray[i] = array[i];
            }else{
                rightArray[j] = array[i];
                j++;
            }

        }

        // Ključna tačka rekurzije: Pozivamo istu funkciju na manjim nizovima
        IO.println("Dijelimo nizove na: " + Arrays.toString(leftArray) + " i na: " + Arrays.toString(rightArray));
        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(array,leftArray,rightArray);
    }

    private static void merge(int[] array,int[] leftArray,int[] rightArray){
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int i=0 , l = 0, r = 0;

        while(l < leftSize && r < rightSize){
            if(leftArray[l] <= rightArray[r]){
                array[i] = leftArray[l];
                i++;
                l++;
            }else{
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while(l < leftSize){
            array[i] = leftArray[l];
            i++;
            l++;
        }

        while(r < rightSize){
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }

    private static void quickSort(int [] array, int start, int end){

        if(start >= end) return; // BASE CASE

        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1); // rekuzivni poziv za end = pivot - 1 -> lijeva strana pivora
        quickSort(array, pivot + 1, end); // rekuzivni pozvi za start = pivot + 1 -> desna strana pivota

    }

    private static int partition(int [] array, int start, int end){

        int pivot = array[end];
        int i = start - 1;

        for(int j = start; j< end; j++){
            if(array[j] <= pivot){
                i++;
                // Pivot je veci od elementa na poziciji J zamjeni elemente sa pozicijama I i J
                IO.println(array[i] + " < " + pivot + " Mijenjamo : " + array[j] + " i " + array[i]);
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                IO.println("SAD IMAMO: " + Arrays.toString(array));

            }
        }
        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i;

    }







}
