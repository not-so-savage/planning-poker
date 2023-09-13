package uk.co.gamma.scrumpoker.domain;

import java.time.LocalDateTime;
import java.util.Optional;

public class Ticket {
    private String name;
    private Developer owner;
    private TicketType ticketType;
    private Priority priority;
    private Optional<LocalDateTime> deadline;

    private Ticket(String name, Developer owner, TicketType ticketType, Priority priority, Optional<LocalDateTime> deadline) {
        this.name = name;
        this.owner = owner;
        this.ticketType = ticketType;
        this.priority = priority;
        this.deadline = deadline;
    }

    public static Ticket createBug(String name, Developer owner, Priority priority, LocalDateTime deadline) {
        return new Ticket(name, owner, TicketType.BUG, priority, Optional.ofNullable(deadline));
    };

    public static Ticket createFeature(String name, Developer owner, Priority priority, LocalDateTime deadline) {
        return new Ticket(name, owner, TicketType.FEATURE, priority, Optional.ofNullable(deadline));
    };

    public static Ticket createTask(String name, Developer owner, Priority priority) {
        return new Ticket(name, owner, TicketType.TASK, priority, Optional.empty());
    };

}
