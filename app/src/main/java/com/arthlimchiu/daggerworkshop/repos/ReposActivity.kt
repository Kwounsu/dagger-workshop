package com.arthlimchiu.daggerworkshop.repos

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arthlimchiu.daggerworkshop.Api
import com.arthlimchiu.daggerworkshop.R
import com.arthlimchiu.daggerworkshop.appComponent
import com.arthlimchiu.daggerworkshop.userdetails.UserDetailsViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ReposActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ReposViewModelFactory
    private val viewModel: ReposViewModel by viewModels { factory }

    private lateinit var repos: RecyclerView
    private lateinit var reposAdapter: ReposAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repos)
        appComponent.reposSubcomponent().Build().inject(this)

        repos = findViewById(R.id.repos)
        repos.layoutManager = LinearLayoutManager(this)
        reposAdapter = ReposAdapter(listOf())
        repos.adapter = reposAdapter

        viewModel.repos.observe(this, Observer { repositories ->
            reposAdapter.updateRepos(repositories)
        })

        val username = intent.getStringExtra("username")
        viewModel.getRepos(username)
    }
}
