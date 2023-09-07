package org.cankut;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


        File jsonFile=new File("randomJson.json");
        if(jsonFile.exists()) jsonFile.delete();
        try {
            int counter=1;
            BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFile, true));
            writer.write("{\"defaultContent\":[\n" +
                    "\t{\"eventUuid"+counter+"\":\"string no:"+counter+"\"},\n" +
                    "\n"
                    );
            counter++;
            while(jsonFile.length()<200000000){
                writer.write("\t{\"eventUuid"+counter+"\":\"string no:"+counter+"\"},\n" +
                        "\n");
                counter++;
            }
            writer.write("]}");
            writer.close();
            System.out.println("file created");
            System.out.println(jsonFile.getAbsolutePath());
        } catch (IOException exc){
            System.out.println("Could not write");
            exc.printStackTrace();
        }

    }
}
