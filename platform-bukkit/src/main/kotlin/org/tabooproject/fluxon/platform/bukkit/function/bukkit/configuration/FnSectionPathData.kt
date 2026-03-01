package org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.configuration.SectionPathData"])
@PlatformSide(Platform.BUKKIT)
object FnSectionPathData {

    private val clazz = Class.forName("org.bukkit.configuration.SectionPathData")


    val TYPE = Type.fromClass(clazz)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(clazz)
                // .function("getData", returns(Type.OBJECT).noParams()) { it.setReturnRef(it.target?.getData()) }
                // .function("setData", returnsVoid().params(Type.OBJECT)) { it.target?.setData(it.getRef(0) as java.lang.Object) }
                // .function("getComments", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.getComments()) }
                // .function("setComments", returnsVoid().params(Type.LIST)) { it.target?.setComments(it.getRef(0) as java.util.List) }
                // .function("getInlineComments", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.getInlineComments()) }
                // .function("setInlineComments", returnsVoid().params(Type.LIST)) { it.target?.setInlineComments(it.getRef(0) as java.util.List) }
        }
    }
}
