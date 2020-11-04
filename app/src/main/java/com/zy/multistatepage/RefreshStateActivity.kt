package com.zy.multistatepage

import androidx.lifecycle.lifecycleScope
import com.zy.multistatepage.base.BaseActivity
import com.zy.multistatepage.databinding.ActivityRefreshStateBinding
import com.zy.multistatepage.state.ErrorState
import com.zy.multistatepage.state.LoadingState
import kotlinx.coroutines.delay

class RefreshStateActivity : BaseActivity<ActivityRefreshStateBinding>() {
    private var count = 0
    override fun initPage() {

        val multiStateActivityRoot = bindMultiState {
            lifecycleScope.launchWhenCreated {
                it.show<LoadingState>()
                delay(2000)
                it.show<ErrorState> {
                    it.setErrorMsg("鸡你太美 ${++count}")
                    it.setErrorIcon(R.mipmap.jntm)
                }

            }
        }
        lifecycleScope.launchWhenCreated {
            multiStateActivityRoot.show<LoadingState>()
            delay(2000)
            multiStateActivityRoot.show<ErrorState>()
        }
    }

}