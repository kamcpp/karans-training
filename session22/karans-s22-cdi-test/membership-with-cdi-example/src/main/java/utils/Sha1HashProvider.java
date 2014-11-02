package utils;

import org.apache.commons.codec.digest.DigestUtils;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Sha1HashProvider implements  HashProvider {
    @Override
    public String hash(String input) {
        return DigestUtils.sha1Hex(input);
    }
}
