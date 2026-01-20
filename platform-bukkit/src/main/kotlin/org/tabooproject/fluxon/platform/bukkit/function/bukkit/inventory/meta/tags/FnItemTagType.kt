package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.tags

import org.bukkit.inventory.meta.tags.ItemTagAdapterContext
import org.bukkit.inventory.meta.tags.ItemTagType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnItemTagType {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ItemTagType::class.java)
                .function("primitiveType", listOf(0, 2)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.primitiveType
                    } else {
                        (it.target as? ItemTagType.PrimitiveTagType<Any>)?.fromPrimitive(
                            it.getArgument(0)!!,
                            it.getArgument(1) as ItemTagAdapterContext
                        )
                    }
                }
                .function("complexType", 0) { it.target?.complexType }
                .function(
                    "toPrimitive",
                    2
                ) {
                    (it.target as? ItemTagType.PrimitiveTagType<Any>)?.toPrimitive(
                        it.getArgument(0)!!,
                        it.getArgument(1) as ItemTagAdapterContext
                    )
                }

            registerExtension(ItemTagType.PrimitiveTagType::class.java)
                .function("primitiveType", listOf(0, 2)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.primitiveType
                    } else {
                        (it.target as? ItemTagType.PrimitiveTagType<Any>)?.fromPrimitive(
                            it.getArgument(0)!!,
                            it.getArgument(1) as ItemTagAdapterContext
                        )
                    }
                }
                .function("complexType", 0) { it.target?.complexType }
                .function(
                    "toPrimitive",
                    2
                ) {
                    (it.target as? ItemTagType.PrimitiveTagType<Any>)?.toPrimitive(
                        it.getArgument(0)!!,
                        it.getArgument(1) as ItemTagAdapterContext
                    )
                }
        }
    }
}
