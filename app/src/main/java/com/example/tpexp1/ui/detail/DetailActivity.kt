package com.example.tpexp1.ui.detail

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings.System.RINGTONE
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.tpexp1.R
import com.example.tpexp1.data.model.RealmFavourite
import com.example.tpexp1.data.model.Ringtone
import com.example.tpexp1.data.realm.RealmManager
import com.example.tpexp1.databinding.ActivityDetailBinding
import com.example.tpexp1.ui.adapter.ViewPagerImageDetailAdapter
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.math.abs

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding
    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler
    private var list: ArrayList<Ringtone> = arrayListOf()
    private var list2: ArrayList<Ringtone> = arrayListOf()
    private var position: Int? = 0
    private lateinit var adapter: ViewPagerImageDetailAdapter
    private var favourite = RealmFavourite()

    @Inject
    lateinit var realmManager : RealmManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()
        ringtoneList()
        init()
        setUpTransformer()
    }

    private fun play() {
        var player = ExoPlayer.Builder(this@DetailActivity).build()

        // Build the media item.
        // Build the media item.
        val mediaItem: MediaItem =
            MediaItem.fromUri("https://us.tpringhashtag.xyz/ringstorage/15_vietnam/92_20220421/Vietnammusic220422004.mp3")
        // Set the media item to be played.
        // Set the media item to be played.
        player.setMediaItem(mediaItem)
        // Prepare the player.
        // Prepare the player.
        player.prepare()
        // Start the playback.
        // Start the playback.
        player.play()
    }

    override fun onPause() {
        super.onPause()

        handler.removeCallbacks(runnable)
    }

    private val runnable = Runnable {
        viewPager2.currentItem = viewPager2.currentItem + 1
    }

    private fun setUpTransformer() {
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(30))
        transformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.1f
        }

        viewPager2.setPageTransformer(transformer)
    }

    private fun init() {
        viewPager2 = findViewById(R.id.viewPager2)
        handler = Handler(Looper.myLooper()!!)

        adapter = ViewPagerImageDetailAdapter(list2, position, this)

        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 3
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {

                binding.nameRingtone.text = list2[position].name
                binding.layoutDetail.setBackgroundColor(Color.parseColor(list2[position].startColorCode))
                binding.hashTag.text = text(list2[position].displayHashtag)

                if ( list2[position].id?.let { realmManager.find(it.toInt()) } == true) {
                    binding.imgFavourite.apply {
                        setImageDrawable(null)
                        setBackgroundResource(R.drawable.vector2)
                    }
                } else {
                    binding.imgFavourite.apply {
                        setImageDrawable(null)
                        setBackgroundResource(R.drawable.vector)
                    }
                }

                binding.imgFavourite.setOnClickListener {
                    if (list2[position].id?.let { realmManager.find(it.toInt()) } == false) {
                        binding.imgFavourite.apply {
                            setImageDrawable(null)
                            setBackgroundResource(R.drawable.vector2)
                            list2[position].id?.let { it1 -> realmManager.insert(it1.toInt() , 1) }
                        }
                    } else {
                        binding.imgFavourite.apply {
                            setImageDrawable(null)
                            setBackgroundResource(R.drawable.vector)
                            list2[position].id?.let { it1 -> realmManager.deleteById(it1.toInt()) }
                        }
                    }
                }
            }

        })
        viewPager2.currentItem = position ?: 1

        binding.imgBack.setOnClickListener {
            finish()
        }

        binding.play.setOnClickListener {
            binding.play.setImageDrawable(null)
            it.setBackgroundResource(R.drawable.pause_circle)
            play()
        }

    }

    private fun getData() {
        this.list = intent.getSerializableExtra(LIST) as ArrayList<Ringtone>
        this.position = intent.getIntExtra(POSITION, 0)
    }

    private fun text(text: String? = ""): String {
        return text?.replace(",", "   ") ?: ""
    }

    private fun ringtoneList() {
        for (item in list) {
            if (item.type == RINGTONE) {
                list2.add(item)
            }

        }
    }

    companion object {
        const val POSITION = "position"
        const val LIST = "list"
    }

}