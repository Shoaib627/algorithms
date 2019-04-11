package com.personal.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class LeetCodeV2 {


	public static void main(String[] args) {

		System.out.println(
				mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] { "hit" }));

	}

	public static int[][] transpose(int[][] A) {
		
		 int[][] B = new int[A.length][A[0].length];

		for (int i = 0; i < A.length; i++) {

			for (int j = 0; j < A[i].length; j++) {
				B[i][j] = A[j][i] ;
			}
		}
		
		return B;
	}
	
	public static List<Integer> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
	
		List<Integer> one = new ArrayList<>();
		
		one.add(1);
		
		if(numRows == 1) {
			return one;
		}
		
		result.add(one);
		
	
		List<Integer> f_current = new ArrayList<>();

		for(int i = 1; i <= numRows; i++) {
			List<Integer> previous = result.get(i-1);
			List<Integer> current = new ArrayList<>();
			
			current.add(1);
			
			for(int j = 0; j < previous.size() - 1; j++) {
				current.add(previous.get(j) + previous.get(j + 1));
			}
			current.add(1);
			result.add(current);

			f_current = current;
		}
		return f_current;		
	}

	public static boolean validPalindrome(String s) {

		int i = 0;
		int j = s.length() - 1;

		while (i <= j) {

			if (s.charAt(i) != s.charAt(j) ) {
				return validPalindromeAtIndexes(s, i, j - 1) || validPalindromeAtIndexes(s, i + 1, j);
			}

			else {
				i++;
				j--;
			}
		}
		return true;
	}

	public static boolean validPalindromeAtIndexes(String s, int i, int j) {

		while (i < j) {

			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}

			else {
				i++;
				j--;
			}
		}
		return true;
	}
	
	public static int trailingZeroes(int n) {
		int five_divisors = 0;
		long div = 5;

		while (true) {
			int c = (int) (n / div);

			if (c <= 0) {
				break;
			}

			five_divisors = five_divisors + c;

			div = div * 5;
		}
		return five_divisors;
	}
	
	public static boolean isPerfectSquareV2(int num) {
		return isPerfectSquareI2(0, num, num);
	}
	
	
	public static boolean isPerfectSquareI2(long i, long j, int num) {

		long mid = (i + j) / 2;
		long lower = i;
		long high = j;

		long square = mid * mid;

		if (i >= j && square != num) {
			return false;
		}

		if (square == num) {
			return true;
		}

		else if (square < num) {
			return isPerfectSquareI2(mid + 1, high, num);

		} else {
			return isPerfectSquareI2(lower, mid - 1, num);

		}
	}

	public static String frequencySort(String s) {
		char[] arr = s.toCharArray();

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < arr.length; i++) {
			Integer count = map.get(arr[i]);
			map.put(arr[i], count == null ? 1 : count + 1);
		}
		
		Map<Character, Integer> sorted = map.entrySet().stream()
		   .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
		   .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
	                LinkedHashMap::new));


		Object[] r = sorted.keySet().toArray();

		StringBuffer str = new StringBuffer("");
		for (int j = 0; j < r.length; j++) {
			for(int p = 0; p < sorted.get(r[j]); p++) {
				str.append(r[j]);
			}
			
		}

		return str.toString();

	}
	

	  public int firstUniqChar(String s) {
			char[] arr = s.toCharArray();

			LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();

			for (int i = 0; i < arr.length; i++) {
				Integer count = map.get(arr[i]);
				map.put(arr[i], count == null ? 1 : count + 1);
			}
			
			Optional<Entry<Character, Integer>> first = map.entrySet()
			.stream()
			.filter(e -> e.getValue() == 1)
			.findFirst();
			
			Character c = first.isPresent() ? first.get().getKey(): null;
			
			if( c == null) {
				return - 1;
			}
			else {
				for (int i = 0; i < arr.length; i++) {
						if(arr[i] == c) {
							return 1;
						}
				}
			}
			
			return - 1;
	    }
	  
	  
	public static int addDigits(int num) {
		if (num <= 9) {
			return num;
		} else {
			int sum = 0;

			while (num > 0) {
				int r = num % 10;
				num = num / 10;
				sum = sum + r;
			}
			return addDigits(sum);

		}

	}

	public static int countSegments(String s) {

		if (s == null || s.equals("")) {
			return 0;
		} else {
			return (int) Stream.of(s.split(" ")).filter(e -> e.length() > 0).count();
		}
	}

	public boolean judgeCircle(String moves) {
		char[] arr = moves.toCharArray();
		int u_count = 0;
		int d_count = 0;
		int r_count = 0;
		int l_count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'U') {
				u_count++;
			}
			if (arr[i] == 'D') {
				d_count++;
			}
			if (arr[i] == 'R') {
				r_count++;
			}
			if (arr[i] == 'L') {
				l_count++;
			}
		}
		return u_count == d_count && r_count == l_count;
	}
	
	public int repeatedNTimes(int[] A) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < A.length; i++) {

			Integer count = map.get(A[i]);
			count = count == null ? 1 : count + 1;
			if (count >= A.length / 2) {
				return A[i];
			}
			map.put(A[i], count);

		}
		return 0;
	}

	public static int[][] flipAndInvertImage(int[][] A) {
		for (int i = 0; i < A.length; i++) {

			int p = 0;
			int q = A[i].length - 1;
			
			while(p < q) {
				
				int temp = A[i][p];

				A[i][p] = A[i][q];
				A[i][q] = temp;
				
				p++;
				q--;

			}

			for (int j = 0; j < A[i].length; j++) {
				A[i][j] = A[i][j] == 0 ? 1 : 0;
			}
			
		}
		
	
		return A;
	}
	
	public int[] sumEvenAfterQueries(int[] A, int[][] queries) {

		int[] B = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {

			A[queries[i][1]] = A[queries[i][1]] + queries[i][0];

			int even_sum = 0;
			for (int j = 0; j < A.length; j++) {
				if (A[j] % 2 == 0) {
					even_sum += A[j];
				}
			}
			B[i] = even_sum;
		}
		return B;
	}

    public static int[] intersection(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList<>();

		if (nums1.length == 0 || nums2.length == 0) {
			return list.stream().mapToInt(Integer::intValue).toArray();
		}

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int i = 0;
		int j = 0;

		while (i < nums1.length && j < nums2.length) {

			if (nums1[i] == nums2[j]) {
				list.add(nums1[i]);
				j++;
				i++;
			}

			else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				i++;
			}
		}
		return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    
    
	public static String shortestCompletingWord(String licensePlate, String[] words) {

		char[] arr = licensePlate.toCharArray();

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (Character.isLetter(arr[i])) {
				Integer count = map.get(Character.toLowerCase(arr[i]));
				map.put(Character.toLowerCase(arr[i]), count == null ? 1 : count + 1);
			}
		}

		String word = null;
		String c_word = null;


		for (int j = 0; j < words.length; j++) {

			char[] word_arr = words[j].toCharArray();
			c_word = words[j];
			Map<Character, Integer> wmap = new HashMap<Character, Integer>();

			for (int k = 0; k < word_arr.length; k++) {
				Integer count = wmap.get(Character.toLowerCase(word_arr[k]));
				wmap.put(Character.toLowerCase(word_arr[k]), count == null ? 1 : count + 1);
			}

			boolean skip_word = false;
			for (Entry<Character, Integer> entry : map.entrySet()) {
				Integer c = wmap.get(Character.toLowerCase(entry.getKey()));
				if (c == null || c < entry.getValue()) {
					skip_word = true;
					break;
				}
			}
			
			if(!skip_word) {
				word = word == null || c_word.length() < word.length() ? c_word : word;

			}

		}

		return word;
	}

	public String reverseVowels(String s) {
		char[] arr = s.toCharArray();
		int i = 0;
		int j = s.length() - 1;

		while (i < j) {

			if (!isVowel(arr[i])) {
				i++;
			}

			if (!isVowel(arr[j])) {
				j--;
			}

			if (isVowel(arr[i]) && isVowel(arr[j])) {
				char temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		return String.valueOf(arr);
	}
	
	
	   public String reverseOnlyLetters(String s) {
		   char[] arr = s.toCharArray();
			int i = 0;
			int j = s.length() - 1;

			while (i < j) {

				if (!Character.isAlphabetic(arr[i])) {
					i++;
				}

				if (!Character.isAlphabetic(arr[j])) {
					j--;
				}

				if (Character.isAlphabetic(arr[i]) && Character.isAlphabetic(arr[j])) {
					char temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					i++;
					j--;
				}
			}
			return String.valueOf(arr);
		   
	    }

	public boolean isVowel(char ch) {
		if (ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O'
				|| ch == 'u' || ch == 'U') {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static boolean checkPerfectNumber(int num) {
		
		if(num <= 1) {
			return false;
		}

		int sum = 1;

		for (int i = 2; i <= Math.sqrt(num); i++) {

			if (num % i == 0) {
				sum = sum + i;
				if (i != num && num % i != i)

					sum = sum + num / i;
			}
		}
		return num == sum;
	}
	
	
  	public static boolean isPerfectSquare(int num) {
        if(num <= 0){
            return false;
        }
		return isPerfectSquareI2(0, num, num);
	}
	
	public static boolean isPerfectSquareI2(int num, int low, int high) {
		
		if(low >= high) {
			return false;
		}

		int mid = (high - low) / 2;

		long p = mid * mid;
		if (p == num && p != num) {
			return true;
		}

		else if (p > num) {
			return isPerfectSquareI2(low, mid - 1, num);
		}

		else {
			return isPerfectSquareI2(mid + 1, high, num);
		}		
		
	}
	
	
	public static boolean judgeSquareSum(int c) {
		
		

		for (int i = 1; i <= Math.sqrt(c); i++) {

			if (isPerfectSquare(c  - i * i)) {
				return true;
			}
		}
		return false;

	}

	public static String addStrings(String num1, String num2) {
		char[] a = num1.toCharArray();
		char[] b = num2.toCharArray();

		StringBuffer result = new StringBuffer();

		int i = a.length - 1;
		int j = b.length - 1;
		
		
		int carry_over = 0;
		
		while (i >= 0 || j >= 0) {
			int i_digit =  i < 0 ? 0 : Character.getNumericValue(a[i]);
			int j_digit =  j < 0 ? 0 : Character.getNumericValue( b[j]);
			
			int digit = i_digit + j_digit + carry_over;
			carry_over = 0;
			if(digit >= 10) {
				
				digit = digit%10;
				carry_over  = 1;
			}
			i--;
			j--;
			result.append(String.valueOf(digit));
		}
		
		if(carry_over == 1) {
			result.append(String.valueOf(carry_over));
		}

		return result.reverse().toString();

	}

	public List<Integer> addToArrayForm(int[] A) {

		
		int[] a = A;
		

		
		int [] b = {1};

		List<Integer> list = new ArrayList<>();
		
		int i = a.length - 1;
		int j = b.length - 1;
		
		
		int carry_over = 0;
		
		while (i >= 0 || j >= 0) {
			int i_digit =  i < 0 ? 0 : a[i];
			int j_digit =  j < 0 ? 0 : Character.getNumericValue( b[j]);
			
			int digit = i_digit + j_digit + carry_over;
			carry_over = 0;
			if(digit >= 10) {
				
				digit = digit%10;
				carry_over  = 1;
			}
			i--;
			j--;
			list.add(digit);
		}
		
		if(carry_over == 1) {
			list.add(carry_over);
		}
		
		Collections.reverse(list);

		return list;
	}
	
	
	
	
	public int[] plusOne(int[] a) {

		int[] b = { 1 };

		List<Integer> list = new ArrayList<>();

		int i = a.length - 1;
		int j = b.length - 1;

		int carry_over = 0;

		while (i >= 0 || j >= 0) {
			int i_digit = i < 0 ? 0 : a[i];
			int j_digit = j < 0 ? 0 : Character.getNumericValue(b[j]);

			int digit = i_digit + j_digit + carry_over;
			carry_over = 0;
			if (digit >= 10) {

				digit = digit % 10;
				carry_over = 1;
			}
			i--;
			j--;
			list.add(digit);
		}

		if (carry_over == 1) {
			list.add(carry_over);
		}

		Collections.reverse(list);

		return list.stream().mapToInt(k -> k).toArray();
	}
	
	public static int reverse(int x) {

		boolean is_negative = x > 0 ? false : true;
		if (is_negative) {
			x = x * -1;
		}

		StringBuffer s = new StringBuffer("");
		while (x > 0) {

			int r = x % 10;
			x = x / 10;
			s.append(r);

		}
		int r;
		try {
			r = Integer.parseInt(s.toString());
		} catch (NumberFormatException e) {
			return 0;
		}
		if (is_negative) {
			r = r * -1;
		}
		return r;
		
		
	
	}

	public String reverseStr(String s, int k) {
		return s;

	}
	
	
	public static int removeElement(int[] nums, int val) {

		int j = nums.length - 1;
		int i = 0;
		while (i <= j) {

			if (nums[i] == val) {

				if (nums[j] != val) {

					nums[i] = nums[j];
					nums[j] = val;
					j--;
					i++;
				}

				else {
					j--;
				}
			}

			else {
				i++;
			}

		}
		return i;
	}
	
	public static void  moveZeroes(int[] nums) {

		int j = 0;
		int i = 0;

		while (j <= nums.length - 1 && i <= nums.length - 1) {
			while (i <= nums.length - 1) {
				if (nums[i] == 0) {
					
					break;
				}
				else {
					i++;
				}
				
			}

			while (nums[j] != 0  && j <= nums.length - 1 ) {
				j++;
			}

			nums[i] = nums[j];
			nums[j] = 0;
			
			
		}
		
		System.out.println(Arrays.toString(nums));
	}
	
	
	
	public static int[]  findErrorNums(int[] nums) {
		int[] arr = new int[nums.length + 1];

		int[] r = new int[2];
		for (int j = 0; j < nums.length; j++) {
			arr[nums[j]] = arr[nums[j]] == 0 ? 1 : -1;
		}

		for (int j = 1; j < arr.length; j++) {
			if (arr[j] == -1) {
				r[0] = j;
			}

			else if (arr[j] == 0) {
				r[1] = j;
			}
		}
		return r;
	}
	
	
	public static boolean backspaceCompare(String S, String T) {

		Stack<Character> s = new Stack<>();

		Stack<Character> t = new Stack<>();

		for (int i = 0; i < S.length(); i++) {

			if (S.charAt(i) == '#') {
				if (!s.empty()) {
					s.pop();
				}
			}

			else {
				s.push(S.charAt(i));
			}
		}

		for (int i = 0; i < T.length(); i++) {

			if (S.charAt(i) == '#') {
				if (!t.empty()) {
					t.pop();
				}
			}

			else {
				t.push(T.charAt(i));
			}
		}

		if (s.size() != t.size()) {
			return false;
		} else {
			while (!s.isEmpty()) {
				if (s.pop() != t.pop()) {
					return false;
				}
			}
		}
		return true;

	}
	
	
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		
		if(s.length() % 2 == 1) {
			return false;
		}

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') {
				stack.push(s.charAt(i));
			}

			else if (s.charAt(i) == ']') {
				if (stack.isEmpty() || stack.pop() != '[') {
					return false;
				}
			}

			else if (s.charAt(i) == ')') {
				if (stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
			}

			else {
				if (stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
			}
		}
		return stack.empty();
	}
	
	
	public static int pivotIndex(int[] nums) {
		int array_sum = 0;
		if(nums.length == 0) {
			return -1;
		}
		for (int i = 0; i <= nums.length - 1; i++) {
			array_sum = array_sum + nums[i];
		}

		int left_sum = 0;
		int right_sum = array_sum - nums[0];

		for (int i = 0; i < nums.length - 1; i++) {

			if (left_sum == right_sum) {
				return i;
			}

			if (left_sum > right_sum) {
				return -1;
			}

			else {
				left_sum = left_sum + nums[i];
				right_sum = right_sum - nums[i + 1];
			}
		}
		return -1;
	}
	
	public static int thirdMax(int[] A) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : A) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
	}
	
	
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

		Stack<Integer> stack = new Stack<>();

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums2.length; i++) {
			if (stack.isEmpty()) {
				stack.push(nums2[i]);
			}

			else {
			
					while (!stack.isEmpty() && stack.peek() < nums2[i]) {
						map.put(stack.pop(), nums2[i]);
					}
				
				
				stack.push(nums2[i]);
			}
		}

		while (!stack.isEmpty()) {
			map.put(stack.pop(), -1);
		}
		

		int[] r = new int[nums1.length];

		for (int i = 0; i < nums1.length; i++) {

			Integer v = map.get(nums1[i]);

			r[i] = v == null ? -1 : v;
		}

		//System.out.println(Arrays.toString(r));
		return r;

	}

	public static int findNthDigit(int n) {

		if (n <= 9) {
			return 9;
		}

		int j = 1;
		long number_of_digits = 0;
		while (number_of_digits < n) {
			number_of_digits = (long) (number_of_digits + 9 * j * Math.pow(10, j - 1));
			j++;
		}

		int k = j;
		long sum = n;
		long x = 0;
		while (k > 0) {
			sum = (long) (sum - 9 * k * Math.pow(10, k - 1));
			x = (long) (x + 9 * k * Math.pow(10, k - 1));
		}
		System.out.println(j);
		return 0;
	}
	
	public static int[] twoSum(int[] numbers, int target) {

		int r[] = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			r[0] = i + 1;

			Integer val = binarySearch(numbers, 0, numbers.length - 1, Math.abs(target - numbers[i]));

			if (val != null) {
				r[1] = val + 1;
				return r;
			}

		}
		return numbers;
	}
    
	public static int binarySearch(int[] numbers, int low, int high, int target) {

		if (low > high) {
			return -1;
		}

		int mid = (high + low) / 2;

		if (numbers[mid] == target) {
			return mid;
		} else if (numbers[mid] > target) {
			return binarySearch(numbers, low, mid - 1, target);
		} else {
			return binarySearch(numbers, mid + 1, high, target);

		}

	}
	
	boolean isBadVersion(int version) {
		return false;
		
	}
	public int firstBadVersion(int n) {
	
		int i = 1;
		int j  = n;
		int mid = i + (j - i) / 2;
		
		while(i < j) { 
			if(!isBadVersion(mid)) {
				i = mid + 1;
			}	else {
				j = mid;
			}
		}
		return i;
	}
	
	public int bitwiseComplement(int N) {
		int c = 0;
		int i = 0;
		while (N > 0) {
			int r = N % 2;
			N = N / 2;
			r = r == 0 ? 1: 0;
			c = (int) (c + r * Math.pow(2, i));
			i++;
		}
		return c;
	}

	public static int binaryGap(int N) {

		int max_distance = 0;
		int cur_distance = 0;

		boolean is_one_occured = false;

		while (N > 0) {
			int r = N % 2;

			if (is_one_occured) {

				if (r == 1) {
					cur_distance++;

					max_distance = max_distance > cur_distance ? max_distance : cur_distance;
					cur_distance = 0;
				} else {
					cur_distance++;
				}

			}

			if (r == 1 && !is_one_occured) {
				is_one_occured = true;

			}
			N = N / 2;

		}

		return max_distance;

	}
	
	public static String addBinary(String a, String b) {
		int A = 0;
		int B = 0;

		for (int i = a.length() - 1; i >= 0; i--) {
			A = (int) (A + Character.getNumericValue(a.charAt(i)) * Math.pow(2, a.length()-1 - i));
		}

		for (int i = b.length() - 1; i >= 0; i--) {
			B = (int) (B + Character.getNumericValue(b.charAt(i)) * Math.pow(2, b.length() - 1 - i));

		}

		int c = A + B;

		StringBuffer r = new StringBuffer();

		while (c > 0) {
			r.append(c % 2);
			c = c / 2;
		}
		return r.reverse().toString();

	}
	
	
	public static char nextGreatestLetter(char[] letters, char target) {

		if (target >= letters[letters.length - 1]) {
			return letters[0];
		}
		
		if (target < letters[0]) {
			return letters[0];
		}

		for (int i = 0; i < letters.length - 1; i++) {
			if (letters[i] <= target && letters[i + 1] > target) {
				return letters[i+1];
			}
		}

		return target;

	}
	

	public static int[] dailyTemperatures(int[] T) {

		Stack<Integer> stack = new Stack<>();
		int[] sol = new int[T.length];

		for (int i = 0; i < T.length; i++) {
			if (stack.isEmpty()) {
				stack.push(i);
			}

			else {
				while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
					int top = stack.pop();
					sol[top] = i - top;
				}
				stack.push(i);
			}
		}

		while (!stack.isEmpty()) {
			sol[stack.pop()] = 0;
		}
		return T;
	}
	
	
	class Solution {
		public List<Integer> powerfulIntegers(int x, int y, int bound) {
			
			Map<Integer, Integer> map = new HashMap<>();

			for (Integer i = 0; i <= bound; i++) {

				map.put(i, i * i);
			}
			
			

			for (Integer i = x; i <= y; i++) {

				map.put(i, i * i);
			}
			
			return null;
		}
	}
	
	
    
	public static String[] findRestaurant(String[] list1, String[] list2) {

		Integer least_index_sum = 2500;
		List<String> list = new ArrayList<>();
		
		boolean is_list_one_bigger = list1.length > list2.length;

		String[] r_list = is_list_one_bigger ? list1 : list2;
		Map<String, Integer> r_map = null;

		if (is_list_one_bigger) {

			Map<String, Integer> map2 = new HashMap<String, Integer>();

			for (int k = 0; k < list2.length; k++) {
				map2.put(list2[k], k);
			}

			r_map = map2;

		}

		else {

			Map<String, Integer> map1 = new HashMap<String, Integer>();

			for (int k = 0; k < list1.length; k++) {
				map1.put(list1[k], k);
			}

			r_map = map1;

		}

		for (int k = 0; k < r_list.length; k++) {

			Integer l = r_map.get(r_list[k]);

			if (l != null) {

				int index_sum = l + k;

				if (index_sum < least_index_sum) {
					list.clear();
					list.add(r_list[k]);
					least_index_sum = l + k;
				}

				else if (index_sum == least_index_sum) {
					list.add(r_list[k]);
				}
			}
		}
		String[] returnArr = new String[list.size()];
		return list.toArray(returnArr);
	}
	
	public static boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {

		if (words1.length != words2.length) {
			return false;
		}

		Set<String> lol = new HashSet<>();

		for (int k = 0; k < pairs.length; k++) {
			for (int j = 0; j < pairs[k].length; j++) {
				lol.add(pairs[k][0] + "#" + pairs[k][1]);
			}
		}

		for (int k = 0; k < words1.length; k++) {
			if (!words1[k].equals(words2[k])
					&& !(lol.contains(words1[k] + "#" + words2[k]) || lol.contains(words2[k] + "#" + words1[k]))) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isOneBitCharacter(int[] bits) {
		boolean isOneBit = true;
		for (int j = 0; j < bits.length; j++) {
			if (bits[j] == 1) {
				j++;
				isOneBit = false;
			}
			else {
				isOneBit = true;
			}
		}
		return isOneBit;
	}
	
	
	public List<List<Integer>> largeGroupPositions(String S) {

		List<List<Integer>> result = new ArrayList<>();
		int start = 0, end = 0;
		for (int j = 1; j < S.length(); j++) {

			if (S.charAt(j - 1) == S.charAt(j)) {
				end++;
			} else {
				if (end - start > 2) {
					result.add(Arrays.asList(start, end));
				}
				start = j;
				end = j;
			}
		}
		return result;

	}
	
	
	public static boolean checkTriangleValidity(int a, int b, int c) {
		// check condition
		if (a + b <= c || a + c <= b || b + c <= a)
			return false;
		else
			return true;
	}
	
	
	public static int hammingDistance(int x, int y) {

		int bigger_num = x > y ? x : y;
		int small_num = x < y ? x : y;

		List<Integer> add = new ArrayList<>();

		while (bigger_num > 0) {
			add.add(bigger_num % 2);
			bigger_num = bigger_num / 2;
		}

		Collections.reverse(add);

		Integer[] returnArr = new Integer[add.size()];
		returnArr = add.toArray(returnArr);

		int[] returnArr2 = new int[add.size()];

		int j = add.size() - 1;

		while (small_num > 0) {
			returnArr2[j] = small_num % 2;
			small_num = small_num / 2;
			j--;
		}

		int r = 0;
		int k = add.size() - 1;

		while (k >= 0) {
			if (returnArr2[k] != returnArr[k]) {
				r++;
				
			}
			k--;
		}

		return r;

	}

	public static List<String> subdomainVisits(String[] cpdomains) {

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < cpdomains.length; i++) {

			String[] lol = cpdomains[i].split(" ");
			int count = Integer.parseInt(lol[0]);
			String[] arr = lol[1].split("\\.");

			if (arr.length == 2) {

				Integer c = map.get(arr[1]);
				map.put(arr[1], c == null ? count : c + count);

				String str = arr[0] + "." + arr[1];
				c = map.get(str);
				map.put(str, c == null ? count : c + count);
			}

			else {

				Integer c = map.get(arr[2]);
				map.put(arr[2], c == null ? count : c + count);

				String str = arr[1] + "." + arr[2];
				c = map.get(str);
				map.put(str, c == null ? count : c + count);

				str = arr[0] + "." + arr[1] + "." + arr[2];
				c = map.get(str);
				map.put(str, c == null ? count : c + count);
			}
		}
		List<String> result = new ArrayList<>();
		for (Entry<String, Integer> entry : map.entrySet()) {
			result.add(entry.getValue() + " " + entry.getKey());
		}
		return result;
	}

	public static int minAddToMakeValid(String S) {
		Stack<Character> stack = new Stack<>();
		int count = 0;
		for (int i = 0; i < S.length(); i++) {

			if (S.charAt(i) == '(') {
				stack.push('(');
			}

			else {
				if (stack.isEmpty() || stack.peek() == ')') {
					count++;
				}

				else if (!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				}
			}
		}
		while (!stack.isEmpty()) {
			stack.pop();
			count++;
		}
		return count;
	}
	
	public static String mostCommonWord(String paragraph, String[] banned) {

		
	    String[] arr = (paragraph.split("\\W+"));


		Set<String> banned_set = Stream.of(banned).map(e -> e.toLowerCase()

		).collect(Collectors.toSet());

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < arr.length; i++) {

			String word = arr[i].toLowerCase();
			if (!banned_set.contains(word)) {
				Integer c = map.get(word);
				map.put(word, c == null ? 1 : c + 1);
			}
		}

		Integer max = -1;
		String max_str = null;
		for (Entry<String, Integer> entry : map.entrySet()) {

			if (entry.getValue() > max) {
				max_str = entry.getKey();
				max = entry.getValue();
			}
		}
		return max_str;
	}
}