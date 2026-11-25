package com.example.myapplication3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class TextCustomView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val paint = Paint()

    init {
        paint.color = Color.BLACK
        paint.textSize = 50f
        paint.style = Paint.Style.FILL

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawText("Hello World", 180f, 50f, paint)
    }


}