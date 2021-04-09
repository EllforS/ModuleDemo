package com.ellfors.common.base

/**
 * BaseEvent
 * 2021-04-09 09:33
 */
interface BaseEvent {
    val getType: Int

    companion object {
        const val EVENT_NOTHING = -1
        const val EVENT_PAGE_A = 1
    }
}