package org.wania.noidle;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		int sleepTime = Stream.of(args)
				.findFirst()
				.filter(a -> a.matches("\\d+"))
				.map(Integer::getInteger)
				.orElse(60);
		new MouseDancer().dance(sleepTime);
	}
}
