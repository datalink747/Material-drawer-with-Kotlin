package material_design.soussi.com.material_drawer.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

/**
 * Created by Soussi on 06/11/2015.
 */
class Events :Serializable {

    // getter and setter here


    var text: String? = null
    var imageUrl: String? = null

   /* protected constructor(`in`: Parcel) {
        text = `in`.readString()
        imageUrl = `in`.readString()
    }*/

   /* override fun describeContents(): Int {
        return 0
    }*/

   /* override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(text)
        dest.writeString(imageUrl)
    }*/

    //constructeur here


    constructor() {}

    constructor(text: String, imageUrl: String) {
        this.text = text
        this.imageUrl = imageUrl
    }

   /* companion object {

        val CREATOR: Parcelable.Creator<Events> = object : Parcelable.Creator<Events> {
            override fun createFromParcel(`in`: Parcel): Events {
                return Events(`in`)
            }

            override fun newArray(size: Int): Array<Events?> {
                return arrayOfNulls(size)
            }
        }
    }*/
}
