package guru.springframework.repositories.reactive;

import guru.springframework.domain.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class CategoryReactiveRepositoryTest {

    public static final String FOO = "Foo";
    @Autowired
    CategoryReactiveRepository categoryReactiveRepository;

    @Before
    public void setUp() throws Exception {
        categoryReactiveRepository.deleteAll().block();
    }

    @Test
    public void save(){
        Category category = new Category();
        category.setDescription(FOO);

        categoryReactiveRepository.save(category).block();

        final Long count = categoryReactiveRepository.count().block();

        assertEquals(Long.valueOf(1L),count);
    }

    @Test
    public void findByDescription() {
        Category category = new Category();
        category.setDescription(FOO);

        categoryReactiveRepository.save(category).block();

        final Category fetchedCategory = categoryReactiveRepository.findByDescription(FOO).block();

        assertNotNull(fetchedCategory);
    }
}