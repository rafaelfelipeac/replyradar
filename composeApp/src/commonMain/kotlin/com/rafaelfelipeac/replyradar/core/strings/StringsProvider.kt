package com.rafaelfelipeac.replyradar.core.strings

import com.rafaelfelipeac.replyradar.core.language.AppLanguage
import com.rafaelfelipeac.replyradar.core.language.AppLanguage.ARABIC
import com.rafaelfelipeac.replyradar.core.language.AppLanguage.ENGLISH
import com.rafaelfelipeac.replyradar.core.language.AppLanguage.FRENCH
import com.rafaelfelipeac.replyradar.core.language.AppLanguage.GERMAN
import com.rafaelfelipeac.replyradar.core.language.AppLanguage.HINDI
import com.rafaelfelipeac.replyradar.core.language.AppLanguage.ITALIAN
import com.rafaelfelipeac.replyradar.core.language.AppLanguage.JAPANESE
import com.rafaelfelipeac.replyradar.core.language.AppLanguage.LATVIAN
import com.rafaelfelipeac.replyradar.core.language.AppLanguage.PORTUGUESE
import com.rafaelfelipeac.replyradar.core.language.AppLanguage.SPANISH
import com.rafaelfelipeac.replyradar.core.language.AppLanguage.SYSTEM

object StringsProvider {
    private val english = StringsEn
    private val portuguese = StringsPt
    private val german = StringsDe
    private val french = StringsFr
    private val spanish = StringsEs
    private val latvian = StringsLv
    private val italian = StringsIt
    private val arabic = StringsAr
    private val hindi = StringsHi
    private val japanese = StringsJa

    var current: Strings = english

    fun setLanguage(language: AppLanguage) {
        current = get(language)
    }

    fun get(language: AppLanguage): Strings {
        return when (language) {
            ENGLISH -> english
            PORTUGUESE -> portuguese
            GERMAN -> german
            FRENCH -> french
            SPANISH -> spanish
            LATVIAN -> latvian
            ITALIAN -> italian
            ARABIC -> arabic
            HINDI -> hindi
            JAPANESE -> japanese
            SYSTEM -> english
        }
    }
}
