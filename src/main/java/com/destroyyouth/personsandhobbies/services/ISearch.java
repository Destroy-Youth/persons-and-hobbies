package com.destroyyouth.personsandhobbies.services;

import java.util.List;

/**
 * Basic search interface to avoid boilerplate code in service interfaces.
 * 
 * @param <T>
 * @param <I>
 */
public interface ISearch<T, I> {

    public List<T> findAll();

    public T findById(I id);

}