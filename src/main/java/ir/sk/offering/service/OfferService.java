package ir.sk.offering.service;

import ir.sk.offering.model.Offer;

import java.net.MalformedURLException;
import java.util.function.Predicate;

public interface OfferService {

    void fetchOffers(String url) throws MalformedURLException;

    long countByPrice(int start, int end);

    long getByFilter(Predicate<Offer> predicate);
}
