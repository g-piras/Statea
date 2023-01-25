package its.statea.consumerforecasts.queue.fintechapi.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FintechRecordMonth extends FintechRecordAbstract {
    
    private LocalDate date;

    public FintechRecordMonth(String originId, String destinationId, String observationTypeId,
            String accommodationTypeId, String prediction, LocalDate date) {
        super(originId, destinationId, observationTypeId, accommodationTypeId, prediction);
        this.date = date;
    }

    public FintechRecordMonth() {
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
        FintechRecordMonth other = (FintechRecordMonth) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "FintechRecordMonth [date=" + date + "] " + super.toString();
    }
}