package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Ocelot
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Ocelot"])
@PlatformSide(Platform.BUKKIT)
object FnOcelot {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Ocelot::class.java)
                .function("isTrusting", returns(Type.Z).noParams()) { it.target?.isTrusting }
                .function("setTrusting", returnsObject().params(Type.OBJECT)) { it.target?.setTrusting(it.getBool(0)) }
                .function("catType", returnsObject().noParams()) { it.target?.catType }
                .function("setCatType", returnsObject().params(Type.OBJECT)) { it.target?.setCatType(it.getRef(0) as Ocelot.Type) }
        }
    }
}

@Requires(classes = ["org.bukkit.entity.Ocelot.Type"])
@PlatformSide(Platform.BUKKIT)
object FnOcelotType {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Ocelot.Type::class.java)
                .function("id", returnsObject().noParams()) { it.target?.id }
                // static
                .function("getType", returnsObject().params(Type.OBJECT)) { Ocelot.Type.getType(it.getInt(0).toInt()) }
        }
    }
}
