package _01_ticket;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AudienceTest {
    private static final Long 티켓가격 = 10_000L;
    private static final Long 관람객_현금 = 20_000L;

    @Test
    void 초대장이_있는경우_관람객가방에_티켓을추가하고_0원을_리턴한다() {
        Audience 초대장소지_관람객 = new Audience(new Bag(관람객_현금, new Invitation()));

        assertEquals(초대장소지_관람객.buy(new Ticket(티켓가격)), 0L);
    }

    @Test
    void 초대장이_없는경우_관람객가방에_티켓을추가하고_티켓값을_리턴한다() {
        Audience 초대장없는_관람객 = new Audience(new Bag(관람객_현금));

        assertEquals(초대장없는_관람객.buy(new Ticket(티켓가격)), 티켓가격);
    }

}