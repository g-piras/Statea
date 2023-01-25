package its.statea.consumer.queue.message;

import its.statea.consumer.queue.istatapi.entity.IstatRecordYear;

public class IstatRecordYearMessage extends IstatRecordMessage<IstatRecordYear> {

    public IstatRecordYearMessage(IstatRecordYear record) {
        super(record);
    }

    public IstatRecordYearMessage() {
    }
}