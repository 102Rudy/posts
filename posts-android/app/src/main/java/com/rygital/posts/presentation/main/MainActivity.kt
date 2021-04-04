package com.rygital.posts.presentation.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rygital.posts.R
import com.rygital.posts.presentation.main.di.MainActivityComponent
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView, OnPostClickListener {

    @Inject
    lateinit var mainPresenter: MainPresenter

    @Inject
    lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        MainActivityComponent.create(this).inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = this@MainActivity.adapter
        }
    }

    override fun onStart() {
        super.onStart()
        mainPresenter.onAttach(this)
    }

    override fun onStop() {
        super.onStop()
        mainPresenter.onDetach()
    }

    override fun setItems(items: List<PostViewData>) {
        adapter.setItems(items)
        adapter.notifyDataSetChanged()
    }

    override fun showError(localizedError: String) {
        Timber.i("Error: $localizedError")
        Toast.makeText(this, localizedError, Toast.LENGTH_SHORT).show()
    }

    override fun onPostClick(viewData: PostViewData) {
        Timber.i("Post $viewData is clicked! Do some useful action")
    }
}
