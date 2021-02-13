
package com.example.taskcoffe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import com.example.taskcoffe.R


class OrderFragment : Fragment() {
    private lateinit var isChoc: CheckBox
    private lateinit var isVan: CheckBox
    private lateinit var plus: Button
    private lateinit var minus: Button
    private lateinit var sugar: TextView
    private lateinit var res: Button
    private lateinit var resView: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val v = inflater.inflate(R.layout.fragment_order, container, false)
        v.findViewById<TextView>(R.id.name_text).text = arguments?.getString("name")
        isChoc = v.findViewById(R.id.choc)
        isVan = v.findViewById(R.id.van)
        plus = v.findViewById(R.id.plus)
        minus = v.findViewById(R.id.minus)
        sugar = v.findViewById(R.id.count)
        res = v.findViewById(R.id.see_res)
        resView = v.findViewById(R.id.result)
        plus.setOnClickListener(){
            val value = sugar.text.toString().toInt()
            sugar.text = (value + 1).toString()
        }
        minus.setOnClickListener(){
            val value = sugar.text.toString().toInt()
            if (value > 0) {
                sugar.text = (value - 1).toString()
            }
        }
        res.setOnClickListener(){
            val s = sugar.text.toString().toInt()
            val order = "Вы заказали:\n" +
                    "Кофе ${if (s > 0) "с $s ложкой(-ами) сахара" else "без сахара"}\n" +
                    "Шоколад: ${if (isChoc.isChecked) "есть" else "нет"}\n" +
                    "Ваниль: ${if (isVan.isChecked) "есть" else "нет"}"
            resView.text = order
        }
        return v
    }
}