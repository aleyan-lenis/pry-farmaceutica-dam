package com.taller.proyectofarmaceutica

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.taller.proyectofarmaceutica.models.Producto

class ProductosAdapter(
    private val productos: List<Producto>,
    private val onAddToCart: (Producto) -> Unit
) : RecyclerView.Adapter<ProductosAdapter.ProductoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_producto, parent, false)
        return ProductoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = productos[position]
        holder.nombreTextView.text = producto.nombreProducto
        holder.precioTextView.text = producto.precioProducto.toString()

        holder.addToCartButton.setOnClickListener {
            onAddToCart(producto)
        }

        holder.descripcionTextView.text = producto.descripcionProducto
    }

    override fun getItemCount() = productos.size

    class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreTextView: TextView = itemView.findViewById(R.id.nombreProductoTextView)
        val precioTextView: TextView = itemView.findViewById(R.id.precioProductoTextView)
        val descripcionTextView: TextView = itemView.findViewById(R.id.textDescripcion)
        val addToCartButton: Button = itemView.findViewById(R.id.addToCartButton)
        // Other views can be initialized here
    }
}


/*package com.taller.proyectofarmaceutica

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.taller.proyectofarmaceutica.models.Producto

class ProductosAdapter(private val productos: List<Producto>,
                       private val onAddtoCart: (Producto) -> Unit) :
    RecyclerView.Adapter<ProductosAdapter.ProductoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_producto, parent, false)
        return ProductoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = productos[position]
        holder.nombreTextView.text = producto.nombreProducto
        holder.precioTextView.text = producto.precioProducto.toString()
        holder.addToCartButton.setOnClickListener {
            onAddToCart(producto)
        }
        //aqui pueden ir otros parámetros

    }

    override fun getItemCount() = productos.size

    class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreTextView: TextView = itemView.findViewById(R.id.nombreProductoTextView)
        val precioTextView: TextView = itemView.findViewById(R.id.precioProductoTextView)
        val addToCartButton : Button  = itemView.findViewById(R.id.addToCartButton)
        //aqui pueden ir otros parámetros
    }
}*/
