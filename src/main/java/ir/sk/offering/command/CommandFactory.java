package ir.sk.offering.command;

import ir.sk.offering.service.OfferService;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private Map<String, Command> commandMap = new HashMap<>();

    public CommandFactory(OfferService offerService, String[] commandArguments) {
        this.commandMap.put("count_by_price_range", new CountByPriceRangeCommand(offerService, Integer.parseInt(commandArguments[1]), Integer.parseInt(commandArguments[2])));
        // TODO: 3/22/21
    }

    public Command CreateCommand(String commandName) {
        Command result = commandMap.get(commandName);
        result = (result == null) ? new NotFoundCommand("No Command") : result;
        return result;
    }
}
