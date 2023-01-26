package its.statea.consumerforecasts.queue.message;

import its.statea.consumerforecasts.queue.fintechapi.entity.FintechRecordYear;

public class FintechRecordYearMessage extends FintechRecordMessage<FintechRecordYear> {

    public FintechRecordYearMessage(FintechRecordYear record) {
        super(record);
    }

    public FintechRecordYearMessage() {
    }
}