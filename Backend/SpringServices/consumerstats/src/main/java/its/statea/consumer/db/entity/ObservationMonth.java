package its.statea.consumer.db.entity;

import java.sql.Date;

import its.statea.consumer.db.entity.abstractentity.ObservationAbstract;
import its.statea.consumer.db.entity.composite.ObservationMonthKey;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table
@IdClass(ObservationMonthKey.class)
public class ObservationMonth extends ObservationAbstract {
    
    @Id private Date date;

    public ObservationMonth(Origin origin, Destination destination, AccommodationType accommodationType,
            ObservationType observationType, Date date, Long observation) {
        super(origin, destination, accommodationType, observationType, observation);
        this.date = date;
    }

    public ObservationMonth() {
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
        ObservationMonth other = (ObservationMonth) obj;
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
}
