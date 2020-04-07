package com.example.ktshoppingapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.ktshoppingapp.databinding.ActivityDetailsBinding
import kotlinx.android.synthetic.main.activity_details.*








class DetailsActivity : AppCompatActivity() {
   private lateinit var binding :ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_details)


        shop_name.text = getIntent().getStringExtra("SHOPNAME")
        shop_description.text = getIntent().getStringExtra("SHOPDESCRIPTION")
        shop_image.setImageResource(getIntent().getStringExtra("SHOPIMAGE").toInt())




    }


}





