package org.etl.Extract;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.etl.Config.Mongo;
import org.etl.Config.Spark;

import java.nio.file.Path;
import java.util.Properties;

public class Extract {

    public static Dataset<Row> extract (Path address, FormatType type) throws Exception {

        return switch (type) {
            case MONGO -> {
                System.out.println("Mongo");
                yield extractMongo(address);
            }
            default -> throw new NotImplementedException(
                    "Extraction for " +  type + "format isn't implemented yet"
            );
        };

    }

    private static Dataset<Row> extractMongo(Path address) {

        System.out.println("Getting Spaksession... ");
        SparkSession spark = Spark.getInstance();

        System.out.println("Reading properties ...");
        Properties props = Mongo.getProps();

        String uri = props.getProperty("uri");
        String database = props.getProperty("database");
        String collection = props.getProperty("collection");

        System.out.println("Trying to read the data ...");
        return spark.read()
                .format("mongodb")
                .option("spark.mongodb.read.connection.uri", uri)
                .option("spark.mongodb.read.database", database)
                .option("spark.mongodb.read.collection", collection)
                .load();
    }

}
