package its.statea.consumer.queue.message;

public class ErrorMessage extends MyMessage {
    
    private String msg;

    public ErrorMessage(String msg) {
        this.msg = msg;
    }

    public ErrorMessage() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ErrorMessage [msg=" + msg + "]";
    }
}
