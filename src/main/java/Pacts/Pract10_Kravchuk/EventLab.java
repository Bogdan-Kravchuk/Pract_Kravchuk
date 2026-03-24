package Pacts.Pract10_Kravchuk;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class EventLab {
    public static List<Event> pick(List<Event> events, Predicate<Event> condition) {
        List<Event> result = new ArrayList<>();
        for (Event e : events) {
            if (condition.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static List<String> labels(List<Event> events, Function<Event, String> formatter) {
        List<String> result = new ArrayList<>();
        for (Event e : events) {
            result.add(formatter.apply(e));
        }
        return result;
    }

    public static void notifyAll(List<Event> events, Consumer<Event> action) {
        for (Event e : events) {
            action.accept(e);
        }
    }

    public static Event create(Supplier<Event> factory) {
        return factory.get();
    }
    public static void findConflicts(List<Event> e){

        for(int i =0; i < e.size(); i++){

            for(int j =i+1; j < e.size(); j++) {
                Event event1 = e.get(i);
                Event event2 = e.get(j);

                Instant start1 = DateTimeLab.toInstant(event1);
                Instant start2 = DateTimeLab.toInstant(event2);
                Instant end1 = DateTimeLab.toInstant(new Event("", event1.end(), 0, event1.getZone(), ""));
                Instant end2 = DateTimeLab.toInstant(new Event("", event2.end(), 0, event2.getZone(), ""));

                if(start1.isBefore(end2) && end1.isAfter(start2))
                    System.out.println("Конфлікт події " +event1+ " і "+event2 + "перетинаються!");
                else
                    System.out.println("Все добре!");
            }
        }
    }

    class LambdaRefactorLab {
        public static void sortAnonymous(List<Event> events) {
            events.sort(new Comparator<Event>() {
                @Override
                public int compare(Event e1, Event e2) {
                    return e1.getStart().compareTo(e2.getStart());
                }
            });
        }

        public static void sortLambda(List<Event> events) {
            events.sort((e1, e2) -> e1.getStart().compareTo(e2.getStart()));
        }

        public static void sortMethodRef(List<Event> events) {
            events.sort(Comparator.comparing(Event::getStart));
        }
    }

}
