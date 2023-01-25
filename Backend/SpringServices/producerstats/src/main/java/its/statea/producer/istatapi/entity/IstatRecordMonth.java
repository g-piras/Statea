package its.statea.producer.istatapi.entity;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IstatRecordMonth extends IstatRecordAbstract {
    
    private LocalDate date;

    @JsonGetter(value = "date")
    public LocalDate getDate() {
        return date;
    }

    @JsonSetter(value = "TIME_PERIOD")
    public void setDate(String dateString) {
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM", Locale.ITALIAN);
        this.date = YearMonth.parse(dateString, dtf).atDay(1);
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