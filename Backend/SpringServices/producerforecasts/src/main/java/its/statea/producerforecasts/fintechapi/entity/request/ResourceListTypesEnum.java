package its.statea.producerforecasts.fintechapi.entity.request;

import its.statea.producerforecasts.fintechapi.entity.FintechRecordAbstract;
import its.statea.producerforecasts.fintechapi.entity.FintechRecordMonth;
import its.statea.producerforecasts.fintechapi.entity.FintechRecordYear;

public enum ResourceListTypesEnum {
    
    annual("names_years", 8, FintechRecordYear.class), monthly("names", 96, FintechRecordMonth.class);

    // path to retrieve the resource list
    private final String path;
    // number of records to generate for the resource type
    private final Integer quantity;
    // type of record corresponding to the resource type
    private final Class<? extends FintechRecordAbstract> recordType;

    public Class<? extends FintechRecordAbstract> getRecordType() {
        return recordType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getPath() {
        return path;
    }

    private ResourceListTypesEnum(String path, Integer quantity, Class<? extends FintechRecordAbstract> recordType) {

        this.path = path;
        this.quantity = quantity;
        this.recordType = recordType;
    }
}
