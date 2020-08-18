package me.dave;

public class MergeISorter extends Sorter {

    @Override
    public void sort(int[] arr, int[] tmp, int startIndex, int endIndex) {
        if(startIndex < endIndex) {
            int midIndex = (startIndex + endIndex)/2;   //배열 파티셔닝에 사용할 중간 인덱스를 구합니다.

            //재귀호출을 통해 배열을 1/2씩 잘라 줍니다.
            sort(arr, tmp, startIndex, midIndex);
            sort(arr, tmp, midIndex+1, endIndex);

            //복귀하면서 잘려있는 배열을 merge합니다.
            merge(arr, tmp, startIndex, midIndex, endIndex);
        }
    }

    public void merge(int[] arr, int[] tmp, int startIndex, int midIndex, int endIndex) {
        //정렬할 영역만큼 배열을 복사합니다.
        for(int i = startIndex; i <= endIndex; i++) {
            tmp[i] = arr[i];
        }

        //이제 복사한 배열을 매개변수로 받은 index들을 기준으로 두 부분으로 나눠 병합합니다.
        int frontArrayCnt = startIndex; //앞쪽 배열요소를 순회할 떄 사용할 카운터입니다.
        int rearArrayCnt = midIndex+1;  //뒤쪽 배열요소를 순회할 때 사용할 카운터입니다.
        int originArrayIndex = startIndex;  //원본 배열 요소를 순회하는데 사용할 카운터입니다.

        //앞, 뒤 배열 요소의 값들을 비교하며 작은 값을 원본 배열에 넣어줍니다.
        while(frontArrayCnt <= midIndex && rearArrayCnt <= endIndex) {
            if(tmp[frontArrayCnt] <= tmp[rearArrayCnt]) {    //앞쪽 배열 요소의 값이 작거나 같으면
                arr[originArrayIndex] = tmp[frontArrayCnt];  //그 값을 원본 배열에 복사하고
                frontArrayCnt++; //캬운터를 하나 증가 시킵니다.
            } else {
                arr[originArrayIndex] = tmp[rearArrayCnt];
                rearArrayCnt++;
            }
            originArrayIndex++; //다음 정렬된 값을 받아오기 위한 index로 옮겨줍니다.
        }

        //만약 앞쪽 배열의 카운터가 그 배열 끝까지 도달하지 못한 상태에서 병합 루프를 탈출한 경우 남은 요소를 모두 원본 배열로 복사합니다.
        for(int i = 0; i <= midIndex - frontArrayCnt; i++) {
            arr[originArrayIndex + i] = tmp[frontArrayCnt + i];
        }
    }
}
