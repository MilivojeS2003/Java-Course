import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Algoritmi {
    public static void main(String args[]){
        
        System.out.println("*************************");
        System.out.println(" --- STACK ----");
        System.out.println("*************************");

        // Stack ili LIFO -> Last Input First Output
        Stack<String> stack = new Stack<>();

        System.out.println(stack.empty());

        stack.push("Milenko");
        stack.push("Micko");
        stack.push("NIkola");
        stack.push("Darko");
        System.out.println(stack);

        String x = stack.pop();
        
        System.out.println(x);
        System.out.println(stack);

        System.out.println(stack.search("monika"));
        System.out.println(stack.search("Milenko"));


        //QUEUE ili FIFO -> First Input First Output

        // add = enqueue, offer()
        // remove = dequeue, poll()

        System.out.println("*************************");
        System.out.println(" --- QUEUE ----");
        System.out.println("*************************");

        Queue<String> queue =   new LinkedList<String>();

        queue.offer("Micko");
        queue.offer("Nikola");
        queue.offer("Darko");

        System.out.println(queue);
        
        queue.poll();
        System.out.println(queue);

        System.out.println("*************************");
        System.out.println(" --- LinkedList ----");
        System.out.println("*************************");

        LinkedList<String> list = new LinkedList<>();

        // Ponasa se kao stack
        
        /*list.push("A");
        list.push("B");
        list.push("C");
        list.push("D");
        list.push("E");
        list.pop();
        System.out.println(list);
         */


        // Ponasa se kao queue
        list.offer("B");
        list.offer("C");
        list.offer("D");
        list.offer("E");
        list.poll();

        System.out.println(list);

        System.out.println("*************************");
        System.out.println(" --- DinamyArray ----");
        System.out.println("*************************");
        
        // U Pythonu to je List, U javi ArrayList


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
        System.out.println("OVO JE NOVI NIZ"  + dynamiArray);

        dynamiArray.delete("X");
        System.out.println("OVO JE NOVI NIZ"  + dynamiArray);

        System.out.println("PRETRAGA U NIZ:"  + dynamiArray.sreach("A"));


    }
}
