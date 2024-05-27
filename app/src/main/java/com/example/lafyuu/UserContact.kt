package com.example.lafyuu

import android.provider.BaseColumns

object UserContract {
    /* Inner class that defines the table contents */
    class UserEntry : BaseColumns {
        companion object {
            const val TABLE_NAME = "users"
            const val COLUMN_NAME = "name"
            const val COLUMN_EMAIL = "email"
            const val COLUMN_PASSWORD = "password"
        }
    }
}
