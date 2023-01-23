package its.statea.webserver.db.entity;

import java.sql.Date;
import java.time.LocalDate;

import its.statea.webserver.db.entity.abstractentity.PredictionAbstract;
import its.statea.webserver.db.entity.composite.PredictionMonthKey;
import its.statea.webserver.helper.datamap.MonthRecordDatamap;
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
@IdClass(PredictionMonthKey.class)
public class PredictionMonth extends PredictionAbstract implements MonthRecordDatamap {
    
    @Id private Date date;

    public PredictionMonth(Origin origin, Destination destination, AccommodationType accommodationType,
            ObservationType observationType, Date date, Long prediction) {
        super(origin, destination, accommodationType, observationType, prediction);
        this.date = date;
    }

    public PredictionMonth() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((date == null) ? 0 : date.hashCode());
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
        PredictionMonth other = (PredictionMonth) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PredictionMonth [date=" + date + "] " + super.toString();
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
    public LocalDate getDatamapDate() {
 
        return this.date.toLocalDate();
    }

    @Override
    public Long getDatamapValue() {

        return this.getPrediction();
    }

    @Override
    public void setMonthRecordDatamapFields(MonthRecordDatamap source) {
        
        Origin origin = new Origin(); origin.setOriginDatamapFields(source.getDatamapOrigin());
        Destination destination = new Destination(); destination.setDestinationDatamapFields(source.getDatamapDestination());
        AccommodationType accommodationType = new AccommodationType(); accommodationType.setAccommodationTypeDatamapFields(source.getDatamapAccommodationType());
        ObservationType observationType = new ObservationType(); observationType.setObservationTypeDatamapFields(source.getDatamapObservationType());
        Date date = Date.valueOf(source.getDatamapDate());
        Long prediction = source.getDatamapValue();

        this.setOrigin(origin);
        this.setDestination(destination);
        this.setAccommodationType(accommodationType);
        this.setObservationType(observationType);
        this.setDate(date);
        this.setPrediction(prediction);
    }
}
