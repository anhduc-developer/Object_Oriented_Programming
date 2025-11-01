import java.util.*;
class Pair <U, V>{
    private U first;
    private V second;
    public Pair(U first, V second){
        this.first = first;
        this.second = second;
    }
    public U getFirst(){
        return this.first;
    }
    public V getSecond(){
        return  this.second;
    }
}
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            long n = sc.nextLong();
            if(n == 0){
                System.out.println("Impossible");
                continue;
            }
            Queue <Pair<Long, TreeSet>> q = new LinkedList<>();
            long res = n;
            TreeSet <Integer> set = new TreeSet<>();
            while(res > 0){
                set.add((int) res % 10);
                res /= 10;
            }
            q.add(new Pair(n, set));
            while(!q.isEmpty()){
                Pair<Long, TreeSet> x = q.poll();
                long num = x.getFirst();
                TreeSet<Integer> digits = x.getSecond();
                if(digits.size() == 10){
                    System.out.println(num);
                    break;
                }
                long next = num + n;
                TreeSet<Integer> se = new TreeSet<>(digits);
                long temp = next;
                while(temp > 0){
                    se.add((int) temp % 10);
                    temp /= 10;
                }
                q.add(new Pair(next, se));
            }
        }
    }
}