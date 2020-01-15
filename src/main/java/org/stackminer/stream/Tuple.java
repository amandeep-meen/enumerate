package org.stackminer.stream;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

public class Tuple<T> {

    private Long index;
    private T data;

    private Tuple(Long index, T data) {
        this.index = index;
        this.data = data;
    }

    public Long getIndex() {
        return index;
    }

    public T getData() {
        return data;
    }

    public static <T> Function<T, Tuple<T>> enumerate() {
        final AtomicLong index = new AtomicLong();
        return (t) -> new Tuple<>(index.getAndIncrement(), t);
    }

}
