/**
	Given a string, find the length of the longest substring without repeating characters.
	Examples:
	Given "abcabcbb", the answer is "abc", which the length is 3.
	Given "bbbbb", the answer is "b", with the length of 1.
	Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
  * 最长的没有重复字母的子串。
  */

//O(n²) 
 public int lengthOfLongestSubstring(String s) {
	char[] str = s.toCharArray();
	int max = 0;
	Map<Character, Boolean> map = new HashMap<>();
	for (int i = 0; i < str.length; i++){
		int cnt = 0;
		for (int j = i; j < str.length; j++) {
			if (map.get(str[j]) == null) {
				map.put(str[j], true);
				cnt++;
				if (cnt > max){
					max = cnt;
				}
			}else {
				map = new HashMap<>();
				break;
			}
		}
	}
	return max;
}

//O(n)
public int lengthOfLongestSubstring(String s) {
	if (s.length()==0) return 0;
	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	int max=0;
	for (int i=0, j=0; i<s.length(); ++i){
		if (map.containsKey(s.charAt(i))){
			j = Math.max(j,map.get(s.charAt(i))+1);
		}
		map.put(s.charAt(i),i);
		max = Math.max(max,i-j+1);
	}
	return max;
}