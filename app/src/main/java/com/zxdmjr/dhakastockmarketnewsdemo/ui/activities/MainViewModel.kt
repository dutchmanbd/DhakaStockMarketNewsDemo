package com.zxdmjr.dhakastockmarketnewsdemo.ui.activities

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.zxdmjr.dhakastockmarketnewsdemo.data.repositories.NewsRepository
import com.zxdmjr.dhakastockmarketnewsdemo.internal.Constant
import com.zxdmjr.material_utils.Resource

class MainViewModel @ViewModelInject constructor(
    private val repository: NewsRepository
) : ViewModel() {

    fun getNews() = liveData {
        emit(Resource.Loading())
        emit(repository.getNews(Constant.PAGE))
    }

}