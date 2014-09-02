package searchengine;

import java.util.List;

public interface LinkExtaractor {

	List<String> extract(String html);

}
