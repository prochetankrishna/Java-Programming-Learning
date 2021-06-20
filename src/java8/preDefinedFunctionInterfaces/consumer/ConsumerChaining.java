package java8.preDefinedFunctionInterfaces.consumer;

import java.util.function.Consumer;

class Movie {

    String movieName;
    String movieResult;

    public Movie(String movieName, String movieResult) {
        this.movieName = movieName;
        this.movieResult = movieResult;
    }
}

public class ConsumerChaining {

    public static void main(String[] args) {

        Consumer<Movie> releaseInfoConsumer = movie -> System.out.println(movie.movieName + " is releasing");
        Consumer<Movie> resultInfoConsumer = movie -> System.out.println(movie.movieName + " is a " + movie.movieResult);
        Consumer<Movie> saveMovieConsumer = movie -> {
            System.out.println("Saving " + movie.movieName + " into database");
            System.out.println("Saving Done");
        };

        Movie joker = new Movie("Joker", "Super Hit");
        Consumer<Movie> moviePipelineConsumer = releaseInfoConsumer.andThen(resultInfoConsumer.andThen(saveMovieConsumer));
        moviePipelineConsumer.accept(joker);
    }
}
