package com.eremenko.dublinmap

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.*

class MapsActivityDublin : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map: GoogleMap
    private val REQUEST_LOCATION_PERMISSION = 1




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.title = "Dublin Map"

            //back button
            actionBar.setDisplayHomeAsUpEnabled(true)


        }




    }


    private fun isPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    private fun enableMyLocation() {
        if (isPermissionGranted()) {
            if (ActivityCompat.checkSelfPermission(
                            this,
                            Manifest.permission.ACCESS_FINE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                            this,
                            Manifest.permission.ACCESS_COARSE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }
            map.isMyLocationEnabled = true
        } else {
            ActivityCompat.requestPermissions(
                    this,
                    arrayOf<String>(Manifest.permission.ACCESS_FINE_LOCATION),
                    REQUEST_LOCATION_PERMISSION
            )
        }
    }

    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<String>,
            grantResults: IntArray) {
        if (requestCode == REQUEST_LOCATION_PERMISSION) {
            if (grantResults.contains(PackageManager.PERMISSION_GRANTED)) {
                enableMyLocation()
            }
        }
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
        map = googleMap

        // Add a marker in Dublin and move the camera
        val dublin = LatLng(53.350140, -6.266155)
        map.addMarker(MarkerOptions().position(dublin).title("Marker in Dublin"))
        map.moveCamera(CameraUpdateFactory.newLatLng(dublin))


      // Add a marker in Dublin and move the camera

        val dublinGreen = LatLng(53.338126, -6.259924)
        val dublinPhenix = LatLng(53.356290, -6.334203)
        val dublinSpir?? = LatLng(53.349713, -6.260088)

// Add a marker in Paris and move the camera


        val zoomLevel = 15f

        map.addMarker(MarkerOptions().position(dublinGreen).title("Marker in St.Stephen Green Park"))
        map.addMarker(MarkerOptions().position(dublinPhenix).title("Marker in Phenix Park"))
        map.addMarker(MarkerOptions().position(dublinSpir??).title("Marker in Spir??"))
        map.moveCamera(CameraUpdateFactory.newLatLng(dublinGreen))




        //  ZOOM LEVEL

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(dublinSpir??, 15f))
        map.moveCamera((CameraUpdateFactory.newLatLngZoom(dublinSpir??, zoomLevel )))


        // ADD MARKER
        map.addMarker(MarkerOptions().position(dublinSpir??).title("Marker Dublin Spir??"))


        setMapLongClick(map)
        setPoiClick(map)
        enableMyLocation()
    }

    private fun setPoiClick(map: GoogleMap) {
        //TODO("Not yet implemented")
        map.setOnPoiClickListener { poi ->
            val poiMarker = map.addMarker(
                    MarkerOptions()
                            .position(poi.latLng)
                            .title(poi.name)
            )
            poiMarker.showInfoWindow()
        }

    }



    private fun setMapLongClick(map: GoogleMap) {
        map.setOnMapClickListener { latLng ->
            val snippet = String.format(
                    Locale.getDefault(),
                    "Lat: %1$.5f, Long: %2$.5f",
                    latLng.latitude,
                    latLng.longitude
            )


            map.addMarker(
                    MarkerOptions()
                            .position(latLng)
                            .title(getString(R.string.dropped_pin))
                            .snippet(snippet)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))


            )
            // it is around here you grab and store coordinates PREFERENCES
        }


    }





  }


