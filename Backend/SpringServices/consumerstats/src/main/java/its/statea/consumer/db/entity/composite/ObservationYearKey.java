package its.statea.consumer.db.entity.composite;

import java.time.Year;

import its.statea.consumer.db.entity.AccommodationType;
import its.statea.consumer.db.entity.Destination;
import its.statea.consumer.db.entity.ObservationType;
import its.statea.consumer.db.entity.Origin;

public class ObservationYearKey {
    
    private Origin origin;
    private Destination destination;
    private AccommodationType accommodationType;
    private ObservationType observationType;
    private Year year;
    
    public ObservationYearKey(Origin origin, Destination destination, AccommodationType accommodationType,
            ObservationType observationType, Year year) {
        this.origin = origin;
        this.destination = destination;
        this.accommodationType = accommodationType;
        this.observationType = observationType;
        this.year = year;
    }

    public ObservationYearKey() {
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public AccommodationType getAccommodationType() {
        return accommodationType;
    }

    public void setAccommodationType(AccommodationType accommodationType) {
        this.accommodationType = accommodationType;
    }

    public ObservationType getObservationType() {
        return observationType;
    }

    public void setObservationType(ObservationType observationType) {
        this.observationType = observationType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((year == null) ? 0 : year.hashCode());
        result = prime * result + ((origin == null) ? 0 : origin.hashCode());
        result = prime * result + ((destination == null) ? 0 : destination.hashCode());
        result = prime * result + ((accommodationType == null) ? 0 : accommodationType.hashCode());
        result = prime * result + ((observationType == null) ? 0 : observationType.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ObservationYearKey other = (ObservationYearKey) obj;
        if (year == null) {
            if (other.year != null)
                return false;
        } else if (!year.equals(other.year))
            return false;
        if (origin == null) {
            if (other.origin != null)
                return false;
        } else if (!origin.equals(other.origin))
            return false;
        if (destination == null) {
            if (other.destination != null)
                return false;
        } else if (!destination.equals(other.destination))
            return false;
        if (accommodationType == null) {
            if (other.accommodationType != null)
                return false;
        } else if (!accommodationType.equals(other.accommodationType))
            return false;
        if (observationType == null) {
            if (other.observationType != null)
                return false;
        } else if (!observationType.equals(other.observationType))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ObservationYearKey [year=" + year + ", origin=" + origin + ", destination=" + destination
                + ", accommodationType=" + accommodationType + ", observationType=" + observationType + "]";
    }
}
