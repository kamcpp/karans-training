package searchengine.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import searchengine.LinkExtaractor;

public class DefaultLinkExtractor implements LinkExtaractor {

	@Override
	public List<String> extract(String html) {
		String aTagRegex = "(?i)<a([^>]+)></a>";
		String linkRegex = "\\s*(?i)href\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\">\\s]+))";
		Matcher aTagMatch;
		Matcher linkMatch;
		Pattern aTagPattern;
		Pattern linkPattern;
		List<String> links = new ArrayList<String>();

		aTagPattern = Pattern.compile(aTagRegex);
		linkPattern = Pattern.compile(linkRegex);

		aTagMatch = aTagPattern.matcher(html);

		while (aTagMatch.find()) {
			String hrefExtracted = aTagMatch.group(1);

			linkMatch = linkPattern.matcher(hrefExtracted);
			while (linkMatch.find()) {
				String link = linkMatch.group(1);
				link = link.replaceAll("'", "");
				link = link.replaceAll("\"", "");
				links.add(link);

			}
		}

		return links;
	}

}
