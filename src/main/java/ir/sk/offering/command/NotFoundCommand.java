package ir.sk.offering.command;

public class NotFoundCommand implements Command {

    private String commandName;

    public NotFoundCommand(String commandName) {
        this.commandName = commandName;
    }

    @Override
    public long execute() {
        return 1;
    }
}
