package its.statea.webserver.web.v1.payload.response;

import java.io.Serializable;
import java.time.Year;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import its.statea.webserver.helper.datamap.YearRecordDatamap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AnnualRecordResponse implements YearRecordDatamap, Serializable {
    
    private OriginResponse origin;
    private DestinationResponse destination;
    private AccommodationTypeResponse accommodationType;
    private ObservationTypeResponse observationType;
    private Long observation;
    private Integer year;
    
    public AnnualRecordResponse(OriginResponse origin, DestinationResponse destination,
            AccommodationTypeResponse accommodationType, ObservationTypeResponse observationType, Long observation,
            Year year) {
        this.origin = origin;
        this.destination = destination;
        this.accommodationType = accommodationType;
        this.observationType = observationType;
        this.observation = observation;
        this.setYear(year);
    }

    public AnnualRecordResponse() {
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year.getValue();
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
    public Year getDatamapYear() {

        return Year.of(this.year);
    }

    @JsonIgnore
    @Override
    public Long getDatamapValue() {

        return this.observation;
    }

    @JsonIgnore
    @Override
    public void setYearRecordDatamapFields(YearRecordDatamap source) {
        
        this.origin = source.getDatamapOrigin();
        this.destination = source.getDatamapDestination();
        this.accommodationType = source.getDatamapAccommodationType();
        this.observationType = source.getDatamapObservationType();
        this.setYear(source.getDatamapYear());
        this.observation = source.getDatamapValue();        
    }
}
