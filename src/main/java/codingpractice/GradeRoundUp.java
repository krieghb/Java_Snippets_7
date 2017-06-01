package codingpractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by Wartree on 5/26/17.
 *
 */
public class GradeRoundUp {
    private static Logger LOGGER = LoggerFactory.getLogger(GradeRoundUp.class);

    public void getGrades(int[] grades) {
        int grade;
        for (int i = 0; i < grades.length; i ++) {
            grade = grades[i];
            if (grade % 5 > 2) {
                grades[i] = (int) (5 * (Math.ceil(Math.abs((double) grade/5))));;
            }

        }

        LOGGER.info("Grades:   {}", Arrays.toString(grades));
    }
}
