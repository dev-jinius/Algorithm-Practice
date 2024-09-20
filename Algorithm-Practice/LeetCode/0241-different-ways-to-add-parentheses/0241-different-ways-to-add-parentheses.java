import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        
        return recur(expression, 0, n-1);
    }

    public List<Integer> recur(String exp, int start, int end) {
        List<Integer> res = new ArrayList<>();

        if (start == end) {
            int num = exp.charAt(start)-'0';    //유니코드를 활용해 문자를 숫자로 계산
            res.add(num);
            return res;
        } 
        if (end-start == 1 && Character.isDigit(exp.charAt(start))) {
            int num = Integer.parseInt(exp.substring(start, end+1));
            res.add(num); 
            return res;
        }

        for (int i=start; i<=end; i++) {
            if (Character.isDigit(exp.charAt(i))) {
                continue;
            }
            char op = exp.charAt(i);
            List<Integer> left = recur(exp, start, i-1);
            List<Integer> right = recur(exp, i+1, end);
            for (int l : left) {
                for (int r : right) {
                    if (op == '*') {
                        res.add(l*r);
                    } else if (op == '+') {
                        res.add(l+r);
                    } else if (op == '-') {
                        res.add(l-r);
                    }
                }
            }
        }
        return res;
    }
}