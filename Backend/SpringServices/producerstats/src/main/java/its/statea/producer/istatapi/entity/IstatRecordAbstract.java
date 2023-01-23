package its.statea.producer.istatapi.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

import its.statea.producer.countriesapi.entity.Country;

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

    @JsonGetter(value = "origin")
    public Country getOrigin() {
        return origin;
    }

    @JsonGetter(value = "destination")
    public District getDestination() {
        return destination;
    }

    @JsonGetter(value = "observationType")
    public ObservationType getObservationType() {
        return observationType;
    }

    @JsonGetter(value = "accommodationType")
    public AccommodationType getAccommodationType() {
        return accommodationType;
    }

    @JsonGetter(value = "observation")
    public String getObservation() {
        return observation;
    }

    @JsonSetter(value = "PAESE_RES")
    public void setOrigin(String originCode) {

        Country originObj = new Country();
        originObj.setCountryCode(originCode);
        this.origin = originObj;
    }

    @JsonSetter(value = "ITTER107")
    public void setDestination(String destinationCode) {
        
        District destinationObj = new District();
        destinationObj.setId(destinationCode);
        this.destination = destinationObj;
    }

    @JsonSetter(value = "INDS")
    public void setObservationType(String observationTypeCode) {
        
        ObservationType observationTypeObj = new ObservationType();
        observationTypeObj.setId(observationTypeCode);
        this.observationType = observationTypeObj;
    }

    @JsonSetter(value = "TIPO_ESERCIZIO")
    public void setAccommodationType(String accommodationTypeCode) {
        
        AccommodationType accommodationTypeObj = new AccommodationType();
        accommodationTypeObj.setId(accommodationTypeCode);
        this.accommodationType = accommodationTypeObj;
    }

    @JsonSetter(value = "OBS_VALUE")
    public void setObservation(String observation) {
        this.observation = observation;
    }

    @JsonIgnore
    public void setOrigin(Country origin) {
        this.origin = origin;
    }

    @JsonIgnore
    public void setDestination(District destination) {
        this.destination = destination;
    }

    @JsonIgnore
    public void setObservationType(ObservationType observationType) {
        this.observationType = observationType;
    }

    @JsonIgnore
    public void setAccommodationType(AccommodationType accommodationType) {
        this.accommodationType = accommodationType;
    }

    public boolean hasValidValue() {

        try {
            
            Long.parseLong(observation);

            return true;

        } catch (NumberFormatException e) {
            
            return false;
        }
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