package business;

import javax.swing.JOptionPane;

public class BusinessException extends RuntimeException {

    public BusinessException() {
        super();
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        JOptionPane.showMessageDialog(null, message + "\n" + cause);
    }

    public BusinessException(String message) {
        super(message);
        JOptionPane.showMessageDialog(null, message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
        JOptionPane.showMessageDialog(null, cause);
    }
}