package com.sintanurpila.smkcoding


import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sintanurpila.smkcoding.connection.MovieInterface
import com.sintanurpila.smkcoding.connection.configRetrofit
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_movie.view.*
import org.jetbrains.anko.support.v4.toast

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment() {
    lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_movie, container, false)




//        val list = Movie.listMovie as ArrayList<MovieModel>
//        val layoutManager = LinearLayoutManager(activity)
//        val adapter = MovieAdapter(list, activity!!.applicationContext)
//
//        rootView.rv_movie.apply {
//            setLayoutManager(layoutManager)
//            setAdapter(adapter)
//        }

        return rootView
    }

    private fun getListMovie(){
        val movieNowPlaying =
        configRetrofit.retrofitConfig()
            .create(MovieInterface::class.java)
            .getListMovieNowPlaying(
                "385bfad4da8e1e92b233b2b6d07627a5")

        movieNowPlaying
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                //Menerima Respon Yang berhasil
                val list = response.results
                val layoutManager =
                    LinearLayoutManager(activity)
                val adapter =
                    MovieAdapter(list, activity!!.applicationContext)

                rootView.rv_movie.apply {
                    setLayoutManager(layoutManager)
                    setAdapter(adapter)
                }


            })
            }
}


