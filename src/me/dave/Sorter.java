package me.dave;

public class Sorter implements ISorter {

    @Override
    public void sort(int[] arr) {

    }

    @Override
    public void sort(int[] arr, int startIndex, int endIndex) {

    }

    @Override
    public void sort(int[] arr, int[] tmp, int startIndex, int endIndex) {

    }

    @Override
    public void swap(int[] arr, int frontIndex, int rearIndex) {
        int tmp = arr[frontIndex];
        arr[frontIndex] = arr[rearIndex];
        arr[rearIndex] = tmp;
    }
}
