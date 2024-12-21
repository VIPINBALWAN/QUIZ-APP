package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizapp.R
import kotlinx.android.synthetic.main.activity_quiz_categories.*

class QuizCategories : AppCompatActivity(), OnClicked {
    private lateinit var categoryList: ArrayList<CategoryView>
    private lateinit var userName: String
    private lateinit var categorySelected: String
    private lateinit var builder : AlertDialog.Builder
    private lateinit var alertDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_categories)


        userName = intent.getStringExtra("user").toString()
        //recycler view needs layout manager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        categoryList = fetchCategories()
        recyclerView.adapter = CategoriesAdapter(categoryList, this)
    }

    private fun fetchCategories(): ArrayList<CategoryView> {
        val data: ArrayList<CategoryView> = ArrayList()
        val obj1 = ResourcesCompat.getDrawable(resources, R.drawable.bg1, null)?.let {
            ResourcesCompat.getDrawable(resources, R.drawable.book_stack, null)?.let { it1 ->
                CategoryView(
                    R.drawable.bg, "MATHS",
                    it, it1
                )
            }
        }
        val obj2 = ResourcesCompat.getDrawable(resources, R.drawable.bg2, null)?.let {
            ResourcesCompat.getDrawable(resources, R.drawable.book_stack, null)?.let { it1 ->
                CategoryView(
                    R.drawable.bg,
                    "SCIENCE",
                    it, it1
                )
            }
        }
        val obj3 = ResourcesCompat.getDrawable(resources, R.drawable.bg3, null)?.let {
            ResourcesCompat.getDrawable(resources, R.drawable.book_stack, null)?.let { it1 ->
                CategoryView(
                    R.drawable.bg,
                    "SST",
                    it, it1
                )
            }
        }
        val obj4 = ResourcesCompat.getDrawable(resources, R.drawable.bg4, null)?.let {
            ResourcesCompat.getDrawable(resources, R.drawable.book_stack, null)?.let { it1 ->
                CategoryView(
                    R.drawable.bg,
                    "ENGLISH",
                    it, it1
                )
            }
        }
        val obj5 = ResourcesCompat.getDrawable(resources, R.drawable.bg1, null)?.let {
            ResourcesCompat.getDrawable(resources, R.drawable.book_stack, null)?.let { it1 ->
                CategoryView(
                    R.drawable.bg,
                    "Art",
                    it, it1
                )
            }
        }


        if (obj1 != null) {
            data.add(obj1)
        }
        if (obj2 != null) {
            data.add(obj2)
        }
        if (obj3 != null) {
            data.add(obj3)
        }
        if (obj4 != null) {
            data.add(obj4)
        }
        if (obj5 != null) {
            data.add(obj5)
        }
        return data

    }

    //through interface in adapter class
    override fun categoryClicked(s: CategoryView) {
        showDialog(s)
    }

    //Dialog for Quiz Category selection
    private fun showDialog(s: CategoryView) {
        val dialogLayout = layoutInflater.inflate(R.layout.category_dialog, null)
        builder = AlertDialog.Builder(this)
        dialogLayout.findViewById<View>(R.id.okButton).setOnClickListener {
            categorySelected = s.category
            alertDialog.dismiss()
            val intent = Intent(this, QuestionsActivity::class.java)
            intent.putExtra("user", userName)
            intent.putExtra("category", categorySelected)
            startActivity(intent)
        }
        dialogLayout.findViewById<View>(R.id.cancelButton).setOnClickListener {
            alertDialog.dismiss()
        }
        builder.setView(dialogLayout)
        alertDialog = builder.create()
        alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        alertDialog.show()
    }
}