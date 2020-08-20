package com.thelumierguy.canvasviewtest.online

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.util.TypedValue
import com.thelumierguy.canvasviewtest.online.contracts.CustomLayout
import com.thelumierguy.canvasviewtest.online.contracts.CustomView
import kotlin.math.roundToInt

enum class ORIENTATION {
    HORIZONTAL,
    VERTICAL
}

fun Int.toDp(context: Context): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        context.resources.displayMetrics
    );
}


interface ViewCallbacks {
    fun refreshView()
    fun getScreenWidth(): Int
    fun getScreenHeight(): Int
}