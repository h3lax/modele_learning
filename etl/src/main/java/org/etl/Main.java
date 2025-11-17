package org.etl;

import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.streaming.StreamingQueryException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws StreamingQueryException {

        Setup setup = new Setup();
        SparkSession spark = SparkSession.builder()
                .appName("Spark Java Test")
                .master("local")
                .getOrCreate();
        String url = setup.ReturnUrl();
        Properties props = setup.ReturnProperties();

        Dataset<Row> df = spark.read()
                .jdbc(url, "(SELECT id, name, address, car_name FROM fake) AS t", props);

        df.show();
        df.describe();
        df.select("name", "address").show();
    }
}

