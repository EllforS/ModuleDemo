package com.ellfors.common.constants

/**
 * RouterKey
 * 2021-03-25 17:22
 */
object RouterKey {

    object ModuleA {
        private const val MODULE_A = "/moduleA"

        const val EXTRA_TEST = "extra_test"

        const val PAGE_A = "$MODULE_A/page_A"
    }

    object ModuleB {
        private const val MODULE_B = "/moduleB"

        const val EXTRA_VALUE = "extra_value"

        const val FRAGMENT_B = "$MODULE_B/fragment_B"
        const val PAGE_B = "$MODULE_B/page_B"
        const val SINGLE_TYPE = "$MODULE_B/single_type"
        const val MULTI_TYPE = "$MODULE_B/multi_type"
        const val IMAGE = "$MODULE_B/image"
    }
}