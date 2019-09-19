package com.workshop.sample.kotlin

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class Student2(
    var name: String,
    var family: String,
    var avg: Int
) : Serializable

data class Student3(
    var name: String,
    var family: String,
    var avg: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(family)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Student3> {
        override fun createFromParcel(parcel: Parcel): Student3 {
            return Student3(parcel)
        }

        override fun newArray(size: Int): Array<Student3?> {
            return arrayOfNulls(size)
        }
    }
}