package ir.sk.offering.service;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import ir.sk.offering.client.JsonReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;



import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import com.github.tomakehurst.wiremock.client.WireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.urlPathMatching;

import static org.junit.Assert.*;


public class OfferServiceImplTest {

    private static final String APPLICATION_JSON = "application/json";



    private OfferService offerService = new OfferServiceImpl(new JsonReader<>());

    @Rule
    public WireMockRule wireMockRule = new WireMockRule();;

    @Before
    public void setUp() throws Exception {
        WireMock.stubFor(get(urlPathMatching("/offering"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", APPLICATION_JSON)
                        .withBody("[\n" +
                                "{\n" +
                                "\"offerId\": 123,\n" +
                                "\"productTitle\": \"Coffee machine\",\n" +
                                "\"vendorId\": 35,\n" +
                                "\"price\": 390.4\n" +
                                "},\n" +
                                "{\n" +
                                "\"offerId\": 124,\n" +
                                "\"productTitle\": \"Napkins\",\n" +
                                "\"vendorId\": 35,\n" +
                                "\"price\": 15.5\n" +
                                "},\n" +
                                "{\n" +
                                "\"offerId\": 125,\n" +
                                "\"productTitle\": \"Chair\",\n" +
                                "\"vendorId\": 84,\n" +
                                "\"price\": 230.0\n" +
                                "}\n" +
                                "]")));
        offerService.fetchOffers("http://localhost:8080/offering");
    }

    @After
    public void tearDown() {
    }


    @Test
    public void countByPrice() {
        long expected = 1;
        long result = offerService.countByPrice(10, 200);
        assertEquals(expected, result);
    }

    @Test
    public void getByFilter() {
        long expected = 1;
        long result = offerService.getByFilter(offer -> offer.getVendorId() == 84);
        assertEquals(expected, result);
    }
}