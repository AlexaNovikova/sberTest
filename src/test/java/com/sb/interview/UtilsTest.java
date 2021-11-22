package com.sb.interview;

import com.sb.interview.utils.Key;
import com.sb.interview.utils.Utils;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class UtilsTest {
    private Utils underTest = new Utils();

    @Test
    public void getTopNMinValues() {
        Integer[] source = {1, 5, 23, 78, 344, 0, 2, 79, 90, 34, 12, 98, 123, 321, 43};

        List<Integer> result = underTest.getTopNMinValues(source, 1);
        assertSame(0, result.get(0));

        result = underTest.getTopNMinValues(source, 5);
        assertSame(5, result.size());
        assertTrue(result.containsAll(Arrays.asList(1, 2, 0, 5, 12)));
    }

    @Test
    public void countDuplicates() {
        String source = "HiHHHiiiii, wwwoooorrrlllddddlll!!!! ";
        int result = underTest.countDuplicates(source);
        assertSame(27, result);
    }

    @Test
    public void isDiffElements() {
        assertTrue(underTest.isDiffElements(true, false));
        assertTrue(underTest.isDiffElements(false, true));
        assertFalse(underTest.isDiffElements(true, true));
        assertFalse(underTest.isDiffElements(false, false));
    }

    @Test
    public void map_test() {
        String value = "String_value";
        Map<Key, String> map = new HashMap<>();

        Key key = new Key(127L);
        key.setMutableDate(new Date());
        map.put(key, value);

        Key newKey = new Key(127L);
        map.put(newKey, value);
        String result = map.get(newKey);

        assertEquals(value, result);
        assertEquals(value, map.get(key));
    }

}