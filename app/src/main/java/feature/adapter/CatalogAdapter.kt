package feature.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.suek.databinding.ItemCatalogBinding
import feature.model.Catalog

class CatalogAdapter : RecyclerView.Adapter<CatalogAdapter.CatalogViewHolder>() {



    private val data = mutableListOf<Catalog>()

    fun submitData(items: List<Catalog>) {
        data.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        return CatalogViewHolder(
            ItemCatalogBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    //counting the data size
    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class CatalogViewHolder(private val binding: ItemCatalogBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Catalog) {
            binding.tvCatalogName.text = item.name
            binding.ivCatalogImage.setImageResource(item.image)
            binding.tvCatalogPrice.text = item.formattedPrice.toString()
        }
    }
}


