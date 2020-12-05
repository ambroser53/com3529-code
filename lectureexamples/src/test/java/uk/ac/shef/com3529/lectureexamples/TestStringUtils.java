package uk.ac.shef.com3529.lectureexamples;

import java.util.Set;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import uk.ac.shef.com3529.lectureexamples.StringUtils;

public class TestStringUtils {

    @Test
    public void testRepeatedChar() {
        Set<Character> resultSet = StringUtils.duplicateLetters("software testing");
        assertTrue(resultSet.contains('t'));

    }

    @Test
    public void testNonRepeatedChar() {
        Set<Character> resultSet = StringUtils.duplicateLetters("software debugging");
        assertFalse(resultSet.contains('t'));
    }
}
