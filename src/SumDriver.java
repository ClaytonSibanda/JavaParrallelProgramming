import java.util.concurrent.ForkJoinPool;

/**
 * Created by Clayza on 2017-08-24.
 */
public class SumDriver {



    public static  void main(String args[])
    {
int arr []= new int [10000];

for(int i=0;i<arr.length;i++)
{
    arr[i]=i;
}
System.out.println(ForkJoinPool.commonPool().invoke(new SumArray(arr,0,arr.length)));

    }

}
