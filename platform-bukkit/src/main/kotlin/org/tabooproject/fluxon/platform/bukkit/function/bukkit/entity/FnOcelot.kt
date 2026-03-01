package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Ocelot
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Ocelot"])
@PlatformSide(Platform.BUKKIT)
object FnOcelot {

    val TYPE = Type.fromClass(Ocelot::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Ocelot::class.java)
                .function("isTrusting", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isTrusting ?: false) }
                .function("setTrusting", returnsVoid().params(Type.Z)) { it.target?.setTrusting(it.getBool(0)) }
                .function("catType",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnOcelotType.TYPE).noParams()) { it.setReturnRef(it.target?.catType) }
                .function("setCatType",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnOcelotType.TYPE)) { it.target?.setCatType(it.getRef(0) as Ocelot.Type) }
        }
    }
}

@Requires(classes = ["org.bukkit.entity.Ocelot\$Type"])
@PlatformSide(Platform.BUKKIT)
object FnOcelotType : org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter<org.bukkit.entity.Ocelot.Type>() {

    override val enumClass: Class<org.bukkit.entity.Ocelot.Type> = org.bukkit.entity.Ocelot.Type::class.java


    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Ocelot.Type::class.java)
                .function("id", returns(Type.I).noParams()) { it.setReturnInt(it.target?.id ?: 0) }
                // static
                .function("getType", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnOcelotType.TYPE).params(Type.I)) { it.setReturnRef(Ocelot.Type.getType(it.getInt(0).toInt())) }
        }
    }
}
