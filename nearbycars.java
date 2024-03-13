import java.util.*;

public class nearbycars{
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int distsq;
        int idx;

        public Point(int x , int y , int distsq , int idx){
            this.x = x;
            this.y = y;
            this.distsq = distsq;
            this.idx =idx;
        }

        @Override
        public int compareTo(Point p2){
           return this.distsq - p2.distsq ;
        }
    }
    public static void main(String args[]){
        int points[][] = {{3,3} ,{5,-1} ,{-2,4}};
        int k=2;

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for(int i=0 ;i <points.length ; i++){
            int distsq = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            pq.add(new Point(points[i][0] , points[i][1] , distsq , i));
        }

        for(int i=0 ;i<k;i++){
            System.out.print("C"+pq.remove().idx+" ");
        }

    }
}