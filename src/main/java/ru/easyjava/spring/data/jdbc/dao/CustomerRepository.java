package ru.easyjava.spring.data.jdbc.dao;

import ru.easyjava.spring.data.jdbc.entity.Customer;

import java.util.Collection;

/**
 * Customer database layer.
 */
public interface CustomerRepository {
    /**
     * Creates new customer in the database.
     * @param c Customer object.
     */
    void add(Customer c);

    /**
     * Gets all emails from the database.
     * @return Collection of customer's emails.
     */
    Collection<String> allEmails();
}
