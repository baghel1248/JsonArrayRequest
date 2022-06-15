package com.example.jsonarrayrequest

 import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var string:String=""
        var textview2:TextView=findViewById(R.id.textview1)
        var jsonArrayRequest1:JsonArrayRequest= JsonArrayRequest("https://jackwebsite1248.000webhostapp.com/databaseFetch.php", Response.Listener {
        response ->
            var jsonObject1:JSONObject
            for(i in 0..response.length()-1){
                jsonObject1=response.getJSONObject(i)
                var name1=jsonObject1.getString("name")
                var id1=jsonObject1.getString("id")
                string+="$name1 \n $id1 \n"

            }
            textview2.setText("$string")

        }, Response.ErrorListener {  })
        var requestQueue1:RequestQueue=Volley.newRequestQueue(applicationContext)
        requestQueue1.add(jsonArrayRequest1)
    }
}