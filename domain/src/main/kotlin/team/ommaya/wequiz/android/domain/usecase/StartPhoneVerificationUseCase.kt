/*
 * Designed and developed by "옴마야" Team 2023.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/mash-up-kr/WeQuiz-Android/blob/main/LICENSE
 */

package team.ommaya.wequiz.android.domain.usecase

import android.app.Activity
import team.ommaya.wequiz.android.domain.repository.FirebaseAuthRepository
import javax.inject.Inject

class StartPhoneVerificationUseCase @Inject constructor(
    private val firebaseAuthRepository: FirebaseAuthRepository,
) {
    suspend operator fun invoke(phoneNumber: String, activity: Activity) =
        firebaseAuthRepository.startPhoneNumberVerification(phoneNumber, activity)
}