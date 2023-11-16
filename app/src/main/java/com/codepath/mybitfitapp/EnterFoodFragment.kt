package com.codepath.mybitfitapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EnterFoodFragment : Fragment(), OnListFragmentInteractionListener {
    private val foodList = mutableListOf<DisplayFood>()
    private lateinit var foodListRecyclerView: RecyclerView
    private lateinit var foodListAdapter: BitFitAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
//    ): View? {
//        val view = inflater.inflate(layout, container, false)
//        val progressBar = view.findViewById<View>(R.id.progress) as ContentLoadingProgressBar
//        val recyclerView = view.findViewById<View>(R.id.list) as RecyclerView
//        val context = view.context
//        recyclerView.layoutManager = GridLayoutManager(context, 2)
//        updateAdapter(progressBar, recyclerView)
//        return view
    ) : View? {
            val view = inflater.inflate(R.layout.food_entry, container, false)

            var foodInput = view.findViewById<EditText>(R.id.foodInputView)
            var caloriesInput = view.findViewById<EditText>(R.id.caloriesInputView)
            val button: Button = view.findViewById(R.id.submitButton)
            button.setOnClickListener {
                val newFoodItem = foodInput.text.toString()
                val newFoodCalories = caloriesInput.text.toString().toInt()
                val newSubmission = DisplayFood(newFoodItem, newFoodCalories)
                foodList.add(newSubmission)
                foodInput.text.clear()
                caloriesInput.text.clear()

            }

            return view

//        val newFoodItemInput = findViewById<EditText>(R.id.foodInputView)
//        val price = findViewById<EditText>(R.id.caloriesInputView)
//        findViewById<Button>(R.id.submitButton).setOnClickListener {
//            val newFoodItem = newFoodItemInput.text.toString()
//            val newFoodCalories = price.text.toString().toInt()
//
//            val newSubmission = DisplayFood(newFoodItem, newFoodCalories)
//            foodCounter = foodList.size
//            foodCounter++
//            val food = FoodEntity(foodCounter, newFoodItem, newFoodCalories)
//
//            foodList.add(newSubmission)
//
//            newFoodItemInput.text.clear()
//            price.text.clear()
//            adapter.notifyItemInserted(foodList.size)
//            foodList.let {
//                lifecycleScope.launch(Dispatchers.IO) {
//
//                    (application as BitFitApplication).db.foodDAO().insertOne(food)
//
//                }
//            }
//        }

    }

}