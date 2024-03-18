package feature.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.suek.R
import com.example.suek.databinding.ActivityMainBinding
import feature.adapter.CatalogAdapter
import feature.adapter.CategoryAdapter
import feature.model.Category

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
        /*setListCatalog()*/
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

    /*private fun setListCatalog() {
        val data1 = listOf(
            Catalog(image = R.drawable.img_boba, name = "Boba", formattedPrice = "Rp 15.000"),
            Catalog(image = R.drawable.img_rotio, name = "Roti O", formattedPrice = "Rp 18.000"),
            Catalog(image = R.drawable.img_mieayam, name = "Mie Ayam", formattedPrice = "Rp 12.000"),
        )
        binding.rvCatalog.apply {
            adapter = this@MainActivity.adapter1
        }
        adapter1.submitData(data1)
    }*/

    private fun setAction() {
        binding.layoutHeader.ivProfile.setOnClickListener {
            Toast.makeText(this@MainActivity, "Aku manusia dan sudah login ", Toast.LENGTH_SHORT)
                .show()
            binding.layoutHeader.tvName.text = "Home"
        }
    }
}


