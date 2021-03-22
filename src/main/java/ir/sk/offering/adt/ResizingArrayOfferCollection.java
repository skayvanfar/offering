package ir.sk.offering.adt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ResizingArrayOfferCollection<T> implements OfferCollection<T>{

    private List<T> offers;

    public ResizingArrayOfferCollection(int capacity) {
        offers = new ArrayList<>(capacity);
    }

    @Override
    public T get(int index) {
        return null;
    }

    public void addAll(Collection<T> anotherCollection) {
        offers.addAll(anotherCollection);
    }

    @Override
    public Iterator<T> iterator() {
        return offers.iterator();
    }

    public Stream<T> stream() {
        return offers.stream();
    }
}
