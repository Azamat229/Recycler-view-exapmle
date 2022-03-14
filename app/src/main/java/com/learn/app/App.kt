package com.learn.app

import android.app.Application
import com.learn.app.models.UsersService

class App:Application() {
    val usersService = UsersService()

}