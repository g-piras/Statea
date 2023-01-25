package its.statea.webserver.db.entity;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.data.annotation.Immutable;

import its.statea.webserver.db.entity.abstractentity.ObservationAbstract;
import its.statea.webserver.db.entity.composite.ObservationMonthKey;
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
@Immutable //This entity is linked to a View
@Table
@IdClass(ObservationMonthKey.class)
public class ObservationMonthCustomView extends ObservationAbstract implements MonthRecordDatamap {
    
    @Id private Date date;

    public ObservationMonthCustomView(Origin origin, Destination destination, AccommodationType accommodationType,
            ObservationType observationType, Date date, Long observation) {
        super(origin, destination, accommodationType, observationType, observation);
        this.date = date;
    }

    public ObservationMonthCustomView() {
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
        ObservationMonthCustomView other = (ObservationMonthCustomView) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ObservationMonth [date=" + date + "] " + super.toString();
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

        return this.getObservation();
    }

    @Override
    public void setMonthRecordDatamapFields(MonthRecordDatamap source) {
        
        Origin origin = new Origin(); origin.setOriginDatamapFields(source.getDatamapOrigin());
        Destination destination = new Destination(); destination.setDestinationDatamapFields(source.getDatamapDestination());
        AccommodationType accommodationType = new AccommodationType(); accommodationType.setAccommodationTypeDatamapFields(source.getDatamapAccommodationType());
        ObservationType observationType = new ObservationType(); observationType.setObservationTypeDatamapFields(source.getDatamapObservationType());
        Date date = Date.valueOf(source.getDatamapDate());
        Long observation = source.getDatamapValue();

        this.setOrigin(origin);
        this.setDestination(destination);
        this.setAccommodationType(accommodationType);
        this.setObservationType(observationType);
        this.setDate(date);
        this.setObservation(observation);
    }
}
