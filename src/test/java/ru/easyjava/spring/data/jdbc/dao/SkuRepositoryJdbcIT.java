package ru.easyjava.spring.data.jdbc.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.easyjava.spring.data.jdbc.entity.Sku;

import javax.inject.Inject;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@ContextConfiguration("/testContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SkuRepositoryJdbcIT {
    @Inject
    private SkuRepositoryJdbc testedObject;

    @DirtiesContext
    @Test
    public void testGetDescription() {
        assertThat(testedObject.getDescription(100), is("TEST"));
    }

    @DirtiesContext
    @Test
    public void testChange() {
        Sku expected = new Sku();
        expected.setId(100);
        expected.setDescription("NEWBIE");

        testedObject.changeDescription(expected);

        assertThat(testedObject.getDescription(100), is("NEWBIE"));
    }
}