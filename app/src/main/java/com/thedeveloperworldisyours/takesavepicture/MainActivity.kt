package com.thedeveloperworldisyours.takesavepicture

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.thedeveloperworldisyours.takesavepicture.photo.CameraActivity
import com.thedeveloperworldisyours.takesavepicture.photo.PIC_FILE_NAME
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_button.setOnClickListener {
            val intent = Intent(this, CameraActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == REQUEST_CODE) {
            if (data!!.hasExtra("file")) {
                Toast.makeText(
                    this, data.extras!!.getString("file"),
                    Toast.LENGTH_SHORT
                ).show()
                show(data.extras!!.getString("file"))
            }
        }
    }

    private fun show(pictureID:String) {
        val imgFile = File(getExternalFilesDir(null), "$pictureID$PIC_FILE_NAME")

        if (imgFile.exists()) {

            val myBitmap = BitmapFactory.decodeFile(imgFile.absolutePath)


            main_imageView.setImageBitmap(myBitmap)

        }
    }


    companion object {
        const val REQUEST_CODE = 10}
}
