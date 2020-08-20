package com.thelumierguy.canvasviewtest.online.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import com.thelumierguy.canvasviewtest.online.ViewCallbacks
import com.thelumierguy.canvasviewtest.online.contracts.CustomLayout
import com.thelumierguy.canvasviewtest.online.contracts.CustomView
import kotlin.math.roundToInt

class Row(private val viewCallbacks: ViewCallbacks, initBlock: Row.() -> Unit) : CustomLayout {

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
    }

    override fun renderChildren(canvas: Canvas, context: Context) {
        childrenViews.forEach {
            it.render(canvas, context)
        }
    }

    override fun setFlexSize(parentSize: Int) {
        val screenWidth = viewCallbacks.getScreenWidth()
        val screenHeight = viewCallbacks.getScreenHeight()
        width = (widthFlex / parentSize) * screenWidth
        height = (heightFlex / parentSize) * screenHeight
        drawRect = Rect(
            0,
            0,
            width,
            height
        )
        setHeightWithChildren()
        layoutViews()
    }

    override fun layoutViews() {
        val screenWidth = drawRect.width()
        val screenHeight = drawRect.height()
        childrenViews.forEach { child ->
            val childWidth = ((child.widthRatio / 100) * screenWidth).roundToInt()
            val childHeight = ((child.heightRatio / 100) * screenHeight).roundToInt()
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
