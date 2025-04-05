package com.rafaelfelipeac.replyradar.core.common.strings

import com.rafaelfelipeac.replyradar.core.common.language.AppLanguage

object StringsProvider {
    private val english = StringsEn
    private val portuguese = StringsPt

    var current: Strings = english

    fun setLanguage(language: AppLanguage) {
        current = get(language)
    }

    fun get(language: AppLanguage): Strings {
        return when (language) {
            AppLanguage.ENGLISH -> english
            AppLanguage.PORTUGUESE -> portuguese
            AppLanguage.SYSTEM -> english
        }
    }
}
