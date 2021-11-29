package org.example;
import tech.tablesaw.aggregate.Summarizer;
import tech.tablesaw.api.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TableSaw {
    public static void main(String[] args) {
        try {

            Table titanicData = Table.read().csv("src/main/resources/titanic.csv");
            System.out.println(titanicData.summary());

            Table newTable = titanicData.select("name","survived","sex");
            Table newTable2 = titanicData.select("age","parch","ticket");
            //System.out.println(newTable.summary());
            System.out.println(newTable.joinOn().leftOuter(newTable2));

            int rowCount= titanicData.rowCount ();
            Integer [] theIndexing = new Integer[rowCount];
            for(int i = 0;i < rowCount;i++) {
                theIndexing[i]=i;
            }
            IntColumn column = IntColumn.create("NewColumn(indices)", theIndexing);
            newTable.addColumns(column);
            System.out.println(newTable.summary());


        }catch (IOException e) {
            e.printStackTrace ();
        }


    }
}