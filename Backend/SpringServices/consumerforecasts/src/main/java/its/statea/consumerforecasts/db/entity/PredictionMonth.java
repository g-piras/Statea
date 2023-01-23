package its.statea.consumerforecasts.db.entity;

import java.sql.Date;

import its.statea.consumerforecasts.db.entity.abstractentity.PredictionAbstract;
import its.statea.consumerforecasts.db.entity.composite.PredictionMonthKey;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table
@IdClass(PredictionMonthKey.class)
public class PredictionMonth extends PredictionAbstract {
    
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
}
