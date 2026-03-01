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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Cat"])
@PlatformSide(Platform.BUKKIT)
object FnCat {

    val TYPE = Type.fromClass(Cat::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Cat::class.java)
                .function("catType",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnCatType.TYPE).noParams()) { it.setReturnRef(it.target?.catType) }
                .function("setCatType",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnCatType.TYPE)) { it.target?.setCatType(it.getRef(0) as Cat.Type) }
                .function("collarColor",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnDyeColor.TYPE).noParams()) { it.setReturnRef(it.target?.collarColor) }
                .function("setCollarColor",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnDyeColor.TYPE)) { it.target?.setCollarColor(it.getRef(0) as DyeColor) }
        }
    }
}

@Requires(classes = ["org.bukkit.entity.Cat\$Type"])
@PlatformSide(Platform.BUKKIT)
object FnCatType {

    val TYPE = Type.fromClass(Cat.Type::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Cat.Type::class.java)
                .function("key", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE).noParams()) { it.setReturnRef(it.target?.key) }
        }
    }
}
