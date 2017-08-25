import javax.swing.plaf.SeparatorUI;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Clayza on 2017-08-24.
 */
public class SumArray extends RecursiveTask<Integer>{

   int lo;
   int hi;
   int arr[];
   final int SEQUENTIAL_CUTOFF =1000;
    public SumArray(int arr[],int lo, int hi)
    {
        this.arr=arr;
        this.lo=lo;
        this.hi=hi;
    }


    protected Integer compute ()//should return the object type taken by Recursive Task class
        {

        if(hi-lo<SEQUENTIAL_CUTOFF)
        { int ans=0;
            //go sequential
            for(int i=lo;i<hi;i++)
               ans+=arr[i];
            return ans;
        }

        else
            {
            SumArray left = new SumArray(arr,lo,(lo+hi)/2);
            SumArray right = new SumArray(arr,(lo+hi)/2,hi);

            left.fork();
            int rightNum = right.compute();
            int leftNum=left.join();//returns the value of compute

            //recursively create threads
            return rightNum+leftNum;
        }
     }


}
