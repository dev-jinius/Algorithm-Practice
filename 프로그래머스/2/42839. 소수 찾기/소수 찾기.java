import java.util.*;

class Solution {
	Set<Integer> numSet = new HashSet<>();	// 조합 완성된 숫자
    Set<Integer> result = new HashSet<>();	// 소수까지 판별된 숫자
    
    //현재 조합된 숫자(comb), 남은 숫자(remains)로 모든 숫자 조합
    public void reculsive(String comb, String remains) {
    	//첫 번째 호출은 ""이므로 예외
        if(!comb.equals(""))
            numSet.add(Integer.parseInt(comb));
        
        //재귀 종료: remains 길이만큼 반복 호출 => remains 전체 숫자를 반복해서 조합하면 종료
        for (int i = 0; i < remains.length(); i++) {
            //1.처음 remains의 i번째 인덱스를 pick하고, pick한 숫자를 제외한 나머지 숫자를 remains로
            //2.pick한 숫자를 comb 오른쪽에 붙임.
            //3.remains의 길이가 0이 될때까지 조합
            reculsive(comb + remains.charAt(i), remains.substring(0,i) + remains.substring(i+1));
        }
    }
    
    //소수 체크
    public boolean check(int num) {
        if (num < 2) return false;
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    
    public int solution(String numbers) {
        
        reculsive("", numbers);
        
        for(int i : numSet) {
            if(check(i))
                result.add(i);
        }
        
        return result.size();
    }
}