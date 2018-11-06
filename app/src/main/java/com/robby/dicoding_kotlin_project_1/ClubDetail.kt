package com.robby.dicoding_kotlin_project_1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.LinearLayout
import com.robby.dicoding_kotlin_project_1.entity.Club
import org.jetbrains.anko.*

class ClubDetail : AppCompatActivity() {

    companion object {
        const val im_logo = 1
        const val tv_name = 2
        const val tv_desc = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
        if (intent.hasExtra(resources.getString(R.string.parcel_club))) {
            val club = intent.getParcelableExtra<Club>(resources.getString(R.string.parcel_club))
            title = club.name
            ClubDetailUI(club).setContentView(this)
        }
    }

    inner class ClubDetailUI(var club: Club) : AnkoComponent<ClubDetail> {
        override fun createView(ui: AnkoContext<ClubDetail>) = with(ui) {
            scrollView {
                lparams(matchParent, matchParent) {
                    padding = dip(dimen(R.dimen.layout_padding))
                }

                linearLayout {
                    lparams(matchParent, wrapContent) {
                        orientation = LinearLayout.VERTICAL
                    }

                    imageView {
                        id = im_logo
                        imageResource = club.logo
                    }.lparams(dimen(R.dimen.image_detail_size), dimen(R.dimen.image_detail_size)) {
                        gravity = Gravity.CENTER_HORIZONTAL
                    }

                    textView {
                        id = tv_name
                        text = club.name
                        textAppearance = android.R.style.TextAppearance_Medium
                    }.lparams(wrapContent, wrapContent) {
                        gravity = Gravity.CENTER_HORIZONTAL
                    }

                    textView {
                        id = tv_desc
                        text = club.description
                    }.lparams(wrapContent, wrapContent)
                }
            }
        }

    }
}