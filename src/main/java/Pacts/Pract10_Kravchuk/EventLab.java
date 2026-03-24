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

}
