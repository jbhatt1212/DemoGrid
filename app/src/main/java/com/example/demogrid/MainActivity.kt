package com.example.demogrid

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.util.Log
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import com.example.demogrid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ItemAdapter
    private val halfHeight by lazy { resources.displayMetrics.heightPixels / 2 }

    private var isExpanded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*enableEdgeToEdge()*/
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imageList = listOf(
            GridModel(R.drawable.images__5_),
            GridModel(R.drawable.images__8_),
            GridModel(R.drawable.ic_launcher_background),
            GridModel(R.drawable.ic_launcher_background),
            GridModel(R.drawable.ic_launcher_background),
            GridModel(R.drawable.ic_launcher_background),
            GridModel(R.drawable.ic_launcher_background),
            GridModel(R.drawable.ic_launcher_background),
            GridModel(R.drawable.ic_launcher_background),
            GridModel(R.drawable.ic_launcher_background),
            GridModel(R.drawable.ic_launcher_background),
            GridModel(R.drawable.ic_launcher_background),
            GridModel(R.drawable.ic_launcher_background),
            GridModel(R.drawable.ic_launcher_background),
            GridModel(R.drawable.ic_launcher_background),
            GridModel(R.drawable.ic_launcher_background),
            GridModel(R.drawable.ic_launcher_background),
            GridModel(R.drawable.ic_launcher_background),
            GridModel(R.drawable.ic_launcher_background),
            GridModel(R.drawable.ic_launcher_background),
            GridModel(R.drawable.ic_launcher_background),
            GridModel(R.drawable.ic_launcher_background),
            GridModel(R.drawable.ic_launcher_background),
            GridModel(R.drawable.ic_launcher_background),
            GridModel(R.drawable.images__8_),
            GridModel(R.drawable.images__5_)
        )

        adapter = ItemAdapter(imageList)
        val layoutManager = GridLayoutManager(this, 6)
        layoutManager.spanSizeLookup = object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (position == 0 || position == 1) 3 else 2
            }
        }
//        binding.recyclerView.setPadding(0, 0, 0, dpToPx(32))
//        binding.recyclerView.clipToPadding = false


        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter


//
//        binding.expandText.setOnClickListener {
//            if (!isExpanded){
//                Log.e("MainActivity","expand recycler")
//                expandRecycler()
        //         }
//            else{
//                Log.e("MainActivity","collapse recycler")
//                collapseRecycler()
//            }
//           if (!isExpanded) showHalfScreenRecycler() else collapseRecycler()

        //    }
    }
//    private fun showHalfScreenRecycler() {
//        binding.recyclerView.visibility = View.VISIBLE
//
//        val layoutParams = binding.recyclerView.layoutParams
//        layoutParams.height = halfHeight
//        binding.recyclerView.layoutParams = layoutParams
//
//        binding.recyclerView.post {
//            // Enable full scrolling once content goes beyond initial half height
//            binding.recyclerView.isNestedScrollingEnabled = true
//        }
//
//        isExpanded = true
//    }
//private fun expandRecycler() {
//    val transition = ChangeBounds().apply {
//        duration = 500
//        interpolator = DecelerateInterpolator()
//    }
//    TransitionManager.beginDelayedTransition(binding.main, transition)
//
//    binding.recyclerView.visibility = View.VISIBLE
//
//    val set = ConstraintSet()
//    set.clone(binding.main)
//
//    set.connect(binding.expandText.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
//    set.connect(binding.expandText.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
//    set.connect(binding.expandText.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
//
//    set.connect(binding.recyclerView.id, ConstraintSet.TOP, binding.expandText.id, ConstraintSet.BOTTOM)
//    set.connect(binding.recyclerView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
//    set.connect(binding.recyclerView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
//    set.connect(binding.recyclerView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
//    set.applyTo(binding.main)
//
//    set.applyTo(binding.main)
//
//
//    isExpanded = true
//}
//
//    private fun collapseRecycler() {
//        val transition = ChangeBounds().apply {
//            duration = 500
//            interpolator = DecelerateInterpolator()
//        }
//
//        TransitionManager.beginDelayedTransition(binding.main, transition)
//
//        val set = ConstraintSet()
//        set.clone(binding.main)
//        set.connect(binding.expandText.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
//        set.connect(binding.expandText.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
//        set.connect(binding.expandText.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
//
//        set.connect(binding.recyclerView.id, ConstraintSet.TOP, binding.expandText.id, ConstraintSet.BOTTOM)
//        set.connect(binding.recyclerView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
//        set.connect(binding.recyclerView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
//        set.connect(binding.recyclerView.id, ConstraintSet.BOTTOM, R.id.guidelineHalf, ConstraintSet.TOP)
//
//        set.applyTo(binding.main)
//
//        isExpanded = false
//    }
//
//    private fun dpToPx(dp: Int): Int {
//        return (dp * resources.displayMetrics.density).toInt()
//    }
}