package com.caps.sejawatcapstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.caps.sejawatcapstone.databinding.ActivityMainBinding
import com.caps.sejawatcapstone.model.itemMenu
import com.caps.sejawatcapstone.ui.activity.ListActivity
import com.caps.sejawatcapstone.ui.adapter.ListMenuAdapter
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var rvLoc :RecyclerView
    private lateinit var rvCat :RecyclerView
    private lateinit var binding : ActivityMainBinding
    lateinit var adapter: ListMenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvLoc = findViewById(R.id.rv_loc)
        rvCat = findViewById(R.id.rv_cat)

        showRecycleList()
        showRecycleListt()
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
    private fun showRecycleList() {
        rvLoc.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapter = ListMenuAdapter()
        rvLoc.adapter = adapter
        adapter.setArrayList(listMenu)
        binding.rvLoc.adapter = adapter
    }
    private fun showRecycleListt() {
        rvCat.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapter = ListMenuAdapter()
        rvCat.adapter = adapter
        adapter.setArrayList(listMenuu)
        binding.rvCat.adapter = adapter
    }

    private val listMenu: ArrayList<itemMenu>
        get(){
            val image = resources.getStringArray(R.array.img)
            val name = resources.getStringArray(R.array.name)
            val listUser = ArrayList<itemMenu>()
            for (i in name.indices){
                listUser.add(
                    itemMenu(image[i], name[i],))
            }
            return listUser
        }

    private val listMenuu: ArrayList<itemMenu>
        get(){
            val image = resources.getStringArray(R.array.imgLokasi)
            val name = resources.getStringArray(R.array.lokasi)
            val listUser = ArrayList<itemMenu>()
            for (i in name.indices){
                listUser.add(
                    itemMenu(image[i], name[i],))
            }
            return listUser
        }

}