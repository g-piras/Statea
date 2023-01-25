package its.statea.producerforecasts.message;

import its.statea.producerforecasts.fintechapi.entity.FintechRecordYear;

public class FintechRecordYearMessage extends FintechRecordMessage<FintechRecordYear> {

    public FintechRecordYearMessage(FintechRecordYear record) {
        super(record);
    }

    public FintechRecordYearMessage() {
    }
}