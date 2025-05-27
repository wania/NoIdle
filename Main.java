package org.wania.noidle;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		int sleepTime = Stream.of(args)
				.filter(a -> a.matches("\\d+"))
				.findAny()
				.map(Integer::getInteger)
				.orElse(60);
		new MouseDancer().dance(sleepTime);
	}
}
