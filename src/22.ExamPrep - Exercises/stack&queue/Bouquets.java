import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bouquets {

    static int sum = 0;
    static int bouquets = 0;
    static int flowersLessThenFifteen = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulips = new ArrayDeque<>();  //STACK
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).forEach(tulips::push);

        ArrayDeque<Integer> daffodils   //QUEUE
                = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
//Stack ----- push(),pop(),peek();
//Queues-----offer(),poll().peek();

        while (!tulips.isEmpty() && !daffodils.isEmpty()) {
            sum = tulips.peek() + daffodils.peek();
            if (sum == 15) {
                bouquets++;
                tulips.pop();
                daffodils.poll();
            } else if (sum > 15) {
                tulips.push(tulips.pop() - 2);
            } else {
                flowersLessThenFifteen += tulips.pop() + daffodils.poll();


            }
        }
        while (flowersLessThenFifteen >= 15) {
            flowersLessThenFifteen -= 15;
            bouquets++;
        }
        if (bouquets >= 5) {
            System.out.println("You made it! You go to the competition with " + bouquets + " bouquets!");
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }
    }
}

