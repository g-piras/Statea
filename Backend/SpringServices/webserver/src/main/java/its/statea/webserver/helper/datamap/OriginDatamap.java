package its.statea.webserver.helper.datamap;

public interface OriginDatamap {
    
    public String getDatamapId();
    public String getDatamapNameIta();
    public String getDatamapNameEng();
    public Boolean getDatamapIsAggregate();

    public void setOriginDatamapFields(OriginDatamap source);
}
