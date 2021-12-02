package com.example.idealkilohesapla

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // todo viewmodel yapısı öğrenilecek

        val height = requireActivity().findViewById<EditText>(R.id.editTextHeight)
        val weight = requireActivity().findViewById<EditText>(R.id.editTextWeight)
        val buttonCalcute = requireActivity().findViewById<Button>(R.id.buttonCalculate)
        val radioButtonMale = requireActivity().findViewById<RadioButton>(R.id.radioButtonMale)
        val radioButtonFemale = requireActivity().findViewById<RadioButton>(R.id.radioButtonFemale)
        val imageViewThin = requireActivity().findViewById<ImageView>(R.id.imageViewBodyThin)
        val imageViewFat = requireActivity().findViewById<ImageView>(R.id.imageViewBodyFat)
        val textViewIdealWeight = requireActivity().findViewById<TextView>(R.id.textViewIdealWeight)
        val imageViewInfo = requireActivity().findViewById<ImageView>(R.id.imageViewInfo)


        imageViewInfo.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAboutFragment())
        }


        buttonCalcute.setOnClickListener {

            val gender = if (radioButtonMale.isChecked) {
                Gender.MALE
            } else {
                Gender.FEMALE
            }

            if (!height.text.isNullOrEmpty()) {
                val idealWeight = calculateIdealWeight(height.text.toString().toDouble(), gender)

                if (weight.text.toString().toDouble() > idealWeight) {
                    imageViewFat.setColorFilter(requireActivity().getColor(R.color.teal_700))
                } else {
                    imageViewThin.setColorFilter(requireActivity().getColor(R.color.teal_700))
                }

                textViewIdealWeight.text = idealWeight.toString()
                textViewIdealWeight.visibility = View.VISIBLE
            }

        }

    }

    fun calculateIdealWeight(height: Double, gender: Gender): Double {
        val idealWeight = when(gender) {
            Gender.MALE -> 50 + (2.3 / 2.54) * (height - 152.4)
            Gender.FEMALE -> 45.4 + (2.3 / 2.54) * (height - 152.4)
        }

        return idealWeight
    }

}