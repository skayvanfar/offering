package ir.sk.offering.command;

import ir.sk.offering.service.OfferService;

public class CountByPriceRangeCommand implements Command {

    private OfferService offerService;
    private int start;
    private int end;

    private String name = "count_by_price_range";

    public CountByPriceRangeCommand(OfferService offerService, int start, int end) {
        this.offerService = offerService;
        this.start = start;
        this.end = end;
    }

    @Override
    public long execute() {
        return offerService.countByPrice(start, end);
    }
}
