package com.codepath.mybitfitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val foodList = mutableListOf<DisplayFood>()
    private var foodCounter: Int = 0
    private lateinit var adapter: BitFitAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.foodList_RV)
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
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        val newFoodItemInput = findViewById<EditText>(R.id.foodInputView)
        val price = findViewById<EditText>(R.id.caloriesInputView)
        findViewById<Button>(R.id.submitButton).setOnClickListener {
            val newFoodItem = newFoodItemInput.text.toString()
            val newFoodCalories = price.text.toString().toInt()

            val newSubmission = DisplayFood(newFoodItem, newFoodCalories)
            foodCounter = foodList.size
            foodCounter++
            val food = FoodEntity(foodCounter, newFoodItem, newFoodCalories)

            foodList.add(newSubmission)

            newFoodItemInput.text.clear()
            price.text.clear()
            adapter.notifyItemInserted(foodList.size)
            foodList.let {
                lifecycleScope.launch(IO) {

                    (application as BitFitApplication).db.foodDAO().insertOne(food)

                }
            }



        }
    }
}