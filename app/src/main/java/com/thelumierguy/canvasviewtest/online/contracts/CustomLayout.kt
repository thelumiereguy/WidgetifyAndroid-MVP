package com.thelumierguy.canvasviewtest.online.contracts

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect

interface CustomLayout {
    var drawRect: Rect
    var widthFlex: Int
    var heightFlex: Int
    var width: Int
    var height: Int
    fun layoutViews()
    val childrenViews: MutableList<CustomView>
    fun addChildren(vararg view: CustomView)
    fun renderChildren(canvas: Canvas, context: Context)
    fun setFlexSize(parentSize: Int)
}