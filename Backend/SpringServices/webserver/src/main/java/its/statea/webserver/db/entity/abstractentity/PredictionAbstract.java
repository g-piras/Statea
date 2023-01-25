package its.statea.webserver.db.entity.abstractentity;

import its.statea.webserver.db.entity.AccommodationType;
import its.statea.webserver.db.entity.Destination;
import its.statea.webserver.db.entity.ObservationType;
import its.statea.webserver.db.entity.Origin;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PredictionAbstract {
    
    @Id @ManyToOne(fetch = FetchType.EAGER) @JoinColumn(name = "origin_id") private Origin origin;
    @Id @ManyToOne(fetch = FetchType.EAGER) @JoinColumn(name = "destination_id") private Destination destination;
    @Id @ManyToOne(fetch = FetchType.EAGER) @JoinColumn(name = "accommodation_type_id") private AccommodationType accommodationType;
    @Id @ManyToOne(fetch = FetchType.EAGER) @JoinColumn(name = "observation_type_id") private ObservationType observationType;
    
    @Column(nullable = false) private Long prediction;
    
    public PredictionAbstract(Origin origin, Destination destination, AccommodationType accommodationType,
            ObservationType observationType, Long prediction) {
        this.origin = origin;
        this.destination = destination;
        this.accommodationType = accommodationType;
        this.observationType = observationType;
        this.prediction = prediction;
    }

    public PredictionAbstract() {
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

    public Long getPrediction() {
        return prediction;
    }

    public void setPrediction(Long prediction) {
        this.prediction = prediction;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        PredictionAbstract other = (PredictionAbstract) obj;
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
        return "PredictionAbstract [origin=" + origin + ", destination=" + destination + ", accommodationType="
                + accommodationType + ", observationType=" + observationType + ", prediction=" + prediction + "]";
    }
}
