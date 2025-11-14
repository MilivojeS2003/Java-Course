package Graf;
import java.util.*;

public class Graph {
    
    ArrayList<LinkedList<Node>> alist;

    Graph(){
        alist = new ArrayList<>();
    }

    public void addNode(Node node){
        LinkedList<Node> currentList = new LinkedList<>();
        currentList.add(node); // prvo u LinkedListu dodajemo cvoroce
        alist.add(currentList); // tu listu dodam u ArrayListu
    }

    public void addEdge(int src, int dst){
        LinkedList<Node> currentList = alist.get(src); // uzimamo listu cvora iz kojeg krecemo !!! VAZNO UZIMO LISTU
        Node dstNode = alist.get(dst).get(0); // uzima cvor ka kojem idemo !!! VAZNO ODJE NE UZIMAMO NIZ VEC ELEMENZT
        currentList.add(dstNode); /// ELEMENAT KOJI SMO UZELI STAVLJAMO U NIZ!!!
    }

    public boolean checkEdge(int src, int dst){
        LinkedList<Node> currentList = alist.get(src);
        Node dstNode = alist.get(dst).get(0); 

        for(Node node:currentList){
            if(node==dstNode){
                return true;
            }
        }
        return false;
    }

    public void printList(){
        for(LinkedList<Node> currentList:alist){
            System.out.println(currentList.get(0).data);
        }
    }

    public void print(){
        for(LinkedList<Node> currentList:alist){
            for(Node node:currentList){
                System.out.print(node.data + " -> ");
            }
            System.out.println("");
        }
    }
}
