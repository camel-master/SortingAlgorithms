package me.dave;

import java.util.Arrays;

public class SortingTester {

    private final int[] arr;
    public SortingTester(int arraySize) {
        this.arr = new int[arraySize];
        for(int i = 0; i < arraySize; i++) {
            arr[i] = (int)(Math.random()*arraySize);
        }
//        arr = new int[] {3,0,3,0,1};
    }
    public void sortingTest(SorterType type) {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(type + "Sorting Test");
        System.out.print("Origin: ");
        printArray(arr);

        //test용 배열 복사
        int[] arrForSorting = Arrays.stream(this.arr).toArray();

        Sorter sorter;
        long beforeTime = System.currentTimeMillis();
        switch(type) {
            case Bubble:
                sorter = new BubbleISorter();
                sorter.sort(arrForSorting);
                break;
            case Heap:
                sorter = new HeapISorter();
                sorter.sort(arrForSorting);
                break;
            case Insert:
                sorter = new InsertISorter();
                sorter.sort(arrForSorting);
                break;
            case Merge:
                sorter = new MergeISorter();
                int[] temp = Arrays.stream(this.arr).toArray();
                sorter.sort(arrForSorting, temp, 0, arrForSorting.length-1);
                break;
            case Quick:
                sorter = new QuickISorter();
                sorter.sort(arrForSorting, 0, arrForSorting.length-1);
                break;
            case Selection:
                sorter = new SelectionISorter();
                sorter.sort(arrForSorting);
                break;
            default:
                break;
        }
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산

        System.out.print("Sorted: ");
        printArray(arrForSorting);

        System.out.println("Execution Time(s) : "+secDiffTime);
    }

    public void printArray(int[] pArray) {
        int arrayLength = pArray.length;
        System.out.print("{");
        if(arrayLength > 10)  {
            for (int i = 0; i < 3; i++) {
                System.out.print(pArray[i] + ", ");
            }
            System.out.print("... ");
            for (int i = arrayLength-3; i < arrayLength-1; i++) {
                System.out.print(pArray[i] + ", ");
            }
        } else {    //10보다 작은 경우만 풀셋으로 찍음.
            for (int i = 0; i < arrayLength - 1; i++) {
                System.out.print(pArray[i] + ", ");
            }
        }
        System.out.println(pArray[arrayLength - 1] + "}");
    }
}
