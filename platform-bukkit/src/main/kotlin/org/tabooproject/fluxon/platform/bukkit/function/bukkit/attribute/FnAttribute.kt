package org.tabooproject.fluxon.platform.bukkit.function.bukkit.attribute

import org.bukkit.attribute.Attribute
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import taboolib.library.xseries.XAttribute
import kotlin.jvm.optionals.getOrNull

@Requires(classes = ["org.bukkit.attribute.Attribute"])
@PlatformSide(Platform.BUKKIT)
object FnAttribute {

    val TYPE = Type.fromClass(Attribute::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerFunction("attribute", returns(FnAttributable.TYPE).params(Type.STRING)) {
                it.setReturnRef(XAttribute.of(it.getString(0)).getOrNull()?.get())
            }
        }
    }
}
