package com.wordpress.safbk.googlemapwithcustomemarker

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.drawable.toDrawable
import androidx.core.graphics.drawable.toIcon

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.wordpress.safbk.googlemapwithcustomemarker.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
//        val sydney = LatLng(-34.0, 151.0)
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        val pakistan = LatLng(30.3753, 69.3451)
        mMap.addMarker(
            MarkerOptions()
                .position(pakistan)
                .title("Pakistan")
                .icon(BitmapDescriptorFactory.defaultMarker(100.0f))
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pakistan))


        val iran = LatLng(32.4279, 53.6880)
        mMap.addMarker(
            MarkerOptions()
                .position(iran)
                .title("Iran")
                .snippet("Iran Islamic Country")
                .flat(true)
                .draggable(true)
                .icon(BitmapDescriptorFactory.defaultMarker(110.0f))
        )

        val melbourneLocation = LatLng(-37.813, 144.962)
        mMap.addMarker(
            MarkerOptions()
                .position(melbourneLocation)
                .title("Melbourne")
                .snippet("Population: 4,137,400")
                .icon(BitmapDescriptorFactory.defaultMarker(50.2F))

        )

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.home_icon)

        val india = LatLng(32.4279, 53.6880)
        mMap.addMarker(
            MarkerOptions()
                .position(india)
                .title("India")
                .icon(BitmapDescriptorFactory
                    .fromBitmap(bitmap))
        )
        }


}