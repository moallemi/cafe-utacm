package com.workshop.sample

import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import java.io.File

class FilesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_files)

        findViewById<View>(R.id.write).setOnClickListener {
            val file1 = File(filesDir, "myfile.txt")
            file1.writeText("This is my text")

            val file2 = File(cacheDir, "myfile2.txt")
            file2.writeText("This is my text")

            val file3 = File(getExternalFilesDir("My Folder"), "myfile3.txt")
            file3.writeText("This is my text")

            //TODO must request runtime permission for writing to external storage

            val file4 = File(Environment.getExternalStoragePublicDirectory(""), "myfile4.txt")
            file4.writeText("This is my text")
        }
        findViewById<View>(R.id.read).setOnClickListener {
            val file = File(filesDir, "myfile.txt")
            Toast.makeText(this, file.readText(), Toast.LENGTH_LONG).show()
        }
    }
}
