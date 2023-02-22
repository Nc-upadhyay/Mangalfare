package com.nc.mangalfare.customviews

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Build
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.res.ResourcesCompat
import com.nc.mangalfare.R

class CustomShagunProgressBar(context: Context) : Dialog(context) {
    private var dialog: CustomDialog
    private var cpTitile: TextView
    private var cpCardView: CardView
    private var cpProgressBar: ProgressBar

    fun start() {
        dialog.show()
    }

    fun stop() {
        dialog.dismiss()
    }

    init {
        val inflater = (context as Activity).layoutInflater
        val view = inflater.inflate(R.layout.progress_dialog_view, null)

        cpTitile = view.findViewById(R.id.cp_title)
        cpCardView = view.findViewById(R.id.cp_cardview)
        cpProgressBar = view.findViewById(R.id.cp_pbar)

        //card view backgroud color
        cpCardView.setCardBackgroundColor(Color.parseColor("#70000000"))

        //progress bar color
        setColorFilter(
            cpProgressBar.indeterminateDrawable,
            ResourcesCompat.getColor(context.resources, R.color.progressCircle, null)
        )

        // Title Text Color
        cpTitile.setTextColor(Color.WHITE)

        //Custom dialog initializer
        dialog= CustomDialog(context)
        dialog.setContentView(view)
    }

    private fun setColorFilter(drawable: Drawable, color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            drawable.colorFilter = BlendModeColorFilter(color, BlendMode.SRC_ATOP)
        } else {
            @Suppress("DEPRECATION")
            drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
        }
    }
    class CustomDialog(context: Context) : Dialog(context, R.style.CustomDialogTheme) {
        init {
            // Set Semi-Transparent Color for Dialog Background
            window?.decorView?.rootView?.setBackgroundResource(R.color.dialogBackground)
            window?.decorView?.setOnApplyWindowInsetsListener { _, insets ->
                insets.consumeSystemWindowInsets()
            }
        }
    }
}
