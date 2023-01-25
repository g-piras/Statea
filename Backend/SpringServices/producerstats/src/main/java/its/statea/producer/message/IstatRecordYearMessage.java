package its.statea.producer.message;

import its.statea.producer.istatapi.entity.IstatRecordYear;

public class IstatRecordYearMessage extends IstatRecordMessage<IstatRecordYear> {

    public IstatRecordYearMessage(IstatRecordYear record) {
        super(record);
    }
}