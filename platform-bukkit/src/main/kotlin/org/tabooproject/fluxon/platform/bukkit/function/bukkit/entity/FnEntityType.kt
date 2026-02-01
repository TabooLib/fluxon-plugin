package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.World
import org.bukkit.entity.EntityType
import org.tabooproject.fluxon.function.FnEnumGetter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.library.xseries.XEntityType
import kotlin.jvm.optionals.getOrNull


@Requires(classes = ["org.bukkit.entity.EntityType"])
@PlatformSide(Platform.BUKKIT)
object FnEntityType : FnEnumGetter<EntityType>() {

    override val enumClass: Class<EntityType> = EntityType::class.java

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityType::class.java)
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("ordinal", returns(Type.I).noParams()) { it.setReturnInt(it.target?.ordinal ?: 0) }
                .function("entityName", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.getName()) }
                .function("key", returnsObject().noParams()) { it.setReturnRef(it.target?.key) }
                .function("typeId", returns(Type.I).noParams()) { it.setReturnInt(it.target?.typeId?.toInt() ?: 0) }
                // static
                .function("fromName", returnsObject().params(Type.STRING)) { it.setReturnRef(EntityType.fromName(it.getString(0))) }
                // static
                .function("fromId", returnsObject().params(Type.I)) { it.setReturnRef(EntityType.fromId(it.getInt(0))) }
                .function("isSpawnable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSpawnable ?: false) }
                .function("isAlive", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isAlive ?: false) }
                .function("translationKey", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.translationKey) }
                .function("isEnabledByFeature", returns(Type.Z).params(Type.OBJECT)) { it.setReturnBool(it.target?.isEnabledByFeature(it.getRef(0) as World) ?: false) }
        }
    }

    override fun enumValue(value: String): EntityType? {
        return XEntityType.of(value).getOrNull()?.get()
    }
}
