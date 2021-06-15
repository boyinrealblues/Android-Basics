package com.example.fragmentandfragmentfactory

import java.lang.reflect.Member

class RemoteDataSource : BTSGetters {

    private var INSTANCE = BTSInstance.dataSet

    private var MEMBER_INSTANCE = INSTANCE.Members

    private var map  = LinkedHashMap<Int , Members>(MEMBER_INSTANCE.size)

    init{
        for(member in MEMBER_INSTANCE){
            addMember(member)
        }
    }

    private fun addMember(member : Members) {
        map.put(member.id,member)
    }

    override fun getBTS(): BTS {
        return INSTANCE
    }



    override fun getMember(id: Int): Members {
            return map[id]!!
    }

}
