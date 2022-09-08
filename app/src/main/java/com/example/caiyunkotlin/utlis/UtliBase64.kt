package com.example.caiyunkotlin.utlis

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.lang.Byte.decode
import java.util.*


/**
 * base64  转图片
 */
class UtliBase64 {

    fun stringToBitmap(string: String): Bitmap? {
        var bitmap: Bitmap? = null
        try {
            val bitmapArray: ByteArray =
                android.util. Base64.decode(string.split(",".toRegex()).toTypedArray()[1],   android.util.Base64.DEFAULT)
            bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.size)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return bitmap
    }
}