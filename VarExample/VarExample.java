import java.util.Arrays;

public class VarExample{

	public static void main(String[] args) {

		var header = "From Java 8 to Java 21, In a nutshell.";
    
		var javaTalks = Arrays.asList("JEP 286 - JDK 10 --> Local-Variable Type Inference", 
									  "JEP 378 - JDK 15 --> Text Blocks",
									  "");
    
		var iterator = 1;

	for (var s : javaTalks) {
		System.out.println(String.format("%d - %s", iterator, s));
			iterator++;
		}
	}
}
