package its.statea.webserver.db.entity;

import java.time.Year;

import its.statea.webserver.db.entity.abstractentity.PredictionAbstract;
import its.statea.webserver.db.entity.composite.PredictionYearKey;
import its.statea.webserver.helper.datamap.YearRecordDatamap;
import its.statea.webserver.web.v1.payload.response.AccommodationTypeResponse;
import its.statea.webserver.web.v1.payload.response.DestinationResponse;
import its.statea.webserver.web.v1.payload.response.ObservationTypeResponse;
import its.statea.webserver.web.v1.payload.response.OriginResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table
@IdClass(PredictionYearKey.class)
public class PredictionYear extends PredictionAbstract implements YearRecordDatamap {
    
    @Id private Year year;

    public PredictionYear(Origin origin, Destination destination, AccommodationType accommodationType,
            ObservationType observationType, Year year, Long prediction) {
        super(origin, destination, accommodationType, observationType, prediction);
        this.year = year;
    }

    public PredictionYear() {
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((year == null) ? 0 : year.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        PredictionYear other = (PredictionYear) obj;
        if (year == null) {
            if (other.year != null)
                return false;
        } else if (!year.equals(other.year))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PredictionYear [year=" + year + "] " + super.toString();
    }

    @Override
    public OriginResponse getDatamapOrigin() {
        
        OriginResponse res = new OriginResponse();
        res.setOriginDatamapFields(this.getOrigin());

        return res;
    }

    @Override
    public DestinationResponse getDatamapDestination() {

        DestinationResponse res = new DestinationResponse();
        res.setDestinationDatamapFields(this.getDestination());

        return res;
    }

    @Override
    public AccommodationTypeResponse getDatamapAccommodationType() {

        AccommodationTypeResponse res = new AccommodationTypeResponse();
        res.setAccommodationTypeDatamapFields(this.getAccommodationType());

        return res;
    }

    @Override
    public ObservationTypeResponse getDatamapObservationType() {

        ObservationTypeResponse res = new ObservationTypeResponse();
        res.setObservationTypeDatamapFields(this.getObservationType());

        return res;
    }

    @Override
    public Year getDatamapYear() {
 
        return this.year;
    }

    @Override
    public Long getDatamapValue() {

        return this.getPrediction();
    }

    @Override
    public void setYearRecordDatamapFields(YearRecordDatamap source) {
        
        Origin origin = new Origin(); origin.setOriginDatamapFields(source.getDatamapOrigin());
        Destination destination = new Destination(); destination.setDestinationDatamapFields(source.getDatamapDestination());
        AccommodationType accommodationType = new AccommodationType(); accommodationType.setAccommodationTypeDatamapFields(source.getDatamapAccommodationType());
        ObservationType observationType = new ObservationType(); observationType.setObservationTypeDatamapFields(source.getDatamapObservationType());
        Year year = source.getDatamapYear();
        Long prediction = source.getDatamapValue();

        this.setOrigin(origin);
        this.setDestination(destination);
        this.setAccommodationType(accommodationType);
        this.setObservationType(observationType);
        this.setYear(year);
        this.setPrediction(prediction);
    }
}
