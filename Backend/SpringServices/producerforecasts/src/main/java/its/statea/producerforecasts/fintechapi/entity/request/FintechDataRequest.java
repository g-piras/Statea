package its.statea.producerforecasts.fintechapi.entity.request;

public class FintechDataRequest {
    
    // resource name
    private String name;
    // how many records
    private Integer quantity;
    
    public FintechDataRequest(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public FintechDataRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
