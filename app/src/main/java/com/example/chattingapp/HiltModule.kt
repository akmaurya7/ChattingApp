package com.example.chattingapp

import android.app.Application
import android.content.Context
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.messaging
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.storage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class HiltModule {
    @Provides
    fun provideAuthentication():FirebaseAuth = Firebase.auth

    @Provides
    fun provideFirestore (): FirebaseFirestore = Firebase.firestore

    @Provides
    fun provideStorage (): FirebaseStorage = Firebase.storage

    @Provides
    fun provideFirebaseMessaging (): FirebaseMessaging = Firebase.messaging

    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

}