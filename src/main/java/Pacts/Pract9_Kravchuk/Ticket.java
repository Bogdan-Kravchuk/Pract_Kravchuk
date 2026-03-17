package Pacts.Pract9_Kravchuk;

public class Ticket {
    private int priority;
    private String createdAt;

    public Ticket(String createdAt, int priority) {
        this.createdAt = createdAt;
        this.priority = priority;
    }

   String buildTicketId(String base){
        String ticketId = base;
        class IdBuilder {  // local
           String build(){
               return ticketId+" 12345";
           }
        }
        return new IdBuilder().build();

    }


    Runnable runOnce() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("run program");
            }
        };
    }

    static void main() {
        Ticket ticket = new Ticket("2018-09-20", 1);
        ticket.runOnce().run();

       String name = ticket.buildTicketId("2018-09-20");

        System.out.println(name);
    }
}
