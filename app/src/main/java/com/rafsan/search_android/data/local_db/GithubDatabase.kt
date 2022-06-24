package com.rafsan.search_android.data.local_db

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [GithubData::class,],version = 1)
abstract class GithubDatabase : RoomDatabase() {
    abstract fun githubDao() : GitHubDao
}