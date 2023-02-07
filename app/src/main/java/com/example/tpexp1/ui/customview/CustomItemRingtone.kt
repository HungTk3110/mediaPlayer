package com.example.tpexp1.ui.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.tpexp1.BuildConfig
import com.example.tpexp1.R
import com.example.tpexp1.data.model.Ringtone
import com.example.tpexp1.databinding.RingtoneCustomItemsBinding

class CustomItemRingtone : ConstraintLayout {

    private lateinit var mBinding: RingtoneCustomItemsBinding

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    init {
        initView(context)
    }

    private fun initView(context: Context) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        mBinding = DataBindingUtil.inflate(inflater, R.layout.ringtone_custom_items, this, true)
    }

    fun setRingtone(ringtone: Ringtone) {
        val img = BuildConfig.DEFAULT_API_URL_LOAD + ringtone.image
        Glide.with(context)//1
            .load(img)    //2
            .centerCrop()  //3
            .placeholder(R.drawable.ic_launcher_background)  //4
            .error(R.drawable.ic_launcher_foreground)       //5
            .into(mBinding.imgLanguage)                      //6
        mBinding.name.text = ringtone.name
        mBinding.time.text = convertTime(ringtone.duration ?: 0)
        mBinding.hashTag.text = text(ringtone.displayHashtag)
    }

    private fun text(text: String? = ""): String {
        return text?.replace(",", "   ") ?: ""
    }

    private fun convertTime(time: Long): String {
        val miniTime = (time.toDouble() / 1000)
        return (miniTime/60).toInt().toString() + ":" + (miniTime%60).toInt().toString()
    }
}