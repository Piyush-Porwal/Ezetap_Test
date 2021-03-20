package com.ezetap.test.utils.databinding

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.facebook.shimmer.ShimmerFrameLayout

/**
 * Custom binding adapter for Views
 */
object ViewBindingAdapters {

    /**
     * Glide data binding adapter
     * Custom binding adapter to fetch and load image in an [android.widget.ImageView] using [Glide]
     *
     * @param imageView ImageView to load image
     * @param url Url of image to be loaded
     * @param placeholder Placeholder drawable while image is being fetched
     */
    @JvmStatic
    @BindingAdapter(value = ["imageUrl", "placeholder"], requireAll = false)
    fun setImageUsingGlide(
        imageView: ImageView, url: String?, placeholder: Drawable?
    ) {

        if (!url.isNullOrBlank()) {
            // Outline clipping is helpful in drawing rounded corners
            imageView.clipToOutline = true

            Glide.with(imageView)
                .load(url).placeholder(placeholder)
                .centerInside()
                .transition(
                    DrawableTransitionOptions().crossFade()
                ).into(imageView)
        }
    }

    @JvmStatic
    @BindingAdapter("isGone")
    fun bindIsGone(view: View, isGone: Boolean) {
        view.visibility = if (isGone) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }

    @JvmStatic
    @BindingAdapter("isLoading")
    fun toggleShimmerEffect(shimmerFrameLayout: ShimmerFrameLayout, isLoading: Boolean) {
        if (!isLoading) {
            shimmerFrameLayout.stopShimmer()
            shimmerFrameLayout.visibility = View.GONE
        } else {
            shimmerFrameLayout.startShimmer()
            shimmerFrameLayout.visibility = View.VISIBLE
        }
    }
}
