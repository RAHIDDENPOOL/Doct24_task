package com.example.doct24_task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.doct24_task.model.Movie
import com.example.doct24_task.ui.theme.Doct24_taskTheme
import com.example.doct24_task.viewModel.MovieViewModel
import com.example.doct24_task.view.MovieItem

class MainActivity : ComponentActivity() {

    val movieViewModel by viewModels<MovieViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Doct24_taskTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    MovieList(movieList = movieViewModel.movieListResponse)
                    movieViewModel.getMovieList()
                }
            }
        }
    }
}

@Composable
fun MovieList(movieList: List<Movie>) {
    LazyColumn {
        itemsIndexed(items = movieList) { index, item -> MovieItem(movie = item) }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Doct24_taskTheme {
        val movie = Movie("HIDDENPOOL", "", "task done", "GJ")
        MovieItem(movie = movie)
    }

}