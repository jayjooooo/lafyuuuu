package com.example.lafyuu

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Handle home navigation
                    return@OnItemSelectedListener true
                }
                R.id.navigation_explore -> {
                    // Handle explore navigation
                    return@OnItemSelectedListener true
                }
                R.id.navigation_cart -> {
                    // Handle cart navigation
                    return@OnItemSelectedListener true
                }
                R.id.navigation_offer -> {
                    // Handle offer navigation
                    return@OnItemSelectedListener true
                }
                R.id.navigation_Account -> {
                    // Handle account navigation
                    return@OnItemSelectedListener true
                }
            }
            false
        })

        // Add OnClickListener for LinearLayout
        val linearLayoutSale: LinearLayout = findViewById(R.id.linearLayoutSale)
        linearLayoutSale.setOnClickListener {
            val intent = Intent(this, SaleActivity::class.java)
            startActivity(intent)
        }

        // Add OnClickListener for ImageView to navigate to FavoriteActivity
        val imageView: ImageView = findViewById(R.id.imageView)
        imageView.setOnClickListener {
            val intent = Intent(this, FavoriteActivity::class.java)
            startActivity(intent)
        }
    }
}
