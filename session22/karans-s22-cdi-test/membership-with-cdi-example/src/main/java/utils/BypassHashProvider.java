package utils;

import javax.enterprise.inject.Alternative;

@Alternative
public class BypassHashProvider implements HashProvider {
    @Override
    public String hash(String input) {
        return input;
    }
}
