package com.kulitekno.submit

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class detail : AppCompatActivity() {
    private lateinit var tvName: TextView
    private lateinit var tvDetail: TextView
    private lateinit var tvLenght: TextView
    private lateinit var tvHeight: TextView
    private lateinit var tvWidht: TextView
    private lateinit var tvMachine: TextView
    private lateinit var tvSpeed: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_view)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        data
    }

    private val data: Unit
        private get() {
            val judul = intent.getStringExtra(TITLE)
            val detailIsi = intent.getStringExtra(ISI)
            val pjg = intent.getStringExtra(Lenght)
            val lbr = intent.getStringExtra(Widht)
            val tgi = intent.getStringExtra(Height)
            val mes = intent.getStringExtra(Machine)
            val spe = intent.getStringExtra(Speed)
            val img = intent.getIntExtra(img_data, 5)
            setImage(img)
            setIsi(judul, detailIsi, pjg, tgi, lbr, mes, spe)
            supportActionBar!!.title = judul
        }

    private fun setImage(img: Int) {
        val imagePhoto = findViewById<ImageView>(R.id.image)
        Glide.with(this)
                .load(img)
                .into(imagePhoto)
    }

    private fun setIsi(judul: String, detailIsi: String, pjg: String, tgi: String, lbr: String, mes: String, spe: String) {
        tvName = findViewById(R.id.tv_item_name)
        tvDetail = findViewById(R.id.tv_item_detail)
        tvLenght = findViewById(R.id.panjang)
        tvHeight = findViewById(R.id.tinggi)
        tvWidht = findViewById(R.id.lebar)
        tvMachine = findViewById(R.id.mesin)
        tvSpeed = findViewById(R.id.speed)
        tvName.setText(judul)
        tvDetail.setText(detailIsi)
        tvLenght.setText(pjg)
        tvHeight.setText(tgi)
        tvWidht.setText(lbr)
        tvMachine.setText(mes)
        tvSpeed.setText(spe)
    }

    companion object {
        const val TITLE = "nothing"
        const val ISI = "falcon"
        const val Lenght = "panjang"
        const val Widht = "lebar"
        const val Height = "tinggi"
        const val Machine = "mesin"
        const val Speed = "maks"
        @JvmField
        var img_data: String? = null
    }
}