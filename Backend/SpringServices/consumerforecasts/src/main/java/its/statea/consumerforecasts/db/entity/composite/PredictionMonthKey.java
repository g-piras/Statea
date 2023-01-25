package its.statea.consumerforecasts.db.entity.composite;

import java.sql.Date;

import its.statea.consumerforecasts.db.entity.AccommodationType;
import its.statea.consumerforecasts.db.entity.Destination;
import its.statea.consumerforecasts.db.entity.ObservationType;
import its.statea.consumerforecasts.db.entity.Origin;

public class PredictionMonthKey {
    
    private Origin origin;
    private Destination destination;
    private AccommodationType accommodationType;
    private ObservationType observationType;
    private Date date;
    
    public PredictionMonthKey(Origin origin, Destination destination, AccommodationType accommodationType,
            ObservationType observationType, Date date) {
        this.origin = origin;
        this.destination = destination;
        this.accommodationType = accommodationType;
        this.observationType = observationType;
        this.date = date;
    }

    public PredictionMonthKey() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        result = prime * result + ((date == null) ? 0 : date.hashCode());
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
        PredictionMonthKey other = (PredictionMonthKey) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
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
        return "PredictionMonthKey [date=" + date + ", origin=" + origin + ", destination=" + destination
                + ", accommodationType=" + accommodationType + ", observationType=" + observationType + "]";
    }
}
