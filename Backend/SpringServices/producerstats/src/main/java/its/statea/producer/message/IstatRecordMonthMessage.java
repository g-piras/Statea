package its.statea.producer.message;

import its.statea.producer.istatapi.entity.IstatRecordMonth;

public class IstatRecordMonthMessage extends IstatRecordMessage<IstatRecordMonth> {

    public IstatRecordMonthMessage(IstatRecordMonth record) {
        super(record);
    }
}