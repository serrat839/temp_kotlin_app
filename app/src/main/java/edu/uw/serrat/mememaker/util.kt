package edu.uw.serrat.mememaker

import androidx.fragment.app.Fragment

fun Fragment.addChildFragment(fragment: Fragment, frameId: Int) {
    val transaction = childFragmentManager.beginTransaction()
    transaction.replace(frameId, fragment).commit()
}