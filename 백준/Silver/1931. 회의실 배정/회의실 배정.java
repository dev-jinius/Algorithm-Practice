import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<Time> timeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            timeList.add(new Time(start, end));
        }

        Collections.sort(timeList);

        int count = 0;
        int endTime = 0;

        for (Time time : timeList) {
            if (time.start >= endTime) {
                endTime = time.end;
                count++;
            }
        }
        System.out.println(count);
    }
}
