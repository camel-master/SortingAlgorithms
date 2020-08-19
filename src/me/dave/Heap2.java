package me.dave;

import java.util.ArrayList;


// Java implementation of Min Heap
public class Heap2 {
//    private int[] Heap;
    private ArrayList<Integer> Heap;
    private int size;
    private int maxsize;

    private static final int FRONT = 1;

    public Heap2()
    {
//        this.maxsize = maxsize;
        this.size = 0;
//        Heap = new int[this.maxsize + 1];
        Heap = new ArrayList<Integer>();
//        Heap[0] = Integer.MIN_VALUE;
        Heap.add(0, Integer.MIN_VALUE);
    }

    // Function to return the position of
    // the parent for the node currently
    // at pos
    private int parent(int pos)
    {
        return pos / 2;
    }

    // Function to return the position of the
    // left child for the node currently at pos
    private int leftChild(int pos)
    {
        return (2 * pos);
    }

    // Function to return the position of
    // the right child for the node currently
    // at pos
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }

    // Function that returns true if the passed
    // node is a leaf node
    private boolean isLeaf(int pos)
    {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    // Function to swap two nodes of the heap
    private void swap(int fpos, int spos)
    {
        int tmp;
//        tmp = Heap[fpos];
        tmp = Heap.get(fpos);
//        Heap[fpos] = Heap[spos];
        Heap.set(fpos, Heap.get(spos));
//        Heap[spos] = tmp;
        Heap.set(spos, tmp);
    }

    // Function to heapify the node at pos
    private void minHeapify(int pos)
    {

        // If the node is a non-leaf node and greater
        // than any of its child
        if (!isLeaf(pos)) {
//            if (Heap[pos] > Heap[leftChild(pos)]
            if (Heap.get(pos) > Heap.get(leftChild(pos))
                    || Heap.get(pos) > Heap.get(rightChild(pos))) {

                // Swap with the left child and heapify
                // the left child
//                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                if (Heap.get(leftChild(pos)) < Heap.get(rightChild(pos))) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }

                // Swap with the right child and heapify
                // the right child
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    // Function to insert a node into the heap
    public void insert(int element)
    {
//        if (size >= maxsize) {
        if(size >= Heap.size()) {
            return;
        }
        Heap.add(++size,element);
        int current = size;

        while (Heap.get(current) < Heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Function to print the contents of the heap
    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap.get(i)
                    + " LEFT CHILD : " + Heap.get(2 * i)
                    + " RIGHT CHILD :" + Heap.get(2 * i + 1));
            System.out.println();
        }
    }

    // Function to build the min heap using
    // the minHeapify
    public void minHeap()
    {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    // Function to remove and return the minimum
    // element from the heap
    public int remove()
    {
        int popped = Heap.get(FRONT);
        Heap.set(FRONT,Heap.get(size--));
        minHeapify(FRONT);
        return popped;
    }
}
