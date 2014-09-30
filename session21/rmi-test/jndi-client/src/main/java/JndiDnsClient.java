import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;

public class JndiDnsClient {
    public static void main(String[] args) throws NamingException {
        InitialDirContext context = new InitialDirContext();
        Attributes attributes = context.getAttributes("8.8.8.8", new String[]{"A"});
        for (int i = 0; i < attributes.size(); i++) {
            System.out.println("---> " + attributes.toString());
        }
    }
}
