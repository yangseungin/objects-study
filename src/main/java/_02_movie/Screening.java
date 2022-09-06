package _02_movie;

public class Screening {
    private Movie movie;

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
    public Money getMovieFee() {
        return movie.getFee();
    }
}
