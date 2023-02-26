package com.forest.yoursystem.db

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.forest.yoursystem.NewNote
import com.forest.yoursystem.R

// Заполняет поле (rcView) в окне (notes) элементами rc_item (являющимися записями из БД)
// Функции этого класса выполняются и рисуют элементы только после появления их на экране для экономии памяти
class MyAdapter(listMain: ArrayList<ListItem>, contextM: Context) : RecyclerView.Adapter<MyAdapter.MyHolder>() {

    private var listArray = listMain
    var context = contextM

    // Класс View в который помещается шаблон заметки
    class MyHolder(itemView: View, contextV: Context) : RecyclerView.ViewHolder(itemView) {
        private val tvNote : TextView = itemView.findViewById(R.id.tvNote)
        private val context = contextV
        fun setData(item: ListItem){
            tvNote.text = item.note;
            itemView.setOnClickListener{
                val intent = Intent(context, NewNote::class.java).apply {
                    putExtra(MyIntentConstants.I_NOTE_KEY, item.note)
                    putExtra(MyIntentConstants.I_ID_KEY, item.id)
                }
                context.startActivity(intent)
            }
        }
    }

    // Берем шаблон и готовим его для рисования
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val inflater = LayoutInflater.from(parent.context) // Берет xml файл и подготавливает его для рисования
        return MyHolder(inflater.inflate(R.layout.rc_item, parent, false), context)
    }

    // Говорим адаптеру - сколько элементов будет в нашем списке
    override fun getItemCount(): Int {
        return listArray.size
    }

    // Подключает данные массива к шаблону который готов для рисования
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.setData(listArray.get(position))
    }

    fun updateAdapter(listItems:List<ListItem>){
        listArray.clear()
        listArray.addAll(listItems)
        notifyDataSetChanged()
    }

    fun removeItem(pos:Int, dbManager: MyDBManager){
        dbManager.removeItemFromDB(listArray[pos].id.toString())
        listArray.removeAt(pos)
        notifyItemRangeChanged(0, listArray.size)
        notifyItemRemoved(pos)
    }
}