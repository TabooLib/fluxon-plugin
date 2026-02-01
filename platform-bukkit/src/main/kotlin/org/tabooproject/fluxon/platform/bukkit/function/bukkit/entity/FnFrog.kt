package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Entity
import org.bukkit.entity.Frog
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Frog"])
@PlatformSide(Platform.BUKKIT)
object FnFrog {

    val TYPE = Type.fromClass(Frog::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Frog::class.java)
                .function("tongueTarget", returnsObject().noParams()) { it.setReturnRef(it.target?.tongueTarget) }
                .function("setTongueTarget", returnsVoid().params(Type.OBJECT)) { it.target?.setTongueTarget(it.getRef(0) as Entity) }
                .function("variant", returnsObject().noParams()) { it.setReturnRef(it.target?.variant) }
                .function("setVariant", returnsVoid().params(Type.OBJECT)) { it.target?.setVariant(it.getRef(0) as Frog.Variant) }
        }
    }
}

@Requires(classes = ["org.bukkit.entity.Frog.Variant"])
@PlatformSide(Platform.BUKKIT)
object FnFrogVariant {

    val TYPE = Type.fromClass(Frog.Variant::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Frog.Variant::class.java)
                .function("key", returnsObject().noParams()) { it.setReturnRef(it.target?.key) }
        }
    }
}
