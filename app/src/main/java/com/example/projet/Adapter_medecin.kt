package com.example.projet

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class Adapter_medecin(val cxt: Context, val data : List<Medecin>): BaseAdapter(){
    override fun getView(i: Int, p0: View?, parent: ViewGroup?): View {
        var view = p0
        var holder: ViewHolder
        if (view == null) {
            view = LayoutInflater.from(cxt).inflate(R.layout.adapter_item_medecin, parent, false)
            val textView = view?.findViewById(R.id.item_nom) as TextView
            val textView1 = view?.findViewById(R.id.item_prenom) as TextView
            val textView2 = view?.findViewById(R.id.item_specialite) as TextView
            val textView3 = view?.findViewById(R.id.item_adresse) as TextView
            val textView4 = view?.findViewById(R.id.item_heure_ouverture) as TextView
            val textView5 = view?.findViewById(R.id.item_heure_fermeture) as TextView
            val textView6 = view?.findViewById(R.id.item_num_tel) as TextView
            holder = ViewHolder(textView,textView1, textView2, textView3, textView4, textView5, textView6)
            view?.setTag(holder)
        } else {
            holder = view.tag as ViewHolder

        }
        holder.textView.setText(data.get(i).nom)
        holder.textView1.setText(data.get(i).prenom)
        holder.textView2.setText(data.get(i).specialite)
        holder.textView3.setText(data.get(i).adresse)
        holder.textView4.setText(data.get(i).heure_ouverture)
        holder.textView5.setText(data.get(i).heure_fermeture)
        holder.textView6.setText(data.get(i).num_tel)
        return view
    }

    override fun getItem(position: Int)= data.get(position)

    override fun getItemId(position: Int) =
        data.get(position).hashCode().toLong()

    override fun getCount()= data.size
}

class ViewHolder(val textView:TextView,val textView1: TextView,val textView2: TextView,val textView3: TextView,
                 val textView4: TextView,val textView5: TextView, val textView6: TextView)