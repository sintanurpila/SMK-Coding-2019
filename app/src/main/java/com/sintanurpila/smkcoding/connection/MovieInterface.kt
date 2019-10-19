package com.sintanurpila.smkcoding.connection

import com.sintanurpila.smkcoding.model.ResponseMovieModel
import io.reactivex.internal.operators.observable.ObservableAmb
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieInterface {

    @GET("movie/now_playing")
    fun getListMovieNowPlaying(
        @Query("api_key")
        apiKey : String
    ): ObservableAmb<ResponseMovieModel>
}