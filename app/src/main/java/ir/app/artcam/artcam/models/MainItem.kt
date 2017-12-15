package ir.app.artcam.artcam.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by saeed on 12/14/17.
 */
data class MainItem(val parts: ArrayList<Part>) : Parcelable {
    constructor(source: Parcel) : this(
            source.createTypedArrayList(Part.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeTypedList(parts)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MainItem> = object : Parcelable.Creator<MainItem> {
            override fun createFromParcel(source: Parcel): MainItem = MainItem(source)
            override fun newArray(size: Int): Array<MainItem?> = arrayOfNulls(size)
        }
    }
}