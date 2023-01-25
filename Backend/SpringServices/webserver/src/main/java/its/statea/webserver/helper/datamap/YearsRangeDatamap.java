package its.statea.webserver.helper.datamap;

import java.time.Year;

public interface YearsRangeDatamap {
    
    public Year getDatamapStartYear();
    public Year getDatamapEndYear();

    public void setYearsRangeDatamapFields(YearsRangeDatamap source);
}
