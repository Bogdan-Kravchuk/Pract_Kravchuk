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
        Event event3 = new Event("Event 3"  , LocalDateTime.of(2026, Month.MARCH, 24, 5,58),10,  London, "track2");
        Event event4 = new Event("Event 4"  , LocalDateTime.of(2025, Month.MARCH, 24, 5,58),10,  Kyiv, "track2");
        Event event5 = new Event("Event 5"  , LocalDateTime.of(2024, Month.MARCH, 24, 5,58),10,  Kyiv, "track2");


        System.out.println(DateTimeLab.toInstant(event1));
        System.out.println("----------------------------");
        System.out.println(DateTimeLab.minutesBetween(event1, event2));
        System.out.println("----------------------------");
        System.out.println(DateTimeLab.minutesBetween(event1, event2));
        System.out.println("----------------------------");

        List<Event>  eventList = new ArrayList<>();
        eventList.add(event1);
        eventList.add(event2);
        eventList.add(event3);
        eventList.add(event4);
        eventList.add(event5);
        EventLab.findConflicts(eventList);
        System.out.println("----------------------------");
        EventLab.LambdaRefactorLab.sortLambda(eventList);
        System.out.println(eventList);
        System.out.println("----------------------------");
        EventLab.LambdaRefactorLab.sortAnonymous(eventList);
        System.out.println(eventList);
        System.out.println("----------------------------");
        EventLab.LambdaRefactorLab.sortMethodRef(eventList);
        System.out.println(eventList);
        System.out.println("----------------------------");
        System.out.println(DateTimeLab.startInZone(event3, Kyiv));
    }
}
