package uk.co.gamma.scrumpoker.generator;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import uk.co.gamma.scrumpoker.domain.Ticket;

/**
 * Implementations should generate a report for the
 * scrum poker results.
 *
 * Jackson is included in the dependencies. Feel free
 * to use this, another JSON library or none at all.
 */
public interface ReportGenerator {
	String generateReport(List<Ticket> tickets);
}
