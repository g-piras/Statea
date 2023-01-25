package its.statea.producerforecasts.message;

import its.statea.producerforecasts.fintechapi.entity.FintechRecordMonth;

public class FintechRecordMonthMessage extends FintechRecordMessage<FintechRecordMonth> {

    public FintechRecordMonthMessage(FintechRecordMonth record) {
        super(record);
    }

    public FintechRecordMonthMessage() {
    }
}