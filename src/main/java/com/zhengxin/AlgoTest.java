package com.zhengxin;



/**
 * @author zhengxin
 * @date 2021-09-02 15:09:43
 */
public class AlgoTest {

  public static void main(String[] args) {
    int[] arr = {1,1,1,1,2,2,2,3,3,4,4,4,4};
    int[] arr2 = {1,1,1,1,2,2,2,3,3,4,4,4,4,4};
//    printOneOddNum(arr);
//    printTwoOddNum(arr2);


    int[] arr3 = {1,3, 8,2,3,5,6};
//    selectionSort(arr3);
//    bubbleSort(arr3);
    insertionSort(arr3);
    for (int i : arr3) {
      System.out.print(i + "\t");

    }



  }

  public static void printOneOddNum(int[] arr){
    int err = 0;
    for (int cur : arr){
      err = err ^ cur;
    }

    System.out.println(err);
  }

  public static void printTwoOddNum(int[] arr){

    // err = a^b
    int err = 0;
    for (int cur : arr){
      err = err ^ cur;
    }


    //提取最右为1
    int rightOne = err & (~err + 1);

    //cur'
    int onlyOne = 0;

    for (int cur: arr){
      if ((cur & rightOne) == 0){
        onlyOne = cur ^ onlyOne;
      }
    }

    System.out.println(onlyOne + "\t" + (onlyOne ^ err));
  }

  public static void selectionSort(int[] arr){

    if (null == arr || arr.length < 2){
      return;
    }

    for(int i=0; i<arr.length; i++){

      int minIndex = i;

      for(int j=i+1; j<arr.length; j++){
        if (arr[j]<arr[minIndex]){
          minIndex = j;
        }
      }

      if(minIndex == i){
        continue;
      }
      swap(arr, minIndex, i);

    }

  }

  public static void bubbleSort(int[] arr){
    if(null == arr || arr.length<2){
      return;
    }

    for(int e=arr.length-1; e>0; e--){
      for(int i=0; i<e; i++){
        if(arr[i] > arr[i+1]){
          swap(arr, i, i+1);
        }
      }
    }

  }

  public static void insertionSort(int[] arr){
    if(null == arr || arr.length<2)
      return;

    for (int i=1; i<arr.length; i++)
      for(int j=i-1; j>=0&&arr[j+1]<arr[j]; j--)
        swap(arr, j, j+1);
  }


  public static void swap(int[] arr, int i, int j){

    arr[i] = arr[i] ^ arr[j];
    arr[j] = arr[i] ^ arr[j];
    arr[i] = arr[i] ^ arr[j];

//    int tmp = arr[i];
//    arr[i] = arr[j];
//    arr[j] = tmp;

  }
}
