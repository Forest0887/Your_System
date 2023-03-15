package com.forest.yoursystem

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKit
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.directions.driving.DrivingRoute
import com.yandex.mapkit.directions.driving.DrivingSession
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.MapObject
import com.yandex.mapkit.map.MapObjectCollection
import com.yandex.mapkit.map.MapObjectTapListener
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.Error
import com.yandex.runtime.image.ImageProvider


class Map : AppCompatActivity(), DrivingSession.DrivingRouteListener {
    lateinit var mapView: MapView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("23a94b81-0b8d-4092-b650-f7335862956b")
        MapKitFactory.initialize(this)
        setContentView(R.layout.map)
        mapView = findViewById(R.id.mapview)
        mapView.map.move(CameraPosition(Point(55.994446, 92.797586), 11.0f, 0.0f, 0.0f),
        Animation(Animation.Type.SMOOTH, 1f), null)
        val mapKit: MapKit = MapKitFactory.getInstance()
        val probki = mapKit.createTrafficLayer(mapView.mapWindow)
        probki.isTrafficVisible = true

        val image = ImageProvider.fromResource(this.applicationContext, R.drawable.pin)
        val mapObjects = mapView.map.mapObjects.addCollection()
        val placeMark = mapObjects.addPlacemark(Point(55.994446, 92.797586), image)
        val placeMark2 = mapObjects.addPlacemark(Point(56.008465, 92.766513), image)
        val placeMark3 = mapObjects.addPlacemark(Point(53.723288, 91.449897), image)
        placeMark.isVisible = true
        placeMark.isDraggable = false
        placeMark2.isVisible = true
        placeMark2.isDraggable = false
        placeMark3.isVisible = true
        placeMark3.isDraggable = false

        mapObjects.addTapListener()

        placeMark.addTapListener{ _, _ ->
            // Обработка нажатия на маркер
            val position = placeMark.geometry
            val message = "\nLatitude: ${position.latitude}, Longitude: ${position.longitude}"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            Toast.makeText(getApplicationContext() , "Its a toast!", Toast.LENGTH_SHORT).show()
            true // Возвращаем true, чтобы остановить всплывающее окно кластера
        }


//        placeMark2.addTapListener{ _, _ ->
//            // Обработка нажатия на маркер
//            val position = placeMark.geometry
//            val message = "Общежитие\nLatitude: ${position.latitude}, Longitude: ${position.longitude}"
//            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//            print(123)
//            true // Возвращаем true, чтобы остановить всплывающее окно кластера
//        }
//
//        placeMark3.addTapListener{ _, _ ->
//            // Обработка нажатия на маркер
//            val position = placeMark.geometry
//            val message = "Дом Родной\nLatitude: ${position.latitude}, Longitude: ${position.longitude}"
//            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//            print(123)
//            true // Возвращаем true, чтобы остановить всплывающее окно кластера
//        }



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

    override fun onDrivingRoutes(p0: MutableList<DrivingRoute>) {
        TODO("Not yet implemented")
    }

    override fun onDrivingRoutesError(p0: Error) {
        TODO("Not yet implemented")
    }
}

private fun MapObjectCollection.addTapListener() {
    println("НАЖАЛИ")
}
