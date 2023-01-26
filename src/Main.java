import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        //Задание 1
        //через анонимный класс
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 0;
            }
        };
        //через лямбду
        Predicate<Integer> predicate1 = x -> x > 0;
        System.out.println(predicate1.test(-7));
        System.out.println(predicate.test(-7));
        System.out.println("--------------------");

        //Задание 2
        //через анонимный класс
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("hello " + s);
            }
        };
        //через лямбду
        Consumer<String> consumer1 = x -> System.out.println("hello " + x);
        consumer.accept("Karl");
        consumer1.accept("Petr");
        System.out.println("--------------------");

        //Задание 3
        //через анонимный класс
        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return aDouble.longValue();
            }
        };
        //через лямбду
        Function<Double, Long> function1 = x -> x.longValue();
        System.out.println(function1.apply(23.23).getClass());
        System.out.println(function.apply(23.23).getClass());
        System.out.println("--------------------");

        //Задание 4
        //через анонимный класс
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int) (Math.random() * 100);
            }
        };
        //через лямбду
        Supplier<Integer> supplier1 = () -> (int) (Math.random() * 100);
        System.out.println(supplier.get());
        System.out.println(supplier1.get());
        System.out.println("--------------------");
        System.out.println(ternaryOperator.apply(12));
        System.out.println(ternaryOperator2.apply("q"));
        System.out.println(ternaryOperator3.apply(12));

    }

    //Задание 4
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
    }

    static Function<Integer, String> ternaryOperator = ternaryOperator(
            x -> x > 0,
            x -> "positive",
            x -> "negative");


    static Function<String, Boolean> ternaryOperator2 = ternaryOperator(
            String::isEmpty,
            x -> false,
            x -> true);


    static Function<Integer, Integer> ternaryOperator3 = ternaryOperator(
            x -> x % 2 == 0,
            x -> x / 2,
            x -> x * 3);
}

class check {
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return new Function<T, U>() {
            @Override
            public U apply(T t) {
                if (condition.test(t)) {
                    return ifTrue.apply(t);
                } else {
                    return ifFalse.apply(t);
                }
            }
        };
    }
}
