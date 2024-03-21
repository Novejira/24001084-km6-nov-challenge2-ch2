package feature.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.suek.databinding.ActivityDetailBinding
import feature.model.Catalog
import feature.model.Food2

class DetailActivity : AppCompatActivity() {
    companion object{

        const val EXTRAS_DETAIL_BOBA = " EXTRAS_DETAIL_BOBA"
        const val EXTRAS_DETAIL_MIEAYAM = " EXTRAS_DETAIL_MIEAYAM"


        fun startActivity(context: Context, catalog:Catalog, food2: Food2 ){
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRAS_DETAIL_BOBA,catalog)
            intent.putExtra(EXTRAS_DETAIL_MIEAYAM,food2)
            context.startActivity(intent)
        }

    }

    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getIntentData()
    }

    private fun getIntentData() {
        intent.extras?.getParcelable<Catalog>(EXTRAS_DETAIL_BOBA)?.let {
            setFoodImage(it.image)
            setFoodData(it)
        }
        intent.extras?.getParcelable<Food2>(EXTRAS_DETAIL_MIEAYAM)?.let {
            setFoodImage2(it.image)
            setFoodData2(it)
        }
    }

    private fun setFoodData(catalog: Catalog) {
        binding.tvNameFood.text = catalog.name
        binding.tvFoodPrice.text = catalog.formattedPrice
        binding.tvFoodDesc.text = catalog.foodDesc
        binding.tvDescLoca.text = catalog.addres
        binding.tvDescLoca.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(catalog.mapURL))
            startActivity(i)
        }
    }

    private fun setFoodImage(imgResDrawable: Int?) {
        imgResDrawable?.let {
            binding.ivPhotoFood.setImageResource(it)
        }
    }

    private fun setFoodData2(food2: Food2) {
        binding.tvNameFood.text = food2.name
        binding.tvFoodPrice.text = food2.formattedPrice
        binding.tvFoodDesc.text = food2.foodDesc
        binding.tvDescLoca.text = food2.addres
        binding.tvDescLoca.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(food2.mapURL))
            startActivity(i)
        }
    }

    private fun setFoodImage2(imgResDrawable: Int?) {
        imgResDrawable?.let {
            binding.ivPhotoFood.setImageResource(it)
        }
    }

}