package com.example.tpexp1.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.tpexp1.BuildConfig
import com.example.tpexp1.R
import com.example.tpexp1.data.model.Ringtone
import com.example.tpexp1.databinding.ImageContainerBinding

class ViewPagerImageDetailAdapter(
    private val imageList: ArrayList<Ringtone>,
    private val position: Int ? = 0,
    private val context: Context,
) :
    RecyclerView.Adapter<ViewPagerImageDetailAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(val binding: ImageContainerBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding =
            ImageContainerBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        with(holder){
            with(imageList[position]){
                val img = BuildConfig.DEFAULT_API_URL_LOAD + this.image
                Glide.with(context)//1
                    .load(img)    //2
                    .centerCrop()  //3
                    .placeholder(R.drawable.ic_launcher_background)  //4
                    .error(R.drawable.ic_launcher_foreground)       //5
                    .into(binding.imageView)
            }
        }
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}