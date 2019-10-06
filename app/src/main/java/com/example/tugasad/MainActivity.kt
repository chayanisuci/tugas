package com.example.tugasad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var isFragmentOneLoaded = true
    val manager = supportFragmentManager
    var kanan: Button? = null
    var kiri: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kanan = findViewById(R.id.next)
        kiri = findViewById(R.id.back)

        val kanan = findViewById<Button>(R.id.next)
        val kiri = findViewById<Button>(R.id.back)
        showFragmentOne()

        kanan.setOnClickListener {
            if (isFragmentOneLoaded)
                showFragmentthree()
            else
                showFragmentTwo()
        }

        kiri?.setOnClickListener {
            if (isFragmentOneLoaded)
                showFragmentTwo()
            else
                showFragmentOne()
        }

    }

    fun showFragmentOne(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentOne()
        transaction.replace(R.id.fragment,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded=true
        kanan?.isEnabled=true
        kiri?.isEnabled=true
    }

    fun showFragmentTwo(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentTwo()
        transaction.replace(R.id.fragment,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded=true
        kanan?.isEnabled=true
        kiri?.isEnabled=true
    }

    fun showFragmentthree(){
        val transaction = manager.beginTransaction()
        val fragment = Fragmentthree()
        transaction.replace(R.id.fragment,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded=true
        kanan?.isEnabled=true
        kiri?.isEnabled=true
    }
}
