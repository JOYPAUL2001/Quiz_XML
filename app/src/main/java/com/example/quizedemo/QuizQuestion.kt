package com.example.quizedemo

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.BitmapFactory.Options
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizedemo.Result
import com.example.quizedemo.databinding.ActivityQuizQuestionBinding

class QuizQuestion : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mUserName: String? = null
    private var mCorrectAnswer: Int = 0


    private lateinit var binding: ActivityQuizQuestionBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)


        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThird.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)
        binding.tvSubmit.setOnClickListener(this)


        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionList = Constants.getQuestions()
        setQuestion()
        defaultOptionsView()
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {
        defaultOptionsView()
        val question: Question = mQuestionList!![mCurrentPosition - 1]
        binding.progressBar.progress = mCurrentPosition
        binding.tvProgress.text = "$mCurrentPosition/${binding.progressBar.max}"
        binding.tvQuestion.text = question.question
        binding.tvImage.setImageResource(question.Image)
        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThird.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour

        if (mCurrentPosition == mQuestionList!!.size) {
            binding.tvSubmit.text = "Finish"
        } else {
            binding.tvSubmit.text = "Submit"
        }
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        binding.tvOptionOne?.let {
            options.add(0, it)
        }
        binding.tvOptionTwo?.let {
            options.add(1, it)
        }
        binding.tvOptionThird?.let {
            options.add(2, it)
        }
        binding.tvOptionFour?.let {
            options.add(3, it)
        }
        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.option
            )
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptioNum: Int) {
        defaultOptionsView()

        mSelectedOptionPosition = selectedOptioNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selectoption
        )
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_optionOne -> {
                binding.tvOptionOne?.let {
                    selectedOptionView(it, 1)
                }
            }

            R.id.tv_optionTwo -> {
                binding.tvOptionTwo?.let {
                    selectedOptionView(it, 2)
                }
            }

            R.id.tv_optionThird -> {
                binding.tvOptionThird?.let {
                    selectedOptionView(it, 3)
                }
            }

            R.id.tv_optionFour -> {
                binding.tvOptionFour?.let {
                    selectedOptionView(it, 4)
                }
            }

            R.id.tv_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++
                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }

                        else -> {
                            val intent = Intent(this, Result::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWER, mCorrectAnswer)
                            intent.putExtra(Constants.TOTAL_QUESTION, mQuestionList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong)
                    } else {
                        mCorrectAnswer++
                    }
                    answerView(question.correctAnswer, R.drawable.correct)


                    if (mCurrentPosition == mQuestionList!!.size) {
                        binding.tvSubmit.text = "Finish"
                    } else {
                        binding.tvSubmit.text = "Next Question"
                    }
                    mSelectedOptionPosition = 0
                }

            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                binding.tvOptionOne?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

            2 -> {
                binding.tvOptionTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

            3 -> {
                binding.tvOptionThird?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

            4 -> {
                binding.tvOptionFour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}