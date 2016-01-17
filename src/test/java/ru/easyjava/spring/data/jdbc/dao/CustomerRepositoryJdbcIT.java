package ru.easyjava.spring.data.jdbc.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.easyjava.spring.data.jdbc.entity.Customer;

import javax.inject.Inject;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@ContextConfiguration("/testContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerRepositoryJdbcIT {
    @Inject
    private CustomerRepositoryJdbc testedObject;

    @DirtiesContext
    @Test
    public void testAdd() {
        Customer c = new Customer();
        c.setEmail("nextone@example.org");
        testedObject.add(c);
        assertThat(testedObject.allEmails(), hasItem("nextone@example.org"));
    }
}