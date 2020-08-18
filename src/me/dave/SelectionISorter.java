package me.dave;

public class SelectionISorter extends Sorter {

    @Override
    public void sort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int minValue = arr[i];
            int minIndex = i;
            for(int j = i; j < arr.length; j++) {
                if(arr[j] < minValue) {
                    minValue = arr[j];
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }
}
