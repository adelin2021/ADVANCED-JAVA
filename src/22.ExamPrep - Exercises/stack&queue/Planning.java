import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Planning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(tasks::push);

        ArrayDeque<Integer> threads = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int taskToKill = Integer.parseInt(scanner.nextLine());
        int threadValue = 0;
        while (!tasks.isEmpty() || threads.isEmpty()) {
            if (tasks.peek() == taskToKill) {
                threadValue = threads.peek();
                break;
            }
            if (threads.peek() >= tasks.peek()) {
                tasks.pop();
                threads.poll();
            } else {
                threads.poll();
            }
            //Stack ----- push(),pop(),peek();
            //---------------------------------------------
            //Queues-----offer(),poll().peek(); -------First In First Out

        }

        System.out.println("Thread with value "+threadValue+" killed task "+taskToKill);
        while (!threads.isEmpty()){
            System.out.print(threads.poll()+" ");
        }
    }
}
