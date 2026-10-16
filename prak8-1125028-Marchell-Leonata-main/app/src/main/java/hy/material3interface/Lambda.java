package hy.material3interface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lambda {

    public static void main(String[] args) {
        Runnable lambdaFunction = () -> System.out.println("Hello Lambda!");
        lambdaFunction.run();

        List<String> names = List.of("Alice", "Bob", "Charlie");

        names.forEach(name -> System.out.println(name));

        List<String> filtered = names
            .stream()
            .filter(name -> name.startsWith("A"))
            .toList();

        List<Integer> numbers = new ArrayList<>();

        Collections.sort(numbers, (o1, o2) -> o1 - o2);
    }
}
