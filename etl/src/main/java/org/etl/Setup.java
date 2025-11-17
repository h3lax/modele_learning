package org.etl;

import org.apache.spark.sql.SparkSession;

import java.util.Properties;

public class Setup {

    public SparkSession SetupSpark() {
        SparkSession spark = SparkSession.builder()
                .appName("Spark Java Test")
                .master("local[*]")
                .getOrCreate();
        return spark;
    }

    public Properties ReturnProperties() {
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "");
        props.setProperty("driver", "com.mysql.cj.jdbc.Driver");

        return props;
    }

    public String ReturnUrl(){
        return "jdbc:mysql://localhost:3306/secbydes";
    }
}
