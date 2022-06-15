package com.example.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recyclerviewhere:RecyclerView
    lateinit var recyclerViewlayoutmanager:RecyclerView.LayoutManager
    lateinit var recyclerAdapter: RecyclerAdapter
     var studentmodelclass: List<Student>?=null
    lateinit var apiInterface: Api_interface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerviewhere=findViewById(R.id.recyclerviewmain)
        recyclerViewlayoutmanager=LinearLayoutManager(this)
        recyclerviewhere.layoutManager=recyclerViewlayoutmanager
        recyclerviewhere.setHasFixedSize(false)
        apiInterface=ApiClient.getRetrofit().create(Api_interface::class.java)

        var call2:Call<List<Student>> = apiInterface.data
        call2.enqueue(object: Callback<List<Student>> {
            override fun onResponse(
                call: Call<List<Student>>,
                response: Response<List<Student>>
            ) {

                studentmodelclass=response.body()
                recyclerAdapter=RecyclerAdapter(studentmodelclass)
                recyclerviewhere.adapter=recyclerAdapter
            }

            override fun onFailure(call: Call<List<Student>>, t: Throwable) {

            }

        })

    }
}