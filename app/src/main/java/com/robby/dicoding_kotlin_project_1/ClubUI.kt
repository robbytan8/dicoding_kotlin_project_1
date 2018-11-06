package com.robby.dicoding_kotlin_project_1

import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*

class ClubUI : AnkoComponent<ViewGroup> {

    companion object {
        const val iv_logo = 1
        const val tv_name = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        linearLayout {
            lparams (matchParent, wrapContent){
                orientation = LinearLayout.HORIZONTAL
                topPadding = dimen(R.dimen.row_padding)
                bottomPadding = dimen(R.dimen.row_padding)
            }

            imageView {
                id = iv_logo
                imageResource = R.drawable.img_acm
            }.lparams(dimen(R.dimen.image_row_size), dimen(R.dimen.image_row_size))

            textView {
                id = tv_name
                text = "My Club"
            }.lparams (matchParent, wrapContent){
                gravity = Gravity.CENTER_VERTICAL
                leftMargin = dimen(R.dimen.component_margin)
            }
        }
    }
}