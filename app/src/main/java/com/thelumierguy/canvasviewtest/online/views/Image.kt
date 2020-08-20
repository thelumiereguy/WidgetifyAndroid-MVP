package com.thelumierguy.canvasviewtest.online.views

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import com.thelumierguy.canvasviewtest.online.ViewCallbacks
import com.thelumierguy.canvasviewtest.online.contracts.CustomView

class Image(val viewCallbacks: ViewCallbacks, initBlock: Image.() -> Unit = {}) : CustomView {

    override var drawRect: Rect = Rect()
    override var heightRatio: Float = 0F
    override var widthRatio: Float = 0F
    override var value: String? = null
    override var padding: Int = 0

    var bitmapToLoad: Bitmap? = null

    init {
        apply(initBlock)
    }

    override fun render(canvas: Canvas, context: Context) {
        bitmapToLoad?.let {
            canvas.drawBitmap(
                it, null, drawRect, null
            )
        } ?: kotlin.run {
            loadImage()
        }
    }

    override fun setSizeRatio(heightRatio: Float, widthRatio: Float) {
        this.heightRatio = heightRatio
        this.widthRatio = widthRatio
    }

    override fun measureSize(): Pair<Int, Int> {
        return Pair(drawRect.width(), drawRect.height())
    }

    private fun loadImage() {
        if (drawRect.width() != 0 && drawRect.height() != 0 && value != null)
            Picasso.get().load(value).centerInside().resize(drawRect.width(), drawRect.height())
                .into(object : Target {
                    override fun onPrepareLoad(placeHolderDrawable: Drawable?) {

                    }

                    override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                    }

                    override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                        bitmapToLoad = bitmap
                        viewCallbacks.refreshView()
                    }

                })
    }

}