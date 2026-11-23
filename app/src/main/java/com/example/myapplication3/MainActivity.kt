package com.example.myapplication3

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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
class MainActivity : AppCompatActivity() {

    private lateinit var spinBtn: Button
    private lateinit var customView: CustomView
    private lateinit var resBtn: Button

    private lateinit var tv : TextCustomView


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
        resBtn = findViewById<Button>(R.id.resBtn)
        resBtn.setOnClickListener { customView.reset() }
        tv = findViewById<TextCustomView>(R.id.tv)




    }
}