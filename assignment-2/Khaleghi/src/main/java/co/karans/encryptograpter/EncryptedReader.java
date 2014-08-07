package co.karans.encryptograpter;

import co.karans.cryptography.Cryptographer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * Hello world!
 *
 */
public class EncryptedReader extends BufferedReader{

    private Cryptographer cryptographer = null;

    public EncryptedReader(Reader in) {
        super(in);
    }

    public EncryptedReader(Reader in, int sz) {
        super(in, sz);
    }
 

    public Cryptographer getCryptographer() {
        return cryptographer;
    }

    public void setCryptographer(Cryptographer cryptographer) {
        this.cryptographer = cryptographer;
    }
    
    
    
    @Override
    public int read() throws IOException {
        
        
        
        
        
        return 0;
        
    }
   
}
