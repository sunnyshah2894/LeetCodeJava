package com.medium;

class Solution {
    public String longestPalindrome(String s) {
        char ch[] = s.toCharArray();
        int n = s.length();
        
        int start = 0 , end = 0;
        for(int i=0; i<s.length(); i++){
            int l=i, r=i;
            while( l>=0 && r<s.length() && ch[l] == ch[r] ){
                l--; r++;
            }
            r--; l++;
            int maxLength = r-l+1;
            l=i; r=i+1;
            while( l>=0 && r<s.length() && ch[l] == ch[r] ){
                l--; r++;
            }   
            r--; l++;
            maxLength = Math.max( maxLength, r-l+1 );
            
            if( end-start+1 < maxLength ){
                if(maxLength%2==1){
                    start = i - maxLength/2;
                    end = i + maxLength/2;
                }else{
                    start = i - ((maxLength/2)-1);
                    end = i + (maxLength/2);
                }
               }
        }
        return s.substring(start, end+1);
    }
}
