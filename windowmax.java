import java.util.*;

public class windowmax{
    static class Pair implements Comparable<Pair>{
        int num;
        int idx;

        public Pair(int num , int idx){
            this.num = num;
            this.idx = idx;

        }

        @Override
        public int compareTo(Pair p2){
            //for ascending
            //return this.num - p2.num

            //for descending
            return p2.num - this.num;
        }
    }
    public static void main(String args[]){
        int arr[] ={ 1,3,-1,-3,5,3,6,7 };
        int k=3;   //window size
        int res[] = new int[arr.length-k+1];   //new array

        PriorityQueue<Pair> pq = new PriorityQueue<>();  

        for(int i=0;i<k;i++){
            pq.add(new Pair(arr[i] , i));    //add first three ele
        }

        res[0] = pq.peek().num;    //peek is maximum

        for(int i=k;i<arr.length;i++){
            while(pq.size()>0 && pq.peek().idx <= (i-k)){
                pq.remove();      //remove ee not in window
            }
            pq.add(new Pair(arr[i] , i));   // add new ele
            res[i-k+1] = pq.peek().num;     // add max peek
        }

        for(int i=0;i<res.length ; i++){
            System.out.print(res[i]+ " ");
        }


    }
}