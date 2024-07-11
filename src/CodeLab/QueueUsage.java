package CodeLab;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueUsage {

    public static void main(String[] args) {
        //优先队列
        Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        q.add(1);q.add(2);
        System.out.println(Arrays.toString(q.toArray()));
    }
}
