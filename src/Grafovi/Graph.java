package Grafovi;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    ArrayList<Node> nodes;
    int[][] matrix;

    Graph(int size){
        matrix = new int[size][size];
    }

    public void addNode(Node node){
        nodes.add(node);
    }

    public void addEdge(int src, int dest){
        matrix[src][dest] = 1;
    }

    public boolean checkEdge(int src, int dest){
        if(matrix[src][dest] == 1){
            return true;
        }
        return false;
    }

    public void print(){
        IO.print(" ");
        for(Node node: nodes){
            IO.print(node.data + " ");
        }
        for(int i=0;i<matrix.length;i++){
            IO.print(nodes.get(i).data + " ");
            for(int j=0;j<matrix[i].length;j++){
                IO.print(matrix[i][j]+" ");
            }
            IO.println("");
        }
    }

}
