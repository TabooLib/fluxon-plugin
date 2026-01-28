package org.tabooproject.fluxon.function.util

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common5.util.parseMillis
import taboolib.common5.util.parseUUID
import taboolib.module.chat.colored
import taboolib.module.chat.parseToHexColor
import taboolib.module.chat.uncolored

object ExtensionString {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(String::class.java)
                .function("parseMillis", returns(Type.J).noParams()) { it.setReturnLong(it.target!!.parseMillis()) }
                .function("parseUUID", returnsObject().noParams()) { it.setReturnRef(it.target!!.parseUUID()) }
                .function("colored", returns(Type.STRING).noParams()) { it.setReturnRef(it.target!!.colored()) }
                .function("uncolored", returns(Type.STRING).noParams()) { it.setReturnRef(it.target!!.uncolored()) }
                .function("parseToHexColor", returns(Type.STRING).noParams()) { it.setReturnRef(it.target!!.parseToHexColor()) }
        }
    }
}