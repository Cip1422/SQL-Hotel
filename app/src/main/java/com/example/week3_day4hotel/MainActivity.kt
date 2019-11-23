package com.example.week3_day4hotel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RoomAdaptor.RoomAdaptorDelegate {


    private var roomList = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        add_Guest.setOnClickListener {
            intent = Intent(this, add_guests::class.java)
            startActivity(intent)
        }




        roomList.add("Pac Man themed room")
        roomList.add("James Bond themed room")
        roomList.add("Gundam themed room")


        displayUsers()

    }

    private fun displayUsers() {

        val myBaseAdapter = RoomAdaptor(roomList, this)
        room_list.adapter = myBaseAdapter
    }


    override fun getImage(guestPosition: Int) {
        if(guestPosition == 0){

            Glide.with(this)
                .load(getString(R.string.pac_room))
                .into(hotel_image)


        }
        else if (guestPosition == 1){
            Glide.with(this)
                .load(getString(R.string.bond_room))
                .into(hotel_image)

        }

        else{
                Glide.with(this)
                    .load(getString(R.string.gundam_room))
                    .into(hotel_image)

        }

    }

}



