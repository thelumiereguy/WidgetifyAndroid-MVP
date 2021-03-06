package com.thelumierguy.canvasviewtest.online.contracts

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.view.View

interface CustomView {
    var drawRect: Rect
    var padding: Int
    val heightPercent: Float
    val widthPercent: Float
    fun render(canvas: Canvas, context: Context)
}

sealed class ViewData {
    data class Url(val url: String) : ViewData()
}