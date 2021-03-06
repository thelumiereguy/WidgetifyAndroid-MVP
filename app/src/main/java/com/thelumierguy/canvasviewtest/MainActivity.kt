package com.thelumierguy.canvasviewtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thelumierguy.canvasviewtest.databinding.ActivityMainBinding
import com.thelumierguy.canvasviewtest.online.contracts.ViewData
import com.thelumierguy.canvasviewtest.online.widgets.Column
import com.thelumierguy.canvasviewtest.online.widgets.Image
import com.thelumierguy.canvasviewtest.online.widgets.Row
import com.thelumierguy.canvasviewtest.online.widgets.Stack

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.widgetView.init {
            addLayout(
                Stack(this) {
                    addChildren(
                        Image(
                            imageData = ViewData.Url("https://tinyurl.com/2zjbzkb5"),
                            this@init
                        ) {
                            padding = 4
                            heightPercent = 45F
                            widthPercent = 90F
                        },
                        Image(
                            imageData = ViewData.Url("https://tinyurl.com/2c6kjxxv"),
                            this@init
                        ) {
                            padding = 4
                            heightPercent = 20F
                            widthPercent = 55F
                        },
                        Image(
                            imageData = ViewData.Url("https://tinyurl.com/5xe4cxrv"),
                            this@init
                        ) {
                            padding = 4
                            heightPercent = 10F
                            widthPercent = 35F
                        },
                    )
                }
            )
        }
    }
}