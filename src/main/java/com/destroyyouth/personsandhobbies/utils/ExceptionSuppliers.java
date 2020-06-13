package com.destroyyouth.personsandhobbies.utils;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class ExceptionSuppliers {

    public static final Supplier<NoSuchElementException> NOT_FOUND = () -> new NoSuchElementException(
            Messages.NOT_FOUND);
}