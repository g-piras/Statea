package its.statea.consumer.queue.istatapi.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import its.statea.consumer.queue.countriesapi.entity.Country;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IstatRecordMonth extends IstatRecordAbstract {
    
    private LocalDate date;

    public IstatRecordMonth(Country origin, District destination, ObservationType observationType,
            AccommodationType accommodationType, String observation, LocalDate date) {
        super(origin, destination, observationType, accommodationType, observation);
        this.date = date;
    }

    public IstatRecordMonth() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
        IstatRecordMonth other = (IstatRecordMonth) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "IstatRecordMonth [date=" + date + "] " + super.toString();
    }
}