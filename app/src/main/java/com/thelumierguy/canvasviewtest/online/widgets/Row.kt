package com.thelumierguy.canvasviewtest.online.widgets

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import com.thelumierguy.canvasviewtest.online.views.WidgetCallbacks
import com.thelumierguy.canvasviewtest.online.contracts.CustomLayout
import com.thelumierguy.canvasviewtest.online.contracts.CustomView
import kotlin.math.roundToInt

open class Row(private val widgetCallbacks: WidgetCallbacks, initBlock: Row.() -> Unit) : CustomLayout {

    override var widthFlex: Int = 0

    override var heightFlex: Int = 0

    override var width: Int = 0

    override var height: Int = 0

    override val childrenViews: MutableList<CustomView> = mutableListOf()

    override var drawRect: Rect = Rect()

    init {
        apply(initBlock)
    }

    override fun addChildren(vararg view: CustomView) {
        childrenViews.addAll(view)
        layoutViews()
    }

    override fun render(canvas: Canvas, context: Context) {
        childrenViews.forEach {
            it.render(canvas, context)
        }
    }

    override fun layoutViews() {
        val screenWidth = widgetCallbacks.getScreenWidth()
        val screenHeight = widgetCallbacks.getScreenHeight()
        childrenViews.forEach { child ->
            val childWidth = ((child.widthPercent / 100) * screenWidth).roundToInt()
            val childHeight = ((child.heightPercent / 100) * screenHeight).roundToInt()
            child.drawRect = getChildRect(
                childWidth,
                childHeight,
                child
            )
        }
        setHeightWithChildren()
    }

    private fun setHeightWithChildren() {
        height = childrenViews.map { it.drawRect.height() + (it.padding * 2) }.max() ?: 0
    }

    private fun getChildRect(childWidth: Int, childHeight: Int, child: CustomView): Rect {
        val drawRect = Rect(
            width + child.padding,
            child.padding,
            width + childWidth,
            childHeight
        )
        width += childWidth + child.padding
        return drawRect
    }
}
