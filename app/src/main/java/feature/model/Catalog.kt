package feature.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize


@Parcelize
data class Catalog(
    var name : String,
    @DrawableRes
    var image: Int,
    var foodDesc: String,
    val formattedPrice: String,
    val addres :String,
    val mapURL : String
): Parcelable
