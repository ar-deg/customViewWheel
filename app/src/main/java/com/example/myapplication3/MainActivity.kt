package com.example.myapplication3

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide


/*
Создать Custom View - Барабан, состоящий из цветов радуги. Каждый цвет означает либо картинку,
либо текст. При нажатии на барабан или на кнорку где-нибудь рядом, он начинает вращаться и останавливается
рандомно каждый раз. Когда барабан останавливается на определении цветов:
красный - текст
оранжевый - картинка
желтый - текст
зеденый - картинка
голубой - текст
синий - картинка
фиолетовый - текст

Если цвет был картинкой - то грузим картинку из сервиса и показываем ее в определенном поле
если цвет был текстом - то РИСУЕМ текст с помощью Custom View и показываем его в определенном поле
Также должна быть кнопка Reset, которая чистит экран от картинки и текстов

-создать барабан
   -у барабана сделать 7 делений, указать в них цвета +
   -цвета будут лежать в массиве цветов +
   -к цвету еще надо прикрутить локигу на картинку или текст
-создать  2 кнопки рядом с барабаном+ (spin/reset)
     -написать работу кнопок
-создать стрелку на барабане/у барабана
-барабан должен крутиться(рандомно) и останавливаться
 */
class MainActivity : AppCompatActivity(), CustomView.Listener {

    private lateinit var spinBtn: Button
    private lateinit var customView: CustomView
    private lateinit var resBtn: Button

    private lateinit var tv: TextCustomView
    private lateinit var iv: ImageView

    val objects = listOf("текст", "картинка", "текст", "картинка", "текст", "картинка", "текст")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        spinBtn = findViewById<Button>(R.id.spinBtn)
        customView = findViewById<CustomView>(R.id.customView)
        spinBtn.setOnClickListener { customView.spin() }
        customView.listener = this

        tv = findViewById<TextCustomView>(R.id.tv)
        iv = findViewById<ImageView>(R.id.iv)

        tv.visibility = View.GONE
        iv.visibility = View.GONE//VISIBLE


        Glide.with(this)
            .load("https://cataas.com/cat/cute/says/Meow")
            .into(iv)

        resBtn = findViewById<Button>(R.id.resBtn)
        resBtn.setOnClickListener {
            tv.visibility = View.GONE
            iv.visibility = View.GONE
        }
    }

    override fun onClick(index: Int) {
        if (objects[index] == "картинка") {
            tv.visibility = View.GONE
            iv.visibility = View.VISIBLE
        } else {
            tv.visibility = View.VISIBLE
            iv.visibility = View.GONE
        }

    }
}