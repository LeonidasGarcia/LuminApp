package com.luminteam.lumin.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.luminteam.lumin.data.repository.LoginRepository
import com.luminteam.lumin.services.luminapi.dto.AnswerRequest
import com.luminteam.lumin.services.luminapi.dto.CompleteTheCodeAnswerRequest
import com.luminteam.lumin.services.luminapi.dto.CompleteTheCodeResponse
import com.luminteam.lumin.services.luminapi.dto.ContextData
import com.luminteam.lumin.services.luminapi.dto.ContextDataRequest
import com.luminteam.lumin.services.luminapi.dto.DailyPracticeResultsRequest
import com.luminteam.lumin.services.luminapi.dto.FixTheCodeAnswerRequest
import com.luminteam.lumin.services.luminapi.dto.FixTheCodeResponse
import com.luminteam.lumin.services.luminapi.dto.FreeResponseAnswerRequest
import com.luminteam.lumin.services.luminapi.dto.FreeResponseResponse
import com.luminteam.lumin.services.luminapi.dto.PracticeResponse
import com.luminteam.lumin.services.luminapi.dto.QuestionResponse
import com.luminteam.lumin.services.luminapi.dto.SingleSelectionAnswerRequest
import com.luminteam.lumin.services.luminapi.dto.SingleSelectionResponse
import com.luminteam.lumin.services.luminapi.dto.UserData
import com.luminteam.lumin.services.luminapi.dto.PracticeResultsRequest
import com.luminteam.lumin.services.luminapi.dto.UserDataDailyPractice
import com.luminteam.lumin.services.luminapi.repositories.aIRepository
import com.luminteam.lumin.ui.domain.CurrentContentUiState
import com.luminteam.lumin.ui.screens.learn.practice.domain.CompleteTheCodeAnswer
import com.luminteam.lumin.ui.screens.learn.practice.domain.CompleteTheCodeQuestion
import com.luminteam.lumin.ui.screens.learn.practice.domain.FixTheCodeAnswer
import com.luminteam.lumin.ui.screens.learn.practice.domain.FixTheCodeQuestion
import com.luminteam.lumin.ui.screens.learn.practice.domain.FreeResponseAnswer
import com.luminteam.lumin.ui.screens.learn.practice.domain.FreeResponseQuestion
import com.luminteam.lumin.ui.screens.learn.practice.domain.Indent
import com.luminteam.lumin.ui.screens.learn.practice.domain.Line
import com.luminteam.lumin.ui.screens.learn.practice.domain.Missing
import com.luminteam.lumin.ui.screens.learn.practice.domain.Question
import com.luminteam.lumin.ui.screens.learn.practice.domain.QuestionsResultsUiState
import com.luminteam.lumin.ui.screens.learn.practice.domain.QuestionsUiState
import com.luminteam.lumin.ui.screens.learn.practice.domain.ResultType
import com.luminteam.lumin.ui.screens.learn.practice.domain.SingleSelectionAnswer
import com.luminteam.lumin.ui.screens.learn.practice.domain.SingleSelectionQuestion
import com.luminteam.lumin.ui.screens.learn.practice.domain.Token
import com.luminteam.lumin.ui.screens.learn.practice.domain.Word
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

val hiperLongQuestion =
    "Lorem ipsum dolor sit amet, ct, sed do eiu laboris nisi ut aliquip ex ea  commodo consequat. Duis aute irure dolor in reprehenderit in voluptate  velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint  occaecat cupidatat non proident, sunt in culpa qui officia deserunt  mollit anim id est labor Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod  tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim  veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea  commodo consequat. Duis aute irure dolor in reprehenderit in voluptate  velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint  occaecat cupidatat non proident, sunt in culpa qui officia deserunt  mollit anim id est labor Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod  tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim  veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea  commodo consequat. Duis aute irure dolor in reprehenderit in voluptate  velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint  occaecat cupidatat non proident, sunt in culpa qui officia deserunt  mollit anim id est labor Lorem ipsum dolor sit amet, ct, sed do eiu laboris nisi ut aliquip ex ea  commodo consequat. Duis aute irure dolor in reprehenderit in voluptate  velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint  occaecat cupidatat non proident, sunt in culpa qui officia deserunt  mollit anim id est labor Lorem ipsum dolor sit amet, consectetur adipiscingaute irure dolor in reprehenderit in voluptate  velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint  occaecat cupidatat non proident, sunt in culpa qui officia deserunt  mollit anim id est labor Lorem ipsum dolor sit amet, consectetur adipiscingaute irure dolor in reprehenderit in voluptate  velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint  occaecat cupidatat non proident, sunt in culpa qui officia deserunt  mollit anim id est labor Lorem ipsum dolor sit amet, consectetur adipiscingaute irure dolor in reprehenderit in voluptate  velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint  occaecat cupidatat non proident, sunt in culpa qui officia deserunt  mollit anim id est labor Lorem ipsum dolor sit amet, consectetur adipiscing"

