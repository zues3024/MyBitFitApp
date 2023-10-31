package com.codepath.mybitfitapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EntryActivity: AppCompatActivity() {
    private lateinit var mediaImageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var bylineTextView: TextView
    private lateinit var abstractTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.food_item)

        // TODO: Find the views for the screen
        titleTextView = findViewById(R.id.foodItemView)
        bylineTextView = findViewById(R.id.calorieView)
//        abstractTextView = findViewById(R.id.mediaAbstract)

        // TODO: Get the extra from the Intent
//        val foodEntry = intent.getSerializableExtra(ARTICLE_EXTRA) as DisplayArticle
//
//        // TODO: Set the title, byline, and abstract information from the article
//        titleTextView.text = foodEntry.headline
//        bylineTextView.text = foodEntry.byline
//        abstractTextView.text = foodEntry.abstract

        // TODO: Load the media image
//        Glide.with(this)
//            .load(article.mediaImageUrl)
//            .into(mediaImageView)
    }
}