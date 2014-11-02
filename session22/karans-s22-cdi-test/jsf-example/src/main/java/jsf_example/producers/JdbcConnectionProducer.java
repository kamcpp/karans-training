package jsf_example.producers;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import java.sql.Connection;

public class JdbcConnectionProducer {

    @Produces
    public Connection create() {
        // TODO: Make a connection
        return null;
    }

    public void close(@Disposes Connection connection) {
        // TODO: close the connection
    }
}
