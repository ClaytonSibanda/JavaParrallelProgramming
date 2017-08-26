import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by Clayza on 2017-08-26.
 */
public class Experiment {


    public static int[] inputSize() {
        int arr[] = new int[10];
        arr[0] = 50000;
        arr[1] = 100000;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + 100000;
        }
        return arr;
    }

    //for changing the size of the filter or the window size of the filter
    public static int[] filterSize() {
        int arr[] = new int[10];
        for (int i = 0, j = 3; i < arr.length; i++, j += 2) {
            arr[i] = j;
        }
        return arr;
    }

    public static double[] readFile(String filename, int arrLength) //reads the file and returns an array of doubles
    {
        double[] arr = null;
        try {
            FileReader fr = new FileReader(filename);

            BufferedReader bf = new BufferedReader(fr);
            String line = "";
            int length = Integer.parseInt(bf.readLine());
            // System.out.println(length);
            arr = new double[arrLength];
            int i = 0;

            while ((line = bf.readLine()) != null && i < arrLength) {

                arr[i] = Double.parseDouble((line.split(" ")[1]));
                i++;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return arr;

    }


    public static void writeFile(String filename, double arr[]) {
        try {
            FileWriter fw = new FileWriter(filename);
            String newLine = System.getProperty("line.separator");
            fw.write(arr.length + newLine);
            for (int i = 0; i < arr.length; i++) {
                fw.write(i + 1 + " " + arr[i] + newLine);
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void writeCSV(String filename, int arr[], int length, double timeArr[]) {
        try {
            FileWriter fw = new FileWriter(filename,true);
            String newLine = System.getProperty("line.separator");
            fw.write("Size,Length,Time"+newLine);

            for(int i=0;i<arr.length;i++) {
                fw.write(arr[i] + "," + length + "," + timeArr[i] + newLine);
            }

            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
