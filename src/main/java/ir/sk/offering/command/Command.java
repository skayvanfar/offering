package ir.sk.offering.command;

@FunctionalInterface
public interface Command {
    long execute();
}
