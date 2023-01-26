package its.statea.webserver.web.v1.payload.response;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import its.statea.webserver.helper.datamap.MonthRecordDatamap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MonthlyRecordResponse implements MonthRecordDatamap, Serializable {
    
    private OriginResponse origin;
    private DestinationResponse destination;
    private AccommodationTypeResponse accommodationType;
    private ObservationTypeResponse observationType;
    private Long observation;
    private String date;
    
    public MonthlyRecordResponse(OriginResponse origin, DestinationResponse destination,
            AccommodationTypeResponse accommodationType, ObservationTypeResponse observationType, Long observation,
            LocalDate date) {
        this.origin = origin;
        this.destination = destination;
        this.accommodationType = accommodationType;
        this.observationType = observationType;
        this.observation = observation;
        this.setDate(date);
    }

    public MonthlyRecordResponse() {
    }

    public OriginResponse getOrigin() {
        return origin;
    }

    public void setOrigin(OriginResponse origin) {
        this.origin = origin;
    }

    public DestinationResponse getDestination() {
        return destination;
    }

    public void setDestination(DestinationResponse destination) {
        this.destination = destination;
    }

    public AccommodationTypeResponse getAccommodationType() {
        return accommodationType;
    }

    public void setAccommodationType(AccommodationTypeResponse accommodationType) {
        this.accommodationType = accommodationType;
    }

    public ObservationTypeResponse getObservationType() {
        return observationType;
    }

    public void setObservationType(ObservationTypeResponse observationType) {
        this.observationType = observationType;
    }

    public Long getObservation() {
        return observation;
    }

    public void setObservation(Long observation) {
        this.observation = observation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date.format(DateTimeFormatter.ISO_DATE);
    }

    @JsonIgnore
    @Override
    public OriginResponse getDatamapOrigin() {

        return this.origin;
    }

    @JsonIgnore
    @Override
    public DestinationResponse getDatamapDestination() {
 
        return this.destination;
    }

    @JsonIgnore
    @Override
    public AccommodationTypeResponse getDatamapAccommodationType() {

        return this.accommodationType;
    }

    @JsonIgnore
    @Override
    public ObservationTypeResponse getDatamapObservationType() {

        return this.observationType;
    }

    @JsonIgnore
    @Override
    public LocalDate getDatamapDate() {

        return LocalDate.parse(date);
    }

    @JsonIgnore
    @Override
    public Long getDatamapValue() {

        return this.observation;
    }

    @JsonIgnore
    @Override
    public void setMonthRecordDatamapFields(MonthRecordDatamap source) {
        
        this.origin = source.getDatamapOrigin();
        this.destination = source.getDatamapDestination();
        this.accommodationType = source.getDatamapAccommodationType();
        this.observationType = source.getDatamapObservationType();
        this.setDate(source.getDatamapDate());
        this.observation = source.getDatamapValue();        
    }
}
