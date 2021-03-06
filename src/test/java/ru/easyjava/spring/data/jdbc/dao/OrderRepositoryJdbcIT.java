package ru.easyjava.spring.data.jdbc.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.easyjava.spring.data.jdbc.entity.Order;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@ContextConfiguration("/testContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderRepositoryJdbcIT {
    @Inject
    private OrderRepositoryJdbc testedObject;

    @DirtiesContext
    @Test
    public void testGet() {
        Order actual = testedObject.get(100);
        assertThat(actual.getId(), is(100));
        assertThat(actual.getCustomer().getId(), is(100));
        assertThat(actual.getCustomer().getEmail(), is("TEST"));
    }
}