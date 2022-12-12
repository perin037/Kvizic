package rs.ac.ni.pmf.kvizic.model;

import java.util.Arrays;
import java.util.List;

public class QuestionsRepository {
    private static final List<Question> QUESTIONS = Arrays.asList(
            new Question("Q1", "o1", "o2","o3", 1),
            new Question("Q2", "o1", "o2","o3", 3),
            new Question("Q3", "o1", "o2","o3", 1),
            new Question("Q4", "o1", "o2","o3", 2),
            new Question("Q5", "o1", "o2","o3", 1)
    );

    public static List<Question> findAll(){
        return QUESTIONS;
    }
}
