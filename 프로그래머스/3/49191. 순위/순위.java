class Solution {
    //대회 참가한 총 권투선수의 수 : n명 (1 ~ n번 번호, 최대 100명)
    //경기 결과: 실력 순 (최대 4500번 경기)
    //return: 순위를 알 수 매길 수 있는 선수의 수
    int[][] results;
    int n;
    public void setTable(int[][] table) {
        for (int i = 0; i < results.length; i++) {
            table[results[i][0]][results[i][1]] = 1;
            table[results[i][1]][results[i][0]] = -1;
        }
    } 
    
    public void calculate(int[][] table) {
        for (int i = 1; i < n+1; i++) {
            for (int x = 1; x < n+1; x++) {
                for (int y = 1; y < n+1; y++) {
                	if (table[x][i] == 1 && table[i][y] == 1)
                        table[x][y] = 1;
                    else if (table[x][i] == -1 && table[i][y] == -1)
                        table[x][y] = -1;
                }
            }
        }
    }
    
    public int counting(int[][] table) {
        int count = 0;
        for (int i = 1; i < table.length; i++) {
            int zero = 0;
            for (int j = 1; j < table[0].length; j++) {
                if (table[i][j] == 0) zero++;
            }
            if (zero < 2) count++;
        }
        
        return count;
    }
    
    public int solution(int n, int[][] results) {
        int count = 0;
        this.results = results;
        this.n = n;
        int[][] table = new int[n+1][n+1];
        
        setTable(table);
       
        calculate(table);
       
        count = counting(table);
        
        return count;
    }
}