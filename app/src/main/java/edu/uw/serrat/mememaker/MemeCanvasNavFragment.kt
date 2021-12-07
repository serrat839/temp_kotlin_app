package edu.uw.serrat.mememaker

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class MemeCanvasNavFragment : Fragment() {
    // TODO: check layout to figure out how to lay my stuff out.
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("LOAD THE THING", "loaded the frame.")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meme_canvas_nav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fieldFragment = MemeCanvasFragment()
        addChildFragment(fieldFragment, R.id.thebaby)
        Log.v("loaded the baby", "loaded the baby")
        // add text button
        view.findViewById<Button>(R.id.add_text).setOnClickListener {
            Log.v("Add text", "adding text")
            // todo: add view model here to control the adding of text
        }
    }
}