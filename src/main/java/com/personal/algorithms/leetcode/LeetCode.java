package com.personal.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LeetCode {

	public static void main(String[] args) {
		
		/*for(Integer i = 0; i <= 10000; i++) {
			if(isStrobogrammatic(i.toString())) {
				System.err.println(i);

			}
		}*/
		System.err.println(isLongPressedName("pyplrz", "ppyypllr"));
	}

	public static int[] sortedSquares(int[] A) {

		return Arrays.stream(A).map(a -> a * a).sorted().toArray();
	}

	public static int[] sortArrayByParityII(int[] A) {

		int[] EA = Arrays.stream(A).filter(a -> a % 2 == 0).sorted().toArray();
		int[] OA = Arrays.stream(A).filter(a -> a % 2 == 1).sorted().toArray();

		for (int i = 0; i < A.length / 2; i++) {
			A[2 * i] = EA[i];
			A[2 * i + 1] = OA[i];
		}
		return A;
	}

	public static String toLowerCase(String str) {
		return str.toLowerCase();
	}

	public static int numUniqueEmails(String[] emails) {

		return Arrays.stream(emails).map(email -> {
			String p1 = email.substring(0, email.indexOf("@"));
			String p2 = email.substring(email.indexOf("@") + 1);

			while (p1.contains(".")) {
				int p = p1.indexOf(".");
				p1 = p1.substring(0, p) + p1.substring(p + 1);
			}
			while (p1.contains("+")) {
				int p = p1.indexOf("+");
				p1 = p1.substring(0, p);

			}
			return p1 + '@' + p2;
		}).collect(Collectors.toSet()).size();
	}

	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		Arrays.stream(nums).sorted().toArray();
		for (int i = 0; i < nums.length;) {
			if (nums[i] != i + 1 || nums[i] != i + 1) {

			}
		}
		return result;
	}

	public static int[] sortArrayByParity(int[] A) {
		for (int i = 0, j = A.length - 1; i < A.length && j >= 0 && i < j;) {
			int a = i;
			int b = j;
			if (A[i] % 2 == 0) {
				i++;
			}

			if (A[j] % 2 == 1) {
				j--;
			}

			if (A[b] % 2 == 0 && A[a] % 2 == 1) {
				int temp = A[a];
				A[a] = A[b];
				A[b] = temp;
				i++;
				j--;
			}
		}
		System.out.println(Arrays.toString(A));

		return A;
	}

	public static int missingNumber(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
		}
		return (nums.length * (nums.length + 1) / 2) - sum;
	}

	public static int maximumProduct(int[] nums) {

		int i, first, second, third, n_first, n_second;

		/* There should be atleast two elements */

		third = first = second = Integer.MIN_VALUE;
		n_first = n_second = Integer.MAX_VALUE;

		for (i = 0; i < nums.length; i++) {
			/*
			 * If current element is smaller than first
			 */
			if (nums[i] > first) {
				third = second;
				second = first;
				first = nums[i];
			}

			/*
			 * If arr[i] is in between first and second then update second
			 */
			else if (nums[i] > second) {
				third = second;
				second = nums[i];
			}

			else if (nums[i] > third)
				third = nums[i];

			if (nums[i] < n_first) {
				n_second = n_first;
				n_first = nums[i];
			}

			else if (nums[i] < n_second) {
				n_second = nums[i];
			}
		}

		int max_1 = first * second * third;
		int max_2 = n_second >0 ? 0: n_first * n_second * first;

		if (max_1 > max_2)
			return max_1;
		else
			return max_2;
	}
	
	public static boolean isPowerOfTwo(int n) {
		
		if(n <=0 )
			return false;

		do {
			if (n % 2 != 0) {
				break;
			}
			n = n / 2;
		} while (n > 1);
		if (n > 1 && n % 2 != 0) {
			return false;

		}
		return true;
	}
	
	
	public static boolean isPowerOfThree(int n) {
		
		if(n <=0 )
			return false;

		do {
			if (n % 3 != 0) {
				break;
			}
			n = n / 3;
		} while (n > 1);
		if (n > 1 && n % 3 != 0) {
			return false;

		}
		return true;
	}
	
	public static boolean isPowerOfFour(int n) {
		
		if(n <=0 )
			return false;

		do {
			if (n % 4 != 0) {
				break;
			}
			n = n / 4;
		} while (n > 1);
		if (n > 1 && n % 4 != 0) {
			return false;

		}
		return true;
	}
	
	public static int hammingWeight(int n) {
		String str = Integer.toBinaryString(n);
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1')
				count++;
		}
		return count;
	}
	
	public static boolean isUgly(int num) {
		if (num == 0)
			return false;

		while (num != 1) {
			if (num % 2 == 0) {
				num = num / 2;
			} else if (num % 3 == 0) {
				num = num / 3;
			} else if (num % 5 == 0) {
				num = num / 5;
			}

			else {
				return false;
			}

		}

		return true;
	}

	public static boolean isPrime2(int n) {

		if (n <= 1) {
			return false;

		}

		if (n <= 3) {
			return true;

		}

		if (n % 2 == 0 || n % 3 == 0)
			return false;

		for (int i = 5; i * i < n; i = i + 6) {
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
		}

		return true;

	}
	
	public static boolean isPrime(int num){
	    if ( num > 2 && num%2 == 0 ) {
	        return false;
	    }
	    int top = (int)Math.sqrt(num) + 1;
	    for(int i = 3; i < top; i+=2){
	        if(num % i == 0){
	            return false;
	        }
	    }
	    return true; 
	}
	
	   public static int countPrimes(int n) {
		   int count = 0;
	        for(int i = 2; i<n; i++) {
	        	if(isPrime(i))
	        		count++;
	        }
			return count;
	    }
	   
	public int findMaxConsecutiveOnes(int[] nums) {
		int count = 0;
		int max_count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				if (max_count < count) {
					max_count = count;
				}
				count = 0;
			} else {
				count++;
				if (max_count < count) {
					max_count = count;
				}
			}
		}
		return max_count;
	}

	public static void reverseString(char[] s) {
		for (int i = 0; i < s.length/2; i++) {
			char temp = s[i];
			s[i] = s[s.length-i-1];
			s[s.length-i-1] = temp;
		}
	}
	
	public int largestPerimeter(int[] A) {
        if(A.length<3)  return 0;
        Arrays.sort(A);
        for(int i=A.length-1;i>=2;i--){
            if(A[i-2]+A[i-1]>A[i])  return A[i-2]+A[i-1]+A[i];
        }
        return 0;
    }
	
	List<Integer> primeFactors(int n) 
	{ 
		List<Integer> list = new ArrayList<>();
	    // Print the number of 2s that divide n 
	    while (n%2 == 0) 
	    { 
	    	list.add(2) ;
	        n = n/2; 
	    } 
	  
	    // n must be odd at this point.  So we can skip  
	    // one element (Note i = i +2) 
	    for (int i = 3; i <= Math.sqrt(n); i = i+2) 
	    { 
	        // While i divides n, print i and divide n 
	        while (n%i == 0) 
	        { 
	        	list.add(i) ;
	            n = n/i; 
	        } 
	    } 
	  
	    // This condition is to handle the case when n  
	    // is a prime number greater than 2 
	    if (n > 2) 
	    	list.add(n) ; 
	    
	    return list;
	} 
	
	public static int numJewelsInStones(String J, String S) {

		char[] jewel_array = J.toCharArray();
		char[] stone_array = S.toCharArray();

		Map<Character, Integer> s = new HashMap<>();
		Map<Character, Integer> j = new HashMap<>();

		int jewel_count = 0;

		for (int i = 0; i < jewel_array.length; i++) {
			j.put(jewel_array[i], 1);
		}

		for (int i = 0; i < stone_array.length; i++) {
			Integer f = s.get(stone_array[i]);
			s.put(stone_array[i], f == null ? 1 : f + 1);
		}

		for (Entry<Character, Integer> entry : s.entrySet()) {
			if (j.keySet().contains(entry.getKey())) {
				jewel_count = jewel_count + entry.getValue();
			}
		}

		return jewel_count;
	}
	
	  public boolean containsDuplicate(int[] nums) {
	       
			Map<Integer, Integer> map = new HashMap<>();


			for (int i = 0; i < nums.length; i++) {
				Integer f = map.get(nums[i]);
				map.put(nums[i], f == null ? 1 : f + 1);
			}
			
		
			for (Entry<Integer, Integer> entry : map.entrySet()) {
				if(entry.getValue() > 1) {
					return true;
				}
			}
			return false;

	    }
	  
	  
	public static boolean isMonotonic(int[] A) {

		boolean is_increasing = true;

		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] > A[i + 1]) {
				is_increasing = false;
			}
		}

		if (is_increasing) {
			return true;
		}

		boolean is_decreasing = true;

		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] < A[i + 1]) {
				is_decreasing = false;
			}
		}

		return is_decreasing;

	}

	public static void moveZeroes(int[] nums) {
		


			for (int i = nums.length - 1; i > 0; i--) {

				if (nums[i] == 0 && nums[i - 1] == 0) {
					continue;
				}

				else if (nums[i - 1] == 0 && nums[i] != 0) {
					int temp = nums[i];
					nums[i] = nums[i - 1];
					nums[i - 1] = temp;
				}
			}
			

			for (int i = 0; i < nums.length - 1; i++) {

				if (nums[i] == 0 && nums[i + 1] == 0) {
					continue;
				}

				else if (nums[i] == 0 && nums[i+1] != 0) {
					int temp = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1] = temp;
				}
			}
		
		
		
		System.out.println(Arrays.toString(nums));

	}
	

	public static int singleNumber(int[] nums) {
		int initial_num = nums[0];
		for (int i = 1; i <=nums.length - 1; i++) {
			initial_num = initial_num ^ nums[i];
		}
		return initial_num;
	}
	
	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> duplicate_list = new ArrayList<>();
		List<Integer> not_present_list = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int j = nums[i] > 0 ? nums[i] : -1 * nums[i];
			nums[j - 1] = nums[j - 1] > 0 ? -nums[j - 1] : nums[j - 1];
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				duplicate_list.add(i + 1);
				nums[i] = -nums[i];
			}
		}

		for (int i = 0; i < nums.length; i++) {
			int j = nums[i] > 0 ? nums[i] : -1 * nums[i];
			nums[j - 1] = -1 * nums[j - 1];
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				not_present_list.add(i + 1);
				nums[i] = -nums[i];
			}
		}

		not_present_list.removeAll(duplicate_list);
		return not_present_list;
	}
	
	
	public static List<Integer> findDuplicatesV2(int[] nums) {
		List<Integer> duplicate_list = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int j = Math.abs(nums[i]);
			
			
			if(nums[j-1] > 0) {
				nums[j-1] = -nums[j-1];
			}
			else {
				duplicate_list.add(j);
			}
		}

		return duplicate_list;
	}
	
	  public static List<Integer> findDisappearedNumbersV2(int[] nums) {
			List<Integer> not_present_list = new ArrayList<>();

			for (int i = 0; i < nums.length; i++) {
				int j = Math.abs(nums[i]);
				nums[j - 1] = nums[j - 1] > 0 ? -nums[j - 1] : nums[j - 1];
			}

			for (int i = 0; i < nums.length; i++) {
				if (nums[i] > 0) {
					not_present_list.add(i + 1);
				}
			}
			return not_present_list;
	    }

	public static int findDuplicate(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int j = Math.abs(nums[i]);
			
			
			if(nums[j-1] > 0) {
				nums[j-1] = -nums[j-1];
			}
			else {
				return j;
			}
		}
		return 0;
	}
	
	  /* public int thirdMax(int[] nums) {
	        if(nums.length == 1) {
	        	return nums[0];
	        }
	        
	        else if(nums.length == 2) {
	        	return Math.max(nums[0], nums[1]);
	        }
	        else {

			int first_max = (nums[0] > nums[1]) ? (nums[0] > nums[2] ? nums[0] : nums[2])
					: nums[1] > nums[2] ? nums[1] : nums[2];
	        	int second_max = 0;

	        	int third_max = 0;
	        	
	    		for (int i = 3; i < nums.length; i++) {
	    		}
	        }
			return 0;
	    }*/
	
	
	  public static String reverseWords(String s) {
		return String.join(" ", Arrays.asList(s.split(" "))
				                      .stream()
				                      .map(str -> { return new StringBuilder().append(str).reverse();
		}).collect(Collectors.toList()));
	}

	public static boolean detectCapitalUse(String word) {


		IntStream list = word.chars();
		IntStream lis2 = word.chars();

		if (list.allMatch(Character::isUpperCase) || lis2.allMatch(Character::isLowerCase)) {
			return true;
		} else {

			if (Character.isUpperCase(word.toCharArray()[0])) {
				return word.substring(1).chars().allMatch(Character::isLowerCase);
			}
			return false;
		}
	}

      // TODO: Failing for large numbers
	  public static int[] plusOne(int[] digits) {
		long num = digits[digits.length - 1];
		for (int i = digits.length - 2; i >= 0; i--) {
			num = num + (long) (digits[i] * Math.pow(10, digits.length - 1 - i));
		}
		num = num + 1;
		
		/*for (int i : Long.toString(num).chars().map(c -> c-'0').toArray()) {
            System.out.println(i);
        }*/
	
		 return  Long.toString(num).chars().map(c -> c-'0').toArray();
		 
		/* for (int i : lol) {
	            System.out.println(i);
	        }
 
		
	    int[] arr = new int[digits[digits.length - 1] == 9 ? digits.length + 1: digits.length];

	    	int j = arr.length - 1;
	    	while(num > 0) {
	    		
	    		arr[j] = num%10;

	    		num = num/10;
	    		j--;
	    	}
	    	
	    	 for (int i : arr) {
		            System.out.println(i);
		        }
	    
	        return arr;*/
	        
	       
	    }
	  
	  
	   public static List<Integer> selfDividingNumbers(int left, int right) {
		   List<Integer> list = new ArrayList<>();
		   
		   for (int i = left; i <= right; i++) { 
			   
			   if(isSelfDividingNumber(i)) {
				   list.add(i);
			   }
		   }
		return list;
	        
	    }
	   
	   public static boolean isSelfDividingNumber(int num) {
		   int a = num;
		   while(num > 0) {
			   int r = num%10;
			   num = num/10;
			   
			   if(r == 0 || a%r != 0) {
				   return false;
			   }
		   }
		return true;
		   
	   }
	   
	   public static int arrayPairSum(int[] nums) {
	        
		   Arrays.sort(nums);
		   int sum = 0;
		   for(int i = 0; i < nums.length; i ++) {
			   sum = sum + nums[i];
			   i++;
		   }
		   return sum;
	    }
	   
	public static String[] uncommonFromSentences(String A, String B) {

		String[] arr_1 = A.split(" ");

		Map<String, Integer> map_1 = new HashMap<>();

		for (int i = 0; i < arr_1.length; i++) {
			Integer c = map_1.get(arr_1[i]);
			int n = c == null ? 1 : c + 1;
			map_1.put(arr_1[i], n);	
		}

		String[] arr_2 = B.split(" ");

		Map<String, Integer> map_2 = new HashMap<>();

		for (int i = 0; i < arr_2.length; i++) {
			Integer c = map_2.get(arr_2[i]);
			int n = c == null ? 1 : c + 1;
			map_2.put(arr_2[i], n);
		}
		
		Set<String> result = new HashSet<>();
		
		for (int i = 0; i < arr_1.length; i++) {
			if(map_1.get(arr_1[i]) == 1 && (!map_2.containsKey(arr_1[i])))	{
				result.add(arr_1[i]);
			}
		}
		
		for (int i = 0; i < arr_2.length; i++) {
			if(map_2.get(arr_2[i]) == 1 && (!map_1.containsKey(arr_2[i])))	{
				result.add(arr_2[i]);
			}
		}
		
		System.out.println(result);
		 int n = result.size(); 
	        String arr[] = new String[n]; 
	  
	        int i = 0; 
	        for (String x : result) 
	            arr[i++] = x; 
		
		return arr;
	}
	
	  public int[] anagramMappings(int[] A, int[] B) {
		  int result[] = new int[A.length];
		  for (int i = 0; i < A.length; i++) { 
			  
			  for (int j = 0; j < B.length; j++) { 
				  if(A[i] == B[j]) {
					  result[i] = j;
				  }
				  
			  }
		  }
		  return result;
	    }

	public int uniqueMorseRepresentations(String[] words) {
		String arr[] = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
				"-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
		Set<String> set = new HashSet<>();
		for (int i = 0; i < words.length; i++) {
			char[] word = words[i].toCharArray();
			String exp = "";
			for (int j = 0; j < word.length; j++) { 
				exp = exp + arr[(int)word[j] - (int)'a'];
			}
			set.add(exp);
		}
		return set.size();
	}
	
	public static int[] diStringMatch(String S) {

		char[] word = S.toCharArray();
		int d = S.toCharArray().length;
		int result[] = new int[d + 1];

		int i = 0;
		
		
		for (int j = 0; j < word.length; j++) { 
				if(word[j] == 'I') {
					result[j] = i;
					i ++;
					
				}
				else {
					result[j] = d;
					d --;
				}
		}
		result[S.toCharArray().length] = d;
		return result;
	}
	
	
	   public static List<String> commonChars(String[] A) {
		   
		   
		   List<Map<Integer, Integer>> map_list = new ArrayList<>();
			for (int i = 0; i < A.length; i++) { 
				
				char[] arr = A[i].toCharArray();
				
			Map<Integer, Integer> map = new HashMap<>();

				
				for (int j = 0; j < arr.length; j++) { 
					
					int word = (int)arr[j] - (int)('a');
					
					Integer count = map.get(word);
					
					if(count == null) {
						map.put(word, 1);
					}
					
					else {
						map.put(word, count + 1);

					}
					
				}
				
				map_list.add(map);
				
			}
			List<String> result = new ArrayList<>();
			
			for (int j = 0; j <= 25; j++) {  
				Integer count = Integer.MAX_VALUE;
				for (int i = 0; i < map_list.size(); i++) {  
					int c = map_list.get(i).get(j) == null ? 0 : map_list.get(i).get(j);
				
				count = count > c ? c : count;
				}
				
				for(int i =0; i < count; i++) {
					result.add(Character.toString((char)(j + 97)));
				}
			}
			return result;
	    }
	   
	public static int removeElement(int[] nums, int val) {
		int count = 0;
		int j = nums.length - 1;
		while (nums.length >= 0 && j >=0 && nums[j] == val ) {
			{
				count++;
				j--;

			}
		}
		
		for (int i = 0; i < nums.length && j >= 0 && i <= j; i++) {
			
	
			
			if (nums[i] == val) {
				count++;
				int temp = nums[j] ;
				nums[j] = nums[i];
				nums[i] = temp;
				 j--;
				
			}
	
		}
		System.out.println(Arrays.toString(nums));
		return nums.length - count;
	}
	
	public static int dominantIndex(int[] nums) {

		int max = Integer.MIN_VALUE;
		int max_index = 0;
		for (int i = 0; i < nums.length; i++) {

			if (nums[i] > max) {
				max = nums[i];
				max_index = i;
			}
		}

		for (int i = 0; i < nums.length; i++) {

			if (i != max_index && nums[i] < 2 * max) {
				return -1;
			}

		}

		return max_index;

	}
	
	// "abcdddeeeeaabbbcd"
	public static List<List<Integer>> largeGroupPositions(String S) {
		List<List<Integer>> result = new ArrayList<>();

		char[] array = S.toCharArray();
		int start_index = 0;
		for (int i = 0; i < array.length; i++) {
			
			int count = 0;
			while (i < array.length && array[i] == array[start_index]  ) {
				count++;
				i++;
			}
			int end_index = start_index + count - 1;

			if (count >= 2) {
				ArrayList<Integer> list = new ArrayList<>();

				list.add(start_index);
				list.add(end_index);

				result.add(list);
			}
			 start_index = end_index;
			 i = end_index;
			//i = end_index - 1;

		}
		return result;
	}
	
	public static List<Integer> addToArrayForm(int[] A, int K) {
		Long num = 0L;
		for (int i = A.length - 1; i >= 0; i--) {

			num = (long) (num + A[i] * (Math.pow(10, A.length - 1 - i)));

		}

		num = num + K;
		
		 List<Integer>  result = new ArrayList<>();
		 if(num == 0) {
			 result.add(0);
			 return result;
		 }
		while(num > 0) {
			int r = (int) (num % 10);
			num = num /10;

			result.add(r);
		}
	    Collections.reverse(result);

		return result;
	}
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		
	}
	
	
	public static int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] { i, map.get(complement) };
			}
		}
		throw new IllegalArgumentException("No two sum solution");

	}
	
	
	public static int findShortestSubArray(int[] nums) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			Integer count = map.get(nums[i]);
			map.put(nums[i], count == null ? 1 : count +1);
		}

		int degree = Integer.MIN_VALUE;
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > degree) {
				degree = entry.getValue();
			}
		}

		int min_sub_array = Integer.MAX_VALUE;

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == degree) {
				int num = entry.getKey();
				int start = 0;
				int end = 0;
				boolean is_start_found = false;

				for (int i = 0; i < nums.length; i++) {

					if (nums[i] == num && !is_start_found) {
						start = i;
						end = i;
						is_start_found = true;
					}

					else if (nums[i] == num) {
						end = i;
					}

				
				}
				
				if ((end - start  + 1) < min_sub_array) {
					min_sub_array = end - start  + 1;
				}
			}
		}

		return min_sub_array;

	}
	
	public static int shortestWordDistance(String[] words, String word1, String word2) {
		Integer current_word_occurence = -1;
		Integer short_distance = words.length;

		for (int i = 0; i < words.length; i++) {

			if (words[i].equals(word1) || words[i].equals(word2)) {
				if (current_word_occurence != -1 
						&& (!words[current_word_occurence].equals(words[i]))) {
					int distance = i - current_word_occurence;
					short_distance = short_distance > distance ? distance : short_distance;
				}
				current_word_occurence = i;
			}
		}
		return short_distance;
	}
	
	public static int[]  getModifiedArray(int length, int[][] updates) {
		int[] a = new int[length];

		for (int i = 0; i < updates.length; i++) {
			int start_index = updates[i][0];
			int end_index = updates[i][1];
			int increment = updates[i][2];

			if (start_index <= end_index && start_index < length && end_index < length) {

				for (int j = start_index; j <= end_index; j++) {
					a[j] += increment;
				}
			}
		}
		return a;
	}
	
	
	public static boolean validMountainArray(int[] A) {
		boolean check_for_small = true;
		
		if(A.length <= 2) {
			return false;
		}

		for (int i = 0; i < A.length - 1; i++) {
			if(A[i] == A[i+1]) {
				return false;
			}
			else if (check_for_small && A[i] > A[i + 1]) {
				check_for_small = false;
			}
			else if(!check_for_small && A[i] <= A[i +1]) {
				return false;
			}
		}
		return !check_for_small;

	}

	  
	public static void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		
		if(nums.length <= 2) {
			return ;
		}
		
		int r = nums.length % 3;

		for (int i = 0; i <=nums.length - r - 2; i = i + 3) {
			int temp = nums[i + 2];
			nums[i + 2] = nums[i];
			nums[i] = temp;
		}
		
		System.out.println(Arrays.toString(nums));
	}
	 public class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }

	public boolean canAttendMeetings(Interval[] intervals) {

		List<Interval> list = Arrays.stream(intervals).sorted((h1, h2) -> h1.end - h2.end).collect(Collectors.toList());

		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).end > list.get(i + 1).start) {
				return false;
			}
		}

		return true;

	}
	
	  public int minMeetingRooms(Interval[] intervals) {
		  int count = 1;
			List<Interval> list = Arrays.stream(intervals).sorted((h1, h2) -> h1.end - h2.end).collect(Collectors.toList());

			for (int i = 0; i < list.size() - 1; i++) {
				if (list.get(i).end > list.get(i + 1).start) {
					count++;
				}
			}
			return count;
	    }
	  
	  
	   public int smallestRangeI(int[] A, int K) {
		   int max = Integer.MIN_VALUE;
		   int min = Integer.MAX_VALUE;
		   
	

			for (int i = 0; i < A.length; i++) { 
				
				if(A[i] > max) {
					max = A[i];
				}
				
				if(A[i] < min) {
					min = A[i];
				}
			}
			
			int diff = max - min;
			
			if(2*K > diff) {
				return 0;
			}
			else {
				return diff - 2*K;
			}
	    }

	   //["zxcvbnzzm","asdfghjkla","qwertyuiopq"]
			   /// ["asdfghjkla","qwertyuiopq","zxcvbnzzm","asdfghjkla","qwertyuiopq","zxcvbnzzm"]
	public static String[] findWords(String[] words) {

		List<String> set = new ArrayList<>();

		Map<Character, Integer> map_1 = new HashMap<>();

		map_1.put('q', 1);
		map_1.put('w', 1);
		map_1.put('e', 1);
		map_1.put('r', 1);
		map_1.put('t', 1);
		map_1.put('y', 1);
		map_1.put('u', 1);
		map_1.put('i', 1);
		map_1.put('o', 1);
		map_1.put('p', 1);
		map_1.put('Q', 1);
		map_1.put('W', 1);
		map_1.put('E', 1);
		map_1.put('R', 1);
		map_1.put('T', 1);
		map_1.put('Y', 1);
		map_1.put('U', 1);
		map_1.put('I', 1);
		map_1.put('O', 1);
		map_1.put('P', 1);

		Map<Character, Integer> map_2 = new HashMap<>();

		map_2.put('a', 1);
		map_2.put('A', 1);
		map_2.put('s', 1);
		map_2.put('S', 1);
		map_2.put('d', 1);
		map_2.put('D', 1);
		map_2.put('f', 1);
		map_2.put('F', 1);
		map_2.put('g', 1);
		map_2.put('G', 1);
		map_2.put('h', 1);
		map_2.put('H', 1);
		map_2.put('j', 1);
		map_2.put('J', 1);
		map_2.put('k', 1);
		map_2.put('K', 1);
		map_2.put('l', 1);
		map_2.put('L', 1);

		Map<Character, Integer> map_3 = new HashMap<>();

		map_3.put('z', 1);
		map_3.put('Z', 1);
		map_3.put('x', 1);
		map_3.put('X', 1);
		map_3.put('c', 1);
		map_3.put('C', 1);
		map_3.put('v', 1);
		map_3.put('V', 1);
		map_3.put('b', 1);
		map_3.put('B', 1);
		map_3.put('n', 1);
		map_3.put('N', 1);
		map_3.put('m', 1);
		map_3.put('M', 1);

		for (int i = 0; i < words.length; i++) {

			boolean is_word_valid = true;

			if (is_word_valid) {
				char[] word = words[i].toCharArray();
				set.add(words[i]);

				String whichRow = null;

				if (map_1.containsKey(word[0])) {
					whichRow = "isRowOne";
				}

				else if (map_2.containsKey(word[0])) {
					whichRow = "isRowTwo";

				}

				else {
					whichRow = "isRowThree";
				}

				for (int j = 1; j < word.length; j++) {

					String local = null;

					if (map_1.containsKey(word[j])) {
						local = "isRowOne";
					}

					else if (map_2.containsKey(word[j])) {
						local = "isRowTwo";

					}

					else {
						local = "isRowThree";
					}

					if (!local.equals(whichRow)) {
						set.remove(words[i]);
						is_word_valid = false;
					}
				}
			}

		}

		int n = set.size();
		String arr[] = new String[n];

		int i = 0;

		for (String x : set)
			arr[i++] = x;
		return arr;
	}
	
	public static boolean isHappy(int n) {

		Map<Integer, Integer> square_sum = new HashMap<>();

		square_sum.put(0, 0);
		square_sum.put(1, 1);
		square_sum.put(2, 4);
		square_sum.put(3, 9);
		square_sum.put(4, 16);
		square_sum.put(5, 25);
		square_sum.put(6, 36);
		square_sum.put(7, 49);
		square_sum.put(8, 64);
		square_sum.put(9, 81);
		int c = n;
		
		Set<Integer> set = new HashSet<>();
		do {

			List<Integer> result = new ArrayList<>();

			while (n > 0) {
				int r = n % 10;
				result.add(r);
				n = n / 10;
			}
			c = result.stream().mapToInt(d -> square_sum.get(d)).sum();
			System.out.println(c);
			if (c == 1) {
				break;
			}
			else {
				if (!set.contains(c)) {
					set.add(c);
				} else {
					break;
				}
			}
			n = c;
		} while (true);

		return c == 1;
	}


	public static boolean isStrobogrammatic(String num) {
		char[] arr = num.toCharArray();
		int i = 0;
		int j = arr.length - 1;
		while (i <= j) {

			if (!((arr[i] == '6' && arr[j] == '9') || (arr[i] == '9' && arr[j] == '6')
				||	(arr[i] == '8' && arr[j] == '8') 	|| (arr[i] == '1' && arr[j] == '1') || (arr[i] == '0' && arr[j] == '0'))) {
				return false;
			}
			if(i == j && (arr[i] != '6' && arr[i] != '9' && arr[i] != '0' && arr[i] != '1' && arr[i] != '8')) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	
	   public static List<String> findStrobogrammatic(int n) {
		   
		   String start = String.valueOf((int)Math.pow(10, n-1));
		   StringBuffer end = new StringBuffer("");
		   for(int i = 0; i < n; i ++) {
			   end.append("9");
		   }
		   List<String> result = new ArrayList<>();
		   
		  for(Integer i = Integer.parseInt(start); i <= Integer.parseInt(end.toString()); i++) {
			  String local_i = i.toString();
			  if(isStrobogrammatic(local_i)) {
				  result.add(local_i);
			  }
		  }
		return result;
	    }

	public int longestPalindrome(String s) {
		char[] arr = s.toCharArray();

		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {

			Integer count = map.get(arr[i]);

			map.put(arr[i], count == null ? 1 : count + 1);
		}
		boolean isOdd = false;
		int sum = 0;
		for (Entry<Character, Integer> entry : map.entrySet()) {
			boolean is_e_odd = entry.getValue() % 2 == 1;
			if (!isOdd && is_e_odd == true) {
				isOdd = true;
			}

			if (isOdd && entry.getValue() == 1) {

			} else {
				sum = sum + (is_e_odd ? entry.getValue() - 1 : entry.getValue());
			}
		}

		return isOdd ? sum + 1: sum;
	}
	
	
	public boolean isIsomorphic(String s, String t) {

		Map<Character, Integer> map_s = new HashMap<>();
		Map<Character, Integer> map_t = new HashMap<>();
		char[] arr_s = s.toCharArray();
		char[] arr_t = t.toCharArray();
		

		for (int i = 0; i < arr_s.length; i++) {

			Integer count = map_s.get(arr_s[i]);

			map_s.put(arr_s[i], count == null ? 1 : count + 1);
		}

		for (int i = 0; i < arr_t.length; i++) {

			Integer count = map_t.get(arr_t[i]);

			map_t.put(arr_t[i], count == null ? 1 : count + 1);
		}

		int[] p = map_s.values().stream().mapToInt(i -> i).toArray();
		int[] q = map_t.values().stream().mapToInt(i -> i).toArray();

		Arrays.sort(p);
		Arrays.sort(q);

		for (int i = 0; i < p.length; i++) {

			if (p[i] != q[i]) {
				return false;
			}
		}

		return true;

	}
	
	  public int mySqrt(int x) {
		  if(x<=0)
			  return 0;
	        return (int) Math.sqrt(x);
	    }
	  
	  public boolean isPalindrome(String s) {
	      char[] arr = s.toLowerCase().toCharArray();
		   StringBuffer end = new StringBuffer("");

			for (int i = 0; i < arr.length; i++) {
				char c = arr[i];
		        if(  (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
		        	end.append(c);
		        }

			}
			System.out.println(end);
	      return end.toString().equals(end.reverse().toString());
	    }
	  
	  
	public static boolean lemonadeChange(int[] bills) {

		int five = 0;
		int ten = 0;

		for (int i = 0; i < bills.length; i++) {

			if (bills[i] == 5) {
				five++;
			}

			else if (bills[i] == 10) {

				if (five < 1) {
					return false;
				}
				five--;
				ten++;

			}

			else if (bills[i] == 20) {

				if (five < 1 && (five < 3 || ten < 1 )) {
					return false;
				}

				if(ten > 0) {
					five--;
					ten--;
				}
				else {
					five--;five--;five--;
				}
				

			}

		}

		return true;

	}
	
	public static String largestNumber(int[] nums) {

		List<Character> char_list = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {

			char[] char_arr = String.valueOf(nums[i]).toCharArray();

			for (int j = 0; j < char_arr.length; j++) {
				char_list.add(char_arr[j]);
			}

		}

		StringBuffer str = new StringBuffer();

		Object[] lol = char_list.stream().sorted((a, b) -> b - a).toArray();

		for (int i = 0; i < lol.length; i++) {

			str.append(lol[i]);
		}

		System.out.println(Arrays.toString(lol));
		System.out.println(str);

		return str.toString();
	}
	
	
	public static int calPoints(String[] ops) {

		Stack<String> stack = new Stack<>();
		Stack<Integer> istack = new Stack<>();


		int points = 0;

		for (int i = ops.length - 1; i >= 0; i--) {
			stack.push(ops[i]);
			
			try {
				 
				istack.push(Integer.parseInt(ops[i]));
			} catch (NumberFormatException e) {

			}
		}

		Integer last_valid = null;
		Integer second_last_valid = null;

		while (!stack.isEmpty()) {

			boolean is_int = false;
			Integer a = null;

			String str = stack.pop();

			try {
				a = Integer.parseInt(str);
				is_int = true;
			} catch (NumberFormatException e) {

			}

			if (is_int) {
				points = points + a;
				;
				Integer temp = last_valid;
				last_valid = a;
				second_last_valid = temp;
			}

			else if (str.equals("C")) {
				if (last_valid != null) {
					points = points - last_valid;
				}
			}

			else if (str.equals("D")) {
				if (last_valid != null)
					points = points + 2 * last_valid;
			}

			else {
				points = points + (last_valid != null ? last_valid : 0)
						+ (second_last_valid != null ? second_last_valid : 0);

			}
		}

		return points;

	}
	
	public boolean isPalindrome(int x) {
		char[] arr = String.valueOf(x).toCharArray();
		int i = 0;
		int j = arr.length - 1;

		while (i <= j) {
			if(arr[i]!=arr[j]) {
				return false;
			}
			i++;
			j--;
		}

		return true;

	}
	
	  public int lengthOfLastWord(String s) {
	        
		  String[] arr = s.split(" ");
		  
		  if(arr.length == 0) {
			  return 0;
		  }
		  
		  return arr[arr.length - 1].length();
	    }
	  
	  
	public static String toGoatLatin(String S) {
		String[] arr = S.split(" ");

		for (int i = 0; i < arr.length; i++) {

			String word = arr[i];

			StringBuffer str = new StringBuffer("");

			char first = word.charAt(0);
			if (first == ('a') || first==('A') || first==('e') || first==('E') || first==('i')
					|| first==('I') || first==('o') || first==('O') || first==('u')
					|| first==('U')) {

				str = new StringBuffer(word);

			} else {
				
				word = word.substring(1);

				str = new StringBuffer(word);
				str.append(first);

			}

			str.append("ma");

			int j = i;

			while (j >= 0) {
				str.append("a");
				j--;
			}

			arr[i] = str.toString();

		}
		
		return Stream.of(arr)
		.collect( Collectors.joining( " " ) );

	}
	
	public static int rotatedDigits(int N) {
		int count = N;
		for (int i = 1; i <= N; i++) {
			
			
		    List<Character> chars = new ArrayList<>(); 
		    
		    char[] arr = String.valueOf(i).toCharArray();
		    
		    char[] rotated_arr = new char[arr.length];

		    
	      
	        for (int p = 0; p < arr.length; p++) { 
	  
	        	char ch = arr[p];
	            chars.add(ch); 
	            
	            char rotated_char  ;
	            
	            if(ch == '1') {
	            	rotated_char = '1';
	            }
	            
	            else if(ch == '2') {
	            	rotated_char = '5';
	            }
	            
	            else if(ch == '3') {
	            	rotated_char = '3';
	            }
	            
	            
	            else if(ch == '4') {
	            	rotated_char = '4';
	            }
	            
	            
	            else if(ch == '5') {
	            	rotated_char = '2';
	            }
	            
	            else if(ch == '6') {
	            	rotated_char = '9';
	            }
	            
	            else if(ch == '7') {
	            	rotated_char = '7';
	            }
	            
	            
	            else if(ch == '8') {
	            	rotated_char = '8';
	            }
	            
	            
	            else if(ch == '9') {
	            	rotated_char = '6';
	            }
	            
	            else {
	            	rotated_char = '0';
	            }
	            
	            rotated_arr[p] = rotated_char;
	            
	            
	        } 
	        
	        if(chars.contains('3') ||chars.contains('4') || chars.contains('7') ) {
	        	
	        	count--;
	        	continue;
	        }
	        
	        boolean is_same = true;
	        for(int j = 0; j < arr.length; j++) {
	        	if(arr[j] != rotated_arr[j]) {
	        		is_same = false;
	        	}
	        }
	        
	        if(is_same) {
	        	count --;
	        }
		}
		
		return count;

	}
	
	  public static boolean  canConstruct(String ransomNote, String magazine) {
		  
			char[] arr = ransomNote.toCharArray();

			Map<Character, Integer> map = new HashMap<>();
			for (int i = 0; i < arr.length; i++) {

				Integer count = map.get(arr[i]);

				map.put(arr[i], count == null ? 1 : count + 1);
			}
			
			char[] arr_2 = magazine.toCharArray();

			Map<Character, Integer> map_2 = new HashMap<>();
			for (int i = 0; i < arr_2.length; i++) {

				Integer count = map_2.get(arr_2[i]);

				map_2.put(arr_2[i], count == null ? 1 : count + 1);
			}
			

			for (Entry<Character, Integer> entry : map.entrySet()) {
					if(!map_2.containsKey(entry.getKey()) || map_2.get(entry.getKey()) < entry.getValue()) {
						return false;
					}
			}
			
			
	        return true;
	    }

	public static int arrangeCoins(int n) {

		int r = n % 2 == 1 ? n / 2 + 1 : n / 2;
		return r == (r * (n + 1)) ? r : r - 1;

	}
	
	
	public static boolean isLongPressedName(String name, String typed) {
		char[] name_arr = name.toCharArray();
		char[] typed_arr = typed.toCharArray();

		int i = 1;
		int j = 1;

		if (name.length() == 0 && typed.length() == 0) {
			return true;
		}

		if (name.length() == 0 && typed.length() >= 0) {
			return false;
		}
		
		if (name.length() >= 0 && typed.length() == 0) {
			return false;
		}

		if (name_arr[0] != typed_arr[0]) {
			return false;
		}
		while (i < name_arr.length) {

			if (name_arr[i] == typed_arr[j]) {
				i++;
				j++;
			}

			else {

				while (j < typed_arr.length && typed_arr[j] == name_arr[i - 1]) {
					j++;
				}

				if (name_arr[i] != typed_arr[j] || j > i) {

					return false;
				}
			}
		}

		return true;

	}
	


}