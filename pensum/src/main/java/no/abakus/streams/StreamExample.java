package no.abakus.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

    private static final List<Character> GRADES = Arrays.asList('F', 'E', 'D', 'C', 'B', 'A');
    private List<Character> javaGrades;

    public StreamExample() {
        this.populateGrades();
    }

    private void populateGrades() {
        Random random = new Random();
        this.javaGrades = Stream.generate(() -> GRADES.get(random.nextInt(GRADES.size())))
                .limit(100)
                .toList(); // Husk å ta med dette i tips and tricks
    }

    public List<Character> getJavaGrades() {
        return new ArrayList<>(this.javaGrades); // Husk å ta med dette i tips & tricks
    }

    public int getNumOfGrades(char grade) {
        return (int) this.javaGrades.stream().filter(javaGrade -> javaGrade == grade).count();
    }

    public List<Integer> getGradesAsNumbers() {
        return this.javaGrades.stream().map(grade -> GRADES.indexOf(grade)).toList();
    }

    public double getAverageScore() {
        return this.getGradesAsNumbers().stream().mapToInt(Integer::intValue).sum() / this.javaGrades.size();
    }

    public static void main(String[] args) {
        
    }

}
