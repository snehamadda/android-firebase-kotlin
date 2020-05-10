package com.example.firebaseexample.models

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
class User (
    var name: String = " ",
    var email: String = " "
)