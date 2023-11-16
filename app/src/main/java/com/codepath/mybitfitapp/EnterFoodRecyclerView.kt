package com.codepath.mybitfitapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EnterFoodRecyclerView (private val entries: List<DisplayFood>,
private val mListener: OnListFragmentInteractionListener?
)
: RecyclerView.Adapter<EnterFoodRecyclerView.FoodEntriesViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodEntriesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.food_entry, parent, false)
        return FoodEntriesViewHolder(view)
    }

    /**
     * This inner class lets us refer to all the different View elements
     * (Yes, the same ones as in the XML layout files!)
     */
    inner class FoodEntriesViewHolder(private val mView: View) : RecyclerView.ViewHolder(mView) {
        val foodItem: TextView = mView.findViewById<View>(R.id.foodInputView) as TextView
        val calories: TextView = mView.findViewById<View>(R.id.calorieView) as TextView

    }

    /**
     * This lets us "bind" each Views in the ViewHolder to its' actual data!
     */
    override fun onBindViewHolder(holder: FoodEntriesViewHolder, position: Int) {
        val entry = entries[position]

        holder.foodItem.text = entry.food
        holder.calories.text = entry.calories.toString()

    }

    /**
     * Remember: RecyclerView adapters require a getItemCount() method.
     */
    override fun getItemCount(): Int {
        return entries.size
    }
}