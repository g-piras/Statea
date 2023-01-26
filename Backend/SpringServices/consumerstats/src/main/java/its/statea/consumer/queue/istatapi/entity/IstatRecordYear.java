package its.statea.consumer.queue.istatapi.entity;

import java.time.Year;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import its.statea.consumer.queue.countriesapi.entity.Country;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IstatRecordYear extends IstatRecordAbstract {
    
    private Year year;

    public IstatRecordYear(Country origin, District destination, ObservationType observationType,
            AccommodationType accommodationType, String observation, Year year) {
        super(origin, destination, observationType, accommodationType, observation);
        this.year = year;
    }

    public IstatRecordYear() {
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
        IstatRecordYear other = (IstatRecordYear) obj;
        if (year == null) {
            if (other.year != null)
                return false;
        } else if (!year.equals(other.year))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "IstatRecordYear [year=" + year + "] " + super.toString();
    }
}