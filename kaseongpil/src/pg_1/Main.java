package pg_1;
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        HashMap<String, Integer> blockerMap = new HashMap<>();
        int[] answer = new int[id_list.length];

        for (int i = 0; i < report.length; i++) {
            String[] temp = report[i].split(" ");
            String reporter = temp[0];
            String reported = temp[1];
            reportMap.putIfAbsent(reported, new HashSet<>());
            reportMap.get(reported).add(reporter);
        }
        for (var e : reportMap.keySet())
            if (reportMap.get(e).size() >= k)
                for (var rep : reportMap.get(e))
                    blockerMap.put(rep, blockerMap.getOrDefault(rep, 0) + 1);
        for (int i = 0; i < id_list.length; i++)
            answer[i] = blockerMap.getOrDefault(id_list[i], 0);
        return answer;
    }
}
