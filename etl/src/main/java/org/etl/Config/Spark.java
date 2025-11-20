package org.etl.Config;

import org.apache.spark.sql.SparkSession;

public class Spark {

    static SparkSession spark ;

    public static SparkSession getInstance() {
        if (spark == null) {
            spark = SparkSession.builder()
                    .appName("Spark Java Test")
                    .master("local[*]")
                    .getOrCreate();
        }
        return spark;
    }

}
