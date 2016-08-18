package gwm.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Convert stream to list
 * @see <a href="http://www.mkyong.com/java8/java-8-convert-a-stream-to-list">Convert stream to list</a>
 * @author gwmccort
 *
 */
public class Stream2List {

	public static void main(String[] args) {
		//convert a Stream to a List via Collectors.toList
		Stream<String> language = Stream.of("java", "python", "node");
		
        //Convert a Stream to List
        List<String> result = language.collect(Collectors.toList());

        result.forEach(System.out::println);
        
        //filter a number 3 and convert it to a List.
        Stream<Integer> number = Stream.of(1, 2, 3, 4, 5);

        List<Integer> result2 = number.filter(x -> x!= 3).collect(Collectors.toList());

        result2.forEach(x -> System.out.println(x));
	}

}
