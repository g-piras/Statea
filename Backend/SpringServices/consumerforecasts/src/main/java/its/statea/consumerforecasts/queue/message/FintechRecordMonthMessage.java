package its.statea.consumerforecasts.queue.message;

import its.statea.consumerforecasts.queue.fintechapi.entity.FintechRecordMonth;

public class FintechRecordMonthMessage extends FintechRecordMessage<FintechRecordMonth> {

    public FintechRecordMonthMessage(FintechRecordMonth record) {
        super(record);
    }

    public FintechRecordMonthMessage() {
    }
}