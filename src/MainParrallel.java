import java.util.*;
import java.util.concurrent.ForkJoinPool;


/**
 * Created by Clayza on 2017-08-25.
 */
public class MainParrallel {


    public static  void main(String args [])
    {
double arr[] = {2,80,6,3,1};
double newArr[] = new double[arr.length];
Scanner sc = new Scanner(System.in);

int size=sc.nextInt();
double tempArr[] =new double[size];
ForkJoinPool.commonPool().invoke(new MedianParrallel((size-1)/2,arr.length-(size-1)/2,arr,newArr,tempArr,size));
System.out.println("The Array is "+Arrays.toString(newArr));


    }



}

