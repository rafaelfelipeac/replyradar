package com.rafaelfelipeac.replyradar.core.common.strings

import com.rafaelfelipeac.replyradar.core.common.language.AppLanguage
import com.rafaelfelipeac.replyradar.core.common.language.AppLanguage.ENGLISH
import com.rafaelfelipeac.replyradar.core.common.language.AppLanguage.PORTUGUESE
import com.rafaelfelipeac.replyradar.core.common.language.AppLanguage.SYSTEM

object StringsProvider {
    private val english = StringsEn
    private val portuguese = StringsPt

    var current: Strings = english

    fun setLanguage(language: AppLanguage) {
        current = get(language)
    }

    fun get(language: AppLanguage): Strings {
        return when (language) {
            ENGLISH -> english
            PORTUGUESE -> portuguese
            SYSTEM -> english
        }
    }
}
