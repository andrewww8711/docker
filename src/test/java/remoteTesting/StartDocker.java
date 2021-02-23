package remoteTesting;

import org.junit.Assert;

import java.io.*;
import java.util.Calendar;

public class StartDocker {

    public void startFile() throws IOException, InterruptedException {
        boolean flag = false;
        ProcessBuilder pb = new ProcessBuilder("./dockerup.sh", "myArg1", "myArg2");
        Process p = pb.start();
/*        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }*/

        String file = "output.txt";

        Calendar cal = Calendar.getInstance(); //current time
        cal.add(Calendar.SECOND, 30);
        long stopNow = cal.getTimeInMillis();
        while (System.currentTimeMillis() < stopNow) {
            if(flag){
                break;
            }
            BufferedReader reader2 = new BufferedReader(new FileReader(file));
            String currentLine = reader2.readLine();
            while (currentLine != null &&!flag) {
                System.out.println(currentLine);
                if (currentLine.contains("Node has been added")) {
                    System.out.println("Found my text");
                    flag = true;
                    break;
                }
                currentLine = reader2.readLine();
            }
            reader2.close();
        }
        Assert.assertTrue(flag);
        Thread.sleep(3000);
    }
    public void stopFile() throws IOException, InterruptedException {
        boolean flag = false;
        ProcessBuilder pb = new ProcessBuilder("./dockerdown.sh", "myArg1", "myArg2");
        Process p = pb.start();
/*        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }*/

        String file = "output.txt";

        Calendar cal = Calendar.getInstance(); //current time
        cal.add(Calendar.SECOND, 30);
        long stopNow = cal.getTimeInMillis();
        while (System.currentTimeMillis() < stopNow) {
            if(flag){
                break;
            }
            BufferedReader reader2 = new BufferedReader(new FileReader(file));
            String currentLine = reader2.readLine();
            while (currentLine != null &&!flag) {
                System.out.println(currentLine);
                if (currentLine.contains("Shutdown complete")) {
                    System.out.println("Found my text");
                    flag = true;
                    break;
                }
                currentLine = reader2.readLine();
            }
            reader2.close();
        }
        Assert.assertTrue(flag);
        Thread.sleep(3000);
        File fd = new File("output.txt");
        if(fd.delete()){
            System.out.println("File is deleted");
        }
    }
}
