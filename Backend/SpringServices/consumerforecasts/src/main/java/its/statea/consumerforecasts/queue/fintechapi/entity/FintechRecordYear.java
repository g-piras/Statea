package its.statea.consumerforecasts.queue.fintechapi.entity;

import java.time.Year;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FintechRecordYear extends FintechRecordAbstract {
    
    private Year year;

    public FintechRecordYear(String originId, String destinationId, String observationTypeId,
            String accommodationTypeId, String prediction, Year year) {
        super(originId, destinationId, observationTypeId, accommodationTypeId, prediction);
        this.year = year;
    }

    public FintechRecordYear() {
    }

    @JsonGetter(value = "date")
    public Year getYear() {
        return year;
    }

    @JsonSetter(value = "date")
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
        FintechRecordYear other = (FintechRecordYear) obj;
        if (year == null) {
            if (other.year != null)
                return false;
        } else if (!year.equals(other.year))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "FintechRecordYear [year=" + year + "] " + super.toString();
    }
}