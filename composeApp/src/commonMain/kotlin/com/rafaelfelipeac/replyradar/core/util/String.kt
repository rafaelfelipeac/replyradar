package com.rafaelfelipeac.replyradar.core.util

fun format(template: String, vararg args: String): String {
    var result = template

    args.forEachIndexed { index, value ->
        result = result.replace("%${index + 1}", value)
    }

    return result
}
