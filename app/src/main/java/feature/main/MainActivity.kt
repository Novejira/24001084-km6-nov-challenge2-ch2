package feature.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.catnip.layoutingexample.layoutingexample.data.FoodDataSource
import com.catnip.layoutingexample.layoutingexample.data.FoodDataSourceImpl
import com.catnip.layoutingexample.layoutingexample.presentation.foodlist.adapter.FoodAdapter
import com.catnip.layoutingexample.layoutingexample.presentation.foodlist.adapter.OnItemClickedListener
import com.example.suek.R
import com.example.suek.databinding.ActivityMainBinding
import feature.adapter.CategoryAdapter
import feature.model.Catalog
import feature.model.Category

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adapter: FoodAdapter? = null
    private val dataSource: FoodDataSource by lazy { FoodDataSourceImpl() }
    private var isUsingGridMode: Boolean = false
    private val adapterCategory = CategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListCategory()
        setClickAction()
    }

    private fun setListCategory() {
        val data = listOf(
            Category(image = R.drawable.img_ic_noodle, name = "Noodle"),
            Category(image = R.drawable.img_ic_bread, name = "Bread"),
            Category(image = R.drawable.img_ic_drink, name = "Drink")
        )
        binding.rvCategory.apply {
            adapter = adapterCategory
        }
        adapterCategory.submitData(data)
    }

    private fun setClickAction() {
        binding.btnChangeListMode.setOnClickListener {
            isUsingGridMode = !isUsingGridMode
            setButtonText(isUsingGridMode)
            bindFoodList(isUsingGridMode)
        }
    }

    private fun setButtonText(usingGridMode: Boolean) {
        val textResId = if (usingGridMode) R.string.text_list_mode else R.string.text_grid_mode
        binding.btnChangeListMode.setText(textResId)
    }

    private fun bindFoodList(isUsingGrid: Boolean) {
        val listMode = if (isUsingGrid) FoodAdapter.MODE_GRID else FoodAdapter.MODE_LIST
        adapter = FoodAdapter (
            listMode = listMode,
            listener = object : OnItemClickedListener<Catalog> {
                override fun onItemClicked(item: Catalog) {
                    //navigate to detail
                    navigateToFood(item)
                }
            })
        binding.rvFoodList.apply {
            adapter = this@MainActivity.adapter
            layoutManager = GridLayoutManager(this@MainActivity, if (isUsingGrid) 2 else 1)
        }
        adapter?.submitData(dataSource.getFoodMembers())
    }

    private fun navigateToFood(item: Catalog) {
        DetailActivity.startActivity(this,
            Catalog(
                name = "Boba",
                nameloca = "Location",
                R.drawable.img_boba,
                foodDesc = "Bulat",
                formattedPrice = "Rp15.000",
                locaDesc = "Jl. Ruko Anggrek 1 No.18 Blok C1, Tirtajaya, Kec. Sukmajaya, Kota Depok, Jawa Barat 16412",
            )
        )
    }

}



