package io.husayn.paging_library_sample.data;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import static java.lang.reflect.Modifier.PRIVATE;

@Dao
public interface PokemonDao {

    @Query("SELECT * FROM pokemon ORDER BY id ASC")
    DataSource.Factory<Integer, Pokemon> getAllPagedPokemons();

    @Query("SELECT * FROM pokemon")
    LiveData<Pokemon> getAllPokemons();

    @VisibleForTesting(otherwise = PRIVATE)
    @Query("SELECT COUNT(*) FROM pokemon")
    Integer pokemonsCount();

    @Insert
    void insert(Pokemon... pokemons);

    @VisibleForTesting(otherwise = PRIVATE)
    @Query("DELETE FROM pokemon")
    void deleteAll();
}
