package com.ezetap.test.ui.customUi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.ezetap.test.R
import com.ezetap.test.data.customUi.model.CustomUIModel
import com.ezetap.test.databinding.FragmentCustomUiBinding
import com.ezetap.test.di.modules.viewmodel.ViewModelFactory
import com.ezetap.test.utils.EventObserver
import com.ezetap.test.utils.extensions.setDataBindingView
import com.ezetap.test.utils.extensions.showSuccessSnackbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class CustomUiFragment: DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val customUiViewModel: CustomUiViewModel by viewModels { viewModelFactory }

    private lateinit var customUIModel: CustomUIModel

    private lateinit var binding: FragmentCustomUiBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = setDataBindingView(R.layout.fragment_custom_ui, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObserver()
        customUiViewModel.getCustomUIData()
    }

    private fun initView(){
        binding.viewmodel = customUiViewModel
        binding.errorView.viewmodel = customUiViewModel
        binding.errorView.lifecycleOwner = viewLifecycleOwner

        binding.errorView.refreshBtn.setOnClickListener {
            customUiViewModel.getCustomUIData()
        }
    }

    private fun initObserver(){
        customUiViewModel.customUiData.observe(viewLifecycleOwner, EventObserver{
            customUIModel = it
            binding.customUIModel = it
            buildCustomUI(customUIModel)
            showSuccessSnackbar("Success")

        })
    }

    private fun buildCustomUI(customUIModel: CustomUIModel){

        if (customUIModel.uidata != null) {
            for (customUIElement in customUIModel.uidata!!){
                when(customUIElement.uiType){
                    LABEL -> {
                        val labelParam: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)

                        val textView = MaterialTextView(binding.parentViewCustomUiLl.context)
                        textView.text = customUIElement.value
                        textView.layoutParams = labelParam
                        labelParam.topMargin = 16
                        labelParam.bottomMargin = 10
                        binding.parentViewCustomUiLl.addView(textView)
                    }
                    EDIT_TEXT -> {
                        val editTextParam: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)

                        val textInputLayout = TextInputLayout(binding.parentViewCustomUiLl.context, null, R.style.Widget_MaterialComponents_TextInputLayout_OutlinedBox)
                        textInputLayout.hint = customUIElement.hint
                        textInputLayout.boxBackgroundMode = TextInputLayout.BOX_BACKGROUND_OUTLINE
                        textInputLayout.boxStrokeColor = ContextCompat.getColor(requireContext(), R.color.colorPrimary)
                        textInputLayout.boxStrokeWidth = 2
                        textInputLayout.layoutParams = editTextParam
                        editTextParam.bottomMargin = 12

                        val textInputEditText = TextInputEditText(textInputLayout.context)
                        textInputLayout.addView(textInputEditText)
                        binding.parentViewCustomUiLl.addView(textInputLayout)
                    }

                    BUTTON -> {
                        val buttonParam: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)

                        val button = MaterialButton(binding.parentViewCustomUiLl.context)
                        button.text = customUIElement.value
                        button.layoutParams = buttonParam
                        buttonParam.topMargin = 50
                        buttonParam.bottomMargin = 12
                        binding.parentViewCustomUiLl.addView(button)
                    }
                }
            }
        }
    }

    companion object {
        private const val LABEL = "label"
        private const val EDIT_TEXT = "edittext"
        private const val BUTTON = "button"
    }
}