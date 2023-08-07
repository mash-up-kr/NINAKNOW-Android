/*
 * Designed and developed by "옴마야" Team 2023.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/mash-up-kr/WeQuiz-Android/blob/main/LICENSE
 */

package team.ommaya.wequiz.android.domain.usecase.intro

import team.ommaya.wequiz.android.domain.AuthCallbacksListener
import team.ommaya.wequiz.android.domain.repository.FirebaseRepository
import team.ommaya.wequiz.android.domain.runSuspendCatching
import javax.inject.Inject

class SetAuthCallbacksUseCase @Inject constructor(
    private val firebaseRepository: FirebaseRepository,
) {
    operator fun invoke(listener: AuthCallbacksListener) =
        runSuspendCatching {
            firebaseRepository.setFirebaseAuthCallbacksListener(listener)
        }
}
