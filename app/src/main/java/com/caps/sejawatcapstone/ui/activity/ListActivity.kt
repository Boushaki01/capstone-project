package com.caps.sejawatcapstone.ui.activity

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.caps.sejawatcapstone.DeskripsiActivity
import com.caps.sejawatcapstone.Login
import com.caps.sejawatcapstone.MainActivity
import com.caps.sejawatcapstone.R
import com.caps.sejawatcapstone.databinding.ActivityListBinding
import com.caps.sejawatcapstone.databinding.ActivityMainBinding
import com.caps.sejawatcapstone.model.itemMenu
import com.caps.sejawatcapstone.ui.adapter.ListAdapter
import com.caps.sejawatcapstone.ui.adapter.ListMenuAdapter
import java.util.ArrayList

class ListActivity : AppCompatActivity() {
    private lateinit var rvList : RecyclerView
    private lateinit var binding : ActivityListBinding
    lateinit var adapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvList = findViewById(R.id.rv_list)
        showRecycleList()
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
            val intent = Intent(this,ListActivity::class.java)
            startActivity(intent)
        }
        deskripsi.setOnClickListener{
            val intent = Intent(this,DeskripsiActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showRecycleList() {
            rvList.layoutManager = LinearLayoutManager(this)
            adapter = ListAdapter()
            rvList.adapter = adapter
            adapter.setArrayList(listMenu)
            binding.rvList.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.search).actionView as SearchView
        return true
    }
    private val listMenu: ArrayList<itemMenu>
        get(){
            val image = resources.getStringArray(R.array.imgWisata)
            val name = resources.getStringArray(R.array.wisata)
            val listUser = ArrayList<itemMenu>()
            for (i in name.indices){
                listUser.add(
                    itemMenu(image[i], name[i],))
            }
            return listUser
        }
}