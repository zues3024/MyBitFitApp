package com.codepath.mybitfitapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BitFitAdapter(private val foodList: List<DisplayFood>) : RecyclerView.Adapter<BitFitAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val item = foodList[position]
        // Set item views based on views and data model
        holder.bind(item)
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        private val foodTextView = itemView.findViewById<TextView>(R.id.foodItemView)
        private val calorieText = itemView.findViewById<TextView>(R.id.calorieView)
        init {
            itemView.setOnClickListener(this)
        }
        fun bind(displayFood: DisplayFood) {
            foodTextView.text = displayFood.food
            calorieText.text = displayFood.calories.toString()
        }

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }
}