package com.thelumierguy.canvasviewtest.online.widgets

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import com.thelumierguy.canvasviewtest.online.views.WidgetCallbacks
import com.thelumierguy.canvasviewtest.online.contracts.CustomView
import com.thelumierguy.canvasviewtest.online.contracts.ViewData

open class Image(
    val imageData: ViewData,
    val widgetCallbacks: WidgetCallbacks,
    initBlock: Image.() -> Unit
) : CustomView {

    override var drawRect: Rect = Rect()
    override var heightPercent: Float = 0F
    override var widthPercent: Float = 0F

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

    private fun loadImage() {
        if (drawRect.width() != 0 && drawRect.height() != 0)
            when (imageData) {
                is ViewData.Url -> {
                    loadOnline(imageData)
                }
            }
    }

    private fun loadOnline(imageData: ViewData.Url) {
        Picasso.get().load(imageData.url).centerInside()
            .resize(drawRect.width(), drawRect.height())
            .into(object : Target {
                override fun onPrepareLoad(placeHolderDrawable: Drawable?) {

                }

                override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                }

                override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                    bitmapToLoad = bitmap
                    widgetCallbacks.redrawWidgets()
                }

            })
    }

}