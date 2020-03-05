package com.example.projet

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class Adapter_traitant(val cxt: Context, val data : List<Medecin>): BaseAdapter(){
    override fun getView(i: Int, p0: View?, parent: ViewGroup?): View {
        var view = p0
        var holder: ViewHolderTrait
        if (view == null) {
            view = LayoutInflater.from(cxt).inflate(R.layout.adapter_item_trait, parent, false)
            val textView = view?.findViewById(R.id.item_fullname) as TextView
            val textView2 = view?.findViewById(R.id.item_adresse) as TextView
            val textView3 = view?.findViewById(R.id.item_tel) as TextView
            holder = ViewHolderTrait(textView, textView2, textView3)
            view?.setTag(holder)
        } else {
            holder = view.tag as ViewHolderTrait

        }
        holder.textView.setText(data.get(i).full_name)
        holder.textView2.setText(data.get(i).commune)
        holder.textView3.setText(data.get(i).phone)
        return view
    }

    override fun getItem(position: Int)= data.get(position)

    override fun getItemId(position: Int) =
        data.get(position).hashCode().toLong()

    override fun getCount()= data.size
}

class ViewHolderTrait(val textView:TextView,val textView2: TextView,val textView3: TextView)