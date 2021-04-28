package com.reloadly.account.exception;

import com.reloadly.commons.exceptions.ReloadlyException;

/**
 * Exception indicating that a requested account was not found.
 *
 * @author Arun Patra
 */
public class AccountNotFoundException extends ReloadlyException {

    private static final String DEFAULT_MESSAGE = "Account not found";

    public AccountNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public AccountNotFoundException(Exception e) {
        super(DEFAULT_MESSAGE, e);
    }

    public AccountNotFoundException(String message) {
        super(message);
    }

    public AccountNotFoundException(String message, Exception e) {
        super(message, e);
    }

}
