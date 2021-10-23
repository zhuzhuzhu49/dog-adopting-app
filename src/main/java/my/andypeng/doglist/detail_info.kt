package my.andypeng.doglist

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class detail_info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var dog_name=this.getIntent().getStringExtra("name")
        var dog_slogan=this.getIntent().getStringExtra("slogan")
        val dog_id=this.getIntent().getIntExtra("id", 0)
        val dog_age=this.getIntent().getIntExtra("age", 0)
        val dog_age_new=dog_age.toString()

        findViewById<TextView>(R.id.name_detail).text=dog_name
        findViewById<ImageView>(R.id.img_detail).setImageResource(dog_id)
        findViewById<TextView>(R.id.slogan_detail).text=dog_slogan
        findViewById<TextView>(R.id.age_detail).text="Age:"+dog_age_new
    }
}