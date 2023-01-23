package its.statea.consumer.queue.message;

import its.statea.consumer.queue.istatapi.entity.IstatRecordAbstract;

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