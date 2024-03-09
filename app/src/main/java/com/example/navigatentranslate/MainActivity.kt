package com.example.navigatentranslate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.Exception
import android.content.Intent
import android.graphics.Bitmap
import android.provider.MediaStore


class MainActivity : AppCompatActivity() {

    //defining bottomnavigation
    lateinit var bottomNav : BottomNavigationView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Toolbar
        var toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "NavigateNTranslate"




        // loading fragment components
        loadFragment(Home())
        bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(Home())
                    true
                }
                R.id.navigate -> {
                    loadFragment(Navigate())
                    true
                }
                R.id.camera -> {
                    loadFragment(Camera())
                    true
                }
                R.id.translate -> {
                    loadFragment(Translate())
                    true
                }
                R.id.history -> {
                    loadFragment(History())
                    true
                }
                else ->{
                    false
                }
            }



        }
    }
    private fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }
}