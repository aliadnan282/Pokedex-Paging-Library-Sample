package io.husayn.paging_library_sample.listing;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import io.husayn.paging_library_sample.data.Pokemon;
import io.husayn.paging_library_sample.data.PokemonDataBase;

public class MainViewModel extends AndroidViewModel {

    private static final int INITIAL_LOAD_KEY = 0;
    private static final int PAGE_SIZE = 20;
    private static final int PREFETCH_DISTANCE = 5;
    private LiveData<PagedList<Pokemon>> personsLiveData;

    //personsLiveData =pagedListBuilder.

    public MainViewModel(@NonNull Application application) {
        super(application);
        DataSource.Factory<Integer, Pokemon> factory = PokemonDataBase.getInstance(getApplication()).pokemonDao().getAllPagedPokemons();

        LivePagedListBuilder<Integer, Pokemon> pagedListBuilder = new LivePagedListBuilder<Integer, Pokemon>(factory, 50);
        personsLiveData = pagedListBuilder.build();
    }

    public LiveData<PagedList<Pokemon>> getPersonsLiveData() {
        return personsLiveData;
    }

 /*   public MainViewModel() {
        PokemonDao pokemonDao = PokemonDataBase.getInstance(PokemonApplication.getContext()).pokemonDao();
        pokemonList = pokemonDao.getAllPagedPokemons().create(INITIAL_LOAD_KEY, new PagedList.Config.Builder()
                .setPageSize(PAGE_SIZE)
                .setPrefetchDistance(PREFETCH_DISTANCE)
                .setEnablePlaceholders(true)
                .build()
        );
    }*/
}
