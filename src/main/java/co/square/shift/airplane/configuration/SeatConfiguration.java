package co.square.shift.airplane.configuration;

import co.square.shift.airplane.repository.AvailableSeatsRepository;
import co.square.shift.airplane.repository.SeatsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeatConfiguration {

    @Bean("windowSeatAvailable")
    public SeatsRepository windowAvailableSeats()
    {
        return new AvailableSeatsRepository();
    }

    @Bean("aisleSeatAvailable")
    public SeatsRepository asileAvailableSeats()
    {
        return new AvailableSeatsRepository();
    }

    @Bean("middleSeatAvailable")
    public SeatsRepository middleAvailableSeats()
    {
        return new AvailableSeatsRepository();
    }
}
