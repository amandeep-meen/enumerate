package org.stackminer.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestEnumerate {


    @Test
    public void testEnumerate() {
        List<Tuple> tuples = IntStream.range(0, 3)
                .mapToObj(i -> new Student("Name" + i))
                .map(Tuple.enumerate())
                .collect(Collectors.toList());

        IntStream.range(0, 3).
                forEach(index -> {
                    Tuple<Student> studentTuple = tuples.get(index);
                    Assertions.assertEquals(Long.valueOf(index), studentTuple.getIndex());
                    Assertions.assertEquals("Name" + index, studentTuple.getData().getName());
                });


    }


}
