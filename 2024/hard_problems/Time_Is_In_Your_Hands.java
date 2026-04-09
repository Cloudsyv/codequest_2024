import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Time_Is_In_Your_Hands {

	//private static final char QUOTATION_MARK = '\u2019'; // '\'';
	private static final char QUOTATION_MARK = '\''; 
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	private static final Map<String, ZoneId> TEAM_MEMBER_ZONEIDS = new HashMap<>();
	static {
		TEAM_MEMBER_ZONEIDS.put("Smith", ZoneId.of("US/Arizona"));
		TEAM_MEMBER_ZONEIDS.put("Sprey", ZoneId.of("US/Eastern"));
		TEAM_MEMBER_ZONEIDS.put("Anderson", ZoneId.of("Europe/London"));
		TEAM_MEMBER_ZONEIDS.put("Bolade", ZoneId.of("UTC+01:00"));
		TEAM_MEMBER_ZONEIDS.put("Hassan", ZoneId.of("UTC+02:00"));
		TEAM_MEMBER_ZONEIDS.put("Agarwal", ZoneId.of("UTC+05:30"));
		TEAM_MEMBER_ZONEIDS.put("Sato", ZoneId.of("UTC+09:00"));
		TEAM_MEMBER_ZONEIDS.put("Thomas", ZoneId.of("Australia/Melbourne"));
	}
	
	public static void main(String[] args) throws IOException {

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

			final int noOfTestCases = Integer.valueOf(reader.readLine().trim());

			for (int i = 0; i < noOfTestCases; i++) {
				Meeting meeting = parseLine(reader.readLine());
				
				writeOutput(writer, meeting);
			}
		}
	}
		
	private static Meeting parseLine(String input) {
		String[] values = input.split(" ");
		final String organiser = values[0]; 
		final LocalDateTime startDate = LocalDateTime.parse(values[1] + " " + values[2], DATE_FORMAT);
		final String[] attendees = Arrays.copyOfRange(values, 3, values.length);
		
		return new Meeting(organiser, startDate, attendees);
	}
	
	private static void writeOutput(BufferedWriter writer, Meeting meeting) throws IOException {
		writer.write(meeting.getOrganiser() + QUOTATION_MARK + "s Meeting:");
		writer.newLine();
		
		for (String attendee : meeting.getAttendees()) {
			ZoneId attendeeZoneId = TEAM_MEMBER_ZONEIDS.get(attendee);
			DateTimeFormatter localisedDateFormatter = DATE_FORMAT.withZone(attendeeZoneId);
			String formattedStartDate = localisedDateFormatter.format(meeting.getStartInstant());
			
			writer.write(attendee);
			writer.write(" ");
			writer.write(formattedStartDate);
			writer.newLine();
		}
	}

	public static class Meeting { 
		private final String organiser;
		private final Instant startInstant;
		private final List<String> attendees = new ArrayList<>();
		
		public Meeting(String organiser, LocalDateTime startDate, String... attendees) {
			this.organiser = organiser;
			this.startInstant = Instant.from(ZonedDateTime.of(startDate, TEAM_MEMBER_ZONEIDS.get(organiser)));
			this.attendees.add(organiser);
			this.attendees.addAll(Arrays.asList(attendees));
			this.attendees.sort(String::compareTo);
		}
		
		public String getOrganiser() {
			return this.organiser;
		}
		
		public Instant getStartInstant() {
			return this.startInstant;
		}
		
		public List<String> getAttendees() {
			return Collections.unmodifiableList(this.attendees);
		}
	}
	

}
