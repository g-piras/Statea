package its.statea.consumer.queue.message;

import its.statea.consumer.queue.istatapi.entity.IstatRecordMonth;

public class IstatRecordMonthMessage extends IstatRecordMessage<IstatRecordMonth> {

    public IstatRecordMonthMessage(IstatRecordMonth record) {
        super(record);
    }

    public IstatRecordMonthMessage() {
    }
}