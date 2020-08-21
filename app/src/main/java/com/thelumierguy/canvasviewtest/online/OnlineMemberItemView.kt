package com.thelumierguy.canvasviewtest.online

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import com.thelumierguy.canvasviewtest.online.contracts.CustomLayout


class OnlineMemberItemView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) : View(context, attributeSet, defStyle), ViewCallbacks {

    var customViews = listOf<CustomLayout>()

    init {
        setBackgroundColor(Color.BLACK)
    }

    fun init(initBlock: OnlineMemberItemView.() -> Unit) = this.initBlock()

    fun addLayout(vararg views: CustomLayout) {
        customViews = views.map { it }
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.let { canvas ->
            customViews.forEach {
                it.renderChildren(canvas, context)
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val newHeight = customViews.map { it.height }.max() ?: 0
        setMeasuredDimension(0, newHeight)
    }

    override fun refreshView() {
        invalidate()
    }

    override fun getScreenWidth(): Int {
        return context.resources.displayMetrics.widthPixels
    }

    override fun getScreenHeight(): Int {
        return context.resources.displayMetrics.heightPixels
    }
}

interface ViewCallbacks {
    fun refreshView()
    fun getScreenWidth(): Int
    fun getScreenHeight(): Int
}


