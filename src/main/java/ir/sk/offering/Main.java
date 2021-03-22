package ir.sk.offering;

import ir.sk.offering.adt.OfferCollection;
import ir.sk.offering.adt.ResizingArrayOfferCollection;
import ir.sk.offering.client.JsonReader;
import ir.sk.offering.command.Command;
import ir.sk.offering.command.CommandFactory;
import ir.sk.offering.model.Offer;
import ir.sk.offering.service.OfferService;
import ir.sk.offering.service.OfferServiceImpl;
import org.springframework.web.client.RestClientException;

import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class.getName());

    private static String url = "http://localhost:8080/offering";

    private static OfferService offerService = new OfferServiceImpl(new JsonReader<>());

    public static void main(String[] args) {
        if (args.length == 0) {
            logger.info("No Arguments");
            System.exit(0);
        }
        try {
            offerService.fetchOffers(url);
        } catch (MalformedURLException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            System.exit(0);
        } catch (RestClientException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            System.exit(0);
        }

        String operation = args[0];

        /*CommandFactory commandFactory = new CommandFactory(offerService, args);
        Command command = commandFactory.CreateCommand(args[0]);
        System.out.println(command.execute());*/

        switch (operation) {
            case "count_by_price_range":
                System.out.println(offerService.countByPrice(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
                break;
            case "count_by_offer_id":
                System.out.println(offerService.getByFilter(offer -> offer.getVendorId() == Integer.parseInt(args[1])));
                break;
            case "count_by_title":
                System.out.println(offerService.getByFilter(offer -> offer.getVendorId() == Integer.parseInt(args[1])));
                break;
            case "count_by_price":
                System.out.println(offerService.getByFilter(offer -> offer.getVendorId() == Integer.parseInt(args[1])));
                break;
        }
    }
}
