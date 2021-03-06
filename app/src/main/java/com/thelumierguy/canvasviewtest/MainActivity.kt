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
                Column(this) {
                    addChildren(
                        Image(this@init) {
                            viewData =
                                ViewData("https://i.kym-cdn.com/entries/icons/original/000/028/021/work.jpg")
                            padding = 4
                            heightPercent = 25F
                            widthPercent = 60F
                        },
                        Image(this@init) {
                            viewData =
                                ViewData("https://www.tjtoday.org/wp-content/uploads/2020/01/unnamed-7.png")
                            padding = 4
                            heightPercent = 15F
                            widthPercent = 45F
                        },
                        Image(this@init) {
                            viewData =
                                ViewData("https://www.finetoshine.com/wp-content/uploads/2020/07/Tom-And-Jerry-Meme-Template.jpg")
                            padding = 4
                            heightPercent = 10F
                            widthPercent = 25F
                        },
                    )
                },
                Row(this) {
                    addChildren(
                        Image(this@init) {
                            viewData =
                                ViewData("https://i.kym-cdn.com/entries/icons/original/000/028/021/work.jpg")
                            padding = 4
                            heightPercent = 25F
                            widthPercent = 60F
                        },
                        Image(this@init) {
                            viewData =
                                ViewData("https://www.tjtoday.org/wp-content/uploads/2020/01/unnamed-7.png")
                            padding = 4
                            heightPercent = 15F
                            widthPercent = 40F
                        },
                    )
                },
                Stack(this) {
                    addChildren(
                        Image(this@init) {
                            viewData =
                                ViewData("https://i.kym-cdn.com/entries/icons/original/000/028/021/work.jpg")
                            padding = 24
                            heightPercent = 20F
                            widthPercent = 50F
                        },
                    )
                }
            )
        }
    }
}