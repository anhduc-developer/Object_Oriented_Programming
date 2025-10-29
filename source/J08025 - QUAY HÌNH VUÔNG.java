import java.util.*;

public class Solution {
    public static String change(String s) {
        return "" + s.charAt(3) + s.charAt(0) + s.charAt(2) + s.charAt(4) + s.charAt(1) + s.charAt(5);
    }

    public static String convert(String s) {
        return "" + s.charAt(0) + s.charAt(4) + s.charAt(1) + s.charAt(3) + s.charAt(5) + s.charAt(2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            String s = sc.nextLine();
            String target = sc.nextLine();
            s = s.replace(" ", "");
            target = target.replace(" ", "");
            Queue<String> q = new LinkedList<>();
            Map<String, Integer> dist = new HashMap<>(); // BFS khoảng cách

            q.add(s);
            dist.put(s, 0);

            while (!q.isEmpty()) {
                String x = q.poll();
                int d = dist.get(x);

                if (x.equals(target)) {
                    System.out.println(d);
                    break;
                }

                String a = change(x);
                String b = convert(x);

                if (!dist.containsKey(a)) {
                    dist.put(a, d + 1);
                    q.add(a);
                }
                if (!dist.containsKey(b)) {
                    dist.put(b, d + 1);
                    q.add(b);
                }
            }
        }
    }
}
