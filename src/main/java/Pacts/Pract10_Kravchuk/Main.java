package Pacts.Pract10_Kravchuk;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        LocalDateTime endTime;
        ZoneId Kyiv = ZoneId.of("Europe/Kyiv");
        Event event1 = new Event("Event 1"  , LocalDateTime.of(2026, Month.MARCH, 24, 11,58),5,  Kyiv, "track1");
        endTime = event1.end();

        System.out.println(endTime);
        System.out.println(event1.label());
        System.out.println(event1);

        ZoneId London = ZoneId.of("Europe/London");
        Event event2 = new Event("Event 2"  , LocalDateTime.of(2026, Month.MARCH, 24, 11,58),10,  Kyiv, "track2");

        System.out.println(DateTimeLab.toInstant(event1));
        System.out.println("----------------------------");
        System.out.println(DateTimeLab.minutesBetween(event1, event2));
        System.out.println("----------------------------");
        System.out.println(DateTimeLab.minutesBetween(event1, event2));
        System.out.println("----------------------------");

        List<Event>  eventList = new ArrayList<>();
        eventList.add(event1);
        eventList.add(event2);
        EventLab.findConflicts(eventList);



    }
}
