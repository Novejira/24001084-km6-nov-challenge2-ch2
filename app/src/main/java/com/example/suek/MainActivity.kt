package com.catnip.layoutingexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.catnip.layoutingexample.model.Category
import com.example.suek.R
import com.example.suek.databinding.ActivityMainBinding
import com.example.suek.model.CategoryAdapter

/* LayoutInflater system / findViewById Approach

class MainActivity : AppCompatActivity() {

    private val ivProfile: ImageView by lazy {
        findViewById(R.id.iv_profile)
    }
    private val tvName : TextView by lazy {
        findViewById(R.id.tv_name)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAction()
        changeProfileIcon()
    }

    private fun changeProfileIcon() {
        ivProfile.setImageResource(R.drawable.img_cat)
    }

    private fun setAction() {
        ivProfile.setOnClickListener {
            Toast.makeText(this@MainActivity, "Asnafi ganteng", Toast.LENGTH_SHORT).show()
        }
        tvName.text = "Hai, Cella !"
    }
}*/


class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val adapter = CategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setAction()
        setListCategory()
    }

    private fun setListCategory() {
        val data = listOf(
            Category(image = R.drawable.img_pudding, name = "Pudding"),
            Category(image = R.drawable.img_bread, name = "Bread"),
            Category(image = R.drawable.img_cake, name = "Cake"),
            Category(image = R.drawable.img_chips, name = "Chips"),
            Category(image = R.drawable.img_cookies, name = "Cookies"),
            Category(image = R.drawable.img_juice, name = "Juice")

        )
        binding.rvCategory.apply {
            adapter = this@MainActivity.adapter
        }
        adapter.submitData(data)
    }

    private fun setAction() {
        binding.layoutHeader.ivProfile.setOnClickListener {
            Toast.makeText(this@MainActivity, "Aku manusia dan sudah login ", Toast.LENGTH_SHORT)
                .show()

            binding.layoutHeader.ivCart.setOnClickListener {
                Toast.makeText(
                    this@MainActivity,
                    "Langsung beli , di jamin nagih ",
                    Toast.LENGTH_SHORT
                ).show()

                binding.layoutHeader.tvName.text = "Hai, Guys !"
            }
        }
    }
}

