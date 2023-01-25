package its.statea.webserver.web.v1.payload.request.paramEnum;

public enum PredictionMonthSortEnum {
    
    // The dot (.) is needed for nested parameters
    date("date"),
    origin_id("origin.id"), 
    origin_nameIta("origin.nameIta"), 
    origin_nameEng("origin.nameEng"), 
    destination_id("destination.id"), 
    destination_nameIta("destination.nameIta"), 
    observation("prediction");

    private final String fieldName;

    private PredictionMonthSortEnum(String fieldName) {

        this.fieldName = fieldName;
    }

    @Override
    public String toString() {

        return this.fieldName;
    }
}
