package com.rafaelfelipeac.replyradar.core.util

const val PAD_CHAR = '0'
const val PAD_LENGTH = 2

fun Int.toTwoDigitString(): String = toString().padStart(PAD_LENGTH, PAD_CHAR)
