/*
 * Designed and developed by "옴마야" Team 2023.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/mash-up-kr/WeQuiz-Android/blob/main/LICENSE
 */

package team.ommaya.wequiz.android.domain.usecase

import team.ommaya.wequiz.android.domain.repository.FirebaseAuthRepository
import javax.inject.Inject

class VerifyCodeUseCase @Inject constructor(
    private val firebaseAuthRepository: FirebaseAuthRepository,
) {
    operator fun invoke(verifyCode: String) =
        firebaseAuthRepository.verifyPhoneNumberWithCode(verifyCode)
}