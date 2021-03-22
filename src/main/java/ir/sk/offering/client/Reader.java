package ir.sk.offering.client;

import ir.sk.offering.adt.OfferCollection;

import java.net.MalformedURLException;

public interface Reader<T> {
    OfferCollection<T> read(String url) throws MalformedURLException;
}
