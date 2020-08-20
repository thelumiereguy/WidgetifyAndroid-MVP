package com.thelumierguy.canvasviewtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thelumierguy.canvasviewtest.online.OnlineMemberItemView
import com.thelumierguy.canvasviewtest.online.views.Column
import com.thelumierguy.canvasviewtest.online.views.Image
import com.thelumierguy.canvasviewtest.online.views.Row
import com.thelumierguy.canvasviewtest.online.views.Stack

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<OnlineMemberItemView>(R.id.canvas_View).init {
            addLayout(
                Column(this) {
                    addChildren(
                        Image(this@init) {
                            value =
                                "https://killerattitudestatus.in/wp-content/uploads/2019/12/gud-night-images.jpg"
                            padding = 12
                            setSizeRatio(20F, 45F)
                        },
                        Image(this@init) {
                            value =
                                "https://cdn.pixabay.com/photo/2016/11/29/05/45/astronomy-1867616__340.jpg"
                            padding = 12
                            setSizeRatio(15F, 35F)
                        },
                        Image(this@init) {
                            value = "https://i.redd.it/ycl02riejmi41.jpg"
                            padding = 12
                            setSizeRatio(10F, 20F)
                        }
                    )
                }

            )
        }
    }
}