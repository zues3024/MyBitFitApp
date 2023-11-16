package com.codepath.mybitfitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val foodList = mutableListOf<DisplayFood>()
    private lateinit var adapter: BitFitAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = BitFitAdapter(foodList)
        lifecycleScope.launch {
            (application as BitFitApplication).db.foodDAO().getAll().collect { databaseList ->
                databaseList.map { entity ->
                    DisplayFood(
                        entity.food,
                        entity.calories


                    )
                }.also { mappedList ->
                    foodList.clear()
                    foodList.addAll(mappedList)
                    adapter.notifyDataSetChanged()
                }
            }
        }
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = adapter
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // define your fragments here
        val bestSellerBooksFragment: Fragment = EnterFoodFragment()
        val articleListFragment: Fragment = StatsFragment()

        // handle navigation selection
        bottomNavigationView.setOnItemSelectedListener { item ->
            lateinit var fragment: Fragment
            when (item.itemId) {
                R.id.nav_books -> fragment = bestSellerBooksFragment
                R.id.nav_articles -> fragment = articleListFragment
            }
            replaceFragment(fragment)
            true
        }

        // Set default selection
        bottomNavigationView.selectedItemId = R.id.nav_books
    }
    private fun replaceFragment(articleListFragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.article_frame_layout, articleListFragment)
        fragmentTransaction.commit()
    }


}