import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

// You need to filter out attendees below the age of 18 and sort them by name using Java 8 functionalities.

// Your task is to complete the following file:
//     1. EventManagementApp.java

public class EventManagementApp {

    public static List<Attendee> filterAndSortAttendees(List<Attendee> attendees) {

	//implement code
    return attendees.stream().filter(a -> a.getAttendeeAge() >= 18)
    .sorted(Comparator.comparing(Attendee :: getAttendeeAge))
    .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Attendee> attendees = new ArrayList<>();
        attendees.add(new Attendee(1, "Alice", 25));
        attendees.add(new Attendee(2, "Bob", 16));
        attendees.add(new Attendee(4, "David", 19));
        attendees.add(new Attendee(3, "Carol", 22));
        attendees.add(new Attendee(5, "Eve", 17));

        List<Attendee> filteredAndSorted = filterAndSortAttendees(attendees);

	//implement code
        for(Attendee  attendee : filteredAndSorted){
            System.out.println("ID: " + attendee.getAttendeeId() + " Name: " + attendee.getAttendeeName() + "Age: " + attendee.getAttendeeAge());
        }
        
    }
}

class Attendee{
    private int attendeeId;
    private String attendeeName;
    private int attendeeAge;

    public Attendee() {
    }

    public Attendee(int attendeeId, String attendeeName, int attendeeAge) {
        this.attendeeId = attendeeId;
        this.attendeeName = attendeeName;
        this.attendeeAge = attendeeAge;
    }
    public int getAttendeeId() {
        return attendeeId;
    }
    public void setAttendeeId(int attendeeId) {
        this.attendeeId = attendeeId;
    }
    public String getAttendeeName() {
        return attendeeName;
    }
    public void setAttendeeName(String attendeeName) {
        this.attendeeName = attendeeName;
    }
    public int getAttendeeAge() {
        return attendeeAge;
    }
    public void setAttendeeAge(int attendeeAge) {
        this.attendeeAge = attendeeAge;
    }    
}
