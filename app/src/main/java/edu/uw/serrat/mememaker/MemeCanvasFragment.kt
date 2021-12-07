package edu.uw.serrat.mememaker

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import kotlin.math.roundToInt

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


class MemeCanvasFragment : Fragment() {

    private lateinit var img: ImageView
    private lateinit var rootLayout: View
    private var _xDelta: Int = 0
    private var _yDelta: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_meme_canvas, container, false)
        rootLayout = rootView
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        img = rootLayout.findViewById(R.id.meme)
        val layoutParams = RelativeLayout.LayoutParams(150, 150)
        img.layoutParams = layoutParams
        // todo: the warning here is for accessibility, be sure to double check this later
        img.setOnTouchListener(ChoiceTouchListener())
        // todo: add viewmodel stuff to listen for more text added.
    }

    inner class ChoiceTouchListener: View.OnTouchListener {
        override fun onTouch(v: View?, event: MotionEvent?): Boolean {
            val X = event!!.rawX
            val Y = event!!.rawY
            if (event.action == MotionEvent.ACTION_DOWN) {
                var lParams: RelativeLayout.LayoutParams = v?.layoutParams as RelativeLayout.LayoutParams
                // todo: check that this works fine, may need to change deltas to floats...
                _xDelta = (X - lParams.leftMargin).roundToInt()
                _yDelta = (Y - lParams.topMargin).roundToInt()
            } else if (event.action == MotionEvent.ACTION_MOVE) {
                var layoutParams = v?.layoutParams as RelativeLayout.LayoutParams
                // todo: check that this works fine, may need to change deltas to floats...
                layoutParams.leftMargin = (X - _xDelta).toInt()
                layoutParams.topMargin = (Y - _yDelta).toInt()
                layoutParams.rightMargin = -250
                layoutParams.bottomMargin = -250
                v.layoutParams = layoutParams
            }
            rootLayout.invalidate()
            return true
        }
    }

}