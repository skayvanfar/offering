package ir.sk.offering.client;

import ir.sk.offering.model.Offer;
import ir.sk.offering.adt.OfferCollection;
import ir.sk.offering.adt.ResizingArrayOfferCollection;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Logger;

public class JsonReader<T extends Offer> implements Reader<T> {

    private static final Logger logger = Logger.getLogger(JsonReader.class.getName());

    private RestTemplate restTemplate = new RestTemplate();

    private OfferCollection<T> offerCollection = new ResizingArrayOfferCollection<>(20);

    @Override
    public OfferCollection<T> read(String url) throws MalformedURLException {
        if (url == null || url.equals(""))
            throw new MalformedURLException("url is not correct");

        logger.info("call third party apt to get offers ... ");


        ParameterizedTypeReference<List<T>> typeRef = new ParameterizedTypeReference<List<T>>() {};
      //  HttpHeaders headers = new HttpHeaders();

    //    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    //    HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        // Offer[] myModelClasses = restTemplate.postForObject(url,null, Offer[].class);
        ResponseEntity<List<T>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, typeRef);
        List<T> offers = responseEntity.getBody();

        logger.info("adding offers to offerCollection");
        offerCollection.addAll(offers);

        return offerCollection;
    }
}
