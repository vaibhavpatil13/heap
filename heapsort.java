import java.util.*;

public class heapsort{
    public static void heapify(int arr[] , int i , int size){
        int left = 2*i +1;
        int right = 2*i +2;
        int maxidx = i;

        if(left < size && arr[left] > maxidx){
            maxidx = left;
        }
        if(right < size && arr[right] > maxidx){
            maxidx = right;
        }

        if(maxidx != i){
            int temp = arr[i];
            arr[i]  = arr[maxidx];
            arr[maxidx] = temp;

            heapify(arr , maxidx ,size);
        }
    }
    public static void sort(int arr[] ){
        //build max heap
        int n = arr.length;

        for(int i=n/2 ; i>=0 ;i--){
            heapify(arr,i , n);
        }

        //push first ele to last
        for(int i= n-1 ;i>0 ;i--){
            //swap larget first with last
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr ,0 ,i);
        }
    }
    public static void main(String args[]){
        int arr[] = { 1,2,4,5,3};

        sort(arr);

        for(int i=0 ;i<arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
    }
}