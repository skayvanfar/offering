package ir.sk.offering.service;

import ir.sk.offering.adt.ResizingArrayOfferCollection;
import ir.sk.offering.client.Reader;
import ir.sk.offering.model.Offer;
import ir.sk.offering.adt.OfferCollection;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.util.function.Predicate;
import java.util.logging.Logger;

public class OfferServiceImpl implements OfferService {

    private static final Logger logger = Logger.getLogger(OfferService.class.getName());

    private Reader<Offer> reader;
    private OfferCollection<Offer> offerCollection = new ResizingArrayOfferCollection<>(1);

    public OfferServiceImpl(Reader<Offer> reader) {
        this.reader = reader;
    }

    @Override
    public void fetchOffers(String url) throws MalformedURLException {
        offerCollection = reader.read(url);
    }

    @Override
    public long countByPrice(int start, int end) {
        logger.info("offers are filtering by price range");
        return offerCollection.stream().filter(offer -> offer.getPrice() >= start && offer.getPrice() <= end).count();
    }

    @Override
    public long getByFilter(Predicate<Offer> predicate) {
        return offerCollection.stream().filter(predicate).count();
    }
}
