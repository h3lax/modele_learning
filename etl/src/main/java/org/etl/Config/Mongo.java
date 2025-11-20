package org.etl.Config;

import io.github.cdimascio.dotenv.Dotenv;
import java.util.Properties;

public class Mongo {

    private static final Dotenv dotenv = Dotenv.load();

    public static Properties getProps(){
        Properties props = new Properties();
        props.setProperty("user", dotenv.get("MONGO_INITDB_ROOT_USERNAME"));
        props.setProperty("password", dotenv.get("MONGO_INITDB_ROOT_PASSWORD"));
        props.setProperty("database", dotenv.get("MONGO_INITDB_ROOT_DATABASE"));
        props.setProperty("collection", dotenv.get("MONGO_INITDB_ROOT_COLLECTION"));
        props.setProperty("uri", dotenv.get("MONGO_INITDB_ROOT_URI"));

        return props;
    }

}
