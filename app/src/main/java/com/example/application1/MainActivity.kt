package com.example.application1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.application1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

        fun checkResult(operand:String,operatorOne:Int,operatorTwo:Int, playerResult: Int):Boolean
        {
            var result = 0
            when (operand){
                "+" -> result = operatorOne+operatorTwo
                "-" -> result = operatorOne-operatorTwo
                "*" -> result = operatorOne*operatorTwo
                "/" -> result = operatorOne/operatorTwo
            }
            return (result == playerResult)
        }

        fun onClickStart(view: View)
        {
            binding.editTextNumber.text.clear()
            binding.editTextNumber.setBackgroundColor(Color.WHITE)
            val operands = arrayOf("+","-","*","/")
            val operand = operands.random()
            var oneOperant = (10..99).random()
            var twoOperator = (10..99).random()
            if (operand == "/")
            {
                while (oneOperant%twoOperator!=0)
                {
                    oneOperant = (10..99).random()
                    twoOperator = (10..99).random()
                }
            }
            binding.txtFirstOperand.text = oneOperant.toString()
            binding.txtTwoOperand.text = twoOperator.toString()
            binding.txtOperation.text = operand
            binding.editTextNumber.isEnabled = true
            binding.btnCheckAnswer.isEnabled = true
            binding.btnStart.isEnabled = false
        }
    fun onClickCheckAnswer(view: View)
    {
        var wins = binding.txtNumberRigth.text.toString().toInt()
        var loses = binding.txtNumberWrong.text.toString().toInt()
        var allExamples = 0
        var percentage = 0.0
        val operator1 = binding.txtFirstOperand.text.toString().toInt()
        val operator2 = binding.txtTwoOperand.text.toString().toInt()
        val operandTxt = binding.txtOperation.text.toString()
        val resultPlayer = binding.txtEqually.text.toString().toInt()
        if (checkResult(operandTxt,operator1,operator2,resultPlayer))
        {
            wins +=1
            allExamples +=1
            percentage = (allExamples/wins).toDouble()
            binding.txtNumberRigth.text = wins.toString()
            binding.editTextNumber.setBackgroundColor(Color.GREEN)
            binding.txtAllExamples.text = allExamples.toString()
            binding.txtPercentageCorrectAnswers.text = percentage.toString() + "%"
        }
        else
        {
            loses +=1
            allExamples +=1
            percentage = (allExamples/wins).toDouble()
            binding.txtNumberWrong.text = wins.toString()
            binding.editTextNumber.setBackgroundColor(Color.RED)
            binding.txtAllExamples.text = allExamples.toString()
            binding.txtPercentageCorrectAnswers.text = percentage.toString() + "%"
        }
    }
}