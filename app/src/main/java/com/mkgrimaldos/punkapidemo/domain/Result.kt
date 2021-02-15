package com.mkgrimaldos.punkapidemo.domain

import androidx.lifecycle.LiveData
import androidx.paging.PagedList

data class Result<T>(val data: LiveData<PagedList<T>>, val error: LiveData<String>)
