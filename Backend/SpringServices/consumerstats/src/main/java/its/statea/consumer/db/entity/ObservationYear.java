package its.statea.consumer.db.entity;

import java.time.Year;

import its.statea.consumer.db.entity.abstractentity.ObservationAbstract;
import its.statea.consumer.db.entity.composite.ObservationYearKey;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table
@IdClass(ObservationYearKey.class)
public class ObservationYear extends ObservationAbstract {
    
    @Id private Year year;

    public ObservationYear(Origin origin, Destination destination, AccommodationType accommodationType,
            ObservationType observationType, Year year, Long observation) {
        super(origin, destination, accommodationType, observationType, observation);
        this.year = year;
    }

    public ObservationYear() {
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
        ObservationYear other = (ObservationYear) obj;
        if (year == null) {
            if (other.year != null)
                return false;
        } else if (!year.equals(other.year))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ObservationYear [year=" + year + "] " + super.toString();
    }
}
