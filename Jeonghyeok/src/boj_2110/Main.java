 package boj_2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] home = new int[n];

        for(int i = 0; i < n; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);

        int low = 1;
        int high = home[n - 1] - home[0];
        int ans = 0;
        /*----------------문제 없음---------------*/

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isInstall(home,c,mid)){
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(ans);
    }

    public static boolean isInstall(int[] home, int c, int dist){
        int cnt = 1;;
        int last = home[0];

        for(int i = 1; i < home.length; i++){
            if(home[i] - last >= dist){
                cnt++;
                last = home[i];
            }
        }

        return  cnt >= c;
    }
}
