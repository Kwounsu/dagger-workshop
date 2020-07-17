package com.arthlimchiu.daggerworkshop.userdetails

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.arthlimchiu.daggerworkshop.Api
import com.arthlimchiu.daggerworkshop.R
import com.arthlimchiu.daggerworkshop.appComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class UserDetailsActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: UserDetailsViewModelFactory

    private lateinit var retrofit: Retrofit
    private lateinit var api: Api

    private lateinit var userRepository: UserRepository

    private lateinit var fullName: TextView
    private lateinit var numOfRepos: TextView

    private val viewModel: UserDetailsViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
        appComponent.inject(this)

        fullName = findViewById(R.id.full_name)
        numOfRepos = findViewById(R.id.num_of_repos)

        viewModel.user.observe(this, Observer { user ->
            fullName.text = user.name
            val reposText = "Public Repos: " + user.repos
            numOfRepos.text = reposText
        })

        val username = intent.getStringExtra("username")
        viewModel.searchUser(username)
    }
}
