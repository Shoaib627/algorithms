package com.algorithms.graphs.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
	
	
	public static void main(String[] args) {
		
		String root = "https://www.bbc.com";		
		WebCrawler bfs = new WebCrawler();	
		bfs.discoverWeb(root);
		
	}

	Queue<String> queue;

	List<String> discoveredWebsitesList;

	public WebCrawler() {
		super();
		this.queue = new LinkedList<String>();
		this.discoveredWebsitesList = new ArrayList<String>();
	}

	public void discoverWeb(String root) {

		queue.add(root);
		discoveredWebsitesList.add(root);

		while (!queue.isEmpty()) {

			String current = queue.poll();
			System.out.println("Website found with URL: "+ current);

			List<String> neighbours = extractUrlsFromString(current);

			for (String neighbour : neighbours) {

				if (!discoveredWebsitesList.contains(neighbour)) {
					discoveredWebsitesList.add(neighbour);
					queue.add(neighbour);
				}
			}

		}
	}

	public List<String> extractUrlsFromString(String v) {

		String rawHtml = "";

		try {
			URL url = new URL(v);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

			String inputLine = "";
			while ((inputLine = in.readLine()) != null) {
				rawHtml += inputLine;
			}

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String regexp = "http://(\\w+\\.)*(\\w+)";
		Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(rawHtml);

		List<String> result = new ArrayList<>();
		while (matcher.find()) {
			result.add(matcher.group());

		}
		return result;
	}
}