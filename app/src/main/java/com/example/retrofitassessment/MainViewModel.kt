 package com.example.retrofitassessment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Response

class MainViewModel: ViewModel() {
    val model: MutableLiveData<List<Items>> = MutableLiveData()
    val myResponse: MutableLiveData<List<Student>> = MutableLiveData()


    fun getAllItems() {
        CoroutineScope(Dispatchers.IO).launch {
            val items: List<Items> = RetrofitProvider.service.getALLItems()

            model.postValue(items)
        }

    }

//    val model2=HashMap<String, String>()

//    val jsonObject=JSONObject()

    fun addStudent() {
        try {
//        jsonObject.put("name :", "Sajere Ogaga")
//        jsonObject.put("seat :", "16")
//        jsonObject.put("class :","Class B")
            CoroutineScope(Dispatchers.IO).launch {
                val response: List<Student> =
                    RetrofitProvider.service.addStudent(Student("B","Sajere Ogaga",16))

                myResponse.postValue(response)


//            model2["name"] = "Sajere Ogaga Terence"
//            model2["seat"] = "16"
//            model2["class"] = "Class B"


            }
        } catch (e: Exception) {
            Log.e("ViewModel", e.message.toString())

        }
    }
}