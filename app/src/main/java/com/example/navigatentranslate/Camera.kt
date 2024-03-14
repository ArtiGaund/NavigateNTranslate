package com.example.navigatentranslate

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.github.dhaval2404.imagepicker.ImagePicker


/**
 * A simple [Fragment] subclass.
 * Use the [Camera.newInstance] factory method to
 * create an instance of this fragment.
 */
class Camera : Fragment() {





    //define the button and imageview type variable
    private lateinit var cameraOpenId: Button
    lateinit var clickImageId: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_camera, container, false)
        //by id we can get each component which id is assigned in XML file
        //get buttons and imageView
        cameraOpenId = view.findViewById(R.id.button_camera)
        clickImageId = view.findViewById(R.id.click_image)

        //camera_open button is for open the camera and add the setOnClickListener
        //in this button
        cameraOpenId.setOnClickListener { v: View? ->


            ImagePicker.with(this)
                .compress(512)            //Final image size will be less than 1 MB(Optional)
                .maxResultSize(
                    1080,
                    1080
                )    //Final image resolution will be less than 1080 x 1080(Optional)
                .start()
        }
        return view
    }

    //this method will help to retrieve the image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        clickImageId.setImageURI(data?.data)
        }
    }
