package no.abakus.filbehandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Filbehandling {

    private static final Path MY_FILE = Path.of("my_file.txt");

    private static void generateRandomGarbage() {
        Random random = new Random();

        List<String> garbage = IntStream.generate(() -> random.nextInt(4096))
                .limit(random.nextInt(100))
                .mapToObj(Integer::toString)
                .toList();

        try {
            Files.write(MY_FILE, garbage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        generateRandomGarbage();
    }
}
