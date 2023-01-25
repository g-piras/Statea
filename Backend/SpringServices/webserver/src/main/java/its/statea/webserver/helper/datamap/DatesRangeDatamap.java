package its.statea.webserver.helper.datamap;

import java.time.LocalDate;

public interface DatesRangeDatamap {
    
    public LocalDate getDatamapStartDate();
    public LocalDate getDatamapEndDate();

    public void setDatesRangeDatamapFields(DatesRangeDatamap source);
}
