package _04_data_driven_movie;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class Screening {
    @Getter
    @Setter
    private Movie movie;
    @Getter
    @Setter
    private int sequence;
    @Getter
    @Setter
    private LocalDateTime whenScreened;
}
