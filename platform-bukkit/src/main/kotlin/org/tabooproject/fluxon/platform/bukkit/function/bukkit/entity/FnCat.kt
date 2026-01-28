package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.DyeColor
import org.bukkit.entity.Cat
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Cat"])
@PlatformSide(Platform.BUKKIT)
object FnCat {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Cat::class.java)
                .function("catType", returnsObject().noParams()) { it.target?.catType }
                .function("setCatType", returnsObject().params(Type.OBJECT)) { it.target?.setCatType(it.getRef(0) as Cat.Type) }
                .function("collarColor", returnsObject().noParams()) { it.target?.collarColor }
                .function("setCollarColor", returnsObject().params(Type.OBJECT)) { it.target?.setCollarColor(it.getRef(0) as DyeColor) }
        }
    }
}

@Requires(classes = ["org.bukkit.entity.Cat.Type"])
@PlatformSide(Platform.BUKKIT)
object FnCatType {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Cat.Type::class.java)
                .function("key", returnsObject().noParams()) { it.target?.key }
        }
    }
}
