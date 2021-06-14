package com.example.fragmentandfragmentfactory

class RemoteDataSource : BTSGetters {

    private var INSTANCE = BTSInstance.dataSet

    override fun getBTS(): BTS {
        return INSTANCE
    }

}
