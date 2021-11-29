package org.example;
import joinery.DataFrame;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Hello world!
 *
 */
public class joinery
{
    public static void main( String[] args )
    {
        try {
            DataFrame<Object> df= DataFrame.readCsv ("src/main/resources/titanic.csv");
            System.out.println(df.describe());

            System.out.println ("=========================================================================================");
            System.in.read();

            DataFrame df1 = df.retain("pclass","name","sex","ticket");
            List<Object> col = df.col(1);

            System.out.println(df.join(df1));
            System.out.println ("=========================================================================================");
            System.in.read();

            System.out.println(df.merge(df1));
            System.out.println ("=========================================================================================");
            System.in.read();


            System.out.println(df.add("pclass 2", col));




            //System.out.println(df1);



        } catch (IOException e) {
            e.printStackTrace ();
        }

    }

}
