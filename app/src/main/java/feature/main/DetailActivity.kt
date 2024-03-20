package feature.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.suek.databinding.ActivityDetailBinding
import feature.model.Catalog

class DetailActivity : AppCompatActivity() {
    companion object{

        const val EXTRAS_DETAIL_MIEAYAM = "EXTRAS_DETAIL_MIEAYAM"
        const val EXTRAS_DETAIL_BOBA = " EXTRAS_DETAIL_BOBA"

        fun startActivity(context: Context, catalog:Catalog){
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRAS_DETAIL_MIEAYAM,catalog)
            intent.putExtra(EXTRAS_DETAIL_BOBA,catalog)
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
        //receive data
        intent.extras?.getParcelable<Catalog>(EXTRAS_DETAIL_MIEAYAM)?.let {
            setFoodImage(it.image)
            setFoodData(it)
        }

        intent.extras?.getParcelable<Catalog>(EXTRAS_DETAIL_BOBA)?.let {
            setFoodImage(it.image)
            setFoodData(it)
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
}