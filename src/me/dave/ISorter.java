package me.dave;

public interface ISorter {
    void sort(int[] arr);
    void sort(int[] arr, int startIndex, int endIndex);
    void sort(int[] arr, int[] tmp, int startIndex, int endIndex);
    void swap(int[] arr, int frontIndex, int rearIndex);
}
