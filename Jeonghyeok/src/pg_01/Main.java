package pg_01;
import java.util.*;
public class Main {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reporterMap = new HashMap<>();
        Map<String, Integer> reportedCount = new HashMap<>();

        for (String id : id_list) {
            reporterMap.put(id, new HashSet<>());
            reportedCount.put(id, 0);
        }

        for (String r : new HashSet<>(Arrays.asList(report))) {
            String[] parts = r.split(" ");
            String reporter = parts[0];
            String reported = parts[1];

            if (!reporterMap.get(reporter).contains(reported)) {
                reporterMap.get(reporter).add(reported);
                reportedCount.put(reported, reportedCount.get(reported) + 1);
            }
        }

        Set<String> suspendedUsers = new HashSet<>();
        for (Map.Entry<String, Integer> entry : reportedCount.entrySet()) {
            if (entry.getValue() >= k) {
                suspendedUsers.add(entry.getKey());
            }
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            int count = 0;
            for (String reported : reporterMap.get(user)) {
                if (suspendedUsers.contains(reported)) {
                    count++;
                }
            }
            answer[i] = count;
        }

        return answer;
    }
}