val wrongCode = """def hola_mundo():
    print(“hola mundo”)

    hola_mund()
""".trimIndent()

class LevelNavigationViewModel(
    private val loginRepository: LoginRepository
) : ViewModel() {
    private val _practiceResponseState = MutableStateFlow(PracticeResponse(questions = listOf()))
    val practiceResponseState: StateFlow<PracticeResponse> = _practiceResponseState.asStateFlow()

    private val _currentAppContentState = MutableStateFlow(CurrentContentUiState())
    val currentAppContentState: StateFlow<CurrentContentUiState> =
        _currentAppContentState.asStateFlow()

    // estas preguntas se deben solicitar cuando se accede a la práctica!!! solicitda desde el backend de lumin
    private val _questionsUiState = MutableStateFlow(QuestionsUiState())
    val questionsUiState: StateFlow<QuestionsUiState> = _questionsUiState.asStateFlow()

    private val _questionsResultsUiState = MutableStateFlow(QuestionsResultsUiState())
    val questionsResultsUiState: StateFlow<QuestionsResultsUiState> =
        _questionsResultsUiState.asStateFlow()

    fun resetPractice() {
        _questionsUiState.update {
            QuestionsUiState()
        }

        _practiceResponseState.update {
            PracticeResponse(questions = listOf())
        }
    }

    fun resetPracticeResults() {
        _questionsResultsUiState.update {
            QuestionsResultsUiState()
        }
    }

    fun updateCurrentAppContentState(currentContentUiState: CurrentContentUiState) {
        _currentAppContentState.update {
            currentContentUiState
        }
    }

    private fun idOnBounds(questionId: Int): Boolean {
        val questions = questionsUiState.value.questions
        return !(questions.isEmpty() || questionId >= questions.size || questionId < 0)
    }

    fun getQuestionAnswers(): List<AnswerRequest> {
        return questionsUiState.value.questions.map { question ->
            val answer = question.answer

            return@map when (answer) {
                is SingleSelectionAnswer ->
                    SingleSelectionAnswerRequest(
                        questionId = question.id,
                        selection = answer.selection!!
                    )

                is FreeResponseAnswer ->
                    FreeResponseAnswerRequest(
                        questionId = question.id,
                        answer = answer.answer
                    )

                is FixTheCodeAnswer ->
                    FixTheCodeAnswerRequest(
                        questionId = question.id,
                        answer = answer.correctedCode
                    )

                is CompleteTheCodeAnswer ->
                    CompleteTheCodeAnswerRequest(
                        questionId = question.id,
                        orderedTokens = answer.orderedTokens.map { it!! }
                    )

                else -> throw Exception("Invalid answer type")
            }
        }
    }

    fun updateSingleSelectionAnswer(questionId: Int, selection: String?) {
        if (!idOnBounds(questionId)) return
        val questions = questionsUiState.value.questions
        val question = questions[questionId]
        if (question is SingleSelectionQuestion) {
            val castedQuestion = question as SingleSelectionQuestion

            val newAnswer = castedQuestion.answer.copy(
                selection = selection
            )

            val newQuestion = castedQuestion.copy(
                answered = true,
                answer = newAnswer
            )

            val newQuestions = questions.toMutableList().apply {
                this[questionId] = newQuestion
            }.toList()

            _questionsUiState.update {
                it.copy(
                    questions = newQuestions
                )
            }
        }
    }

    fun updateFreeResponseAnswer(questionId: Int, answer: String) {
        if (!idOnBounds(questionId)) return
        val questions = questionsUiState.value.questions
        val question = questions[questionId]
        if (question is FreeResponseQuestion) {
            val castedQuestion = question as FreeResponseQuestion

            val newAnswer = castedQuestion.answer.copy(
                answer = answer
            )

            val newQuestion = castedQuestion.copy(
                answered = answer.trim() != "",
                answer = newAnswer
            )

            val newQuestions = questions.toMutableList().apply {
                this[questionId] = newQuestion
            }.toList()

            _questionsUiState.update {
                it.copy(
                    questions = newQuestions
                )
            }
        }
    }

    fun updateFixTheCodeAnswer(questionId: Int, correctedCode: String) {
        if (!idOnBounds(questionId)) return
        val questions = questionsUiState.value.questions
        val question = questions[questionId]
        if (question is FixTheCodeQuestion) {
            val castedQuestion = question as FixTheCodeQuestion

            val newAnswer = castedQuestion.answer.copy(
                correctedCode = correctedCode
            )

            val newQuestion = castedQuestion.copy(
                answered = correctedCode != wrongCode,
                answer = newAnswer
            )

            val newQuestions = questions.toMutableList().apply {
                this[questionId] = newQuestion
            }.toList()

            _questionsUiState.update {
                it.copy(
                    questions = newQuestions
                )
            }
        }
    }

    fun updateCompleteTheCodeAnswer(
        questionId: Int,
        orderedTokens: List<String?>,
        assignedChunks: MutableMap<Int, String?>
    ) {
        if (!idOnBounds(questionId)) return
        val questions = questionsUiState.value.questions
        val question = questions[questionId]
        if (question is CompleteTheCodeQuestion) {
            val castedQuestion = question as CompleteTheCodeQuestion

            val newAnswer = castedQuestion.answer.copy(
                orderedTokens = orderedTokens,
                assignedChunks = assignedChunks
            )

            val missingTokens = castedQuestion.missingTokens
            val newQuestion = castedQuestion.copy(
                answered = missingTokens.size == orderedTokens.filterNotNull().size,
                answer = newAnswer
            )

            val newQuestions = questions.toMutableList().apply {
                this[questionId] = newQuestion
            }.toList()

            _questionsUiState.update {
                it.copy(
                    questions = newQuestions
                )
            }
        }
    }

    fun loadPractice(levelName: String, sectionName: String) {
        Log.d("Practica", "Cargando practica")
        viewModelScope.launch {
            val jwt = loginRepository.jwt.first()
            val practiceResponse = aIRepository.postPractice(
                jwt,
                ContextDataRequest(
                    contextData = ContextData(
                        sectionName = sectionName,
                        levelName = levelName
                    )
                )
            )

            _practiceResponseState.update {
                practiceResponse
            }

            val uiQuestions: List<Question> = practiceResponse.questions.map { questionResponse ->
                when (questionResponse) {
                    is SingleSelectionResponse ->
                        SingleSelectionQuestion(
                            id = questionResponse.id,
                            question = questionResponse.question,
                            options = questionResponse.options
                        )

                    is FreeResponseResponse ->
                        FreeResponseQuestion(
                            id = questionResponse.id,
                            question = questionResponse.question,
                        )

                    is FixTheCodeResponse ->
                        FixTheCodeQuestion(
                            id = questionResponse.id,
                            wrongCode = questionResponse.wrongCode
                        )

                    is CompleteTheCodeResponse ->
                        CompleteTheCodeQuestion(
                            id = questionResponse.id,
                            codeLines = questionResponse.codeLines.map { lineResponse ->
                                Line(tokens = lineResponse.tokens.map { tokenResponse ->
                                    val token = tokenResponse.token
                                    when (token) {
                                        "INDENT" -> Indent
                                        "MISSING" -> Missing
                                        else -> Word(
                                            token = token
                                        )
                                    }
                                })
                            },
                            missingTokens = questionResponse.missingTokens
                        )
                }
            }

            _questionsUiState.update {
                it.copy(questions = uiQuestions)
            }
        }
    }

    fun loadDailyPractice() {
        Log.d("Practica Diaria", "Cargando practica diaria")
        viewModelScope.launch {
            val jwt = loginRepository.jwt.first()
            val practiceResponse = aIRepository.postDailyPractice(jwt = jwt)

            _practiceResponseState.update {
                practiceResponse
            }

            val uiQuestions: List<Question> = practiceResponse.questions.map { questionResponse ->
                when (questionResponse) {
                    is SingleSelectionResponse ->
                        SingleSelectionQuestion(
                            id = questionResponse.id,
                            question = questionResponse.question,
                            options = questionResponse.options
                        )

                    is FreeResponseResponse ->
                        FreeResponseQuestion(
                            id = questionResponse.id,
                            question = questionResponse.question,
                        )

                    is FixTheCodeResponse ->
                        FixTheCodeQuestion(
                            id = questionResponse.id,
                            wrongCode = questionResponse.wrongCode
                        )

                    is CompleteTheCodeResponse ->
                        CompleteTheCodeQuestion(
                            id = questionResponse.id,
                            codeLines = questionResponse.codeLines.map { lineResponse ->
                                Line(tokens = lineResponse.tokens.map { tokenResponse ->
                                    val token = tokenResponse.token
                                    when (token) {
                                        "INDENT" -> Indent
                                        "MISSING" -> Missing
                                        else -> Word(
                                            token = token
                                        )
                                    }
                                })
                            },
                            missingTokens = questionResponse.missingTokens
                        )
                }
            }

            _questionsUiState.update {
                it.copy(questions = uiQuestions)
            }
        }
    }

    fun loadDailyPracticeResults(sectionId: Int) {
        val questions: List<QuestionResponse> = practiceResponseState.value.questions
        val answers: List<AnswerRequest> = getQuestionAnswers()
        val userData = UserDataDailyPractice(sectionId = sectionId)

        viewModelScope.launch {
            val jwt = loginRepository.jwt.first()
            val practiceResultsResponse = aIRepository.postDailyPracticeResults(
                jwt, DailyPracticeResultsRequest(
                    questions = questions,
                    answers = answers,
                    userData = userData
                )
            )

            val totalApproved = practiceResultsResponse.questionsResults.filter { it }.size

            val resultType = when {
                totalApproved < 3 -> ResultType.Disapproved
                totalApproved >= 3 && totalApproved < 5 -> ResultType.Approved
                else -> ResultType.FullyApproved
            }

            _questionsResultsUiState.update {
                it.copy(
                    questionsResults = practiceResultsResponse.questionsResults,
                    resultType = resultType,
                    score = practiceResultsResponse.score
                )
            }
        }
    }

    fun loadPracticeResults(userId: Int, sectionId: Int) {
        val questions: List<QuestionResponse> = practiceResponseState.value.questions
        val answers: List<AnswerRequest> = getQuestionAnswers()
        val userData = UserData(id = userId, sectionId = sectionId)

        viewModelScope.launch {
            val jwt = loginRepository.jwt.first()
            val practiceResultsResponse = aIRepository.postPracticeResults(
                jwt, PracticeResultsRequest(
                    questions = questions,
                    answers = answers,
                    userData = userData
                )
            )

            val totalApproved = practiceResultsResponse.questionsResults.filter { it }.size

            val resultType = when {
                totalApproved < 3 -> ResultType.Disapproved
                totalApproved >= 3 && totalApproved < 5 -> ResultType.Approved
                else -> ResultType.FullyApproved
            }

            _questionsResultsUiState.update {
                it.copy(
                    questionsResults = practiceResultsResponse.questionsResults,
                    resultType = resultType,
                    score = practiceResultsResponse.score
                )
            }
        }

    }

    companion object {
        fun provideFactory(repository: LoginRepository): ViewModelProvider.Factory =
            viewModelFactory {
                initializer {
                    LevelNavigationViewModel(repository)
                }
            }
    }
}
