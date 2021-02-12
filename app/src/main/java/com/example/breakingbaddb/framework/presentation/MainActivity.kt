package com.example.breakingbaddb.framework.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.breakingbaddb.R
import com.example.breakingbaddb.business.network.CharacterService
import com.example.breakingbaddb.business.network.model.CharacterDto
import com.example.breakingbaddb.framework.presentation.ui.list.CharacterListFragment
import com.google.gson.GsonBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        supportFragmentManager.beginTransaction().replace(
            R.id.main_container,
            CharacterListFragment()
        ).commit()
        **/

    }
}