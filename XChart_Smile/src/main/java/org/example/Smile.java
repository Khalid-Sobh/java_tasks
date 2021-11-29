package org.example;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.csv.CSVFormat;
import smile.classification.RandomForest;
import smile.data.DataFrame;
import smile.data.formula.Formula;
import smile.data.measure.NominalScale;
import smile.data.vector.IntVector;
import smile.data.vector.StringVector;
import smile.io.Read;
import smile.plot.swing.BarPlot;
import smile.plot.swing.Histogram;


public class Smile {
    public static int[] encodeCategory(DataFrame df, String columnName) {
            String[] values = df.stringVector (columnName).distinct ().toArray (new String[]{});
            int[] pclassValues = df.stringVector (columnName).factorize (new NominalScale (values)).toIntArray ();
            return pclassValues;
        }
        public static void main (String[]args) throws
        InvocationTargetException, InterruptedException, IOException, URISyntaxException {
            DataFrame titanic = Read.csv("src/main/resources/titanic_train.csv", CSVFormat.DEFAULT.withDelimiter(',')
                    .withHeader("PassengerId","Survived","Pclass","Name","Sex","Age")
                    .withSkipHeaderRecord(true));

            titanic = titanic.merge(IntVector.of("PclassValue", encodeCategory(titanic, "Pclass")));
            titanic = titanic.merge(IntVector.of("SexValue", encodeCategory(titanic, "Sex")));

            titanic = titanic.drop("Name");
            titanic = titanic.drop("PassengerId");
            titanic = titanic.drop("Sex");
            titanic = titanic.drop("Pclass");
            titanic = titanic.omitNullRows();
            System.out.println(titanic.schema());
            System.out.println(titanic.summary());
            smile.classification.RandomForest model = RandomForest.fit(Formula.lhs("Survived"), titanic);
            System.out.println("feature importance:");
            System.out.println(Arrays.toString(model.importance()));
            System.out.println(model.metrics());

            DataFrame titanic_s = Read.csv("src/main/resources/titanic_test.csv", CSVFormat.DEFAULT.withDelimiter(',')
                    .withHeader("PassengerId","Pclass","Name","Sex","Age")
                    .withSkipHeaderRecord(true));
            titanic_s = titanic_s.merge(StringVector.of("string_pclass",titanic_s.intVector("Pclass").toStringArray()));
            titanic_s = titanic_s.merge(IntVector.of("PclassValue", encodeCategory(titanic_s, "string_pclass")));
            titanic_s = titanic_s.merge(IntVector.of("SexValue", encodeCategory(titanic_s, "Sex")));

            titanic_s = titanic_s.drop("PassengerId");
            titanic_s = titanic_s.drop("Name");
            titanic_s = titanic_s.drop("Sex");
            titanic_s = titanic_s.drop("Pclass");
            titanic_s = titanic_s.drop("string_pclass");
            titanic_s = titanic_s.omitNullRows();
            System.out.println(titanic_s.schema());
            System.out.println(titanic_s.summary());
            Arrays.stream(model.predict(titanic_s)).forEach(System.out::println);


    }
}
