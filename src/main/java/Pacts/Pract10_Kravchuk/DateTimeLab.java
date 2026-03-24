package Pacts.Pract10_Kravchuk;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.*;

public class DateTimeLab {


    public static Instant toInstant(Event e) {
        ZonedDateTime findZone = ZonedDateTime.of(e.getStart(), e.getZone());
        return findZone.toInstant();
    }

    public static long minutesBetween(Event a, Event b) {
        Instant instantEventA = toInstant(a);
        Instant instantEventB = toInstant(b);
        return Math.abs(Duration.between(instantEventA, instantEventB).toMinutes());
    }

    public static ZonedDateTime startInZone(Event e, ZoneId zone) {
        ZonedDateTime original = ZonedDateTime.of(e.getStart(), e.getZone());
        return original.withZoneSameInstant(zone);
    }

}

