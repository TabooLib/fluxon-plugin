package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.World
import org.bukkit.entity.EntityType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FnEntityType {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityType::class.java)
                // 橙汁喵: 枚举类语法
                .function("name", 0) { it.target?.name }
                // 橙汁喵: 枚举类语法
                .function("ordinal", 0) { it.target?.ordinal }
                .function("entityName", 0) { it.target?.getName() }
                // 橙汁喵: 自定义语法, 这个语法并不在Bukkit中存在
                .function("namespacedKey", 0) { it.target?.key }
                .function("key", 0) { it.target?.key }
                .function("typeId", 0) { it.target?.typeId }
                // static
                .function("fromName", 1) { EntityType.fromName(it.getString(0)) }
                // static
                .function("fromId", 1) { EntityType.fromId(it.getNumber(0).toInt()) }
                .function("isSpawnable", 0) { it.target?.isSpawnable }
                .function("isAlive", 0) { it.target?.isAlive }
                .function("translationKey", 0) { it.target?.translationKey }
                .function("isEnabledByFeature", 1) { it.target?.isEnabledByFeature(it.getArgument(0) as World) }
        }
    }
}
