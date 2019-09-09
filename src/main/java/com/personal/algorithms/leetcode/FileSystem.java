package com.personal.algorithms.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class FileSystem {

	Map<String, SortedSet<String>> map;

	Map<String, String> b_map;

	public FileSystem() {

		this.map = new HashMap<>();
		this.b_map = new HashMap<>();

		map.put("/", new TreeSet<String>());

	}

	public List<String> ls(String path) {

		if (b_map.containsKey(path)) {

			List<String> list = new ArrayList<>();
			list.add(path.substring(path.lastIndexOf('/') + 1));

			return list;
		}
		return new ArrayList<String>(map.get(path));
	}

	public void mkdir(String path) {

		mkdir(path, null);
	}

	public void mkdir(String path, String child) {

		if (path.length() == 0) {
			
			if (child != null) {
				SortedSet<String> set = map.get("/");
				set.add(child);
				map.put("/", set);
			}
			
			return;
		}

		if (!map.containsKey(path)) {

			String parent_path = path.substring(0, path.lastIndexOf('/'));

			mkdir(parent_path, path.substring(path.lastIndexOf('/') + 1));
			
			TreeSet<String> set = new TreeSet<String>();
			
			if (child != null) {
				set.add(child);
			}

			map.put(path, set);

		
		}
		else {
			if (child != null) {

				SortedSet<String> set = map.get(path);
				set.add(child);
				map.put(path, set);
			}
	
		}
	}

	public void addContentToFile(String filePath, String content) {

		if (b_map.containsKey(filePath)) {

			b_map.put(filePath, b_map.get(filePath) + content);
		}

		else {
			String path = filePath.substring(0, filePath.lastIndexOf('/'));
			String file_name = filePath.substring(filePath.lastIndexOf('/') + 1);

			mkdir(path, file_name);


			SortedSet<String> set = map.getOrDefault(path, new TreeSet<>());
			set.add(file_name);
			map.put(path, set);

			b_map.put(filePath, content);
		}
	}

	public String readContentFromFile(String filePath) {
		return b_map.get(filePath);
	}
}