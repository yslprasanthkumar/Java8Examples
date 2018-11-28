import java.util.List;
import java.util.stream.Collectors;

public class ExceptionsExample {
	
	public static void main(String[] args) {
		
	}
	
	public List<Integer> scale(List<Integer> values, Integer factor) {
		
		return values.stream()
		        .map(n -> n / factor)
		        .collect(Collectors.toList());
		
	}

}
