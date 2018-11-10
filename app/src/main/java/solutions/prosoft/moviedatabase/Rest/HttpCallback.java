package solutions.prosoft.moviedatabase.Rest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import solutions.prosoft.moviedatabase.Adapters.MoviesAdapter;
import solutions.prosoft.moviedatabase.Model.Movie;
import solutions.prosoft.moviedatabase.Model.MovieResponse;
import solutions.prosoft.moviedatabase.R;

public class HttpCallback implements Callback<MovieResponse> {
    RecyclerView recyclerView;
    Context context;

    public HttpCallback(RecyclerView recyclerView,Context context){
        this.recyclerView = recyclerView;
        this.context = context;
    }

    @Override
    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
        int statusCode = response.code();
        List<Movie> movies = response.body().getResults();
        recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, context));
    }

    @Override
    public void onFailure(Call<MovieResponse> call, Throwable t) {
        Toast.makeText(context, "Sorry! We could not load data", Toast.LENGTH_SHORT).show();
    }
}
