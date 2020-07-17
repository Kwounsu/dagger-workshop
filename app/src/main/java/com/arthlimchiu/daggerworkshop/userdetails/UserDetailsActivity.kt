package com.arthlimchiu.daggerworkshop.userdetails

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.arthlimchiu.daggerworkshop.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class UserDetailsActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: UserDetailsViewModelFactory

//    private lateinit var viewModel: UserDetailsViewModel
    private val viewModel: UserDetailsViewModel by viewModels { factory }

    private lateinit var fullName: TextView
    private lateinit var numOfRepos: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
        AndroidInjection.inject(this)

        fullName = findViewById(R.id.full_name)
        numOfRepos = findViewById(R.id.num_of_repos)

//        viewModel = ViewModelProvider(this, factory).get(UserDetailsViewModel::class.java)

        viewModel.user.observe(this, Observer { user ->
            fullName.text = user.name
            val reposText = "Public Repos: " + user.repos
            numOfRepos.text = reposText
        })

        val username = intent.getStringExtra("username")
        viewModel.searchUser(username)
    }
}
