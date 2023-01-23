package its.statea.consumer.queue.istatapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import its.statea.consumer.queue.countriesapi.entity.Country;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class IstatRecordAbstract {
    
    private Country origin;
    private District destination;
    private ObservationType observationType;
    private AccommodationType accommodationType;
    private String observation;
    
    public IstatRecordAbstract(Country origin, District destination, ObservationType observationType,
            AccommodationType accommodationType, String observation) {
        this.origin = origin;
        this.destination = destination;
        this.observationType = observationType;
        this.accommodationType = accommodationType;
        this.observation = observation;
    }

    public IstatRecordAbstract() {
    }

    public Country getOrigin() {
        return origin;
    }

    public void setOrigin(Country origin) {
        this.origin = origin;
    }

    public District getDestination() {
        return destination;
    }

    public void setDestination(District destination) {
        this.destination = destination;
    }

    public ObservationType getObservationType() {
        return observationType;
    }

    public void setObservationType(ObservationType observationType) {
        this.observationType = observationType;
    }

    public AccommodationType getAccommodationType() {
        return accommodationType;
    }

    public void setAccommodationType(AccommodationType accommodationType) {
        this.accommodationType = accommodationType;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((origin == null) ? 0 : origin.hashCode());
        result = prime * result + ((destination == null) ? 0 : destination.hashCode());
        result = prime * result + ((observationType == null) ? 0 : observationType.hashCode());
        result = prime * result + ((accommodationType == null) ? 0 : accommodationType.hashCode());
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
        IstatRecordAbstract other = (IstatRecordAbstract) obj;
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
        if (observationType == null) {
            if (other.observationType != null)
                return false;
        } else if (!observationType.equals(other.observationType))
            return false;
        if (accommodationType == null) {
            if (other.accommodationType != null)
                return false;
        } else if (!accommodationType.equals(other.accommodationType))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "IstatRecordAbstract [origin=" + origin + ", destination=" + destination + ", observationType="
                + observationType + ", accommodationType=" + accommodationType + ", observation=" + observation + "]";
    }
}