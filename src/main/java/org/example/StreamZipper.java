package org.example;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamZipper {

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Spliterator<T> firstSpliterator = first.spliterator();
        Spliterator<T> secondSpliterator = second.spliterator();

        // Create a zipping Spliterator
        ZippingSpliterator<T> zippingSpliterator = new ZippingSpliterator<>(firstSpliterator, secondSpliterator);

        // Create a stream from the zipping Spliterator
        return StreamSupport.stream(zippingSpliterator, false);
    }

    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> stream2 = Stream.of(10, 20, 30);

        Stream<Integer> zippedStream = zip(stream1, stream2);

        zippedStream.forEach(System.out::println);
    }

    // Custom spliterator for zipping two streams
    static class ZippingSpliterator<T> extends Spliterators.AbstractSpliterator<T> {
        private final Spliterator<T> firstSpliterator;
        private final Spliterator<T> secondSpliterator;
        private boolean useFirst = true;

        protected ZippingSpliterator(Spliterator<T> firstSpliterator, Spliterator<T> secondSpliterator) {
            super(Math.min(firstSpliterator.estimateSize(), secondSpliterator.estimateSize()), 0);
            this.firstSpliterator = firstSpliterator;
            this.secondSpliterator = secondSpliterator;
        }

        @Override
        public boolean tryAdvance(java.util.function.Consumer<? super T> action) {
            Spliterator<T> source = useFirst ? firstSpliterator : secondSpliterator;
            boolean hadNext = source.tryAdvance(action);
            if (!hadNext && useFirst) {
                useFirst = false;
                return secondSpliterator.tryAdvance(action);
            }
            return hadNext;
        }
    }
}