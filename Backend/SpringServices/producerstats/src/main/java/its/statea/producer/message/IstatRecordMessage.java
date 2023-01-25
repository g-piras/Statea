package its.statea.producer.message;

import its.statea.producer.istatapi.entity.IstatRecordAbstract;

public class IstatRecordMessage<T extends IstatRecordAbstract> extends MyMessage {
    
    private T record;

    public IstatRecordMessage(T record) {
        this.record = record;
    }

    public IstatRecordMessage() {
    }

    public T getRecord() {
        return record;
    }

    public void setRecord(T record) {
        this.record = record;
    }

    @Override
    public String toString() {
        return "IstatRecordMessage [record=" + record + "]";
    }
}