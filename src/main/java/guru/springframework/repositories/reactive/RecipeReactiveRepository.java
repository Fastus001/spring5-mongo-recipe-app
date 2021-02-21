package guru.springframework.repositories.reactive;

import guru.springframework.domain.Recipe;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by Tom - 21.02.2021
 */
public interface RecipeReactiveRepository extends ReactiveMongoRepository<Recipe,String> {

}
