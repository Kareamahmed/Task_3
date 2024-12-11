package com.example.task_3

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task_3.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding : ActivitySecondBinding
    private val myAdapter by lazy { MyAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySecondBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val userName = intent.getStringExtra("name")
        binding.textWelcome.text = "welcome , ".plus(userName)

        val list = MoviesItems().getMoviesItems()
        myAdapter.updateList(list)
        binding.rvMovies.adapter=myAdapter
        binding.rvMovies.layoutManager = LinearLayoutManager(this)

        setSupportActionBar(binding.toolbar)

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when( item.itemId){
            R.id.cl_more->{
                myAdapter.updateList(MoviesItems().getMoreItems())
                binding.rvMovies.adapter=myAdapter
                binding.rvMovies.layoutManager=LinearLayoutManager(this)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}