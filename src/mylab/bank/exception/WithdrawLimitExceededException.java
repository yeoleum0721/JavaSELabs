package mylab.bank.exception;

public class WithdrawLimitExceededException extends InsufficientBalanceException{
	public WithdrawLimitExceededException(String errMessage) {
		super(errMessage);
	}

}
