package faang.school.projectservice.exception;

public class ZeroDivisionException extends BusinessException {
    public ZeroDivisionException(int a) {
        super("ZERO_DIVISION", "Trying to divide " + a + " by zero!");
    }
}