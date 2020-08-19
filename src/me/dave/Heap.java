package me.dave;

import java.util.ArrayList;

public class Heap {
    private ArrayList<Integer> nodeList;
    public Heap() {
        this.nodeList  = new ArrayList<Integer>();
        nodeList.add(Integer.MIN_VALUE);
    }
    public void insert(Integer node) {
        this.nodeList.add(node);

        int index = nodeList.size()-1;
        while(index > 0) {
            Integer temp;
            if(index == 1) {
                break;
            }
            if(nodeList.get(index) < nodeList.get(index/2)) {
                temp = nodeList.get(index);
                nodeList.set(index, nodeList.get(index/2));
                nodeList.set(index/2, temp);
            } else {
                break;
            }
            index /= 2;
        }
    }
    public Integer peek() {
        return nodeList.get(1);
    }
    public Integer remove() {
        Integer top = nodeList.get(1);
        nodeList.set(1, nodeList.get(nodeList.size()-1));
        nodeList.remove(nodeList.size()-1);

        int index = 1;
        if(nodeList.size()-1 == 2 && nodeList.get(1) > nodeList.get(2)) {
            Integer temp = nodeList.get(1);
            nodeList.set(1, nodeList.get(2));
            nodeList.set(2, temp);
        }
        while(index*2 < nodeList.size()-1) {
            if(nodeList.get(index) > nodeList.get(index*2) || nodeList.get(index) > nodeList.get(index*2+1)) {
                Integer temp = nodeList.get(index);
                if (nodeList.get(index * 2) > nodeList.get(index * 2 + 1)) {
                    nodeList.set(index, nodeList.get(index*2+1));
                    nodeList.set(index*2+1, temp);
                    index = index*2+1;
                } else {
                    nodeList.set(index, nodeList.get(index*2));
                    nodeList.set(index*2, temp);
                    index *= 2;
                }
            } else {
                break;
            }
        }
        return top;
    }

    public ArrayList<Integer> getNodeList() {
        return nodeList;
    }

    public void printHeap(){
        for(int i=1; i<nodeList.size(); i++) {
            System.out.print(nodeList.get(i) +", ");
        }
        System.out.println();
    }
}
