package com.viiam.feednemo.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.viiam.feednemo.R
import com.viiam.feednemo.model.Post
import kotlinx.android.synthetic.main.activity_post.*

class PostActivity : BaseActivity<PostPresenter>(), PostView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun updatePosts(posts: List<Post>) {
        tv_post.text = posts.size.toString()
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun instantiatePresenter(): PostPresenter {
        return PostPresenter(this)
    }
}