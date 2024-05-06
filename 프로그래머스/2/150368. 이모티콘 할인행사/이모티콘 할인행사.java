class Solution {
    
    private static int SERVICE_COUNT = 0;
    private static int TOTAL_AMOUNT = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        int[] discount_arr = new int[emoticons.length];
        
        dfs(users, emoticons, discount_arr, 0);
        
        answer[0] = SERVICE_COUNT;
        answer[1] = TOTAL_AMOUNT;
        return answer;
    }
    
    public void dfs(int[][] users, int[] emoticons, int[] discount_arr, int depth) {
        
        if (depth == discount_arr.length) {
            // 이모티콘 할인 계산 및 할인 정보 저장
         	calculate(users, emoticons, discount_arr);
            
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            discount_arr[depth] = (i+1)*10;
            dfs(users, emoticons, discount_arr, depth+1);
        }
    }
    
    public void calculate(int[][] users, int[] emoticons, int[] discount_arr) {
        int count = 0;
        int amount = 0;
        
        for(int[] user : users) {
            int ratio = user[0];
            int price = user[1];
        	int sum = 0;
            for (int i = 0; i < discount_arr.length; i++) {
                if (discount_arr[i] >= ratio) {
                    sum += (emoticons[i]/100) * (100-discount_arr[i]);
                } else continue;
            }
            
            if (sum < price) amount += sum;
            else count += 1;
        }
        if (count > SERVICE_COUNT) {
            SERVICE_COUNT = count;
            TOTAL_AMOUNT = amount;
        } else if (count == SERVICE_COUNT) {
            TOTAL_AMOUNT = TOTAL_AMOUNT < amount ? amount : TOTAL_AMOUNT;
        }
    }
}