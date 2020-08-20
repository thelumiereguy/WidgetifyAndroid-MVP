package com.thelumierguy.canvasviewtest.online.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import com.thelumierguy.canvasviewtest.online.ViewCallbacks
import com.thelumierguy.canvasviewtest.online.contracts.CustomLayout
import com.thelumierguy.canvasviewtest.online.contracts.CustomView
import kotlin.math.roundToInt

class Stack(private val viewCallbacks: ViewCallbacks, initBlock: Stack.() -> Unit) : CustomLayout {

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

    override fun renderChildren(canvas: Canvas, context: Context) {
        childrenViews.forEach {
            it.render(canvas, context)
        }
    }

    override fun layoutViews() {
        val screenWidth = viewCallbacks.getScreenWidth()
        val screenHeight = viewCallbacks.getScreenHeight()
        childrenViews.forEach { child ->
            val childWidth = ((child.widthRatio / 100) * screenWidth).roundToInt()
            val childHeight = ((child.heightRatio / 100) * screenHeight).roundToInt()
            child.drawRect = Rect(
                child.padding,
                child.padding,
                childWidth+ child.padding,
                childHeight+ child.padding
            )
        }
        setHeightWithChildren()
    }

    private fun setHeightWithChildren() {
        height = childrenViews.map { it.drawRect.height() + (it.padding * 2) }.max() ?: 0
    }

}
