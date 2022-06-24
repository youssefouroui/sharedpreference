package com.learning.sharedpreference

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var nameText: EditText
    private lateinit var ageText:EditText
    private lateinit var sf:SharedPreferences
    private lateinit var editor:SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameText=findViewById(R.id.etName)
        ageText=findViewById(R.id.etAge)
        sf=getSharedPreferences("my_sf", MODE_PRIVATE)
        editor=sf.edit()
        sf.edit().commit()


    }

    override fun onPause() {
        super.onPause()
        var name=nameText.text.toString()
        var age=ageText.text.toString().toInt()
        editor.apply{
            putString("sf_name",name)
            putInt("sf_age",age)
            commit()
        }

    }

    override fun onResume() {
        super.onResume()
        var name=sf.getString("sf_name",null)
        var age=sf.getInt("sf_age",0)
        nameText.setText(name)
        if (age!=0){
            ageText.setText(age.toString())
        }

    }
}