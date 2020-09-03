package me.dave;

public class Application {

    public static void main(String[] args) {
        /*
         * recommended maximum array size
         *  n^2 algorithms : 100000
         *  n Log n algorithms : 10000000;
         */
        SortingTester sTest = new SortingTester(100000);

        //nlogn algorithms
//        sTest.sortingTest(SorterType.Heap);
//        sTest.sortingTest(SorterType.Quick);
//        sTest.sortingTest(SorterType.Merge);

        //n^2 algorithms
        sTest.sortingTest(SorterType.Selection);
        sTest.sortingTest(SorterType.Insert);
        sTest.sortingTest(SorterType.Bubble);

    }
}
