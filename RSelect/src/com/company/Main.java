package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        int[] data = new int[20];
        for(int i = 0; i< data.length; i++){
            data[i] = rnd.nextInt(100);
            System.out.print(data[i] + " ");
        }
        System.out.println();
        System.out.print("Enter index of selection: ");
        Scanner scan = new Scanner(System.in);
        int index = scan.nextInt();
        System.out.println(select(data, index) + " - selected stat");

        for(int i = 0; i< data.length; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    private static int select(int[] arr, int left, int right, int index){
        int element = arr[left];
        int i = left, j = right;
        while(i <= j){
            while(i!=arr.length-1 && arr[i]<element){
                i++;
            }
            while(j!=0 && arr[j]>element){
                j--;
            }
            if(i <= j){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        if(j==index-1){
            return arr[j+1];
        } else if(index-1<j){
            return select(arr, left, j, index);
        } else return select(arr, i, right, index);
    }

    public static int select(int[] arr, int index){
        return select(arr, 0, arr.length-1, index);
    }
}
