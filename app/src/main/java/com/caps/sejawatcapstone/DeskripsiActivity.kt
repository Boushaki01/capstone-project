package com.caps.sejawatcapstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.caps.sejawatcapstone.ui.activity.ListActivity

class DeskripsiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deskripsi)
        clickListener()
    }
    private fun clickListener(){
        val login = findViewById<TextView>(R.id.login)
        val home = findViewById<TextView>(R.id.home)
        val list = findViewById<TextView>(R.id.list)
        val deskripsi = findViewById<TextView>(R.id.deskripsi)
        login.setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        home.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        list.setOnClickListener{
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
        deskripsi.setOnClickListener{
            val intent = Intent(this,DeskripsiActivity::class.java)
            startActivity(intent)
        }
    }
}