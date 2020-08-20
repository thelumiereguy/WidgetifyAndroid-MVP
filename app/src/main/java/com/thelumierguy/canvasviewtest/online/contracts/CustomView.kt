package com.thelumierguy.canvasviewtest.online.contracts

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect

interface CustomView {
    var value: String?
    fun render(canvas: Canvas, context: Context)
    fun setSizeRatio(heightRatio: Float, widthRatio: Float)
    fun measureSize(): Pair<Int, Int>
    var padding: Int
    var drawRect: Rect
    val heightRatio: Float
    val widthRatio: Float
}