import java.util.*;

public class Cocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> ingredient = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)//Queue
                .forEach(ingredient::offer);

        ArrayDeque<Integer> freshness = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(freshness::push);//stack

        Map<String, Integer> cocktails = new TreeMap<>();


        while (!ingredient.isEmpty() && !freshness.isEmpty()) {

            int cocktail = ingredient.peek() * freshness.peek();

            switch (cocktail) {
                case 150:
                    cocktails.putIfAbsent("Pear Sour", 0);
                    cocktails.put("Pear Sour", cocktails.get("Pear Sour") + 1);
                    ingredient.poll();
                    freshness.pop();
                    break;
                case 250:
                    cocktails.putIfAbsent("The Harvest", 0);
                    cocktails.put("The Harvest", cocktails.get("The Harvest") + 1);
                    ingredient.poll();
                    freshness.pop();
                    break;
                case 300:
                    cocktails.putIfAbsent("Apple Hinny", 0);
                    cocktails.put("Apple Hinny", cocktails.get("Apple Hinny") + 1);
                    ingredient.poll();
                    freshness.pop();
                    break;
                case 400:
                    cocktails.putIfAbsent("High Fashion", 0);
                    cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
                    ingredient.poll();
                    freshness.pop();
                    break;
                default:
                    if (ingredient.peek() == 0) {
                        ingredient.poll();
                        continue;
                    }
                    int lastIndex = ingredient.pop();
                    freshness.poll();
                    ingredient.offer(lastIndex + 5);
            }
        }
        if (cocktails.size() == 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
            int sum = 0;
            if (!ingredient.isEmpty()) {
                while (!ingredient.isEmpty()) {
                    sum += ingredient.poll();

                }
                System.out.println("Ingredients left: " + sum);

            }
        }
        cocktails.forEach((key, value) ->
                System.out.printf("# %s --> %d%n", key, value));
    }
}


