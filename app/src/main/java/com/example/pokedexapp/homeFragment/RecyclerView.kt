package com.example.pokedexapp.homeFragment

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView

class RecyclerView (view: RecyclerView, listener:OnItemClickListener) : RecyclerView.OnItemTouchListener {

    var gestureDetector: GestureDetector

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
        fun onItemLongClick(view: View, position: Int)
    }

    init {
        gestureDetector =
            GestureDetector(view.context, object : GestureDetector.SimpleOnGestureListener() {
                override fun onSingleTapUp(e: MotionEvent): Boolean {
                    super.onSingleTapUp(e)
                    val childView = view.findChildViewUnder(e.x, e.y)
                    if (childView != null) {
                        listener.onItemClick(childView, view.getChildAdapterPosition(childView))
                    }
                    return true
                }

                override fun onLongPress(e: MotionEvent) {
                    super.onLongPress(e)
                    val childView = view.findChildViewUnder(e.x, e.y)
                    if (childView != null) {
                        listener.onItemLongClick(childView, view.getChildAdapterPosition(childView))
                    }
                }
            })
    }

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        gestureDetector.onTouchEvent(e)
        return false
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
    }
}