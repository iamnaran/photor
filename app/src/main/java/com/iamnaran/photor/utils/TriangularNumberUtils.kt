package com.iamnaran.photor.utils

import android.net.Uri

class TriangularNumberUtils {

    companion object {
        @JvmStatic
        fun generateTriangularSequence(
            size: Int,
            uris: List<@JvmSuppressWildcards Uri>
        ): MutableList<Uri> {
            val result = mutableListOf<Uri>()
            for (i in 0..size) {
                if (isTriangularNumber(i)) {
                    result.add(uris[0])
                } else {
                    result.add(uris[1])
                }
            }
            return result
        }

        @JvmStatic
        fun isTriangularNumber(number: Int): Boolean {
            if (number == 0) {
                return false
            }
            var sum = 0
            var n = 1
            while (sum < number) {
                sum += n
                n++
            }
            return sum == number
        }
    }
}