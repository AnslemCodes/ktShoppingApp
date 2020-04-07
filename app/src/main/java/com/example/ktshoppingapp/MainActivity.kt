package com.example.ktshoppingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ktshoppingapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ShopAdapter.OnShopItemClickListener {

     lateinit var binding: ActivityMainBinding

    lateinit var shoplist :ArrayList<ShopData>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        shoplist = ArrayList()
        addShops()

        shopRecycler.layoutManager = LinearLayoutManager(this)

        shopRecycler.adapter = ShopAdapter (shoplist,this)

    }

    fun addShops (){

        shoplist.add(ShopData("Surgical Mask","A Surgical Mask is also known as procedure mask, medical mask or simply face mask,  it is intented to be worn by health professionals during surgery","$ 300",R.drawable.surgical_mask))
        shoplist.add(ShopData("Hand Sanitizer","Hand Sanitizer is  apply to the hands for the purpose of removing common pathogens (disease - causing organism)","$200",R.drawable.dettol_senitiser))
        shoplist.add(ShopData("Strawberry Ice Cream","Strawberry ice cream ia a flavor of ice cream made with strawberry or strawberry flavoring.It is made by blending in fresh strawberries or strawberry flavoring with the eggs, cream, vanilla and sugar used to make ice cream.They are mostly colored pink or light red ","$100",R.drawable.ice_cream))
        shoplist.add(ShopData("Shoes","Donning the perfect pair of footwaer is something that compliments the whole look put together by a man, in a big way. Men's footwear comes in different styles","$ 500",R.drawable.shoes))
        shoplist.add(ShopData("Orange","Orange is a fruit of the citrus that has numerous benefits like Vitamin C, prevent skin damage, lowers the risk of cancer and cholesterol, controls blood sugar level etc","$ 200",R.drawable.orange2))

    }


    override fun onItemClick(item: ShopData, Position: Int) {
        Toast.makeText(this,item.name,Toast.LENGTH_SHORT).show()
        val intent = Intent(this,DetailsActivity::class.java)
        intent.putExtra("SHOPNAME",item.name)
        intent.putExtra("SHOPDESCRIPTION",item.description)
        intent.putExtra("SHOPIMAGE",item.Image.toString())
        startActivity(intent)


    }


}




