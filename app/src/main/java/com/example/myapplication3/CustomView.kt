package com.example.myapplication3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import kotlin.math.atan2


class CustomView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val paint = Paint()
    private val paintC = Paint()
    private val colors = listOf(
        Color.RED, Color.rgb(255, 165, 0), Color.YELLOW, Color.GREEN, Color.CYAN,
        Color.BLUE, Color.MAGENTA
    )
    private val startAngle = 0f
    private val sweepAngle = 360f / colors.size

    private val BASE_ROTATION_DEGREES = 3600f
    private val DURATION = 3000L


//    init {
//        paint.style = Paint.Style.STROKE
//        paint.color = Color.GRAY
//        paint.strokeWidth = 5f
//        paintC.style = Paint.Style.FILL
//        paintC.color = Color.RED
//
//    }


    override fun onDraw(canvas: Canvas) {
        Log.d("!!!", "Рисуем холст")
        super.onDraw(canvas)
        drawCircleCol(canvas)

    }

    private fun drawCircleCol(canvas: Canvas) {
        Log.d("!!!", "Рисуем цвета  круга по секторам ")
        val centerX = width / 2f
        val centerY = height / 2f
        val radius = width.coerceAtMost(height) / 2f
        for (i in colors.indices) {
            paintC.color = colors[i]
            canvas.drawArc(
                centerX - radius,
                centerY - radius,
                centerX + radius,
                centerY + radius,
                startAngle + i * sweepAngle,
                sweepAngle,
                true,
                paintC

            )
        }


    }

    fun spin() {
        Log.d("!!!", "Нажали кнопку spin, барабан начал вращаться")
        val deg = rotation + BASE_ROTATION_DEGREES + (Math.random().toFloat() * 360f)
        Log.d(
            "!!!",
            "угол, до которого крутится анимация, а потом останавливается(рандом), т.е сколько вращений в градусах = $deg"
        )
        Log.d("!!!", "Запущена анимация поворота барабана до значения $deg за $DURATION милисек")
        animate().rotation(deg).setDuration(DURATION)
            .setInterpolator(AccelerateDecelerateInterpolator())
        getCurrentSector()


    }

    fun reset() {
        animate().cancel()
        rotation = 0f
        Log.d(
            "!!!",
            "Нажали кнопку reset. Очищаем барабан, вращение на начале = $rotation"
        )
    }

    fun getCurrentSector(): Int {
        val ostatok = rotation % 360f
        Log.d("!!!", "Секторы двигаются на $ostatok градусов")
        val currentSectorAngle = (360f - ostatok)
        Log.d(
            "!!!",
            "Angle(угол), в котором должен остановится барабан : $currentSectorAngle"
        )
        val index = (currentSectorAngle / (360f / colors.size)).toInt()
        Log.d(
            "!!!",
            "Номер : $index - индекс цвета, в котором лежит найденный угол $currentSectorAngle"
        )
        return index
//        val centerX = width / 2f
//        val centerY = height / 2f
//        val angle = (Math.toDegrees(
//            atan2(
//                y = y - centerY,
//                x = x - centerX
//            ).toDouble()
//        ) + 360) % 360
//        val index = (angle / (360 / colors.size)).toInt()
//        Log.d(
//            "!!!",
//            "Angle(угол), в котором должен остановится барабан : $angle, но он определяет не то"
//        )
//        Log.d("!!!", "Номер : $index - индекс цвета, в котором лежит найденный угол $angle")
    }


}
