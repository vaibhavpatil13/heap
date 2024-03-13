import java.util.*;

public class insert{
    static class Heap{
        ArrayList<Integer> list = new ArrayList<>();

        public void add(int data){
            list.add(data);

            int x = list.size()-1;   //index of child
            int y = (x-1)/2 ;       //index of parent

            while(list.get(x)<list.get(y)){
                //swap
                int temp = list.get(x);
                list.set(x , list.get(y));
                list.set(y , temp);

                x = y;
                y = (x-1)/2;
            }
        }

        public int peek(){
            return list.get(0);
        }

        private void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int min = i;
            if(left < list.size() && list.get(min)>list.get(left)){
                min = left;

            }
            if(right < list.size() && list.get(min)>list.get(right)){
                min = right;
            }
            if(min!=i){
                int temp = list.get(i);
                list.set(i , list.get(min));
                list.set(min , temp);
                heapify(min);
            }


        }

        public int remove(){
            int data = list.get(0);  //first ele

            //swap
            int temp = list.get(0);
            list.set(0 , list.get(list.size()-1));
            list.set(list.size()-1 , temp);

            list.remove(list.size()-1);

            heapify(0);
            return data;

        }

        public boolean isEmpty(){
            return list.size() ==0;
        }
    }
    public static void main(String args[]){

        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(5);
        h.add(1);

        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }

    }
}