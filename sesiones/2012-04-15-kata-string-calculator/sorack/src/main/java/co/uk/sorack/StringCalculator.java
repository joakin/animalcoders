package co.uk.sorack;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class StringCalculator {

    public static int add(String text) {
        if (text.isEmpty()) {
            return 0;
        }else {
            Iterable<Integer> numbers = Iterables.transform(split(text), toInt());
            Iterable<Integer> negatives = Iterables.filter(numbers, negatives());
            
            Preconditions.checkArgument(Iterables.isEmpty(negatives), 
                    "Sorry, you can't add negative numbers, but I got --> " + 
                    Joiner.on(",").join(negatives));
            
            return sum(numbers);
        }
    }
    
    private static Predicate<Integer> negatives() {
        return new Predicate<Integer>() {

            public boolean apply(Integer number) {
                return number < 0;
            }
        };

    }

    private static Function<String,Integer> toInt() {
        return new Function<String, Integer>() {

            public Integer apply(String string) {
                return Integer.valueOf(string);
            }
        };
    }

    private static int sum(Iterable<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    
    private static Iterable<String> split(String text) {
        if(hasCustomDelimiter(text)) {
            return Arrays.asList(splitByCustomDelimiter(text));
        } else {
            return Arrays.asList(splitByComma(text));
        }
    }

    private static String[] splitByCustomDelimiter(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        matcher.matches();
        String delimiter = matcher.group(1);
        String rest = matcher.group(2);
        return rest.split(delimiter);
    }

    private static String[] splitByComma(String text) {
        return text.split(",|\n");
    }

    private static boolean hasCustomDelimiter(String text) {
        return text.startsWith("//");
    }

    
}
