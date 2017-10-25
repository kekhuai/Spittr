package spittr;

import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "time");
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, "id", "time");
    }

}
