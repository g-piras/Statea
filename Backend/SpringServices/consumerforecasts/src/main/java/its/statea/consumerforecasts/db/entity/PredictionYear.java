package its.statea.consumerforecasts.db.entity;

import java.time.Year;

import its.statea.consumerforecasts.db.entity.abstractentity.PredictionAbstract;
import its.statea.consumerforecasts.db.entity.composite.PredictionYearKey;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table
@IdClass(PredictionYearKey.class)
public class PredictionYear extends PredictionAbstract {
    
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
}
