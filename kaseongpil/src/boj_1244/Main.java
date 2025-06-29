package boj_1244;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int swi;
    static int[] switchState;
    static int student;

    static void manSwitch(int n) {
        for (int i = n; i <= swi; i += n)
            switchState[i] = switchState[i] == 0 ? 1 : 0;
    }

    static void womanSwitch(int n) {
        switchState[n] = switchState[n] == 0 ? 1 : 0;
        for (int i = 1; i < swi; i++) {
            if (n - i > 0 && n + i <= swi) {
                if (switchState[n - i] == switchState[n + i]) {
                    switchState[n - i] = switchState[n - i] == 0 ? 1 : 0;
                    switchState[n + i] = switchState[n + i] == 0 ? 1 : 0;
                }
                else break;
            }
            else break;
        }
    }

    public static void main(String[] args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        swi = Integer.parseInt(br.readLine());
        switchState = new int[swi + 1];

        var st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= swi; i++)
            switchState[i] = Integer.parseInt(st.nextToken());

        student = Integer.parseInt(br.readLine());
        for (int i = 0; i < student; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (gender == 1) manSwitch(num);
            else womanSwitch(num);
        }

        for (int i = 1; i <= swi; i++) {
            bw.write(switchState[i] + " ");
            if (i % 20 == 0) bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
