package com.personal.algorithms.leetcode;

public class SI {

	private String str;

	private Integer current_index;

	private Integer current_frequency;

	private Integer current_give_frequency;

	public SI(String compressedString) {
		this.str = compressedString;
		this.current_index = 0;
		this.current_frequency = 0;
		this.current_give_frequency = getFrequency(compressedString, 1);
	}

	public char next() {

		if (hasNext()) {

			if (current_give_frequency > current_frequency) {
				current_frequency++;
				char res = str.charAt(current_index);
				Integer prev = current_give_frequency;

				if (current_give_frequency == current_frequency) {
					current_give_frequency = getFrequency(str, current_index + 3);
					current_frequency = 0;
					current_index = current_index + 1 + prev.toString().length();
				}

				return res;
			}

			else {
				Integer prev = current_give_frequency;
				current_give_frequency = getFrequency(str, current_index + 3);
				current_frequency = 0;
				current_index = current_index + 1 + prev.toString().length();
				return next();
			}
		}
		return ' ';
	}

	public boolean hasNext() {

		if (current_index >= str.length() - 1) {
			return false;
		}

		if (current_give_frequency == current_frequency) {
			return false;
		}

		return true;

	}

	public Integer getFrequency(String str, int index) {

		StringBuffer b = new StringBuffer();
		for (int i = index; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				b.append(str.charAt(i));
			} else {
				break;
			}
		}

		return b.length() == 0 ? 0:Integer.parseInt(b.toString());
	}
}