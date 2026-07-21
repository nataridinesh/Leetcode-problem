class Solution {
    public String replaceDigits(String s) {
        char[] arr = s.toCharArray();
        
        // Loop through odd indices to shift characters
        for (int i = 1; i < arr.length; i += 2) {
            arr[i] = (char) (arr[i - 1] + (arr[i] - '0'));
        }
        
        return new String(arr);
    }
}
