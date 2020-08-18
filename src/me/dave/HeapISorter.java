package me.dave;

import java.util.PriorityQueue;

public class HeapISorter extends Sorter {

    //private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    private Heap minHeap = new Heap();
    //private Heap2 minHeap = new Heap2(10000002);
    @Override
    public void sort(int[] arr) {
        for(int i=0; i < arr.length-1; i++) {
            //this.minHeap.add(arr[i]);
            this.minHeap.insert(arr[i]);
        }
        for(int i=0; i < arr.length-1; i++) {
            arr[i] = this.minHeap.remove();
        }
    }
}
