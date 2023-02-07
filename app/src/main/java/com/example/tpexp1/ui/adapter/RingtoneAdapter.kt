package com.example.tpexp1.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tpexp1.R
import com.example.tpexp1.data.model.Ringtone
import com.example.tpexp1.databinding.AdsItemsBinding
import com.example.tpexp1.databinding.BigCollectionItemsBinding
import com.example.tpexp1.databinding.CollectionItemsBinding
import com.example.tpexp1.databinding.RingtoneItemsBinding
import com.example.tpexp1.enums.RingType

class RingtoneAdapter(
    private val context: Context,
    private val callback: IOnClickItem,
) : RecyclerView.Adapter<RingtoneViewHolder>() {

    private var ringtoneMutableList: ArrayList<Ringtone> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RingtoneViewHolder {
        return when (viewType) {
            RingType.RING.viewType -> {
                RingtoneViewHolder.RingtonesViewHolder(
                    RingtoneItemsBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ), context
                )
            }
            RingType.COLLECTION_NORMAL.viewType -> {
                RingtoneViewHolder.ColectionViewHolder(
                    CollectionItemsBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ), context
                )
            }
           RingType.COLLECTION_RECOMMEND.viewType -> {
                RingtoneViewHolder.BigColectionViewHolder(
                    BigCollectionItemsBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ), context
                )
            }
            else -> {
                RingtoneViewHolder.AdsViewHolder(
                    AdsItemsBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ), context
                )
            }

        }
    }

    override fun onBindViewHolder(holder: RingtoneViewHolder, position: Int) {
        when (holder) {
            is RingtoneViewHolder.RingtonesViewHolder ->
                holder.bind(
                    ringtoneMutableList[position],
                    callback,
                    position,
                    ringtoneMutableList
                )
            is RingtoneViewHolder.ColectionViewHolder ->
                holder.bind(
                    ringtoneMutableList[position],
                    callback
                )
            is RingtoneViewHolder.BigColectionViewHolder ->
                holder.bind(
                    ringtoneMutableList[position],
                    callback
                )
            is RingtoneViewHolder.AdsViewHolder ->
                holder
        }
    }

    override fun getItemCount(): Int {
        return ringtoneMutableList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (ringtoneMutableList[position].type) {
            RingType.COLLECTION.type -> {
                when (ringtoneMutableList[position].collection.collectionType) {
                    RingType.COLLECTION_NORMAL.type -> RingType.COLLECTION_NORMAL.viewType
                    else ->  RingType.COLLECTION_RECOMMEND.viewType
                }
            }
            RingType.RING.type -> RingType.RING.viewType
            else -> RingType.ADVERTISE.viewType
        }
    }

    fun setList(list: ArrayList<Ringtone>) {
        this.ringtoneMutableList = list
        notifyDataSetChanged()
    }

    interface IOnClickItem {
        fun onClickDetailColection(position: Int, list: ArrayList<Ringtone>)
    }
}
