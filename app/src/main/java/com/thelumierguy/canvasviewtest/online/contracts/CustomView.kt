package com.thelumierguy.canvasviewtest.online.contracts

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect

interface CustomView {
    var drawRect: Rect
    var padding: Int
    val heightPercent: Float
    val widthPercent: Float
    fun render(canvas: Canvas, context: Context)
}

data class ViewData(val value: String?)