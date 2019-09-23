package com.example.fuel.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fuel.R
import com.example.fuel.adapter.NewsAdapter
import com.example.fuel.base.BaseFragment
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : BaseFragment(), MainView {

    private lateinit var model : MainViewModel
    private val adapter = NewsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProviders.of(this)[MainViewModel::class.java].init(kodein)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvNews.adapter = adapter
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
        rvNews.layoutManager =layoutManager
        rvNews.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                Logger.d(layoutManager.findLastCompletelyVisibleItemPosition())
            }
        })

        buttonGetNews.setOnClickListener {
            showProgressBar()
            if (model.isFirstLoad){
                model.getNewsList(10).observe(this, Observer {
                    list ->
                    adapter.submitList(list)
                    hideProgressBar()
                })

                model.fetchNewsList()
                model.isFirstLoad = false
            }else{
                model.getNewsList(10)
            }
        }

    }


    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }
}
