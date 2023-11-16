package com.codepath.mybitfitapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EntryActivity: AppCompatActivity() {
    private lateinit var foodInput: EditText
    private lateinit var calorieInput: EditText
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.food_entry)

        // TODO: Find the views for the screen
        foodInput = findViewById(R.id.foodInputView)
        calorieInput = findViewById(R.id.caloriesInputView)
        submitButton = findViewById(R.id.submitButton)

        submitButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            val food = DisplayFood(foodInput.text.toString(), calorieInput.text.toString().toInt())
            intent.putExtra("ENTRY_EXTRA", food)
            this.startActivity(intent)
        }
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