package Pacts.Pract10_Kravchuk;

import java.time.*;

public class Event {
private String title;
private LocalDateTime start;
private int durationMinutes;
private ZoneId zone;
private String track;

public Event(String title, LocalDateTime start, int durationMinutes, ZoneId zone, String track) {
    this.title = title;
    this.start = start;
    this.durationMinutes = durationMinutes;
    this.zone = zone;
    this.track = track;
}

public LocalDateTime end() {
    return start.plusMinutes(durationMinutes);
}

public String label() {
    return title + " [" + track + "]";
}


public String getTitle() { return title; }
public LocalDateTime getStart() { return start; }
public long getDurationMinutes() { return durationMinutes; }
public ZoneId getZone() { return zone; }
public String getTrack() { return track; }

@Override
public String toString() {
    return label() + " в " + start + " (" + zone + ")";
}
}