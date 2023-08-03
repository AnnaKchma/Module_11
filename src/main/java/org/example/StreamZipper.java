package org.example;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamZipper {

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        // Create custom iterator for the zipped elements
        Iterator<T> zippedIterator = new Iterator<>() {
            final Iterator<T> firstIterator = first.iterator();
            final Iterator<T> secondIterator = second.iterator();

            @Override
            public boolean hasNext() {
                return firstIterator.hasNext() && secondIterator.hasNext();
            }

            @Override
            public T next() {
                return firstIterator.next();
            }
        };

        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(zippedIterator, Spliterator.ORDERED);

        return StreamSupport.stream(spliterator, false);
    }

    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> stream2 = Stream.of(10, 20, 30);

        Stream<Integer> zippedStream = zip(stream1, stream2);

        zippedStream.forEach(System.out::println);
    }
}