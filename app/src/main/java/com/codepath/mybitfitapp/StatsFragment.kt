package com.codepath.mybitfitapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class StatsFragment : Fragment() {
    private lateinit var adapter: BitFitAdapter
    private val foodList = mutableListOf<DisplayFood>()
    private lateinit var foodDAO: FoodDAO




    companion object {
        fun newInstance() = StatsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter = BitFitAdapter(foodList)
       viewLifecycleOwner.lifecycleScope.launch {

       }

        val view = inflater.inflate(R.layout.fragment_stats, container, false)
        val recyclerView = view.findViewById<View>(R.id.foodList_RV) as RecyclerView
        val context = view.context
        recyclerView.layoutManager = GridLayoutManager(context, 2)


        return view
    }


}