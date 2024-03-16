package feature.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import feature.model.Category
import com.example.suek.R
import com.example.suek.databinding.ActivityMainBinding
import feature.detail.model.CategoryAdapter
import feature.model.Catalog

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
    private val adapter1 = CatalogAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setAction()
        setListCategory()
        setListCatalog()
    }

    private fun setListCategory() {
        val data = listOf(
            Category(image = R.drawable.img_ic_noodle, name = "Noodle"),
            Category(image = R.drawable.img_ic_bread, name = "Bread"),
            Category(image = R.drawable.img_ic_drink, name = "Drink")

        )
        binding.rvCategory.apply {
            adapter = this@MainActivity.adapter
        }
        adapter.submitData(data)
    }

    private fun setListCatalog() {
        val data = listOf(
            Catalog(image = R.drawable.img_choco_cake, name = "Chocolate Cake", price = 50000.0),
            Catalog(image = R.drawable.img_straw_cake, name = "Strawberry Cake", price = 50000.0),
            Catalog(image = R.drawable.img_choco_bread, name = "Chocolate Bread", price = 10000.0),
            Catalog(image = R.drawable.img_straw_bread, name = "Strawberry Bread", price = 10000.0),
            Catalog(
                image = R.drawable.img_choco_cookies,
                name = "Chocolate Cookies",
                price = 5000.0
            ),
            Catalog(image = R.drawable.img_ginger_cookies, name = "Ginger Cookies", price = 5000.0),
            Catalog(
                image = R.drawable.img_choco_pudding,
                name = "Chocolate Pudding",
                price = 10000.0
            ),
            Catalog(
                image = R.drawable.img_straw_pudding,
                name = "Strawberry Pudding",
                price = 10000.0
            ),
            Catalog(image = R.drawable.img_straw_juice, name = "Strawberry Juice", price = 15000.0),
            Catalog(image = R.drawable.img_orange_juice, name = "Orange Juice", price = 15000.0),
            Catalog(image = R.drawable.img_potato_chips, name = "Potato Chips", price = 10000.0),
            Catalog(image = R.drawable.img_spicy_chips, name = "Spicy Chips", price = 10000.0)

        )
        binding.rvCatalog.apply {
            adapter = this@MainActivity.adapter1
        }
        adapter1.submitData(data)
    }

    private fun setAction() {
        binding.layoutHeader.ivProfile.setOnClickListener {
            Toast.makeText(this@MainActivity, "Aku manusia dan sudah login ", Toast.LENGTH_SHORT)
                .show()
            binding.layoutHeader.tvName.text = "Home"
        }
    }
}


