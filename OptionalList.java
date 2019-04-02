import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalList {

	public static void main(String[] args) {
		List<String> nameList = null;
//		List<String> nameList = Arrays.asList("Krishna","Ananad");
		printIfMatchFound(nameList, "Saravan");

	}

	private static void printIfMatchFound(List<String> nameList, String matchingString) {
		Optional<List<String>> nameLst = Optional.ofNullable(nameList);
		Stream<String> nameStream = nameLst.orElseGet(Collections::emptyList).stream();
		if (nameStream.anyMatch(s -> s.equalsIgnoreCase(matchingString))) {
			System.out.println("Match found :: " + matchingString);
		} else {
			System.out.println("No Match found :: ");
		}
	}
}