package spittr;

import java.time.LocalDateTime;
import java.util.Objects;

public class Spittle {

    private final Long id;

    private final String message;

    private final LocalDateTime time;

    private Double latitude;

    private Double longitude;

    public Spittle(String message, LocalDateTime time) {
        this(null, message, time, null, null);
    }

    public Spittle(Long id, String message, LocalDateTime time, Double latitude, Double longitude) {
        super();
        this.id = id;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof Spittle)) {
            return false;
        }
        Spittle castOther = (Spittle) other;
        return Objects.equals(id, castOther.id) && Objects.equals(time, castOther.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time);
    }

}
