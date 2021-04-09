package com.ellfors.common.entity

import com.ellfors.common.base.BaseEvent

/**
 * SampleEvent
 * 2021-03-29 10:08
 */
data class SampleEvent(
    var age: Int? = 0,
    var value: String? = ""
) : BaseEvent {
    override val getType: Int
        get() = BaseEvent.EVENT_PAGE_A
}