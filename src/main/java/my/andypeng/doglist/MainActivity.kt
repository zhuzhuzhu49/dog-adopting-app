package my.andypeng.doglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView




class MainActivity : AppCompatActivity() {



    private fun init_data(): ArrayList<dogclass> {
        var listData = ArrayList<dogclass>()
        for(i in 1..10) {
            val id =this.resources.getIdentifier("dog$i", "drawable", this.packageName)
            listData.add(dogclass("Dog $i", " No. $i : 欢迎来领养我 ",id,(1..10).random()))

        }

        return listData
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = findViewById<RecyclerView>(R.id.list)
        var dataset=init_data()
        val adapter=dog_adapter(dataset)
        list.adapter=adapter
        list.layoutManager=LinearLayoutManager(this)
        val main_context =this
        adapter.setOnItemClick(object:dog_adapter.OnItemClickListener{
            override fun onItemClick(position: Int) {

                val intent = Intent(main_context,detail_info::class.java)
                intent.putExtra("name",dataset[position].dog_name)
                intent.putExtra("slogan",dataset[position].slogan)
                intent.putExtra("id",dataset[position].dog_id)
                intent.putExtra("age",dataset[position].dog_age)
                startActivity(intent)

            }
        })




    }
}