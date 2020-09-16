package com.kulitekno.submit

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kulitekno.submit.data.listData
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var rvJets: RecyclerView
    private val list = ArrayList<jet>()
    private var title = "Mode List"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setActionBarTitle(title)
        rvJets = findViewById(R.id.rv_heroes)
        rvJets.setHasFixedSize(true)

        list.addAll(listData)
        showRecyclerList()
    }

    //    menu atas code
    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            supportActionBar!!.title = title
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_about) {
            val move = Intent(this@MainActivity, about::class.java)
            move.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT or Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP
            startActivity(move)
        } else {
            setMode(item.itemId)
        }
        return super.onOptionsItemSelected(item)
    }

    fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                title = "Mode List"
                showRecyclerList()
            }
            R.id.action_cardview -> {
                title = "Mode CardView"
                showRecyclerCard()
            }
        }
        setActionBarTitle(title)
    }

    //    ===
    private fun showRecyclerList() {
        rvJets!!.layoutManager = LinearLayoutManager(this)
        val listAdapter = listAdapter(list)
        rvJets!!.adapter = listAdapter
        listAdapter.setOnItemClickCallback(object : listAdapter.OnItemClickCallback {
            override fun onItemClicked(data: jet?) {
//                showSelectedJet(data);
                val move = Intent(this@MainActivity, detail::class.java)
                move.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT or Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP
                move.putExtra(detail.TITLE, data!!.name)
                move.putExtra(detail.ISI, data.detail)
                move.putExtra(detail.img_data, data.photo)
                move.putExtra(detail.Lenght, data.lenght)
                move.putExtra(detail.Height, data.height)
                move.putExtra(detail.Widht, data.widht)
                move.putExtra(detail.Machine, data.machine)
                move.putExtra(detail.Speed, data.speed)
                startActivity(move)
            }
        })
    }

    //    private void showSelectedJet(jet Jet) {
    //        Toast.makeText(this, "Kamu memilih " + Jet.getName(), Toast.LENGTH_SHORT).show();
    //    }
    private fun showRecyclerCard() {
        rvJets!!.layoutManager = LinearLayoutManager(this)
        val CardAdapter = cardAdapter(list)
        rvJets!!.adapter = CardAdapter
        CardAdapter.setOnItemClickCallback(object : cardAdapter.OnItemClickCallback {
            override fun onItemClicked(data: jet?) {
//                showSelectedJet(data);
                val move = Intent(this@MainActivity, detail::class.java)
                move.putExtra(detail.TITLE, data!!.name)
                move.putExtra(detail.ISI, data.detail)
                move.putExtra(detail.img_data, data.photo)
                move.putExtra(detail.Lenght, data.lenght)
                move.putExtra(detail.Height, data.height)
                move.putExtra(detail.Widht, data.widht)
                move.putExtra(detail.Machine, data.machine)
                move.putExtra(detail.Speed, data.speed)
                startActivity(move)
            }
        })
    }
}