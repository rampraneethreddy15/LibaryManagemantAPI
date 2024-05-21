package libgenesis.responses;


public class Exceptionresponse {
    private String message;
    private String code;

    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Exceptionresponse(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public Exceptionresponse() {

    }
}
