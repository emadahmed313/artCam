package ir.app.artcam.artcam.models

import android.os.Parcel
import android.os.Parcelable
import java.util.*


data class Part(val resID: Int, val title: String, val subtitle: Array<String>, val videoUrl: String) : Parcelable {
    constructor(source: Parcel) : this(
            source.readInt(),
            source.readString(),
            source.createStringArray(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(resID)
        writeString(title)
        writeStringArray(subtitle)
        writeString(videoUrl)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Part

        if (resID != other.resID) return false
        if (title != other.title) return false
        if (!Arrays.equals(subtitle, other.subtitle)) return false
        if (videoUrl != other.videoUrl) return false

        return true
    }

    override fun hashCode(): Int {
        var result = resID
        result = 31 * result + title.hashCode()
        result = 31 * result + Arrays.hashCode(subtitle)
        result = 31 * result + videoUrl.hashCode()
        return result
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Part> = object : Parcelable.Creator<Part> {
            override fun createFromParcel(source: Parcel): Part = Part(source)
            override fun newArray(size: Int): Array<Part?> = arrayOfNulls(size)
        }
    }
}