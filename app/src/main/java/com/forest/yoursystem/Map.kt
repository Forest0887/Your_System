package com.forest.yoursystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView

class Map : AppCompatActivity() {
    lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("23a94b81-0b8d-4092-b650-f7335862956b")
        MapKitFactory.initialize(this)
        setContentView(R.layout.map)
        mapView = findViewById(R.id.mapview)
        mapView.map.move(CameraPosition(Point(55.994446, 92.797586), 11.0f, 0.0f, 0.0f),
        Animation(Animation.Type.SMOOTH, 300f), null)


        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            val startNewActivity = Intent(this,  MainMenu::class.java)
            startActivity(startNewActivity)
        }
    }

    override    fun onStart() {
        mapView.onStart()
        MapKitFactory.getInstance().onStart()
        super.onStart()
    }

    override fun onStop() {
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop    ()
    }
}