package com.example.ktshoppingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_shop_list.view.*

class ShopAdapter(private var items: ArrayList<ShopData>, private var clickListener: OnShopItemClickListener) :
    RecyclerView.Adapter<ShopAdapter.ShopViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {

        return ShopViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.activity_shop_list,
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int {
        return items.size

    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
//        holder.shopName?.text = items.get(position).name
//        holder.shopDescription?.text = items.get(position).description
//        holder.shopPrice?.text = items.get(position).price
//        holder.shopImage.setImageResource(items.get().Image)
        holder.Initialize(items.get(position), clickListener)


    }

    class ShopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var shopName = itemView.shopname
        var shopDescription = itemView.shopdescriptio
        var shopImage = itemView.shopimage
        var shopPrice = itemView.shopprice

        fun Initialize(item: ShopData, action: OnShopItemClickListener) {

            shopName.text = item.name
            shopDescription.text = item.description
            shopImage.setImageResource(item.Image)
            shopPrice.text = item.price

            itemView.setOnClickListener {
                action.onItemClick(item, adapterPosition)
            }
        }


    }


    interface OnShopItemClickListener {
        fun onItemClick(item: ShopData, position: Int)
    }

}
