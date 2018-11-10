package solutions.prosoft.moviedatabase.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import solutions.prosoft.moviedatabase.Model.Movie;
import solutions.prosoft.moviedatabase.R;


public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Movie> movies;
    private int rowLayout;
    private Context context;


    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView rating;
        ImageView thumbnail;

        public MovieViewHolder(View v) {
            super(v);
            movieTitle   = v.findViewById(R.id.tv_title);
            rating       = v.findViewById(R.id.tv_rating);
            thumbnail    = v.findViewById(R.id.iv_thumbnail);
        }
    }

    public MoviesAdapter(List<Movie> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.rating.setText(movies.get(position).getVoteAverage().toString());
        Glide.with(context).load(movies.get(position).getPosterPath()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}