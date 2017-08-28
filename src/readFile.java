import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.Buffer;

/**
 * Created by Clayza on 2017-08-28.
 */
public class readFile {

    public static void main(String args[])
    {
        try{
            FileReader fr = new FileReader("C:\\Users\\USER\\Desktop\\2nd year\\2nd Semester\\CSC2002S\\Assignments\\Assignment1\\outputSEQUENTIAL_CUTOFFAll.csv");
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter("C:\\Users\\USER\\Desktop\\2nd year\\2nd Semester\\CSC2002S\\Assignments\\Assignment1\\sequentialCutOffAll.csv");

            String line ="";
            long start = System.currentTimeMillis();
            while((line = br.readLine())!=null)
            {
                if(!line.startsWith("SEQUENTIAL"))
                    fw.write(line+"\n");
            }
            fw.close();
            long end = System.currentTimeMillis();
            System.out.println("time taken is "+(end-start));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
