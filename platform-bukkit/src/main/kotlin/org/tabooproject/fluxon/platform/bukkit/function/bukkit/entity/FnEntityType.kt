package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.World
import org.bukkit.entity.EntityType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns


@Requires(classes = ["org.bukkit.entity.EntityType"])
@PlatformSide(Platform.BUKKIT)
object FnEntityType {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityType::class.java)
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("ordinal", returnsObject().noParams()) { it.setReturnRef(it.target?.ordinal) }
                .function("entityName", returnsObject().noParams()) { it.setReturnRef(it.target?.getName()) }
                .function("key", returnsObject().noParams()) { it.setReturnRef(it.target?.key) }
                .function("typeId", returnsObject().noParams()) { it.setReturnRef(it.target?.typeId) }
                // static
                .function("fromName", returnsObject().params(Type.OBJECT)) { it.setReturnRef(EntityType.fromName(it.getString(0))) }
                // static
                .function("fromId", returnsObject().params(Type.OBJECT)) { it.setReturnRef(EntityType.fromId(it.getInt(0).toInt())) }
                .function("isSpawnable", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isSpawnable) }
                .function("isAlive", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isAlive) }
                .function("translationKey", returnsObject().noParams()) { it.setReturnRef(it.target?.translationKey) }
                .function("isEnabledByFeature", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.isEnabledByFeature(it.getRef(0) as World)) }
        }
    }
}
