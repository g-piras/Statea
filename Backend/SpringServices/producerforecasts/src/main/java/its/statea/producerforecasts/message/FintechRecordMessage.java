package its.statea.producerforecasts.message;

import its.statea.producerforecasts.fintechapi.entity.FintechRecordAbstract;

public class FintechRecordMessage<T extends FintechRecordAbstract> extends MyMessage {
    
    private T record;

    public FintechRecordMessage(T record) {
        this.record = record;
    }

    public FintechRecordMessage() {
    }

    public T getRecord() {
        return record;
    }

    public void setRecord(T record) {
        this.record = record;
    }

    @Override
    public String toString() {
        return "FintechRecordMessage [record=" + record + "]";
    }
}