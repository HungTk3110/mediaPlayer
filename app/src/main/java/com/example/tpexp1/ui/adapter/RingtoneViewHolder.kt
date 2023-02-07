package com.example.tpexp1.ui.adapter

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.tpexp1.BuildConfig
import com.example.tpexp1.R
import com.example.tpexp1.data.model.Ringtone
import com.example.tpexp1.databinding.AdsItemsBinding
import com.example.tpexp1.databinding.BigCollectionItemsBinding
import com.example.tpexp1.databinding.CollectionItemsBinding
import com.example.tpexp1.databinding.RingtoneItemsBinding
import com.example.tpexp1.ui.customview.CustomItemRingtone

open class RingtoneViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {


    class RingtonesViewHolder(private val binding: RingtoneItemsBinding, val context: Context) :
        RingtoneViewHolder(binding) {
        fun bind(
            ringtone: Ringtone,
            callback: RingtoneAdapter.IOnClickItem,
            position: Int,
            list: ArrayList<Ringtone>
        ) = binding.apply {
            customRingtone.setRingtone(ringtone)
            customRingtone.setOnClickListener {
                callback.onClickDetailColection(position , list)
            }
        }
    }

    class ColectionViewHolder(private val binding: CollectionItemsBinding, val context: Context) :
        RingtoneViewHolder(binding) {

        fun bind(
            ringtone: Ringtone,
            callback:RingtoneAdapter.IOnClickItem,
        ) = binding.apply {
            nameCollection.text = ringtone.name
            val img = BuildConfig.DEFAULT_API_URL_LOAD + ringtone.collection.listImage
            Glide.with(context)//1
                .load(img)    //2
                .centerCrop()  //3
                .placeholder(R.drawable.ic_launcher_background)  //4
                .error(R.drawable.ic_launcher_foreground)       //5
                .into(binding.imgColection)
            nameCollection.text = ringtone.collection.name
        }
    }

    class BigColectionViewHolder(
        private val binding: BigCollectionItemsBinding,
        val context: Context,
    ) :
        RingtoneViewHolder(binding) {
        fun bind(
            ringtone: Ringtone,
            callback: RingtoneAdapter.IOnClickItem,
        ) = binding.apply {
            nameBigColection.text = ringtone.name
            val img = BuildConfig.DEFAULT_API_URL_LOAD + ringtone.collection.listImage
            Glide.with(context)//1
                .load(img)    //2
                .centerCrop()  //3
                .placeholder(R.drawable.ic_launcher_background)  //4
                .error(R.drawable.ic_launcher_foreground)       //5
                .into(binding.imgBigColection)
            nameBigColection.text = ringtone.collection.name
        }
    }

    class AdsViewHolder(private val binding: AdsItemsBinding, context: Context): RingtoneViewHolder(binding)
}