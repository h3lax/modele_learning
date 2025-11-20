package org.etl;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.streaming.StreamingQueryException;
import org.etl.Extract.Extract;
import org.etl.Extract.FormatType;

import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {

    public static void main(String[] args) throws StreamingQueryException {

        Path address = Paths.get("./data/openfoodfacts-mongodbdump");
        FormatType type = FormatType.MONGO;
        Dataset<Row> df ;

        try {
            df = Extract.extract(address, type);
            System.out.println("Data received from Mongo");
            df.show();
            System.out.println("Trying to display the data");
            df.describe();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

