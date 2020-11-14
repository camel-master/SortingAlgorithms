package me.dave;

public class InsertISorter extends Sorter {

    @Override
    public void sort(int[] arr) {
        for(int i=1; i<arr.length; i++) {
            for(int j=i; j>0; j--) {
                if(arr[j-1]>arr[j]) {   //arr[j-1]<arr[j] 로 DESC
                    swap(arr, j-1, j);
                }
            }
        }
    }
}
