package ir.sk.offering.adt;

import ir.sk.offering.model.Offer;

import java.util.Collection;
import java.util.stream.Stream;

public interface OfferCollection<T> extends Iterable<T> {
    T get(int index);

    void addAll(Collection<T> anotherCollection);

    Stream<T> stream();
}
