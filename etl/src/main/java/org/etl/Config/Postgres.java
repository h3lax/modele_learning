package org.etl.Config;

import java.util.Properties;

public class Postgres {

    public static Properties getProps(){
        Properties props = new Properties();
        props.setProperty("user", "admin");
        props.setProperty("password", "trde703");
        props.setProperty("driver", "com.mysql.cj.jdbc.Driver");
        props.setProperty("database", "trde703");


        return props;
    }


}
