import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.stream.Stream;

/**
 * This Solution program implements an application that displays duplicates or
 * not duplicates from a text file containing 6M entries in the fastest way
 * possible.
 * 
 * @author Varun Subramanian
 * @version 1.0
 * @since 2016-10-21
 *
 */
public class Solution {

	static long startTime = 0;

	public static void main(String[] args) throws IOException {

		startTime = System.currentTimeMillis();

		try {
			Path path = Paths.get("PATH");
			if (readLines(path))
				System.out.println("No Duplicates");
			else
				System.out.println("Duplicates");
		} catch (Exception e) {
			System.err.println("File not found");
		}

		long elapsed = System.currentTimeMillis() - startTime;
		System.out.println("Elapsed time = " + elapsed + "ms");
		System.out.println((elapsed * 1000.0) / 1000000 + " microseconds per execution");

	}

	/**
	 * @param path
	 * @throws IOException
	 * @return boolean
	 */
	public static boolean readLines(Path path) throws IOException {

		Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
		return isUnique(lines);
	}

	/**
	 * @param lines
	 * @return boolean
	 */
	public static <T> boolean isUnique(Stream<T> lines) {
		return lines.allMatch(new LinkedHashSet<T>()::add);
	}

}