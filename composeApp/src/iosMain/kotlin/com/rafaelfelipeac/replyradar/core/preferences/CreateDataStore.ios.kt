package com.rafaelfelipeac.replyradar.core.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

@Suppress("FunctionNaming")
@OptIn(ExperimentalForeignApi::class)
fun CreateDataStore(): DataStore<Preferences> {
    return CreateDataStore {
        val directory = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null

        )
        requireNotNull(directory).path() + "/$DATA_STORE_FILE_NAME"
    }
}
