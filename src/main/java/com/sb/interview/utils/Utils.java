package com.sb.interview.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Utils {

    /**
     * Метод возвращает минимальные N элементов из входящего списка
     *
     * @param source - исходный список
     * @param n      - количество возвращаемых значений
     * @return - список из N минимальных значений списка
     */
    public List<Integer> getTopNMinValues(final Integer[] source, int n) {
        List<Integer> result = Arrays.asList(source.clone());
        Collections.sort(result);
        return result.subList(0, n);
    }

    /**
     * Подсчет повторяющихся символов в строке
     *
     * @param source - исходная строка
     * @return - сумарное количество всех повторных вхождений символов
     * <p>
     * пример: дано: AASSDDD -> вернет 4:
     * A-1, S-1, D-2
     */
    public int countDuplicates(String source) {
        return source.length()- (int) source.chars().distinct().summaryStatistics().getCount();
    }

    /**
     * Вернет TRUE если значения разные
     *
     * @param a1 - первое значене
     * @param a2 - второе значене
     * @return - если разные, вернет TRUE
     */
    public boolean isDiffElements(boolean a1, boolean a2) {
        return a1!=a2;
    }

}
