package me.dave;

public class QuickISorter extends Sorter {

    @Override
    public void sort(int[] arr, int startIndex, int endIndex) {
        int partition = getPartition(arr, startIndex, endIndex);
        if(startIndex < partition - 1) {    //정렬 대상이 두개 이상일 때만 재귀호출합니다.
            sort(arr, startIndex, partition - 1);
        }
        if(endIndex > partition) {
            sort(arr, partition, endIndex);
        }
    }

    public int getPartition(int[] arr, int startIndex, int endIndex) {
        //물리적 중간 값으로 pivot 설정
        int pivot = arr[(startIndex + endIndex)/2];
        while(startIndex <= endIndex) { //포인터가 완전히 교차하면 루프를 탈출합니다.
            while (pivot > arr[startIndex]) startIndex++;
            while (pivot < arr[endIndex]) endIndex--;
            if (startIndex <= endIndex) {   //포인터가 완전히 교차한 상태에서는 swap하지 않습니다.
                swap(arr, startIndex, endIndex);
                startIndex++;
                endIndex--;
            }
        }
        return startIndex;
    }
}
