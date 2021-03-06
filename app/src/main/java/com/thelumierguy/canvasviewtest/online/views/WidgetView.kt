package com.thelumierguy.canvasviewtest.online.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import com.thelumierguy.canvasviewtest.online.contracts.CustomLayout


class WidgetView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) : View(context, attributeSet, defStyle), WidgetCallbacks {

    var customViews = listOf<CustomLayout>()

    init {
        setBackgroundColor(Color.BLACK)
    }

    fun init(initBlock: WidgetView.() -> Unit) = this.initBlock()

    fun addLayout(vararg views: CustomLayout) {
        customViews = views.map { it }
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.let { canvas ->
            customViews.forEach {
                it.render(canvas, context)
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val newHeight = customViews.map { it.height }.maxOrNull() ?: 0
        val newWidth = customViews.map { it.width }.maxOrNull() ?: 0
        setMeasuredDimension(newWidth, newHeight)
    }

    override fun redrawWidgets() {
        invalidate()
    }

    override fun getScreenWidth(): Int {
        return context.resources.displayMetrics.widthPixels
    }

    override fun getScreenHeight(): Int {
        return context.resources.displayMetrics.heightPixels
    }
}

interface WidgetCallbacks {
    fun redrawWidgets()
    fun getScreenWidth(): Int
    fun getScreenHeight(): Int
}


