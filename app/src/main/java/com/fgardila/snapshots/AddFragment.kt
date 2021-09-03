package com.fgardila.snapshots

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fgardila.snapshots.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private val RC_GALLERY = 18

    private lateinit var mBindign: FragmentAddBinding

    private var mPhotoSelectedUri: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBindign = FragmentAddBinding.inflate(inflater, container, false)
        return mBindign.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBindign.btnPost.setOnClickListener { postSnapshot() }

        mBindign.btnSelect.setOnClickListener { openGallery() }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, RC_GALLERY)
    }

    private fun postSnapshot() {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == RC_GALLERY) {
                mPhotoSelectedUri = data?.data
                mBindign.imgPhoto.setImageURI(mPhotoSelectedUri)
            }
        }
    }
}