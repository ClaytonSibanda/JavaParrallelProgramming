import java.io.*;
import java.util.*;

public class MergeSort{




    public static double[] mergeSort(double arr[])
    {

        if(arr.length==1){
            return arr;
        }

        double firstHalf []= new double[arr.length/2];
        double secondHalf[] = new double[ arr.length-(arr.length/2)];

        System.arraycopy(arr,0,firstHalf,0,arr.length/2);
        System.arraycopy(arr,(arr.length/2),secondHalf,0,(arr.length-(arr.length/2)));



        firstHalf= mergeSort(firstHalf);
        secondHalf= mergeSort(secondHalf);

        return merge(firstHalf,secondHalf);


    }


    public static double[] merge (double firstHalf[], double secondHalf[])
    {
        int firstIndex=0;
        int secondIndex=0;
        int index=0;
        double newArray[]= new double[firstHalf.length+secondHalf.length];
        while(firstIndex<firstHalf.length && secondIndex<secondHalf.length)
        {
            if(firstHalf[firstIndex]<secondHalf[secondIndex])
            {
                newArray[index]=firstHalf[firstIndex];

                firstIndex++;

            }
            else{
                newArray[index]=secondHalf[secondIndex];

                secondIndex++;
            }


            index++;

        }


        //if one of the arrays fiished first

        while(firstIndex<firstHalf.length)
        {
            newArray[index]=firstHalf[firstIndex];
            index++;
            firstIndex++;
        }

        while(secondIndex<secondHalf.length)
        {
            newArray[index]=secondHalf[secondIndex];
            index++;
            secondIndex++;
        }


        return newArray;
    }

}