# [level 2] 올바른 괄호 - 12909 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12909) 

### 실패 했던 코드
```java
import java.util.List;
import java.util.ArrayList;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
    	
        // 괄호 관리하는 List
        List<String> list = new ArrayList<String>();

        // char 비교가 아닌 문자열로 비교하기 위해 입력한 문자열 Array로 변환
        String[] str = s.split("");
        
        // 괄호가 "(" 이면 add, ")"이면 remove
        for (String val : str) {
            if (val.equals("(")) list.add(val);
            else list.remove("(");
        }
        
        if (list.isEmpty()) answer = true;
        else answer = false;
        
        return answer;
    }
}
```

### 왜 실패했나?
- 효율성 테스트 실패
  - split()을 사용하면 메모리 할당, 사용량이 증가하게 된다. => 시간 복잡도 증가, 효율성 감소
  - charAt() 함수를 사용해 char로 비교하면, 추가 메모리 사용 없이 비교할 수 있다.

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges