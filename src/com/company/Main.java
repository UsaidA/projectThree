package com.company;

public class Main {

    public static int getLeftChildIndex(int parentIndex){
        return 2 * parentIndex ;
    }
    public static int getRightChildIndex(int parentIndex){
        return 2* parentIndex + 1 ;
    }
    public static int getParentIndex(double childIndex){
        double x = childIndex / 2;
        Math.floor(x);
        int y = (int) x;
        return y;
    }



    public static void main(String[] args) {

        String[] jobDesc = {"EEE","GGG","CCC","DDD","BBB","FFF","AAA"};
        int[] priority = {4,5,2,4,2,4,1,1,1};

        int node = 2;


        int components = priority.length;
        int[] heap = new int[components + 1 ];
        heap[1] = priority[0];


        for (int y = 1; y < components ; y ++){
            int tempOne = node;
            heap[node] = priority[y];
           while(heap[node] < heap[getParentIndex(node)] && node != 0){
               int temp = heap[node];
               heap[node] = heap[getParentIndex(node)];
               heap[getParentIndex(node)] = temp;
               node = getParentIndex(node);
           }
            node = tempOne;
           if(heap[node] > heap[getParentIndex(node)]){
               heap[node] = priority[y];
           }
           node = node +1;
          
        }

        //System.out.println((heap[getParentIndex(5)]));
        //System.out.println(node);
        for(int x = 1 ; x < components+ 1; x ++){
            System.out.println(heap[x]);
        }

        //System.out.println( heap[8]);





    }


}
