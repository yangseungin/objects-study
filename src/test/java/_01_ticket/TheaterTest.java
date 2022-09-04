package _01_ticket;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TheaterTest {
    private static final Long 매표소_현금 = 1_000_000L;
    private static final Long 티켓가격 = 10_000L;
    private static final Long 관람객_현금 = 20_000L;

    @Test
    void 초대장이_가방에있는_관람객에게_가방에_티켓을_넣어준다() {
        Audience 초대장_소지_관람객 = 초대장이_있는_관람객생성();
        Long 처음_소지_금액 = 초대장_소지_관람객.getBag().getAmount();
        Theater 극장 = 극장생성();

        극장.enter(초대장_소지_관람객);

        assertTrue(초대장_소지_관람객.getBag().hasTicket());
        assertEquals(처음_소지_금액, 초대장_소지_관람객.getBag().getAmount());
    }

    @Test
    void 초대장이_가방에없는_관람객에게_티켓요금만큼_현금을_제외시키고_티켓을_넣어준다() {
        Audience 초대장_없는_관람객 = 초대장이_없는_관람객생성();
        Long 처음_소지_금액 = 초대장_없는_관람객.getBag().getAmount();
        Theater 극장 = 극장생성();

        극장.enter(초대장_없는_관람객);


        assertTrue(초대장_없는_관람객.getBag().hasTicket());
        assertEquals(처음_소지_금액 - 초대장_없는_관람객.getBag().getAmount(), 티켓가격);
    }

    private Audience 초대장이_있는_관람객생성() {
        Bag bag = new Bag(관람객_현금, new Invitation());
        return new Audience(bag);
    }

    private Audience 초대장이_없는_관람객생성() {
        Bag bag = new Bag(관람객_현금);
        return new Audience(bag);
    }

    private TicketOffice 매표소생성() {
        return new TicketOffice(매표소_현금, new Ticket(10_000L));
    }

    private TicketSeller 판매원생성() {
        return new TicketSeller(매표소생성());
    }

    private Theater 극장생성() {
        return new Theater(판매원생성());
    }

    private List<Ticket> 티켓뭉치생성() {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(티켓가격));
        return tickets;
    }


}